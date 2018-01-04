package com.baoquan.shuxin.service.spi.admin;

import java.util.List;
import java.util.Map;

import com.baoquan.shuxin.model.admin.AdminAngle;

public interface AdminAngleService {

	List<AdminAngle> queryAll(Map<String, Object> parms);

}
