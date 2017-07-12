package com.baoquan.shuxin;

/*
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

/**
 * 使用注解的方式来扫描API 无需在Spring的xml配置文件来配置，由 @see @EnableWebMvc 代替
 * 
 * @version 0.0.1
 * @date 2015年4月26日 下午1:18:48
 */
// @Configuration
// @EnableWebMvc
// @EnableSwagger
public class SpringfoxConfig extends WebMvcConfigurerAdapter {

	/**
	 * Project Name
	 */
	public static String PROJECT_NAME;

	static {
		String projectName = System.getProperty("user.dir");
		if (projectName.contains("kafujia")) {
			int end = projectName.indexOf(File.separator, projectName.indexOf("kafujia"));
			PROJECT_NAME = projectName.substring(
					projectName.lastIndexOf(File.separator, projectName.indexOf("kafujia")) + 1,
					end == -1 ? projectName.length() : end);
		} else {
			PROJECT_NAME = "maven_ssh_demo";
		}
	}

	private SpringSwaggerConfig springSwaggerConfig;

	@Autowired
	public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
		this.springSwaggerConfig = springSwaggerConfig;
	}

	/**
	 * 链式编程 来定制API样式 后续会加上分组信息
	 * 
	 * @return
	 */
	@Bean
	public SwaggerSpringMvcPlugin customImplementation() {
		return new SwaggerSpringMvcPlugin(this.springSwaggerConfig).apiInfo(apiInfo()).includePatterns(".*")
				.apiVersion("0.0.1");
		// .swaggerGroup(PROJECT_NAME);
	}

	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo(PROJECT_NAME + " API", PROJECT_NAME + " 后台API文档",
				"http://192.168.3.102:8080/data-server", "niuxp@kafujia.com", "MTA License", "MTA API License URL");
		return apiInfo;
	}
}