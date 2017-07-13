package com.baoquan.shuxin.model.user;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class UserMoneyLog {

	private Long id;

	private String type;

	private Long userId;

	private BigDecimal amount;

	private String remark;

	private String itemInfo;

	private Integer status;

	private String requestNo;

	private Long dateline;

	private Integer reverse;

	private Long reverseTime;

	private BigDecimal fee;

	private String expense;

	private String userRemark;

	private String feeRelative;

	private BigDecimal extraCost;

	private String extraExpense;

	private String extraRequest;

	private String statusDesc;

	private Long finishTime;
}
