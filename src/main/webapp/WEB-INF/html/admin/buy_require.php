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
    <div class="box box-default">
        <div class="box-header with-border">

        </div>
    </div>
    <div class="box-body">
        <div class="tile-body">
        </div>
        <div class="col-sm-12">
            <table id="example2" class="table table-bordered table-hover dataTable" role="grid"
                   aria-describedby="example2_info">
                <thead>
                </thead>
            </table>
        </div>
        <div class="panel panel-transparent-black">
            <div class="panel-body">
                <div class="row">
                    <div class="col-sm-3">
                        <div class="input-group">
                            <span class="input-group-addon">状态:</span>
                            <select name="search-type" class="form-control" id="domain">
                                <option value="<?php echo SERVICE_PARAM_INT_TYPE_ALL ?>">全部</option>
                                <?php foreach($domain as $key => $value):?>
                                <option value="<?php echo $key?>" <?php echo $domain_v == $key ? 'selected' : ''?>><?php echo $value?>
                                    <?php endforeach;?>
                            </select>
                        </div>
                    </div>
                    <div class="col-sm-3">
                        <div class="input-group">
                            <span class="input-group-addon">类型:</span>
                            <select name="search-type" class="form-control" id="require_type">
                                <option value="<?php echo SERVICE_PARAM_INT_TYPE_ALL ?>">全部</option>
                                <?php foreach($type as $key => $value):?>
                                <option value="<?php echo $key?>" <?php echo $type_v == $key ? 'selected' : ''?>><?php echo $value?>
                                    <?php endforeach;?>
                            </select>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-addon">日期：</div>
                                <input type="text" class="form-control pull-right" id="date_range">
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-2">
                        <div class="btn-group">
                            <button id="search-btn" class="btn btn-primary search-btn" style="margin-left:10px "><i
                                    class="fa fa-search"></i> 筛选
                            </button>
                        </div>
                    </div>
                </div><br>

            </div>
        </div>

        <br>
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
<!--                                <td>图标</td>-->
                                <td>需求方</td>
                                <td>类型</td>
                                <td>描述</td>
                                <td>价格/次数</td>
                                <td>联系电话</td>
                                <td>邮箱</td>
                                <td>详情</td>
                                <td>生成时间</td>
                                <td>需求状态</td>
                            </tr>
                            </thead>
                            <tbody>
                            <?php foreach ($list as $k => $v) { ?>
                                <tr>
<!--                                    <td><img class="f-image" src="--><?php //echo base_url('static/upload/images/').(isset($v['icon'])?$v['icon']:'')?><!--"></td>-->
                                    <td><?php echo isset($v['name'])?$v['name'] : ''; ?></td>
                                    <td><?php echo isset($v['type'])?$v['type'] : ''; ?></td>
                                    <td><?php echo isset($v['description'])?$v['description'] : ''; ?></td>
                                    <td><?php echo isset($v['price'])?$v['price'] : ''; ?></td>
                                    <td><?php echo isset($v['mobile'])?$v['mobile'] : ''; ?></td>
                                    <td><?php echo isset($v['email'])?$v['email'] : ''; ?></td>
                                    <td><textarea rows="3" cols="70" readonly>
                                            <?php print_r(isset($v['detail'])? json_decode($v['detail'],true) : ''); ?>
                                        </textarea></td>
                                    <td><?php echo isset($v['dateline'])?date("Y-m-d H:i:s",$v['dateline']) : ''; ?></td>
                                    <td><?php if(isset($v['status'])&&$v['status']==Market_service::REQUIRE_STATUS_INIT){?>
                                        <button class="btn btn-info require_check" data_id="<?php echo isset($v['id'])?$v['id'] : '';?>" data_status="<?php echo Market_service::REQUIRE_STATUS_VERIFY?>">初始化</button>
                                        <?php }elseif(isset($v['status'])&&$v['status']==Market_service::REQUIRE_STATUS_VERIFY){?>
                                            <button class="btn btn-info require_check" data_id="<?php echo isset($v['id'])?$v['id'] : '';?>" data_status="<?php echo Market_service::REQUIRE_STATUS_LISTING?>">审核中</button>
                                        <?php }elseif(isset($v['status'])&&$v['status']==Market_service::REQUIRE_STATUS_LISTING){?>
                                            <button class="btn btn-info">需求竞价</button>
                                        <?php }else{?>
                                            <button class="btn btn-info">需求完成</button>
                                        <?php }?>
                                    </td>
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
        $("a.active").removeClass("active");
        $(this).addClass("btn-primary");
        var url = "<?php echo base_url("admin/data_buy_require/buy_require");?>" + "/1/" + $("#domain").val()+"/" +$("#require_type").val()+ "/"+ "choosetime/" + g_start_time_str + "/" + g_end_time_str + ".html";
        doFilter(url);
        return false;
    });

    $(function() {

        $(".status_button").click(function () {
            $("#update_id").attr("value",$(this).attr("id"));
        });

        $(".require_check").click(function () {
            var param = {
                'id': $.trim($(this).attr('data_id')),
                'status': $.trim($(this).attr('data_status')),
            };
            cloud_request("<?php echo site_url('market/need_issue_update');?>", param, function (e) {
                if(e.error > 0){
                    show_dialog({msg:e.data});//显示对话框
                }else{
                    window.location.reload(true);
                }
            });
        });

    });
</script>




