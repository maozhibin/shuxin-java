<%--
  Created by IntelliJ IDEA.
  User: yongj
  Date: 7/15/2017
  Time: 2:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>产品列表</title><style>
    td {
        padding: 10px;
    }
</style>
</head>
<body>

<section class="filter-box" style="border:none">
    <div class="row">
    	 <form class="form-inline">
            <table style="margin-left: 30px">
                <tr>
                    <td>
                        <input class="form-control" type="text" name="name"
                               value="${name}" placeholder="请输入搜索的关键词" />
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
                <!--                <div style="margin-bottom: 8px">--><?//= '总计' . $count . '条' ?><!--</div>-->
                <table id="example2" class="table table-striped table-hover" style="table-layout:fixed">
                    <thead>
                    <tr>
                        <th>发布时间</th>
                        <th>产品名称</th>
                        <th>类型</th>
                        <th>状态</th>
                        <th>定价</th>
                        <th>覆盖范围</th>
                        <th>供应商</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                     <c:if test="${page != null && page.result != null}">
                        <c:forEach items="${page.result}" var="map">
                             <tr>
                             	 <td>
                               		<jsp:useBean id="dateValue" class="java.util.Date"/>
									<jsp:setProperty name="dateValue" property="time" value="${map.dateline*1000}"/>
									<fmt:formatDate value="${dateValue}" pattern="yyyy-MM-dd "/>
                             	 </td>
		                        <td>${map.name}</td>
		                        <td>${map.type}</td>
		                        <td>${map.status}</td>
		                        <td>${map.price}</td>
		                        <td>${map.areaName}</td>
		                         <td>${map.seller}</td>
		                        <td>
		                        	 <a class="" title='查看'
		                                       href=""><i
		                                            class="fa fa-eye"></i> </a>&nbsp;&nbsp;
		                             <a class="" title='查看'
		                                       href="}"><i
		                                            class="fa fa-pencil"></i> </a>&nbsp;&nbsp;
		                             <a class="" title='查看'
		                                       href=""><i
		                                            class="fa fa-trash"></i> </a>&nbsp;&nbsp;             
		                        </td>
		                    </tr>
                        </c:forEach>
                    </c:if>
                   
                    </tbody>
                </table>
                <div class="col-sm-12" style="text-align: center">
                    <span class="float-left"
                          style="line-height: 40px;">共${page.totalRecordCount}条，每页15条</span>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
