package com.baoquan.shuxin.service.spi.news;

import java.util.List;
import java.util.Map;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.model.config.Config;
import com.baoquan.shuxin.model.news.News;
import com.baoquan.shuxin.model.news.NewsVO;
import com.baoquan.shuxin.model.news.Option;
import com.baoquan.shuxin.model.user.User;

/**
 * Author:Zhoumc
 * Description:
 * DATA:17:19 ${DATA}
 */
public interface NewsService {


    //查询
    Integer countNewsInfo(String newsClassType );

    List<News> queryNewsInfoList(String type, Page<News> page);
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
    News updateNews(Long id);

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
