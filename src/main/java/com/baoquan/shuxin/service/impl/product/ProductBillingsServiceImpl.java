package com.baoquan.shuxin.service.impl.product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.baoquan.shuxin.dao.product.ProductBillingsDao;
import com.baoquan.shuxin.model.product.Product;
import com.baoquan.shuxin.model.product.ProductBillings;
import com.baoquan.shuxin.service.spi.product.ProductBillingsService;
@Named
public class ProductBillingsServiceImpl implements ProductBillingsService{
	@Inject
	private ProductBillingsDao productBillingsDao;

	@Override
	public List<ProductBillings> findByProductId(Integer id) {
		return productBillingsDao.findByProductId(id);
	}

	@Override
	public Boolean setBillings(JSONObject data, Integer productId, Product product,Integer time) {
		String priceOnePrice = data.getString("priceOne");
		String priceHundredPrice = data.getString("priceHundred");
		String priceYearPrice = data.getString("priceYear");
		Integer userId = product.getUserId();
		List<ProductBillings> billingsList = new ArrayList<>();
		for(int i=0;i<3;i++){
			ProductBillings billings = new ProductBillings();
			if(i==0 && !StringUtils.isEmpty(priceOnePrice)){
				BigDecimal price=new BigDecimal(priceOnePrice);
				billings.setPrice(price);
				billings.setNum(1);
				billings.setType(1);
				billingsList.add(billings);
			}else if(i==1 && !StringUtils.isEmpty(priceHundredPrice)){
				BigDecimal price=new BigDecimal(priceHundredPrice);
				billings.setPrice(price);
				billings.setNum(100);
				billings.setType(1);
				billingsList.add(billings);
			}else if(i==2 && !StringUtils.isEmpty(priceYearPrice)){
				BigDecimal price=new BigDecimal(priceYearPrice);
				billings.setPrice(price);
				billings.setNum(12);
				billings.setType(2);
				billingsList.add(billings);
			}
			billings.setUserId(userId);
			billings.setDateline(time);
			billings.setProductId(productId);
		}

		productBillingsDao.delete(productId);
		productBillingsDao.insertList(billingsList);
		return true;
	}
}