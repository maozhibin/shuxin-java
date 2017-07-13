package com.baoquan.shuxin.service.impl.config;

import javax.inject.Inject;
import javax.inject.Named;

import com.baoquan.shuxin.dao.config.ConfigDao;
import com.baoquan.shuxin.service.spi.config.ConfigService;

@Named
public class ConfigServiceImpl implements ConfigService{
	@Inject
	private ConfigDao configDao;
}
