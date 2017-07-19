<%--
  Created by IntelliJ IDEA.
  User: yongj
  Date: 7/17/2017
  Time: 2:51 PM
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
    <title>产品描述</title>

    <link href='<%=basePath%>static/css/style.css?1.0' rel="stylesheet" type="text/css"/>
    <link href='<%=basePath%>static/css/market.css?1.0' rel="stylesheet" type="text/css"/>
    <link href='<%=basePath%>static/plugins/simditor/styles/simditor.css?1.0' rel="stylesheet" type="text/css"/>

    <link href='<%=basePath%>static/admin/css/data-release.css?1.0' rel="stylesheet" type="text/css"/>

    <script src='<%=basePath%>static/plugins/simditor/scripts/module.js?1.0'></script>
    <script src='<%=basePath%>static/plugins/simditor/scripts/uploader.js?1.0'></script>
    <script src='<%=basePath%>static/plugins/simditor/scripts/hotkeys.js?1.0'></script>
    <script src='<%=basePath%>static/plugins/simditor/scripts/simditor.js?1.0'></script>

    <script>
        $(function () {
            var $preview, editor_intro, editor_highlight,
                editor_snapshot, editor_service, toolbar;
            var defaultImages = "<%=basePath%>static/plugins/simditor/images/image.png";
            Simditor.locale = 'en-US';
            toolbar = ['title', 'bold', 'italic', 'underline', 'strikethrough', 'fontScale', 'color', '|', 'ol', 'ul', 'blockquote', 'code', 'table', '|', 'link', 'image', 'hr', '|', 'indent', 'outdent', 'alignment'];
            editor_intro = new Simditor({
                textarea: $('#intro'),
                placeholder: '这里输入文字...',
                toolbar: toolbar,
                pasteImage: true,
                defaultImage: defaultImages,
                upload: location.search === '?upload' ? {
                        url: '/upload'
                    } : false
            });

            editor_highlight = new Simditor({
                textarea: $('#highlight'),
                placeholder: '这里输入文字...',
                toolbar: toolbar,
                pasteImage: true,
                defaultImage: defaultImages,
                upload: location.search === '?upload' ? {
                        url: '/upload'
                    } : false
            });

            editor_snapshot = new Simditor({
                textarea: $('#snapshot'),
                placeholder: '这里输入文字...',
                toolbar: toolbar,
                pasteImage: true,
                defaultImage: defaultImages,
                upload: location.search === '?upload' ? {
                        url: '/upload'
                    } : false
            });

            editor_service = new Simditor({
                textarea: $('#service'),
                placeholder: '这里输入文字...',
                toolbar: toolbar,
                pasteImage: true,
                defaultImage: defaultImages,
                upload: location.search === '?upload' ? {
                        url: '/upload'
                    } : false
            });

//        $preview = $('#preview');
//        if ($preview.length > 0) {
//            return editor_intro.on('valuechanged', function(e) {
//                return $preview.html(editor_intro.getValue());
//            });
//        }
        });
    </script>
    <style>
        #preview {
            min-height: 100px;
            padding: 15px;
            margin: 60px 0 0 0;
            border: 1px solid #dfdfdf;
        }
    </style>
</head>
<body>

<div class="release-tabs">
    <div class="tabs">
        <a href="<%=basePath%>admin/product/issue" class="tab">基础设置</a>
        <a href="<%=basePath%>admin/product/inter" class="tab">接口设置</a>
        <a href="<%=basePath%>admin/product/description" class="tab active">产品描述</a>
        <a href="<%=basePath%>admin/product/fee" class="tab">计费设置</a>
    </div>
    <form action="<%=basePath%>admin/product/description/${product_id}">
        <div class="container desc">
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
                <input class="btn btn-red" type="submit" value="下一步">
            </div>
        </div>
    </form>
</div>
</body>
</html>
