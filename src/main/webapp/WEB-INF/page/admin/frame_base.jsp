<%@ page import="org.apache.commons.lang3.StringUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link href='/static/admin/css/bootstrap.min.css?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>' rel="stylesheet"
          type="text/css"/>
    <link href='/static/admin/css/sb-admin.css?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>' rel="stylesheet" type="text/css"/>
    <link href='/static/admin/font-awesome/css/font-awesome.min.css?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>' rel="stylesheet"
          type="text/css"/>
    <link href='/static/admin/css/baseui.css?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>' rel="stylesheet" type="text/css"/>
    <link href='/static/admin/css/AdminLTE.min.css?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>' rel="stylesheet" type="text/css"/>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script>
        var base_url = "/";
        var requestUri = '${requestScope['javax.servlet.forward.request_uri']}';
        var reg = /(\/\w+)+/g;
        var arr = reg.exec(requestUri);
        if (arr != null && arr.length > 0) {
            requestUri = arr[0];
        }
    </script>
    <script src='/static/admin/js/jquery.js?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>'></script>
    <script src='/static/admin/js/bootstrap.min.js?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>'></script>
    <script src='/static/admin/js/common.js?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>'></script>
    <script src='/static/js/common/common.js?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>'></script>
    <sitemesh:write property='head'/>
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
    function show_delete(msg, callback) {
        if (typeof msg === "function") {
            callback = msg;
            msg = null;
        }
        msg = msg || '数据宝贵，确实删除吗？';
        $("#model_delete .modal-body").text(msg);
        $("#model_delete").modal('show');

        $("#model_delete_sure").unbind().click(function () {
            typeof callback === "function" && callback();
        });
    }

    /*
     * 显示成功提示信息
     * @param msg string 错误提示
     * @param callback function 确认按钮点击的回调时间
     * */
    function show_success(msg, callback) {
        if (typeof msg === "function") {
            callback = msg;
            msg = null;
        }
        msg = msg || '操作成功!';
        $("#model_success .modal-body").text(msg);
        $("#model_success").modal('show');

        $("#model_success_sure").unbind().click(function () {
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
            <a href="/admin"><img src="/static/admin/images/logo.png"
                                              alt="" width="302" height="38"></a>
        </div>
        <!-- Top Menu Items -->
        <ul class="nav navbar-right top-nav">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle"><i class="fa fa-bell"></i> <b class="caret"></b></a>
            </li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i
                        class="fa fa-user"></i> ${admin_username} <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li>
                        <a href="/admin/logout"><i
                                class="fa fa-fw fa-power-off"></i>退出</a>
                    </li>
                    <li>
                        <a href="/admin/password"><i
                                class="fa fa-fw fa-lock"></i>修改密码</a>
                    </li>
                </ul>
            </li>
        </ul>
        <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav side-nav">
                <c:if test="${userMenu != null}">
                    <c:forEach items="${userMenu.values()}" var="menu">
                        <%@include file="menu_recursive.jsp" %>
                    </c:forEach>
                </c:if>
                <li><br/></li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </nav>

    <div id="page-wrapper">
        <div class="container-fluid">
            <sitemesh:write property='body'/>
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

</script>
<script type="text/javascript">
    var d = $("ul[href]");
    for (i = 0; i < d.length; i++) {
        if (requestUri.startsWith($(d[i]).attr("href"))) {
            $(d[i]).addClass("in").parent("li").addClass("active");
            $(d[i]).find("a[href='"+window.location.href+"']").parent("li").addClass("nav_active");
        }
    }
</script>
</body>
</html>
