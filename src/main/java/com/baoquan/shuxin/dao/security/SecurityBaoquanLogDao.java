package com.baoquan.shuxin.dao.security;

import org.springframework.stereotype.Repository;

import com.baoquan.shuxin.model.security.SecurityBaoquanLog;

@Repository
public interface SecurityBaoquanLogDao {

	void insertBaoquanLog(SecurityBaoquanLog baoquanLog);

}
