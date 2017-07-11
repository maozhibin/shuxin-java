<style>
    section{
        height:600px;
    }
</style>
<section>
    <h4 class="header"><a href="<?php echo base_url('admin');?>">后台管理系统</a> — 修改密码</h4>
    <hr>

        <?= form_open('', 'class=form-inline') ?>
            <div class="row">
                <label class="col-sm-1 text-overflow">原密码：</label>
                <div class="col-sm-11"><input class="form-control" type="password" name="old_pass" /></div>
            </div>
            <div class="row">
                <label class="col-sm-1 text-overflow">新密码：</label>
                <div class="col-sm-11"><input class="form-control" type="password" name="new_pass" /></div>
            </div>
            <div class="row">
                <label class="col-sm-1 text-overflow">确认密码：</label>
                <div class="col-sm-11"><input class="form-control" type="password" name="re_pass"  /></div>
            </div>
            <div class="row">
                <hr>
                <button id="re_pass" type="button" class="btn">修改</button>
            </div>
        <?= form_close() ?>
    </div>
</section>
<script>
    $("#re_pass").click(function () {
        var old_pass=$("input[name='old_pass']").val();
        var new_pass=$("input[name='new_pass']").val();
        var re_pass=$("input[name='re_pass']").val();
        if(old_pass==''){
            show_error('原密码不能为空');
            return false;
        }
        if(new_pass==''){
            show_error('新密码不能为空');
            return false;
        }else if(new_pass.length<8||new_pass.length>20){
            show_error('密码长度不符合8—20位，请重新输入！');
            return false;
        }
        if(new_pass != re_pass){
            show_error('两次密码不一致');
            return false;
        }
        var data = {
            'old_pass' : old_pass,
            'new_pass' : new_pass,
        };
        $.post('<?php echo base_url('admin/login/reset_password');?>',data,function (obj) {
            if(obj && obj.error == 0){
                show_success(obj.data);
                debugger;
                setTimeout(function () {
                    location.href = '<?php echo base_url('admin');?>';
                }, 3000);
            }else{
                show_error(obj.data);
            }
        });

    });
</script>








