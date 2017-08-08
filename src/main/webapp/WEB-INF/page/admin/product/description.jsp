<%--
  Created by IntelliJ IDEA.
  User: yongj
  Date: 7/17/2017
  Time: 2:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div hidden="hidden" class="container desc">
    <p class="f16 gray6 mb10">产品介绍</p>
    <textarea rows="10" class="input-ctrl mb30" name="intro" id="intro">${hashMap.productDetail.intro}</textarea>

    <p class="f16 gray6 mb10 mt10">产品亮点</p>
    <textarea rows="10" class="input-ctrl mb30" name="highlight" id="highlight">${hashMap.productDetail.highlight}</textarea>

    <p class="f16 gray6 mb10 mt10">产品截图</p>
    <%--<textarea rows="10" class="input-ctrl mb30" name="snapshot" id="snapshot">${hashMap.productDetail.snapshot}</textarea>--%>
    <div class="m-imgshow">
        <div class="thumbnail-list" id="inResult">
        </div>
        <div class="imgBtn">
        <form id="image-upload" class="btn-upload" enctype="multipart/form-data">
            <input type="file" name="file" id="update">
        </form>
        <span class="upload-num">共<em id="all">0</em>张,还能上传<em id="num">9</em>张</span>
        </div>
    </div>

    <p class="f16 gray6 mb10 mt10">售后服务</p>
    <textarea rows="10" class="input-ctrl mb30" name="service" id="service">${hashMap.productDetail.service}</textarea>

    <div class="pt30 pb30">
        <input class="btn btn-red" type="button" value="下一步"
               data-url="price">
    </div>
</div>

<script src='/static/admin/js/img-holder.js?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>'></script>
<script src="http://malsup.github.io/jquery.form.js"></script>
