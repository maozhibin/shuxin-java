package com.baoquan.shuxin.dao.product;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.baoquan.shuxin.model.product.Product;

/**
 * Desc:
 * Created by yongj on 7/10/2017,
 */
@Repository
public interface ProductDao {
    List<Product> queryByReflectClass(@Param("reflectClass") String reflectClass);

    Long filterIdByReflectClass(String reflectClass, Collection<Long> ids);
}
