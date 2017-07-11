<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>资产-后台管理中心</title>

    <?php load_css('static/admin/css/bootstrap.min.css');?>
    <?php load_css('static/admin/css/sb-admin.css');?>
    <?php load_css('static/admin/font-awesome/css/font-awesome.min.css');?>
    <?php load_css('static/admin/css/baseui.css');?>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
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
        <img src="<?php echo base_url('static/admin/images/logo.png')?>" alt="" width="470" height="40">
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
                                <input class="form-control" placeholder="账号" name="email" id="email" type="email" autofocus>
                                <div class="error-tip" id="user_error"></div>
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="密码" name="password" id="password" type="password" value="">
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

<?php load_js('static/admin/js/jquery.js');?>
<?php load_js('static/admin/js/bootstrap.min.js');?>
<?php load_js('static/admin/js/common.js');?>
<?php load_js('static/admin/js/md5.min.js');?>
<script>
    /*
    * 显示错误提示信息
    * @param msg string 错误提示
    * */

    $("#email").bind('input propertychange', function() {
        $("#user_error").text('');
    });
    $("#password").bind('input propertychange', function() {
        $("#psd_error").text('');
    });
    $("#login").click(function () {
        var email = $("#email").val();
        var password = $("#password").val();

        if(trim(email) == ''){
            $("#user_error").text('请输入管理员账号!');
            return ;
        }

        if(trim(password) == '' || password.length < 8 || password.length > 20){
            $("#psd_error").text('请输入管理员密码，字符数在8-20位!');
            return ;
        }

        var data = {
            'account' : email,
            'password' : password
        };

        $.post('<?php echo base_url('admin/login/login_action');?>',data,function (obj) {
            if(obj && obj.error == 0){
                console.log(obj);
                localStorage.token=obj.data.token;
//                debugger;
                location.href = '<?php echo base_url('admin');?>';
            }else{
                $("#psd_error").text("用户名或密码错误，"+obj.data);
            }
        });

    });

</script>

</body>

</html>
