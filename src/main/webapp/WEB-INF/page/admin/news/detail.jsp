
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>新闻详情</title>
    <style>
        th, td {
            padding-top: 10px;
            padding-right: 10px;
        }

        .box span {
            background-color: #e0e0e0;
            padding: 10px;
        }
    </style>
</head>
<body>
    <h2 class="header"><a onclick="javascript:;history.back()">新闻列表查看</a> — 列表详情</h2>

<hr>
<section>
    <h4 class="header"><span class="text-left">新闻详情</span></h4>

    <div class="row">
        <label class="col-md-2 text-overflow">ID：</label>
        <div class="col-md-10">${news.id}</div>
    </div>
    <div class="row">
        <label class="col-md-2 text-overflow">类别：</label>
        <div class="col-md-10">
        	<c:if test="${news.newsClassType==1}">
                     	 平台公告
            </c:if>
            <c:if test="${news.newsClassType==2}">
                    	媒体公告
            </c:if>
            <c:if test="${news.newsClassType==3}">
                     	产品动态
            </c:if>
      </div>
    </div>
    <div class="row">
        <label class="col-md-2 text-overflow">标题：</label>
        <div class="col-md-10">${news.title}</div>
    </div>
    <div class="row">
        <label class="col-md-2 text-overflow">时间：</label>

        <div class="col-md-10">
            <jsp:useBean id="dateValue" class="java.util.Date"/>
            <jsp:setProperty name="dateValue" property="time" value="${news.dateline*1000}"/>
            <fmt:formatDate value="${dateValue}" pattern="yyyy-MM-dd hh:ss:mm"/>
        </div>
    </div>
    <div class="row">
        <label class="col-md-2 text-overflow">来源：</label>
        <div class="col-md-10">${news.source}</div>
    </div>
    <div class="row">
        <label class="col-md-2 text-overflow">作者：</label>
        <div class="col-md-10">${news.author}</div>
    </div>
    <div class="row">
        <label class="col-md-2 text-overflow">浏览次数：</label>
        <div class="col-md-10">${news.viewCount}</div>
    </div>
    <div class="row">
        <label class="col-md-2 text-overflow">关键字：</label>
        <div class="col-md-10">${news.keywords}</div>
    </div>
    <div class="row">
        <label class="col-md-2 text-overflow">网页描述：</label>
        <div class="col-md-10">${news.description}</div>
    </div>
    <div class="row">
        <label class="col-md-2 text-overflow">是否展示：</label>
        <div class="col-md-10">${news.isDisplay ==1 ? '是':'否'}</div>
    </div>
    <div class="row">
        <label class="col-md-2 text-overflow">是否置顶：</label>
        <div class="col-md-10">${news.top == 1 ? '是':'否'}</div>
    </div>
    <div class="row">
        <label class="col-md-2 text-overflow">新闻头图：</label>
        <div class="f-logoshow">
        	<div class="logoShade hide">
        		<i class="closeLogo"></i>
        	</div><img src=${news.image} alt="" id="logo" height="150" class="showLogo"/></div>
    </div>
    <div class="row">
        <label class="col-md-2 text-overflow">内容：</label>
        <div class="col-md-10">${news.content}</div>
    </div>
</section>

</body>
</html>
