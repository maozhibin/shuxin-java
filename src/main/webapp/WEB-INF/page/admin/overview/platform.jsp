<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

    <script src='<%=basePath%>static/admin/js/bootstrap.js'></script>
    <script src='<%=basePath%>static/admin/js/echarts.js'></script>
    <script src='<%=basePath%>static/admin/js/index2.js'></script>
    <script src='<%=basePath%>static/admin/js/console.js'></script>

</head>
<body>


    <div id="canvas-box">
        <canvas id="bg-canvas"></canvas>
        <div id="mask"></div>
        <div id="line-chart"></div>
        <div id="total">
            <div class="select-box">
                <div class="select-item" id="lastDay"><div class="s-select"></div>前一日</div>
                <div class="select-item" id="lastWeek"><div class="s-select"></div>上周同期</div>
            </div>
            <div class="title">平台数据概况</div>
            <div class="total-number"><span class="item-icon"></span>196.87<span class="tip"> &#8593;</span></div>
            <div class="number-tip">总交易额(万元)</div>
            <div class="rate"><span class="item-icon"></span>7.59%<span class="tip"> &#8595;</span></div>
            <div class="rate-tip">交易额日增长比率</div>
        </div>
        <div id="pie-chart"></div>
        <div id="top-data">
            <div class="product-data">
                <div class="head">TOP3 产品购买<a class="product-detail" href="">详细&#8250;</a></div>
                <table>
                    <thead>
                        <tr>
                            <th></th>
                            <th>产品名称</th>
                            <th>订单量</th>
                            <th>占比</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><span class="table-item-icon"></span></td>
                            <td>产品1</td>
                            <td>14</td>
                            <td>10%</td>
                        </tr>
                        <tr>
                            <td><span class="table-item-icon"></span></td>
                            <td>产品2</td>
                            <td>12</td>
                            <td>8.57%</td>
                        </tr>
                        <tr>
                            <td><span class="table-item-icon"></span></td>
                            <td>产品3</td>
                            <td>4</td>
                            <td>2.86%</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="business-data">
                 <div class="head">TOP3 合作机构交易总额排名和明细<a class="business-detail" href="">详细&#8250;</a></div>
                <table>
                    <thead>
                        <tr>
                            <th></th>
                            <th>合作机构名称</th>
                            <th>交易总额(万元)</th>
                            <th>总订单量</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><span class="table-item-icon"></td>
                            <td>产品1</td>
                            <td>14</td>
                            <td>10%</td>
                        </tr>
                        <tr>
                            <td><span class="table-item-icon"></td>
                            <td>产品2</td>
                            <td>12</td>
                            <td>8.57%</td>
                        </tr>
                        <tr>
                            <td><span class="table-item-icon"></td>
                            <td>产品3</td>
                            <td>4</td>
                            <td>2.86%</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
