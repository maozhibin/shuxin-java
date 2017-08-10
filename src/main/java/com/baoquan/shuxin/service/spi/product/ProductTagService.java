package com.baoquan.shuxin.service.spi.product;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.baoquan.shuxin.model.product.ProductTag;

public interface ProductTagService {

	String findByProductId(Integer idValue);


	Boolean setTages(JSONArray productTags,Integer productId);


	List<ProductTag> findByproductId(Integer productId);
}
