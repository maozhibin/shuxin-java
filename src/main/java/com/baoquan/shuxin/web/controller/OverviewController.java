package com.baoquan.shuxin.web.controller;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.constatn.OrgConstatnt;
import com.baoquan.shuxin.service.spi.product.StatsProductService;
import com.baoquan.shuxin.service.spi.stats.PlatformOverviewService;
import com.baoquan.shuxin.service.spi.stats.StatsOrgService;
import com.baoquan.shuxin.service.spi.user.UserMoneyLogService;
import com.baoquan.shuxin.web.vo.PlatformOverviewVO;
import com.google.common.collect.Maps;

/**
 * Desc:
 * Created by yongj on 7/15/2017,
 */
@Controller
@RequestMapping("/overview")
public class OverviewController {
	@Inject
	private StatsProductService statsProductService;
	@Inject
	private StatsOrgService statsOrgService;

	@Inject
	private PlatformOverviewService platformOverviewService;
	@Inject
	private UserMoneyLogService userMoneyLogService;
    @RequestMapping("/platform")
    public ModelAndView  platform() {
    	ModelAndView mv = new ModelAndView("admin/overview/platform");
    	Map<String, Object> params = Maps.newHashMap();
    	List<Map<String, Object>> productTop = statsProductService.productTop();
    	Map<String, Object> parms = new HashMap<>();
    	parms.put("type", OrgConstatnt.TOP_TEN_ORG);
    	List<Map<String, Object>> orgTop = statsOrgService.orgTopOrAll(parms);
    	params.put("productTop", productTop);
    	params.put("orgTop", orgTop);
    	mv.addObject(params);

    	addOverview(mv);
        return mv;
    }

    private void addOverview(ModelAndView mv) {
        Date now = new Date();
        Date today = DateUtils.truncate(now, Calendar.DATE);
        Date lastday = DateUtils.addDays(today, -1);

        PlatformOverviewVO today2now = platformOverviewService.queryByTime(today.getTime() / 1000,
                now.getTime() / 1000);
        PlatformOverviewVO lastdaySameTime = platformOverviewService.queryByTime(lastday.getTime() / 1000,
                DateUtils.addDays(now, -1).getTime() / 1000);
        setIncrementRate(today2now, lastdaySameTime);

        PlatformOverviewVO lastday2today = platformOverviewService.queryByTime(lastday.getTime() / 1000,
                today.getTime() / 1000);
        PlatformOverviewVO twodayBefore = platformOverviewService.queryByTime(
                DateUtils.addDays(lastday, -1).getTime() / 1000, lastday.getTime() / 1000);
        setIncrementRate(lastday2today, twodayBefore);


        double rate = 1.0* (today.getTime() - lastday.getTime()) / (now.getTime() - today.getTime());
        PlatformOverviewVO todayWhole = new PlatformOverviewVO();
        todayWhole.setTradeIncreaseRate(today2now.getTradeIncreaseRate());
        if (lastdaySameTime.getTradeAmount() != null && lastdaySameTime.getTradeAmount().doubleValue() > 0) {
            todayWhole.setTradeAmount(BigDecimal.valueOf(
                    today2now.getTradeAmount().doubleValue() / lastdaySameTime.getTradeAmount().doubleValue()
                            * lastday2today.getTradeAmount().doubleValue()).setScale(2, BigDecimal.ROUND_HALF_EVEN));
        } else {
            todayWhole.setTradeAmount(BigDecimal.valueOf(today2now.getTradeAmount().doubleValue() * rate).setScale(2,
                    BigDecimal.ROUND_HALF_EVEN));
        }
        if (lastdaySameTime.getOrderCount() > 0) {
            todayWhole.setOrderCount((long) (1.0 * today2now.getOrderCount() / lastdaySameTime.getOrderCount()
                    * lastday2today.getOrderCount()));
        } else {
            todayWhole.setOrderCount((long) (today2now.getOrderCount() * rate));
        }
        if (lastdaySameTime.getOrderCount() > 0) {
            todayWhole.setAttestCount((long) (1.0 * today2now.getAttestCount() / lastdaySameTime.getAttestCount()
                    * lastday2today.getAttestCount()));
        } else {
            todayWhole.setAttestCount((long) (today2now.getAttestCount() * rate));
        }
        if (lastdaySameTime.getOrderCount() > 0) {
            todayWhole.setAuthorizationCount(
                    (long) (1.0 * today2now.getAuthorizationCount() / lastdaySameTime.getAuthorizationCount()
                            * lastday2today.getAuthorizationCount()));
        } else {
            todayWhole.setAuthorizationCount((long) (today2now.getAuthorizationCount() * rate));
        }

        mv.addObject("today2now", today2now);
        mv.addObject("lastday", lastday2today);
        mv.addObject("todayWhole", todayWhole);
    }

