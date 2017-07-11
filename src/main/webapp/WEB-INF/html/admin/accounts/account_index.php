<?php load_css(
    "static/admin/plugins/daterangepicker/daterangepicker.css",
    "static/admin/plugins/datepicker/datepicker3.css",
    "static/admin/plugins/colorpicker/bootstrap-colorpicker.min.css",
    "static/admin/plugins/timepicker/bootstrap-timepicker.min.css",
    "static/admin/plugins/select2/select2.min.css",
    "static/admin/plugins/fullcalendar/fullcalendar.min.css",
    "static/admin/plugins/datatables/dataTables.bootstrap.css",
    "static/admin/plugins/ad_yzt.css"
);
?>
<style>
    td {
        word-break: break-all;
        word-wrap:break-word;
        padding:10px;
    }
</style>
    <section>
        <div class="row">
            <form action="" class="form-inline" method="post" accept-charset="utf-8">
                <table style="margin-left: 30px">
                    <tbody><tr>
                        <td> 类型：</td>
                        <td>
                            <select name="search-type" class="form-control" id="domain">
                                <option value="<?php echo SERVICE_PARAM_INT_TYPE_ALL ?>">全部</option>
                                <?php foreach($type as $key => $value):?>
                                <option value="<?php echo $key?>" <?php echo $type_v == $key ? 'selected' : ''?>><?php echo $value?>
                                    <?php endforeach;?>
                            </select>
                        </td>
                        <td> ID：</td>
                        <td>
                            <input type="text" class="form-control pull-right" id="user_id" placeholder="用户ID">
                        </td>
                        <td> 日期：</td>
                        <td>
                            <input type="text" class="form-control pull-right" id="date_range">
                        </td>
                        <td>
                            <button type="submit" class="btn"><i class="fa fa-search"></i> 筛选</button>
                        </td>
                    </tr>
                    </tbody></table>
            </form>    </div>
    </section>
    <div class="row">
            <div class="col-md-12">
                <section class="tile color transparent-black">
                    <!-- tile body -->
                    <div class="tile-body nopadding">
                        <!--                        <table id="datatable1"-->
                        <!--                               class="datatable table table-striped table-bordered table-hover" style="table-layout:fixed;">-->
                        <table id="data_table" class="table table-bordered table-sortable">
                            <thead>
                            <tr>
                                <td>用户ID</td>
                                <td>类型</td>
                                <td>金额</td>
                                <td>状态</td>
                                <td>操作第三方流水号</td>
                                <td>手续费值</td>
                                <td>状态描述</td>
                                <td>生成时间</td>
                                <td>完成时间</td>
                            </tr>
                            </thead>
                            <tbody>
                            <?php foreach ($list as $k => $v) { ?>
                                <tr>
                                    <td><?php echo isset($v['user_id'])?$v['user_id'] : ''; ?></td>
                                    <td><?php echo isset($v['type'])?$v['type'] : ''; ?></td>
                                    <td><?php echo isset($v['amount'])?$v['amount'] : ''; ?></td>
                                    <td><?php echo isset($v['status'])?$v['status'] : ''; ?></td>
                                    <td><?php echo isset($v['request_no'])?$v['request_no'] : ''; ?></td>
                                    <td><?php echo isset($v['fee'])?$v['fee'] : ''; ?></td>
                                    <td><?php echo isset($v['status_desc'])?$v['status_desc'] : ''; ?></td>
                                    <td><?php echo isset($v['dateline'])?date("Y-m-d H:i:s",$v['dateline']) : ''; ?></td>
                                    <td><?php echo isset($v['finish_time'])?date("Y-m-d H:i:s",$v['finish_time']) : ''; ?></td>
                                </tr>
                            <?php } ?>

                            </tbody>
                        </table>
                    </div>
                    <!-- /BOX -->
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="pull-left">
                            </div>
                            <div class="pull-right">
                                <div class="dataTables_paginate paging_bs_full" id="datatable1_paginate">
                                    <ul class="pagination">
                                        <?php echo $this->pagination->create_links(); ?>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        </div>
<?php
load_js(
    "static/admin/js/laydate/laydate.js",
    "static/admin/plugins/select2/select2.full.min.js",
    "static/admin/plugins/daterangepicker/moment.min.js",
    "static/admin/plugins/daterangepicker/daterangepicker.js",
    "static/admin/plugins/datepicker/bootstrap-datepicker.js",
    "static/admin/plugins/fullcalendar/fullcalendar2.js",
    "static/admin/plugins/fullcalendar/locale-all.js",
    "static/admin/plugins/datatables/jquery.dataTables.min.js",
    "static/admin/plugins/datatables/dataTables.bootstrap.min.js"
);
?>
<!---->
<!--<script type="text/javascript">-->
<!--    var dataTableOption = {-->
<!--        pageLength: 10,-->
<!--        language: {-->
<!--            paginate: {-->
<!--                previous: "上一页",-->
<!--                next: "下一页"-->
<!--            },-->
<!--            emptyTable: "<br>暂无数据!"-->
<!--        },-->
<!--        "order": [[0, "desc"]]-->
<!--    };-->
<!--    $('#data_table').DataTable(dataTableOption);-->
<!--</script>-->
<script type="text/javascript">

    var g_start_time_str = "";
    var g_end_time_str = "";
    var g_start = moment('<?php echo date("Y-m-d",$start_time);?>');
    var g_end = moment('<?php echo date("Y-m-d",$end_time);?>');

    function cb(start, end) {
        g_start_time_str = start.format('YYYY-MM-DD');
        g_end_time_str = end.format('YYYY-MM-DD');
    }

    $('#date_range').daterangepicker({
        startDate: g_start,
        endDate: g_end,
        ranges: {
            '今天': [moment(), moment()],
            '昨天': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
            '最近七天': [moment().subtract(6, 'days'), moment()],
            '最近30天': [moment().subtract(29, 'days'), moment()],
            '本月': [moment().startOf('month'), moment().endOf('month')],
            '上一月': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
        }
    }, cb);
    cb(g_start, g_end);

    function doFilter(url) {
        document.location.href = url;
    }

    $("#search-btn").click(function () {
        var id=$("#user_id").val()?$("#user_id").val():-1;
        var url = "<?php echo base_url("admin/account/account_money_record");?>" + "/1/choosetime/"+ $("#domain").val()+"/"+id+ "/" + g_start_time_str + "/" + g_end_time_str + ".html";
        doFilter(url);
        return false;
    });

</script>




