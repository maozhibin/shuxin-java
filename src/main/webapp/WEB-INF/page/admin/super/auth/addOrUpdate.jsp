<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>管理员用户</title>

    <script src='<%=basePath%>static/js/jquery.tagsinput.js?1.0'></script>
    <script src='<%=basePath%>static/js/jquery.ajaxfileupload.js?1.0'></script>
    <style>
        td {
            padding: 10px;
        }
    </style>
    <script type="text/javascript">
        function myfunction(){//js表单验证方法

        }
    </script>
</head>
<body>
 <h4 class="header"><a onclick="javascript:;history.back()">管理用户</a> — 新增</h4>

<form id="from_module_edit" method="post">
    <input type="hidden" class="input-ctrl" name="id"  value="${adminUser.id}">
    <div class="container base">
        <div class="inline-form mb30">
            <label class="col-md-2 control-label">管理员名称:</label>
            <div class="cell">
                <input type="text" class="input-ctrl" name="userName" id="userName"
                       value="${adminUser.username}">
            </div>
        </div><br/>

        <div class="inline-form mb30">
                <label class="col-md-2 control-label">管理员密码:</label>
                <div class="cell">
                    <input type="password" class="input-ctrl" name="password" id="password"
                           value="">
                </div>
         </div><br/>
        <div class="inline-form mb30">
            <label class="col-md-2 control-label">确认密码:</label>
            <div class="cell">
                <input type="password" class="input-ctrl" name="copyPassword" id="copyPassword"
                       value="">
            </div>
        </div><br/>
        <div class="inline-form mb30">
            <label class="col-md-1 control-label"></label>
            <a class="btn btn-info" href="list">取消</a>
            <button class="btn btn-primary"  type="submit" value="Submit">保存</button>
        </div><br/>
    </div>
</form>
<script type="text/javascript">


    $(document).ready(function(){
        $("#from_module_edit").submit(function(e){
            $.ajax({
                url:'/admin/super/auth/addAdmin',
                data:$("#from_module_edit").serialize(),
                success:function (data) {
                    if(data.code==1){
                        alert(data.msg);
                    }else{
                        window.location.href="/admin/super/auth/list";
                    }
                }
            });
            return false;
        });
    });

</script>
</body>
</html>
