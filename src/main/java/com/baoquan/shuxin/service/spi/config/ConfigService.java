package com.baoquan.shuxin.service.spi.config;


import java.util.List;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.model.config.Config;

public interface ConfigService {


	Page<Config> configList(Page<Config> page);


	void updateConfig(Config config);

	void insertConfig(Config config);

	Config findByIdConfig(Integer id);

	void deleteConfig(Config config);

	Integer countConfigInfo();


	List<Config> queryConfigList(Integer start, Integer length);
}
