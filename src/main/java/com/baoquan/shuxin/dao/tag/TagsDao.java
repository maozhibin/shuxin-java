package com.baoquan.shuxin.dao.tag;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.baoquan.shuxin.model.tag.Tags;

@Repository
public interface TagsDao {

	void delete(List<Integer> tagIdList);

	List<Integer> getItermByName(List<Object> tagsNameList);

	void insertTagsList(List<Tags> tagsList);
	
}