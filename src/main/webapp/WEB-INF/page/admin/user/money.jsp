<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: yongj
  Date: 7/13/2017
  Time: 2:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
            + "/";
    String requestUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
            + request.getAttribute("javax.servlet.forward.request_uri").toString();
%>
<html>
<head>
    <title>用户资金流动</title>
    <style>
        td {
            padding: 10px;
        }

        .row {
            font-size: 14px;
            color: #999;
            letter-spacing: 0;
            text-align: left;
            margin: 5px 8px;
        }
    </style>
    <script type="text/javascript">
        $(document).ready(function () {
            $('.datepicker').datepicker({
                language: 'cn',
                todayHighlight: true
            });
        });
    </script>
    <script src='/static/admin/plugins/datepicker/bootstrap-datepicker.js?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>'></script>
    <link href='/static/admin/plugins/datepicker/datepicker3.css?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>' rel="stylesheet" type="text/css"/>
</head>
<body>
<h3 class="header">资金变动记录</h3>
<section class="filter-box" style="border:none">
    <div class="row">
        <form class="form-inline" method="post">
            <table>
                <tr>
                    <td> 资金类型：</td>
                    <td>
                        <select name="type">
                        	<option value="" <c:if test="${typeValue eq ''}">selected="selected"</c:if>>全部</option>
                        	<option value="consume" <c:if test="${typeValue eq 'consume'}">selected="selected"</c:if>>消费</option>
                        	<option value="recharge" <c:if test="${typeValue eq 'recharge'}">selected="selected"</c:if>>充值</option>
                        	<option value="buy_product" <c:if test="${typeValue eq 'buy_product'}">selected="selected"</c:if>>购买</option>
                        </select>
                    </td>
                    <td> 起始时间：</td>
                    <td>
                        <input class="form-control datepicker" data-date-format="yyyy-mm-dd" type="text"
                               name="startTime"  value="${startTime}"/>
                    </td>
                    <td> -</td>
                    <td>
                        <input class="form-control datepicker" data-date-format="yyyy-mm-dd" type="text" name="endTime"
                               value="${endTime}"/>
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
                        <th>资金类型</th>
                        <th>金额</th>
                        <th>时间</th>
                        <th>备注</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${page != null && page.result != null}">
                        <c:forEach items="${page.result}" var="UserMoneyLog">
                            <tr>
                                <td>
                                    <c:if test="${UserMoneyLog.type eq 'buy_product'}">
                                        购买
                                    </c:if>
                                    <c:if test="${UserMoneyLog.type eq 'consume'}">
                                        消费
                                    </c:if>
                                    <c:if test="${UserMoneyLog.type eq 'recharge'}">
                                        充值
                                    </c:if>
                                </td>
                                <td>${UserMoneyLog.amount}</td>
                                <td>
                                	<jsp:useBean id="dateObject" class="java.util.Date"></jsp:useBean>
									<jsp:setProperty property="time" name="dateObject" value="${UserMoneyLog.finishTime*1000}"/>
									<fmt:formatDate value="${dateObject}" pattern="yyyy-MM-dd" /> 
									
                                </td>
                                <td>${UserMoneyLog.remark}</td>
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
