<!DOCTYPE HTML>
<html lang="en-US">

<head>
    <meta charset="UTF-8">
    <?php load_css('static/admin/css/select2.css'); ?>
</head>
<style>
    .select-ctrl,.select2-container .select2-choice{
        width:150px;
        height: 34px;
        line-height: 34px;
    }
    #inputfile{
        height:0;
        width:0;
        z-index: -1;
        position: absolute;
        left: 10px;
        top: 5px;
    }
</style>
<body>
<h3 class="header">产品发布</h3>

    <?php echo form_open('admin/data/index', array( 'class' => 'form-horizontal')); ?>
        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">产品名称:</label>
            <div class="col-sm-11">
                <input class="form-control" style="width: 200px" name="name">
                <?php echo form_error('name')?>
            </div>
        </div>

        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">内容简介:</label>
            <div class="col-sm-11">
                <textarea class="form-control" rows="3" style="vertical-align: top;width: 500px" name="description"></textarea>
                <?php echo form_error('description')?>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">数据级别:</label>
            <div class="col-sm-11">
                <label><input name="data_level" type="radio" value="1"/>一星 </label>&nbsp;&nbsp;
                <label><input name="data_level" type="radio" value="2"/>二星 </label>&nbsp;&nbsp;
                <label><input name="data_level" type="radio" value="3"/>三星 </label>&nbsp;&nbsp;
                <label><input name="data_level" type="radio" value="4"/>四星 </label>&nbsp;&nbsp;
                <label><input name="data_level" type="radio" value="5"/>五星 </label>
                <?php echo form_error('data_level')?>
            </div>

        </div>
        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">数据类型:</label>
            <div class="col-sm-11">
                <label><input name="data_type" type="radio" value="1"/>接口 </label>&nbsp;&nbsp;
                <label><input name="data_type" type="radio" value="2"/>文件 </label>&nbsp;&nbsp;
                <?php echo form_error('data_type')?>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">发布者:</label>
            <div class="col-sm-11">
                <select name="producer" class="form-control" style="width: 150px">
                    <?php foreach ($producer as $item):?>
                        <option value="<?php echo $item['id']?>"><?php echo $item['username']?></option>
                    <?php endforeach;?>
                </select>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-sm-1 control-label no-padding-right">数据所在区域:</label>
            <div class="col-sm-11">
                <select class="select-ctrl"  name='province_id' id='province_id'><option value="">请选择</option></select>
                <select class="select-ctrl" name='area_id' id='area_id'><option value="">请选择</option></select>
                <input type="hidden" name="area_id_exist" id="area_id_exist" value=""/>
                <?php echo form_error('area_id')?>
            </div>
        </div>
        <div class="row form-group">
            <label for="file" class="col-sm-1 control-label no-padding-right">上传产品Icon:</label>
            <div class="col-sm-11">
                <input class="btn" type="button" id="file" value="上传图片"
                       onclick="getElementById('inputfile').click()"><label class="add_btn_img"></label> (上传图片大小应小于2500px*1500px)
                <input type="file" id="inputfile"><br/>
                <input type="hidden" name="icon" id="icon" value=""/>
                <br>
                <img src="" id="uf" width=188 height=96 margin-bottom=20px overflow=hidden;/>
            </div>
        </div>
        <div class="row">
            <hr>
            <button type="submit" class="btn" style="width: 90px">提交</button>
        </div>
    </form>

<?php load_js('static/admin/js/select2.js');?>
<?php load_js('static/js/area.js');?>
<?php load_js('static/js/common.js');?>

<script type="text/javascript">
    $(document).ready(function(){
        //响应文件添加成功事件

        $("#inputfile").change(function(){
            //创建FormData对象
            var data = new FormData();
            //为FormData对象添加数据
            data.append('imgFile'  ,  $('#inputfile')[0].files[0] ) ;
//            data.append('<?php //echo $this->security->get_csrf_token_name();?>//', '<?php //echo $this->security->get_csrf_hash();?>//');

            //发送数据
            $.ajax({
                url:'<?=site_url("admin/data/upload")?>',
                type:'POST',
                data:data,
                cache: false,
                contentType: false,		//不可缺参数
                processData: false,		//不可缺参数
                dataType:'json',
                success:function(data){
                    if( data.error ==1 ){
                        alert( data.message ) ;
                    }
                    else{
                        console.log(data.url);
                        // alert( JSON.stringify( data.url ) ) ;
                        $('#uf').attr('src',base_url+data.url);
                        $('#uf').show() ;
                        $('#icon').val( data.url );
                        $('#uf').val( base_url+data.url );
                    }
                },
                error:function(){
                    alert( '上传失败！' );

                }
            });
        });
    });
</script>
</body>

</html>