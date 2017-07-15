package com.baoquan.shuxin.web.controller.news;

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
import com.baoquan.shuxin.model.news.News;
import com.baoquan.shuxin.model.user.User;
import com.baoquan.shuxin.model.user.UserMoneyLog;
import com.baoquan.shuxin.service.spi.news.NewsService;
import com.baoquan.shuxin.util.JsonResponseMsg;
import com.baoquan.shuxin.util.common.DateUtil;

/**
 * Author:Zhoumc
 * Description: 新闻
 * DATA:13:06 ${DATA}
 */

@RequestMapping("/news")
@Controller
public class NewsController {

    @Inject
    private NewsService newsService;

    /**
     * 分页查询新闻信息
     * @param newsClassType 类别
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("list")
    public ModelAndView newsList(String newsClassType, String pageNo, String pageSize) {
        ModelAndView mv = new ModelAndView("admin/news/list");
        Page<News> page = new Page<News>();
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
        page = newsService.queryNewInfo(newsClassType, page);
        mv.addObject(page);
        return mv;
    }

    /**
     * 删除新闻
     */
    @ResponseBody
    @RequestMapping("delete")
    public JsonResponseMsg del(String id) {
        JsonResponseMsg result = new JsonResponseMsg();
        if (!NumberUtils.isNumber(id)) {
            return result.fill(JsonResponseMsg.CODE_FAIL, "参数错误");
        }
        Long idN = NumberUtils.toLong(id);
        Boolean isSuccess = newsService.delNews(idN);
        if (isSuccess) {
            return result.fill(JsonResponseMsg.CODE_SUCCESS, "删除成功");
        }
        return result.fill(JsonResponseMsg.CODE_FAIL, "删除失败");
    }

    /**
     * 新闻详情
     */
    @RequestMapping("newsdetail")
    public ModelAndView newDetail(String id) {
        ModelAndView mv = new ModelAndView("admin/news/detail");
        if (!NumberUtils.isNumber(id)) {
            return null;
        }
        News news = newsService.queryNewsDetails(NumberUtils.toLong(id));
        if (news == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("news", news);
        mv.addObject(news);
        return mv;

    }

    @RequestMapping("issue")
    public Object issue() {
        return "admin/news/add";
    }

}
