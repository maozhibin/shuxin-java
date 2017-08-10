package com.baoquan.shuxin.service.impl.security;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baoquan.shuxin.dao.security.SecurityBaoquanLogDao;
import com.baoquan.shuxin.model.product.Product;
import com.baoquan.shuxin.model.product.ProductBase;
import com.baoquan.shuxin.model.product.ProductBillings;
import com.baoquan.shuxin.model.product.ProductClass;
import com.baoquan.shuxin.model.product.ProductDetail;
import com.baoquan.shuxin.model.product.ProductInterface;
import com.baoquan.shuxin.model.product.ProductInterfaceCode;
import com.baoquan.shuxin.model.product.ProductInterfaceParam;
import com.baoquan.shuxin.model.product.ProductInterfaceSample;
import com.baoquan.shuxin.model.product.ProductTag;
import com.baoquan.shuxin.model.security.SecurityBaoquanLog;
import com.baoquan.shuxin.service.spi.product.ProductBaseService;
import com.baoquan.shuxin.service.spi.product.ProductBillingsService;
import com.baoquan.shuxin.service.spi.product.ProductClassService;
import com.baoquan.shuxin.service.spi.product.ProductDetailService;
import com.baoquan.shuxin.service.spi.product.ProductInterfaceCodeService;
import com.baoquan.shuxin.service.spi.product.ProductInterfaceParamService;
import com.baoquan.shuxin.service.spi.product.ProductInterfaceSampleService;
import com.baoquan.shuxin.service.spi.product.ProductTagService;
import com.baoquan.shuxin.service.spi.security.SecurityBaoquanLogService;
@Named
public class SecurityBaoquanLogServiceImpl implements SecurityBaoquanLogService{
	@Inject
	private SecurityBaoquanLogDao securityBaoquanLogDao;
	@Inject
	private ProductBaseService productBaseService;
	@Inject
	private ProductClassService productClassService;
	@Inject
	private ProductBillingsService productBillingsService;
	@Inject
	private ProductDetailService productDetailService;
	@Inject
	private ProductInterfaceCodeService productInterfaceCodeService;
	@Inject
	private ProductInterfaceParamService productInterfaceParamService;
	@Inject
	private ProductInterfaceSampleService productInterfaceSampleService;
	@Inject
	private ProductTagService productTagService;
	@Override
	public void insertSecurityBaoquanLogInfo(SecurityBaoquanLog baoquanLog, Product product,
			ProductInterface productInterface) {
		Map<String, Object> map = new HashMap<>();
		Integer productId = product.getId();
		Integer productClassId = product.getProductClassId();
		Integer productBaseId = product.getProductBaseId();
		//产品子类别
		ProductBase productBase = productBaseService.queryById(productBaseId);
		//产品类别
		ProductClass productClass = productClassService.queryById(productClassId);
		//产品套餐计费规则表
	    List<ProductBillings> ProductBillingsList = productBillingsService.findByProductId(productId);
	    //产品介绍
	    ProductDetail productDetail = productDetailService.findByProductId(productId);
	    //错误码
	    List<ProductInterfaceCode> codeList = productInterfaceCodeService.interfaceCodeList(productId);
	    //产品api接口参数
	    List<ProductInterfaceParam> productInterfaceParamList= productInterfaceParamService.paramslist(productId, "");
	    //产品api接口示例
	    List<ProductInterfaceSample> productInterfaceSampleList = productInterfaceSampleService.findByProductId(productId);
	    //
	    List<ProductTag> tagList = productTagService.findByproductId(productId);
		map.put("product", product);
		map.put("product_base", productBase);
		map.put("product_class", productClass);
		map.put("product_billings", ProductBillingsList);
		map.put("product_detail", productDetail);
		map.put("product_interface", productInterface);
		map.put("product_interface_code",codeList);
		map.put("product_interface_param", productInterfaceParamList);
		map.put("product_interface_sample", productInterfaceSampleList);
		map.put("product_tag", tagList);
	    String json = JSONArray.toJSONString(map);
	    baoquanLog.setSecurityData(json);
	    securityBaoquanLogDao.insertBaoquanLog(baoquanLog);
	}
}
