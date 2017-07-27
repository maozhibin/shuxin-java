<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>用户列表</title>
    <style>
        td {
            padding: 10px;
        }
    </style>
</head>
<body>
<section class="filter-box" style="border:none">
    <div class="row">
        <form class="form-inline" method="post">
            <table style="margin-left: 30px">
                <tr>
                    <td> 客户名称：</td>
                    <td>
                        <input class="form-control" type="text" name="name"
                               value="${name}"/>
                    </td>
                    <td> 电话号码：</td>
                    <td>
                        <input class="form-control" type="text" name="mobile"
                               value="${mobile}"/>
                    </td>
                    <td>
                        <button type="submit" class="btn"><i class="fa fa-search"></i> 搜索</button>
                    </td>
                    
                     <c:if test="${typeId eq 'ORG'}">
						<td>
							<a href="/admin/user/skip" type="button" class="btn btn-info" style="margin-left:10px">新增</a>
						</td>
					</c:if>
                </tr>
            </table>
        </form>
       
         
    </div>
</section>
<div class="row" style="border-top: none;">
    <div class="col-md-12">
        <div class="box-primary">
            <div class="box-body">
                <!--                <div style="margin-bottom: 8px"></div>-->
                <table id="example2" class="table table-bordered table-striped table-hover" style="table-layout:fixed">
                    <thead>
                    <tr>
                        <th>用户ID</th>
                        <th>手机号</th>
                        <th>姓名</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${page != null && page.result != null}">
                        <c:forEach items="${page.result}" var="user">
                            <tr>
                                <td>${user.id}</td>
                                <td>${user.mobile}</td>
                                <td>${user.username}</td>
                                <td>
                                    <a class="" title='查看'
                                       href="detail?id=${user.id}"><i
                                            class="fa fa-eye"></i> </a>&nbsp;&nbsp;
                                    <!--  <a class="" title='编辑'
                                       href="user/detail/"><i
                                            class="fa fa-pencil"></i> </a>&nbsp;&nbsp;-->
                                    <a class="delete_button" title='删除' url="delete?id=${user.id}"><i
                                            class="fa fa-trash"></i></a>&nbsp;&nbsp;
                                    <c:if test="${typeId eq 'ORG'}">
                                    	<a class="" title='编辑' href="skip?id=${user.id}"><i
                                            class="fa fa-pencil"></i></a>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    </tbody>
                </table>
                <%@include file="/WEB-INF/page/admin/pager.jsp"%>
            </div>
        </div>
    </div>
</div>
</body>
</html>
