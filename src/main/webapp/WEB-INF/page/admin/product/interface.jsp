<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yongj
  Date: 7/17/2017
  Time: 2:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div hidden="hidden" class="container api">
    <div class="inline-form mb30">
        <div class="addon">接口名称</div>
        <div class="cell">
            <input type="text" class="input-ctrl" name="interfaceName" id="interface_name" value="${hashMap.productInterface.name}">
        </div>
        &nbsp;&nbsp;&nbsp;<div class="addon">appCode</div>
        <div class="cell">
            <input type="text" class="input-ctrl" name="appCode" id="app_code" value="${hashMap.productInterface.appCode}">
        </div>
    </div>

    <div class="inline-form mb30">
        <div class="addon">请求方式</div>
        <div class="cell">
            <select class="input-ctrl" name="requestMethod" id="request_method">
                <option value="post" <c:if test="${hashMap.productInterface.method eq 'post'}">selected="selected"</c:if>>POST</option>
                <option value="get" <c:if test="${hashMap.productInterface.method eq 'get'}">selected="selected"</c:if>>GET</option>
            </select>
        </div>
        <div class="addon">返回报文格式</div>
        <div class="cell vat">
            <select class="input-ctrl" name="responseFormat" id="response_format">
                <option value="json" <c:if test="${hashMap.productInterface.responseFormat eq 'json'}">selected="selected"</c:if>>JSON</option>
                <option value="xml" <c:if test="${hashMap.productInterface.responseFormat eq 'xml'}">selected="selected"</c:if>>XML</option>
            </select>
        </div>
    </div>

    <div class="inline-form mb30">
        <div class="addon">传输字符</div>
        <div class="cell">
            <select class="input-ctrl" name="character" id="character">
                <option value="UTF-8">UTF-8</option>
            </select>
        </div>
        <div class="addon">请求超时时长</div>
        <div class="cell">
            <input type="number" class="input-ctrl" name="timeout" id="time_out" value="${hashMap.productInterface.timeout}" max="10">
        </div>
    </div>
    <div class="inline-form mb30">
        <div class="addon">URL 地址</div>
        <div class="cell">
            <input type="text" class="input-ctrl" name="urlAddress" id="url_address" value="${hashMap.productInterface.url}">
        </div>
    </div>
    <p class="f16 gray6 mb10">请求参数（Headers）</p>
    <table class="mb50" id="Headers">
        <thead>
        <tr>
            <th width="145">名称</th>
            <th width="145">类型</th>
            <th width="157">是否必须</th>
            <th>描述</th>
            <th width="56"></th>
        </tr>
        </thead>
        <tbody id="request_headers">
        <c:if test="${not empty hashMap.productBaseInfo.id}">
            <c:forEach items="${hashMap.headersParamslist}" var="item">
                <tr>
                    <td><input type="text" class="input" value="${item.name}" placeholder="点击输入" name="headerName"></td>
                    <td>
                        <select name="headerType" class="input-ctrl">
                            <option value="String">String</option>
                        </select>
                    </td>
                    <td>
                        <select name="headerMust" class="input-ctrl">
                            <option value="1" <c:if test="${item.must eq 'true'}">selected="selected"</c:if>>必须</option>
                            <option value="0" <c:if test="${item.must eq 'false'}">selected="selected"</c:if>>非必须</option>
                        </select>
                    </td>
                    <td><input type="text" class="input" value="${item.description}" placeholder="点击输入" name="headerDesc"></td>
                    <td>
                        <button class="blue add-line deleteTr" onclick="delHeaders(this)">删除</button>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td><input type="text" class="input" value="" placeholder="点击输入" name="headerName"></td>
                <td>
                    <select name="headerType" class="input-ctrl">
                        <option value="String">String</option>
                    </select>
                </td>
                <td>
                    <select name="headerMust" class="input-ctrl">
                        <option value="1">必须</option>
                        <option value="0">非必须</option>
                    </select>
                </td>
                <td><input type="text" class="input" value="" placeholder="点击输入" name="headerDesc"></td>
                <td>
                    <button class="blue add-line add_header">新增</button>
                </td>
            </tr>
        </c:if>

        <c:if test="${empty hashMap.productBaseInfo.id}">
            <tr>
                <td><input type="text" class="input" value="" placeholder="点击输入" name="headerName"></td>
                <td>
                    <select name="headerType" class="input-ctrl">
                        <option value="String">String</option>
                    </select>
                </td>
                <td>
                    <select name="headerMust" class="input-ctrl">
                        <option value="1">必须</option>
                        <option value="0">非必须</option>
                    </select>
                </td>
                <td><input type="text" class="input" value="" placeholder="点击输入" name="headerDesc"></td>
                <td>
                    <button class="blue add-line add_header">新增</button>
                </td>
            </tr>
        </c:if>
        </tbody>
    </table>

    <p class="f16 gray6 mb10">请求参数（Query）</p>
    <table class="mb50" id="Querys">
        <thead>
        <tr>
            <th width="145">名称</th>
            <th width="145">类型</th>
            <th width="157">是否必须</th>
            <th>描述</th>
            <th width="56"></th>
        </tr>
        </thead>
        <tbody id="request_querys">
        <c:if test="${not empty hashMap.productBaseInfo.id}">
            <c:forEach items="${hashMap.queryParamslist}" var="item">
                <tr>
                    <td><input type="text" class="input" value="${item.name}" placeholder="点击输入" name="queryName"></td>
                    <td>
                        <select name="queryType" class="input-ctrl">
                            <option value="String">String</option>
                        </select>
                    </td>
                    <td>
                        <select name="queryMust" class="input-ctrl">
                            <option value="1" <c:if test="${item.must eq 'true'}">selected="selected"</c:if>>必须</option>
                            <option value="0" <c:if test="${item.must eq 'false'}">selected="selected"</c:if>>非必须</option>
                        </select>
                    </td>
                    <td><input type="text" class="input" value="${item.description}" placeholder="点击输入" name="queryDesc"></td>
                    <td>
                        <button class="blue add-line deleteTr" onclick="delHeaders(this)">删除</button>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td><input type="text" class="input" value="" placeholder="点击输入" name="queryName"></td>
                <td>
                    <select name="queryType" class="input-ctrl">
                        <option value="String">String</option>
                    </select>
                </td>
                <td>
                    <select name="queryMust" class="input-ctrl">
                        <option value="1">必须</option>
                        <option value="0">非必须</option>
                    </select>
                </td>
                <td><input type="text" class="input" value="" placeholder="点击输入" name="queryDesc"></td>
                <td>
                    <button class="blue add-line add_query">新增</button>
                </td>
            </tr>
        </c:if>

        <c:if test="${empty hashMap.productBaseInfo.id}">
            <tr>
                <td><input type="text" class="input" value="" placeholder="点击输入" name="queryName"></td>
                <td>
                    <select name="queryType" class="input-ctrl">
                        <option value="String">String</option>
                    </select>
                </td>
                <td>
                    <select name="queryMust" class="input-ctrl">
                        <option value="1">必须</option>
                        <option value="0">非必须</option>
                    </select>
                </td>
                <td><input type="text" class="input" value="" placeholder="点击输入" name="queryDesc"></td>
                <td>
                    <button class="blue add-line add_query">新增</button>
                </td>
            </tr>
        </c:if>
        </tbody>
    </table>

    <p class="f16 gray6 mb10">请求参数（Body）</p>
    <table class="mb50" id="Bodys">
        <thead>
        <tr>
            <th width="145">名称</th>
            <th width="145">类型</th>
            <th width="157">是否必须</th>
            <th>描述</th>
            <th width="56"></th>
        </tr>
        </thead>
        <tbody id="request_bodys">
        <c:if test="${not empty hashMap.productBaseInfo.id}">
            <c:forEach items="${hashMap.bodyParamslist}" var="item">
                <tr>
                    <td><input type="text" class="input" value="${item.name}" placeholder="点击输入" name="bodyName"></td>
                    <td>
                        <select name="bodyType" class="input-ctrl">
                            <option value="String">String</option>
                        </select>
                    </td>
                    <td>
                        <select name="bodyMust" class="input-ctrl">
                            <option value="1" <c:if test="${item.must eq 'true'}">selected="selected"</c:if>>必须</option>
                            <option value="0" <c:if test="${item.must eq 'false'}">selected="selected"</c:if>>非必须</option>
                        </select>
                    </td>
                    <td><input type="text" class="input" value="${item.description}" placeholder="点击输入" name="bodyDesc"></td>
                    <td>
                        <button class="blue add-line deleteTr" onclick="delHeaders(this)">删除</button>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td><input type="text" class="input" value="" placeholder="点击输入" name="bodyName"></td>
                <td>
                    <select name="bodyType" class="input-ctrl">
                        <option value="String">String</option>
                    </select>
                </td>
                <td>
                    <select name="bodyMust" class="input-ctrl">
                        <option value="1">必须</option>
                        <option value="0">非必须</option>
                    </select>
                </td>
                <td><input type="text" class="input" value="" placeholder="点击输入" name="bodyDesc"></td>
                <td>
                    <button class="blue add-line add_body">新增</button>
                </td>
            </tr>
        </c:if>

        <c:if test="${empty hashMap.productBaseInfo.id}">
            <tr>
                <td><input type="text" class="input" value="" placeholder="点击输入" name="bodyName"></td>
                <td>
                    <select name="bodyType" class="input-ctrl">
                        <option value="String">String</option>
                    </select>
                </td>
                <td>
                    <select name="bodyMust" class="input-ctrl">
                        <option value="1">必须</option>
                        <option value="0">非必须</option>
                    </select>
                </td>
                <td><input type="text" class="input" value="" placeholder="点击输入" name="bodyDesc"></td>
                <td>
                    <button class="blue add-line add_body">新增</button>
                </td>
            </tr>
        </c:if>
        </tbody>
    </table>

    <c:if test="${not empty hashMap.productBaseInfo.id}">
        <c:forEach items="${hashMap.interfaceSample}" var="item">
            <c:if test="${item.type eq 'INPUT'}">
                <p class="f16 gray6 mb10">请求示例</p>
                <textarea rows="10" class="input-ctrl mb30" name="requestSample" id="request_sample">${item.value}</textarea>
            </c:if>
            <c:if test="${item.type eq 'OUTPUT_SUCCESS' }">
                <p class="f16 gray6 mb10">正常返回示例</p>
                <textarea rows="10" class="input-ctrl mb30" name="normalSample" id="normal_sample">${item.value}</textarea>
            </c:if>
            <c:if test="${item.type eq 'OUTPUT_FAIL' }">
                <p class="f16 gray6 mb10">错误返回示例</p>
                <textarea rows="10" class="input-ctrl mb30" name="errorSample" id="error_sample">${item.value}</textarea>
            </c:if>
        </c:forEach>
    </c:if>
    
     <c:if test="${empty hashMap.productBaseInfo.id}">
        <p class="f16 gray6 mb10">请求示例</p>
        <textarea rows="10" class="input-ctrl mb30" name="requestSample" id="request_sample"></textarea>

        <p class="f16 gray6 mb10">正常返回示例</p>
        <textarea rows="10" class="input-ctrl mb30" name="normalSample" id="normal_sample"></textarea>

        <p class="f16 gray6 mb10">错误返回示例</p>
        <textarea rows="10" class="input-ctrl mb30" name="errorSample" id="error_sample"></textarea>
     </c:if>
    
    <p class="f16 gray6 mb10">错误码定义</p>
    <table class="mb50" id="codes">
        <thead>
        <tr>
            <th width="218">错误码</th>
            <th width="218">状态码名称</th>
            <th>描述</th>
            <th width="56"></th>
        </tr>
        </thead>
        <tbody id="request_codes">

        <c:if test="${not empty hashMap.productBaseInfo.id}">
            <c:forEach items="${hashMap.interfaceCodeList}" var="item">
                <tr>
                    <td><input type="text" class="input" value="${item.code}" placeholder="点击输入" name="code"></td>
                    <td><input type="text" class="input" value="${item.name}" placeholder="点击输入" name="codeName"></td>
                    <td><input type="text" class="input" value="${item.desc}" placeholder="点击输入" name="codeDesc"></td>
                    <td>
                        <button class="blue add-line deleteTr" onclick="delHeaders(this)">删除</button>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td><input type="text" class="input" value="" placeholder="点击输入" name="code"></td>
                <td><input type="text" class="input" value="" placeholder="点击输入" name="codeName"></td>
                <td><input type="text" class="input" value="" placeholder="点击输入" name="codeDesc"></td>
                <td>
                    <button class="blue add-line add_code">新增</button>
                </td>
            </tr>
        </c:if>

        <c:if test="${empty hashMap.productBaseInfo.id}">
            <tr>
                <td><input type="text" class="input" value="" placeholder="点击输入" name="code"></td>
                <td><input type="text" class="input" value="" placeholder="点击输入" name="codeName"></td>
                <td><input type="text" class="input" value="" placeholder="点击输入" name="codeDesc"></td>
                <td>
                    <button class="blue add-line add_code">新增</button>
                </td>
            </tr>
        </c:if>

        </tbody>
    </table>

    <div class="pt30 pb30">
        <input type="button" class="btn btn-red" value="下一步"
               onclick="examineData(desc);">
    </div>
</div>

