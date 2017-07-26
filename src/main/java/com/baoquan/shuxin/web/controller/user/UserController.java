package com.baoquan.shuxin.web.controller.user;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.model.user.UserMoneyLog;
import com.baoquan.shuxin.model.user.User;
import com.baoquan.shuxin.service.spi.user.UserMoneyLogService;
import com.baoquan.shuxin.service.spi.user.UserService;
import com.baoquan.shuxin.util.common.DateUtil;

/**
 * Created by Administrator on 2017/7/12.
 */
@Controller
@RequestMapping("user")
public class UserController {
	@Inject
	private UserService userService;
	@Inject
	private UserMoneyLogService userMoneyLogService;

	/**
	 * 查询用户列表
	 * 
	 * @param name
	 * @param mobile
	 * @param typeId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("list")
	public ModelAndView userList(String name, String mobile, String typeId, Integer pageNo, Integer pageSize) {
		if (pageNo == null || pageNo < 1) pageNo = 1;
		if (pageSize == null || pageSize > Page.DEFAULT_PAGE_SIZE) pageSize = Page.DEFAULT_PAGE_SIZE;
		name = StringUtils.trimToNull(name);
		mobile = StringUtils.trimToNull(mobile);
		ModelAndView mv = new ModelAndView("admin/user/list");
		Page<User> page = new Page<User>();
		page.setPageSize(pageSize);
		page.setPageNo(pageNo);
		page = userService.findListUser(name, mobile, typeId, page);
		mv.addObject(page);
		mv.addObject("name", name);
		mv.addObject("mobile", mobile);
		return mv;

	}

	/**
	 * 根据id查询用户信息
	 */
	@RequestMapping("detail")
	public ModelAndView detail(String id) {
		ModelAndView mv = new ModelAndView("admin/user/detail");
		if (!NumberUtils.isNumber(id)) {
			return null;
		}
		User user = userService.findByIdUserInfo(NumberUtils.toLong(id));
		if (user == null) {
			return null;
		}
		Map<String, Object> map = new HashMap<>();
		map.put("user", user);
		Long time = user.getLastLoginTime()*1000;
		String lastTime=DateUtil.stampToDate(time.toString());
		mv.addObject(user);
		mv.addObject(lastTime);
		return mv;

	}

	/**
	 * 删除用户
	 */
	@RequestMapping("delete")
	public String delete(String id) {
		if (!NumberUtils.isNumber(id)) {
			return null;
		}
		Long idValue = NumberUtils.toLong(id);
		Boolean isSuccess = userService.deleteUser(idValue);
		if (!isSuccess) {
			return null;
		}
		return "redirect:list";
	}

	/**
	 * 用户资金变动记录
	 */
	@RequestMapping("moneyChange")
	public ModelAndView moneyChange(String userId, String startTime, String endTime, Integer pageNo, Integer pageSize,String type) {
		//todo 搜索条件还差一个交易类型
		if (pageNo == null || pageNo < 1) pageNo = 1;
		if (pageSize == null || pageSize > Page.DEFAULT_PAGE_SIZE) pageSize = Page.DEFAULT_PAGE_SIZE;
		ModelAndView mv = new ModelAndView("admin/user/money");
		Long startTimeValue = null;
		if (!StringUtils.isEmpty(startTime)) {
			startTimeValue = DateUtil.dateToStamp(startTime) / 1000;
		}

		Long endTimeValue = null;
		if (!StringUtils.isEmpty(endTime)) {
			endTimeValue = DateUtil.dateToStamp(endTime) / 1000;
		}

		Page<UserMoneyLog> page = new Page<UserMoneyLog>();
		page.setPageSize(pageSize);
		page.setPageNo(pageNo);
		page = userMoneyLogService.byIdFinduserMoneyChange(page, endTimeValue, startTimeValue,
				NumberUtils.toLong(userId),type);
		mv.addObject(page);
		mv.addObject("startTime", startTime);
		mv.addObject("endTime", endTime);
		return mv;
	}
}
