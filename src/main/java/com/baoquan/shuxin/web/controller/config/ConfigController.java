package com.baoquan.shuxin.web.controller.config;


import javax.inject.Inject;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.model.config.Config;
import com.baoquan.shuxin.service.spi.config.ConfigService;

@Controller
@RequestMapping("config")
public class ConfigController {
	@Inject
	private ConfigService configService;
	
	/**
	 * 配置参数列表
	 */
	@RequestMapping("list")
	public ModelAndView configList(String pageNo, String pageSize){
		ModelAndView mv = new ModelAndView("admin/config/list");
		Page<Config> page = new Page<>();
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
		page=configService.configList(page);
		mv.addObject(page);
		return mv;
	}
	
	/**
	 * 配置参数修改或者添加
	 */
	@RequestMapping("updateOrAdd")
	public String updateOrAdd(String id,String varname,String valueName,String memo){
		if(StringUtils.isEmpty(varname)){
			return null;
		}
		if(StringUtils.isEmpty(valueName)){
			return null;
		}
		Config config = new Config();
		config.setMemo(memo);
		config.setVarname(varname);
		config.setValue(valueName);
		if(NumberUtils.isNumber(id)){
			config.setId(NumberUtils.toInt(id));
			configService.updateConfig(config);
		}else{
			configService.insertConfig(config);
		}
		return "redirect:list";
	}
	
	/**
	 * 跳转到编辑页面或者新增页面
	 */
	@RequestMapping("skip")
	public ModelAndView page(String id){
		ModelAndView mv = new ModelAndView("admin/config/addOrEdit");
		if(NumberUtils.isNumber(id)){
			Config config =configService.findByIdConfig(NumberUtils.toInt(id));
			mv.addObject(config);
		}
		return mv;
	}
}
