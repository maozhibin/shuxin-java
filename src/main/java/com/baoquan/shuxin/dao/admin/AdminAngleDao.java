package com.baoquan.shuxin.dao.admin;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.baoquan.shuxin.model.admin.AdminAngle;

@Repository
public interface AdminAngleDao {

	List<AdminAngle> queryAll(Map<String, Object> parms);
}
