package com.baoquan.shuxin.service.impl.product;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.math.NumberUtils;

import com.alibaba.fastjson.JSONObject;
import com.baoquan.shuxin.dao.product.ProductInterfaceDao;
import com.baoquan.shuxin.model.product.ProductInterface;
import com.baoquan.shuxin.service.spi.product.ProductInterfaceService;

@Named
public class ProductInterfaceServiceImpl implements ProductInterfaceService{
	@Inject
	private ProductInterfaceDao productInterfaceDao;
	@Override
	public ProductInterface findByProductId(Integer id) {
		return productInterfaceDao.findByProductId(id);
	}
	
	/**
	 * 接口设置
	 */
	@Override
	public Boolean setInterface(ProductInterface productInterface, JSONObject data,Integer productId) {
		String interfaceName = data.getString("interfaceName");//接口名称
		String appCode = data.getString("appCode");//接口名称
		String urlAddress = data.getString("urlAddress");//服务地址
		String requestMethod = data.getString("requestMethod");//请求方式
		String responseFormat = data.getString("responseFormat");//返回报文格式
		String character = data.getString("character");//传输字符串
		String timeout = data.getString("timeout");//请求超时
		productInterface.setCharacter(character);
		productInterface.setName(interfaceName);
		productInterface.setAppCode(appCode);
		productInterface.setUrl(urlAddress);
		productInterface.setMethod(requestMethod);
		productInterface.setResponseFormat(responseFormat);
		productInterface.setTimeout(NumberUtils.toInt(timeout));
		productInterface.setProductId(productId);
		productInterface.setFree(1);
		productInterfaceDao.delete(productId);
		productInterfaceDao.insert(productInterface);
		return true;
	}

}
