package com.baoquan.shuxin.web.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.constatn.OrgConstatnt;
import com.baoquan.shuxin.service.spi.product.StatsProductService;
import com.baoquan.shuxin.service.spi.stats.PlatformOverviewService;
import com.baoquan.shuxin.service.spi.stats.StatsOrgService;
import com.baoquan.shuxin.service.spi.user.UserMoneyLogService;
import com.google.common.collect.Maps;

/**
 * Desc: Created by yongj on 7/15/2017,
 */
@Controller
@RequestMapping("/overview")
public class OverviewController {
	@Inject
	private StatsProductService statsProductService;
	@Inject
	private StatsOrgService statsOrgService;

	@Inject
	private PlatformOverviewService platformOverviewService;
	@Inject
	private UserMoneyLogService userMoneyLogService;

	@RequestMapping("/platform")
	public ModelAndView platform() {
		ModelAndView mv = new ModelAndView("admin/overview/platform");
		Map<String, Object> params = Maps.newHashMap();
		List<Map<String, Object>> productTop = statsProductService.productTop();
		Map<String, Object> parms = new HashMap<>();
		parms.put("type", OrgConstatnt.TOP_TEN_ORG);
		List<Map<String, Object>> orgTop = statsOrgService.orgTopOrAll(parms);
		Map<String, Object> moneyCount = userMoneyLogService.queryAmountMoney();
		params.put("productTop", productTop);
		params.put("orgTop", orgTop);
		params.put("moneyCount", moneyCount);
		mv.addObject(params);
		return mv;
	}

	/**
	 * 机构top10或者全部
	 * 
	 * @return
	 */
	@RequestMapping("/organization")
	public ModelAndView organization(String orgName, Integer pageNo, Integer pageSize) {
		if (pageNo == null || pageNo < 1)
			pageNo = 1;
		if (pageSize == null || pageSize > Page.DEFAULT_PAGE_SIZE)
			pageSize = Page.DEFAULT_PAGE_SIZE;
		orgName = StringUtils.trimToNull(orgName);
		ModelAndView mv = new ModelAndView("admin/overview/organization");
		Map<String, Object> parms = new HashMap<>();
		Page<Map<String, Object>> page = new Page<>();
		parms.put("type", OrgConstatnt.TOP_TEN_ORG);
		parms.put("page", page);
		List<Map<String, Object>> orgTop = statsOrgService.orgTopOrAll(parms);
		List<Map<String, Object>> orgList = null;
		Long count = null;
		// if(StringUtils.isEmpty(orgName)){
		// parms.put("type", OrgConstatnt.ALL_ORG);
		// orgList = statsOrgService.orgTopOrAll(parms);
		// count = statsOrgService.orgCount();
		// }else{
		// orgList = statsOrgService.orgListByOrgName(orgName);
		// count = (long) orgList.size();
		// }
		orgList = statsOrgService.orgListByOrgName(orgName);
		if (!CollectionUtils.isEmpty(orgList)) {
			count = (long) orgList.size();
		}
		// 分页实现
		page.setPageSize(pageSize);
		page.setPageNo(pageNo);
		page.setResult(orgList);

		page.setTotalRecordCount(orgList == null ? 0 : count);

		Map<String, Object> params = Maps.newHashMap();
		params.put("orgTop", orgTop);
		mv.addObject(params);
		mv.addObject(page);
		mv.addObject("keywords", orgName);
		return mv;
	}

	/**
	 * 产品top10列表或者全部
	 * 
	 * @return
	 */
	@RequestMapping("/product")
	public ModelAndView product(String productName, Integer pageNo, Integer pageSize) {
		if (pageNo == null || pageNo < 1)
			pageNo = 1;
		if (pageSize == null || pageSize > Page.DEFAULT_PAGE_SIZE)
			pageSize = Page.DEFAULT_PAGE_SIZE;
		productName = StringUtils.trimToNull(productName);
		ModelAndView mv = new ModelAndView("admin/overview/product");
		List<Map<String, Object>> productTop = statsProductService.productTop();// top10产品
		Map<String, Object> map = new HashMap<>();

		// 分页实现
		Page<Map<String, Object>> page = new Page<>();

		page.setPageSize(pageSize);
		page.setPageNo(pageNo);

		map.put("page", page);
		List<Map<String, Object>> productList = null;
		Long size = (long) 0;
		if (!StringUtils.isEmpty(productName)) {
			map.put("productName", productName);
			productList = statsProductService.productList(map);
			size = statsProductService.productListCount(map);
		}
		page.setResult(productList);
		page.setTotalRecordCount(size);
		Map<String, Object> params = Maps.newHashMap();
		params.put("productTop", productTop);
		mv.addObject(params);
		mv.addObject(page);
		mv.addObject("keywords", productName);
		return mv;
	}

	/**
	 * 用户资金今日,昨天,上周同期曲线记录
	 */
	@RequestMapping("moneyProfile")
	@ResponseBody
	public Object moneyProfile(@RequestParam("types[]") Integer[] types) {
		Date now = new Date();
		Date today = DateUtils.truncate(now, Calendar.DATE);
		Long time = null;
		Map<Object, Object> map = new HashMap<>();
		for (Integer type : types) {
			time = DateUtils.addDays(today, type).getTime();
			Map<Object, Object> mapValue = userMoneyLogService.findByFinishTime(time);
			map.putAll(mapValue);
		}
		return map;
	}

	/**
	 * 圆形统计
	 */
	@RequestMapping("round")
	@ResponseBody
	public Object round() {
		List<Map<String, Object>> productTop = statsProductService.productTop();// top10产品
		List<Map<String, Object>> mapList = new ArrayList<>();
		for (Map<String, Object> map : productTop) {
			Map<String, Object> maps = new HashMap<>();
			String name = MapUtils.getString(map, "name");
			String value = MapUtils.getString(map, "order_num");
			maps.put("name", name);
			maps.put("value", value);
			mapList.add(maps);
		}
		return mapList;
	}
}
