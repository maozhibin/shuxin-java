<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yongj
  Date: 7/19/2017
  Time: 9:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="col-sm-12" style="text-align: center">
                    <span class="float-left pagination" style="line-height: 40px;">
                        共${page.totalRecordCount}条，每页${page.pageSize}条
                    </span>
    <div class="pages">
        <ul class="pagination">
            <li><a onclick="nav(${page.pageNo - 3 < 1 ? 1 : page.pageNo - 3})">«</a></li>
            <c:forEach var="i" begin="${page.pageNo > 2 ? page.pageNo - 2 : 1}" end="${page.pageNo > 1 ? page.pageNo - 1 : 0}">
                <li><a onclick="nav(${i})">${i}</a></li>
            </c:forEach>
            <li><a class="active" onclick="nav(${page.pageNo})">${page.pageNo}</a></li>
            <c:forEach var="i" begin="${page.pageNo + 1}" end="${(page.pageNo + 2) > page.totalPageCount ? page.totalPageCount : (page.pageNo + 2)}">
                <li><a onclick="nav(${i})">${i}</a></li>
            </c:forEach>
            <li><a onclick="nav(${page.pageNo + 3  > page.totalPageCount ? page.totalPageCount : page.pageNo + 3})">»</a></li>
        </ul>
    </div>
</div>
<script>
    function nav(pageNo) {
        $("form").attr("method", "post");
        $("form").append('<input hidden name="pageNo" value="${page.pageNo}" title="页码">');
        $('form').append('<input hidden name="pageSize" value="${page.pageSize}" title="页容量">');
        $('input[name=pageNo]').val(pageNo);
        $("button[type=submit]").click();
    }
</script>
