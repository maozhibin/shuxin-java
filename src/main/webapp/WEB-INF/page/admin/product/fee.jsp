<%--
  Created by IntelliJ IDEA.
  User: yongj
  Date: 7/17/2017
  Time: 2:54 PM
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
    <title>计费设置</title>

    <link href='<%=basePath%>static/css/style.css?1.0' rel="stylesheet" type="text/css"/>
    <link href='<%=basePath%>static/css/market.css?1.0' rel="stylesheet" type="text/css"/>

    <link href='<%=basePath%>static/admin/css/data-release.css?1.0' rel="stylesheet" type="text/css"/>

    <script>
        $(function () {
            var valid_time = $("input[name='valid_time']");
            var container_combo = $("#container-combo");
            var container_per = $("#container-per");
            $("#billing_method").change(function () {
                var result = $(this).val();
                if (result == 'combo') {
                    container_combo.show();
                    container_per.hide();
                }
                switch (result) {
                    case 'y':
                        valid_time.val(12);
                        break;
                    case 'q':
                        valid_time.val(3);
                        break;
                    case 'm':
                        valid_time.val(1);
                        break;
                    case 'w':
                        valid_time.val(0.25);
                        break;
                }
            });

            $(".add_billing").click(function () {
                var request_billings = $("#request_billings");
                var billing_name_input = $("input[name='billing_name_input']");
                var billing_time_input = $("input[name='billing_time_input']");
                var billing_price_input = $("input[name='billing_price_input']");
                if (billing_name_input.val() == "") {
                    show_dialog({
                        msg: "套餐名称不能为空"
                    });
                    return false;
                }
                if (billing_time_input.val() == "") {
                    show_dialog({
                        msg: "套餐次数不能为空"
                    });
                    return false;
                }
                if (billing_price_input.val() == "") {
                    show_dialog({
                        msg: "套餐价格不能为空"
                    });
                    return false;
                }
                var request_billing_tr = ' <tr> ' +
                    '<td><input type="text" class="input" value="' + billing_name_input.val() +
                    '" placeholder="点击输入" name="billing_name[]"></td>' +
                    '<td> <ul class="inline">' +
                    '<li class="cell"><input type="text" name="billing_time[]" value="' +
                    billing_time_input.val() +
                    '"></li>' +
                    '<li class="cell">次/</li>' +
                    '<li class="cell"><input type="text" name="billing_price[]" value="' +
                    billing_price_input.val() +
                    '"></li>' +
                    '<li class="cell">元</li>' +
                    '</ul></td>' +
                    '<td></td>' +
                    '</tr>';
                request_billings.prepend(request_billing_tr);

                billing_name_input.val("");
                billing_time_input.val("");
                billing_price_input.val("");
            });

            var form = $("#form"),
                submit_btn = $("#submit_btn");
            submit_btn.click(function (e) {
                e.preventDefault();
                var checked = true;
                $(".agreement").each(function () {
                    if ($(this).prop("checked") == false) {
                        show_dialog({
                            msg: "请选择协议"
                        });
                        checked = false;
                    }
                });

                if (checked) {
                    $("#submit").click();
                }
            });
        });
    </script>
</head>
<body>

<div class="release-tabs">
    <div class="tabs">
        <a href="<%=basePath%>admin/product/issue" class="tab">基础设置</a>
        <a href="<%=basePath%>admin/product/inter" class="tab">接口设置</a>
        <a href="<%=basePath%>admin/product/description" class="tab">产品描述</a>
        <a href="<%=basePath%>admin/product/fee" class="tab active">计费设置</a>
    </div>
    <form action="<%=basePath%>admin/product/fee/${product_id}">
        <div class="container price">
            <div class="inline-form mb30">
                <div class="addon">计费方式</div>
                <div class="cell">
                    <select class="input-ctrl" name="billing_method" id="billing_method">
                        <option value=""></option>
                    </select>
                    <?php echo form_error('billing_method'); ?>
                </div>
                <div class="addon">结算方式</div>
                <div class="cell">
                    <select class="input-ctrl" name="settlement" id="settlement">
                        <option value=""></option>
                    </select>
                    <?php echo form_error('settlement'); ?>
                </div>
            </div>

            <div class="inline-form mb30">
                <div class="addon">有效时间</div>
                <div class="addon">
                    <input type="text" class="input-ctrl" name="valid_time">
                </div>
                <div class="cell">月</div>
            </div>

            <div class="ml60 pl10" id="container-per">
                <table class="mb50">
                    <thead>
                    <tr>
                        <th width="218">标准名称</th>
                        <th>设置</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td><input type="text" class="input" value="" placeholder="点击输入" name="billing_name_per"></td>
                        <td>
                            <ul class="inline">
                                <li class="cell"><input type="text" name="billing_time_per"></li>
                                <li class="cell">次/</li>
                                <li class="cell"><input type="text" name="billing_price_per"></li>
                                <li class="cell">元</li>
                            </ul>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>

            <div class="ml60 pl10 hide" id="container-combo">
                <table class="mb50">
                    <thead>
                    <tr>
                        <th width="218">标准名称</th>
                        <th>设置</th>
                        <th width="56"></th>
                    </tr>
                    </thead>
                    <tbody id="request_billings">
                    <tr>
                        <td><input type="text" class="input" value="" placeholder="点击输入" name="billing_name_input"></td>
                        <td>
                            <ul class="inline">
                                <li class="cell"><input type="text" name="billing_time_input"></li>
                                <li class="cell">次/</li>
                                <li class="cell"><input type="text" name="billing_price_input"></li>
                                <li class="cell">元</li>
                            </ul>
                        </td>
                        <td><a href="javascript:void(0)" class="blue add-line add_billing">新增</a></td>
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
