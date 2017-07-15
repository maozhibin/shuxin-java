<%--
  Created by IntelliJ IDEA.
  User: yongj
  Date: 7/15/2017
  Time: 2:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>产品列表</title><style>
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
                        <!--  <?php /*foreach ($type_list as $key => $item): */?>
                              <option
                                  value="<?php /*echo $key */?>" <?php /*echo (isset($type) && $key == $type) ? 'selected' : '' */?>><?php /*echo $item */?></option>
                          --><?php /*endforeach; */?>
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
                        <th>产品名称</th>
                        <th>发布者名称</th>
                        <th>被购买次数</th>
                        <th>发布时间</th>
                        <th>状态</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <?php if (!empty($productlist)) {
                        foreach ($productlist as $item) {
                            ?>
                    <tr>
                        <td><?= $item['id'] ?></td>
                        <td><?= $item['name'] ?></td>
                        <td><?= $item['username'] ?></td>
                        <td><?= $item['used']?></td>
                        <td><?= date("Y-m-d H:i:s", $item['dateline']) ?></td>
                        <td><?= $item['status'] ?></td>
                        <td>
                            <a class="" title='查看'
                               href=<?= site_url("admin/news/news_detail/" . $item['id']) ?>><i
                                class="fa fa-eye"></i> </a>&nbsp;&nbsp;
                            <a class="<?= site_url('admin/news/news_add/' . $item['id']); ?>" title='编辑'
                               href=<?= site_url("admin/user/user_detail/" . $item['id']) ?>><i
                                class="fa fa-pencil"></i> </a>&nbsp;&nbsp;
                            <a class="delete_button" title='删除'
                               url=<?= site_url("admin/news/news_delete/" . $item['id']) ?>><i
                                class="fa fa-trash"></i> </a>
                        </td>
                    </tr>
                    <?php } ?>
                    <?php } ?>
                    </tbody>
                </table>
                <div class="col-sm-12" style="text-align: center">
                    <hr>
                    <!-- <span class="float-left" style="    line-height: 40px;"><?/*= '共' . $count . '条，每页' . '5' . '条' */?></span>
                     --><?php /*echo $pages; */?>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
