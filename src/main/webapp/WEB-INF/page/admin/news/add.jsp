

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

     <link href='/static/admin/plugins/simditor/styles/simditor.css?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>' rel="stylesheet" type="text/css"/>
     <link href='/static/admin/css/img-holder.css?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>' rel="stylesheet" type="text/css"/>

    <script src='/static/admin/plugins/simditor/scripts/jquery.min.js?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>'></script>
    <script src='/static/admin/plugins/simditor/scripts/module.js?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>'></script>
    <script src='/static/admin/plugins/simditor/scripts/hotkeys.js?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>'></script>
    <script src='/static/admin/plugins/simditor/scripts/uploader.js?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>'></script>
    <script src='/static/admin/plugins/simditor/scripts/simditor.js?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>'></script>

    <script src='/static/js/jquery.ajaxfileupload.js?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>'></script>
	<script src='/static/admin/js/add.js?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>'></script>

</head>
<body>

    <c:if test="${not empty news.id} ">
    <h3 class="header"><a onclick="javascript:;history.back()">新闻列表</a> — 新闻修改</h3>
    </c:if>
    <c:if test="${empty news.id} ">
        <h3 class="header"><a onclick="javascript:;history.back()">新闻列表</a> — 新闻发布</h3>
    </c:if>
<hr>
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
            </div>
        </div>

        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">新闻头图:</label>

            <div class="col-sm-11">
                <div class='logoBtn' id='imgbtn'>
                    <c:if test="${not empty news.image}">
                        <div class="f-logoshow">
                            <div class="logoShade hide">
                            <i class="closeLogo"></i>
                            </div>
                            <img src=${news.image} alt="" id="logo" height="150" class="showLogo"/>
                        </div>
                    </c:if>
                    <form id="show" class="btn-upload" enctype="multipart/form-data">
                        <input type="file" name="file" id="upLogo" accept="image/png,image/gif,image/jpg,image/jpeg" style='display:inline-block'>
                    </form>
                        (上传图片大小应小于2500px*1500px)
                </div>
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

</body>
</html>
