<script type="text/javascript">
    $().ready(function () {
        $('.datepicker').datepicker({
            language: 'cn',
            todayHighlight: true
        });
    });
</script>
<?php
load_js("static/admin/plugins/datepicker/bootstrap-datepicker.js");
load_css("static/admin/plugins/datepicker/datepicker3.css");
?>

<style>
    td {
        padding: 10px;
    }
    .row{
        font-size:14px;
        color:#999;
        letter-spacing:0;
        text-align:left;
        margin:5px 8px;
    }
</style>
<h3 class="header">资金变动记录</h3>
<!--<div class="btn-group" role="group">
<a href="<?/*= site_url('admin/user/user_detail/' . $user_id) */?>" type="button" class="btn btn-success"><i
            class="fa fa-reply"></i> 返回</a>
</div>-->
<section class="col-md-12">
    <div class="row">
        <?= form_open('admin/user/user_money/' . $user_id, 'class=form-inline') ?>
        <table>
            <tr>
                <td> 资金类型：</td>
                <td>
                    <select name="type">
                        <option value="">全部</option>
                    </select>
                </td>
                <td> 起始时间：</td>
                <td>
                    <input class="form-control datepicker" data-date-format="yyyy-mm-dd" type="text" name="start_time"
                           value="<?= isset($start_time) ? $start_time : ''; ?>"/>
                </td>
                <td> -</td>
                <td>
                    <input class="form-control datepicker" data-date-format="yyyy-mm-dd" type="text" name="end_time"
                           value="<?= isset($end_time) ? $end_time : ''; ?>"/>
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
<!--                <div style="margin-bottom: 8px">--><?//= '总计' . $count . '条' ?><!--</div>-->
                <table id="example2" class="table table-striped table-hover" style="table-layout:fixed">
                    <thead>
                    <tr>
                        <th>资金类型</th>
                        <th>金额</th>
                        <th>时间</th>
                        <th>备注</th>
                    </tr>
                    </thead>
                    <tbody>
                    <?php if (!empty($money_list)) {
                        foreach ($money_list as $item) {
                            ?>
                            <tr>
                                <td><?= $item['type'] ?></td>
                                <td><?= $item['amount'] ?></td>
                                <td><?= date('Y-m-d H:i:s', $item['dateline']) ?></td>
                                <td><?= $item['remark'] ?></td>
                            </tr>
                        <?php } ?>
                    <?php } ?>

                    </tbody>
                </table>
                <div class="col-sm-12" style="text-align: center">
                    <span class="float-left" style="    line-height: 40px;"><?= '共' . $count . '条，每页' . '15' . '条' ?></span>
                    <?php echo $pages; ?>
                </div>
            </div>
        </div>
    </div>
</div>