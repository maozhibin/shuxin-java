<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>亚欧大数据交易中心-后台管理中心</title>
    <?php load_css('static/admin/css/bootstrap.min.css');?>
    <?php load_css('static/admin/css/sb-admin.css');?>
    <?php load_css('static/admin/font-awesome/css/font-awesome.min.css');?>
    <?php load_css('static/admin/css/baseui.css');?>
    <?php load_css('static/admin/css/AdminLTE.min.css');?>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script>
        var base_url = "<?php echo base_url();?>";
    </script>
    <?php load_js('static/admin/js/jquery.js');?>
    <?php load_js('static/admin/js/bootstrap.min.js');?>
    <?php load_js('static/admin/js/common.js');?>
    <?php load_js('static/js/common/common.js'); ?>
</head>
<body>
    <!-- 错误提示模态框（Modal） -->
    <div class="modal fade" id="model_error" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">

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
                <div class="modal-header">
                    <span>提示</span>
                    <span style="float: right;color: #666">（3s后关闭）</span>
                </div>
                <div class="modal-body" style="height: 150px">

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn" id="model_success_sure" data-dismiss="modal">
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
            $("#model_error .modal-body").text(msg);
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
            $("#model_delete .modal-body").text(msg);
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
            $("#model_success .modal-body").text(msg);
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
                <a href="<?php echo site_url('/admin') ?>"><img src="<?php echo base_url('static/admin/images/logo.png')?>" alt="" width="470" height="40"></a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle"><i class="fa fa-bell"></i> <b class="caret"></b></a>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i
                            class="fa fa-user"></i> <?php echo $this->admin_username; ?> <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="<?php echo base_url('admin/login/login_out') ?>"><i
                                    class="fa fa-fw fa-power-off"></i>退出</a>
                        </li>
                        <li>
                            <a href="<?php echo base_url('admin/login/reset_password') ?>"><i
                                    class="fa fa-fw fa-lock"></i>修改密码</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#control_panel"><i
                                    class="fa fa-fw fa-desktop"></i> 控制台 <i
                                    class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="control_panel" class="collapse">
                            <li>
                                <a href="<?php echo base_url('admin/ControlPanel/index'); ?>">平台概况</a>
                            </li>
                            <li>
                                <a href="<?php echo base_url('admin/ControlPanel/org_deal'); ?>">机构交易概况</a>
                            </li>
                            <li>
                                <a href="<?php echo base_url('admin/ControlPanel/platform_deal'); ?>">平台交易概况</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#enterprise"><i class="fa fa-university"></i>  机构管理 <i
                                class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="enterprise" class="collapse">
                            <li>
                                <a href="<?php echo base_url('admin/user/org_list'); ?>">机构列表</a>
                            </li>
                        </ul>
                    </li>
                   <!-- <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#buy_require"> 数据买方需求 <i
                                class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="buy_require" class="collapse">
                            <li>
                                <a href="<?php /*echo base_url('admin/data_buy_require/buy_require'); */?>">买方需求列表</a>
                            </li>
                        </ul>
                    </li>-->
                   <!-- <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#data_sale_need"> 数据卖方需求 <i
                                class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="data_sale_need" class="collapse">
                            <li>
                                <a href="<?php /*echo base_url('admin/recharge'); */?>">卖方需求列表</a>
                            </li>
                        </ul>
                    </li>-->
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#member"><i class="fa fa-fw  fa-id-card-o"></i> 已开通会员 <i
                                class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="member" class="collapse">
                            <li>
                                <a href="<?php echo base_url('admin/user/user_list'); ?>">会员列表</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#config"><i
                                    class="fa fa-fw fa-cogs"></i> 参数配置 <i
                                class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="config" class="collapse">
                            <li>
                                <a href="<?php echo base_url('admin/option/option_index'); ?>">配置参数</a>
                            </li>
<!--                            <li>-->
<!--                                <a href="--><?php //echo base_url('admin/recharge'); ?><!--">定时调度</a>-->
<!--                            </li>-->
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#product"><i class="fa fa-fw fa-database"></i> 产品发布 <i
                                class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="product" class="collapse">
                            <li>
                                <a href="<?php echo base_url('admin/data'); ?>">产品发布编辑</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#tools"><i class="fa fa-fw fa-wrench"></i> 工具 <i
                                class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="tools" class="collapse">
                            <li>
                                <a href="<?php echo base_url('admin/tools/ip_index'); ?>">IP解锁</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#account"><i class="fa fa-fw fa-google-wallet"></i> 账户 <i
                                class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="account" class="collapse">
                            <li>
                                <a href="<?php echo base_url('admin/account/account_money_record'); ?>">账户流水</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#order_form"><i class="fa fa-fw fa-indent"></i> 订单<i
                                class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="order_form" class="collapse">
                            <li>
                                <a href="<?php echo base_url('admin/order/user_order'); ?>">会员订单</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#news"><i class="fa fa-fw fa-file-text-o"></i> 新闻发布<i
                                class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="news" class="collapse">
                            <li>
                                <a href="<?php echo base_url('admin/news/news_list'); ?>">新闻列表查看</a>
                            </li>
                            <li>
                                <a href="<?php echo base_url('admin/news/news_add'); ?>">新闻发布</a>
                            </li>
                        </ul>
                    </li>
            </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>

        <div id="page-wrapper">
            <div class="container-fluid">
                <?php echo $content;?>
            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
        
    <script type="text/javascript">

        $(function () {
            $('.delete_button').click(function () {
                var url = $(this).attr('url');
                delete_confirm('delete_button', url);
            });
        });


        var nav_parent_index = <?php echo isset($index_p) ? $index_p : 0;?>;
        console.log(nav_parent_index);
        var nav_child_index = <?php echo isset($index_c) ? $index_c : 0;?>;
        console.log(nav_child_index);
        var nav_active = $(".side-nav > li")[nav_parent_index];
        $(nav_active).addClass("active");
        $(nav_active).find('ul').addClass("in");
        $($(nav_active).find('li')[nav_child_index]).addClass("nav_active");
    </script>
</body>

</html>


