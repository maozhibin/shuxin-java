<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
%>
<html>
<head>
    <title>角色权限</title>

    <script src='/static/js/jquery.tagsinput.js?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>'></script>
    <script src='/static/js/jquery.ajaxfileupload.js?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>'></script>
    <style>
        td {
            padding: 10px;
        }
        
         ul{
		 float:left;
		}
    </style>
    <script type="text/javascript">
        function myfunction(){//js表单验证方法

        }
    </script>
</head>
<body>
	<c:if test="${not empty adminUser.id}">
		<h4 class="header"><a onclick="javascript:;history.back()">角色权限</a> — 修改</h4>
	</c:if>
	<c:if test="${empty adminUser.id}">
		<h4 class="header"><a onclick="javascript:;history.back()">角色权限</a> — 新增</h4>
	</c:if>
<form id="from_module_edit" method="post" class="form-inline">
    <input type="hidden" class="form-control" name="id"  value="${adminUser.id}">
    <div class="container base">
        
        <div class="inline-form mb30">
        	
	        <ul class="col-md-1">
	           <li >
			 		1
			   </li>
			 </ul>
			 <ul class="col-md-1">
	           <li>
			 		33
			   </li>
			 </ul>
        </div><br/>
        <div class="inline-form mb30">
            <label class="col-md-1 control-label"></label>
            <a class="btn btn-info" href="list">取消</a>
            <button class="btn btn-primary"  type="submit" value="Submit">保存</button>
        </div><br/>
    </div>
</form>
<script type="text/javascript">

</script>
</body>
</html>
