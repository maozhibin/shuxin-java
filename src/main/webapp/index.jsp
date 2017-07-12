<%--
  Created by IntelliJ IDEA.
  User: yongj
  Date: 7/10/2017
  Time: 12:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>亚欧大数据交易中心-后台管理中心</title>

    <link rel="stylesheet" href="../public/static/admin/css/bootstrap.min.css">
    <link rel="stylesheet" href="../public/static/admin/css/sb-admin.css">
    <link rel="stylesheet" href="../public/static/admin/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="../public/static/admin/css/baseui.css">
    <link rel="stylesheet" href="../public/static/admin/css/AdminLTE.min.css">


    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->


</head>

<body>
<!-- 错误提示模态框（Modal） -->
<div class="modal fade" id="model_error" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <div class="alert alert-danger error-msg"></div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">
                    确定
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<!-- 删除提示模态框（Modal） -->
<div class="modal fade" id="model_delete" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <div class="alert alert-danger error-msg"></div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">
                    取消
                </button>
                <button type="button" class="btn btn-danger" id="model_delete_sure" data-dismiss="modal">
                    确定
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<!-- 成功提示模态框（Modal） -->
<div class="modal fade" id="model_success" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <div class="alert alert-success error-msg"></div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success" id="model_success_sure" data-dismiss="modal">
                    确定
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<script>
    /*
     * 显示错误提示信息
     * @param msg string 错误提示
     * */
    function show_error(msg) {
        $("#model_error .error-msg").text(msg);
        $("#model_error").modal('show');
    }

    /*
     * 显示删除提示信息
     * @param msg string 错误提示
     * @param callback function 确认按钮点击的回调时间
     * */
    function show_delete(msg,callback) {
        if(typeof msg === "function"){
            callback = msg;
            msg = null;
        }
        msg = msg || '数据宝贵，确实删除吗？';
        $("#model_delete .error-msg").text(msg);
        $("#model_delete").modal('show');

        $("#model_delete_sure").unbind().click(function(){
            typeof callback === "function" && callback();
        });
    }

    /*
     * 显示成功提示信息
     * @param msg string 错误提示
     * @param callback function 确认按钮点击的回调时间
     * */
    function show_success(msg,callback) {
        if(typeof msg === "function"){
            callback = msg;
            msg = null;
        }
        msg = msg || '操作成功!';
        $("#model_success .error-msg").text(msg);
        $("#model_success").modal('show');

        $("#model_success_sure").unbind().click(function(){
            typeof callback === "function" && callback();
        });
    }
</script>

<div id="wrapper">

    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.html">亚欧大数据交易中心-后台管理系统</a>
        </div>
        <!-- Top Menu Items -->
        <ul class="nav navbar-right top-nav">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle"><i class="fa fa-envelope"></i> <b class="caret"></b></a>
            </li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i
                        class="fa fa-user"></i> <?php echo $this->admin_username; ?> <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li>
                        <a href="login/login.html"><i
                                class="fa fa-fw fa-power-off"></i>退出</a>
                    </li>
                </ul>
            </li>
        </ul>
        <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav side-nav">
                <li>
                    <a href="javascript:;" data-toggle="collapse" data-target="#control_panel"> 控制台 <i
                            class="fa fa-fw fa-caret-down"></i></a>
                    <ul id="control_panel" class="collapse">
                        <li>
                            <a href="control_panel/overview.html">平台概况</a>
                        </li>
                        <li>
                            <a href="control_panel/org_deal.html">机构交易概况</a>
                        </li>
                        <li>
                            <a href="control_panel/platform_deal.html">平台交易概况</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="javascript:;" data-toggle="collapse" data-target="#enterprise"> 机构管理 <i
                            class="fa fa-fw fa-caret-down"></i></a>
                    <ul id="enterprise" class="collapse">
                        <li>
                            <a href="enterprise/org_list.html">机构列表</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="javascript:;" data-toggle="collapse" data-target="#user"> 已开通会员 <i
                            class="fa fa-fw fa-caret-down"></i></a>
                    <ul id="user" class="collapse">
                        <li>
                            <a href="user/user_list.html">会员列表</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="javascript:;" data-toggle="collapse" data-target="#config"> 参数配置 <i
                            class="fa fa-fw fa-caret-down"></i></a>
                    <ul id="config" class="collapse">
                        <li>
                            <a href="config/option_index.html">配置参数</a>
                        </li>
                        <li>
                            <a href="config/dispatch.html">定时调度</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="javascript:;" data-toggle="collapse" data-target="#product"> 产品发布 <i
                            class="fa fa-fw fa-caret-down"></i></a>
                    <ul id="product" class="collapse">
                        <li>
                            <a href="product/data.html">产品发布编辑</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="javascript:;" data-toggle="collapse" data-target="#tools"> 工具 <i
                            class="fa fa-fw fa-caret-down"></i></a>
                    <ul id="tools" class="collapse">
                        <li>
                            <a href="tools/ip_deblock.html">IP解锁</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="javascript:;" data-toggle="collapse" data-target="#account"> 账户 <i
                            class="fa fa-fw fa-caret-down"></i></a>
                    <ul id="account" class="collapse">
                        <li>
                            <a href="account/account_money_record.html">账户流水</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="javascript:;" data-toggle="collapse" data-target="#order_form">订单<i
                            class="fa fa-fw fa-caret-down"></i></a>
                    <ul id="order_form" class="collapse">
                        <li>
                            <a href="order/user_order.html">会员订单</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="javascript:;" data-toggle="collapse" data-target="#news">新闻发布<i
                            class="fa fa-fw fa-caret-down"></i></a>
                    <ul id="news" class="collapse">
                        <li>
                            <a href="news/news_list.html">新闻列表查看</a>
                        </li>
                        <li>
                            <a href="news/news_add.html">新闻发布</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </nav>

    <div id="page-wrapper">

        <div class="container-fluid">


        </div>
        <!-- /.container-fluid -->

    </div>
    <!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->

</body>

<script src="../public/static/admin/js/jquery.js"></script>
<script src="../public/static/admin/js/bootstrap.min.js"></script>
<script src="../public/static/admin/js/common.js"></script>
<script src="../public/static/admin/js/toggle-nav.js"></script>

</html>