    private void setIncrementRate(PlatformOverviewVO today, PlatformOverviewVO lastday) {
        if (lastday.getTradeAmount() != null && lastday.getTradeAmount().doubleValue() > 0) {
            today.setTradeIncreaseRate(BigDecimal.valueOf(
                    (today.getTradeAmount().doubleValue() - lastday.getTradeAmount().doubleValue())
                            / lastday.getTradeAmount().doubleValue() * 100).setScale(2, BigDecimal.ROUND_HALF_EVEN));
        } else {
            today.setTradeIncreaseRate(BigDecimal.valueOf(100));
        }
    }

    /**
     * 机构top10或者全部
     * @return
     */
    @RequestMapping("/organization")
    public ModelAndView organization(String orgName, Integer pageNo, Integer pageSize) {
		if (pageNo == null || pageNo < 1) pageNo = 1;
		if (pageSize == null || pageSize > Page.DEFAULT_PAGE_SIZE) pageSize = Page.DEFAULT_PAGE_SIZE;
		orgName = StringUtils.trimToNull(orgName);
    	ModelAndView mv = new ModelAndView("admin/overview/organization");
    	Map<String, Object> parms = new HashMap<>();
    	Page<Map<String, Object>> page = new Page<>();
    	parms.put("type", OrgConstatnt.TOP_TEN_ORG);
    	parms.put("page", page);
    	List<Map<String, Object>> orgTop = statsOrgService.orgTopOrAll(parms);
    	List<Map<String, Object>> orgList=null;
    	Long count = null;
    	//if(StringUtils.isEmpty(orgName)){
    	//	parms.put("type", OrgConstatnt.ALL_ORG);
    	//	orgList = statsOrgService.orgTopOrAll(parms);
    	//	count = statsOrgService.orgCount();
    	//}else{
    	//	orgList = statsOrgService.orgListByOrgName(orgName);
    	//	count = (long) orgList.size();
    	//}
		orgList = statsOrgService.orgListByOrgName(orgName);
    	if(!CollectionUtils.isEmpty(orgList)){
			count = (long) orgList.size();
		}
    	//分页实现
		page.setPageSize(pageSize);
		page.setPageNo(pageNo);
		page.setResult(orgList);

		page.setTotalRecordCount(orgList == null ? 0 : count);

    	Map<String, Object> params = Maps.newHashMap();
    	params.put("orgTop", orgTop);
    	mv.addObject(params);
    	mv.addObject(page);
    	mv.addObject("keywords", orgName);
        return mv;
    }

    /**
     * 产品top10列表或者全部
     * @return
     */
    @RequestMapping("/product")
    public ModelAndView product(String productName, Integer pageNo, Integer pageSize) {
		if (pageNo == null || pageNo < 1) pageNo = 1;
		if (pageSize == null || pageSize > Page.DEFAULT_PAGE_SIZE) pageSize = Page.DEFAULT_PAGE_SIZE;
		productName = StringUtils.trimToNull(productName);
    	ModelAndView mv = new ModelAndView("admin/overview/product");
    	List<Map<String, Object>> productTop = statsProductService.productTop();//top10产品
    	Map<String, Object> map = new HashMap<>();

    	//分页实现
		Page<Map<String, Object>> page = new Page<>();

		page.setPageSize(pageSize);
		page.setPageNo(pageNo);

		map.put("page",page);
    	List<Map<String, Object>> productList = null;
		Long size=(long)0;
		if(!StringUtils.isEmpty(productName)){
			map.put("productName", productName);
			productList = statsProductService.productList(map);
			size = statsProductService.productListCount(map);
		}
		page.setResult(productList);
		page.setTotalRecordCount(size);
    	Map<String, Object> params = Maps.newHashMap();
    	params.put("productTop", productTop);
    	mv.addObject(params);
    	mv.addObject(page);
    	mv.addObject("keywords", productName);
        return mv;
    }
    
    /**
	 * 用户资金今日,昨天,上周同期曲线记录
	 */
	@RequestMapping("moneyProfile")
	@ResponseBody
	public Object moneyProfile(@RequestParam("types") Integer[] types){
		Date now = new Date();
		 Date today = DateUtils.truncate(now, Calendar.DATE);
		Long time= null;
		Map<Object, Object> map = new HashMap<>();
		for (Integer type : types) {
			time = DateUtils.addDays(today, type).getTime();;
			Map<Object, Object> mapValue=userMoneyLogService.findByFinishTime(time);
			map.putAll(mapValue);
		}
		return map;
	}
	
	/**
	 * 圆形统计
	 */
	@RequestMapping("round")
	@ResponseBody
	public Object round(){
		List<Map<String, Object>> productTop = statsProductService.productTop();//top10产品
		Map<Object, Object> map = new HashMap<>();
		for (Map<String, Object> list : productTop) {
			map.put(list, list);
		}
		return map;
	}
}
