package com.baoquan.shuxin.web.controller.product;

import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.service.spi.product.ProductService;

@Controller
@RequestMapping("product")
public class ProductController {
    @Inject
    private ProductService productService;

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
    public Object issue() {
        return "admin/product/issue";
    }

}
