<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: yongj
  Date: 7/14/2017
  Time: 11:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
            + "/";
%>
<html>
<head>
    <title>角色权限管理</title>
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
                    <td> 关键字：</td>
                    <td>
                        <input type="text" class="form-control pull-right" id="keywords" name="keywords"
                               value="${keywords}" placeholder="请输入关键字搜索">
                    </td>
                    <td>
                        <button type="submit" class="btn"><i class="fa fa-search"></i> 搜索</button>
                    </td>
                    <td>
                        <a href="skipAngle" type="button" class="btn btn-info" style="margin-left:10px">新增</a>
                    </td>
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
                        <th>序号</th>
                        <th>角色名称</th>
                        <th>操作</th>
                    </tr>
                    </thead>
	                    <tbody>
	                   		<c:if test="${page != null && page.result != null}">
		                        <c:forEach items="${page.result}" var="adminAngle" varStatus="status">
		                            <tr>
		                                <td>${status.index+1+(page.pageSize*(page.pageNo-1))}</td>
		                                <td>${adminAngle.name}</td>
		                                <td>
		                                    <a class="" title='查看'
		                                       href="detail?id=${user.id}"><i
		                                            class="fa fa-eye"></i> </a>&nbsp;&nbsp;
		                                    <a class="delete_button" title='删除' url="delete?id=${user.id}"><i
		                                            class="fa fa-trash"></i></a>&nbsp;&nbsp;
		                                    <a class="" title='编辑' href="skip?id=${user.id}"><i
		                                            class="fa fa-pencil"></i></a>
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
