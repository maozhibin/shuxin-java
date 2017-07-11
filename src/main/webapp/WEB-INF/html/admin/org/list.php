<style>
    td {
        padding: 10px;
    }
</style>
<h3 class="header">机构列表</h3>
<section>
    <div class="row">
        <?= form_open('admin/user/org_list', 'class=form-inline') ?>
        <table style="margin-left: 30px">
            <tr>
                <td> 客户名称：</td>
                <td>
                    <input class="form-control" type="text" name="user_name"
                           value="<?= isset($name) ? $name : ''; ?>"/>
                </td>
                <td> 电话号码：</td>
                <td>
                    <input class="form-control" type="text" name="user_mobile"
                           value="<?= isset($mobile) ? $mobile : ''; ?>"/>
                </td>
                <td>
                    <button type="submit" class="btn"><i class="fa fa-search"></i> 搜索</button>
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
               <!-- <div style="margin-bottom: 8px"><?/*= '总计' . $count . '条' */?></div>-->
                <table id="example2" class="table table-striped table-hover" style="table-layout:fixed">
                    <thead>
                    <tr>
                        <th>用户ID</th>
                        <th>手机号</th>
                        <th>姓名</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <?php if (!empty($org)) {
                        foreach ($org as $item) {
                            ?>
                            <tr>
                                <td><?= $item['id'] ?></td>
                                <td><?= $item['mobile'] ?></td>
                                <td><?= $item['username'] ?></td>
                                <td>
                                    <a class="" title='查看'
                                       href=<?= site_url("admin/user/user_detail/" . $item['id']) ?>><i
                                            class="fa fa-eye"></i> </a>&nbsp;&nbsp;
                                   <!-- <a class="" title='编辑'
                                                                                      href=<?/*= site_url("admin/user/edit_user/" . $item['id']) */?>><i
                                                class="fa fa-pencil"></i> </a>&nbsp;&nbsp;-->
                                    <a class="delete_button" title='删除'
                                       url=<?= site_url("admin/user/user_delete/" . $item['id'].'/'.'org_list') ?>><i
                                            class="fa fa-trash"></i> </a>
                                </td>
                            </tr>
                        <?php } ?>
                    <?php } ?>

                    </tbody>
                </table>
                <div class="col-sm-12" style="text-align: center">
                    <hr>
                    <span class="float-left" style="    line-height: 40px;"><?= '共' . $count . '条，每页' . '15' . '条' ?></span>
                    <?php echo $pages; ?>
                </div>
            </div>
        </div>
    </div>
</div>