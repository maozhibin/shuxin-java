<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yongj
  Date: 7/13/2017
  Time: 2:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户列表</title>
    <style>
        td {
            padding: 10px;
        }
    </style>
</head>
<body>
	<c:if test="${not empty config.id}">
		<h4 class="header"><a onclick="javascript:;history.back()">参数配置</a> — 修改</h4>
	</c:if>
	<c:if test="${empty config.id}">
		<h4 class="header"><a onclick="javascript:;history.back()">参数配置</a> — 新增</h4>
	</c:if>
	
    <form id="from_module_edit" method="post">
    	<input type="hidden" id="typeValue" value="${config.id}" name="id" />
		<div class="row">
     	   <div class="box-body">
	            <div class="form-group">
		                <div class="col-md-1">
		                    <label class="control-label" >变量名 <b class=" red">*</b> :</label>
		                </div>
			                <div class="col-md-11">
			              	  <c:if test="${not empty config.id}">
			              	 	 <input name="varname" value="${config.varname }"
				                           class="col-xs-10 col-sm-5" placeholder="变量名必须填写！" id="varname"/>
			              	  </c:if>
			                   <c:if test="${empty config.id}">
			              	 	 <input name="varname" value=""
				                           class="col-xs-10 col-sm-5" placeholder="变量名必须填写！" id="varname"/>
			              	  </c:if>
			              	 &nbsp;&nbsp;&nbsp;&nbsp;<span class="label label-warning" id= "nameSpan"></span>
			                </div>
			               <br/>
	            </div>
	            
	             <div class="form-group">
		               <div class="col-md-1">
		                    <label class="control-label" >变量值 <b class=" red">*</b> :</label>
		                </div>
		                <div class="col-md-11">
		                	<c:if test="${not empty config.id}">
			              	 	 <textarea name="valueName"  style="height: 200px"
		                              class="col-xs-10 col-sm-5"
		                              placeholder="变量值必须填写！"  id="valueName">${config.value}</textarea>
			              	  </c:if>
			              	  
			                   <c:if test="${empty config.id}">
			              	 	 <textarea name="valueName" style="height: 200px"
		                              class="col-xs-10 col-sm-5"
		                              placeholder="变量值必须填写！" id="valueName"></textarea>
			              	  </c:if>
			              	  <span class="label label-warning" id="valueSpan"></span>
		                </div>
		                  <br/>
	            </div>
	            <div class="form-group">
	            	<span>&nbsp;&nbsp;&nbsp;&nbsp;</span>
	            </div>
		                
	            <div class="form-group">
	                <div class="col-md-1">
	                    <label class="control-label" >备注：</label>
	                </div>
	                <div class="col-md-11">
	                   
	                     <c:if test="${not empty config.id}">
			              	 	 <input name="memo" value="${config.memo }"
				                           class="col-xs-10 col-sm-5" placeholder="" />
			             </c:if>
			             <c:if test="${empty config.id}">
			              	 	<input name="memo" value="${config.memo }"
				                           class="col-xs-10 col-sm-5" placeholder="" />
			             </c:if>
	                </div>
	            </div>
	            	<button class="btn btn-primary"  type="submit" value="Submit">保存</button>
    	    </div>
   		 </div>		
	</form>
	
<script type="text/javascript">
		var configId= $('#typeValue').val();
		$(document).ready(function(){
			  $("#from_module_edit").submit(function(e){
				  if(configId.length==0){//新增
					  $.ajax({
		                    url:'/admin/config/add',
		                    data:$("#from_module_edit").serialize(),
		                    success:function (data) {
		                        if(data.code==1){
		                            alert(data.msg);
		                        }else{
		                            window.location.href="/admin/config/list";
		                        }
		                    }
		                });
					}else{
						$.ajax({
			                  url:'/admin/config/update',
			                  data:$("#from_module_edit").serialize(),
			                  success:function (data) {
			                      if(data.code==1){
			                           alert(data.msg);
			                      }else{
			                            window.location.href="/admin/config/list";
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
