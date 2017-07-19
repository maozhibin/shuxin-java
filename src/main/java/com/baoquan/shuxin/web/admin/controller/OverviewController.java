package com.baoquan.shuxin.web.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.constatn.OrgConstatnt;
import com.baoquan.shuxin.model.product.Product;
import com.baoquan.shuxin.service.spi.product.StatsProductService;
import com.baoquan.shuxin.service.spi.stats.StatsOrgService;
import com.baoquan.shuxin.util.JsonResponseMsg;
import com.google.common.collect.Maps;

/**
 * Desc:
 * Created by yongj on 7/15/2017,
 */
@Controller
@RequestMapping("/overview")
public class OverviewController {
	@Inject
	private StatsProductService statsProductService;
	@Inject
	private StatsOrgService statsOrgService;
    @RequestMapping("/platform")
    public ModelAndView  platform() {
    	ModelAndView mv = new ModelAndView("admin/overview/platform");
    	Map<String, Object> params = Maps.newHashMap();
    	List<Map<String, Object>> productTop = statsProductService.productTop();
    	List<Map<String, Object>> orgTop = statsOrgService.orgTopOrAll(OrgConstatnt.TOP_TEN_ORG);
    	params.put("productTop", productTop);
    	params.put("orgTop", orgTop);
    	mv.addObject(params);
        return mv;
    }
    
    /**
     * 机构top10
     * @return
     */
    @RequestMapping("/organization")
    public ModelAndView organization(String orgName,String pageNo, String pageSize) {
    	ModelAndView mv = new ModelAndView("admin/overview/organization");
    	List<Map<String, Object>> orgTop = statsOrgService.orgTopOrAll(OrgConstatnt.TOP_TEN_ORG);
    	List<Map<String, Object>> orgList=null;
    	if(StringUtils.isEmpty(orgName)){
    		orgList = statsOrgService.orgTopOrAll(OrgConstatnt.ALL_ORG);
    	}else{
    		orgList = statsOrgService.orgListByOrgName(orgName);
    	}
    	//分页实现
    	Page<Map<String, Object>> page = new Page<>();
    	Integer pageSizeValue = null;
		if (NumberUtils.isNumber(pageSize)) {
			pageSizeValue = NumberUtils.toInt(pageSize);
			page.setPageSize(pageSizeValue);
		}
		Integer pageNoValue = null;
		if (NumberUtils.isNumber(pageNo)) {
			pageNoValue = NumberUtils.toInt(pageNo);
			page.setPageNo(pageNoValue);
		}
		Long size = (long) orgList.size();
		page.setResult(orgList);
		page.setTotalRecordCount(size);
		
    	Map<String, Object> params = Maps.newHashMap();
    	params.put("orgTop", orgTop);
    	mv.addObject(params);
    	mv.addObject(page);
        return mv;
    }
    
    /**
     * 产品top10列表或者全部
     * @return
     */
    @RequestMapping("/product")
    public ModelAndView product(String productName,String pageNo, String pageSize) {
    	ModelAndView mv = new ModelAndView("admin/overview/product");
    	List<Map<String, Object>> productTop = statsProductService.productTop();//top10产品
    	Map<String, Object> map = new HashMap<>();
    	if(!StringUtils.isEmpty(productName)){
    		map.put("productName", productName);
    	}
    	List<Map<String, Object>> productList = statsProductService.productList(map);
    	Long size = (long) productList.size();
    	//分页实现
    	Page<Map<String, Object>> page = new Page<>();
    	Integer pageSizeValue = null;
		if (NumberUtils.isNumber(pageSize)) {
			pageSizeValue = NumberUtils.toInt(pageSize);
			page.setPageSize(pageSizeValue);
		}
		Integer pageNoValue = null;
		if (NumberUtils.isNumber(pageNo)) {
			pageNoValue = NumberUtils.toInt(pageNo);
			page.setPageNo(pageNoValue);
		}
		page.setResult(productList);
    	page.setTotalRecordCount(size);
		
    	Map<String, Object> params = Maps.newHashMap();
    	params.put("productTop", productTop);
    	mv.addObject(params);
    	mv.addObject(page);
        return mv;
    }
    
    
    /**
     *产品局部刷新 
     */
    @RequestMapping("/freshen")
    @ResponseBody
    public JsonResponseMsg productFreshen(String productName,String pageNo, String pageSize) {
    	JsonResponseMsg result = new JsonResponseMsg();
    	Map<String, Object> map = new HashMap<>();
    	if(!StringUtils.isEmpty(productName)){
    		map.put("productName", productName);
    	}
    	List<Map<String, Object>> productList = statsProductService.productList(map);
    	Long size = (long) productList.size();
    	//分页实现
    	Page<Map<String, Object>> page = new Page<>();
    	Integer pageSizeValue = null;
		if (NumberUtils.isNumber(pageSize)) {
			pageSizeValue = NumberUtils.toInt(pageSize);
			page.setPageSize(pageSizeValue);
		}
		Integer pageNoValue = null;
		if (NumberUtils.isNumber(pageNo)) {
			pageNoValue = NumberUtils.toInt(pageNo);
			page.setPageNo(pageNoValue);
		}
		page.setResult(productList);
    	page.setTotalRecordCount(size);
    	Map<String, Object>  pageResult = new HashMap<>();
    	pageResult.put("page", page);
        return result.fill(JsonResponseMsg.CODE_SUCCESS, "成功",pageResult);
    }
}
