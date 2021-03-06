<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yongj
  Date: 7/15/2017
  Time: 1:33 PM
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
    <title>机构交易概况</title>
    <style>
        .container-fluid {
            background: transparent;
            border: none;
            padding: 0;
        }

        td {
            padding: 10px;
        }

        .ctn-tables {
            background: #fff;
            border: 1px solid #ccc;
            padding: 10px;
        }
    </style>

    <link href='/static/admin/plugins/daterangepicker/daterangepicker.css?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>' rel="stylesheet" type="text/css"/>
    <link href='/static/admin/plugins/datepicker/datepicker3.css?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>' rel="stylesheet" type="text/css"/>
    <link href='/static/admin/plugins/colorpicker/bootstrap-colorpicker.min.css?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>' rel="stylesheet" type="text/css"/>
    <link href='/static/admin/plugins/timepicker/bootstrap-timepicker.min.css?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>' rel="stylesheet" type="text/css"/>
    <link href='/static/admin/plugins/timepicker/bootstrap-timepicker.min.css?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>' rel="stylesheet" type="text/css"/>
    <link href='/static/admin/plugins/fullcalendar/fullcalendar.min.css?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>' rel="stylesheet" type="text/css"/>
    <link href='/static/admin/plugins/datatables/dataTables.bootstrap.css?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>' rel="stylesheet" type="text/css"/>
    <link href='/static/admin/plugins/ad_yzt.css?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>' rel="stylesheet" type="text/css"/>


    <script src='/static/admin/js/laydate/laydate.js?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>'></script>
    <script src='/static/admin/plugins/select2/select2.full.min.js?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>'></script>
    <script src='/static/admin/plugins/daterangepicker/moment.min.js?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>'></script>
    <script src='/static/admin/plugins/daterangepicker/daterangepicker.js?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>'></script>
    <script src='/static/admin/plugins/datepicker/bootstrap-datepicker.js?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>'></script>
    <script src='/static/admin/plugins/fullcalendar/fullcalendar2.js?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>'></script>
    <script src='/static/admin/plugins/fullcalendar/locale-all.js?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>'></script>
    <script src='/static/admin/plugins/datatables/jquery.dataTables.min.js?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>'></script>
    <script src='/static/admin/plugins/datatables/dataTables.bootstrap.min.js?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>'></script>

    <script type="text/javascript">
        $(document).ready(function () {
            var g_start_time_str = "";
            var g_end_time_str = "";
            var g_start = moment(${startTime});
            var g_end = moment(${endTime});
            function cb(start, end) {
                g_start_time_str = start.format('YYYY-MM-DD');
                g_end_time_str = end.format('YYYY-MM-DD');
            }

            $('#date_range').daterangepicker({
                startDate: g_start,
                endDate: g_end,
                ranges: {
                    '今天': [moment(), moment()],
                    '昨天': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
                    '最近七天': [moment().subtract(6, 'days'), moment()],
                    '最近30天': [moment().subtract(29, 'days'), moment()],
                    '本月': [moment().startOf('month'), moment().endOf('month')],
                    '上一月': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
                }
            }, cb);
            cb(g_start, g_end);
        });
    </script>

</head>
<body>

<div class="row tables-left ctn-tables">
    <h4 class="header">TOP10 合作机构交易总额排名和明细</h4>
    <table id="purchase" class="table table-bordered table-striped table-hover" style="table-layout:fixed">
        <thead>
        <tr>
            <th>合作机构名称</th>
            <th>排名</th>
            <th>交易总额(万元)</th>
            <th>总订单量</th>
            <th>购买最多产品名称|购买次数</th>
            <th>存证总数</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${hashMap.orgTop}" var="item" varStatus="status">
                  <tr>
	                <td>
	                        ${item.username}
	                </td>
	                <td>
	                		${status.index+1}
	                </td>
	                <td>
	                        ${item.total_amount /10000}
	                </td>
	                <td>
	                        ${item.order_num}
	                </td>
	                <td>
	                        ${item.productName}	|	${item.num}
	                </td>
	                <td>
							${item.receipt_num}
	                </td>
	            </tr>          
            </c:forEach>
        </tbody>
    </table>
</div>
<div class="row tables-right ctn-tables">
    <form action="/admin/overview/organization" class="form-inline" method="post"
          accept-charset="utf-8">
        <table>
            <tbody>
            <tr>
            <!-- 
                <td> 筛选：</td>
                <td>
                    <select name="search-type" class="form-control" id="domain">
                        <option>北京</option>
                        <option>浙江</option>
                    </select>
                </td> -->
                <td> 关键字：</td>
                <td>
                    <input type="text" class="form-control pull-right" id="keywords" name="orgName"
                           value="${keywords}"
                           placeholder="请输入合作机构名称">
                </td>
                <!-- 
                <td> 日期：</td>
                <td>
                    <input type="text" class="form-control pull-right" id="date_range">
                </td> -->
                <td>
                    <button type="submit" class="btn"><i class="fa fa-search"></i> 搜索</button>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
    <table id="deal" class="table table-bordered table-striped table-hover" style="table-layout:fixed">
        <thead>
        <tr>
            <th>合作机构名称</th>
            <th>排名</th>
            <th>交易总额(万元)</th>
            <th>总订单量</th>
            <th>购买最多产品名称 | 购买次数</th>
            <th>存证总数</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${page != null && page.result != null}">
            <c:forEach items="${page.result}" var="item" varStatus="status">
                 <tr>
	                <td>
	                        ${item.username}
	                </td>
	                <td>
	                		${status.index+1}
	                </td>
	                <td>
	                        ${item.total_amount /10000}
	                </td>
	                <td>
	                        ${item.order_num}
	                </td>
	                <td>
	                        ${item.productName}	|	${item.num}
	                </td>
	                <td>
							${item.receipt_num}
	                </td>
	            </tr>          
            </c:forEach>
        </c:if>
        </tbody>
    </table>
    <%@include file="/WEB-INF/page/admin/pager.jsp"%>
</div>

</body>
</html>
