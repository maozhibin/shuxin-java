<?php
defined('BASEPATH') OR exit('No direct script access allowed');
?>

<h4 class="header">参数配置 — 编辑</h4>
<div class="row">
        <div class="box-body">

            <?php echo form_open('admin/option/option_edit/' . $this->uri->segment(4, 0), array('class' => 'form-horizontal')); ?>
            <div class="form-group">
                <div class="col-md-1">
                    <label class="control-label" >变量名 <b class=" red">*</b> :</label>
                </div>
                <div class="col-md-11">
                    <input name="varname" value="<?php echo set_value('varname', $option['varname']) ?>"
                           class="col-xs-10 col-sm-5" placeholder="变量名必须填写！"/>
                </div>

                <div class="col-md-1"></div>
                <div class="col-md-11">
                    <?php echo form_error('varname'); ?>
                </div>

            </div>
            <div class="form-group">
                <br/>
                <div class="col-md-1">
                    <label class="control-label" >变量值 <b class=" red">*</b> :</label>
                </div>
                <div class="col-md-11">
                    <textarea name="value" style="height: 200px"
                              class="col-xs-10 col-sm-5"
                              placeholder="变量值必须填写！"><?php echo set_value('value', $option['value']) ?></textarea>
                </div>
                <div class="col-md-1"></div>
                <div class="col-md-11">
                    <?php echo form_error('value'); ?>
                </div>
            </div>

            <div class="form-group">
                <br/>
                <div class="col-md-1">
                    <label class="control-label" >备注：</label>
                </div>
                <div class="col-md-11">
                    <input name="remark" value="<?php echo set_value('remark', $option['memo']) ?>"
                           class="col-xs-10 col-sm-5" placeholder=""/>
                </div>
            </div>
            <div class="form-group">
                <hr>
                <button type="submit" style="" class="btn">保存修改</button>
            </div>
            <?php echo form_close(); ?>

        </div>
</div>


