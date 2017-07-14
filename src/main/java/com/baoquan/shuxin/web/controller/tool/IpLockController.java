package com.baoquan.shuxin.web.controller.tool;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.constatn.IpConstant;
import com.baoquan.shuxin.model.ipLock.IpLock;
import com.baoquan.shuxin.service.spi.ipLock.IpLockService;
import com.baoquan.shuxin.util.JsonResponseMsg;
@Controller
@RequestMapping("ip")
public class IpLockController{
	@Inject
	private IpLockService ipLockService;
	
	/**
	 * ip锁定列表列表
	 */
	@RequestMapping("list")
	@ResponseBody
	public JsonResponseMsg List(String pageNo, String pageSize){
		JsonResponseMsg result = new JsonResponseMsg();
		Page<IpLock> page = new Page<>();
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
		page=ipLockService.ipLockList(page);
		Map<String, Object> map = new HashMap<>();
		map.put("page", page);
		return result.fill(JsonResponseMsg.CODE_SUCCESS, "查询成功",map);
	}
	
	/**
	 * ip解锁
	 */
	@RequestMapping("debLockingIp")
	@ResponseBody
	public JsonResponseMsg debLockingIp(String id){
		JsonResponseMsg result = new JsonResponseMsg();
		if(!NumberUtils.isNumber(id)){
			return result.fill(JsonResponseMsg.CODE_FAIL,"参数错误");
		}
		Integer idValue = NumberUtils.toInt(id);
		IpLock ipLock=ipLockService.findById(idValue);
		if(ipLock==null){
			return result.fill(JsonResponseMsg.CODE_FAIL,"你修改的信息不存在");
		}
		ipLock.setStatus(IpConstant.DEBLOCKING);
		ipLockService.debLockingIp(ipLock);
		return result.fill(JsonResponseMsg.CODE_SUCCESS, "修改成功");
	}
}
