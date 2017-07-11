<style>
    th, td {
        padding-top: 10px;
        padding-right: 10px;
    }

    .box span {
        background-color: #e0e0e0;
        padding: 10px;
    }
</style>

    <h2 class="header"><a href="<?= site_url('admin/news/news_list'); ?>">新闻列表查看</a> — 列表详情</h2>


<!--    <a href="--><?//= site_url('admin/news/news_add/' . $info['id']); ?><!--" type="button"-->
<!--       class="btn btn-primary" style="margin-left: 10px"><i class="fa fa-edit"></i> 修改</a>-->


<hr>
<section>
    <h4 class="header">
        <span class="text-left">新闻详情<span>
    </h4>

    <div class="row">
        <label class="col-md-2 text-overflow">序号：</label>
        <div class="col-md-10"><?= is_array($info) ? $info['id'] : '' ?></div>
    </div>
    <div class="row">
        <label class="col-md-2 text-overflow">类别：</label>
        <div class="col-md-10"><?= is_array($info) ? $info['type'] : '' ?></div>
    </div>
    <div class="row">
        <label class="col-md-2 text-overflow">标题：</label>
        <div class="col-md-10"><?= is_array($info) ? $info['title'] : '' ?></div>
    </div>
    <div class="row">
        <label class="col-md-2 text-overflow">时间：</label>
        <div class="col-md-10"><?= is_array($info) ?date('Y-m-d H:i:s', $info['dateline']) : '' ?></div>
    </div>
    <div class="row">
        <label class="col-md-2 text-overflow">来源：</label>
        <div class="col-md-10"><?= is_array($info) ? $info['source'] : '' ?></div>
    </div>
    <div class="row">
        <label class="col-md-2 text-overflow">作者：</label>
        <div class="col-md-10"><?= is_array($info) ?$info['author'] : '' ?></div>
    </div>
    <div class="row">
        <label class="col-md-2 text-overflow">浏览次数：</label>
        <div class="col-md-10"><?= is_array($info) ? $info['view_count'] : '' ?></div>
    </div>
    <div class="row">
        <label class="col-md-2 text-overflow">关键字：</label>
        <div class="col-md-10"><?= is_array($info) ?$info['keywords'] : '' ?></div>
    </div>
    <div class="row">
        <label class="col-md-2 text-overflow">网页描述：</label>
        <div class="col-md-10"><?= is_array($info) ? $info['description'] : '' ?></div>
    </div>
    <div class="row">
        <label class="col-md-2 text-overflow">是否展示：</label>
        <div class="col-md-10"><?=  $info['isdisplay'] == 1 ? '是' : '否' ?></div>
    </div>
    <div class="row">
        <label class="col-md-2 text-overflow">是否置顶：</label>
        <div class="col-md-10"><?=  $info['top'] == 1 ? '是' : '否' ?></div>
    </div>
    <div class="row">
        <label class="col-md-2 text-overflow">新闻头图：</label>
        <div class="col-md-10"><img src="<?= is_array($info) ? base_url($info['image']) : '' ?>"></div>
    </div>
    <div class="row">
        <label class="col-md-2 text-overflow">内容：</label>
        <div class="col-md-10"><?= is_array($info) ? $info['content'] : '' ?></div>
    </div>
</section>
<hr>

