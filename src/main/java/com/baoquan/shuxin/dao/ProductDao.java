package com.baoquan.shuxin.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.baoquan.shuxin.model.Product;

/**
 * Desc:
 * Created by yongj on 7/10/2017,
 */
@Repository
public interface ProductDao {
    Product queryByReflectClass(@Param("reflectClass") String reflectClass);
}
