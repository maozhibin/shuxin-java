package com.baoquan.shuxin.service.aop;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.baoquan.shuxin.dao.product.ProductBillingsDao;
import com.baoquan.shuxin.dao.product.ProductInterfaceDao;
import com.baoquan.shuxin.dao.user.UserDao;
import com.baoquan.shuxin.dao.user.UserDiscountDao;
import com.baoquan.shuxin.dao.user.UserMoneyChangeDao;
import com.baoquan.shuxin.dao.user.UserMoneyLogDao;
import com.baoquan.shuxin.dao.user.UserProductUsageDao;
import com.baoquan.shuxin.enums.BillingTypeEnum;
import com.baoquan.shuxin.enums.FreeEnum;
import com.baoquan.shuxin.enums.ProductUseTypeEnum;
import com.baoquan.shuxin.enums.UserMoneyExchangeStatusEnum;
import com.baoquan.shuxin.enums.UserMoneyExchangeTypeEnum;
import com.baoquan.shuxin.exception.billing.InsufficientBalanceException;
import com.baoquan.shuxin.exception.billing.InvalidPackageException;
import com.baoquan.shuxin.model.product.ProductBillings;
import com.baoquan.shuxin.model.product.ProductInterface;
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
    private ProductInterfaceDao productInterfaceDao;
    @Inject
    private UserProductUsageDao userProductUsageDao;
    @Inject
    private ProductBillingsDao productBillingsDao;
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

        ProductInterface productInterface = productInterfaceDao.queryByProductId(productId);
        //如果是免费的，做一下调用记录即可
        if (Objects.equals(productInterface.getFree(), FreeEnum.YES.getCode())) {
            logger.info("ProductInterface is free for use!");
            //throw new UnsupportedOperationException("不支持免费产品！");
            return;
        }

        UserProductUsage userProductUsage = findUserProductUsage(userId, productId);
        //包年未到期
        if (userProductUsage.getTimeEnd() >= System.currentTimeMillis() / 1000) {
            //increase time_used
            int rows = userProductUsageDao.increaseTimeUsed(userProductUsage.getId());
            if (rows > 0) return;
        }
        //有剩余次数
        if (userProductUsage.getCountRemain() > 0) {
            //decrease count_remain & increase count_used
            int rows = userProductUsageDao.decreaseCountRemain(userProductUsage.getId());
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
        List<ProductBillings> productBillingsList = productBillingsDao.queryByType(productId,
                BillingTypeEnum.COUNT.getCode());
        ProductBillings productBillings = null;
        if (productBillingsList != null) {
            for (ProductBillings billings : productBillingsList) {
                if (billings.getNum() == 1) {//找到单次的套餐
                    productBillings = billings;
                    break;
                }
            }
        }
        Assert.notNull(productBillings, "每个产品必须都有按次计费规则");
        User user = userDao.queryUserBalance(userId);
        UserDiscount userDiscount = userDiscountDao.selectByUserId(userId);
        BigDecimal discount = userDiscount != null ? userDiscount.getDiscount().divide(BigDecimal.valueOf(100), 2,
                BigDecimal.ROUND_HALF_EVEN) : BigDecimal.ONE;
        logger.info("user balance:{}, product price:{}, discount:{}", user.getMoneyBalance(),
                productBillings.getPrice(), discount);
        BigDecimal amount = productBillings.getPrice().multiply(discount);
        if (user.getMoneyBalance().doubleValue() < amount.doubleValue()) {
            throw new InsufficientBalanceException();
        }
        //increase extra, deduct user balance/money
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
        userProductUsage.setTimeStart(0L);
        userProductUsage.setTimeEnd(0L);
        userProductUsage.setTimeUsed(0L);
        userProductUsage.setCountRemain(0L);
        userProductUsage.setCountUsed(0L);
        userProductUsage.setExtra(0L);
        return userProductUsageDao.insertIgnore(userProductUsage);
    }
}
