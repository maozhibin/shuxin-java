<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        .container-fluid {
            background: transparent;
            border: none;
            padding: 0;
        }

        td {
            padding: 10px;
        }

        .ctn-tables {
            background: #fff;
            border: 1px solid #ccc;
            padding: 10px;
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
                <c:forEach items="${orgAmountlist}" var="item">
                    <tr>
                        <td>
                                ${item.username}
                        </td>
                        <td>
                                ${item.rank}
                        </td>
                        <td>
                                ${item.amount}
                        </td>
                        <td>
                                ${item.ordernum}
                        </td>
                        <td>
                                ${item.product.name}|${item.product.ordernum}
                        </td>
                        <td>

                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="row tables-right ctn-tables">
            <form action="/admin/overview/organization/search" class="form-inline" method="post"
                  accept-charset="utf-8">
                <table>
                    <tbody>
                    <tr>
                        <td> 筛选：</td>
                        <td>
                            <select name="search-type" class="form-control" id="domain">
                                <option>北京</option>
                                <option>浙江</option>
                            </select>
                        </td>
                        <td> 关键字：</td>
                        <td>
                            <input type="text" class="form-control pull-right" id="keywords" name="keywords"
                                   value="${keywords}"
                                   placeholder="请输入关键字搜索">
                        </td>
                        <td> 日期：</td>
                        <td style="position: relative">
                            <input type="text" class="timePoint">
                            <div id='wrap' class="hidden">
                                <form>
                                    <i class="fa fa-window-close btn-close"></i>
                                    <select class='custom-date' name='select'>
                                        <option value=''>请选择时间</option>
                                        <option value='7'>最近7天</option>
                                        <option value='30'>最近一个月</option>
                                        <option value='90'>最近三个月</option>
                                        <option value='180'>最近半年</option>
                                        <option selected='selected' value='1'>今天</option>
                                        <option value='custom'>自由选择</option>
                                    </select>
                                </form>
                            </div>
                        </td>
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
                <c:if test="${orgSearchAmoun != null}">
                    <c:forEach items="${orgSearchAmoun}" var="item">
                        <tr>
                            <td>
                                    ${item.username}
                            </td>
                            <td>
                                    ${item.rank}
                            </td>
                            <td>
                                    ${item.amount}
                            </td>
                            <td>
                                    ${item.ordernum}
                            </td>
                            <td>
                                    ${item.product.name}|${item.product.ordernum}
                            </td>
                            <td>

                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                </tbody>
            </table>
        </div>
    </div>
    <!-- /.container-fluid -->
</div>
<!-- /#page-wrapper -->

</body>
</html>
