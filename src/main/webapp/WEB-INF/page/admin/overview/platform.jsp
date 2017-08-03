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
    <link rel="stylesheet" href="/static/admin/fonts/iconfont.css?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>">
    <link rel="stylesheet" href="/static/admin/css/console.css?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>">
    <style>
    html,body{
        background: url('/static/admin/images/bj.png');
    }
    </style>
    <script>
        var clientWidth = null;
        var clientHeight = null;
        function changeSize() {
            clientWidth = document.documentElement.clientWidth;
            clientWidth = clientWidth < 1280 ? 1280 : clientWidth;
            document.documentElement.style.fontSize = parseInt(clientWidth / 1920 * 100) + 'px';
        }
        changeSize();
        window.resize=changeSize();
    </script>
    <script src="/static/admin/js/echarts.js?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>"></script>
    <script src="/static/admin/js/console.js?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>"></script>
</head>
<body id="console-page">
<div id="canvas-box">
    <canvas id="bg-canvas"></canvas>
    <div id="mask"></div>
    <div id="line-chart"></div>
    <div id="total">
        <div class="total-number"><span class="item-icon"></span>
       		<fmt:formatNumber type="number" value="${hashMap.moneyCount.todaytAmount /10000}" pattern="0.00" maxFractionDigits="2"/>  
	        <c:if test="${hashMap.moneyCount.todaytAmount  gt hashMap.moneyCount.yesterdaytAmount}">
	               <span class="tip">&#8593;</span><!-- 上 -->                        	
	        </c:if>
	       <c:if test="${hashMap.moneyCount.todaytAmount  lt hashMap.moneyCount.yesterdaytAmount}">
	               <span class="tip">&#8595;</span>                        	
	      </c:if>
        </div>
        <div class="number-tip">总交易额(万元)</div>
       
        <c:if test="${hashMap.moneyCount.todaytAmount  gt hashMap.moneyCount.yesterdaytAmount}">
	         <div class="rate"><span class="item-icon"></span>
	         <fmt:formatNumber value="${(hashMap.moneyCount.todaytAmount -hashMap.moneyCount.yesterdaytAmount)/hashMap.moneyCount.todaytAmount }" pattern="0.00" maxFractionDigits="2" />%
	         <span class="tip"> &#8593;</span><!--下--></div>
       		 <div class="rate-tip">交易额日增长比率</div>                     	
	    </c:if>
	    <c:if test="${hashMap.moneyCount.todaytAmount  lt hashMap.moneyCount.yesterdaytAmount}">
	       <div class="rate"><span class="item-icon"></span>
	       <fmt:formatNumber value="${(hashMap.moneyCount.yesterdaytAmount -hashMap.moneyCount.todaytAmount)/hashMap.moneyCount.yesterdaytAmount }" pattern="0.00" maxFractionDigits="2" />%
	       <span class="tip"> &#8595;</span><!--下--></div>
      	   <div class="rate-tip">交易额日下降比率</div>                        	
	    </c:if>
        
    </div>
    <div id="pie-chart"></div>
    <div id="top-data" class="flex-row">
        <div class="product-data">
            <div class="head">TOP3 产品购买<a class="product-detail" href="/admin/overview/product">详细&#8250;</a></div>
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
                <c:forEach items="${hashMap.productTop}" var="item" end="2">
                    <tr>
                        <td><span class="table-item-icon"></span></td>
                        <td>${item.name}</td>
                        <td>${item.order_num}</td>
                        <td>${item.rate}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="business-data">
            <div class="head">TOP3 合作机构交易总额排名和明细<a class="business-detail" href="/admin/overview/organization">详细&#8250;</a></div>
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
                <c:forEach items="${hashMap.orgTop}" var="item" end="2">
                    <tr>
                        <td><span class="table-item-icon"></td>
                        <td>${item.username}</td>
                        <td>${item.total_amount}</td>
                        <td>${item.order_num}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
<script>
// 路径配置
    require.config({
        paths: {
            echarts: 'http://echarts.baidu.com/build/dist'
        }
    });

    // 图表数据
    var name1,name2,name3,data1,data2,data3;
    $.ajax({
        "url": "/admin/overview/moneyProfile",
        "data":{"types": [0,-1,-7]},
        async:false,
        "type": "GET",
        "cache": false,
        "success": function (result) {
           var name=[],data=[];
            for(var k in result){
                name.push(k);
                data.push(result[k]);
            }
            name1=name[0];
            name2=name[1];
            name3=name[2];
            data1=data[0];
            data2=data[1];
            data3=data[2];
            console.log(name);
            console.log(data);
        }
    });

    // 使用
    require(
        [
            'echarts',
            'echarts/chart/line' // 使用柱状图就加载bar模块，按需加载
        ],
        function (ec) {
            // 基于准备好的dom，初始化echarts图表
            var myChart = ec.init(document.getElementById('line-chart'));

            var option = {
                title : {
                    text: '平台数据概况',
                    subtext: '纯属虚构'
                },
                tooltip : {
                    trigger: 'axis'
                },
                legend: {
                    data:[name1,name2,name3]
                },
                toolbox: {
                    show : true,
                    feature : {
                        mark : {show: false},
                        dataView : {show: false, readOnly: false},
                        magicType : {show: false, type: ['line', 'bar', 'stack', 'tiled']},
                        restore : {show: false},
                        saveAsImage : {show: false}
                    }
                },
                calculable : true,
                xAxis : [
                    {
                        type : 'category',
                        boundaryGap : false,
                        data : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23]
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : [
                    {
                        name:'成交',
                        type:'line',
                        smooth:true,
                        itemStyle: {normal: {areaStyle: {type: 'default'}}},
                        data:data1
                    },
                    {
                        name:'前一日',
                        type:'line',
                        smooth:true,
                        itemStyle: {normal: {areaStyle: {type: 'default'}}},
                        data:data2
                    },
                    {
                        name:'上周同期',
                        type:'line',
                        smooth:true,
                        itemStyle: {normal: {areaStyle: {type: 'default'}}},
                        data:data3
                    }
                ]
            };

            // 为echarts对象加载数据
            myChart.setOption(option);
        }
    );

</script>
