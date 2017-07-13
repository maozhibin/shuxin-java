package com.baoquan.shuxin.web.controller.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.model.config.Config;
import com.baoquan.shuxin.service.spi.config.ConfigService;
import com.baoquan.shuxin.util.JsonResponseMsg;

@Controller
@RequestMapping("config")
public class ConfigController {
	@Inject
	private ConfigService configService;
	
	/**
	 * 配置参数列表
	 */
	@RequestMapping("list")
	@ResponseBody
	public JsonResponseMsg configList(String pageNo, String pageSize){
		JsonResponseMsg result = new JsonResponseMsg();
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
		Map<String, Object> map = new HashMap<>();
		map.put("page", page);
		return result.fill(JsonResponseMsg.CODE_SUCCESS, "查询成功",map);
	}
	
	/**
	 * 配置参数修改或者添加
	 */
	@RequestMapping("updateOrAdd")
	@ResponseBody
	public JsonResponseMsg updateOrAdd(String id,String varname,String value,String memo){
		JsonResponseMsg result = new JsonResponseMsg();
		if(StringUtils.isEmpty(varname)){
			return result.fill(JsonResponseMsg.CODE_FAIL,"变量名不能为空");
		}
		if(StringUtils.isEmpty(value)){
			return result.fill(JsonResponseMsg.CODE_FAIL,"变量值不能为空");
		}
		Config config = new Config();
		config.setMemo(memo);
		config.setVarname(varname);
		config.setValue(value);
		if(NumberUtils.isNumber(id)){
			config.setId(NumberUtils.toInt(id));
			configService.updateConfig(config);
		}else{
			config.setMemo(memo);
			config.setVarname(varname);
			config.setValue(value);
			configService.insertConfig(config);
		}
		return result.fill(JsonResponseMsg.CODE_SUCCESS,"success");
	}
	
}
