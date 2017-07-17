package com.baoquan.shuxin.service.aop;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.baoquan.shuxin.dao.product.ProductBillingDao;
import com.baoquan.shuxin.dao.user.UserDao;
import com.baoquan.shuxin.dao.user.UserDiscountDao;
import com.baoquan.shuxin.dao.user.UserMoneyChangeDao;
import com.baoquan.shuxin.dao.user.UserMoneyLogDao;
import com.baoquan.shuxin.dao.user.UserProductUsageDao;
import com.baoquan.shuxin.enums.BillingMethodEnum;
import com.baoquan.shuxin.enums.ProductUseTypeEnum;
import com.baoquan.shuxin.enums.UserMoneyExchangeStatusEnum;
import com.baoquan.shuxin.enums.UserMoneyExchangeTypeEnum;
import com.baoquan.shuxin.exception.billing.InsufficientBalanceException;
import com.baoquan.shuxin.exception.billing.InvalidPackageException;
import com.baoquan.shuxin.model.product.ProductBilling;
import com.baoquan.shuxin.model.user.User;
import com.baoquan.shuxin.model.user.UserDiscount;
import com.baoquan.shuxin.model.user.UserMoneyChange;
import com.baoquan.shuxin.model.user.UserMoneyLog;
import com.baoquan.shuxin.model.user.UserProductUsage;

/**
 * Desc:
 * Created by yongj on 7/11/2017,
 */
@Named
public class ProductChargingService {
    private final static Logger logger = LoggerFactory.getLogger(ProductChargingService.class);

    @Inject
    private UserProductUsageDao userProductUsageDao;
    @Inject
    private ProductBillingDao productBillingDao;
    @Inject
    private UserDao userDao;
    @Inject
    private UserMoneyLogDao userMoneyLogDao;
    @Inject
    private UserMoneyChangeDao userMoneyChangeDao;
    @Inject
    private UserDiscountDao userDiscountDao;

    @Transactional
    public void charge(Long userId, Long productId, Integer type) {
        UserProductUsage userProductUsage = findUserProductUsage(userId, productId);
        //包年未到期
        if (userProductUsage.getEnd() >= System.currentTimeMillis() / 1000) {
            //increase total
            int rows = userProductUsageDao.increaseTotal(userProductUsage.getId());
            if (rows > 0) return;
        }
        //有剩余次数
        if (userProductUsage.getRemain() > 0) {
            //decrease remain & increase total
            int rows = userProductUsageDao.decreaseRemain(userProductUsage.getId());
            if (rows > 0) return;
        }
        //普通调用类型，只进行余量扣减，不进行单次计费调用
        if (Objects.equals(type, ProductUseTypeEnum.Normal.getCode())) {
            throw new InvalidPackageException();
        }
        //单次调用计费
        singleCharge(userId, productId, userProductUsage.getId());
    }

    private void singleCharge(Long userId, Long productId, Long userProductUsageId) {
        //单次调用计费
        ProductBilling productBilling = productBillingDao.queryByMethod(productId, BillingMethodEnum.COUNT.getCode());
        Assert.notNull(productBilling, "每个产品必须都有按次计费规则");
        User user = userDao.queryUserBalance(userId);
        UserDiscount userDiscount = userDiscountDao.selectByUserId(userId);
        BigDecimal discount = userDiscount != null ? userDiscount.getDiscount().divide(BigDecimal.valueOf(100), 2,
                BigDecimal.ROUND_HALF_EVEN) : BigDecimal.ONE;
        logger.info("user balance:{}, product price:{}, discount:{}", user.getMoneyBalance(), productBilling.getPrice(),
                discount);
        BigDecimal amount = productBilling.getPrice().multiply(discount);
        if (user.getMoneyBalance().doubleValue() < amount.doubleValue()) {
            throw new InsufficientBalanceException();
        }
        //increase extra & total, deduct user balance/money
        int rows = userProductUsageDao.increaseExtra(userProductUsageId);
        Assert.isTrue(rows > 0, "增加套餐外调用次数失败");
        rows = userDao.deductUserBalance(userId, amount);
        if (rows == 0) {
            throw new InsufficientBalanceException();
        }
        UserMoneyLog userMoneyLog = buildUserMoneyLog(user, amount);
        rows = userMoneyLogDao.insertSelective(userMoneyLog);
        Assert.isTrue(rows > 0, "增加用户资金记录失败");

        UserMoneyChange userMoneyChange = buildUserMoneyChange(user, amount);
        rows = userMoneyChangeDao.insertSelective(userMoneyChange);
        Assert.isTrue(rows > 0, "增加用户资金变动记录失败");
    }

    private UserMoneyChange buildUserMoneyChange(User user, BigDecimal amount) {
        UserMoneyChange userMoneyChange = new UserMoneyChange();
        userMoneyChange.setUserId(user.getId());
        userMoneyChange.setPayment("");
        userMoneyChange.setAmount(amount);
        userMoneyChange.setBalanceOld(user.getMoneyBalance());
        userMoneyChange.setBalanceNew(userMoneyChange.getBalanceOld().subtract(userMoneyChange.getAmount()));
        userMoneyChange.setDateline(System.currentTimeMillis() / 1000);
        return userMoneyChange;
    }

    private UserMoneyLog buildUserMoneyLog(User user, BigDecimal amount) {
        UserMoneyLog userMoneyLog = new UserMoneyLog();
        userMoneyLog.setUserId(user.getId());
        userMoneyLog.setType(UserMoneyExchangeTypeEnum.CONSUME.getCode());
        userMoneyLog.setAmount(amount);
        userMoneyLog.setRemark("");
        userMoneyLog.setItemInfo("");
        userMoneyLog.setStatus(UserMoneyExchangeStatusEnum.SUCCEED.getCode());
        userMoneyLog.setRequestNo(UUID.randomUUID().toString());
        userMoneyLog.setDateline(System.currentTimeMillis() / 1000);
        userMoneyLog.setStatusDesc(UserMoneyExchangeStatusEnum.SUCCEED.getDesc());
        userMoneyLog.setFinishTime(userMoneyLog.getDateline());
        return userMoneyLog;
    }

    /**
     * 查找用户产品使用记录，不存在则新建一条记录
     * @param userId
     * @param productId
     * @return
     */
    private UserProductUsage findUserProductUsage(Long userId, Long productId) {
        UserProductUsage userProductUsage = userProductUsageDao.selectByUserProduct(userId, productId);
        if (userProductUsage == null) {
            initUserProductUsage(userId, productId);
            userProductUsage = userProductUsageDao.selectByUserProduct(userId, productId);
        }
        //这里如果userProductUsage还为null就完蛋了
        return userProductUsage;
    }

    /**
     * 初始化用户的产品使用记录
     * @param userId
     * @param productId
     * @return 返回影响行数
     */
    private int initUserProductUsage(Long userId, Long productId) {
        UserProductUsage userProductUsage = new UserProductUsage();
        userProductUsage.setUserId(userId);
        userProductUsage.setProductId(productId);
        userProductUsage.setStart(0L);
        userProductUsage.setEnd(0L);
        userProductUsage.setRemain(0L);
        userProductUsage.setTotal(0L);
        userProductUsage.setExtra(0L);
        return userProductUsageDao.insertIgnore(userProductUsage);
    }
}
