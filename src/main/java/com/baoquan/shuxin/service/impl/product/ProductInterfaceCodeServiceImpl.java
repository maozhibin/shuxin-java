package com.baoquan.shuxin.service.impl.product;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baoquan.shuxin.dao.product.ProductInterfaceCodeDao;
import com.baoquan.shuxin.model.product.ProductInterfaceCode;
import com.baoquan.shuxin.service.spi.product.ProductInterfaceCodeService;

@Named
public class ProductInterfaceCodeServiceImpl  implements ProductInterfaceCodeService{
	@Inject
	private ProductInterfaceCodeDao productInterfaceCodeDao;

	@Override
	public List<ProductInterfaceCode> interfaceCodeList(Integer id) {
		return productInterfaceCodeDao.interfaceCodeList(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Boolean setCode(Integer productId, Integer productInterfaceId, JSONObject data) {
		List<ProductInterfaceCode> codeList = new ArrayList<>();
		JSONArray codesArrays = data.getJSONArray("codesArrays");
		List<Object> codes= null;;
		for(int i=0;i<codesArrays.size();i++){
			ProductInterfaceCode productInterfaceCode = new ProductInterfaceCode();
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
		return true;
	}

}
