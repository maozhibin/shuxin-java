package com.baoquan.shuxin.service.spi.security;

import com.alibaba.fastjson.JSONObject;
import com.baoquan.shuxin.model.product.Product;
import com.baoquan.shuxin.model.product.ProductInterface;
import com.baoquan.shuxin.model.security.SecurityBaoquanLog;

public interface SecurityBaoquanLogService {

	void insertSecurityBaoquanLogInfo(SecurityBaoquanLog baoquanLog, Product product, ProductInterface productInterface);

}
