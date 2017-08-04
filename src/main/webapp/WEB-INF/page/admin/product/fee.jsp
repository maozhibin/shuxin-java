<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yongj
  Date: 7/17/2017
  Time: 2:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div hidden="hidden" class="container price">
    <div class="ml60 pl10" id="container-per">
        <table class="mb50">
            <thead>
            <tr>
                <th width="218">标准名称</th>
                <th>设置(元/1次)</th>
            </tr>
            </thead>
            <tbody id="request_billings_per">
            <tr>
                <td>单次计费</td>
                <td>
                    <ul class="inline">
                        <li class="cell"><input class="input-ctrl" type="number" name="priceOne" 
                        <c:forEach items="${hashMap.billingsList}" var="item">
                        <c:if test="${item.num == 1}"> value="${item.price}"</c:if></c:forEach>id="priceOne"></li>
                    </ul>
                </td>
            </tr>
            </tbody>
        </table>
    </div>

    <div class="ml60 pl10" id="container-multi">
        <table class="mb50">
            <thead>
            <tr>
                <th width="218">标准名称</th>
                <th>设置(元/100次)</th>
            </tr>
            </thead>
            <tbody id="request_billings_multi">
            <tr>
                <td>多次计费</td>
                <td>
                    <ul class="inline">
                        <li class="cell"><input type="text" name="priceHundred"
                        <c:forEach items="${hashMap.billingsList}" var="item">
                        <c:if test="${item.num == 100}"> value="${item.price}"</c:if></c:forEach> id="priceHundred"></li>
                    </ul>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="ml60 pl10" id="container-year">
        <table class="mb50">
            <thead>
            <tr>
                <th width="218">标准名称</th>
                <th>设置(元/1年)</th>
            </tr>
            </thead>
            <tbody id="request_billings_year">
            <tr>
                <td>包年计费</td>
                <td>
                    <ul class="inline">
                        <li class="cell"><input type="text" name="priceYear"
                        <c:forEach items="${hashMap.billingsList}" var="item">
                        <c:if test="${item.num == 12}"> value="${item.price}"</c:if></c:forEach>id="priceYear" style="width: "></li>
                    </ul>
                </td>
            </tr>
            </tbody>
        </table>



        <div class="pb30">
            <p class="mb10"><label class="gray6"><input type="checkbox" class="agreement" id="chexkboxId">
                我已同意并阅读 <a href="" class="blue">《2226888协议》</a></label>
            </p>
            <button class="btn btn-red" id="submit_btn" onclick="chargingFunction()">提交发布</button>
        </div>
    </div>
</div>

