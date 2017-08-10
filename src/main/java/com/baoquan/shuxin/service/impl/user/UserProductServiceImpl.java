package com.baoquan.shuxin.service.impl.user;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import com.baoquan.shuxin.dao.user.UserProductDao;
import com.baoquan.shuxin.service.spi.user.UserProductService;
@Named
public class UserProductServiceImpl implements UserProductService{
	@Inject
	private UserProductDao userProductDao;

	@Override
	public List<Map<String, Object>> queryByBuyTime(String stampTimeYesterday) {
		return userProductDao.queryByBuyTime(stampTimeYesterday);
	}

	@Override
	public List<Map<String, Object>> findByTimeYesterday(String stampTimeYesterday) {
		return userProductDao.findByTimeYesterday(stampTimeYesterday);
	}
}
