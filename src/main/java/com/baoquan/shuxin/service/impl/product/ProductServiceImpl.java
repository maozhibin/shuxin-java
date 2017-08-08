package com.baoquan.shuxin.service.impl.product;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.dao.product.ProductBillingsDao;
import com.baoquan.shuxin.dao.product.ProductDao;
import com.baoquan.shuxin.model.product.Product;
import com.baoquan.shuxin.model.product.ProductInterface;
import com.baoquan.shuxin.service.spi.product.ProductBillingsService;
import com.baoquan.shuxin.service.spi.product.ProductDetailService;
import com.baoquan.shuxin.service.spi.product.ProductInterfaceCodeService;
import com.baoquan.shuxin.service.spi.product.ProductInterfaceParamService;
import com.baoquan.shuxin.service.spi.product.ProductInterfaceSampleService;
import com.baoquan.shuxin.service.spi.product.ProductInterfaceService;
import com.baoquan.shuxin.service.spi.product.ProductService;
import com.baoquan.shuxin.service.spi.product.ProductTagService;

@Named
public class ProductServiceImpl implements ProductService{
	@Inject
	private ProductDao productDao;
	@Inject
	private ProductInterfaceParamService productInterfaceParamService;
	@Inject
	private ProductBillingsDao productBillingsDao;
	@Inject
	private ProductTagService productTagService;
	@Inject
	private ProductInterfaceService productInterfaceService;
	@Inject
	private ProductInterfaceSampleService productInterfaceSampleService;
	@Inject
	private ProductInterfaceCodeService productInterfaceCodeService;
	@Inject
	private ProductDetailService productDetailService;
	@Inject
	private ProductBillingsService productBillingsService;
	
	@Override
	public Page<Map<String,Object>> findListProduct(Page<Map<String, Object>> page, String name) {
		Map<String,Object>  map= new HashMap<>();
		map.put("name",name);
		map.put("page",page);
		Integer total = productDao.countByName(map);
		List<Map<String,Object> > list = productDao.productList(map);
		page.setTotalRecordCount(total);
		page.setResult(list);
		return page;
	}

	/**
	 *设置产品属性
	 */
	public void setProduct(String json,Product product){
		//解析json
		JSONObject data=JSONObject.parseObject(json);
		//基础设置
		String productName = data.getString("productName");//产品名
		Byte frequent = data.getByte("frequent");//更新频率
		Integer productClassId = data.getInteger("productClass");//产品类型id
		Integer productBaseId= data.getInteger("productBase");//子类型id
		String productDescription = data.getString("productDescription");//产品简介
		Byte productType = data.getByte("productType");
		String icon =data.getString("icon");//上传的图片
		Integer cityid = data.getInteger("city");//区域id
		Integer userNameId = data.getInteger("userName");
		
		product.setUserId(userNameId);
		product.setName(productName);
		product.setFrequent(frequent);
		product.setType(productType);
		product.setProductClassId(productClassId);
		product.setProductBaseId(productBaseId);
		product.setAreaId(cityid);
		product.setDescription(productDescription);
		product.setIcon(icon);

	}

	@Override
	@Transactional
	public Boolean UpdateOrAdd(Integer id,String json) {
		Date date = new Date();
		Integer time = (int) (date.getTime()/1000);

		//解析json
		JSONObject data=JSONObject.parseObject(json);
		Product product=null;
		if(id!=null){
			product = productDao.findById(id);
			if(product==null){
				return false;
			}
			product.setId(id);
			this.setProduct(json,product);
			productDao.updateProduct(product);
		}else{
			product=new Product();
			this.setProduct(json,product);
			product.setDateline(time);
			product.setUsed(0);
			product.setStatus(0);
			productDao.insertProduct(product);
		}
		Integer productId = product.getId();
		if(productId==null){
			return false;
		}

		//标签
		JSONArray productTags = data.getJSONArray("tags");
		Boolean setTages = productTagService.setTages(productTags,productId);
		if(!setTages){
			return false;
		}

		//接口设置
		//产品api接口详情
		ProductInterface productInterface = new ProductInterface();
		Boolean setInterface = productInterfaceService.setInterface(productInterface,data,productId);
		if(!setInterface){
			return false;
		}
		
		//产品api接口参数进行组装
		Integer productInterfaceId = productInterface.getId();
		Boolean setInterfaceParam = productInterfaceParamService.setInterfaceParam(productInterfaceId,productId,data);
		if(!setInterfaceParam){
			return false;
		}

		//产品api接口示例
		Boolean setSample = productInterfaceSampleService.setSample(data,productId,productInterfaceId);
		if(!setSample){
			return false;
		}
		
		//错误码定义
		Boolean setCode = productInterfaceCodeService.setCode(productId,productInterfaceId,data);
		if(!setCode){
			return false;
		}
		
		//产品描述
		Boolean setDetail = productDetailService.setDetail(data,productId);
		if(!setDetail){
			return false;
		}
		
		//产品套餐计费规则表
		Boolean setBillings = productBillingsService.setBillings(data,productId,product,time);
		if(!setBillings){
			return false;
		}
		
		return true;
	}

	@Override
	public Product findById(Integer id) {
		return productDao.findById(id);
	}

	/**
	 * 根据产品id查找产品的基础信息
	 */
	@Override
	public Map<String, Object> productBaseInfo(Integer id) {
		return productDao.productBaseInfo(id);
	}

	@Override
	public void updateProductStatus(Product product) {
		productDao.updateProductStatus(product);
	}


}
