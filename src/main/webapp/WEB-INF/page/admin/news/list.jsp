
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>新闻查看</title>
    <style>
        td {
            padding: 10px;
        }
    </style>
</head>
<body>

<section class="filter-box" style="border:none">
    <div class="row">
        <?= form_open('admin/news/news_list', 'class=form-inline') ?>
        <table style="margin-left: 30px">
            <tr>
                <td> 类型：</td>
                <td>
                    <select name="type" class="form-control">
                        <?php foreach ($type_list as $key => $item): ?>
                        <option
                                value="<?php echo $key ?>" <?php echo (isset($type) && $key == $type) ? 'selected' : '' ?>><?php echo $item ?></option>
                        <?php endforeach; ?>
                    </select>
                </td>
                <td>
                    <button type="submit" class="btn"><i class="fa fa-search"></i> 搜索</button>
                    <!--                    <a class="btn btn-primary" href="--><?php //echo site_url("admin/news/news_add") ?><!--"><i-->
                    <!--                            class="fa fa-plus"></i> 新闻发布</a>-->
                </td>
            </tr>
        </table>
        <?= form_close() ?>

    </div>
</section>
<div class="row" style="margin-top: 20px">
    <div class="col-md-12">
        <div class="box-primary">
            <div class="box-body">
                <!--                <div style="margin-bottom: 8px">--><?//= '总计' . $count . '条' ?><!--</div>-->
                <table id="example2" class="table table-striped table-hover" style="table-layout:fixed">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>类别</th>
                        <th>标题</th>
                        <th>发布日期</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${page != null && page.result != null}">
                        <c:forEach items="${page.result}" var="news">
                            <tr>
                                <td>${News.id}</td>
                                <td>${News.newsClassType}</td>
                                <td>${News.title}</td>
                                <td>${News.dateline}</td>
                                <td>
                                    <a class="" title='查看'
                                       href="detail?id=${News.id}"><i
                                            class="fa fa-eye"></i> </a>&nbsp;&nbsp;
                                      <a class="" title='编辑'
                                       href="news/detail/"><i
                                            class="fa fa-pencil"></i> </a>&nbsp;&nbsp;
                                    <a class="delete_button" title='删除' url="delete?id=${News.id}"><i
                                            class="fa fa-trash"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    </tbody>
                </table>
                <div class="col-sm-12" style="text-align: center">
                    <hr>
                    <span class="float-left" style="line-height: 40px;">共${page.totalRecordCount}条，每页15条</span>

                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
