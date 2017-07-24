package com.baoquan.shuxin.service.spi.product;

import java.util.List;
import java.util.Map;

import com.baoquan.shuxin.bean.Page;
import com.baoquan.shuxin.model.product.Product;

public interface ProductService {
    Page<Map<String,Object>> findListProduct(Page<Map<String, Object>> page,String name);

    Boolean UpdateOrAdd(Integer id,String json);

    Product findById(Integer id);


}
