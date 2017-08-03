package com.baoquan.shuxin.service.spi.stats;

import com.baoquan.shuxin.web.vo.PlatformOverviewVO;

/**
 * Desc:
 * Created by yongj on 7/24/2017,
 */
public interface PlatformOverviewService {

    PlatformOverviewVO queryByTime(long startTime, long endTime);

    Long queryOrgByTime(long stampTimeToday);


}
