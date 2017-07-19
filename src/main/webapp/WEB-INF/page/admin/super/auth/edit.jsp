<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<div class="row" style="border-top: none;">
    <div class="col-md-12">
        <div class="box-primary">
            <div class="box-body">
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
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${user != null}">
                        <tr>
                            <td>${user.username}</td>
                            <td><fmt:formatDate value="${user.lastLoginTime}" pattern="yyyy-MM-dd hh:ss:mm"/></td>
                            <c:if test="${menus != null}">
                                <c:forEach items="${menus.values()}" var="menu">
                                    <td>
                                        <c:choose>
                                            <c:when test="${user.menuPerm.get(menu.id) == null or user.menuPerm.get(menu.id) == 0}">
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
                        </tr>
                    </c:if>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<form action="<%=basePath%>admin/super/auth/update" method="post">
    <input name="userId" value="${user.userId}" hidden="hidden">
    <div class="row" style="border-top: none;">
        <div class="col-md-12">
            <div class="box-primary">
                <div class="box-body">
                    <ul class="">
                        <c:if test="${menus != null}">
                            <c:forEach items="${menus.values()}" var="menu">
                                <%@include file="recursive.jsp" %>
                            </c:forEach>
                        </c:if>
                    </ul>
                    <button type="submit" class="btn" id="submit">提交</button>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>
