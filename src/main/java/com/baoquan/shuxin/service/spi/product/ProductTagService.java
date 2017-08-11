package com.baoquan.shuxin.service.spi.product;

import java.util.List;

import com.alibaba.fastjson.JSONArray;

public interface ProductTagService {

	String findByProductId(Integer idValue);


	Boolean setTages(JSONArray productTags,Integer productId);


	List<String> findByproductId(Integer productId);
}
