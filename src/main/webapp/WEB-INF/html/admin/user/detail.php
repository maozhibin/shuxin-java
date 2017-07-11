<style>
    .row{
        font-size:14px;
        color:#999;
        letter-spacing:0;
        text-align:left;
        margin:5px 8px;
    }
</style>
<h2 class="header"><a href="<?= site_url('admin/user/' . ($info['type_id'] == 'USER' ? 'user_list' : 'org_list')); ?>">机构列表</a> — 机构详情</h2>
<div class="box"></div>
<section style="margin: 20px">
    <h4 class="header">
        <span class="text-left">用户基本信息<span>
    </h4>

    <div class="row">
        <label class="col-md-2 text-overflow">用户姓名：</label>
        <div class="col-md-10"><?= is_array($info) ? $info['username'] : '' ?></div>
    </div>
    <div class="row">
        <label class="col-md-2 text-overflow">手机号码：</label>
        <div class="col-md-10"><?= is_array($info) ? $info['mobile'] : '' ?></div>
    </div>
    <div class="row">
        <label class="col-md-2 text-overflow">客户最近一次登录时间：</label>
        <div class="col-md-10"><?= is_array($info) ? date('Y-m-d H:i:s', $info['last_login_time']): '' ?></div>
    </div>
    <div class="row">
        <label class="col-md-2 text-overflow">客户最近一次登录IP：</label>
        <div class="col-md-10"><?= is_array($info) ? $info['last_login_ip'] : '' ?></div>
    </div>
    <div class="row">
        <label class="col-md-2 text-overflow">邮箱：</label>
        <div class="col-md-10"><?= is_array($info) ? $info['email'] : '' ?></div>
    </div>
</section>

<section style="margin: 20px;">
    <h4 class="header">
        <span class="text-left">用户第三方绑定信息<span>
    </h4>

    <?php if (isset($user_card)): ?>
        <div class="row">
            <label class="col-md-2 text-overflow">添加时间：</label>
            <div class="col-md-10"><?= $user_card['modify_time'] != null ? $user_card['modify_time'] : ''; ?></div>
        </div>
        <div class="row">
            <label class="col-md-2 text-overflow">开户名称：</label>
            <div class="col-md-10"><?= $user_card['bank']; ?></div>
        </div>
        <div class="row">
            <label class="col-md-2 text-overflow">开户卡号：</label>
            <div class="col-md-10"><?= $user_card['card_no']; ?></div>
        </div>
        <div class="row">
            <label class="col-md-2 text-overflow">是否认证：</label>
            <div class="col-md-10">
                <?php if ($user_card['card_status'] == 'VERIFYING') {
                    echo '认证中';
                } elseif ($user_card['card_status'] == 'VERIFIED') {
                    echo '认证成功';
                } elseif ($user_card['card_status'] == 'VERIFYFAILED') {
                    echo '认证失败';
                } else {
                    echo '其他';
                } ?>
            </div>
        </div>
    <?php else: ?>
        <div class="row">暂无第三方绑定信息</div>
    <?php endif; ?>
</section>

<section style="margin: 20px">
    <h4 class="header">
    <span class="text-left">用户资金信息<span>
    </h4>
    <div class="row">
        <label class="col-md-2 text-overflow">账户金额：</label>
        <div class="col-md-10"><?= is_array($info) ? $info['money_balance'] : '' ?></div>
    </div>
    <div class="row">
        <label class="col-md-2 text-overflow">账户冻结金额：</label>
        <div class="col-md-10"><?= is_array($info) ? $info['money_freeze'] : '' ?></div>
    </div>
</section>

<section class="box" style="margin-top: 20px;padding-top: 20px;box-shadow: none;">
    <a href="<?php echo site_url("admin/user/user_money/" . $info['id']) ?>" class="btn">查看用户资金变动记录</a>
    <br>
    <br>
</section>

