<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yongj
  Date: 7/19/2017
  Time: 9:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<li>
    <c:choose>
        <c:when test="${user.menuPerm != null and user.menuPerm.get(menu.id) != null and user.menuPerm.get(menu.id) > 0}">
            <input type="checkbox" id="#authmenu${menu.id}" name="menuId" value="${menu.id}" checked="checked">
        </c:when>
        <c:otherwise>
            <input type="checkbox" id="#authmenu${menu.id}" name="menuId" value="${menu.id}">
        </c:otherwise>
    </c:choose>
    <a href="javascript:;" data-toggle="collapse" data-target="#authmenu${menu.id}">
        <c:if test="${menu.ico != null and menu.ico != ''}">
            <i class="fa fa-fw fa-${menu.ico}"></i>
        </c:if>
        ${menu.name}
        <c:if test="${menu.children != null}">
            <i class="fa fa-fw fa-caret-down"></i>
        </c:if>
    </a>
    <ul id="authmenu${menu.id}" class="collapse in" href="${menu.uri}">
        <c:if test="${menu.children != null}">
            <c:forEach items="${menu.children.values()}" var="child">
                <c:set var="menu" value="${child}" scope="request"/>
                <jsp:include page="recursive.jsp"/>
            </c:forEach>
        </c:if>
    </ul>
</li>
