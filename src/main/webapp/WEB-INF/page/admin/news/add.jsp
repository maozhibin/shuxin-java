

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







</head>
<body>

    <c:if test="${not empty news.id} ">
    <h3 class="header"><a onclick="javascript:;history.back()">新闻列表</a> — 新闻修改</h3>
    </c:if>
    <c:if test="${empty news.id} ">
        <h3 class="header"><a onclick="javascript:;history.back()">新闻列表</a> — 新闻发布</h3>
    </c:if>
<hr>
    <form action="updateAndAdd" id="formid">

        <input type="hidden" id="typeValue" value="${news.id}" name="id"/>



        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">选择类型:</label>
            <div class="col-sm-11">

                <select name="newsClassType" class="form-control" id="newsClassType">
                    <option selected value="">请选择类型</option>
                    <c:forEach items="${options}" var="option">
                            <option value="${option.value}">${option.name}

                        </option>
                    </c:forEach>
                </select>
                &nbsp;&nbsp;&nbsp;&nbsp;<span class="label label-warning" id= "newsClassTypeSpan"></span>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">标题:</label>
            <div class="col-sm-11">
                <c:if test="${not empty news.title}">
                    <input name="title" value="${news.title}"
                           class="col-xs-10 col-sm-5" placeholder="" id="title"/>
                </c:if>
                <c:if test="${empty news.title}">
                    <input name="title" value=""
                           class="col-xs-10 col-sm-5" placeholder="" id="title"/>
                </c:if>
                &nbsp;&nbsp;&nbsp;&nbsp;<span class="label label-warning" id= "titleSpan"></span>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">来源:</label>
            <div class="col-sm-11">
                <c:if test="${not empty news.source}">
                    <input name="source" value="${news.source}"
                           class="col-xs-10 col-sm-5" placeholder="" id="source"/>
                </c:if>
                <c:if test="${empty news.source}">
                    <input name="source" value=""
                           class="col-xs-10 col-sm-5" placeholder="" id="source"/>
                </c:if>
                &nbsp;&nbsp;&nbsp;&nbsp;<span class="label label-warning" id= "sourceSpan"></span>

            </div>
        </div>
        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">作者:</label>
            <div class="col-sm-11">
                <c:if test="${not empty news.author}">
                    <input name="author" value="${news.author}"
                           class="col-xs-10 col-sm-5" placeholder="" id="author"/>
                </c:if>
                <c:if test="${empty news.author}">
                    <input name="author" value=""
                           class="col-xs-10 col-sm-5" placeholder="" id="author"/>
                </c:if>
                &nbsp;&nbsp;&nbsp;&nbsp;<span class="label label-warning" id= "authorSpan"></span>

            </div>
        </div>
        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">是否置顶:</label>
            <div class="col-sm-11">
                <label><input name="top" type="radio" id="top"
                              value="1" />是
                </label>&nbsp;&nbsp;
                <label><input name="top" type="radio"
                              value="0" id="" checked="true"/>否
                </label>&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;<span class="label label-warning" id= "topSpan"></span>

            </div>
        </div>
        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">是否显示发布:</label>
            <div class="col-sm-11">
                <label><input name="isDisplay" type="radio"
                              value="1" checked="true"/>是
                </label>&nbsp;&nbsp;
                <label><input name="isDisplay" type="radio"
                              value="0" />否
                </label>&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;<span class="label label-warning" id= "isDisplaySpan"></span>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">网页关键词:</label>
            <div class="col-sm-11">
                <c:if test="${not empty news.keywords}">
                    <input name="keywords" value="${news.author}"
                           class="col-xs-10 col-sm-5" placeholder="" id="keywords"/>
                </c:if>
                <c:if test="${empty news.keywords}">
                    <input name="keywords" value=""
                           class="col-xs-10 col-sm-5" placeholder="" id="keywords"/>
                </c:if>
                &nbsp;&nbsp;&nbsp;&nbsp;<span class="label label-warning" id= "keywordsSpan"></span>

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
            <label class="col-sm-1 control-label no-padding-right">新闻内容:</label>
            <div class="col-sm-11">
                <c:if test="${not empty news.id}">
			              	 	 <textarea name="content"  style="height: 200px"
                                           class="col-xs-10 col-sm-5"
                                           placeholder=""  id="content">${news.content}</textarea>
                </c:if>
                <c:if test="${empty news.id}">
			              	 	 <textarea name="content" style="height: 200px"
                                           class="col-xs-10 col-sm-5"
                                           placeholder="" id="content"></textarea>
                </c:if>

            </div>
        </div>
        <div class="row">
            <hr>
            <button type="button" class="btn"  onclick="mysumit()">提交</button>
        </div>
        </form>


<script type="text/javascript">


    function mysumit() {
        document.getElementById("newsClassTypeSpan").innerText = "";
        document.getElementById("titleSpan").innerText = "";
        document.getElementById("sourceSpan").innerText = "";
        document.getElementById("authorSpan").innerText = "";
        document.getElementById("topSpan").innerText = "";
        document.getElementById("isDisplaySpan").innerText = "";
        document.getElementById("keywordsSpan").innerText = "";


        var newsClassType=$("#newsClassType").val()
        var title=$("#title").val()
        var source=$("#source").val()
        var author=$("#author").val()
        var top=$("#top").val()
        var isDisplay=$("#isDisplay").val()
        var keywords=$("#keywords").val()


        if(newsClassType.length<=0){//当上面获取的值为空时
            document.getElementById("newsClassTypeSpan").innerText = "亲，请选择类型！";
            return false;//返回false（不提交表单）
        }
        if(title.length<=0){
            document.getElementById("titleSpan").innerText = "亲，请填写标题哦！";
            return false;
        }
        if(source.length<=0){
            document.getElementById("sourceSpan").innerText = "亲，请填写来源！";
            return false;
        }
        if(author.length<=0){
            document.getElementById("authorSpan").innerText = "亲，请填写作者名称哦！";
            return false;
        }
        if(keywords.length<=0){
            document.getElementById("keywordsSpan").innerText = "亲，请填写网页关键词哦！";
            return false;
        }


        document.getElementById("formid").submit();
    }


    $(document).ready(function () {
        //响应文件添加成功事件

//        $("#inputfile").change(function () {
//            //创建FormData对象
//            var data = new FormData();
//            //为FormData对象添加数据
//            data.append('imgFile', $('#inputfile')[0].files[0]);
//
////            data.append('<?php //echo $this->security->get_csrf_token_name();?>//', '<?php //echo $this->security->get_csrf_hash();?>//');
//
//            //发送数据
//            $.ajax({
//                url: "admin/data/upload",
//                type: 'POST',
//                data: data,
//                cache: false,
//                contentType: false,		//不可缺参数
//                processData: false,		//不可缺参数
//                dataType: 'json',
//                success: function (data) {
//                    if (data.error == 1) {
//                        alert(data.message);
//                    }
//                    else {
//                        console.log(data.url);
//                        // alert( JSON.stringify( data.url ) ) ;
//                        $('#uf').attr('src', base_url + data.url);
//                        $('#uf').show();
//                        $('#icon').val(data.url);
//                        $('#uf').val(base_url + data.url);
//                    }
//                },
//                error: function () {
//                    alert('上传失败！');
//
//                }
//            });
//        });






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
</body>
</html>
