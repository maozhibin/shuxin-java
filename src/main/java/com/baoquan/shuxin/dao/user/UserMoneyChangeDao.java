package com.baoquan.shuxin.dao.user;

import org.springframework.stereotype.Repository;

import com.baoquan.shuxin.model.user.UserMoneyChange;

@Repository
public interface UserMoneyChangeDao {

    int insert(UserMoneyChange record);

    int insertSelective(UserMoneyChange record);

    UserMoneyChange selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserMoneyChange record);

    int updateByPrimaryKey(UserMoneyChange record);
}