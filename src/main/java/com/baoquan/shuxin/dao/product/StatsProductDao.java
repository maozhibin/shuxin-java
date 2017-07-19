package com.baoquan.shuxin.dao.product;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface StatsProductDao{
	List<Map<String, Object>> productTop();

	List<Map<String, Object>> productList(Map<String, Object> map);

}
