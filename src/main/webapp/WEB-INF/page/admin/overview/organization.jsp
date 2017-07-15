<%--
  Created by IntelliJ IDEA.
  User: yongj
  Date: 7/15/2017
  Time: 1:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>机构交易概况</title>
    <style>
        .container-fluid{
            background: transparent;
            border:none;
            padding:0;
        }
        td{
            padding: 10px;
        }
        .ctn-tables{
            background: #fff;
            border:1px solid #ccc;
            padding:10px;
        }
    </style>
</head>
<body>

<div id="page-wrapper">
    <div class="container-fluid">
        <!-- 内容区域 -->
        <div class="row tables-left ctn-tables">
            <h4 class="header">TOP10 合作机构交易总额排名和明细</h4>
            <table id="purchase" class="table table-bordered table-striped table-hover" style="table-layout:fixed">
                <thead>
                <tr>
                    <th>合作机构名称</th>
                    <th>排名</th>
                    <th>交易总额</th>
                    <th>总订单量</th>
                    <th>购买最多产品名称|购买次数</th>
                    <th>存证总数</th>
                </tr>
                </thead>
                <tbody>
                <?php foreach ($orgAmountlist as $item =>$value):?>
                <tr>
                    <td>
                        <?php echo $value['username'] ?>
                    </td>
                    <td>
                        <?php echo $item+1; ?>
                    </td>
                    <td>
                        <?php echo $value['amount'] ?>
                    </td>
                    <td>
                        <?php echo $value['ordernum'] ?>
                    </td>
                    <td>
                        <?php echo $value['productname_num'][0]['name'].' | '; echo $value['productname_num'][0]['ordernum'];?>
                    </td>
                    <td>

                    </td>
                </tr>
                <?php endforeach;?>
                </tbody>
            </table>
        </div>
        <div class="row tables-right ctn-tables">
            <form action="<?php echo site_url('admin/ControlPanel/org_deal'); ?>" class="form-inline" method="post" accept-charset="utf-8">
                <table>
                    <tbody>
                    <tr>
                        <!-- <td> 筛选：</td>
                         <td>
                             <select name="search-type" class="form-control" id="domain">
                                 <option >北京</option>
                                 <option >浙江</option>
                             </select>
                         </td>-->
                        <td> 关键字：</td>
                        <td>
                            <input type="text" class="form-control pull-right" id="keywords" name="keywords" value="<?php if(isset($_POST['keywords'])){echo $_POST['keywords'];} ?>" placeholder="请输入关键字搜索">
                        </td>
                        <!--  <td> 日期：</td>
                          <td>
                              <input type="text" class="form-control pull-right" id="date_range">
                          </td>-->
                        <td>
                            <button type="submit" class="btn"><i class="fa fa-search"></i> 搜索</button>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form>
            <table id="deal" class="table table-bordered table-striped table-hover" style="table-layout:fixed">
                <thead>
                <tr>
                    <th>合作机构名称</th>
                    <th>排名</th>
                    <th>交易总额</th>
                    <th>总订单量</th>
                    <th>购买最多产品名称 | 购买次数</th>
                    <th>存证总数</th>
                </tr>
                </thead>
                <tbody>
                <?php if (isset($orgSearchAmoun)): ?>
                <?php foreach ($orgSearchAmoun as $items =>$values):?>
                <tr>
                    <td>
                        <?php echo $values['username'] ?>
                    </td>
                    <td>
                        <?php echo $values['ranking'] ?>
                    </td>
                    <td>
                        <?php echo $values['amount'] ?>
                    </td>
                    <td>
                        <?php echo $values['ordernum'] ?>
                    </td>
                    <td>
                        <?php echo $values['productname_num'][0]['name'].' | '; echo $values['productname_num'][0]['ordernum'];?>
                    </td>
                    <td>
                    </td>
                </tr>
                <?php endforeach;?>
                <?php endif; ?>
                </tbody>
            </table>
        </div>
    </div>
    <!-- /.container-fluid -->
</div>
<!-- /#page-wrapper -->

</body>
</html>
