package com.baoquan.shuxin.web.controller.area;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baoquan.shuxin.model.area.Area;
import com.baoquan.shuxin.service.spi.area.AreaService;

/**
 * Created by Administrator on 2017/7/20.
 */
@Controller
@RequestMapping("area")
public class AreaController {
	@Inject
	private AreaService areaService;
	
	/**
	 * 根据省份查找城市
	 * @param pid
	 * @return
	 */
	@RequestMapping("city")
	@ResponseBody
	public Object cityList(String pid){
		if(!NumberUtils.isNumber(pid)){
			return null;
		}
		List<Area> list = areaService.findByPid(NumberUtils.toInt(pid));
		return list;
	}

}
