package com.baoquan.shuxin.service.impl.stats;

import java.math.BigDecimal;

import javax.inject.Inject;
import javax.inject.Named;

import com.baoquan.shuxin.dao.stats.PlatformOverviewDao;
import com.baoquan.shuxin.service.spi.stats.PlatformOverviewService;
import com.baoquan.shuxin.web.vo.PlatformOverviewVO;

/**
 * Desc:
 * Created by yongj on 7/24/2017,
 */
@Named
public class PlatformOverviewServiceImpl implements PlatformOverviewService {

    @Inject
    private PlatformOverviewDao platformOverviewDao;

    @Override
    public PlatformOverviewVO queryByTime(long startTime, long endTime) {
        BigDecimal tradeAmount = platformOverviewDao.sumMoneyLogByTime(startTime, endTime);
        Long orderCount = platformOverviewDao.countUserProductByTime(startTime, endTime);
        Long attestCount = platformOverviewDao.countSecurityBaoquanLogByTime(startTime, endTime);
        BigDecimal tradeIncreaseRate = BigDecimal.ZERO;//todo
        Long authorizationCount = platformOverviewDao.countAuthorizationByTime(startTime, endTime);

        PlatformOverviewVO vo = new PlatformOverviewVO();
        vo.setTradeAmount(tradeAmount != null ? tradeAmount.setScale(2, BigDecimal.ROUND_HALF_EVEN) : BigDecimal.ZERO);
        vo.setOrderCount(orderCount);
        vo.setAttestCount(attestCount);
        vo.setTradeIncreaseRate(tradeIncreaseRate);
        vo.setAuthorizationCount(authorizationCount);
        return vo;
    }
}
