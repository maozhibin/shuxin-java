package com.baoquan.shuxin.dao.product;

import org.springframework.stereotype.Repository;

import com.baoquan.shuxin.model.product.ProductInterface;

/**
 * Desc:
 * Created by yongj on 7/7/2017,
 */
@Repository
public interface ProductInterfaceDao {

    ProductInterface queryByProductId(Long productId);

	void delete(Integer productId);

	void insert(ProductInterface productInterface);
	
	void update(ProductInterface productInterface);

}
