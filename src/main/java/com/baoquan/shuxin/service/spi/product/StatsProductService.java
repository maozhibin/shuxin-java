package com.baoquan.shuxin.service.spi.product;

import java.util.List;
import java.util.Map;

public interface StatsProductService {

	List<Map<String, Object>> productTop();

	List<Map<String, Object>> productList(Map<String, Object> map);

	Long productListCount(Map<String, Object> map);

}
