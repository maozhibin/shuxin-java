package com.baoquan.shuxin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.baoquan.shuxin.model.UserProduct;

/**
 * Desc:
 * Created by yongj on 7/7/2017,
 */
@Repository
public interface UserProductDao {
    List<UserProduct> queryByUserProductStatus(@Param("userId") long userId, @Param("productId") long productId,
            @Param("status") int status);
}
