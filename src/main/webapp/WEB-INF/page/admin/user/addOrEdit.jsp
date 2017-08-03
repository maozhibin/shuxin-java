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
    <title>机构用户</title>

    <script src='/static/js/jquery.tagsinput.js?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>'></script>
    <script src='/static/js/jquery.ajaxfileupload.js?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>'></script>
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
	<c:if test="${not empty user.id}">
		<h4 class="header"><a onclick="javascript:;history.back()">机构用户</a> — 修改</h4>
	</c:if>
	<c:if test="${empty user.id}">
		<h4 class="header"><a onclick="javascript:;history.back()">机构用户</a> — 新增</h4>
	</c:if>
	
	
    <form id="from_module_edit" method="post">
    	<input type="hidden" class="input-ctrl" name="id"  id="userId"  value="${user.id}">
    	<div class="container base">
    		<div class="inline-form mb30">
                <label class="col-md-2 control-label">会员名称:</label>
                <c:if test="${empty user.id}">
	                <div class="cell">
	                    <input type="text" class="input-ctrl" name="orgName" id="orgName"
	                           value="${user.username}">
	                </div>
				</c:if>
                <c:if test="${not empty user.id}">
					 <div class="cell">
					 	<span>${user.username}</span>
                	</div>
				</c:if>
            </div><br/>
            
            <div class="inline-form mb30">
                <label class="col-md-2 control-label">用户账户余额:</label>
                <div class="cell">
                    <input type="text" class="input-ctrl" name="moneyBalance" id="moneyBalance"
                           value="${user.moneyBalance }">
                </div>
            </div><br/>
            
            <c:if test="${not empty user.id}">
				<div class="inline-form mb30">
	                <label class="col-md-2 control-label">用户冻结金额:</label>
	                <div class="cell">
	                    <input type="text" class="input-ctrl" name="moneyFreeze" id="moneyFreeze"
	                           value="${user.moneyFreeze }">
	                </div><span class="label label-warning" id= "productNameSpan"></span>
           		</div><br/>
			</c:if>
            
            
            <div class="inline-form mb30">
                <label class="col-md-2 control-label">手机号码:</label>
                <div class="cell">
                    <input type="text" class="input-ctrl" name="mobile" id="mobile"
                           value="${user.mobile }">
                </div>
            </div><br/>
            
            <div class="inline-form mb30">
                <label class="col-md-2 control-label">邮箱地址:</label>
                <div class="cell">
                    <input type="text" class="input-ctrl" name="email" id="email"
                           value="${user.email }">
                </div>
            </div><br/>
            
            <div class="inline-form mb30">
                <label class="col-md-2 control-label">机构实名:</label>
                <div class="cell">
                    <input type="text" class="input-ctrl" name="realName" id="realName"
                           value="${user.realName }">
                </div>
            </div><br/>
            
            <div class="inline-form mb30">
                <label class="col-md-2 control-label">机构统一社会信用编码:</label>
                <div class="cell">
                    <input type="text" class="input-ctrl" name="orgCode" id="orgCode"
                           value="${user.orgCode }">
                </div>
            </div><br/>
            
             <div class="inline-form mb30">
             <label class="col-md-1 control-label"></label>
                <a class="btn btn-info" href="/admin/user/list?typeId=ORG">取消</a>
				<button class="btn btn-primary"  type="submit" value="Submit">保存</button>
            </div><br/>
    	</div>
	</form>
	<script type="text/javascript">
		
		var userId= $('#userId').val();
		$(document).ready(function(){
			  $("#from_module_edit").submit(function(e){
				  if(userId.length==0){//新增
					  $.ajax({
		                    url:'/admin/user/add',
		                    data:$("#from_module_edit").serialize(),
		                    success:function (data) {
		                        if(data.code==1){
		                            alert(data.msg);
		                        }else{
		                            window.location.href="/admin/user/list?typeId=ORG";
		                        }
		                    }
		                });
					}else{
						$.ajax({
			                  url:'/admin/user/update',
			                  data:$("#from_module_edit").serialize(),
			                  success:function (data) {
			                      if(data.code==1){
			                           alert(data.msg);
			                      }else{
			                            window.location.href="/admin/user/list?typeId=ORG";
			                      }
			                    }
			             });
					}
				  return false;
			  });
			});
		
		
	</script>
</body>
</html>
