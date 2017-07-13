package com.baoquan.shuxin.web.controller.configController;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public JsonResponseMsg configList(){
		return null;
	}
}
