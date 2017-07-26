<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%--
  Created by IntelliJ IDEA.
  User: yongj
  Date: 7/15/2017
  Time: 2:33 PM
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
    <title>产品发布</title>

    <link href='<%=basePath%>static/css/style.css?1.0' rel="stylesheet" type="text/css"/>
    <link href='<%=basePath%>static/css/market.css?1.0' rel="stylesheet" type="text/css"/>
    <link href='<%=basePath%>static/css/style_other.css?1.0' rel="stylesheet" type="text/css"/>
    <link href='<%=basePath%>static/css/data.css?1.0' rel="stylesheet" type="text/css"/>
    <link href='<%=basePath%>static/css/jquery.tagsinput.css?1.0' rel="stylesheet" type="text/css"/>

    <link href='<%=basePath%>static/admin/css/data-release.css?1.0' rel="stylesheet" type="text/css"/>

    <script src='<%=basePath%>static/js/jquery.tagsinput.js?1.0'></script>
    <script src='<%=basePath%>static/js/jquery.ajaxfileupload.js?1.0'></script>

    <script>
        $(function () {
            var product_class = $("#product_class");
            if (product_class.val() != undefined && product_class.val() != '') {
                getProductClass(product_class.val())
            }

            product_class.change(function () {
                getProductClass(product_class.val())
            });

            function getProductClass(product_class_id) {
                var data = {};
                request("admin/product/product_base/" + product_class_id, data, function (r) {
                    var product_base = $("#product_base");
                    product_base.empty();
                    for (var key in r) {
                        product_base.append("<option value='" + key + "'>" + r[key] + "</option>")
                    }
                });
            }

            var pid = $("#pid");
            if (pid.val() != undefined) {
                getArea(pid.val())
            }

            pid.change(function () {
                getArea(pid.val())
            });

            function getArea(pid) {
                var data = {};
                request("admin/product/area/" + pid, data, function (r) {
                    var area_id = $("#area_id");
                    area_id.empty();
                    for (var key in r) {
                        area_id.append("<option value='" + key + "'>" + r[key] + "</option>")
                    }
                });
            }

            var preview = $("#preview");
            $("#upload").AjaxFileUpload({
                action: '<%=basePath%>admin/product/uploadLogo',
                onComplete: function (filename, response) {
                    if (response.error != "") {
                        alert(response.error + "请重新选择");
                    } else {
                        var url = base_url + "uploads/logos/" + filename;
//                    preview.attr("src", url).attr("width", 96).attr("height", 96);
                        $("#logo").val(response.name.file_name);
                        $(this).parents(".cell").addClass('hide');
                        $("#close").removeClass('hide');
                        $("#img").removeClass('hide').attr("src", url).attr("width", 96).attr("height", 96).attr('alt', filename);
                    }
                }
            });

            $("#close").click(function () {
                $(this).addClass('hide').prevAll('img').removeAttr('src width height alt').addClass('hide').prevAll('.cell').removeClass('hide');
            });
            preview.click(function () {
                $("#upload").trigger("click");
            });

            $("#submit").click(function () {
                $(window).off("beforeunload");
            });


            //input tags
            var product_tags = $("#product_tags");
            product_tags.tagsInput({
                width: "auto",
                defaultText: "添加标签"
            })
        });

        //        //未保存提示
        //        $(window).on("beforeunload", function () {
        //            return "are you sure?"
        //        });
    </script>
</head>
<body>

<script>
    function goto(tab) {
        $('.container').attr('hidden', 'hidden');
        $('.container.' + tab).removeAttr('hidden');
        $('.tab').removeClass('active');
        $('.tab.' + tab).addClass('active');
        scroll(0, 0);
    }
</script>

