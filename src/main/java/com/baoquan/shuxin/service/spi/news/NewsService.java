package com.baoquan.shuxin.service.spi.news;

import java.util.Map;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.model.config.Config;
import com.baoquan.shuxin.model.news.News;
import com.baoquan.shuxin.model.user.User;

/**
 * Author:Zhoumc
 * Description:
 * DATA:17:19 ${DATA}
 */
public interface NewsService {


    //查询
    Page<News> queryNewInfo(String newsClassType, Page<News> page);
    //删除
    Boolean delNews(Long id);
    //新闻详情
    News queryNewsDetails(Long id);
    /**
    * @Description: 修改新闻
    * @param
    * @return
    * @throws
    */
    News updateNews(Integer id);

    /**
     * 修改新闻和添加新闻
     * @param news
     */
    void updateAndAddNews(News news);

    /**
     * 添加新闻
     * @param news
     */
    void insertNews(News news);


}
