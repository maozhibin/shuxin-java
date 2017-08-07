package com.baoquan.shuxin.web.controller.config;

import java.util.List;

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
	public ModelAndView configList(Integer pageNo, Integer pageSize) {
		ModelAndView mv = new ModelAndView("admin/config/list");

		if (pageNo == null || pageNo < 1)
			pageNo = 1;
		if (pageSize == null || pageSize > Page.DEFAULT_PAGE_SIZE)
			pageSize = Page.DEFAULT_PAGE_SIZE;
		Page<Config> page = new Page<>();
		page.setPageSize(pageSize);
		page.setPageNo(pageNo);
		Integer configCount = configService.countConfigInfo();
		page.setTotalRecordCount(configCount);
		if (configCount > (pageNo - 1) * pageSize) {
			List<Config> configList = configService.configList(page);
			page.setResult(configList);
		}

		mv.addObject(page);
		return mv;
	}

	/**
	 * 配置参数修改
	 */
	@RequestMapping("update")
	@ResponseBody
	public JsonResponseMsg updateConfig(String id, String varname, String valueName, String memo) {
		JsonResponseMsg result = new JsonResponseMsg();
		if (StringUtils.isEmpty(varname)) {
			return result.fill(JsonResponseMsg.CODE_FAIL, "请填写变量名");
		}
		if (StringUtils.isEmpty(valueName)) {
			return result.fill(JsonResponseMsg.CODE_FAIL, "请填写变量值");
		}
		
		Config config = configService.findByIdConfig(NumberUtils.toInt(id));
		if (!config.getVarname().equals(varname)) {
			config.setMemo(memo);
			boolean queryByVarname = configService.queryByVarname(varname);
			if(!queryByVarname){
				return result.fill(JsonResponseMsg.CODE_FAIL, "你的变量名已经存在请重新命名");
			}
		}
		config.setVarname(varname);
		config.setValue(valueName);
		configService.updateConfig(config);
		return result.fill(JsonResponseMsg.CODE_SUCCESS, "修改成功");
	}

	/**
	 * 配置参数添加
	 */
	@RequestMapping("add")
	@ResponseBody
	public JsonResponseMsg addConfig( String varname, String valueName, String memo) {
		JsonResponseMsg result = new JsonResponseMsg();
		if (StringUtils.isEmpty(varname)) {
			return result.fill(JsonResponseMsg.CODE_FAIL, "请填写变量名");
		}
		if (StringUtils.isEmpty(valueName)) {
			return result.fill(JsonResponseMsg.CODE_FAIL, "请填写变量值");
		}
		boolean queryByVarname = configService.queryByVarname(varname);
		if(!queryByVarname){
			return result.fill(JsonResponseMsg.CODE_FAIL, "你的变量名已经存在请重新命名");
		}
		Config config = new Config();
		config.setMemo(memo);
		config.setVarname(varname);
		config.setValue(valueName);
		config.setIsValid(true);
		configService.insertConfig(config);
		return result.fill(JsonResponseMsg.CODE_SUCCESS, "修改成功");
	}

	/**
	 * 跳转到编辑页面或者新增页面
	 */
	@RequestMapping("skip")
	public ModelAndView page(String id) {
		ModelAndView mv = new ModelAndView("admin/config/addOrEdit");
		if (NumberUtils.isNumber(id)) {
			Config config = configService.findByIdConfig(NumberUtils.toInt(id));
			mv.addObject(config);
		}
		return mv;
	}

	/**
	 * 删除配置
	 */
	@RequestMapping("delete")
	public String delete(String id) {
		if (!NumberUtils.isNumber(id)) {
			return null;
		}
		Config config = configService.findByIdConfig(NumberUtils.toInt(id));
		if (config == null) {
			return null;
		}
		config.setIsValid(false);
		configService.deleteConfig(config);
		return "redirect:list";
	}
}
