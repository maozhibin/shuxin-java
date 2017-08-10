package com.baoquan.shuxin.dao.product;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.baoquan.shuxin.model.product.ProductInterfaceParam;

@Repository
public interface ProductInterfaceParamDao {

	void paramListInsert(List<ProductInterfaceParam> interfaceParamList);

	void deleteParamLit(Integer productId);

	List<ProductInterfaceParam> paramslist(@Param("idValue")Integer idValue, @Param("paramType")String paramType);
   
}