<div class="release-tabs" >
    <div class="tabs">
        <a onclick=" " class="tab base active">基础设置</a>
        <a onclick=" " class="tab api">接口设置</a>
        <a onclick=" " class="tab desc">产品描述</a>
        <a onclick=" " class="tab price">计费设置</a>
        <%--<a onclick="goto('base')" class="tab base active">基础设置</a>
        <a onclick="goto('api')" class="tab api">接口设置</a>
        <a onclick="goto('desc')" class="tab desc">产品描述</a>
        <a onclick="goto('price')" class="tab price">计费设置</a>--%>
     </div>
     	<input type="hidden" class="input-ctrl" name="productId" id="productId" value="${hashMap.productBaseInfo.id}">
     	<input type="hidden" class="input-ctrl" name="areaId" id="areaId" value="${hashMap.productBaseInfo.areaId}">
        <div class="container base">
            <div class="inline-form mb30">
                <div class="addon">数据名称</div>
                <div class="cell">
                    <input type="text" class="input-ctrl" name="productName" id="product_name"
                           value="${hashMap.productBaseInfo.name}">
                </div><span class="label label-warning" id= "productNameSpan"></span>
                <div class="addon">更新频率</div>
                <div class="cell">
                    <select class="input-ctrl" name="frequent" id="frequent">
	                    <option value="1" <c:if test="${hashMap.productBaseInfo.frequent==1}">selected="selected"</c:if>>实时</option>
                    </select>
                </div>
            </div>
            <div class="inline-form mb30">
                <div class="addon">数据分类</div>
                <div class="cell">
                    <div class="mb15">
                        <select class="input-ctrl" name="productClass" id="product_class">
                        <c:forEach items="${hashMap.productClassList}" var="item">
                           <option value="${item.id}" <c:if test="${hashMap.productBaseInfo.product_class_id==item.id}">selected="selected"</c:if>>${item.name}</option>
			            </c:forEach>
                        </select>
                    </div>

                    <div class="cell">
                        <select class="input-ctrl" name="productBase" id="product_base">
                            <option value=""></option>
                        </select>
                    </div>

                </div>

                <div class="addon">数据类型</div>
                <div class="cell vat">
                    <select class="input-ctrl" name="productType" id="product_type">
                    	<option value="1" <c:if test="${hashMap.productBaseInfo.type==1}">selected="selected"</c:if>>API</option>
                    	<option value="2" <c:if test="${hashMap.productBaseInfo.type==2}">selected="selected"</c:if>>普通文件</option>
                    </select>
                </div>
                
                
            </div>
            <div class="inline-form mb30">
                <div class="addon">区域范围</div>
                <div class="cell">
                    <div class="mb15">
                        <select class="input-ctrl" name="province " id="province">
                            <c:forEach items="${hashMap.provinceList }" var="item">
                                <option value="${item.id}" <c:if test="${hashMap.productBaseInfo.pid==item.id}">selected="selected"</c:if>>${item.name}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="cell">
                        <select class="input-ctrl" name="city" id="city">
                            <option value=""></option>
                        </select>
                    </div>
                </div>
                
                <div class="addon">发布人</div>
                <div class="cell vat">
                    <select class="input-ctrl" name="userName" id="user_name">
                        <c:forEach items="${hashMap.userList }" var="item">
                        	<option value="${item.id}" <c:if test="${hashMap.productBaseInfo.sellerId==item.id}">selected="selected"</c:if>>${item.username}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            
            <div class="inline-form mb30">
                <div class="addon">数据简介</div>
                <div class="cell">
                        <textarea rows="10" class="input-ctrl"
                                  name="productDescription" id="product_description">${hashMap.productBaseInfo.description}</textarea>
                </div>
            </div>
            <div class="inline-form mb30">
                <div class="addon">标签设置</div>
                <div class="cell">
                    <input type="text" name="productTags" value=" ${hashMap.tagLists}" class="input-ctrl" id="productTags"/>
                </div>
                <div class="cell gray9">多个标签请用逗号分隔，例如：标签,设置。</div>
            </div>

            <div class="inline-form mb30">
                <div class="addon">数据logo</div>
                <div class="cell">
                    <label for="upload" class="upload">上传图片</label>
                    <input type="file" id="upload" class="hide" name="icon"
                           accept="image/png,image/gif,image/jpg,image/jpeg">
                </div>
                <img id="img"/>
                <i id="close" class="hide"></i>
                <input type="text" class="hide" id="logo" name="logo">
                <div class="cell gray9">请上传资料的照片或扫描件。图片格式仅限jpg、png、gif格式，大小不超过1M。</div>
            </div>
            <div class="ml40 pad30">
                <input type="button" class="btn btn-blue" value="下一步"
                       onclick="apiFunction();">
            </div>
        </div>

        <div hidden="hidden" class="container api">
			<div class="inline-form mb30">
            	<div class="addon">接口名称</div>
                <div class="cell">
                    <input type="text" class="input-ctrl" name="interfaceName" id="interface_name" value="${hashMap.productInterface.name}">
                </div>
               &nbsp;&nbsp;&nbsp;<div class="addon">appCode</div>
                <div class="cell">
                    <input type="text" class="input-ctrl" name="appCode" id="app_code" value="${hashMap.productInterface.appCode}">
                </div>
            </div>
            
            <div class="inline-form mb30">
                <div class="addon">请求方式</div>
                <div class="cell">
                    <select class="input-ctrl" name="requestMethod" id="request_method">
                      	<option value="post" <c:if test="${hashMap.productInterface.method eq 'post'}">selected="selected"</c:if>>POST</option>
                        <option value="get" <c:if test="${hashMap.productInterface.method eq 'get'}">selected="selected"</c:if>>GET</option>
                    </select>
                </div>
                <div class="addon">返回报文格式</div>
                <div class="cell vat">
                    <select class="input-ctrl" name="responseFormat" id="response_format">
                  		<option value="json" <c:if test="${hashMap.productInterface.responseFormat eq 'json'}">selected="selected"</c:if>>JSON</option>
                        <option value="xml" <c:if test="${hashMap.productInterface.responseFormat eq 'xml'}">selected="selected"</c:if>>XML</option>
                    </select>
                </div>
            </div>

            <div class="inline-form mb30">
                <div class="addon">传输字符</div>
                <div class="cell">
                    <select class="input-ctrl" name="character" id="character">
                        <option value="UTF-8">UTF-8</option>
                    </select>
                </div>
                <div class="addon">请求超时时长</div>
                <div class="cell">
                    <input type="text" class="input-ctrl" name="timeout" id="time_out" value="${hashMap.productInterface.timeout}">
                </div>
            </div>
         	 <div class="inline-form mb30">
                <div class="addon">URL 地址</div>
                <div class="cell">
                    <input type="text" class="input-ctrl" name="urlAddress" id="url_address" value="${hashMap.productInterface.url}">
                </div>
            </div>
            <p class="f16 gray6 mb10">请求参数（Headers）</p>
            <table class="mb50" id="Headers">
                <thead>
                <tr>
                    <th width="145">名称</th>
                    <th width="145">类型</th>
                    <th width="157">是否必须</th>
                    <th>描述</th>
                    <th width="56"></th>
                </tr>
                </thead>
                <tbody id="request_headers">
	                <c:if test="${not empty hashMap.productBaseInfo.id}">
	             		<c:forEach items="${hashMap.headersParamslist}" var="item">
			                <tr>
			                    <td><input type="text" class="input" value="${item.name}" placeholder="点击输入" name="headerName"></td>
			                    <td>
			                    	<select name="headerType" class="input-ctrl">
			                            <option value="String">String</option>
			                        </select>
			                    </td>
			                    <td>
			                        <select name="headerMust" class="input-ctrl">
			                          	<option value="1" <c:if test="${item.must eq 'true'}">selected="selected"</c:if>>必须</option>
			                          	<option value="0" <c:if test="${item.must eq 'false'}">selected="selected"</c:if>>非必须</option>
			                        </select>
			                    </td>
			                    <td><input type="text" class="input" value="${item.description}" placeholder="点击输入" name="headerDesc"></td>
			                    <td>
			                    	    <button class="blue add-line deleteTr" onclick="delHeaders(this)">删除</button>
			                    </td>
			                </tr>
	                	 </c:forEach>
	                	 <tr>
		                    <td><input type="text" class="input" value="" placeholder="点击输入" name="headerName"></td>
		                    <td>
		                    	<select name="headerType" class="input-ctrl">
		                            <option value="String">String</option>
		                        </select>
		                    </td>
		                    <td>
		                        <select name="headerMust" class="input-ctrl">
		                            <option value="1">必须</option>
		                            <option value="0">非必须</option>
		                        </select>
		                    </td>
		                    <td><input type="text" class="input" value="" placeholder="点击输入" name="headerDesc"></td>
		                    <td>
		                    	    <button class="blue add-line add_header">新增</button>
		                    </td>
		                </tr>
		            </c:if>
	            
		            <c:if test="${empty hashMap.productBaseInfo.id}">
		             	<tr>
		                    <td><input type="text" class="input" value="" placeholder="点击输入" name="headerName"></td>
		                    <td>
		                    	<select name="headerType" class="input-ctrl">
		                            <option value="String">String</option>
		                        </select>
		                    </td>
		                    <td>
		                        <select name="headerMust" class="input-ctrl">
		                            <option value="1">必须</option>
		                            <option value="0">非必须</option>
		                        </select>
		                    </td>
		                    <td><input type="text" class="input" value="" placeholder="点击输入" name="headerDesc"></td>
		                    <td>
		                    	    <button class="blue add-line add_header">新增</button>
		                    </td>
		                </tr>
		            </c:if>
                </tbody>
            </table>

            <p class="f16 gray6 mb10">请求参数（Query）</p>
            <table class="mb50" id="Querys">
                <thead>
                <tr>
                    <th width="145">名称</th>
                    <th width="145">类型</th>
                    <th width="157">是否必须</th>
                    <th>描述</th>
                    <th width="56"></th>
                </tr>
                </thead>
                <tbody id="request_querys">
                <c:if test="${not empty hashMap.productBaseInfo.id}">
	             		<c:forEach items="${hashMap.queryParamslist}" var="item">
			                <tr>
			                    <td><input type="text" class="input" value="${item.name}" placeholder="点击输入" name="queryName"></td>
			                    <td>
			                    	<select name="queryType" class="input-ctrl">
			                            <option value="String">String</option>
			                        </select>
			                    </td>
			                    <td>
			                        <select name="queryMust" class="input-ctrl">
			                          	<option value="1" <c:if test="${item.must eq 'true'}">selected="selected"</c:if>>必须</option>
			                          	<option value="0" <c:if test="${item.must eq 'false'}">selected="selected"</c:if>>非必须</option>
			                        </select>
			                    </td>
			                    <td><input type="text" class="input" value="${item.description}" placeholder="点击输入" name="queryDesc"></td>
			                    <td>
			                    	    <button class="blue add-line deleteTr" onclick="delHeaders(this)">删除</button>
			                    </td>
			                </tr>
	                	 </c:forEach>
	                	 	<tr>
			                    <td><input type="text" class="input" value="" placeholder="点击输入" name="queryName"></td>
			                    <td>
			                    	<select name="queryType" class="input-ctrl">
			                            <option value="String">String</option>
			                        </select>
			                    </td>
			                    <td>
			                        <select name="queryMust" class="input-ctrl">
			                            <option value="1">必须</option>
			                            <option value="0">非必须</option>
			                        </select>
			                    </td>
			                    <td><input type="text" class="input" value="" placeholder="点击输入" name="queryDesc"></td>
			                    <td>
			                    	<button class="blue add-line add_query">新增</button>
			                    </td>
		              	  </tr>
		            </c:if>
	            
		            <c:if test="${empty hashMap.productBaseInfo.id}">
		             	<tr>
		                    <td><input type="text" class="input" value="" placeholder="点击输入" name="queryName"></td>
		                    <td>
		                    	<select name="queryType" class="input-ctrl">
		                            <option value="String">String</option>
		                        </select>
		                    </td>
		                    <td>
		                        <select name="queryMust" class="input-ctrl">
		                            <option value="1">必须</option>
		                            <option value="0">非必须</option>
		                        </select>
		                    </td>
		                    <td><input type="text" class="input" value="" placeholder="点击输入" name="queryDesc"></td>
		                    <td>
		                    	<button class="blue add-line add_query">新增</button>
		                    </td>
		                </tr>
		            </c:if>
                </tbody>
            </table>

            <p class="f16 gray6 mb10">请求参数（Body）</p>
            <table class="mb50" id="Bodys">
                <thead>
                <tr>
                    <th width="145">名称</th>
                    <th width="145">类型</th>
                    <th width="157">是否必须</th>
                    <th>描述</th>
                    <th width="56"></th>
                </tr>
                </thead>
                <tbody id="request_bodys">
                  <c:if test="${not empty hashMap.productBaseInfo.id}">
	             		<c:forEach items="${hashMap.bodyParamslist}" var="item">
			                <tr>
			                    <td><input type="text" class="input" value="${item.name}" placeholder="点击输入" name="bodyName"></td>
			                    <td>
			                    	<select name="bodyType" class="input-ctrl">
			                            <option value="String">String</option>
			                        </select>
			                    </td>
			                    <td>
			                        <select name="bodyMust" class="input-ctrl">
			                          	<option value="1" <c:if test="${item.must eq 'true'}">selected="selected"</c:if>>必须</option>
			                          	<option value="0" <c:if test="${item.must eq 'false'}">selected="selected"</c:if>>非必须</option>
			                        </select>
			                    </td>
			                    <td><input type="text" class="input" value="${item.description}" placeholder="点击输入" name="bodyDesc"></td>
			                    <td>
			                    	   <button class="blue add-line deleteTr" onclick="delHeaders(this)">删除</button>
			                    </td>
			                </tr>
	                	 </c:forEach>
	                	 <tr>
		                    <td><input type="text" class="input" value="" placeholder="点击输入" name="bodyName"></td>
		                    <td>
		                    	<select name="bodyType" class="input-ctrl">
		                            <option value="String">String</option>
		                        </select>
		                    </td>
		                    <td>
		                        <select name="bodyMust" class="input-ctrl">
		                            <option value="1">必须</option>
		                            <option value="0">非必须</option>
		                        </select>
		                    </td>
		                    <td><input type="text" class="input" value="" placeholder="点击输入" name="bodyDesc"></td>
		                    <td>
		                    	<button class="blue add-line add_body">新增</button>
		                    </td>
		                </tr>
		            </c:if>
	            
		            <c:if test="${empty hashMap.productBaseInfo.id}">
		             	<tr>
		                    <td><input type="text" class="input" value="" placeholder="点击输入" name="bodyName"></td>
		                    <td>
		                    	<select name="bodyType" class="input-ctrl">
		                            <option value="String">String</option>
		                        </select>
		                    </td>
		                    <td>
		                        <select name="bodyMust" class="input-ctrl">
		                            <option value="1">必须</option>
		                            <option value="0">非必须</option>
		                        </select>
		                    </td>
		                    <td><input type="text" class="input" value="" placeholder="点击输入" name="bodyDesc"></td>
		                    <td>
		                    	<button class="blue add-line add_body">新增</button>
		                    </td>
		                </tr>
		            </c:if>
                </tbody>
            </table>
			
			<c:if test="${not empty hashMap.productBaseInfo.id}">
             	<c:forEach items="${hashMap.interfaceSample}" var="item">
             		<c:if test="${item.type eq 'INPUT'}">
             			<p class="f16 gray6 mb10">请求示例</p>
		          	  <textarea rows="10" class="input-ctrl mb30" name="requestSample" id="request_sample">${item.value}</textarea>
             		</c:if>
					<c:if test="${item.type eq 'OUTPUT_SUCCESS' }">
             			<p class="f16 gray6 mb10">正常返回示例</p>
		          	  <textarea rows="10" class="input-ctrl mb30" name="normalSample" id="normal_sample">${item.value}</textarea>
             		</c:if>
             		<c:if test="${item.type eq 'OUTPUT_FAIL' }">
             			<p class="f16 gray6 mb10">错误返回示例</p>
		          	  <textarea rows="10" class="input-ctrl mb30" name="errorSample" id="error_sample">${item.value}</textarea>
             		</c:if>
         	   </c:forEach>
            </c:if>
            <c:if test="${empty hashMap.productBaseInfo.id}">
             	<p class="f16 gray6 mb10">请求示例</p>
	            <textarea rows="10" class="input-ctrl mb30" name="requestSample" id="request_sample"></textarea>
	
	            <p class="f16 gray6 mb10">正常返回示例</p>
	            <textarea rows="10" class="input-ctrl mb30" name="normalSample" id="normal_sample"></textarea>
	
	            <p class="f16 gray6 mb10">错误返回示例</p>
	            <textarea rows="10" class="input-ctrl mb30" name="errorSample" id="error_sample"></textarea>
            </c:if>
           


            <p class="f16 gray6 mb10">错误码定义</p>
            <table class="mb50" id="codes">
                <thead>
                <tr>
                    <th width="218">错误码</th>
                    <th width="218">状态码名称</th>
                    <th>描述</th>
                    <th width="56"></th>
                </tr>
                </thead>
                <tbody id="request_codes">
                
                <c:if test="${not empty hashMap.productBaseInfo.id}">
             	<c:forEach items="${hashMap.interfaceCodeList}" var="item">
             		<tr>
	                     <td><input type="text" class="input" value="${item.code}" placeholder="点击输入" name="code"></td>
			             <td><input type="text" class="input" value="${item.name}" placeholder="点击输入" name="codeName"></td>
			             <td><input type="text" class="input" value="${item.desc}" placeholder="点击输入" name="codeDesc"></td>
	                     <td>
	                     	<button class="blue add-line deleteTr" onclick="delHeaders(this)">删除</button>
	                    </td>
                	</tr>
         	   </c:forEach>
                	<tr>
	                     <td><input type="text" class="input" value="" placeholder="点击输入" name="code"></td>
			             <td><input type="text" class="input" value="" placeholder="点击输入" name="codeName"></td>
			             <td><input type="text" class="input" value="" placeholder="点击输入" name="codeDesc"></td>
	                     <td>
	                     	<button class="blue add-line add_code">新增</button>
	                    </td>
                	</tr>
            </c:if>
            
            <c:if test="${empty hashMap.productBaseInfo.id}">
             	<tr>
                     <td><input type="text" class="input" value="" placeholder="点击输入" name="code"></td>
		             <td><input type="text" class="input" value="" placeholder="点击输入" name="codeName"></td>
		             <td><input type="text" class="input" value="" placeholder="点击输入" name="codeDesc"></td>
                     <td>
                     	<button class="blue add-line add_code">新增</button>
                    </td>
                </tr>
            </c:if>
                
                </tbody>
            </table>

            <div class="pt30 pb30">
                <input type="button" class="btn btn-red" value="下一步"
                       onclick="descFunction();">
            </div>
        </div>

        <div hidden="hidden" class="container desc">
            <p class="f16 gray6 mb10">产品介绍</p>
            <textarea rows="10" class="input-ctrl mb30" name="intro" id="intro">${hashMap.productDetail.intro}</textarea>

            <p class="f16 gray6 mb10 mt10">产品亮点</p>
            <textarea rows="10" class="input-ctrl mb30" name="highlight" id="highlight">${hashMap.productDetail.highlight}</textarea>

            <p class="f16 gray6 mb10 mt10">产品截图</p>
            <textarea rows="10" class="input-ctrl mb30" name="snapshot" id="snapshot">${hashMap.productDetail.snapshot}</textarea>

            <p class="f16 gray6 mb10 mt10">售后服务</p>
            <textarea rows="10" class="input-ctrl mb30" name="service" id="service">${hashMap.productDetail.service}</textarea>

            <div class="pt30 pb30">
                <input class="btn btn-red" type="button" value="下一步"
                       onclick="priceFunction();">
            </div>
        </div>

       <div hidden="hidden" class="container price">
           		   <div class="ml60 pl10" id="container-combo">
                        <table class="mb50">
                            <thead>
                            <tr>
                                <th width="218">标准名称</th>
                                <th>设置</th>
                            </tr>
                            </thead>
                            <tbody id="request_billings">
                            <tr>
                                <td>单次计费</td>
                                <td>
                                    <ul class="inline">
                                        <li class="cell"><input type="text" name="priceOne" 
	                                       <c:forEach items="${hashMap.billingsList}" var="item">
	                                       		<c:if test="${item.num == 1}"> value="${item.price}"</c:if></c:forEach>id="priceOne"></li>
                                        <li class="cell">元/</li>
                                        <li class="cell">1次</li>
                                    </ul>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    
                    <div class="ml60 pl10" id="container-combo">
                        <table class="mb50">
                            <thead>
                            <tr>
                                <th width="218">标准名称</th>
                                <th>设置</th>
                            </tr>
                            </thead>
                            <tbody id="request_billings">
                            <tr>
                                <td>多次计费</td>
                                <td>
                                    <ul class="inline">
                                        <li class="cell"><input type="text" name="priceHundred" 
                                         <c:forEach items="${hashMap.billingsList}" var="item">
	                                       		<c:if test="${item.num == 100}"> value="${item.price}"</c:if></c:forEach> id="priceHundred"></li>
                                        <li class="cell">元/</li>
                                        <li class="cell">100次</li>
                                    </ul>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="ml60 pl10" id="container-combo">
                        <table class="mb50">
                            <thead>
                            <tr>
                                <th width="218">标准名称</th>
                                <th>设置</th>
                            </tr>
                            </thead>
                            <tbody id="request_billings">
                            <tr>
                                <td>包年计费</td>
                                <td>
                                    <ul class="inline">
                                        <li class="cell"><input type="text" name="priceYear" 
                                        <c:forEach items="${hashMap.billingsList}" var="item">
	                                       		<c:if test="${item.num == 12}"> value="${item.price}"</c:if></c:forEach>id="priceYear" style="width: "></li>
                                        <li class="cell">元/</li>
                                        <li class="cell">1年</li>
                                    </ul>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        
                    

            <div class="pb30">
                <p class="mb10"><label class="gray6"><input type="checkbox" class="agreement" id="chexkboxId">
                    我已同意并阅读 <a href="" class="blue">《2226888协议》</a></label>
                </p>
                <button class="btn btn-red" id="submit_btn" onclick="chargingFunction()">提交发布</button>
            </div>
            </div>
        </div>
