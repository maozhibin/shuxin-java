//package com.baoquan.shuxin.service.aop.product;
//
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.List;
//import java.util.Objects;
//
//import javax.inject.Inject;
//
//import org.apache.commons.collections.CollectionUtils;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//import com.alibaba.fastjson.JSON;
//import com.baoquan.shuxin.context.AppContext;
//import com.baoquan.shuxin.dao.product.ProductBillingDao;
//import com.baoquan.shuxin.dao.product.ProductDao;
//import com.baoquan.shuxin.dao.product.ProductInterfaceDao;
//import com.baoquan.shuxin.dao.user.UserProductDao;
//import com.baoquan.shuxin.dao.UserProductUseDao;
//import com.baoquan.shuxin.enums.BillingMethodEnum;
//import com.baoquan.shuxin.enums.FreeEnum;
//import com.baoquan.shuxin.exception.billing.NotPurchasedException;
//import com.baoquan.shuxin.model.product.ProductBilling;
//import com.baoquan.shuxin.model.product.ProductInterface;
//import com.baoquan.shuxin.model.user.UserProduct;
//import com.baoquan.shuxin.model.UserProductUse;
//import com.google.common.base.Function;
//import com.google.common.collect.ListMultimap;
//import com.google.common.collect.Lists;
//import com.google.common.collect.Multimaps;
//
///**
// * Desc:
// * Created by yongj on 7/7/2017,
// */
////@Aspect
////@Component
//public class BillingInterceptor {
//    private final static Logger logger = LoggerFactory.getLogger(BillingInterceptor.class);
//
//    @Pointcut("execution(* com.baoquan.shuxin.service.spi.product..*.*(..))")
//    private void aspect() {
//    }
//
//    @Before("aspect()")
//    public void before() {
//        Long userId = AppContext.get().getUserId();
//        String className = AppContext.get().getClassName();
//        String methodName = AppContext.get().getMethodName();
//        charging(userId, className, methodName);
//    }
//
//    @Inject
//    private ProductDao productDao;
//    @Inject
//    private ProductInterfaceDao productInterfaceDao;
//    @Inject
//    private UserProductDao userProductDao;
//    @Inject
//    private UserProductUseDao userProductUseDao;
//    @Inject
//    private ProductBillingDao productBillingDao;
//
//    public void charging(Long userId, String className, String methodName) {
//        logger.info("user[{}] access product[{}/{}]", userId, className, methodName);
//
//        ProductInterface productInterface = findProductInterface(methodName, className);
//
//        //如果是免费的，做一下调用记录即可
//        if (Objects.equals(productInterface.getFree(), FreeEnum.YES.getCode())) {
//            logger.info("ProductInterface is free for use!");
//            //throw new UnsupportedOperationException("不支持免费产品！");
//            return;
//        }
//
//        //用户购买记录，对应的使用记录，涉及的产品套餐
//        List<UserProduct> userProducts = userProductDao.queryByUserProductStatus(userId,
//                productInterface.getProductId(), 1);
//        logger.info("userProducts:{}", JSON.toJSONString(userProducts));
//        if (CollectionUtils.isEmpty(userProducts)) {
//            throw new NotPurchasedException();
//        }
//        //todo：确保在生成user_product的时候同时生成对应的user_product_use记录
//        List<UserProductUse> userProductUses = userProductUseDao.queryByUserProductIds(
//                Lists.transform(userProducts, new Function<UserProduct, Long>() {
//                    @Override
//                    public Long apply(UserProduct userProduct) {
//                        return userProduct.getId();
//                    }
//                }));
//        logger.info("userProductUses:{}", JSON.toJSONString(userProductUses));
//        if (CollectionUtils.isEmpty(userProductUses)) {
//            throw new RuntimeException("Not found related UserProductUse by UserProduct!?");
//        }
//        List<ProductBilling> productBillings = productBillingDao.queryByIds(
//                Lists.transform(userProductUses, new Function<UserProductUse, Long>() {
//                    @Override
//                    public Long apply(UserProductUse userProductUse) {
//                        return userProductUse.getProductBillingId();
//                    }
//                }));
//        logger.info("productBillings:{}", JSON.toJSONString(productBillings));
//
//        //用户购买的套餐进行分组
//        ListMultimap<Long, UserProductUse> userProductUseImmutableListMultimap = Multimaps.index(userProductUses,
//                new Function<UserProductUse, Long>() {
//                    @Override
//                    public Long apply(UserProductUse input) {
//                        return input.getProductBillingId();
//                    }
//                });
//        //对产品套餐进行排序
//        Collections.sort(productBillings, productBillingComparator);
//        //按排序好的套餐类型，选择用户购买的套餐进行计费
//        for (ProductBilling productBilling : productBillings) {
//            List<UserProductUse> productUses = userProductUseImmutableListMultimap.get(productBilling.getId());
//            if (CollectionUtils.isEmpty(productUses)) continue;
//
//            //对使用记录排序
//            productUses = Lists.newArrayList(productUses);
//            Collections.sort(productUses, userProductUseComparator);
//            for (UserProductUse productUse : productUses) {
//                switch (BillingMethodEnum.codeOf(productBilling.getBillingMethod())) {
//                    case YEAR:
//                        long now = System.currentTimeMillis() / 1000;
//                        if (now >= productUse.getStart() && now <= productUse.getEnd()) {
//                            logger.info("user_product_use:{}", JSON.toJSONString(productUse));
//                            return;
//                        }
//                        break;
//                    case COMBO:
//                    case COUNT:
//                        if (productUse.getUsed() < productUse.getTotal()) {
//                            int rows = userProductUseDao.increaseUsed(productUse.getId());
//                            if (rows > 0) {
//                                logger.info("user_product_use:{}", JSON.toJSONString(productUse));
//                                return;
//                            }
//                        }
//                        break;
//                    default:
//                        throw new UnsupportedOperationException("不支持的计费方式！");
//                }
//            }
//        }
//        throw new RuntimeException("无可用套餐记录！");
//    }
//
//    /**
//     * class+method应当对应唯一一条记录，不同class下可能会有相同method
//     * @param methodName 对应ProductInterface
//     * @param className  对应Product
//     * @return 定位到唯一的接口
//     */
//    private ProductInterface findProductInterface(String methodName, String className) {
//        //MARK:约束每个product只有一个interface
//        List<ProductInterface> productInterfaces = productInterfaceDao.queryByReflectMethod(methodName);
//        logger.info("productInterfaces:{}", JSON.toJSONString(productInterfaces));
//        if (CollectionUtils.isEmpty(productInterfaces)) {
//            throw new RuntimeException("ProductInterface not exists!");
//        }
//        ProductInterface productInterface = null;
//        if (productInterfaces.size() == 1) {
//            productInterface = productInterfaces.get(0);
//        } else {
//            //接口名有重复的，按类名过滤
//            Long productId = productDao.filterIdByReflectClass(className,
//                    Lists.transform(productInterfaces, new Function<ProductInterface, Long>() {
//                        @Override
//                        public Long apply(ProductInterface input) {
//                            return input.getProductId();
//                        }
//                    }));
//            if (productId == null) {
//                throw new RuntimeException("Product no exists!?");
//            }
//            for (ProductInterface pi : productInterfaces) {
//                if (Objects.equals(pi.getProductId(), productId)) {
//                    productInterface = pi;
//                }
//            }
//            if (productInterface == null) {
//                throw new RuntimeException("Not found matched Product by ReflectClass!?");
//            }
//        }
//        return productInterface;
//    }
//
//    /**
//     * 用户套餐使用记录的排序规则，原则是尽量使用后剩余的记录应该越来越少
//     * 1.时间：结束时间早的先使用
//     * 2.剩余量：剩余少的先使用
//     */
//    private Comparator<UserProductUse> userProductUseComparator = new Comparator<UserProductUse>() {
//        @Override
//        public int compare(UserProductUse o1, UserProductUse o2) {
//            int ret = o1.getEnd() - o2.getEnd();
//            if (ret != 0) {
//                return ret;
//            }
//            ret = (o1.getTotal() - o1.getUsed()) - (o2.getTotal() - o2.getUsed());
//            return ret;
//        }
//    };
//
//    /**
//     * 套餐的排序规则，原则是优惠的优先
//     * 1.计费类型：包年、包次数、单次
//     * 2.设置的优先级？可能是同种套餐？或者就没法用？
//     * 3.折扣率：折扣高的优先
//     */
//    private Comparator<ProductBilling> productBillingComparator = new Comparator<ProductBilling>() {
//        @Override
//        public int compare(ProductBilling o1, ProductBilling o2) {
//            int ret = BillingMethodEnum.compare(o1.getBillingMethod(), o2.getBillingMethod());
//            if (ret != 0) {
//                return ret;
//            }
//            ret = Integer.compare(o2.getPriority(), o1.getPriority());
//            if (ret != 0) {
//                return ret;
//            }
//            return Float.compare(o2.getDiscountRate(), o1.getDiscountRate());
//        }
//    };
//
//}
