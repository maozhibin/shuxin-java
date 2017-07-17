<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yongj
  Date: 7/15/2017
  Time: 1:29 PM
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
    <title>平台概况</title>
    <style>
        .container-fluid {
            background: transparent;
            border: none;
            padding: 0;
        }

        .tab-header {
            margin: 30px 0 15px 10px;
        }

        #survey {
            margin-left: 100px;
        }

        #survey th, #survey tr, #survey td {
            border: none;
        }

        .tab-header span {
            display: inline-block;
            width: 90px;
            line-height: 35px;
            height: 35px;
            text-align: center;
            background: #fff;
            color: #666;
            margin: 0;
            border-right: 1px solid #d8d8d8;
            cursor: pointer;
        }

        span.active {
            background: #1a97f4;
            color: #fff;
        }

        .cnt-data, .ctn-charts, .ctn-tables {
            background: #fff;
            border: 1px solid #ccc;
            padding: 10px;
        }

        .ctn-tables {
            margin-top: 30px;
        }

        .left-charts, .right-charts, .tables-left, .tables-right {
            width: 49%;
            height: 550px;
        }

        .right-charts, .tables-right {
            margin-left: 2%;
        }
    </style>

    <script src='<%=basePath%>static/admin/hcharts/highcharts.js?1499845987'></script>
    <script src='<%=basePath%>static/admin/hcharts/modules/exporting.js?1499845987'></script>
    <script src='<%=basePath%>static/admin/hcharts/modules/data.js?1499845987'></script>
    <script src='<%=basePath%>static/admin/js/chartData.js?1499845987'></script>

</head>
<body>

<!-- Navigation -->
<div id="page-wrapper">

    <div class="container-fluid">
        <!-- 内容区域 -->
        <div class="cnt-data row">
            <h4 class="header">平台概况</h4>
            <hr>
            <table id="survey" class="table text-overflow">
                <tr>
                    <th>总交易额</th>
                    <th>总订单量</th>
                    <th>存证总数</th>
                    <th>交易额日增长比率</th>
                    <th>授权总量</th>
                </tr>
                <tr class="blue-bold text-overflow">
                    <td>${todayAmount}</td>
                    <td>${todayOrdersum}</td>
                    <td>0</td>
                    <td>${todaytradingRate}</td>
                    <td>0</td>
                </tr>
                <tr>
                    <td>昨日 ${yesterdayAmount}</td>
                    <td>昨日 ${yesterdayOrdersum}</td>
                    <td>昨日 0</td>
                    <td>昨日 ${yesterdaytradingRate}</td>
                    <td>昨日 0</td>
                </tr>
                <tr>
                    <td>预计明日 <i class="fa fa-fw fa-long-arrow-down"></i></td>
                    <td>预计明日 <i class="fa fa-fw fa-long-arrow-down"></i></td>
                    <td>预计明日 0</td>
                    <td>预计明日 <i class="fa fa-fw fa-long-arrow-down"></i></td>
                    <td>预计明日 0</td>
                </tr>
            </table>
        </div>
        <div class="tab-header row">
            <span class="tab active" id="today">今日</span>
            <span class="tab" id="yesterday">昨日</span>
            <span class="tab" id="week">最近7天</span>
            <span class="tab" id="month">最近30天</span>
        </div>
        <div class="row">
            <div class="float-left left-charts ctn-charts">
                <div id="tendency"></div>
                <div class="msg"></div>
            </div>
            <div class="float-right right-charts ctn-charts">
                <div id="productUse"></div>
                <div class="msg"></div>
            </div>
        </div>
        <div class="row">
            <div class="float-left tables-left ctn-tables">
                <h4 class="header">TOP10产品购买</h4>
                <table id="purchase" class="table table-bordered table-striped table-hover" style="table-layout:fixed">
                    <thead>
                    <tr>
                        <th>产品名称</th>
                        <th>订单量</th>
                        <th>占比</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${toplist}" var="item">
                        <tr>
                            <td>
                                    ${item.name}
                            </td>
                            <td>
                                    ${item.ordernum}
                            </td>
                            <td>
                                    ${item.percent}
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="float-right tables-right ctn-tables">
                <h4 class="header">合作机构交易总额排名和明细</h4>
                <table id="deal" class="table table-bordered table-striped table-hover" style="table-layout:fixed">
                    <thead>
                    <tr>
                        <th>合作机构名称</th>
                        <th>排名</th>
                        <th>交易总额（元）</th>
                        <th>总订单量</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${orgAmountlist}" var="item">
                        <tr>
                            <td>
                                    ${item.username}
                            </td>
                            <td>
                                    ${item.rank}
                            </td>
                            <td>
                                    ${item.amount}
                            </td>
                            <td>
                                    ${item.num}
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <!-- /.container-fluid -->

</div>
<!-- /#page-wrapper -->
</body>
</html>
