package com.baoquan.shuxin.service.spi.product;

import java.util.Map;

import com.baoquan.shuxin.bean.Page;

public interface ProductService {
    Page<Map<String,Object>> findListProduct(Page<Map<String, Object>> page,String name);
}
