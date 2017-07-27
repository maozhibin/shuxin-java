package com.baoquan.shuxin.dao.config;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.baoquan.shuxin.model.config.Config;

@Repository
public interface ConfigDao {

	List<Config> configList(Map<String, Object> map);

	Integer configTotal();

	void updateConfig(Config config);

	void insertConfig(Config config);

	Config findByIdConfig(Integer id);

	void deleteConfig(Config config);
}
