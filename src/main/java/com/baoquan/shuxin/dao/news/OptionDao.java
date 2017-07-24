package com.baoquan.shuxin.dao.news;

import java.util.List;

import com.baoquan.shuxin.model.news.Option;
import com.baoquan.shuxin.model.product.Product;

/**
 * Author:Zhoumc
 * Description:${TODO}
 * DATA:15:29 ${DATA}
 */
public interface OptionDao {

    /**
     * 查询新闻类型
     * @return
     */
    List<Option> queryOptionInfo(String varname);

}
