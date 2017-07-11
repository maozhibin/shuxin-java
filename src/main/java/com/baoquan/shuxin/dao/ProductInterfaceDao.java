package com.baoquan.shuxin.dao;

import org.springframework.stereotype.Repository;

import com.baoquan.shuxin.model.ProductInterface;

/**
 * Desc:
 * Created by yongj on 7/7/2017,
 */
@Repository
public interface ProductInterfaceDao {
    ProductInterface queryByReflectMethod(String reflectMethod);
}
