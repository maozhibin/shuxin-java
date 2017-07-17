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
    <title>产品交易概况</title>
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
            <h4 class="header">TOP10 产品交易总额排名和明细</h4>
            <table id="purchase" class="table table-bordered table-striped table-hover" style="table-layout:fixed">
                <thead>
                <tr>
                    <th>产品名称</th>
                    <th>产品类别</th>
                    <th>排名</th>
                    <th>交易总额</th>
                    <th>总购买次数</th>
                    <th>产品来源</th>
                </tr>
                </thead>
                <tbody>
                <?php foreach ($prodeal as $item =>$value):?>
                <tr>
                    <td>
                        <?php echo $value['productname']; ?>
                    </td>
                    <td>
                        <?php echo $value['catename']; ?>
                    </td>
                    <td>
                        <?php echo $item+1  ?>
                    </td>
                    <td>
                        <?php echo $value['totalAmount']; ?>
                    </td>
                    <td>
                        <?php echo $value['ordernum']; ?>
                    </td>
                    <td>
                        <?php echo $value['username']; ?>
                    </td>
                </tr>
                <?php endforeach;?>
                </tbody>
            </table>
        </div>
        <div class="row tables-right ctn-tables">
            <form action="<?php echo site_url('admin/ControlPanel/product_deal'); ?>" class="form-inline" method="post" accept-charset="utf-8">
                <table>
                    <tbody>
                    <tr>
                        <!--<td> 筛选：</td>
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
                        <!-- <td> 日期：</td>
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
                    <th>产品名称</th>
                    <th>产品类别</th>
                    <th>排名</th>
                    <th>交易总额</th>
                    <th>总购买次数</th>
                    <th>产品来源</th>
                </tr>
                </thead>
                <tbody>
                <?php if (isset($searchProdeal)): ?>
                <?php foreach ($searchProdeal as $items =>$values):?>
                <tr>
                    <td>
                        <?php echo $values['productname']; ?>
                    </td>
                    <td>
                        <?php echo $values['catename']; ?>
                    </td>
                    <td>
                        <?php echo $values['ranking'];  ?>
                    </td>
                    <td>
                        <?php echo $values['totalAmount']; ?>
                    </td>
                    <td>
                        <?php echo $values['ordernum']; ?>
                    </td>
                    <td>
                        <?php echo $values['username']; ?>
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

</body>
</html>
