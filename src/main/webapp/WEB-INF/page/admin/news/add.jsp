

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

    <script src='<%=basePath%>static/js/jquery.ajaxfileupload.js?1.0'></script>


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
                    <c:forEach items="${hashedMap.options}" var="options">
                            <option value="${options.value}"<c:if test="${hashedMap.news.newsClassType==options.value}">selected="selected"</c:if>>${options.name}
                        </option>
                    </c:forEach>
                </select>
                &nbsp;&nbsp;&nbsp;&nbsp;<span class="label label-warning" id= "newsClassTypeSpan"></span>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">标题:</label>
            <div class="col-sm-11">
                <c:if test="${not empty hashedMap.news.title}">
                    <input name="title" value="${hashedMap.news.title}"
                           class="col-xs-10 col-sm-5" placeholder="" id="title"/>
                </c:if>
                <c:if test="${empty hashedMap.news.title}">
                    <input name="title" value=""
                           class="col-xs-10 col-sm-5" placeholder="" id="title"/>
                </c:if>
                &nbsp;&nbsp;&nbsp;&nbsp;<span class="label label-warning" id= "titleSpan"></span>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">来源:</label>
            <div class="col-sm-11">
                <c:if test="${not empty hashedMap.news.source}">
                    <input name="source" value="${hashedMap.news.source}"
                           class="col-xs-10 col-sm-5" placeholder="" id="source"/>
                </c:if>
                <c:if test="${empty hashedMap.news.source}">
                    <input name="source" value=""
                           class="col-xs-10 col-sm-5" placeholder="" id="source"/>
                </c:if>
                &nbsp;&nbsp;&nbsp;&nbsp;<span class="label label-warning" id= "sourceSpan"></span>

            </div>
        </div>
        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">作者:</label>
            <div class="col-sm-11">
                <c:if test="${not empty hashedMap.news.author}">
                    <input name="author" value="${hashedMap.news.author}"
                           class="col-xs-10 col-sm-5" placeholder="" id="author"/>
                </c:if>
                <c:if test="${empty hashedMap.news.author}">
                    <input name="author" value=""
                           class="col-xs-10 col-sm-5" placeholder="" id="author"/>
                </c:if>
                &nbsp;&nbsp;&nbsp;&nbsp;<span class="label label-warning" id= "authorSpan"></span>

            </div>
        </div>
        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">是否置顶:</label>
            <div class="col-sm-11">
                <c:if test="${not empty hashedMap.news.top}">
                    <label><input name="top" type="radio" id="top"
                                  value="1" <c:if test="${hashedMap.news.top ==1 }">checked="true"</c:if> />是
                    </label>&nbsp;&nbsp;
                    <label><input name="top" type="radio"
                                  value="0" id="" <c:if test="${hashedMap.news.top ==0 }">checked="true"</c:if> />否
                    </label>&nbsp;&nbsp;
                </c:if>
                <c:if test="${empty hashedMap.news.top}">
                    <label><input name="top" type="radio" id="top"
                                  value="1" />是
                    </label>&nbsp;&nbsp;
                    <label><input name="top" type="radio"
                                  value="0" id=""  checked="true" />否
                    </label>&nbsp;&nbsp;
                </c:if>
                &nbsp;&nbsp;&nbsp;&nbsp;<span class="label label-warning" id= "topSpan"></span>

            </div>
        </div>
        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">是否显示发布:</label>
            <div class="col-sm-11">
                <c:if test="${not empty hashedMap.news.isDisplay}" >
                    <label><input name="isDisplay" type="radio"
                                  value="1" <c:if test="${hashedMap.news.isDisplay ==1 }">checked="true"</c:if>/>是
                    </label>&nbsp;&nbsp;
                    <label><input name="isDisplay" type="radio"
                                  value="0"  <c:if test="${hashedMap.news.isDisplay ==0 }">checked="true"</c:if>/>否
                    </label>&nbsp;&nbsp;
                </c:if>
                <c:if test="${ empty hashedMap.news.isDisplay}">
                    <label><input name="isDisplay" type="radio"
                                  value="1" checked="true"/>是
                    </label>&nbsp;&nbsp;
                    <label><input name="isDisplay" type="radio"
                                  value="0" />否
                    </label>&nbsp;&nbsp;
                </c:if>

                &nbsp;&nbsp;&nbsp;&nbsp;<span class="label label-warning" id= "isDisplaySpan"></span>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">网页关键词:</label>
            <div class="col-sm-11">
                <c:if test="${not empty hashedMap.news.keywords}">
                    <input name="keywords" value="${hashedMap.news.author}"
                           class="col-xs-10 col-sm-5" placeholder="" id="keywords"/>
                </c:if>
                <c:if test="${empty hashedMap.news.keywords}">
                    <input name="keywords" value=""
                           class="col-xs-10 col-sm-5" placeholder="" id="keywords"/>
                </c:if>
                &nbsp;&nbsp;&nbsp;&nbsp;<span class="label label-warning" id= "keywordsSpan"></span>

            </div>
        </div>

        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">新闻头图:</label>
            <div class="col-sm-11">
                <label for="upload" class="btn">上传图片</label>
                (上传图片大小应小于2500px*1500px)
                <div></div>
                <input type="file" id="upload" name="file"
                       style="height:0;width:0;z-index: -1; position: absolute;left: 10px;top: 5px;"><br/>
                <input type="hidden" name="image" id="logo" value=""/>
                <img src="" id="img" width=188 height=96 margin-bottom=20px overflow=hidden;/>

            </div>
        </div>
        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">新闻内容:</label>
            <div class="col-sm-11">
                <c:if test="${not empty hashedMap.news.id}">
			              	 	 <textarea name="content"  style="height: 200px"
                                           class="col-xs-10 col-sm-5"
                                           placeholder=""  id="content">${hashedMap.news.content}</textarea>
                </c:if>
                <c:if test="${empty hashedMap.news.id}">
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
        <!--文件上传-->
        $("#upload").AjaxFileUpload({
            action: '<%=basePath%>admin/upload/logo',
            onComplete: function (filename, response) {
                if (response.error != null) {
                    alert(response.error + "请重新选择");
                } else {
                    var url = base_url + response.imgUrl;
                    $("#logo").val(url);
                    $(this).parents(".cell").addClass('hide');
                    $("#close").removeClass('hide');
                    $("#img").removeClass('hide').attr("src", url).attr('alt', filename);
                }
            }
        });
        $("#img").click(function () {
            $("#upload").trigger("click");
        });
        $("#close").click(function () {
            $(this).addClass('hide').prevAll('img').removeAttr('src alt').addClass('hide').prevAll('.cell').removeClass('hide');
        });

    });
</script>
</body>
</html>
