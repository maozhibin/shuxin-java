package com.baoquan.shuxin.web.controller.news;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.model.config.Config;
import com.baoquan.shuxin.model.news.News;
import com.baoquan.shuxin.model.news.NewsVO;
import com.baoquan.shuxin.model.news.Option;
import com.baoquan.shuxin.service.spi.news.NewsService;
import com.baoquan.shuxin.service.spi.news.OptionService;
import com.baoquan.shuxin.util.JsonResponseMsg;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * Author:Zhoumc Description: 新闻 DATA:13:06 ${DATA}
 */

@RequestMapping("/news")
@Controller
public class NewsController {

	@Inject
	private NewsService newsService;

	@Inject
	private OptionService optionService;

	/**
	 * 分页查询新闻信息
	 * 
	 * @param newsClassType
	 *            类别
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("list")
	public Object newsList(String type, Integer pageNo, Integer pageSize) {
		ModelAndView mv = new ModelAndView("admin/news/list");

		if (pageNo == null || pageNo < 1)
			pageNo = 1;
		if (pageSize == null || pageSize > Page.DEFAULT_PAGE_SIZE)
			pageSize = Page.DEFAULT_PAGE_SIZE;
		Page<News> page = new Page<>();
		page.setPageSize(pageSize);
		page.setPageNo(pageNo);
		List<News> queryNewsInfoList = newsService.queryNewsInfoList(type,page);
		page.setResult(queryNewsInfoList);
		mv.addObject("type",type);
		mv.addObject(page);
		return mv;
	}

	/**
	 * @Description: 删除用户 @param @return @throws
	 */
	@RequestMapping("delete")
	public String del(String id) {
		if (!NumberUtils.isNumber(id)) {
			return null;
		}
		Long idN = NumberUtils.toLong(id);
		Boolean isSuccess = newsService.delNews(idN);
		if (!isSuccess) {
			return null;
		}
		return "redirect:list";
	}

	/**
	 * 新闻详情
	 */
	@RequestMapping("detail")
	public ModelAndView newDetail(String id) {
		ModelAndView mv = new ModelAndView("admin/news/detail");
		if (!NumberUtils.isNumber(id)) {
			return null;
		}
		News news = newsService.queryNewsDetails(NumberUtils.toLong(id));
		mv.addObject("news", news);
		return mv;

	}

	/**
	 * 编辑
	 */
	@RequestMapping("update")
	public ModelAndView page(String id) {
		ModelAndView mv = new ModelAndView("admin/news/add");
		if (NumberUtils.isNumber(id)) {
			News news = newsService.updateNews(NumberUtils.toLong(id));
			Map<String, Object> map = new HashedMap();
			map.put("options", optionService.queryOptionInfo());
			map.put("news", news);
			mv.addObject(map);
		}
		return mv;
	}

	/**
	 * 修改新闻 添加新闻
	 */
	@RequestMapping("updateAndAdd")
	@ResponseBody
	public JsonResponseMsg updateAndAdd(String id, String newsClassType, String title, String source, String author,
			String top, String isDisplay, String image, String keywords, String content) {
		JsonResponseMsg result = new JsonResponseMsg();
		// 获取系统时间戳
		Long dateline = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
		String time = df.format(new Date());
		Timestamp createTime = Timestamp.valueOf(time);
		dateline = createTime.getTime() / 1000;
		News news = new News();
		if (!NumberUtils.isNumber(newsClassType)) {
			return result.fill(JsonResponseMsg.CODE_FAIL, "类型为空");
		}
		news.setNewsClassType(NumberUtils.toInt(newsClassType));
		if (StringUtils.isEmpty(title)) {
			return result.fill(JsonResponseMsg.CODE_FAIL, "标题为空");
		}
		news.setTitle(title);
		if (StringUtils.isEmpty(source)) {
			return result.fill(JsonResponseMsg.CODE_FAIL, "来源为空");
		}
		news.setSource(source);
		if (StringUtils.isEmpty(author)) {
			return result.fill(JsonResponseMsg.CODE_FAIL, "作者为空");
		}
		news.setAuthor(author);
		if (!NumberUtils.isNumber(top)) {
			return result.fill(JsonResponseMsg.CODE_FAIL, "请选择是否置顶");
		}
		news.setTop(NumberUtils.toInt(top));
		if (StringUtils.isEmpty(image)) {
			return result.fill(JsonResponseMsg.CODE_FAIL, "请上传图片");
		}
		news.setImage(image);
		if (!NumberUtils.isNumber(isDisplay)) {
			return result.fill(JsonResponseMsg.CODE_FAIL, "请选择是否展示");
		}
		news.setIsDisplay(NumberUtils.toInt(isDisplay));
		if (StringUtils.isEmpty(keywords)) {
			return result.fill(JsonResponseMsg.CODE_FAIL, "网易关键词为空");
		}
		news.setKeywords(keywords);
		if (StringUtils.isEmpty(content)) {
			return result.fill(JsonResponseMsg.CODE_FAIL, "内容为空");
		}
		news.setContent(content);
		news.setDateline(dateline);
		if (NumberUtils.isNumber(id)) {
			news.setId(NumberUtils.toInt(id));
			newsService.updateAndAddNews(news);
		} else {
			newsService.insertNews(news);
		}
		return result.fill(JsonResponseMsg.CODE_SUCCESS, "success");
	}

	/**
	 * 新闻发布
	 */
	@RequestMapping("issue")
	public ModelAndView issue() {
		ModelAndView mv = new ModelAndView("admin/news/add");
		List<Option> options = optionService.queryOptionInfo();
		Map<String, Object> map = new HashedMap();
		map.put("options", options);
		mv.addObject(map);
		return mv;
	}

}
