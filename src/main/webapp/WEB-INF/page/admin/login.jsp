<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
            + "/";
%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>数信系统-后台管理中心</title>

    <link href='<%=basePath%>static/admin/css/bootstrap.min.css?1499845987' rel="stylesheet" type="text/css"/>
    <link href='<%=basePath%>static/admin/css/sb-admin.css?1499845987' rel="stylesheet" type="text/css"/>
    <link href='<%=basePath%>static/admin/font-awesome/css/font-awesome.min.css?1499845987' rel="stylesheet"
          type="text/css"/>
    <link href='<%=basePath%>static/admin/css/baseui.css?1499845987' rel="stylesheet" type="text/css"/>


    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <%--密码加密--%>
    <script src="<%=basePath%>static/js/CryptoJSv3.1.2/rollups/hmac-sha256.js"></script>
    <script src="<%=basePath%>static/js/CryptoJSv3.1.2/components/enc-base64-min.js"></script>

</head>

<body class="bg-img">
<!-- Brand and toggle get grouped for better mobile display -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <img src="<%=basePath%>static/admin/images/logo.png" alt="" width="302" height="38">
    </div>
</nav>
<div class="row">
    <div id="row_error" class="text-center">
    </div>
</div>
<div class="row" style="margin-top: 150px">
    <div class="col-md-4 col-md-offset-4">
        <div class="login-panel panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title text-center">登录</h3>
            </div>
            <div class="panel-body">
                <form role="form">
                    <fieldset>
                        <div class="form-group">
                            <input class="form-control" placeholder="账号" name="email" id="email" type="email" autofocus
                                   value="administrator">
                            <div class="error-tip" id="user_error"></div>
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="密码" name="password" id="password" type="password"
                                   value="aa123456">
                            <div class="error-tip" id="psd_error"></div>
                        </div>
                        <div class="form-group">
                            <a id="login" class="btn btn-lg btn-block">登录</a>
                        </div>
                        <!--<div class="checkbox">
                            <label>
                                <input name="remember" type="checkbox" value="Remember Me">Remember Me
                            </label>
                        </div>-->
                        <!-- Change this to a button or input when using this as a form -->

                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</div>

<script src='<%=basePath%>static/admin/js/jquery.js?1499845987'></script>
<script src='<%=basePath%>static/admin/js/bootstrap.min.js?1499845987'></script>
<script src='<%=basePath%>static/admin/js/common.js?1499845987'></script>
<script src='<%=basePath%>static/admin/js/md5.min.js?1499845987'></script>

<script>
    /*
     * 显示错误提示信息
     * @param msg string 错误提示
     * */

    $("#email").bind('input propertychange', function () {
        $("#user_error").text('');
    });
    $("#password").bind('input propertychange', function () {
        $("#psd_error").text('');
    });
    $("#login").click(function () {
        var email = $("#email").val();
        var password = $("#password").val();

        if (trim(email) == '') {
            $("#user_error").text('请输入管理员账号!');
            return;
        }

        if (trim(password) == '' || password.length < 8 || password.length > 20) {
            $("#psd_error").text('请输入管理员密码，字符数在8-20位!');
            return;
        }

        var hash = CryptoJS.HmacSHA256(password, email);
        var hashInBase64 = CryptoJS.enc.Base64.stringify(hash);
        console.log(hashInBase64);

        var data = {
            'account': email,
            'password': hashInBase64
        };

        $.post('<%=basePath%>admin/login', data, function (obj) {
            if (obj && obj.code == 0) {
                console.log(obj);
                localStorage.token = obj.data;
//                debugger;
                location.href = '<%=basePath%>admin';
            } else {
                $("#psd_error").text("用户名或密码错误，" + obj.message);
            }
        });

    });

</script>

</body>

</html>
