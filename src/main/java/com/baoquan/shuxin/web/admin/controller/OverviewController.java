package com.baoquan.shuxin.web.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.baoquan.shuxin.constatn.OrgConstatnt;
import com.baoquan.shuxin.service.spi.product.StatsProductService;
import com.baoquan.shuxin.service.spi.stats.StatsOrgService;
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
    public ModelAndView organization(String orgName) {
    	ModelAndView mv = new ModelAndView("admin/overview/organization");
    	List<Map<String, Object>> orgTop = statsOrgService.orgTopOrAll(OrgConstatnt.TOP_TEN_ORG);
    	List<Map<String, Object>> orgList=null;
    	if(StringUtils.isEmpty(orgName)){
    		orgList = statsOrgService.orgTopOrAll(OrgConstatnt.ALL_ORG);
    	}else{
    		orgList = statsOrgService.orgListByOrgName(orgName);
    	}
    	Map<String, Object> params = Maps.newHashMap();
    	params.put("orgTop", orgTop);
    	params.put("orgList", orgList);
    	mv.addObject(params);
        return mv;
    }
    
    /**
     * 产品top10列表或者全部
     * @return
     */
    @RequestMapping("/product")
    public ModelAndView product(String productName) {
    	ModelAndView mv = new ModelAndView("admin/overview/product");
    	List<Map<String, Object>> productTop = statsProductService.productTop();//top10产品
    	Map<String, Object> map = new HashMap<>();
    	if(!StringUtils.isEmpty(productName)){
    		map.put("productName", productName);
    	}
    	List<Map<String, Object>> productList = statsProductService.productList(map);
    	Map<String, Object> params = Maps.newHashMap();
    	params.put("productTop", productTop);
    	params.put("productList", productList);
    	mv.addObject(params);
        return mv;
    }

}
