package com.baoquan.shuxin.service.impl.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;

import com.alibaba.fastjson.JSONArray;
import com.baoquan.shuxin.dao.product.ProductTagDao;
import com.baoquan.shuxin.dao.tag.TagsDao;
import com.baoquan.shuxin.model.product.ProductTag;
import com.baoquan.shuxin.model.tag.Tags;
import com.baoquan.shuxin.service.spi.product.ProductTagService;
@Named
public class ProductTagServiceImpl implements ProductTagService{
	@Inject
	private ProductTagDao productTagDao;
	@Inject
	private  TagsDao tagsDao;
	/**
	 * 查询标签信息
	 */
	@Override
	public String findByProductId(Integer id) {
		List<String> findProductInfo = productTagDao.findProductInfo(id);
		String names="";
		int index = findProductInfo.size()-1;
		for(int i=0; i < findProductInfo.size();i++){
			String name=findProductInfo.get(i);
			if(index == i){
				names += name;
			}else{
				names += name+",";
			}
		}
		return names;
	}
	
	/**
	 * 标签属性修改
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Boolean setTages(JSONArray productTags,Integer productId ) {
		List<Object> tagsNameList = null;
		for(int i=0;i<productTags.size();i++){
			tagsNameList = (List<Object>) productTags.get(i);
		}
		if(CollectionUtils.isEmpty(tagsNameList)){
			return false;
		}
		List<Integer> tagIdList = new ArrayList<>();
		List<ProductTag> productTaglist=productTagDao.findByproductId(productId);
		for(int i=0;i<productTaglist.size();i++){
			Integer tagId = productTaglist.get(i).getTagId();
			tagIdList.add(tagId);
		}
		if(!CollectionUtils.isEmpty(tagIdList)){
			tagsDao.delete(tagIdList);
			productTagDao.delete(productId);
		}
		String tagsName=null;
		List<Tags> tagsList = new ArrayList<>();
		for(int i=0;i<tagsNameList.size();i++){
			Tags tags = new Tags();
			tagsName=(String) tagsNameList.get(i);
			tags.setName(tagsName);
			tagsList.add(tags);
		}
		tagsDao.insertTagsList(tagsList);

		List<Integer> tagsIds = tagsDao.getItermByName(tagsNameList);
		if(CollectionUtils.isEmpty(tagsIds)){
			return false;
		}
		List<ProductTag> productTagList = new ArrayList<>();
		for(int i=0;i<tagsIds.size();i++){
			ProductTag productTag = new ProductTag();
			productTag.setProductId(productId);
			productTag.setTagId(tagsIds.get(i));
			productTagList.add(productTag);
		}
		productTagDao.insertListByTagTds(productTagList);
		
		return true;
	}

	@Override
	public List<String> findByproductId(Integer productId) {
		return productTagDao.findProductInfo(productId);
	}

}
