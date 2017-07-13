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
    <title>用户资金流动</title>
<style>
    td {
        padding: 10px;
    }
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
<h3 class="header">资金变动记录</h3>
<section class="filter-box" style="border:none">
    <div class="row">
        <form class="form-inline">
            <table>
            <tr>
                <td> 资金类型：</td>
                <td>
                    <select name="type">
                        <option value="">全部</option>
                    </select>
                </td>
                <td> 起始时间：</td>
                <td>
                    <input class="form-control datepicker" data-date-format="yyyy-mm-dd" type="text" name="start_time"
                           value=""/>
                </td>
                <td> -</td>
                <td>
                    <input class="form-control datepicker" data-date-format="yyyy-mm-dd" type="text" name="end_time"
                           value=""/>
                </td>
                <td>
                    <button type="" class="btn"><i class="fa fa-search"></i> 搜索</button>
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
                        <c:forEach items="${page.result}" var="user">
                            <tr>
                                <td>${UserMoneyLog.type}</td>
                                <td>${UserMoneyLog.amount}</td>
                                <td>${UserMoneyLog.finishTime}</td>
                                <td>${UserMoneyLog.remark}</td>
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
