package com.baoquan.shuxin.web.admin.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
    	List<Map<String, Object>> orgTop = statsOrgService.orgTop();
    	params.put("productTop", productTop);
    	params.put("orgTop", orgTop);
    	mv.addObject(params);
        return mv;
    }

    @RequestMapping("/organization")
    public ModelAndView organization() {
    	ModelAndView mv = new ModelAndView("admin/overview/organization");
    	List<Map<String, Object>> orgTop = statsOrgService.orgTop();
    	mv.addObject(orgTop);
        return mv;
    }

    @RequestMapping("/product")
    public ModelAndView product() {
    	ModelAndView mv = new ModelAndView("admin/overview/product");
    	List<Map<String, Object>> productTop = statsProductService.productTop();
    	mv.addObject(productTop);
        return mv;
    }

}
