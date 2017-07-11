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
    }
</style>
<div class="row">
<!--    <div class="box box-default">-->
<!--        <div class="box-header with-border">-->
<!---->
<!--        </div>-->
<!--    </div>-->
    <div class="box-body">
<!--        <div class="tile-body">-->
<!--        </div>-->
<!--        <div class="col-sm-12">-->
<!--            <table id="example2" class="table table-bordered table-hover dataTable" role="grid"-->
<!--                   aria-describedby="example2_info">-->
<!--                <thead>-->
<!--                </thead>-->
<!--            </table>-->
<!--        </div>-->
<!--        <div class="panel panel-transparent-black">-->
<!--            <div class="panel-body">-->
<!--                <div class="row">-->
<!--                </div><br>-->
<!---->
<!--            </div>-->
<!--        </div>-->
<!---->
<!--        <br>-->
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
                                <td>ip</td>
                                <td>时间</td>
                                <td>操作</td>
                            </tr>
                            </thead>
                            <tbody>
                            <?php foreach ($list as $k => $v) { ?>
                                <tr>
                                    <td><?php echo isset($v['ip'])?$v['ip'] : ''; ?></td>
                                    <td><?php echo isset($v['dateline'])?date("Y-m-d H:i:s",$v['dateline']) : ''; ?></td>
                                    <td><button class="btn btn-info f-lock" name_ip="<?php echo isset($v['ip'])?$v['ip'] : '';?>">解锁</button></td>
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
<script>
    $(function () {
        $(".f-lock").click(function () {
            var posts={
                'ip':$(this).attr("name_ip")
            };
            request('user/ip_update',posts,function (r) {
                if(r.error==0)
                {
                    show_success(r.data);
                    $(document).on('click', '.dialog .btn-close, .dialog .btn-blue, .dialog .btn-gray,#model_success_sure', function () {
                        window.location.reload();
                    });
                }else {
                    show_error();
                }

            })
        })
    })
</script>





