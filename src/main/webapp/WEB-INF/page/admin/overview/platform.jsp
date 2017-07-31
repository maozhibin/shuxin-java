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
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>数信平台控制台</title>
    <link rel="stylesheet" href="<%=basePath%>static/admin/fonts/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>static/admin/css/console.css">
    <script>
        var clientWidth = null;
        var clientHeight = null;
        function changeSize() {
            clientWidth = document.documentElement.clientWidth;
            clientWidth = clientWidth < 1280 ? 1280 : clientWidth;
            document.documentElement.style.fontSize = parseInt(clientWidth / 1920 * 100) + 'px';
        }
        changeSize();
    </script>
    <script src="<%=basePath%>static/admin/js/echarts.js"></script>
    <script src="<%=basePath%>static/admin/js/console.js"></script>
</head>
<body id="console-page">
<div id="canvas-box">
    <canvas id="bg-canvas"></canvas>
    <div id="mask"></div>
    <div id="line-chart"></div>
    <div id="total">
        <div class="select-box">
            <div class="select-item"><div class="s-select"></div>前一日</div>
            <div class="select-item"><div class="s-select"></div>上周同期</div>
            <div class="select-item"><div class="s-select"></div>上周同期</div>
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
