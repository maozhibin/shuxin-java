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
 <link href='/static/admin/plugins/daterangepicker/daterangepicker.css?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>' rel="stylesheet" type="text/css"/>
 <link href='/static/admin/plugins/datepicker/datepicker3.css?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>' rel="stylesheet" type="text/css"/>
 <link href='/static/admin/plugins/colorpicker/bootstrap-colorpicker.min.css?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>' rel="stylesheet" type="text/css"/>
 <link href='/static/admin/plugins/timepicker/bootstrap-timepicker.min.css?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>' rel="stylesheet" type="text/css"/>
 <link href='/static/admin/plugins/select2/select2.min.css?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>' rel="stylesheet" type="text/css"/>
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
<html>
<head>
    <style>
    td {
        word-break: break-all;
        word-wrap:break-word;
    }
</style>
</head>
<body>
<div class="row">
        <div class="row">
            <div class="col-md-12">
                <section class="tile color transparent-black">
                    <!-- tile body -->
                    <div class="tile-body nopadding">
                        <!--                        <table id="datatable1"-->
                        <!--                               class="datatable table table-striped table-bordered table-hover" style="table-layout:fixed;">-->
                        <table id="data_table" class="table table-bordered table-sortable">
                            <thead>
                            <tr>
                                <td>ip</td>
                                <td>时间</td>
                                <td>操作</td>
                            </tr>
                            </thead>
                            <tbody>
                                 <c:if test="${page != null && page.result != null}">
		                        <c:forEach items="${page.result}" var="IpLock">
		                            <tr>
		                                <td>${IpLock.ip}</td>
		                                <td>
                               				<jsp:useBean id="dateValue" class="java.util.Date"/>
											<jsp:setProperty name="dateValue" property="time" value="${IpLock.dateline*1000}"/>
											<fmt:formatDate value="${dateValue}" pattern="yyyy-MM-dd hh:ss:mm"/>
                             	  		 </td>
                             	  		 <td>
	                             	  		 <a href="debLockingIp?id=${IpLock.id}" type="button" class="btn btn-info" >解锁</a>
                                         </td>
		                            </tr>
		                        </c:forEach>
		                    </c:if>
                            </tbody>
                        </table>
                    </div>
                    <%@include file="/WEB-INF/page/admin/pager.jsp"%>
                </section>
            </div>
        </div>
  </div>
<script>
    function nav(pageNo) {
        location.href="?pageNo="+pageNo;
    }
</script>
</body>
</html>
