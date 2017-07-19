package com.baoquan.shuxin.service.impl.stats;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;

import com.baoquan.shuxin.constatn.OrgConstatnt;
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
	
	/**
	 * 查询top10或者所有的机构
	 */
	@Override
	public List<Map<String, Object>> orgTopOrAll(Integer type) {
		List<Long> idList =new ArrayList<>();
		List<Map<String, Object>> orgTop=null;
		if(OrgConstatnt.TOP_TEN_ORG.equals(type)){
			 orgTop = statsOrgDao.orgTop();
		}else if(OrgConstatnt.ALL_ORG.equals(type)){
			 orgTop = statsOrgDao.orgAll();
		}
		
		if(CollectionUtils.isEmpty(orgTop)){
			return null;
		}
		for (Map<String, Object> map : orgTop) {
			Long orgId = MapUtils.getLong(map, "org_id");
			idList.add(orgId);
		}
		
		List<User> nameList=userDao.orgName(idList);
		if(CollectionUtils.isEmpty(nameList)){
			return null;
		}
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
			if(CollectionUtils.isEmpty(productList)){
				return null;
			}
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

	/**
	 * 根据机构名查询
	 */
	@Override
	public List<Map<String, Object>> orgListByOrgName(String orgName) {
		User user = userDao.findByUserName(orgName);
		if(user==null){
			return null;
		}
		Long orgId = user.getId();
		Map<String, Object> product = statsOrgProductDao.productByorgId(orgId);
		if(product==null){
			return null;
		}
		String productName = MapUtils.getString(product, "productName");
		Long num = MapUtils.getLong(product, "num");
		
		Map<String, Object> org=statsOrgDao.findById(orgId);
		org.put("username", user.getUsername());
		org.put("productName", productName);
		org.put("num", num);
		List<Map<String, Object>> list = new ArrayList<>();
		list.add(org);
		return list;
	}
}
