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
        <c:when test="${menu.children != null}">
            <a href="javascript:;" data-toggle="collapse" data-target="#menu${menu.id}">
                <c:if test="${menu.ico != null and menu.ico != ''}">
                    <i class="fa fa-fw fa-${menu.ico}"></i>
                </c:if>
                    ${menu.name}
                <c:if test="${menu.children != null}">
                    <i class="fa fa-fw fa-caret-down"></i>
                </c:if>
            </a>
            <ul id="menu${menu.id}" class="collapse" href="${menu.uri}">
                <c:forEach items="${menu.children.values()}" var="child">
                    <c:set var="menu" value="${child}" scope="request"/>
                    <c:set var="basePath" value="${basePath}" scope="request"/>
                    <jsp:include page="menu_recursive.jsp"/>
                </c:forEach>
            </ul>
        </c:when>
        <c:when test="${menu.children == null and menu.isdir == 0}">
            <a href='<c:if test="${menu.isdir == 0}">${basePath}${menu.uri}</c:if>' data-toggle="collapse" data-target="#menu${menu.id}">
                <c:if test="${menu.ico != null and menu.ico != ''}">
                    <i class="fa fa-fw fa-${menu.ico}"></i>
                </c:if>
                    ${menu.name}
                <c:if test="${menu.children != null}">
                    <i class="fa fa-fw fa-caret-down"></i>
                </c:if>
            </a>
        </c:when>
    </c:choose>
</li>
