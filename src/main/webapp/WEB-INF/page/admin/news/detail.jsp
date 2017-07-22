
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
        <label class="col-md-2 text-overflow">序号：</label>
        <div class="col-md-10">${news.id}</div>
    </div>
    <div class="row">
        <label class="col-md-2 text-overflow">类别：</label>
        <div class="col-md-10">${news.newsClassType}</div>
    </div>
    <div class="row">
        <label class="col-md-2 text-overflow">标题：</label>
        <div class="col-md-10">${news.title}</div>
    </div>
    <div class="row">
        <label class="col-md-2 text-overflow">时间：</label>

        <div class="col-md-10"><fmt:formatDate value="${news.dateline}" pattern="yyyy-MM-dd hh:ss:mm"/></div>
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
        <div class="col-md-10"><img src="${news.image}"></div>
    </div>
    <div class="row">
        <label class="col-md-2 text-overflow">内容：</label>
        <div class="col-md-10">${news.content}</div>
    </div>
</section>

</body>
</html>
