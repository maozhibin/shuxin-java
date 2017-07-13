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
	public ModelAndView UserList(String name, String mobile, String typeId, String pageNo, String pageSize) {
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
	@ResponseBody
	@RequestMapping("detail")
	public JsonResponseMsg detail(String id) {
		JsonResponseMsg result = new JsonResponseMsg();
		if (!NumberUtils.isNumber(id)) {
			return result.fill(JsonResponseMsg.CODE_FAIL, "参数错误");
		}
		User user = userService.findByIdUserInfo(NumberUtils.toLong(id));
		if (user == null) {
			return result.fill(JsonResponseMsg.CODE_FAIL, "查询的用户信息不存在");
		}
		Map<String, Object> map = new HashMap<>();
		map.put("user", user);
		return result.fill(JsonResponseMsg.CODE_SUCCESS, "查询成功", map);

	}

	/**
	 * 删除用户
	 */
	@ResponseBody
	@RequestMapping("delete")
	public JsonResponseMsg delete(String id) {
		JsonResponseMsg result = new JsonResponseMsg();
		if (!NumberUtils.isNumber(id)) {
			return result.fill(JsonResponseMsg.CODE_FAIL, "参数错误");
		}
		Long idValue = NumberUtils.toLong(id);
		Boolean isSuccess = userService.deleteUser(idValue);
		if (isSuccess) {
			return result.fill(JsonResponseMsg.CODE_SUCCESS, "删除成功");
		}
		return result.fill(JsonResponseMsg.CODE_FAIL, "删除失败");
	}

	/**
	 * 用户资金变动记录
	 */
	@ResponseBody
	@RequestMapping("moneyChange")
	public JsonResponseMsg moneyChange(String userId, String startTime, String endTime, String pageNo,
			String pageSize) {
		JsonResponseMsg result = new JsonResponseMsg();
		if (!NumberUtils.isNumber(userId)) {
			return result.fill(JsonResponseMsg.CODE_FAIL, "参数错误");
		}
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
		Map<String, Object> map = new HashMap<>();
		map.put("page",page);
		return result.fill(JsonResponseMsg.CODE_SUCCESS, "查询成功", map);
	}
}
