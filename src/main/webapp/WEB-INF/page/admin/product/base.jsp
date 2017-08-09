<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yongj
  Date: 7/15/2017
  Time: 2:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <div class="logoBtn" id="imgBtn">
	        	<c:if test="${not empty hashMap.productBaseInfo.icon}">
	        		<div class="f-imgshow">
		        		<div class="shade hide">
		        			<i class="close"></i>
		        		</div>
		        		<img src=${hashMap.productBaseInfo.icon} alt="" id="logo" height="150" class="showImg"/>
	        		</div>
	        	</c:if>
	        <form id="show" class="btn-upload" enctype="multipart/form-data">
	            <input type="file" name="file" id="upLogo" accept="image/png,image/gif,image/jpg,image/jpeg">
	        </form>
        <div class="cell gray9">请上传资料的照片或扫描件。图片格式仅限jpg、png、gif格式，大小不超过1M。</div>
        </div>
    </div>
    <div class="ml40 pad30">
        <input type="button" class="btn btn-blue" value="下一步"
               data-url="api">
    </div>
</div>