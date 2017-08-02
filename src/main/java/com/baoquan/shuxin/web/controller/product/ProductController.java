package com.baoquan.shuxin.web.controller.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.model.area.Area;
import com.baoquan.shuxin.model.product.Product;
import com.baoquan.shuxin.model.product.ProductBase;
import com.baoquan.shuxin.model.product.ProductBillings;
import com.baoquan.shuxin.model.product.ProductClass;
import com.baoquan.shuxin.model.product.ProductDetail;
import com.baoquan.shuxin.model.product.ProductInterface;
import com.baoquan.shuxin.model.product.ProductInterfaceCode;
import com.baoquan.shuxin.model.product.ProductInterfaceParam;
import com.baoquan.shuxin.model.product.ProductInterfaceSample;
import com.baoquan.shuxin.model.user.User;
import com.baoquan.shuxin.service.spi.area.AreaService;
import com.baoquan.shuxin.service.spi.product.ProductBaseService;
import com.baoquan.shuxin.service.spi.product.ProductBillingsService;
import com.baoquan.shuxin.service.spi.product.ProductClassService;
import com.baoquan.shuxin.service.spi.product.ProductDetailService;
import com.baoquan.shuxin.service.spi.product.ProductInterfaceCodeService;
import com.baoquan.shuxin.service.spi.product.ProductInterfaceParamService;
import com.baoquan.shuxin.service.spi.product.ProductInterfaceSampleService;
import com.baoquan.shuxin.service.spi.product.ProductInterfaceService;
import com.baoquan.shuxin.service.spi.product.ProductService;
import com.baoquan.shuxin.service.spi.product.ProductTagService;
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
    @Inject
    private ProductInterfaceService productInterfaceService;
    @Inject
    private ProductInterfaceSampleService productInterfaceSampleService;
    @Inject
    private ProductDetailService productDetailService;
    @Inject
    private ProductTagService productTagService;
    @Inject
    private ProductInterfaceParamService productInterfaceParamService;
    @Inject
    private ProductInterfaceCodeService productInterfaceCodeService;
    @Inject
    private ProductBillingsService productBillingsService;
    /**
     * 产品列表
     * @param name
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("list")
    public ModelAndView list(String name, Integer pageNo, Integer pageSize) {
        if (pageNo == null || pageNo < 1) pageNo = 1;
        if (pageSize == null || pageSize > Page.DEFAULT_PAGE_SIZE) pageSize = Page.DEFAULT_PAGE_SIZE;
        name = StringUtils.trimToNull(name);
    	ModelAndView mv = new ModelAndView("admin/product/list");
    	Page<Map<String, Object>> page = new Page<Map<String,Object>>();
        page.setPageSize(pageSize);
        page.setPageNo(pageNo);
		page = productService.findListProduct(page,name);
		mv.addObject(page);
		mv.addObject("name", name);
		return mv;
    }

    /**
     * 产品发布或者修改页面
     * @param content
     * @param request
     * @return
     */
    @RequestMapping("issue")
    public ModelAndView issue(@RequestBody(required = false) String content,HttpServletRequest request) {
        logger.info(content);
        ModelAndView mv = new ModelAndView("admin/product/issue");
        List<ProductClass> productClassList= productClassService.findAllClassList();
        List<Area> provinceList = areaService.findProvince();
        List<User> userList = userService.userList();
        Map<String, Object> map = new HashMap<>();
        map.put("provinceList", provinceList);
        map.put("productClassList", productClassList);
        map.put("userList", userList);
        String id = request.getParameter("id");
        if(!StringUtils.isEmpty(id)){
        	Integer idValue = NumberUtils.toInt(id);
        	Map<String,Object> productBaseInfo=productService.productBaseInfo(idValue);
        	map.put("productBaseInfo", productBaseInfo);
        	ProductInterface productInterface = productInterfaceService.findByProductId(idValue);
        	map.put("productInterface", productInterface);
        	List<ProductInterfaceSample> interfaceSample=productInterfaceSampleService.findByProductId(idValue);
        	map.put("interfaceSample", interfaceSample);
        	ProductDetail productDetail = productDetailService.findByProductId(idValue);
        	map.put("productDetail", productDetail);
        	String tagLists=productTagService.findByProductId(idValue);
        	map.put("tagLists",tagLists);
        	List<ProductInterfaceParam> headersParamslist = productInterfaceParamService.headersParamslist(idValue);
        	map.put("headersParamslist",headersParamslist);
        	List<ProductInterfaceParam> queryParamslist = productInterfaceParamService.queryParamslist(idValue);
        	map.put("queryParamslist",queryParamslist);
        	List<ProductInterfaceParam> bodyParamslist = productInterfaceParamService.bodyParamslist(idValue);
        	map.put("bodyParamslist",bodyParamslist);
        	List<ProductInterfaceCode> interfaceCodeList = productInterfaceCodeService.interfaceCodeList(idValue);
        	map.put("interfaceCodeList",interfaceCodeList);
        	List<ProductBillings> billingsList = productBillingsService.findByProductId(idValue);
        	map.put("billingsList",billingsList);
        }
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
    @ResponseBody
    public JsonResponseMsg ProductUpdateOrAdd(String id,String data){
    	JsonResponseMsg result = new JsonResponseMsg();
        Integer idValue=null;
        if(NumberUtils.isNumber(id)){
            idValue=NumberUtils.toInt(id);
        }
       Boolean updateOrAdd = productService.UpdateOrAdd(idValue,data);
       if(!updateOrAdd){
    	   return result.fill(JsonResponseMsg.CODE_FAIL,"失败");
        }
       return result.fill(JsonResponseMsg.CODE_SUCCESS,"成功");
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

    /**
     * 产品状态修改
     */
    @RequestMapping("status")
    public String updateStatus(String id,String status){
        if(!NumberUtils.isNumber(id)){
            return  "参数错误";
        }
        Product product = productService.findById(NumberUtils.toInt(id));
        Integer statusType = NumberUtils.toInt(status);
        product.setStatus(statusType);
        productService.updateProductStatus(product);
        return "redirect:list";
    }
    
}


