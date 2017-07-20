package com.baoquan.shuxin.service.spi.news;

import java.util.List;

import com.baoquan.shuxin.model.news.Option;

/**
 * Author:Zhoumc
 * Description:${TODO}
 * DATA:15:32 ${DATA}
 */
public interface OptionService {


    /**
     * 查询新闻类型
     * @return
     */
    List<Option> queryOptionInfo();
    List<Option> queryFlowInfo();

}
