package com.baoquan.shuxin.service.impl.product;

import javax.inject.Inject;
import javax.inject.Named;

import com.alibaba.fastjson.JSONObject;
import com.baoquan.shuxin.dao.product.ProductDetailDao;
import com.baoquan.shuxin.model.product.ProductDetail;
import com.baoquan.shuxin.service.spi.product.ProductDetailService;
@Named
public class ProductDetailServiceImpl implements ProductDetailService{
	@Inject
	private ProductDetailDao productDetailDao;

	@Override
	public ProductDetail findByProductId(Integer id) {
		return productDetailDao.findByProductId(id);
	}

	@Override
	public Boolean setDetail(JSONObject data, Integer productId) {
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
		return true;
	}
}
