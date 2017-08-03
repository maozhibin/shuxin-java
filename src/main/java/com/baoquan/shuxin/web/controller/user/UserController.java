package com.baoquan.shuxin.web.controller.user;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.constatn.UserConstant;
import com.baoquan.shuxin.model.user.User;
import com.baoquan.shuxin.model.user.UserMoneyLog;
import com.baoquan.shuxin.service.spi.user.UserMoneyLogService;
import com.baoquan.shuxin.service.spi.user.UserService;
import com.baoquan.shuxin.util.JsonResponseMsg;
import com.baoquan.shuxin.util.common.DateUtil;
import com.baoquan.shuxin.util.common.Stringutil;

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
		if (pageNo == null || pageNo < 1)
			pageNo = 1;
		if (pageSize == null || pageSize > Page.DEFAULT_PAGE_SIZE)
			pageSize = Page.DEFAULT_PAGE_SIZE;
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
		mv.addObject("typeId", typeId);
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
		Long time = user.getLastLoginTime() * 1000;
		String lastTime = DateUtil.stampToDate(time.toString());
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
	public ModelAndView moneyChange(String userId, String startTime, String endTime, Integer pageNo, Integer pageSize,
			String type) {
		// todo 搜索条件还差一个交易类型
		if (pageNo == null || pageNo < 1)
			pageNo = 1;
		if (pageSize == null || pageSize > Page.DEFAULT_PAGE_SIZE)
			pageSize = Page.DEFAULT_PAGE_SIZE;
		ModelAndView mv = new ModelAndView("admin/user/money");
		Long startTimeValue = null;
		Long time = System.currentTimeMillis();
		if (!StringUtils.isEmpty(startTime)) {
			startTimeValue = DateUtil.zero(startTime) / 1000;
		} else {
			startTimeValue = time;
			startTime = DateUtil.stampToDateY(time.toString());
		}

		Long endTimeValue = null;
		if (!StringUtils.isEmpty(endTime)) {
			endTimeValue = DateUtil.twelve(endTime) / 1000;
		} else {
			endTimeValue = time;
			endTime = DateUtil.stampToDateY(time.toString());
		}

		Page<UserMoneyLog> page = new Page<UserMoneyLog>();
		page.setPageSize(pageSize);
		page.setPageNo(pageNo);
		page = userMoneyLogService.byIdFinduserMoneyChange(page, endTimeValue, startTimeValue,
				NumberUtils.toLong(userId), type);
		mv.addObject(page);
		mv.addObject("typeValue", type);
		mv.addObject("startTime", startTime);
		mv.addObject("endTime", endTime);
		return mv;
	}

	/**
	 * 添加或者修改页面跳转
	 */
	@RequestMapping("skip")
	public ModelAndView skip(String id) {
		ModelAndView mv = new ModelAndView("admin/user/addOrEdit");
		if (NumberUtils.isNumber(id)) {
			User user = userService.findByIdUserInfo(NumberUtils.toLong(id));
			mv.addObject("user", user);
		}
		return mv;
	}

	@RequestMapping("add")
	@ResponseBody
	public JsonResponseMsg addUser(String orgName, String moneyFreeze, String moneyBalance, String mobile, String email,
			String realName, String orgCode) {
		JsonResponseMsg result = new JsonResponseMsg();
		if (StringUtils.isEmpty(orgName)) {
			return result.fill(JsonResponseMsg.CODE_FAIL, "请输入用户名");
		}
		if (!Stringutil.isChinaPhoneLegal(mobile)) {
			return result.fill(JsonResponseMsg.CODE_FAIL, "请输入正确的手机号码");
		}
		if (!NumberUtils.isNumber(moneyBalance)) {
			return result.fill(JsonResponseMsg.CODE_FAIL, "请传入正确用户账户余额");
		}
		if (!Stringutil.isEmail(email)) {
			return result.fill(JsonResponseMsg.CODE_FAIL, "请输入正确邮箱");
		}
		if (StringUtils.isEmpty(realName)) {
			return result.fill(JsonResponseMsg.CODE_FAIL, "请输入机构实名");
		}
		if (StringUtils.isEmpty(orgCode)) {
			return result.fill(JsonResponseMsg.CODE_FAIL, "请输入机构统一社会信用编码");
		}
		User user = new User();
		user.setPassword("$2y$10$bSp7VZPvuLgP46eLrMdU4OPHG3rZZhCqTT1sIJ8tfDFjyHuChe.U2");
		BigDecimal moneyBalanceValue = new BigDecimal(moneyBalance);
		user.setMoneyBalance(moneyBalanceValue);
		user.setEmail(email);
		user.setRealName(realName);
		user.setMobile(mobile);
		user.setOrgCode(orgCode);
		user.setUsername(orgName);
		user.setTypeId(UserConstant.ORG);
		if (!userService.isValidUserName(orgName)) {
			return result.fill(JsonResponseMsg.CODE_FAIL, "你输入的用户名已经被使用了请重新输入");
		}

		if (!userService.findByMobileUserIdfo(mobile)) {
			return result.fill(JsonResponseMsg.CODE_FAIL, "你输入的手机号已经被使用过了");
		}
		userService.addUser(user);
		return result.fill(JsonResponseMsg.CODE_SUCCESS, "SUCCESS");
	}

	@RequestMapping("update")
	@ResponseBody
	public JsonResponseMsg updateUser(String id, String moneyFreeze, String moneyBalance, String mobile, String email,
			String realName, String orgCode) {
		JsonResponseMsg result = new JsonResponseMsg();
		if (!Stringutil.isChinaPhoneLegal(mobile)) {
			return result.fill(JsonResponseMsg.CODE_FAIL, "请输入正确的手机号码");
		}
		if (!NumberUtils.isNumber(moneyBalance)) {
			return result.fill(JsonResponseMsg.CODE_FAIL, "请传入正确用户账户余额");
		}
		if (!Stringutil.isEmail(email)) {
			return result.fill(JsonResponseMsg.CODE_FAIL, "请输入正确邮箱");
		}
		if (StringUtils.isEmpty(realName)) {
			return result.fill(JsonResponseMsg.CODE_FAIL, "请输入机构实名");
		}
		if (StringUtils.isEmpty(orgCode)) {
			return result.fill(JsonResponseMsg.CODE_FAIL, "请输入机构统一社会信用编码");
		}
		if (!NumberUtils.isNumber(id)) {
			return result.fill(JsonResponseMsg.CODE_FAIL, "参数错误");
		}
		User user = userService.findByIdUserInfo(NumberUtils.toLong(id));
		if (user == null) {
			return result.fill(JsonResponseMsg.CODE_FAIL, "你查询的账号信息不存在");
		}
		String telPhone = user.getMobile();
		if (!mobile.equals(telPhone)) {
			if (userService.findByMobileUserIdfo(mobile)) {
				user.setMobile(telPhone);
			} else {
				return result.fill(JsonResponseMsg.CODE_FAIL, "这个手机已经被使用了请换个手机号码");
			}
		}
		
		BigDecimal moneyBalanceValue = new BigDecimal(moneyBalance);
		user.setMoneyBalance(moneyBalanceValue);
		user.setEmail(email);
		user.setRealName(realName);
		user.setMobile(mobile);
		user.setOrgCode(orgCode);
		user.setTypeId(UserConstant.ORG);

		userService.updateUser(user);
		return result.fill(JsonResponseMsg.CODE_SUCCESS, "SUCCESS");
	}
}
