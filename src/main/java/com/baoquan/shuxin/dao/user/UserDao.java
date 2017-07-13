package com.baoquan.shuxin.dao.user;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.baoquan.shuxin.model.user.User;

/**
 * Created by Administrator on 2017/7/12.
 */
@Repository
public interface UserDao {

    Integer findValidUser(Map<String, Object> parms);

    List<User> findUserInfo(Map<String, Object> parms);

    void deleteUser(Long id);

    User findByIdUserInfo(Long id);

    User queryUserBalance(Long id);

    int deductUserBalance(Long id, BigDecimal price);

}