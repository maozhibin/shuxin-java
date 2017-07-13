package com.baoquan.shuxin.service.impl.news;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.model.news.News;
import com.baoquan.shuxin.service.spi.news.NewsService;

/**
 * Author:Zhoumc
 * Description:${TODO}
 * DATA:17:35 ${DATA}
 */
public class NewsServiceImpl implements NewsService {


    @Override
    public Page<News> queryNewInfo(String name, String mobile, String typeId, Page<News> page) {
        return null;
    }

    @Override
    public Boolean delNews(Long id) {
        return null;
    }
}
