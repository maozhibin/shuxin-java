package com.baoquan.shuxin.service.impl.product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.math.NumberUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.constatn.InterfaceParamConstant;
import com.baoquan.shuxin.constatn.InterfaceSampleConstant;
import com.baoquan.shuxin.dao.product.ProductBillingsDao;
import com.baoquan.shuxin.dao.product.ProductDao;
import com.baoquan.shuxin.dao.product.ProductDetailDao;
import com.baoquan.shuxin.dao.product.ProductInterfaceCodeDao;
import com.baoquan.shuxin.dao.product.ProductInterfaceDao;
import com.baoquan.shuxin.dao.product.ProductInterfaceSampleDao;
import com.baoquan.shuxin.dao.product.ProductTagDao;
import com.baoquan.shuxin.dao.tag.TagsDao;
import com.baoquan.shuxin.model.product.Product;
import com.baoquan.shuxin.model.product.ProductBillings;
import com.baoquan.shuxin.model.product.ProductDetail;
import com.baoquan.shuxin.model.product.ProductInterface;
import com.baoquan.shuxin.model.product.ProductInterfaceCode;
import com.baoquan.shuxin.model.product.ProductInterfaceParam;
import com.baoquan.shuxin.model.product.ProductInterfaceSample;
import com.baoquan.shuxin.model.product.ProductTag;
import com.baoquan.shuxin.model.tag.Tags;
import com.baoquan.shuxin.service.spi.product.ProductInterfaceParamService;
import com.baoquan.shuxin.service.spi.product.ProductService;

@Named
public class ProductServiceImpl implements ProductService{
	@Inject
	private ProductDao productDao;
	@Inject
	private ProductInterfaceParamService productInterfaceParamService;
	@Inject
	private ProductInterfaceDao productInterfaceDao;
	@Inject
	private ProductInterfaceSampleDao productInterfaceSampleDao;
	@Inject
	private ProductInterfaceCodeDao productInterfaceCodeDao;
	@Inject
	private ProductDetailDao productDetailDao;
	@Inject
	private ProductBillingsDao productBillingsDao;
	@Inject
	private TagsDao tagsDao;
	@Inject
	private ProductTagDao productTagDao;




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

