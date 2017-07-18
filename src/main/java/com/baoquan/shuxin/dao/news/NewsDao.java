package com.baoquan.shuxin.dao.news;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.baoquan.shuxin.model.news.News;
import com.baoquan.shuxin.model.user.User;

/**
 * Author:Zhoumc
 * Description:新闻查看
 * DATA:17:11 ${DATA}
 */
@Repository
public interface NewsDao {

    Integer pageCount(Map<String, Object> parms);
    //查询
    List<News> queryNewsInfo(Map<String, Object> parms);

    /**
    * @Description:  根据id 查看新闻详情
    * @param
    * @return
    * @throws
    */
    News querNewInfoById(Long id);
    /**
     * 根据 id 修改新闻
     * @param id
     * @return
     */
    News updateNews(Integer id);
    /**
     *  根据 id 删除新闻
     * @param id
     */
    void deleteNews(Long id);
    /**
     * 依据 id  查询新闻xiangq
     * @param id
     * @return
     */
    News queryNewsDetails(Long id);
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
