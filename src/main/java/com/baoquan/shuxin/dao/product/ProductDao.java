package com.baoquan.shuxin.dao.product;

import java.util.Collection;
import java.util.List;
import java.util.Map;

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

    Long filterIdByReflectClass(@Param("reflectClass") String reflectClass, @Param("ids") Collection<Long> ids);

    Integer countByName(Map<String, Object> map);

    List<Map<String,Object>> productList(Map<String, Object> map);

	void updateProduct(Product product);

	void insertProduct(Product product);

	Product findById(Integer id);



}
