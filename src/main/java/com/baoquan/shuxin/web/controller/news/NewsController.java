package com.baoquan.shuxin.web.controller.news;

import java.util.ArrayList;
import java.util.Date;
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
import com.baoquan.shuxin.model.news.NewsVO;
import com.baoquan.shuxin.model.news.Option;
import com.baoquan.shuxin.service.spi.news.NewsService;
import com.baoquan.shuxin.service.spi.news.OptionService;
import com.baoquan.shuxin.util.JsonResponseMsg;
import com.sun.org.apache.bcel.internal.generic.NEW;

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
    public  Object newsList(String newsClassType, Integer pageNo, Integer pageSize) {
        ModelAndView mv = new ModelAndView("admin/news/list");

        if (pageNo == null || pageNo < 1)  pageNo = 1;
        if (pageSize == null || pageSize > 15) pageSize = 15;

        Page page = new Page();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);

        Integer newsCount = newsService.countNewsInfo(newsClassType);
        page.setTotalRecordCount(newsCount);
        if(newsCount > 0){
            List<News> newsList = newsService.queryNewsInfoList(newsClassType,(pageNo-1)*pageSize,pageSize);
            List<Option> optionList = optionService.queryOptionInfo();

            List<NewsVO> newsVOList = new ArrayList<>(newsList.size());
            for (News news : newsList){
                String typeName  = news.getNewsClassType();
                Option op = null;
                for(Option option : optionList){
                    if(typeName.equals(option.getValue())){
                        op = option;
                        break;
                    }
                }
                NewsVO nv = buildNewsInfo(news,op);
                newsVOList.add(nv);
            }
            page.setResult(newsVOList);
        }
        mv.addObject(page);
        mv.addObject("options",optionService.queryOptionInfo());
        return mv;
    }

    private  NewsVO buildNewsInfo(News news ,Option option){
        NewsVO newsVO = new NewsVO();
        newsVO.setId(news.getId());
        newsVO.setNewsClassType(option.getName());
        newsVO.setTitle(news.getTitle());
        if (news.getDateline() != null){
            newsVO.setDateline(new Date(news.getDateline()));
        }
        newsVO.setContent(news.getContent());
        newsVO.setAuthor(news.getAuthor());
        newsVO.setSource(news.getSource());
        newsVO.setDescription(news.getDescription());
        newsVO.setIsDisplay(news.getIsDisplay());
        newsVO.setImage(news.getImage());
        newsVO.setKeywords(news.getKeywords());
        newsVO.setViewCount(news.getViewCount());
        return newsVO;
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
        List<Option> optionList = optionService.queryOptionInfo();
        Option op = null;
        for (Option option : optionList){
            if(news.getNewsClassType().equals(option.getValue())){
                op = option;
                break;
            }
        }
        NewsVO newsVO = buildNewsInfo(news,op);
        mv.addObject("news",newsVO);
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
            mv.addObject("options",optionService.queryOptionInfo());
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
    public ModelAndView issue() {
        ModelAndView mv = new ModelAndView("admin/news/add");
        List<Option> options = optionService.queryOptionInfo();
        mv.addObject("options",options);
        return mv;
    }

}
