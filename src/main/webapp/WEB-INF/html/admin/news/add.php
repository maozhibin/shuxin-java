<?php
defined('BASEPATH') OR exit('No direct script access allowed');
?>
<style>
    select.form-control{
        width:150px;
    }
    input.form-control{
        width:500px;
    }
    .btn{
        width: 90px;
    }
</style>
    <h3 class="header">
        <a href="<?= site_url('admin/news/news_list'); ?>">新闻列表</a> —
        <?php echo isset($id) ? '新闻修改' : '新闻发布' ?>
    </h3>
<hr>
<?php echo form_open('admin/news/news_add' . (isset($id) ? '/' . $id : '')); ?>
    <?php echo form_open('admin/data/news_add', array('class' => 'form-inline')); ?>
        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">选择类型:</label>
            <div class="col-sm-11">
                <select name="type" class="form-control">
                    <?php foreach ($type_list as $key => $item): ?>
                        <option
                                value="<?php echo $key ?>" <?php echo (isset($info['type']) && $key == $info['type']) ? 'selected' : '' ?>><?php echo $item ?></option>
                    <?php endforeach; ?>
                </select>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">标题:</label>
            <div class="col-sm-11">
                <input class="form-control" name="title"
                       value="<?php echo isset($info['title']) ? $info['title'] : '' ?>"/>
                <?php echo form_error('title') ?>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">来源:</label>
            <div class="col-sm-11">
                <input class="form-control" name="source"
                       value="<?php echo isset($info['source']) ? $info['source'] : '' ?>"/>
                <?php echo form_error('source') ?>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">作者:</label>
            <div class="col-sm-11">
                <input class="form-control" name="author"
                       value="<?php echo isset($info['author']) ? $info['author'] : '' ?>"/>
                <?php echo form_error('author') ?>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">是否置顶:</label>
            <div class="col-sm-11">
                <label><input name="top" type="radio"
                              value="1" <?php echo (isset($info['top']) && $info['top'] == 1) ? 'checked="true"' : '' ?>/>是
                </label>&nbsp;&nbsp;
                <label><input name="top" type="radio"
                              value="0" <?php echo (isset($info['top']) && $info['top'] == 0) ? 'checked="true"' : '' ?>/>否
                </label>&nbsp;&nbsp;
                <?php echo form_error('top') ?>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">是否显示发布:</label>
            <div class="col-sm-11">
                <label><input name="is_display" type="radio"
                              value="1" <?php echo (isset($info['isdisplay']) && $info['isdisplay'] == 1) ? 'checked="true"' : '' ?>/>是
                </label>&nbsp;&nbsp;
                <label><input name="is_display" type="radio"
                              value="0" <?php echo (isset($info['isdisplay']) && $info['isdisplay'] == 0) ? 'checked="true"' : '' ?>/>否
                </label>&nbsp;&nbsp;
                <?php echo form_error('is_display') ?>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">网页关键词:</label>
            <div class="col-sm-11">
                <input class="form-control" name="keywords"
                       value="<?php echo isset($info['keywords']) ? $info['keywords'] : '' ?>"/>
                <?php echo form_error('keywords') ?>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">网页关键词:</label>
            <div class="col-sm-11">
                <input class="form-control" name="keywords"
                       value="<?php echo isset($info['keywords']) ? $info['keywords'] : '' ?>"/>
                <?php echo form_error('keywords') ?>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">新闻头图:</label>
            <div class="col-sm-11">
                <input class="btn" type="button" id="file" value="上传图片"
                       onclick="getElementById('inputfile').click()"><label class="add_btn_img"></label>
                (上传图片大小应小于2500px*1500px)
                <div></div>
                <input type="file" id="inputfile"
                       style="height:0;width:0;z-index: -1; position: absolute;left: 10px;top: 5px;"><br/>
                <input type="hidden" name="image" id="icon"
                       value="<?php echo isset($info['image']) ? $info['image'] : '' ?>"/>
                <img src="<?php echo isset($info['image']) ? base_url($info['image']) : '' ?>" id="uf" width=188
                     height=96 margin-bottom=20px overflow=hidden;/>
                <?php echo form_error('image') ?>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">网页关键词:</label>
            <div class="col-sm-11">
                <input class="form-control" name="keywords"
                       value="<?php echo isset($info['keywords']) ? $info['keywords'] : '' ?>"/>
                <?php echo form_error('keywords') ?>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">新闻内容:</label>
            <div class="col-sm-11">
                <textarea id="editor" name="content"
                          autofocus><?php echo isset($info['content']) ? $info['content'] : '' ?></textarea>
                <?php echo form_error('content') ?>
            </div>
        </div>
        <div class="row">
            <hr>
            <button type="submit" class="btn" id="submit">提交</button>
        </div>
    </form>


<?php load_css('static/admin/plugins/simditor/styles/simditor.css'); ?>

<?php load_js('static/admin/plugins/simditor/scripts/jquery.min.js'); ?>
<?php load_js('static/admin/plugins/simditor/scripts/module.js'); ?>
<?php load_js('static/admin/plugins/simditor/scripts/hotkeys.js'); ?>
<?php load_js('static/admin/plugins/simditor/scripts/uploader.js'); ?>
<?php load_js('static/admin/plugins/simditor/scripts/simditor.js'); ?>


<script type="text/javascript">
    $(document).ready(function () {
        //响应文件添加成功事件

        $("#inputfile").change(function () {
            //创建FormData对象
            var data = new FormData();
            //为FormData对象添加数据
            data.append('imgFile', $('#inputfile')[0].files[0]);
//            data.append('<?php //echo $this->security->get_csrf_token_name();?>//', '<?php //echo $this->security->get_csrf_hash();?>//');

            //发送数据
            $.ajax({
                url: '<?=site_url("admin/data/upload")?>',
                type: 'POST',
                data: data,
                cache: false,
                contentType: false,		//不可缺参数
                processData: false,		//不可缺参数
                dataType: 'json',
                success: function (data) {
                    if (data.error == 1) {
                        alert(data.message);
                    }
                    else {
                        console.log(data.url);
                        // alert( JSON.stringify( data.url ) ) ;
                        $('#uf').attr('src', base_url + data.url);
                        $('#uf').show();
                        $('#icon').val(data.url);
                        $('#uf').val(base_url + data.url);
                    }
                },
                error: function () {
                    alert('上传失败！');

                }
            });
        });

        var editor = new Simditor({
            textarea: $('#editor'),
            placeholder: '这里输入内容...',
            toolbar: toolbar,  //工具栏
            defaultImage: 'simditor/images/image.png', //编辑器插入图片时使用的默认图片
            upload: {
                url: '<?php echo site_url("admin/data/upload")?>', //文件上传的接口地址
                params: null, //键值对,指定文件上传接口的额外参数,上传的时候随文件一起提交
                fileKey: 'imgFile', //服务器端获取文件数据的参数名
                connectionCount: 3,
                leaveConfirm: '正在上传文件'
            }
        });

    });
</script>
