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
    <title>权限管理</title>
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
                        <th>管理员账号</th>
                        <th>最后登陆时间</th>
                        <c:if test="${menus != null}">
                            <c:forEach items="${menus.values()}" var="menu">
                                <th>${menu.name}</th>
                            </c:forEach>
                        </c:if>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${page.result != null}">
                        <c:forEach items="${page.result}" var="user">
                            <tr>
                                <td>${user.username}</td>
                                <td><fmt:formatDate value="${user.lastLoginTime}" pattern="yyyy-MM-dd hh:ss:mm"/></td>
                                <c:if test="${menus != null}">
                                    <c:forEach items="${menus.values()}" var="menu">
                                        <td>
                                            <c:choose>
                                                <c:when test="${user.menuPerm.get(menu.id) == null or user.menuPerm.get(menu.id) == 0 or (menu.children == null and menu.isdir == 1)}">
                                                    否
                                                </c:when>
                                                <c:when test="${user.menuPerm.get(menu.id) == 1}">
                                                    是
                                                </c:when>
                                                <c:otherwise>
                                                    ${user.menuPerm.get(menu.id)}
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                    </c:forEach>
                                </c:if>
                                <td style="text-align: center">
                                    <a class="" title='编辑' href="edit?userId=${user.userId}">
                                        <i class="fa fa-pencil"></i>&nbsp;编辑
                                    </a>
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
