package com.baoquan.shuxin.web.controller.user;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.model.user.UserMoneyLog;
import com.baoquan.shuxin.model.user.User;
import com.baoquan.shuxin.service.spi.user.UserMoneyLogService;
import com.baoquan.shuxin.service.spi.user.UserService;
import com.baoquan.shuxin.util.JsonResponseMsg;
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
	public ModelAndView userList(String name, String mobile, String typeId, String pageNo, String pageSize) {
		ModelAndView mv = new ModelAndView("admin/user/list");
		Page<User> page = new Page<User>();
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
		page = userService.findListUser(name, mobile, typeId, page);
		mv.addObject(page);
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
	public ModelAndView moneyChange(String userId, String startTime, String endTime, String pageNo,
			String pageSize) {
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
		page = userMoneyLogService.byIdFinduserMoneyChange(page, endTimeValue, startTimeValue,
				NumberUtils.toLong(userId));
		mv.addObject(page);
		return mv;
	}
}
