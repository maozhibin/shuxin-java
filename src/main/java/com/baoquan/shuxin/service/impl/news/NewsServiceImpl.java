package com.baoquan.shuxin.service.impl.news;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.dao.news.NewsDao;
import com.baoquan.shuxin.model.news.News;
import com.baoquan.shuxin.model.news.NewsVO;
import com.baoquan.shuxin.model.news.Option;
import com.baoquan.shuxin.service.spi.news.NewsService;

/**
 * Author:Zhoumc
 * Description:${TODO}
 * DATA:17:35 ${DATA}
 */
@Named
public class NewsServiceImpl implements NewsService {


    @Inject
    private NewsDao newsDao;

    @Override
    public Integer countNewsInfo(String newsClassType) {
        return newsDao.countNewsInfo(newsClassType);
    }

    /**
     * 查询分页
     * @param newsClassType 类型
     * @return
     */
    @Override
    public List<News> queryNewsInfoList(String newsClassType, Integer start, Integer length) {
        Map<String, Object> parms = new HashMap<>();
        parms.put("newsClassType",newsClassType);
        parms.put("start",start);
        parms.put("length",length);
        return newsDao.queryNewsInfo(parms);
    }



    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public Boolean delNews(Long id) {
        if (id == null){
            return  false;
        }
        newsDao.deleteNews(id);
        return true;
    }

    /**
     * 根据id 查询新闻详情
     * @param id
     * @return
     */
    @Override
    public News queryNewsDetails(Long id) {
        if(id == null){
            return  null;
        }
        return newsDao.querNewInfoById(id);
    }



    @Override
    public void updateAndAddNews(News news) {
        newsDao.updateAndAddNews(news);
    }

    @Override
    public void insertNews(News news) {
        newsDao.insertNews(news);
    }




    /**
     * 根据id 修改 新闻
     * @param id
     * @return
     */
    @Override
    public News updateNews(Long id) {
        if (id == null){
            return null;
        }
        return newsDao.querNewInfoById(id);
    }


}
