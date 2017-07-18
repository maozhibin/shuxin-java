package com.baoquan.shuxin.service.impl.stats;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.collections.MapUtils;

import com.baoquan.shuxin.dao.stats.StatsOrgDao;
import com.baoquan.shuxin.dao.stats.StatsOrgProductDao;
import com.baoquan.shuxin.dao.user.UserDao;
import com.baoquan.shuxin.model.user.User;
import com.baoquan.shuxin.service.spi.stats.StatsOrgService;

@Named
public class StatsOrgServiceImpl implements StatsOrgService{
	@Inject
	private StatsOrgDao statsOrgDao;
	@Inject
	private UserDao userDao;
	@Inject
	private StatsOrgProductDao statsOrgProductDao;
	
	@Override
	public List<Map<String, Object>> orgTop() {
		List<Long> idList =new ArrayList<>();
		List<Map<String, Object>> orgTop = statsOrgDao.orgTop();
		for (Map<String, Object> map : orgTop) {
			Long orgId = MapUtils.getLong(map, "org_id");
			idList.add(orgId);
		}
		
		List<User> nameList=userDao.orgName(idList);
		for (User user : nameList) {
			String username = user.getUsername();
			Long id = user.getId();;
			for (Map<String, Object> map : orgTop) {
				Long orgId = MapUtils.getLong(map, "org_id");
				if(id.equals(orgId)){
					map.put("username", username);
				}
			}
		}
		
		List<Map<String, Object>> productList = statsOrgProductDao.productList(idList);
			for (Map<String, Object> product: productList) {
				String productName = MapUtils.getString(product, "productName");
				Long num = MapUtils.getLong(product, "num");
				Long orgId = MapUtils.getLong(product, "org_id");
				for (Map<String, Object> map : orgTop) {
					Long id = MapUtils.getLong(map, "org_id");
					if(id.equals(orgId)){
						map.put("productName", productName);
						map.put("num", num);
					}
				}
		}
		return orgTop;
	}
}