</div>

<script type="text/javascript">
    $(document).ready(function(){
        var classValue=$('#product_class').val();
        $.ajax({
            type: "GET",
            url: "/admin/product/base?id="+classValue,
            dataType: "json",
            success: function(data){
                $("#product_base").html('');
                var option="";
                for(var i=0;i<data.length;i++){
                    option+="<option value='"+data[i].id+"'>"+data[i].name+"</option>";
                }
                $("#product_base").append(option);
            }

        });
    });
    
	$('#product_class').change(function(){
		var classValue=$('#product_class').val();
	    $.ajax({
	        type: "GET",
	        url: "/admin/product/base?id="+classValue,
	        dataType: "json",
	        success: function(data){
	        		$("#product_base").html('');
                    var option="";
	        		for(var i=0;i<data.length;i++){
	        			option+="<option value='"+data[i].id+"'>"+data[i].name+"</option>";
	        		}
	        		$("#product_base").append(option);
	         }
	        
	    });
	});
	
	var productId = $('#productId').val();
	 $(document).ready(function(){
		 var pidValue=$('#province').val();
		    $.ajax({
		        type: "GET",
		        url: "/admin/area/city?pid="+pidValue,
		        dataType: "json",
		        success: function(data){
		        		$("#city").html('');
	                    var option="";
		        		for(var i=0;i<data.length;i++){
		        			option+="<option value='"+data[i].id+"'>"+data[i].name+"</option>";
		        		}
		        		
		      			$("#city").append(option);
		      			//当是进行修改时显示原来的区域
		        		var areaId = $('#areaId').val();
		      			if(productId!==''){
		      				$('#city').val(areaId);
		      			}
		         }
		        
		    });
		    
		    //请求参数（Headers）
		    $('#request_headers').on("click","button.add_header",function(){
		    	var tr = $(this).parents('tr');
		    	var td1 =tr.children().eq(0).find(".input").val();
		    	var td4 =tr.children().eq(3).find(".input").val();
		    	if(td1.length<=0){
		    		alert("参数名称不能为空");
		    		return;
		    	}
		    	if(td4.length<=0){
		    		alert("参数描述不能为空");
		    		return;
		    	}
		    	var row=$(tr).html();
                $('#request_headers').append("<tr>"+row+"</tr>");
                $(this).removeClass("add_header").addClass("deleteTr").text("删除").attr("onclick","delHeaders(this)");
		    });
			
		    //请求参数（Query）
		    $('#request_querys').on("click","button.add_query",function(){
		    	var tr = $(this).parents('tr');
		    	var td1 =tr.children().eq(0).find(".input").val();
		    	var td4 =tr.children().eq(3).find(".input").val();
		    	if(td1.length<=0){
		    		alert("参数名称不能为空");
		    		return;
		    	}
		    	if(td4.length<=0){
		    		alert("参数描述不能为空");
		    		return;
		    	}
		    	var row=$(tr).html();
                $('#request_querys').append("<tr>"+row+"</tr>");
                $(this).removeClass("add_query").addClass("deleteTr").text("删除").attr("onclick","delHeaders(this)");
		    });
		    
		    //请求参数（Body）
		    $('#request_bodys').on("click","button.add_body",function(){
		    	var tr = $(this).parents('tr');
		    	var td1 =tr.children().eq(0).find(".input").val();
		    	var td4 =tr.children().eq(3).find(".input").val();
		    	if(td1.length<=0){
		    		alert("参数名称不能为空");
		    		return;
		    	}
		    	if(td4.length<=0){
		    		alert("参数描述不能为空");
		    		return;
		    	}
		    	var row=$(tr).html();
                $('#request_bodys').append("<tr>"+row+"</tr>");
                $(this).removeClass("add_body").addClass("deleteTr").text("删除").attr("onclick","delHeaders(this)");
		    });
		    
		    //错误码定义
		    $('#request_codes').on("click","button.add_code",function(){
		    	var tr = $(this).parents('tr');
		    	var td1 =tr.children().eq(0).find(".input").val();
		    	var td2 =tr.children().eq(1).find(".input").val();
		    	var td3 =tr.children().eq(2).find(".input").val();
		    	if(td1.length<=0){
		    		alert("错误码不能为空");
		    		return;
		    	}
		    	if(td2.length<=0){
		    		alert("状态码名称不能为空");
		    		return;
		    	}
		    	if(td3.length<=0){
		    		alert("描述不能为空");
		    		return;
		    	}
		    	var row=$(tr).html();
                $('#request_codes').append("<tr>"+row+"</tr>");
                $(this).removeClass("add_code").addClass("deleteTr").text("删除").attr("onclick","delHeaders(this)");
		    });


	    });
	
	$('#province').change(function(){
		var pidValue=$('#province').val();
	    $.ajax({
	        type: "GET",
	        url: "/admin/area/city?pid="+pidValue,
	        dataType: "json",
	        success: function(data){
	        		$("#city").html('');
                    var option="";
	        		for(var i=0;i<data.length;i++){
	        			option+="<option value='"+data[i].id+"'>"+data[i].name+"</option>";
	        		}
	        		$("#city").append(option);
	         }
	        
	    });
	});
	
	function myfunction(){
		var str = {};
		var productName=$('#product_name').val();//产品名
		var frequent=$('#frequent').val();//更新频率
		var productClass=$('#product_class').val();//产品类型
		var productBase=$('#product_base').val();//产品子类型
		var productType=$('#product_type').val();//数据类型
		var city=$('#city').val();//区域
		var userName=$('#user_name').val();//发布人
		var productDescription=$('#product_description').val();//数据简介
		var interfaceName=$('#interface_name').val();//接口名称
		var appCode=$('#app_code').val();//appCode
		var urlAddress=$('#url_address').val();//服务地址
		var requestMethod=$('#request_method').val();//请求方式
		var responseFormat=$('#response_format').val();//返回报文格式
		var character=$('#character').val();//字符类型
		var timeout=$('#time_out').val();//请求超时
		var requestSample=$('#request_sample').val();//请求实例
		var normalSample=$('#normal_sample').val();//正常返回
		var errorSample=$('#error_sample').val();//错误提示
		var intro=$('#intro').val();//产品介绍
		var highlight=$('#highlight').val();//产品亮点
		var service=$('#service').val();//售后服务
		str.productName=productName;
		str.frequent=frequent;
		str.productClass=productClass;
		str.productBase=productBase;
		str.productType=productType;
		str.city=city;
		str.userName=userName;
		str.productDescription=productDescription;
		str.interfaceName=interfaceName;
		str.appCode=appCode;
		str.urlAddress=urlAddress;
		str.requestMethod=requestMethod;
		str.responseFormat=responseFormat;
		str.character=character;
		str.timeout=timeout;
		str.requestSample=requestSample;
		str.normalSample=normalSample;
		str.errorSample=errorSample;
		str.intro=intro;
		str.highlight=highlight;
		str.service=service;

		
		//对请求参数的操作
		var headersArray=new Array();
		var headerList = $("#request_headers").children("tr")
			for (var i=0;i<headerList.length-1;i++) {
				var headers=[];
				var tdArr = headerList.eq(i).find("td");
				var headerName = tdArr.eq(0).find("input").val();
				var headerType = tdArr.eq(1).find("select").val();
				var headerMust = tdArr.eq(2).find("select").val();
				var headerDesc = tdArr.eq(3).find("input").val();
				headers.push(headerName)
				headers.push(headerType)
				headers.push(headerMust)
				headers.push(headerDesc)
				headersArray.push(headers);
				str.headersArray=headersArray;
			}
		
		var querysArray=new Array();;
		var queryList = $("#request_querys").children("tr")
			for (var i=0;i<queryList.length-1;i++) {
				var query = [];
				var tdArr = queryList.eq(i).find("td");
				var queryName = tdArr.eq(0).find("input").val();
				var queryType = tdArr.eq(1).find("select").val();
				var queryMust = tdArr.eq(2).find("select").val();
				var queryDesc = tdArr.eq(3).find("input").val();
				query.push(queryName)
				query.push(queryType)
				query.push(queryMust)
				query.push(queryDesc)
				querysArray.push(query);
				str.querysArray=querysArray;
		}
		
		var bodysArrays=new Array();
		var bodyList = $("#request_bodys").children("tr")
			for (var i=0;i<bodyList.length-1;i++) {
				var body = [];
				var tdArr = bodyList.eq(i).find("td");
				var bodyName = tdArr.eq(0).find("input").val();
				var bodyType = tdArr.eq(1).find("select").val();
				var bodyMust = tdArr.eq(2).find("select").val();
				var bodyDesc = tdArr.eq(3).find("input").val();
				body.push(bodyName)
				body.push(bodyType)
				body.push(bodyMust)
				body.push(bodyDesc)
				bodysArrays.push(body);
				str.bodysArrays=bodysArrays;
		}
		
		var codesArrays=new Array();
		var codeList = $("#request_codes").children("tr")
			for (var i=0;i<codeList.length-1;i++) {
				var codet = [];
				var tdArr = codeList.eq(i).find("td");
				var code = tdArr.eq(0).find("input").val();
				var codeName = tdArr.eq(1).find("input").val();
				var codeDesc = tdArr.eq(2).find("input").val();
				codet.push(code);
				codet.push(codeName);
				codet.push(codeDesc);
				codesArrays.push(codet);
				str.codesArrays=codesArrays;
		}
		
		
		var priceOne=$('#priceOne').val();//一次收费
		var priceHundred=$('#priceHundred').val();//100次收费
		var priceYear=$('#priceYear').val();//1年收费
		str.priceOne=priceOne;
		str.priceHundred=priceHundred;
		str.priceYear=priceYear;
		
		var productTags=$('#productTags').val();//标签
		var tags = new Array();
		tag=productTags.trim().split(","); //字符分割 
		console.log(tag);
		tags.push(tag);
		str.tags = tags;
		
		var data = JSON.stringify(str);
		var productId = $('#productId').val();
		$.ajax({
	            type: "post",
	            cache: false,
	            datatype:"json",
	            url: "/admin/product/updateOrAdd?id="+productId,
	            data:{data:data},
	            success: function(d){
	    		    	 if(d.code==1){
	    		    	      alert(d.result);
	    		    	   }else{
	    		    		  window.location.href="/admin/product/list";
	    		    	   }
	    			}
	       });
		
	}
	
	function apiFunction(){//基础设置检查
		var product_name=$('#product_name').val();
		var product_description=$('#product_description').val();
		var productTags=$('#productTags').val();
		product_name_value=product_name.replace(/\n/g,'');
		product_description_value=product_description.replace(/\n/g,'');
		productTags_value=productTags.replace(/\n/g,'');
		if(javaTrim(product_name_value)==""){
			alert("请输入数据名称");
			return;
		}
		if(javaTrim(product_description_value)==""){
			alert("请输入数据简介");
			return;
		}
		if(javaTrim(productTags_value)==""){
			alert("请输入标签设置");
			return;
		}
		
		goto('api')
	}
	
	function descFunction(){//接口设置判断
		var interface_name=$('#interface_name').val();
		var url_address=$('#url_address').val();
		var request_sample=$('#request_sample').val();
		var normal_sample=$('#normal_sample').val();
		var error_sample=$('#error_sample').val();
		var app_code = $('#app_code').val();
		var time_out=$('#time_out').val();//请求超时
		
		interface_name_value=interface_name.replace(/\n/g,'');
		url_address_value=url_address.replace(/\n/g,'');
		request_sample_value=request_sample.replace(/\n/g,'');
		normal_sample_value=normal_sample.replace(/\n/g,'');
		error_sample_value=error_sample.replace(/\n/g,'');
		app_code_value=app_code.replace(/\n/g,'');
		if(javaTrim(interface_name_value)==""){
			alert("请输入接口名称");
			return;
		}
		if(javaTrim(app_code_value)==""){
			alert("请输入appCode");
			return;
		}
		if(!/^[0-9]+$/.test(time_out.trim()) || time_out.length > 10){
			alert("请输入正确的请求超时时长时间");
			return;
		}
		if(javaTrim(url_address_value)==""){
			alert("请输入服务地址");
			return;
		}
		var  rownum =$("#Headers tr").length
		if(rownum < 3){
			alert("至少输入一个请求参数(Headers)");
			return;
		}
		
		var  rownum =$("#Querys tr").length
		if(rownum < 3){
			alert("至少输入一个请求参数(Querys)");
			return;
		}
		
		var  rownum =$("#Bodys tr").length
		if(rownum < 3){
			alert("至少输入一个请求参数(Bodys)");
			return;
		}
		
		
		if(javaTrim(request_sample_value)==""){
			alert("请输入请求实例");
			return;
		}
		if(javaTrim(normal_sample_value)==""){
			alert("请输入正常返回示例");
			return;
		}
		if(javaTrim(error_sample_value)==""){
			alert("请输入错误返回实例");
			return;
		}
		
		var  rownum =$("#codes tr").length
		if(rownum < 3){
			alert("至少输入一个请求参数(codes)");
			return;
		}
		
		goto('desc');
	}
	
	function priceFunction(){//产品描述判断
		var intro=$('#intro').val();
		var highlight=$('#highlight').val();
		//var snapshot=$('#snapshot').val();//产品截图
		var service=$('#service').val();
		intro_value=intro.replace(/\n/g,'');
		highlight_value=highlight.replace(/\n/g,'');
		service_value=service.replace(/\n/g,'');
		if(javaTrim(intro_value)==""){
			alert("请输入产品介绍");
			return;
		}
		if(javaTrim(highlight_value)==""){
			alert("请输入产品亮点");
			return;
		}
		if(javaTrim(service_value)==""){
			alert("请输入售后服务");
			return;
		}
		goto('price')
	}
	
	function chargingFunction(){//计费设置判断
		var priceOne=$('#priceOne').val();
		var priceHundred=$('#priceHundred').val();
		var priceYear=$('#priceYear').val();
		var reg=/^[-\+]?\d+(\.\d+)?$/;
		
		priceOne_value=priceOne.replace(/\n/g,'');
		priceHundred_value=priceHundred.replace(/\n/g,'');
		priceYear_value=priceYear.replace(/\n/g,'');
		if(javaTrim(priceOne_value)==""){
			alert("单次费用必须填写");
			return;
		}
		if(javaTrim(priceOne_value)!=""){
			if(!reg.test(priceOne) || priceOne.length >7){
				alert("请输入正确的单次计费价格");
				return;
			}
		}
		if(javaTrim(priceHundred_value)!=""){
			if(!reg.test(priceHundred) || priceHundred.length >7){
				alert("请输入正确的多次计费价格");
				return;
			}
		}
		
		if(javaTrim(priceYear_value)!=""){
			if(!reg.test(priceYear) || priceYear.length >7){
				alert("请输入正确的包年计费价格");
				return;
			}
		}
		if(document.getElementById("chexkboxId").checked == false){
			alert("请认真阅读协议并同意");
			return;
		}
		myfunction();
	}
	
	 function javaTrim(str) {//判断输入的是否为空
	     for (var i=0; (str.charAt(i)==' ') && i<str.length; i++);
	     if (i == str.length) return ''; //whole string is space
	     var newstr = str.substr(i);
	     for (var i=newstr.length-1; newstr.charAt(i)==' ' && i>=0; i--);
	     newstr = newstr.substr(0,i+1);
	     return newstr;
	} 
	
	function delHeaders(obj)//点击事件那边需要加this
	{
		var tr=obj.parentNode.parentNode;
		var tbody=tr.parentNode;
		tbody.removeChild(tr);
	}
</script>
</body>
</html>
