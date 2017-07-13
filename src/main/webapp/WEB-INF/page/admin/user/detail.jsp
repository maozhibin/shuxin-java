<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%--
  Created by IntelliJ IDEA.
  User: yongj
  Date: 7/13/2017
  Time: 2:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息详情</title>
    <style>
	    .row{
	        font-size:14px;
	        color:#999;
	        letter-spacing:0;
	        text-align:left;
	        margin:5px 8px;
	    }
	</style>
</head>
<body>
	<section style="margin: 20px">
	    <h4 class="header">
	        <span class="text-left">用户基本信息<span>
	    </h4>
	    <div class="row">
	        <label class="col-md-2 text-overflow">用户姓名：</label>
	        <div class="col-md-10">${user.username}</div>
		    </div>
		    <div class="row">
		        <label class="col-md-2 text-overflow">手机号码：</label>
		        <div class="col-md-10">${user.mobile}</div>
		    </div>
		    <div class="row">
		        <label class="col-md-2 text-overflow">客户最近一次登录时间：</label>
		         <div class="col-md-10">${string}</div>
		    </div>
		    <div class="row">
		        <label class="col-md-2 text-overflow">客户最近一次登录IP：</label>
		        <div class="col-md-10">${user.lastLoginIp}</div>
		    </div>
		    <div class="row">
		     <label class="col-md-2 text-overflow">邮箱：</label>
		     <div class="col-md-10">${user.email}</div>
	    </div>
	</section>
	<section style="margin: 20px">
	    <h4 class="header">
	    <span class="text-left">用户资金信息<span>
	    </h4>
	    <div class="row">
	        <label class="col-md-2 text-overflow">账户金额：</label>
	        <div class="col-md-10">${user.moneyBalance}</div>
	    </div>
	    <div class="row">
	        <label class="col-md-2 text-overflow">账户冻结金额：</label>
	        <div class="col-md-10">${user.moneyFreeze}</div>
	    </div>
	</section>
	
	<section class="box" style="margin-top: 20px;padding-top: 20px;box-shadow: none;">
	    <a href="moneyChange?userId=${user.id}" class="btn">查看用户资金变动记录</a>
	    <br>
	    <br>
	</section>

</body>
</html>
