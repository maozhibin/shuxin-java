package com.baoquan.shuxin.service.impl.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.dao.user.UserDao;
import com.baoquan.shuxin.model.user.User;
import com.baoquan.shuxin.service.spi.user.UserService;
import com.baoquan.shuxin.util.common.Stringutil;

/**
 * Created by Administrator on 2017/7/12.
 */
@Named
public class UserServiceImpl<T> implements UserService {
	@Inject
	private UserDao userDao;

	@Override
	public Page<User> findListUser(String name, String mobile, String typeId, Page<User> page) {
		Map<String, Object> parms = new HashMap<>();
		if (StringUtils.isNotEmpty(name)) {
			parms.put("name", name);
		}
		if (!StringUtils.isEmpty(mobile)) {
			if (Stringutil.isChinaPhoneLegal(mobile)) {
				parms.put("mobile", mobile);
			}
		}
		if (StringUtils.isNotEmpty(typeId)) {
			parms.put("typeId", typeId);
		}
		parms.put("page", page);
		List<User> list = userDao.findUserInfo(parms);
		Integer total = userDao.findValidUser(parms);
		if (total != null) {
			page.setTotalRecordCount(total);
		}
		page.setResult(list);

		return page;
	}

	@Override
	public Boolean deleteUser(Long id) {
		if (id == null) {
			return false;
		}
		userDao.deleteUser(id);
		return true;
	}

	@Override
	public User findByIdUserInfo(Long id) {
		if (id == null) {
			return null;
		}
		return userDao.findByIdUserInfo(id);
	}
}
