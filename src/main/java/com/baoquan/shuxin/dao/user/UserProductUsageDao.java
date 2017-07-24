package com.baoquan.shuxin.dao.user;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.baoquan.shuxin.model.user.UserProductUsage;

@Repository
public interface UserProductUsageDao {

    int insertIgnore(UserProductUsage record);

    UserProductUsage selectByUserProduct(@Param("userId") Long userId, @Param("productId") Long productId);

    int increaseTimeUsed(Long id);

    int decreaseCountRemain(Long id);

    int increaseExtra(Long id);
}