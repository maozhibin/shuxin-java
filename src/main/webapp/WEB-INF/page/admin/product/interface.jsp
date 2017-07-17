<%--
  Created by IntelliJ IDEA.
  User: yongj
  Date: 7/17/2017
  Time: 2:49 PM
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
    <title>接口设置</title>

    <link href='<%=basePath%>static/css/style.css?1.0' rel="stylesheet" type="text/css"/>
    <link href='<%=basePath%>static/css/market.css?1.0' rel="stylesheet" type="text/css"/>

    <link href='<%=basePath%>static/admin/css/data-release.css?1.0' rel="stylesheet" type="text/css"/>

    <script>
        $(function () {
            $(".add_header").click(function () {
                var request_headers = $("#request_headers");
                var header_name_input = $("input[name='header_name_input']");
                var header_type_input = $("input[name='header_type_input']");
                var header_must_input = $("select[name='header_must_input']");
                var header_desc_input = $("input[name='header_desc_input']");
                if (header_name_input.val() == "") {
                    show_dialog({
                        msg: "header名称不能为空"
                    });
                    return false;
                }
                if (header_type_input.val() == "") {
                    show_dialog({
                        msg: "header类型不能为空"
                    });
                    return false;
                }
                if (header_desc_input.val() == "") {
                    show_dialog({
                        msg: "header描述不能为空"
                    });
                    return false;
                }
                var checked = "";
                if (header_must_input.val() == 1) {
                    checked = '<select name="header_must[]" class="input-ctrl"><option value="1">必须</option></select>';
                } else {
                    checked = '<select name="header_must[]" class="input-ctrl"><option value="0">非必须</option></select>';
                }
                var request_header_tr = ' <tr> ' +
                    '<td><input type="text" class="input" value="' + header_name_input.val() +
                    '" placeholder="点击输入" name="header_name[]"></td>' +
                    '<td><input type="text" class="input" value="' + header_type_input.val() +
                    '" placeholder="点击输入" name="header_type[]"></td>' +
                    '<td>' +
                    checked +
                    '</td>' +
                    '<td><input type="text" class="input" value="' + header_desc_input.val() +
                    '" placeholder="点击输入" name="header_desc[]"></td>' +
                    '<td></td>' +
                    '</tr>';
                request_headers.prepend(request_header_tr);

                header_name_input.val("");
                header_type_input.val("");
                header_desc_input.val("");
            });

            $(".add_query").click(function () {
                var request_querys = $("#request_querys");
                var query_name_input = $("input[name='query_name_input']");
                var query_type_input = $("input[name='query_type_input']");
                var query_must_input = $("select[name='query_must_input']");
                var query_desc_input = $("input[name='query_desc_input']");
                if (query_name_input.val() == "") {
                    show_dialog({
                        msg: "query名称不能为空"
                    });
                    return false;
                }
                if (query_type_input.val() == "") {
                    show_dialog({
                        msg: "query类型不能为空"
                    });
                    return false;
                }
                if (query_desc_input.val() == "") {
                    show_dialog({
                        msg: "query描述不能为空"
                    });
                    return false;
                }
                var checked = "";
                if (query_must_input.val() == 1) {
                    checked = '<select name="query_must[]" class="input-ctrl"><option value="1">必须</option></select>';
                } else {
                    checked = '<select name="query_must[]" class="input-ctrl"><option value="0">非必须</option></select>';
                }
                var request_query_tr = ' <tr> ' +
                    '<td><input type="text" class="input" value="' + query_name_input.val() +
                    '" placeholder="点击输入" name="query_name[]"></td>' +
                    '<td><input type="text" class="input" value="' + query_type_input.val() +
                    '" placeholder="点击输入" name="query_type[]"></td>' +
                    '<td>' +
                    checked +
                    '</td>' +
                    '<td><input type="text" class="input" value="' + query_desc_input.val() +
                    '" placeholder="点击输入" name="query_desc[]"></td>' +
                    '<td></td>' +
                    '</tr>';
                request_querys.prepend(request_query_tr);

                query_name_input.val("");
                query_type_input.val("");
                query_desc_input.val("");
            });

            $(".add_body").click(function () {
                var request_bodys = $("#request_bodys");
                var body_name_input = $("input[name='body_name_input']");
                var body_type_input = $("input[name='body_type_input']");
                var body_must_input = $("select[name='body_must_input']");
                var body_desc_input = $("input[name='body_desc_input']");
                if (body_name_input.val() == "") {
                    show_dialog({
                        msg: "body名称不能为空"
                    });
                    return false;
                }
                if (body_type_input.val() == "") {
                    show_dialog({
                        msg: "body类型不能为空"
                    });
                    return false;
                }
                if (body_desc_input.val() == "") {
                    show_dialog({
                        msg: "body描述不能为空"
                    });
                    return false;
                }
                var checked = "";
                console.log(body_must_input.val());
                if (body_must_input.val() == 1) {
                    checked = '<select name="body_must[]" class="input-ctrl"><option value="1">必须</option></select>';
                } else {
                    checked = '<select name="body_must[]" class="input-ctrl"><option value="0">非必须</option></select>';
                }
                var request_body_tr = ' <tr> ' +
                    '<td><input type="text" class="input" value="' + body_name_input.val() +
                    '" placeholder="点击输入" name="body_name[]"></td>' +
                    '<td><input type="text" class="input" value="' + body_type_input.val() +
                    '" placeholder="点击输入" name="body_type[]"></td>' +
                    '<td>' +
                    checked +
                    '</td>' +
                    '<td><input type="text" class="input" value="' + body_desc_input.val() +
                    '" placeholder="点击输入" name="body_desc[]"></td>' +
                    '<td></td>' +
                    '</tr>';
                request_bodys.prepend(request_body_tr);

                body_name_input.val("");
                body_type_input.val("");
                body_desc_input.val("");
            });

            $(".add_code").click(function () {
                var request_codes = $("#request_codes");
                var code_name_input = $("input[name='code_name_input']");
                var code_info_input = $("input[name='code_info_input']");
                var code_desc_input = $("input[name='code_desc_input']");
                if (code_name_input.val() == "") {
                    show_dialog({
                        msg: "code名称不能为空"
                    });
                    return false;
                }
                if (code_info_input.val() == "") {
                    show_dialog({
                        msg: "code类型不能为空"
                    });
                    return false;
                }
                if (code_desc_input.val() == "") {
                    show_dialog({
                        msg: "code描述不能为空"
                    });
                    return false;
                }
                var request_code_tr = ' <tr> ' +
                    '<td><input type="text" class="input" value="' + code_name_input.val() +
                    '" placeholder="点击输入" name="code_name[]"></td>' +
                    '<td><input type="text" class="input" value="' + code_info_input.val() +
                    '" placeholder="点击输入" name="code_info[]"></td>' +
                    '<td><input type="text" class="input" value="' + code_desc_input.val() +
                    '" placeholder="点击输入" name="code_desc[]"></td>' +
                    '<td></td>' +
                    '</tr>';
                request_codes.prepend(request_code_tr);

                code_name_input.val("");
                code_info_input.val("");
                code_desc_input.val("");
            });
        });
    </script>
