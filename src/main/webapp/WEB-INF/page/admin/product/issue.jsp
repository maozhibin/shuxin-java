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

<div class="release-tabs">
    <div class="tabs">
        <a onclick="goto('base')" class="tab base active">基础设置</a>
        <a onclick="goto('api')" class="tab api">接口设置</a>
        <a onclick="goto('desc')" class="tab desc">产品描述</a>
        <a onclick="goto('price')" class="tab price">计费设置</a>
    </div>
    <form action="<%=basePath%>admin/product/issue" method="post">
        <div class="container base">
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
                        <option value="">实时</option>
                        <option value="">每日</option>
                        <option value="">每周</option>
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
                        <option value="">API</option>
                    </select>
                    <?php echo form_error('product_type'); ?>
                </div>
            </div>
            <div class="inline-form mb30">
                <div class="addon">数据简介</div>
                <div class="cell">
                        <textarea rows="10" class="input-ctrl"
                                  name="product_description">${product_description}</textarea>
                    <?php echo form_error('product_description'); ?>
                </div>
            </div>
            <div class="inline-form mb30">
                <div class="addon">标签设置</div>
                <div class="cell">
                    <input type="text" name="product_tags" value="${product_tags}" class="input-ctrl"/>
                    <?php echo form_error('product_tags'); ?>
                </div>
                <div class="cell gray9">多个标签请用逗号分隔，例如：标签,设置。</div>
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
            <div class="ml40 pad30">
                <input type="button" class="btn btn-blue" value="下一步"
                       onclick="goto('api');">
            </div>
        </div>

        <div hidden="hidden" class="container api">

            <div class="inline-form mb30">
                <div class="addon">请求方式</div>
                <div class="cell">
                    <select class="input-ctrl" name="request_method">
                        <option value="">POST</option>
                        <option value="">GET</option>
                    </select>
                </div>
                <div class="addon">返回报文格式</div>
                <div class="cell vat">
                    <select class="input-ctrl" name="response_format">
                        <option value="">JSON</option>
                        <option value="">XML</option>
                    </select>
                </div>
            </div>

            <div class="inline-form mb30">
                <div class="addon">传输字符</div>
                <div class="cell">
                    <select class="input-ctrl" name="character">
                        <option value="">UTF-8</option>
                    </select>
                </div>
                <div class="addon">请求超时时长</div>
                <div class="cell">
                    <input type="text" class="input-ctrl" name="timeout">
                </div>
                <?php echo form_error('timeout'); ?>
            </div>

            <p class="f16 gray6 mb10">请求参数（Headers）</p>
            <table class="mb50">
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
                <tr>
                    <td><input type="text" class="input" value="" placeholder="点击输入" name="header_name_input"></td>
                    <td><input type="text" class="input" value="" placeholder="点击输入" name="header_type_input"></td>
                    <td>
                        <select name="header_must_input" class="input-ctrl">
                            <option value="1">必须</option>
                            <option value="0">非必须</option>
                        </select>
                    </td>
                    <td><input type="text" class="input" value="" placeholder="点击输入" name="header_desc_input"></td>
                    <td><a href="javascript:void(0)" class="blue add-line add_header">新增</a></td>
                </tr>
                </tbody>
            </table>

            <p class="f16 gray6 mb10">请求参数（Query）</p>
            <table class="mb50">
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
                <tr>
                    <td><input type="text" class="input" value="" placeholder="点击输入" name="query_name_input"></td>
                    <td><input type="text" class="input" value="" placeholder="点击输入" name="query_type_input"></td>
                    <td>
                        <select name="query_must_input" class="input-ctrl">
                            <option value="1">必须</option>
                            <option value="0">非必须</option>
                        </select>
                    </td>
                    <td><input type="text" class="input" value="" placeholder="点击输入" name="query_desc_input"></td>
                    <td><a href="javascript:void(0)" class="blue add-line add_query">新增</a></td>
                </tr>
                </tbody>
            </table>

            <p class="f16 gray6 mb10">请求参数（Body）</p>
            <table class="mb50">
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
                <tr>
                    <td><input type="text" class="input" value="" placeholder="点击输入" name="body_name_input"></td>
                    <td><input type="text" class="input" value="" placeholder="点击输入" name="body_type_input"></td>
                    <td>
                        <select name="body_must_input" class="input-ctrl">
                            <option value="1">必须</option>
                            <option value="0">非必须</option>
                        </select>
                    </td>
                    <td><input type="text" class="input" value="" placeholder="点击输入" name="body_desc_input"></td>
                    <td><a href="javascript:void(0)" class="blue add-line add_body">新增</a></td>
                </tr>
                </tbody>
            </table>

            <p class="f16 gray6 mb10">请求示例</p>
            <textarea rows="10" class="input-ctrl mb30" name="request_sample"></textarea>

            <p class="f16 gray6 mb10">正常返回示例</p>
            <textarea rows="10" class="input-ctrl mb30" name="normal_sample"></textarea>

            <p class="f16 gray6 mb10">错误返回示例</p>
            <textarea rows="10" class="input-ctrl mb30" name="error_sample"></textarea>


            <p class="f16 gray6 mb10">错误码定义</p>
            <table class="mb50">
                <thead>
                <tr>
                    <th width="218">错误码</th>
                    <th width="218">错误信息</th>
                    <th>描述</th>
                    <th width="56"></th>
                </tr>
                </thead>
                <tbody id="request_codes">
                <tr>
                    <td><input type="text" class="input" value="" placeholder="点击输入" name="code_name_input"></td>
                    <td><input type="text" class="input" value="" placeholder="点击输入" name="code_info_input"></td>
                    <td><input type="text" class="input" value="" placeholder="点击输入" name="code_desc_input"></td>
                    <td><a href="javascript:void(0)" class="blue add-line add_code">新增</a></td>
                </tr>
                </tbody>
            </table>

            <div class="pt30 pb30">
                <input type="button" class="btn btn-red" value="下一步"
                       onclick="goto('desc');">
            </div>
        </div>

        <div hidden="hidden" class="container desc">
            <p class="f16 gray6 mb10">产品介绍</p>
            <textarea rows="10" class="input-ctrl mb30" name="intro" id="intro">${intro}</textarea>
            <?php echo form_error('intro'); ?>

            <p class="f16 gray6 mb10 mt10">产品亮点</p>
            <textarea rows="10" class="input-ctrl mb30" name="highlight" id="highlight">${highlight}</textarea>
            <?php echo form_error('highlight'); ?>

            <p class="f16 gray6 mb10 mt10">产品截图</p>
            <textarea rows="10" class="input-ctrl mb30" name="snapshot" id="snapshot">${snapshot}</textarea>
            <?php echo form_error('snapshot'); ?>

            <p class="f16 gray6 mb10 mt10">售后服务</p>
            <textarea rows="10" class="input-ctrl mb30" name="service" id="service">${service}</textarea>
            <?php echo form_error('service'); ?>

            <div class="pt30 pb30">
                <input class="btn btn-red" type="button" value="下一步"
                       onclick="goto('price');">
            </div>
        </div>

        <div hidden="hidden" class="container price">
            <p class="f16 gray6 mb10 mt10">计费方式</p>
            <div class="mb30" id="container-combo">
                <table class="mb50">
                    <thead>
                    <tr>
                        <th>标准名称</th>
                        <th>价格(元)</th>
                    </tr>
                    </thead>
                    <tbody id="request_billings">
                    <tr>
                        <td><input type="text" class="input" value="单次" placeholder="点击输入" name="billing_name_input"
                                   disabled="disabled"></td>
                        <td><input class="input" type="text" placeholder="点击输入" name="billing_price_input"></td>
                    </tr>
                    <tr>
                        <td><input type="text" class="input" value="100次" placeholder="点击输入" name="billing_name_input"
                                   disabled="disabled"></td>
                        <td><input class="input" type="text" placeholder="点击输入" name="billing_price_input"></td>
                    </tr>
                    <tr>
                        <td><input type="text" class="input" value="包年" placeholder="点击输入" name="billing_name_input"
                                   disabled="disabled"></td>
                        <td><input class="input" type="text" placeholder="点击输入" name="billing_price_input"></td>
                    </tr>
                    </tbody>
                </table>
            </div>

            <div class="pb30">
                <p class="mb10"><label class="gray6"><input type="checkbox" class="agreement">
                    我已同意并阅读 <a href="" class="blue">《2226888协议》</a></label>
                </p>
                <button class="btn btn-red" id="submit_btn">提交发布</button>
                <input type="submit" id="submit" class="hide">
            </div>
        </div>
    </form>
</div>

</body>
</html>
