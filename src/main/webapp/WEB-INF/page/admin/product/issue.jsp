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

    <link href='/static/css/style.css?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>' rel="stylesheet" type="text/css"/>
    <link href='/static/css/market.css?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>' rel="stylesheet" type="text/css"/>
    <link href='/static/css/style_other.css?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>' rel="stylesheet" type="text/css"/>
    <link href='/static/css/data.css?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>' rel="stylesheet" type="text/css"/>
    <link href='/static/css/jquery.tagsinput.css?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>' rel="stylesheet" type="text/css"/>

    <link href='/static/admin/css/data-release.css?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>' rel="stylesheet" type="text/css"/>

    <script src='/static/js/jquery.tagsinput.js?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>'></script>
    <script src='/static/js/jquery.ajaxfileupload.js?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>'></script>
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


<div class="release-tabs" >
    <div class="tabs">
        <!--  <a onclick=" " class="tab base active">基础设置</a>
        <a onclick=" " class="tab api">接口设置</a>
        <a onclick=" " class="tab desc">产品描述</a>
        <a onclick=" " class="tab price">计费设置</a>-->
        <a onclick="goto('base')" class="tab base active">基础设置</a>
        <a onclick="goto('api')" class="tab api">接口设置</a>
        <a onclick="goto('desc')" class="tab desc">产品描述</a>
        <a onclick="goto('price')" class="tab price">计费设置</a>
     </div>
     	<input type="hidden" class="input-ctrl" name="productId" id="productId" value="${hashMap.productBaseInfo.id}">
     	<input type="hidden" class="input-ctrl" name="areaId" id="areaId" value="${hashMap.productBaseInfo.areaId}">

    <%@include file="base.jsp"%>

    <%@include file="interface.jsp"%>

    <%@include file="description.jsp"%>

    <%@include file="fee.jsp"%>
</div>
<script>
    <!--文件上传-->
    $("#upload").AjaxFileUpload({
        action: '/admin/upload/logo',
        onComplete: function (filename, response) {
            if (response.error != null) {
                alert(response.error + "请重新选择");
            } else {
                var url = base_url + response.imgUrl;
                $("#logo").val(url);
                $(this).parents(".cell").addClass('hide');
                $("#close").removeClass('hide');
                $("#img").removeClass('hide').attr("src", url).attr("width", 96).attr("height", 96).attr('alt', filename);
            }
        }
    });
    $("#img").click(function () {
        $("#upload").trigger("click");
    });
    $("#close").click(function () {
        $(this).addClass('hide').prevAll('img').removeAttr('src width height alt').addClass('hide').prevAll('.cell').removeClass('hide');
        $("#upload").val("");
    });
</script>
<script>
    //查找box元素,检测当粘贴时候,
    document.querySelector('#snapshot').addEventListener('paste', function (e) {

        //判断是否是粘贴图片
        if (e.clipboardData && e.clipboardData.items[0].type.indexOf('image') > -1) {
            var that = this,
                reader = new FileReader();
            file = e.clipboardData.items[0].getAsFile();

            //ajax上传图片
            reader.onload = function (e) {
                var xhr = new XMLHttpRequest(),
                    fd = new FormData();

                xhr.open('POST', '/admin/upload/imageBase64', true);
                xhr.onload = function () {
                    var img = new Image();
                    img.src = base_url + xhr.responseText;

                    //todo 记录返回的图片地址
                    // that.innerHTML = '<img src="'+img.src+'" alt=""/>';
                    document.getElementById("img_puth").value = img.src;
                }

                // this.result得到图片的base64 (可以用作即时显示)
                fd.append('file', this.result);
                that.innerHTML = '<img src="' + this.result + '" alt=""/>';
                xhr.send(fd);
            }
            reader.readAsDataURL(file);
        }
    }, false);
</script>
<script src='/static/js/issue.js?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>'></script>
</body>
</html>
