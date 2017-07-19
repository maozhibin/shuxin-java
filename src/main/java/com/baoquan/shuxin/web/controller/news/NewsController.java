package com.baoquan.shuxin.web.controller.news;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.model.config.Config;
import com.baoquan.shuxin.model.news.News;
import com.baoquan.shuxin.model.news.Option;
import com.baoquan.shuxin.service.spi.news.NewsService;
import com.baoquan.shuxin.service.spi.news.OptionService;
import com.baoquan.shuxin.util.JsonResponseMsg;

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

    @Inject
    private OptionService optionService;

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
        List<Option> options = optionService.queryOptionInfo();
        List<Option> flow = optionService.queryOptionInfo();
        page = newsService.queryNewInfo(newsClassType, page);

        mv.addObject(page);
        mv.addObject("options",options);
        mv.addObject("flow",flow);
        return mv;
    }

    /**
    * @Description:  删除用户
    * @param
    * @return
    * @throws
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
        if (news == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("news", news);
        mv.addObject(news);
        return mv;

    }

    /**
     * 编辑
     */
    @RequestMapping("update")
    public ModelAndView page(String id){
        ModelAndView mv = new ModelAndView("admin/news/add");
        if(NumberUtils.isNumber(id)){
            News news =newsService.updateNews(NumberUtils.toInt(id));
            mv.addObject(news);
        }
        return mv;
    }


    /**
     * 修改新闻 添加新闻
     * @param id
     * @param newsClassType
     * @param title
     * @param source
     * @param author
     * @param top
     * @param isDisplay
     * @param keywords
     * @param content
     * @return
     */
    @RequestMapping("updateAndAdd")
    public String updateAndAdd(String id,String newsClassType,String title,String source,String author,
            Integer top,Integer isDisplay, String keywords,String content){
        if(StringUtils.isEmpty(newsClassType)){
            return null;
        }
        if(StringUtils.isEmpty(title)){
            return null;
        }
        News news = new News();
        news.setNewsClassType(newsClassType);
        news.setTitle(title);
        news.setSource(source);
        news.setAuthor(author);
        news.setTop(top);
        news.setIsDisplay(isDisplay);
        news.setKeywords(keywords);
        news.setContent(content);

        if(NumberUtils.isNumber(id)){
            news.setId(NumberUtils.toInt(id));
            newsService.updateAndAddNews(news);
        }else{
            newsService.insertNews(news);
        }
        return "redirect:list";
    }



    @RequestMapping("issue")
    public Object issue() {
        return "admin/news/add";
    }

}
