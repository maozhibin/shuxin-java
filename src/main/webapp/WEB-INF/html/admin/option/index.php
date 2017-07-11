<a class="btn" style="float:left;margin-bottom: 20px" href="<?= site_url('admin/option/option_add') ?>"><!--<i
        class="fa fa-plus"></i> -->添加选项参数</a>

<div class="row">
    <div class="col-md-12">
        <div class="box-primary">
            <div class="box-body">
<!--                <div style="margin-bottom: 8px">--><?//= '总计' . $count . '条' ?><!--</div>-->
                <table id="example2" class="table table-striped table-hover" style="table-layout:fixed">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th style="width:10%">配置名称</th>
                        <th>配置值</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <?php if (!empty($list)) { ?>
                        <?php $id = 1; ?>
                        <?php foreach ($list as $key => $option) { ?>
                            <tr>
                                <td style="width:30px;"><?= $id++ ?></td>
                                <td style="width:150px; word-wrap: break-word; word-break: normal;  "><?= $option['varname'] ?></td>
                                <td style="width:350px; word-wrap: break-word; word-break: normal;  "><?= $option['value'] ?></td>
                                <td>
                                    <a class="" title='编辑'
                                       href=<?= site_url("admin/option/option_edit/" . $option['id']) ?>><i
                                                class="fa fa-pencil"></i> </a>&nbsp;&nbsp;
<!--                                    <a class="delete_button" title='删除'-->
<!--                                       href=--><?//= site_url("admin/option/option_delete/" . $option['id']) ?><!--><i-->
<!--                                                class="fa fa-trash"></i> </a>-->
                                </td>
                            </tr>
                        <?php } ?>
                    <?php } ?>

                    </tbody>
                </table>
                <div class="col-sm-12" style="text-align: right">
                    <span class="float-left" style="    line-height: 40px;"><?= '共' . $count . '条，每页5条' ?></span>
                    <?php /*echo $pages; */?>
                </div>
            </div>
        </div>
    </div>
</div>