	@SuppressWarnings("unchecked")
	@Override
	public Boolean UpdateOrAdd(Integer id,String json) {
		Date date = new Date();
		Integer time = (int) (date.getTime()/1000);
		
		//解析json
		JSONObject data=JSONObject.parseObject(json);
		System.out.println(data.size());
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
		
		Product product=null;
		if(id!=null){
			product = productDao.findById(id);
			if(product==null){
				return false;
			}
			product.setId(id);
			product.setUserId(userNameId);
			product.setName(productName);
			product.setFrequent(frequent);
			product.setType(productType);
			product.setProductClassId(productClassId);
			product.setProductBaseId(productBaseId);
			product.setAreaId(cityid);
			product.setDescription(productDescription);
			product.setIcon(icon);
			productDao.updateProduct(product);
		}else{
			product=new Product();
			product.setUserId(userNameId);
			product.setName(productName);
			product.setFrequent(frequent);
			product.setType(productType);
			product.setProductClassId(productClassId);
			product.setProductBaseId(productBaseId);
			product.setAreaId(cityid);
			product.setDescription(productDescription);
			product.setIcon(icon);
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
		Tags tags = new Tags();
		ProductTag productTag = new ProductTag();
		List<Object> tagsList = null;;
		for(int i=0;i<productTags.size();i++){
			tagsList = (List<Object>) productTags.get(i);
		}
		List<Integer> tagIdList = new ArrayList<>();
		List<ProductTag> productTaglist=productTagDao.findByproductId(productId);
		for(int i=0;i<productTaglist.size();i++){
			Integer tagId = productTaglist.get(i).getTagId();
			tagIdList.add(tagId);
		}
		
		
		//接口设置
		//产品api接口详情
		ProductInterface productInterface = new ProductInterface();
		String interfaceName = data.getString("interfaceName");//接口名称
		String urlAddress = data.getString("urlAddress");//服务地址
		String requestMethod = data.getString("requestMethod");//请求方式
		String responseFormat = data.getString("responseFormat");//返回报文格式
		String character = data.getString("character");//传输字符串
		String timeout = data.getString("timeout");//请求超时
		productInterface.setCharacter(character);
		productInterface.setName(interfaceName);
		productInterface.setUrl(urlAddress);
		productInterface.setMethod(requestMethod);
		productInterface.setResponseFormat(responseFormat);
		productInterface.setTimeout(NumberUtils.toInt(timeout));
		productInterface.setProductId(productId);
		
		productInterfaceDao.delete(productId);
		productInterfaceDao.update(productInterface);
		
		//产品api接口参数进行组装
		
		Integer productInterfaceId = productInterface.getId();
		JSONArray headerArray = data.getJSONArray("headersArray");
		JSONArray bodysArray = data.getJSONArray("bodysArrays");
		JSONArray querysArray = data.getJSONArray("querysArray");
		List<Object> paramList = null;;
		List<ProductInterfaceParam> interfaceParamList = new ArrayList<>();
		ProductInterfaceParam interfaceParam = new ProductInterfaceParam();
		if(productInterfaceId==null){
			return false;
		}
		
		for(int i=0;i<headerArray.size();i++){
			paramList = (List<Object>) headerArray.get(i);
			String name=(String) paramList.get(0);
			String type=(String) paramList.get(1);
			Boolean must=null;
			if("1".equals((String) paramList.get(2))){
				must=true;
			}else if("0".equals((String) paramList.get(2))){
				must=false;
			}
			
			String description=(String) paramList.get(3);
			interfaceParam.setName(name);
			interfaceParam.setDescription(description);
			interfaceParam.setMust(must);
			interfaceParam.setType(type);
			interfaceParam.setProductId(productId);
			interfaceParam.setParamType(InterfaceParamConstant.PARAM_TYPE_QUERY);
			interfaceParam.setProductInterfaceId(productInterfaceId);
			interfaceParamList.add(interfaceParam);
		}
		
		for(int i=0;i<bodysArray.size();i++){
			paramList = (List<Object>) bodysArray.get(i);
			String name=(String) paramList.get(0);
			String type=(String) paramList.get(1);
			Boolean must=null;
			if("1".equals((String) paramList.get(2))){
				must=true;
			}else if("0".equals((String) paramList.get(2))){
				must=false;
			}
			String description=(String) paramList.get(3);
			interfaceParam.setName(name);
			interfaceParam.setDescription(description);
			interfaceParam.setMust(must);
			interfaceParam.setType(type);
			interfaceParam.setProductId(productId);
			interfaceParam.setParamType(InterfaceParamConstant.PARAM_TYPE_QUERY);
			interfaceParam.setProductInterfaceId(productInterfaceId);
			interfaceParamList.add(interfaceParam);
		}
		
		for(int i=0;i<querysArray.size();i++){
			paramList = (List<Object>) querysArray.get(i);
			String name=(String) paramList.get(0);
			String type=(String) paramList.get(1);
			Boolean must=null;
			if("1".equals((String) paramList.get(2))){
				must=true;
			}else if("0".equals((String) paramList.get(2))){
				must=false;
			}
			String description=(String) paramList.get(3);
			interfaceParam.setName(name);
			interfaceParam.setDescription(description);
			interfaceParam.setMust(must);
			interfaceParam.setType(type);
			interfaceParam.setProductId(productId);
			interfaceParam.setParamType(InterfaceParamConstant.PARAM_TYPE_QUERY);
			interfaceParam.setProductInterfaceId(productInterfaceId);
			interfaceParamList.add(interfaceParam);
		}
		
		productInterfaceParamService.deleteParamLit(productId);
		productInterfaceParamService.paramListInsert(interfaceParamList);
		
		
		
		//产品api接口示例
		List<ProductInterfaceSample> sampleList = new ArrayList<>();
		String requestSample = data.getString("requestSample");//请求实例
		String normalSample = data.getString("normalSample");//正常返回
		String errorSample = data.getString("errorSample");//错误提示
		ProductInterfaceSample productInterfaceSample = new ProductInterfaceSample();
		String sampleType=null;
		String sampleValue=null;
		for(int i=0;i<3;i++){
			if(i==0){
				 sampleType = InterfaceSampleConstant.TYPE_INPUT;
				 sampleValue = requestSample;
			}else if(i==1){
				 sampleType = InterfaceSampleConstant.TYPE_OUTPUT_SUCCESS;
				 sampleValue = normalSample;
			}else if(i==2){
				 sampleType = InterfaceSampleConstant.TYPE_OUTPUT_FAIL;
				 sampleValue = errorSample;
			}
			productInterfaceSample.setProductId(productId);
			productInterfaceSample.setProductInterfaceId(productInterfaceId);
			productInterfaceSample.setType(sampleType);
			productInterfaceSample.setValue(sampleValue);
			sampleList.add(productInterfaceSample);
		}
		productInterfaceSampleDao.delete(productId);
		productInterfaceSampleDao.insertSample(sampleList);
		
		//错误码定义
		ProductInterfaceCode productInterfaceCode = new ProductInterfaceCode();
		List<ProductInterfaceCode> codeList = new ArrayList<>();
		JSONArray codesArrays = data.getJSONArray("codesArrays");
		List<Object> codes= null;;
		for(int i=0;i<codesArrays.size();i++){
			codes = (List<Object>) codesArrays.get(i);
			String code=(String) codes.get(0);
			String codeName=(String) codes.get(1);
			String codeDesc=(String) codes.get(2);
			productInterfaceCode.setCode(code);
			productInterfaceCode.setName(codeName);
			productInterfaceCode.setDesc(codeDesc);
			productInterfaceCode.setProductId(productId);
			productInterfaceCode.setProductInterfaceId(productInterfaceId);
			codeList.add(productInterfaceCode);
		}
		productInterfaceCodeDao.delete(productId);
		productInterfaceCodeDao.insertList(codeList);
		
		//产品描述
		String intro = data.getString("intro");//产品介绍
		String highlight = data.getString("highlight");//产品亮点
		//String snapshot = data .getString("snapshot");//产品截图
		String service = data.getString("service");//售后服务
		ProductDetail productDetail = new ProductDetail();
		productDetail.setIntro(intro);
		productDetail.setHighlight(highlight);
		productDetail.setService(service);
		productDetail.setProductId(productId);
		
		productDetailDao.delete(productId);
		productDetailDao.insert(productDetail);
		
		//产品套餐计费规则表
		String priceOnePrice = data.getString("priceOne");
		String priceHundredPrice = data.getString("priceHundred");
		String priceYearPrice = data.getString("priceYear");
		Integer userId = product.getUserId();
		List<ProductBillings> billingsList = new ArrayList<>();
		ProductBillings billings = new ProductBillings();
		for(int i=0;i<3;i++){
			if(i==0){
				BigDecimal price=new BigDecimal(priceOnePrice); 
				billings.setPrice(price);
				billings.setNum(1);
				billings.setType(1);
			}else if(i==1){
				BigDecimal price=new BigDecimal(priceHundredPrice); 
				billings.setPrice(price);
				billings.setNum(100);
				billings.setType(1);
			}else if(i==2){
				BigDecimal price=new BigDecimal(priceYearPrice); 
				billings.setPrice(price);
				billings.setNum(12);
				billings.setType(2);
			}
			billings.setUserId(userId);
			billings.setDateline(time);
			billings.setProductId(productId);
		}
		
		productBillingsDao.delete(productId);
		productBillingsDao.insertList(billingsList);
		return true;
	}

	@Override
	public Product findById(Integer id) {
		return productDao.findById(id);
	}


}
