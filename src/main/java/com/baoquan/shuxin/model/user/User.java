package com.baoquan.shuxin.model.user;

import java.math.BigDecimal;

import lombok.Data;

/**
 * Created by Administrator on 2017/6/8.
 */
@Data
public class User {
    private Long id;

    private String username;

    private BigDecimal moneyBalance;

    private BigDecimal moneyFreeze;

    private String mobile;

    private String email;

    private String password;

    private Long lastLoginTime;

    private String lastLoginIp;

    private String typeId;

    private String realName;

    private String bankStatus;

    private String orgCode;

    private String payPassword;

    private Integer isValid;

}
