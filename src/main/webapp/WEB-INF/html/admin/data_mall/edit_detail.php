<?php load_css('static/admin/plugins/simditor/styles/simditor.css'); ?>

<?php load_js('static/admin/plugins/simditor/scripts/jquery.min.js'); ?>
<?php load_js('static/admin/plugins/simditor/scripts/module.js'); ?>
<?php load_js('static/admin/plugins/simditor/scripts/hotkeys.js'); ?>
<?php load_js('static/admin/plugins/simditor/scripts/uploader.js'); ?>
<?php load_js('static/admin/plugins/simditor/scripts/simditor.js'); ?>

<br>
<div class="box box-solid box-primary">
    <div class="box-header">
        <h3 class="box-title">[<?php echo $product['name'] ?>]产品详情填写:</h3>
    </div>
</div>


<div class="box box-solid box-default">
    <div class="box-header">
        <?php if ($product['type'] == "FILE"): ?>
            <h3 class="box-title">api接口填写:</h3>
        <?php else: ?>
            <h3 class="box-title">FILE文件上传:</h3>
        <?php endif; ?>
    </div>
</div>

<div class="box box-solid box-default">
    <div class="box-header">
        <h3 class="box-title">产品详情填写:</h3>
    </div>
    <div class="box-body">
        <!--        <div style="500px">-->
        <!--            <textarea id="container" name="content" style="height: 320px;">fasf</textarea>-->
        <!--        </div>-->
    </div>

</div>


<div class="box box-solid box-default">
    <div class="box-header">
        <h3 class="box-title">产品价格填写:</h3>
    </div>
    <textarea id="editor" placeholder="Balabala" autofocus></textarea>
    <button id="save_editor" class="btn btn-success btn-block" style="margin: 10px;width: 20%;font-size: 20px">提交
    </button>
</div>


<?php load_js('static/admin/ue/ueditor.config.js'); ?>
<?php load_js('static/admin/ue/ueditor.all.js'); ?>

<script type="text/javascript">
    //    var ue = UE.getEditor('container');
    //    ue.ready(function() {
    //        ue.setContent('hello');
    //        var html = ue.getContent();
    //    });

    var editor = new Simditor({
        textarea: $('#editor'),
        placeholder: '这里输入内容...',
        toolbar: toolbar,  //工具栏
        defaultImage: 'simditor-2.0.1/images/image.png', //编辑器插入图片时使用的默认图片
        upload: {
            url: '<?php echo site_url("admin/data/upload")?>', //文件上传的接口地址
            params: null, //键值对,指定文件上传接口的额外参数,上传的时候随文件一起提交
            fileKey: 'imgFile', //服务器端获取文件数据的参数名
            connectionCount: 3,
            leaveConfirm: '正在上传文件'
        }
    });
    $(function () {

        $('#save_editor').click(function () {
            var img = $('.simditor-body p img').attr("alt");
            var img_url = base_url + 'uploads/' + img;
            $('.simditor-body p img').removeAttr("alt");
            $('.simditor-body p img').attr("src", img_url);
        });
    });


</script>


