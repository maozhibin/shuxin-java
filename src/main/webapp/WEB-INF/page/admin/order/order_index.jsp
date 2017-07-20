<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
            + "/";
%>
<html>
<head>
    <title>订单</title>
    <style>
        td {
            word-break: break-all;
            word-wrap: break-word;
            padding: 10px;
        }
    </style>

    <link href='<%=basePath%>static/admin/plugins/daterangepicker/daterangepicker.css?1.0' rel="stylesheet"
          type="text/css"/>
    <link href='<%=basePath%>static/admin/plugins/datepicker/datepicker3.css?1.0' rel="stylesheet" type="text/css"/>
    <link href='<%=basePath%>static/admin/plugins/colorpicker/bootstrap-colorpicker.min.css?1.0' rel="stylesheet"
          type="text/css"/>
    <link href='<%=basePath%>static/admin/plugins/timepicker/bootstrap-timepicker.min.css?1.0' rel="stylesheet"
          type="text/css"/>
    <link href='<%=basePath%>static/admin/plugins/timepicker/bootstrap-timepicker.min.css?1.0' rel="stylesheet"
          type="text/css"/>
    <link href='<%=basePath%>static/admin/plugins/fullcalendar/fullcalendar.min.css?1.0' rel="stylesheet"
          type="text/css"/>
    <link href='<%=basePath%>static/admin/plugins/datatables/dataTables.bootstrap.css?1.0' rel="stylesheet"
          type="text/css"/>
    <link href='<%=basePath%>static/admin/plugins/ad_yzt.css?1.0' rel="stylesheet" type="text/css"/>
    <link href='<%=basePath%>static/admin/plugins/select2/select2.min.css?1.0' rel="stylesheet" type="text/css"/>

    <script src='<%=basePath%>static/admin/js/laydate/laydate.js?1.0'></script>
    <script src='<%=basePath%>static/admin/plugins/select2/select2.full.min.js?1.0'></script>
    <script src='<%=basePath%>static/admin/plugins/daterangepicker/moment.min.js?1.0'></script>
    <script src='<%=basePath%>static/admin/plugins/daterangepicker/daterangepicker.js?1.0'></script>
    <script src='<%=basePath%>static/admin/plugins/datepicker/bootstrap-datepicker.js?1.0'></script>
    <script src='<%=basePath%>static/admin/plugins/fullcalendar/fullcalendar2.js?1.0'></script>
    <script src='<%=basePath%>static/admin/plugins/fullcalendar/locale-all.js?1.0'></script>
    <script src='<%=basePath%>static/admin/plugins/datatables/jquery.dataTables.min.js?1.0'></script>
    <script src='<%=basePath%>static/admin/plugins/datatables/dataTables.bootstrap.min.js?1.0'></script>

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

            function doFilter(url) {
                document.location.href = url;
            }

            $("#search-btn").click(function () {
                var id = $("#user_id").val() ? $("#user_id").val() : -1;
//                var url = "<?php echo base_url("admin/order/user_order");?>" + "/1/choosetime/"+ $("#domain").val()+"/"+id+ "/" + g_start_time_str + "/" + g_end_time_str + ".html";
                var url = "<%=basePath%>admin/order/list";
                doFilter(url);
                return false;
            });
        });
    </script>
</head>
<body>
<section>
    <div class="row">
        <form action="" class="form-inline" method="post" accept-charset="utf-8">
            <table style="margin-left: 30px">
                <tbody>
                <tr>
                    <td> 类型：</td>
                    <td>
                        <select name="status" class="form-control" id="domain">
                            <option value="">全部</option>
                            <c:forEach items="${order}" var="option">
                                <option value="${option.value}">${option.name}
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                    <td> ID：</td>
                    <td>
                        <input type="text" class="form-control pull-right" id="user_id" placeholder="用户ID"
                               name="userId">
                    </td>
                    <td> 日期：</td>
                    <td>
                        <input type="text" class="form-control pull-right" id="date_range" name="date_range">
                    </td>
                    <td>
                        <button type="submit" class="btn"><i class="fa fa-search"></i> 筛选</button>
                    </td>
                </tr>
                </tbody>
            </table>
        </form>
    </div>
</section>
<div class="row">
    <div class="col-md-12">
        <section class="tile color transparent-black">
            <div class="tile-body nopadding">
                <table id="data_table" class="table table-sortable">
                    <thead>
                    <tr>
                        <td>用户编号</td>
                        <td>产品名称</td>
                        <td>购买金额</td>
                        <td>支付金额</td>
                        <td>状态</td>
                        <td>投资记录流水号</td>
                        <td>购买时间</td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${page != null && page.result != null}">
                        <c:forEach items="${page.result}" var="order">
                            <tr>
                                <td>${order.userId}</td>
                                <td>${order.productId}</td>
                                <td>${order.buyAmount}</td>
                                <td>${order.payAmount}</td>
                                <td>${order.status}</td>
                                <td>${order.requestNo}</td>
                                <td>
                                    <jsp:useBean id="dateValue" class="java.util.Date"/>
                                    <jsp:setProperty name="dateValue" property="time" value="${order.buyTime*1000}"/>
                                    <fmt:formatDate value="${dateValue}" pattern="yyyy-MM-dd hh:ss:mm"/>
                                </td>

                            </tr>
                        </c:forEach>
                    </c:if>
                    </tbody>


                </table>
            </div>
            <!-- /BOX -->
            <div class="row">
                <div class="col-sm-12">
                    <div class="pull-left">
                    </div>
                    <div class="pull-right">
                        <div class="dataTables_paginate paging_bs_full" id="datatable1_paginate">
                            <ul class="pagination">

                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
</div>

</body>
</html>
