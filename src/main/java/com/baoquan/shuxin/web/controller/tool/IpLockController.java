package com.baoquan.shuxin.web.controller.tool;

import javax.inject.Inject;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.constatn.IpConstant;
import com.baoquan.shuxin.model.ipLock.IpLock;
import com.baoquan.shuxin.service.spi.ipLock.IpLockService;
@Controller
@RequestMapping("tools/ip")
public class IpLockController{
	@Inject
	private IpLockService ipLockService;
	
	/**
	 * ip锁定列表列表
	 */
	@RequestMapping("list")
	public ModelAndView ipFlowInfo(Integer pageNo, Integer pageSize) {
		if (pageNo == null || pageNo < 1) pageNo = 1;
		if (pageSize == null || pageSize > Page.DEFAULT_PAGE_SIZE) pageSize = Page.DEFAULT_PAGE_SIZE;
		ModelAndView mv = new ModelAndView("admin/tools/ipList");
		Page<IpLock> page = new Page<>();
		page.setPageSize(pageSize);
		page.setPageNo(pageNo);
		page=ipLockService.ipLockList(page);
		mv.addObject(page);
		return mv;
	}
	
	/**
	 * ip解锁
	 */
	@RequestMapping("debLockingIp")
	public String debLockingIp(String id){
		if(!NumberUtils.isNumber(id)){
			return null;
		}
		Integer idValue = NumberUtils.toInt(id);
		IpLock ipLock=ipLockService.findById(idValue);
		if(ipLock==null){
			return null;
		}
		ipLock.setStatus(IpConstant.DEBLOCKING);
		ipLockService.debLockingIp(ipLock);
		return "redirect:list";
	}
}
