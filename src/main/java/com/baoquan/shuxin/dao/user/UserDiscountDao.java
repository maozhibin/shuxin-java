package com.baoquan.shuxin.dao.user;

import org.springframework.stereotype.Repository;

import com.baoquan.shuxin.model.user.UserDiscount;

/**
 * Desc:
 * Created by yongj on 7/13/2017,
 */
@Repository
public interface UserDiscountDao {
    UserDiscount selectByUserId(Long userId);
}
