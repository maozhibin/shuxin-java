
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>新闻查看</title>

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
                    <td> 类型：</td>
                    <td>
                        <select name="newsClassType" class="form-control">
                            <option selected value="">请选择类型</option>
                            <c:forEach items="${options}" var="option">
                                <c:if test="${newsClassType == option.value}"><option selected value="${option.value}">${option.name}</option></c:if>
                                <c:if test="${newsClassType != option.value}"><option value="${option.value}">${option.name}</option></c:if>
                            </c:forEach>

                        </select>
                    </td>
                    <td>
                        <button type="submit" class="btn"><i class="fa fa-search"></i> 搜索</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</section>
<div class="row" style="margin-top: 20px">
    <div class="col-md-12">
        <div class="box-primary">
            <div class="box-body">
                <table id="example2" class="table table-striped table-hover" style="table-layout:fixed">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>类别</th>
                        <th>标题</th>
                        <th>发布日期</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:if test="${page != null && page.result != null}">
                        <c:forEach items="${page.result}" var="news" varStatus="status">
                            <tr>
                                <td>${status.index+1}</td>
                                <td>${news.newsClassType}</td>
                                <td>${news.title}</td>
                                <td>
                                    <jsp:useBean id="dateValue" class="java.util.Date"/>
                                    <jsp:setProperty name="dateValue" property="time" value="${news.dateline*1000}"/>
                                    <fmt:formatDate value="${dateValue}" pattern="yyyy-MM-dd HH:ss:mm"/>
                                </td>
                                <td>
                                    <a class="" title='查看'
                                       href="detail?id=${news.id}"><i class="fa fa-eye"></i> </a>&nbsp;&nbsp;
                                      <a class="" title='编辑'
                                       href="update?id=${news.id}"><i
                                            class="fa fa-pencil"></i> </a>&nbsp;&nbsp;
                                    <a class="delete_button" title='删除' url="delete?id=${news.id}"><i
                                            class="fa fa-trash"></i></a>
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
