package com.baoquan.shuxin.dao.news;

import java.util.List;
import java.util.Map;

import com.baoquan.shuxin.model.news.News;
import com.baoquan.shuxin.model.user.User;

/**
 * Author:Zhoumc
 * Description:新闻查看
 * DATA:17:11 ${DATA}
 */
public interface NewsDao {

    Integer PageCount(Map<String, Object> parms);
    //查询
    List<News> queryNewsInfo(Map<String, Object> parms);
    //删除
    void deleteNews(Long id);
    //修改

    //查询新闻详情
    News queryNewsDetails(Long id);

}
