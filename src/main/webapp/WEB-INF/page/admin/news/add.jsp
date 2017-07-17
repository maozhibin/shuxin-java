

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
            + "/";
%>
<html>
<head>
    <title>新闻发布</title>
    <style>
        select.form-control{
            width:150px;
        }
        input.form-control{
            width:500px;
        }
        .btn{
            width: 90px;
        }
    </style>


    <link href='<%=basePath%>static/admin/plugins/simditor/styles/simditor.css?1.0' rel="stylesheet" type="text/css"/>

    <script src='<%=basePath%>static/admin/plugins/simditor/scripts/jquery.min.js?1.0'></script>
    <script src='<%=basePath%>static/admin/plugins/simditor/scripts/module.js?1.0'></script>
    <script src='<%=basePath%>static/admin/plugins/simditor/scripts/hotkeys.js?1.0'></script>
    <script src='<%=basePath%>static/admin/plugins/simditor/scripts/uploader.js?1.0'></script>
    <script src='<%=basePath%>static/admin/plugins/simditor/scripts/simditor.js?1.0'></script>





    <script type="text/javascript">
        $(document).ready(function () {
            //响应文件添加成功事件

            $("#inputfile").change(function () {
                //创建FormData对象
                var data = new FormData();
                //为FormData对象添加数据
                data.append('imgFile', $('#inputfile')[0].files[0]);
//            data.append('<?php //echo $this->security->get_csrf_token_name();?>//', '<?php //echo $this->security->get_csrf_hash();?>//');

                //发送数据
                $.ajax({
                    url: '<?=site_url("admin/data/upload")?>',
                    type: 'POST',
                    data: data,
                    cache: false,
                    contentType: false,		//不可缺参数
                    processData: false,		//不可缺参数
                    dataType: 'json',
                    success: function (data) {
                        if (data.error == 1) {
                            alert(data.message);
                        }
                        else {
                            console.log(data.url);
                            // alert( JSON.stringify( data.url ) ) ;
                            $('#uf').attr('src', base_url + data.url);
                            $('#uf').show();
                            $('#icon').val(data.url);
                            $('#uf').val(base_url + data.url);
                        }
                    },
                    error: function () {
                        alert('上传失败！');

                    }
                });
            });

            var editor = new Simditor({
                textarea: $('#editor'),
                placeholder: '这里输入内容...',
                toolbar: toolbar,  //工具栏
                defaultImage: 'simditor/images/image.png', //编辑器插入图片时使用的默认图片
                upload: {
                    url: '<?php echo site_url("admin/data/upload")?>', //文件上传的接口地址
                    params: null, //键值对,指定文件上传接口的额外参数,上传的时候随文件一起提交
                    fileKey: 'imgFile', //服务器端获取文件数据的参数名
                    connectionCount: 3,
                    leaveConfirm: '正在上传文件'
                }
            });

        });
    </script>

</head>
<body>
<h3 class="header">
    <a href="<?= site_url('admin/news/news_list'); ?>">新闻列表</a> —
   <!-- <?php echo isset($id) ? '新闻修改' : '新闻发布' ?>-->
</h3>
<hr>
       <!-- <?php echo form_open('admin/news/news_add' . (isset($id) ? '/' . $id : '')); ?>
        <?php echo form_open('admin/data/news_add', array('class' => 'form-inline')); ?> -->
        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">选择类型:</label>
            <div class="col-sm-11">
                <select name="type" class="form-control">

                </select>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">标题:</label>
            <div class="col-sm-11">
                <input class="form-control" name="title"
                       value=""/>

            </div>
        </div>
        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">来源:</label>
            <div class="col-sm-11">
                <input class="form-control" name="source"
                       value=""/>

            </div>
        </div>
        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">作者:</label>
            <div class="col-sm-11">
                <input class="form-control" name="author"
                       value=""/>

            </div>
        </div>
        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">是否置顶:</label>
            <div class="col-sm-11">
                <label><input name="top" type="radio"
                              value="1" />是
                </label>&nbsp;&nbsp;
                <label><input name="top" type="radio"
                              value="0" />否
                </label>&nbsp;&nbsp;

            </div>
        </div>
        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">是否显示发布:</label>
            <div class="col-sm-11">
                <label><input name="is_display" type="radio"
                              value="1"/>是
                </label>&nbsp;&nbsp;
                <label><input name="is_display" type="radio"
                              value="0" />否
                </label>&nbsp;&nbsp;

            </div>
        </div>
        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">网页关键词:</label>
            <div class="col-sm-11">
                <input class="form-control" name="keywords"
                       value="${News.keywords}"/>

            </div>
        </div>
        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">网页关键词:</label>
            <div class="col-sm-11">
                <input class="form-control" name="keywords" value=""/>

            </div>
        </div>
        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">新闻头图:</label>
            <div class="col-sm-11">
                <input class="btn" type="button" id="file" value="上传图片"
                       onclick="getElementById('inputfile').click()"><label class="add_btn_img"></label>
                (上传图片大小应小于2500px*1500px)
                <div></div>
                <input type="file" id="inputfile"
                       style="height:0;width:0;z-index: -1; position: absolute;left: 10px;top: 5px;"><br/>
                <input type="hidden" name="image" id="icon"
                       value=""/>
                <img src="" id="uf" width=188
                     height=96 margin-bottom=20px overflow=hidden;/>

            </div>
        </div>
        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">网页关键词:</label>
            <div class="col-sm-11">
                <input class="form-control" name="keywords" value=""/>

            </div>
        </div>
        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">新闻内容:</label>
            <div class="col-sm-11">
                        <textarea id="editor" name="content" autofocus></textarea>

            </div>
        </div>
        <div class="row">
            <hr>
            <button type="submit" class="btn" id="submit">提交</button>
        </div>
        </form>
</body>
</html>
