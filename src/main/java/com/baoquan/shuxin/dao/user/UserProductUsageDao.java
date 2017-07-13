package com.baoquan.shuxin.dao.user;

import org.springframework.stereotype.Repository;

import com.baoquan.shuxin.model.user.UserProductUsage;

@Repository
public interface UserProductUsageDao {

    int insertIgnore(UserProductUsage record);

    int insertSelective(UserProductUsage record);

    UserProductUsage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserProductUsage record);

    UserProductUsage selectByUserProduct(Long userId, Long productId);

    int increaseTotal(Long id);

    int decreaseRemain(Long id);

    int increaseExtra(Long id);
}