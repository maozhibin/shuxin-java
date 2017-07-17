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

<div class="release-tabs">
    <div class="tabs">
        <a href="<%=basePath%>admin/product/issue" class="tab active">基础设置</a>
        <a href="<%=basePath%>admin/product/inter" class="tab">接口设置</a>
        <a href="<%=basePath%>admin/product/description" class="tab">产品描述</a>
        <a href="<%=basePath%>admin/product/fee" class="tab">计费设置</a>
    </div>
    <div class="container base">
        <form action="<%=basePath%>admin/product/issue">
            <div class="inline-form mb30">
                <div class="addon">数据名称</div>
                <div class="cell">
                    <input type="text" class="input-ctrl" name="product_name"
                           value="${product_name}">
                    <?php echo form_error('product_name'); ?>
                </div>
                <div class="addon">更新频率</div>
                <div class="cell">
                    <select class="input-ctrl" name="frequent">
                        <option value=""></option>
                    </select>
                    <?php echo form_error('frequent'); ?>
                </div>
            </div>
            <div class="inline-form mb30">
                <div class="addon">数据分类</div>
                <div class="cell">
                    <div class="mb15">
                        <select class="input-ctrl" name="product_class" id="product_class">
                            <option value=""></option>
                        </select>
                        <?php echo form_error('product_class'); ?>
                    </div>

                    <div class="">
                        <select class="input-ctrl" name="product_base" id="product_base">
                            <option value=""></option>
                        </select>
                        <?php echo form_error('product_base'); ?>
                    </div>

                </div>

                <div class="addon">数据类型</div>
                <div class="cell vat">
                    <select class="input-ctrl" name="product_type" id="product_type">
                        <option value=""></option>
                    </select>
                    <?php echo form_error('product_type'); ?>
                </div>
            </div>
            <div class="inline-form mb30">
                <div class="addon">数据简介</div>
                <div class="cell">
                    <textarea rows="10" class="input-ctrl" name="product_description">${product_description}</textarea>
                    <?php echo form_error('product_description'); ?>
                </div>
            </div>
            <div class="inline-form mb30">
                <div class="addon">标签设置</div>
                <div class="cell">
                    <input type="text" name="product_tags" value="${product_tags}" class="input-ctrl"/>
                    <?php echo form_error('product_tags'); ?>
                </div>
                <i class="fa fa-plus"></i>
            </div>

            <div class="inline-form mb30">
                <div class="addon">数据logo</div>
                <div class="cell">
                    <label for="upload" class="upload">上传图片</label>
                    <input type="file" id="upload" class="hide" name="user_file"
                           accept="image/png,image/gif,image/jpg,image/jpeg">
                </div>
                <img id="img"/>
                <i id="close" class="hide"></i>
                <input type="text" class="hide" id="logo" name="logo">
                <div class="cell gray9">请上传资料的照片或扫描件。图片格式仅限jpg、png、gif格式，大小不超过1M。</div>
                <?php echo form_error("logo"); ?>
            </div>
            <div class="ml40 pad30"><input type="submit" id="submit" class="btn btn-blue" value="下一步"></div>
        </form>
    </div>
</div>

</body>
</html>
