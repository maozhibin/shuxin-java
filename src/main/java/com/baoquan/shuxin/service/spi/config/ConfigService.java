package com.baoquan.shuxin.service.spi.config;


import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.model.config.Config;

public interface ConfigService {


	Page<Config> configList(Page<Config> page);

	void updateConfig(Config config);

	void insertConfig(Config config);

	Config findByIdConfig(Integer id);



}
