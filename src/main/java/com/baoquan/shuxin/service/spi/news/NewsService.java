package com.baoquan.shuxin.service.spi.news;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.model.news.News;
import com.baoquan.shuxin.model.user.User;

/**
 * Author:Zhoumc
 * Description:
 * DATA:17:19 ${DATA}
 */
public interface NewsService {

    //查询
    Page<News> queryNewInfo(String typeId, Page<News> page);
    //删除
    Boolean delNews(Long id);
    //修改


}
