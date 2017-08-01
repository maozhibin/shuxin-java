package com.baoquan.shuxin.service.impl.product;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baoquan.shuxin.constatn.InterfaceParamConstant;
import com.baoquan.shuxin.dao.product.ProductInterfaceParamDao;
import com.baoquan.shuxin.model.product.ProductInterfaceParam;
import com.baoquan.shuxin.service.spi.product.ProductInterfaceParamService;

@Named
public class ProductInterfaceParamServiceImpl implements ProductInterfaceParamService {
	@Inject
	private ProductInterfaceParamDao productInterfaceParamDao;

	@Override
	public void paramListInsert(List<ProductInterfaceParam> interfaceParamList) {
		productInterfaceParamDao.paramListInsert(interfaceParamList);
	}

	@Override
	public void deleteParamLit(Integer productId) {
		productInterfaceParamDao.deleteParamLit(productId);

	}

	// 请求参数（Headers）
	@Override
	public List<ProductInterfaceParam> headersParamslist(Integer id) {
		return productInterfaceParamDao.headersParamslist(id);
	}

	// 请求参数（Body）
	@Override
	public List<ProductInterfaceParam> bodyParamslist(Integer id) {
		return productInterfaceParamDao.bodyParamslist(id);
	}

	// 请求参数（Query）
	@Override
	public List<ProductInterfaceParam> queryParamslist(Integer id) {
		return productInterfaceParamDao.queryParamslist(id);
	}

	/**
	 * 接口参数设置
	 */
	public Boolean setInterfaceParam(Integer productInterfaceId, Integer productId, JSONObject data) {
		List<Object> paramList = null;
		List<ProductInterfaceParam> interfaceParamList = new ArrayList<>();
		if (productInterfaceId == null) {
			return false;
		}
		JSONArray headerArray = data.getJSONArray("headersArray");
		Boolean updateParam = this.updateParam(headerArray, productInterfaceId, productId, interfaceParamList,paramList);
		if (!updateParam) {
			return false;
		}
		JSONArray bodysArray = data.getJSONArray("bodysArrays");
		Boolean updateParam2 = this.updateParam(bodysArray, productInterfaceId, productId, interfaceParamList,paramList);
		if (!updateParam2) {
			return false;
		}
		JSONArray querysArray = data.getJSONArray("querysArray");
		Boolean updateParam3 = this.updateParam(querysArray, productInterfaceId, productId, interfaceParamList,paramList);
		if (!updateParam3) {
			return false;
		}

		this.deleteParamLit(productId);
		this.paramListInsert(interfaceParamList);

		return true;
	}

	@SuppressWarnings("unchecked")
	public Boolean updateParam(JSONArray array, Integer productInterfaceId, Integer productId,
			List<ProductInterfaceParam> interfaceParamList, List<Object> paramList) {
		if (productInterfaceId == null) {
			return false;
		}
		for (int i = 0; i < array.size(); i++) {
			ProductInterfaceParam interfaceParam = new ProductInterfaceParam();
			paramList = (List<Object>) array.get(i);
			String name = (String) paramList.get(0);
			String type = (String) paramList.get(1);
			Boolean must = null;
			if ("1".equals((String) paramList.get(2))) {
				must = true;
			} else if ("0".equals((String) paramList.get(2))) {
				must = false;
			}

			String description = (String) paramList.get(3);
			interfaceParam.setName(name);
			interfaceParam.setDescription(description);
			interfaceParam.setMust(must);
			interfaceParam.setType(type);
			interfaceParam.setProductId(productId);
			interfaceParam.setParamType(InterfaceParamConstant.PARAM_TYPE_HEADERS);
			interfaceParam.setProductInterfaceId(productInterfaceId);
			interfaceParamList.add(interfaceParam);
		}
		return true;
	}
}
