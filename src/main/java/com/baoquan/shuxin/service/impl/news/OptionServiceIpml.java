package com.baoquan.shuxin.service.impl.news;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.baoquan.shuxin.dao.news.OptionDao;
import com.baoquan.shuxin.enums.OptionEnum;
import com.baoquan.shuxin.model.news.Option;
import com.baoquan.shuxin.service.spi.news.OptionService;

/**
 * Author:Zhoumc
 * Description:${TODO}
 * DATA:15:33 ${DATA}
 */
@Named
public class OptionServiceIpml implements OptionService {

    @Inject
    private OptionDao optionDao;

    @Override
    public List<Option> queryOptionInfo() {
        String type = OptionEnum.NEWS_CLASS_TYPE.getDesc();
        List<Option> list = optionDao.queryOptionInfo(type);
        return list;
    }

    @Override
    public List<Option> queryFlowInfo() {
        String type = OptionEnum.ACCOUNT_FLOW.getDesc();
        List<Option> list = optionDao.queryOptionInfo(type);
        return list;
    }

    @Override
    public List<Option> queryOrderInfo() {
        String type = OptionEnum.ORDER.getDesc();
        List<Option> list = optionDao.queryOptionInfo(type);
        return list;
    }




}
