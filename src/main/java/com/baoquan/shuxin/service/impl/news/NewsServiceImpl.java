package com.baoquan.shuxin.service.impl.news;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.dao.news.NewsDao;
import com.baoquan.shuxin.model.news.News;
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

    /**
     * 查询分页
     * @param newsClassType 类型
     * @param page
     * @return
     */
    @Override
    public Page<News> queryNewInfo(String newsClassType, Page<News> page) {
        Map<String, Object> parms = new HashMap<>();
        parms.put("newsClassType",newsClassType);
        parms.put("page",page);
        List<News> list = newsDao.queryNewsInfo(parms);
        Integer total = newsDao.PageCount(parms);
        if (total != null){
            page.setTotalRecordCount(total);
        }
        page.setResult(list);
        return page;
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

        return null;
    }


}
