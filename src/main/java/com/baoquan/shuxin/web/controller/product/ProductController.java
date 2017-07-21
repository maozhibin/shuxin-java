package com.baoquan.shuxin.web.controller.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.model.area.Area;
import com.baoquan.shuxin.model.product.ProductBase;
import com.baoquan.shuxin.model.product.ProductClass;
import com.baoquan.shuxin.model.user.User;
import com.baoquan.shuxin.service.spi.area.AreaService;
import com.baoquan.shuxin.service.spi.product.ProductBaseService;
import com.baoquan.shuxin.service.spi.product.ProductClassService;
import com.baoquan.shuxin.service.spi.product.ProductService;
import com.baoquan.shuxin.service.spi.user.UserService;
import com.baoquan.shuxin.util.JsonResponseMsg;

@Controller
@RequestMapping("product")
public class ProductController {
    private final static Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Inject
    private ProductService productService;
    @Inject
    private ProductClassService productClassService;
    @Inject
    private ProductBaseService productBaseService;
    @Inject
    private AreaService areaService;
    @Inject
    private UserService userService;
    /**
     * 产品列表
     * @param name
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("list")
    public ModelAndView list(String name,String pageNo, String pageSize) {
    	ModelAndView mv = new ModelAndView("admin/product/list");
    	Page<Map<String, Object>> page = new Page<Map<String,Object>>();
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
		page = productService.findListProduct(page,name);
		mv.addObject(page);
		return mv;
    }

    @RequestMapping("issue")
    public ModelAndView issue(@RequestBody(required = false) String content) {
        logger.info(content);
        ModelAndView mv = new ModelAndView("admin/product/issue");
        List<ProductClass> productClassList= productClassService.findAllClassList();
        List<Area> provinceList = areaService.findProvince();
        List<User> userList = userService.userList();
        Map<String, Object> map = new HashMap<>();
        map.put("provinceList", provinceList);
        map.put("productClassList", productClassList);
        map.put("userList", userList);
        mv.addObject(map);
        return mv;
    }
    /**
     * 查询子类性
     */
    @RequestMapping("base")
    @ResponseBody
    public Object ProductBase(String id){
    	JsonResponseMsg result = new JsonResponseMsg();
    	if(!NumberUtils.isNumber(id)){
    		return result.fill(JsonResponseMsg.CODE_FAIL, "参数错误");
    	}
    	List<ProductBase> productBaseList=productBaseService.findByProductClassId(NumberUtils.toInt(id));
		return productBaseList;
    }

    /**
     * 修改或者添加产品
     * @return
     */
    @RequestMapping("updateOrAdd")
    @Transactional
    public ModelAndView ProductUpdateOrAdd(String id,String data){
        ModelAndView mv = new ModelAndView("admin/product/list");
        Integer idValue=null;
        if(NumberUtils.isNumber(id)){
            idValue=NumberUtils.toInt(id);
        }
//        Boolean updateOrAdd = productService.UpdateOrAdd(idValue,data);
//        if(!updateOrAdd){
//        	return null;
//        }
        return mv;
    }

    @RequestMapping("inter")
    public Object inter() {
        return "admin/product/interface";
    }

    @RequestMapping("description")
    public Object description() {
        return "admin/product/description";
    }

    @RequestMapping("fee")
    public Object fee() {
        return "admin/product/fee";
    }

    @RequestMapping("product_base/{pid}")
    @ResponseBody
    public Object product_base(@PathVariable(value = "pid", required = false) String pid) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "11");
        return map;
    }

    @RequestMapping("area/{pid}")
    @ResponseBody
    public Object area(@PathVariable(value = "pid", required = false) String pid) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "11");
        System.out.println(0b001 + 0b010 + 0b100);
        return map;
    }

}
