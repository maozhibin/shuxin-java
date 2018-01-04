package com.baoquan.shuxin.service.impl.admin;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import com.baoquan.shuxin.dao.admin.AdminAngleDao;
import com.baoquan.shuxin.model.admin.AdminAngle;
import com.baoquan.shuxin.service.spi.admin.AdminAngleService;

@Named
public class AdminAngleServiceImpl implements AdminAngleService {
	@Inject
	private AdminAngleDao adminAngleDao;

	@Override
	public List<AdminAngle> queryAll(Map<String, Object> parms) {
		List<AdminAngle> list = adminAngleDao.queryAll(parms);
		return list;
	}
}
