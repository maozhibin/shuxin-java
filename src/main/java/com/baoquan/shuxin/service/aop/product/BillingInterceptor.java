package com.baoquan.shuxin.service.aop.product;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import org.apache.commons.collections.CollectionUtils;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.baoquan.shuxin.context.AppContext;
import com.baoquan.shuxin.dao.ProductBillingDao;
import com.baoquan.shuxin.dao.ProductDao;
import com.baoquan.shuxin.dao.ProductInterfaceDao;
import com.baoquan.shuxin.dao.UserProductDao;
import com.baoquan.shuxin.dao.UserProductUseDao;
import com.baoquan.shuxin.enums.BillingMethodEnum;
import com.baoquan.shuxin.enums.FreeEnum;
import com.baoquan.shuxin.exception.billing.NotPurchasedException;
import com.baoquan.shuxin.model.ProductBilling;
import com.baoquan.shuxin.model.ProductInterface;
import com.baoquan.shuxin.model.UserProduct;
import com.baoquan.shuxin.model.UserProductUse;
import com.google.common.base.Function;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimaps;

/**
 * Desc:
 * Created by yongj on 7/7/2017,
 */
@Aspect
@Component
public class BillingInterceptor {
    private final static Logger logger = LoggerFactory.getLogger(BillingInterceptor.class);

    @Pointcut("execution(* com.baoquan.shuxin.service.spi.product..*.*(..))")
    private void aspect() {
    }

    @Inject
    private ProductDao productDao;
    @Inject
    private ProductInterfaceDao productInterfaceDao;
    @Inject
    private UserProductDao userProductDao;
    @Inject
    private UserProductUseDao userProductUseDao;
    @Inject
    private ProductBillingDao productBillingDao;

    @Before("aspect()")
    public void Before() {
        logger.info("user[{}] access product[{}/{}]", AppContext.get().getUserId(), AppContext.get().getClassName(),
                AppContext.get().getMethodName());
        //MARK:约束每个product只有一个interface
        ProductInterface productInterface = productInterfaceDao.queryByReflectMethod(AppContext.get().getMethodName());
        logger.info("productInterface:{}", JSON.toJSONString(productInterface));
        if (productInterface == null) {
            throw new RuntimeException("ProductInterface not exists!");
        }
        //如果是免费的，做一下调用记录即可
        if (Objects.equals(productInterface.getFree(), FreeEnum.YES.getCode())) {
            //todo 记录调用请求
            logger.info("ProductInterface is free for use!");
            throw new UnsupportedOperationException("不支持免费产品！");
            //return;
        }
        List<UserProduct> userProducts = userProductDao.queryByUserProductStatus(AppContext.get().getUserId(),
                productInterface.getProductId(), 1);
        logger.info("userProducts:{}", JSON.toJSONString(userProducts));
        if (CollectionUtils.isEmpty(userProducts)) {
            throw new NotPurchasedException("未购买");
        }
        //todo：确保在生成user_product的时候同时生成对应的user_product_use记录
        List<UserProductUse> userProductUses = userProductUseDao.queryByUserProductIds(
                Lists.transform(userProducts, new Function<UserProduct, Long>() {
                    @Override
                    public Long apply(UserProduct userProduct) {
                        return userProduct.getId();
                    }
                }));
        logger.info("userProductUses:{}", JSON.toJSONString(userProductUses));
        if (CollectionUtils.isNotEmpty(userProductUses)) {
            List<ProductBilling> productBillings = productBillingDao.queryByIds(
                    Lists.transform(userProductUses, new Function<UserProductUse, Long>() {
                        @Override
                        public Long apply(UserProductUse userProductUse) {
                            return userProductUse.getProductBillingId();
                        }
                    }));
            logger.info("productBillings:{}", JSON.toJSONString(productBillings));
            Collections.sort(productBillings, productBillingComparator);

            ListMultimap<Long, UserProductUse> userProductUseImmutableListMultimap = Multimaps.index(userProductUses,
                    new Function<UserProductUse, Long>() {
                        @Override
                        public Long apply(UserProductUse input) {
                            return input.getProductBillingId();
                        }
                    });
            for (ProductBilling productBilling : productBillings) {
                List<UserProductUse> productUses = userProductUseImmutableListMultimap.get(productBilling.getId());
                if (CollectionUtils.isNotEmpty(productUses)) {
                    productUses = Lists.newArrayList(productUses);
                    Collections.sort(productUses, userProductUseComparator);

                    for (UserProductUse productUse : productUses) {
                        switch (BillingMethodEnum.codeOf(productBilling.getBillingMethod())) {
                            case YEAR:
                                long now = System.currentTimeMillis() / 1000;
                                if (now >= productUse.getStart() && now <= productUse.getEnd()) {
                                    //todo 请求记录
                                    logger.info("user_product_use:{}", JSON.toJSONString(productUse));
                                    return;
                                }
                                break;
                            case COUNT:
                                if (productUse.getUsed() < productUse.getTotal()) {
                                    //todo 请求记录
                                    int rows = userProductUseDao.increaseUsed(productUse.getId());
                                    if (rows > 0) {
                                        logger.info("user_product_use:{}", JSON.toJSONString(productUse));
                                        return;
                                    }
                                }
                                break;
                            default:
                                throw new UnsupportedOperationException("不支持的计费方式！");
                        }
                    }
                }
            }
        }
        throw new RuntimeException("abort");
    }

    private Comparator<UserProductUse> userProductUseComparator = new Comparator<UserProductUse>() {
        @Override
        public int compare(UserProductUse o1, UserProductUse o2) {
            int ret = o1.getEnd() - o2.getEnd();
            if (ret != 0) {
                return ret;
            }
            ret = (o1.getTotal() - o1.getUsed()) - (o2.getTotal() - o2.getUsed());
            return ret;
        }
    };

    private Comparator<ProductBilling> productBillingComparator = new Comparator<ProductBilling>() {
        @Override
        public int compare(ProductBilling o1, ProductBilling o2) {
            int ret = BillingMethodEnum.compare(o1.getBillingMethod(), o2.getBillingMethod());
            if (ret != 0) {
                return ret;
            }
            ret = Integer.compare(o2.getPriority(), o1.getPriority());
            if (ret != 0) {
                return ret;
            }
            return Float.compare(o2.getDiscountRate(), o1.getDiscountRate());
        }
    };
}
