package com.baoquan.shuxin.service.impl.product;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.collections.MapUtils;

import com.baoquan.shuxin.dao.product.ProductTagDao;
import com.baoquan.shuxin.service.spi.product.ProductTagService;
@Named
public class ProductTagServiceImpl implements ProductTagService{
	@Inject
	private ProductTagDao productTagDao;
	
	/**
	 * 查询标签信息
	 */
	@Override
	public String findByProductId(Integer id) {
		List<Map<String, Object>> findProductInfo = productTagDao.findProductInfo(id);
		Map<String, Object> map =null;
		String names="";
		int index = findProductInfo.size()-1;
		for(int i=0; i < findProductInfo.size();i++){
			String name=null;
			map = findProductInfo.get(i);
			name = MapUtils.getString(map, "name");
			if(index == i){
				names += name;
			}else{
				names += name+",";
			}
		}
		return names;
	}
}
