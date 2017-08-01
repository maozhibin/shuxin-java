package com.baoquan.shuxin.service.impl.product;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.alibaba.fastjson.JSONObject;
import com.baoquan.shuxin.constatn.InterfaceSampleConstant;
import com.baoquan.shuxin.dao.product.ProductInterfaceSampleDao;
import com.baoquan.shuxin.model.product.ProductInterfaceSample;
import com.baoquan.shuxin.service.spi.product.ProductInterfaceSampleService;

@Named
public class ProductInterfaceSampleServiceImpl implements ProductInterfaceSampleService{
	@Inject
	private ProductInterfaceSampleDao productInterfaceSampleDao;

	@Override
	public List<ProductInterfaceSample> findByProductId(Integer id) {
		
		return productInterfaceSampleDao.findByProductId(id);
	}
	
	/**
	 * 产品api接口示例设置
	 */
	@Override
	public Boolean setSample(JSONObject data, Integer productId, Integer productInterfaceId){
		String requestSample = data.getString("requestSample");//请求实例
		String normalSample = data.getString("normalSample");//正常返回
		String errorSample = data.getString("errorSample");//错误提示
		List<ProductInterfaceSample> sampleList = new ArrayList<>();
		
		String sampleType=null;
		String sampleValue=null;
		for(int i=0;i<3;i++){
			ProductInterfaceSample productInterfaceSample = new ProductInterfaceSample();
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
		return null;
	}
}