</head>
<body>

<div class="release-tabs">
    <div class="tabs">
        <a href="<%=basePath%>admin/product/issue" class="tab">基础设置</a>
        <a href="<%=basePath%>admin/product/inter" class="tab active">接口设置</a>
        <a href="<%=basePath%>admin/product/description" class="tab">产品描述</a>
        <a href="<%=basePath%>admin/product/fee" class="tab">计费设置</a>
    </div>
    <form action="<%=basePath%>admin/product/inter/${product_id}">
        <div class="container api">
            <div class="inline-form mb30">
                <div class="addon">数据名称</div>
                <div class="cell"><input type="text" class="input-ctrl" name="interface_name"></div>
                <?php echo form_error('interface_name'); ?>
            </div>
            <div class="inline-form mb30">
                <div class="addon">数据简介</div>
                <div class="cell"><input type="text" class="input-ctrl full" name="introduction"></div>
                <?php echo form_error('introduction'); ?>
            </div>

            <div class="inline-form mb30">
                <div class="addon">请求方式</div>
                <div class="cell">
                    <select class="input-ctrl" name="request_method">
                        <option value=""></option>
                    </select>
                </div>
                <div class="addon">返回报文格式</div>
                <div class="cell vat">
                    <select class="input-ctrl" name="response_format">
                        <option value=""></option>
                    </select>
                </div>
            </div>

            <div class="inline-form mb30">
                <div class="addon">传输字符</div>
                <div class="cell">
                    <select class="input-ctrl" name="character">
                        <option value=""></option>
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
            <div class="code-example mb30">
                <div class="tab-head">
                    <a href="" class="tab active">curl</a>
                    <a href="" class="tab">Java</a>
                    <a href="" class="tab">C#</a>
                    <a href="" class="tab">PHP</a>
                    <a href="" class="tab">Python</a>
                    <a href="" class="tab">ObjectC</a>
                </div>
                <div class="container">

                </div>
            </div>


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
                <input type="submit" class="btn btn-red" value="下一步">
            </div>
        </div>
    </form>
</div>
</body>
</html>
