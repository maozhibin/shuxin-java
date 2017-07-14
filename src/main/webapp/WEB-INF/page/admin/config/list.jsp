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
</head>
<body>
<a class="btn" style="float:left;margin-bottom: 20px" href="skip"><!--<i
        class="fa fa-plus"></i> -->添加选项参数</a>
        
        
 <div class="row">
    <div class="col-md-12">
        <div class="box-primary">
            <div class="box-body">
                <table id="example2" class="table table-striped table-hover" style="table-layout:fixed">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th style="width:10%">配置名称</th>
                        <th>配置值</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:if test="${page != null && page.result != null}">
                        <c:forEach items="${page.result}" var="Config" varStatus="status">
                            <tr>
                            	<td>${status.index+1}</td>
                                <td>${Config.varname}</td>
                                <td>${Config.value}</td>
                                <td>
                                	<a class="" title='编辑'
                                       href="skip?id=${Config.id}"><i class="fa fa-pencil"></i> </a>&nbsp;&nbsp;
                                </td>
                            </tr>
                        </c:forEach>
                    	</c:if>
                    </tbody>
                </table>
                <div class="col-sm-12" style="text-align: right">
                  
                    
                </div>
            </div>
        </div>
    </div>
</div>
 
</body>
</html>
