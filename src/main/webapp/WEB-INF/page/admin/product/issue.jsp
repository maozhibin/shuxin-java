<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%--
  Created by IntelliJ IDEA.
  User: yongj
  Date: 7/15/2017
  Time: 2:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
            + "/";
%>
<html>
<head>
    <title>产品发布</title>

    <link href='/static/css/style.css?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>' rel="stylesheet" type="text/css"/>
    <link href='/static/css/market.css?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>' rel="stylesheet" type="text/css"/>
    <link href='/static/css/style_other.css?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>' rel="stylesheet" type="text/css"/>
    <link href='/static/css/data.css?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>' rel="stylesheet" type="text/css"/>
    <link href='/static/css/jquery.tagsinput.css?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>' rel="stylesheet" type="text/css"/>

    <link href='/static/admin/css/data-release.css?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>' rel="stylesheet" type="text/css"/>

    <script src='/static/js/jquery.tagsinput.js?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>'></script>
    <script src='/static/js/jquery.ajaxfileupload.js?_=<%@include file="/WEB-INF/public/static/ver/.ver"%>'></script>

    <script>
        $(function () {
            var product_class = $("#product_class");
            if (product_class.val() != undefined && product_class.val() != '') {
                getProductClass(product_class.val())
            }

            product_class.change(function () {
                getProductClass(product_class.val())
            });

            function getProductClass(product_class_id) {
                var data = {};
                request("admin/product/product_base/" + product_class_id, data, function (r) {
                    var product_base = $("#product_base");
                    product_base.empty();
                    for (var key in r) {
                        product_base.append("<option value='" + key + "'>" + r[key] + "</option>")
                    }
                });
            }

            var pid = $("#pid");
            if (pid.val() != undefined) {
                getArea(pid.val())
            }

            pid.change(function () {
                getArea(pid.val())
            });

            function getArea(pid) {
                var data = {};
                request("admin/product/area/" + pid, data, function (r) {
                    var area_id = $("#area_id");
                    area_id.empty();
                    for (var key in r) {
                        area_id.append("<option value='" + key + "'>" + r[key] + "</option>")
                    }
                });
            }

            $("#submit").click(function () {
                $(window).off("beforeunload");
            });


            //input tags
            var product_tags = $("#product_tags");
            product_tags.tagsInput({
                width: "auto",
                defaultText: "添加标签"
            })
        });

        //        //未保存提示
        //        $(window).on("beforeunload", function () {
        //            return "are you sure?"
        //        });
    </script>
</head>
<body>

<script>
    function goto(tab) {
        $('.container').attr('hidden', 'hidden');
        $('.container.' + tab).removeAttr('hidden');
        $('.tab').removeClass('active');
        $('.tab.' + tab).addClass('active');
        scroll(0, 0);
    }
</script>

<div class="release-tabs" >
    <div class="tabs">
        <a onclick=" " class="tab base active">基础设置</a>
        <a onclick=" " class="tab api">接口设置</a>
        <a onclick=" " class="tab desc">产品描述</a>
        <a onclick=" " class="tab price">计费设置</a>
        <%--<a onclick="goto('base')" class="tab base active">基础设置</a>
        <a onclick="goto('api')" class="tab api">接口设置</a>
        <a onclick="goto('desc')" class="tab desc">产品描述</a>
        <a onclick="goto('price')" class="tab price">计费设置</a>--%>
     </div>
     	<input type="hidden" class="input-ctrl" name="productId" id="productId" value="${hashMap.productBaseInfo.id}">
     	<input type="hidden" class="input-ctrl" name="areaId" id="areaId" value="${hashMap.productBaseInfo.areaId}">

    <%@include file="base.jsp"%>

    <%@include file="interface.jsp"%>

    <%@include file="description.jsp"%>

    <%@include file="fee.jsp"%>
</div>

<script type="text/javascript">
    $(document).ready(function(){
        var classValue=$('#product_class').val();
        $.ajax({
            type: "GET",
            url: "/admin/product/base?id="+classValue,
            dataType: "json",
            success: function(data){
                $("#product_base").html('');
                var option="";
                for(var i=0;i<data.length;i++){
                    option+="<option value='"+data[i].id+"'>"+data[i].name+"</option>";
                }
                $("#product_base").append(option);
            }

        });
    });

	$('#product_class').change(function(){
		var classValue=$('#product_class').val();
	    $.ajax({
	        type: "GET",
	        url: "/admin/product/base?id="+classValue,
	        dataType: "json",
	        success: function(data){
	        		$("#product_base").html('');
                    var option="";
	        		for(var i=0;i<data.length;i++){
	        			option+="<option value='"+data[i].id+"'>"+data[i].name+"</option>";
	        		}
	        		$("#product_base").append(option);
	         }

	    });
	});

	var productId = $('#productId').val();
	 $(document).ready(function(){
		 var pidValue=$('#province').val();
		    $.ajax({
		        type: "GET",
		        url: "/admin/area/city?pid="+pidValue,
		        dataType: "json",
		        success: function(data){
		        		$("#city").html('');
	                    var option="";
		        		for(var i=0;i<data.length;i++){
		        			option+="<option value='"+data[i].id+"'>"+data[i].name+"</option>";
		        		}

		      			$("#city").append(option);
		      			//当是进行修改时显示原来的区域
		        		var areaId = $('#areaId').val();
		      			if(productId!==''){
		      				$('#city').val(areaId);
		      			}
		         }

		    });

		    //请求参数（Headers）
		    $('#request_headers').on("click","button.add_header",function(){
		    	var tr = $(this).parents('tr');
		    	var td1 =tr.children().eq(0).find(".input").val();
		    	var td4 =tr.children().eq(3).find(".input").val();
		    	if(td1.length<=0){
		    		alert("参数名称不能为空");
		    		return;
		    	}
		    	if(td4.length<=0){
		    		alert("参数描述不能为空");
		    		return;
		    	}
		    	var row=$(tr).html();
                $('#request_headers').append("<tr>"+row+"</tr>");
                $(this).removeClass("add_header").addClass("deleteTr").text("删除").attr("onclick","delHeaders(this)");
		    });

		    //请求参数（Query）
		    $('#request_querys').on("click","button.add_query",function(){
		    	var tr = $(this).parents('tr');
		    	var td1 =tr.children().eq(0).find(".input").val();
		    	var td4 =tr.children().eq(3).find(".input").val();
		    	if(td1.length<=0){
		    		alert("参数名称不能为空");
		    		return;
		    	}
		    	if(td4.length<=0){
		    		alert("参数描述不能为空");
		    		return;
		    	}
		    	var row=$(tr).html();
                $('#request_querys').append("<tr>"+row+"</tr>");
                $(this).removeClass("add_query").addClass("deleteTr").text("删除").attr("onclick","delHeaders(this)");
		    });

		    //请求参数（Body）
		    $('#request_bodys').on("click","button.add_body",function(){
		    	var tr = $(this).parents('tr');
		    	var td1 =tr.children().eq(0).find(".input").val();
		    	var td4 =tr.children().eq(3).find(".input").val();
		    	if(td1.length<=0){
		    		alert("参数名称不能为空");
		    		return;
		    	}
		    	if(td4.length<=0){
		    		alert("参数描述不能为空");
		    		return;
		    	}
		    	var row=$(tr).html();
                $('#request_bodys').append("<tr>"+row+"</tr>");
                $(this).removeClass("add_body").addClass("deleteTr").text("删除").attr("onclick","delHeaders(this)");
		    });

		    //错误码定义
		    $('#request_codes').on("click","button.add_code",function(){
		    	var tr = $(this).parents('tr');
		    	var td1 =tr.children().eq(0).find(".input").val();
		    	var td2 =tr.children().eq(1).find(".input").val();
		    	var td3 =tr.children().eq(2).find(".input").val();
		    	if(td1.length<=0){
		    		alert("错误码不能为空");
		    		return;
		    	}
		    	if(td2.length<=0){
		    		alert("状态码名称不能为空");
		    		return;
		    	}
		    	if(td3.length<=0){
		    		alert("描述不能为空");
		    		return;
		    	}
		    	var row=$(tr).html();
                $('#request_codes').append("<tr>"+row+"</tr>");
                $(this).removeClass("add_code").addClass("deleteTr").text("删除").attr("onclick","delHeaders(this)");
		    });


	    });

	$('#province').change(function(){
		var pidValue=$('#province').val();
	    $.ajax({
	        type: "GET",
	        url: "/admin/area/city?pid="+pidValue,
	        dataType: "json",
	        success: function(data){
	        		$("#city").html('');
                    var option="";
	        		for(var i=0;i<data.length;i++){
	        			option+="<option value='"+data[i].id+"'>"+data[i].name+"</option>";
	        		}
	        		$("#city").append(option);
	         }

	    });
	});

	function myfunction(){
		var str = {};
		var productName=$('#product_name').val();//产品名
		var frequent=$('#frequent').val();//更新频率
		var productClass=$('#product_class').val();//产品类型
		var productBase=$('#product_base').val();//产品子类型
		var productType=$('#product_type').val();//数据类型
		var city=$('#city').val();//区域
		var userName=$('#user_name').val();//发布人
		var productDescription=$('#product_description').val();//数据简介
		var interfaceName=$('#interface_name').val();//接口名称
		var appCode=$('#app_code').val();//appCode
		var urlAddress=$('#url_address').val();//服务地址
		var requestMethod=$('#request_method').val();//请求方式
		var responseFormat=$('#response_format').val();//返回报文格式
		var character=$('#character').val();//字符类型
		var timeout=$('#time_out').val();//请求超时
		var requestSample=$('#request_sample').val();//请求实例
		var normalSample=$('#normal_sample').val();//正常返回
		var errorSample=$('#error_sample').val();//错误提示
		var intro=$('#intro').val();//产品介绍
		var highlight=$('#highlight').val();//产品亮点
		var service=$('#service').val();//售后服务
		str.productName=productName;
		str.frequent=frequent;
		str.productClass=productClass;
		str.productBase=productBase;
		str.productType=productType;
		str.city=city;
		str.userName=userName;
		str.productDescription=productDescription;
		str.interfaceName=interfaceName;
		str.appCode=appCode;
		str.urlAddress=urlAddress;
		str.requestMethod=requestMethod;
		str.responseFormat=responseFormat;
		str.character=character;
		str.timeout=timeout;
		str.requestSample=requestSample;
		str.normalSample=normalSample;
		str.errorSample=errorSample;
		str.intro=intro;
		str.highlight=highlight;
		str.service=service;


		//对请求参数的操作
		var headersArray=new Array();
		var headerList = $("#request_headers").children("tr")
			for (var i=0;i<headerList.length-1;i++) {
				var headers=[];
				var tdArr = headerList.eq(i).find("td");
				var headerName = tdArr.eq(0).find("input").val();
				var headerType = tdArr.eq(1).find("select").val();
				var headerMust = tdArr.eq(2).find("select").val();
				var headerDesc = tdArr.eq(3).find("input").val();
				headers.push(headerName)
				headers.push(headerType)
				headers.push(headerMust)
				headers.push(headerDesc)
				headersArray.push(headers);
				str.headersArray=headersArray;
			}

		var querysArray=new Array();;
		var queryList = $("#request_querys").children("tr")
			for (var i=0;i<queryList.length-1;i++) {
				var query = [];
				var tdArr = queryList.eq(i).find("td");
				var queryName = tdArr.eq(0).find("input").val();
				var queryType = tdArr.eq(1).find("select").val();
				var queryMust = tdArr.eq(2).find("select").val();
				var queryDesc = tdArr.eq(3).find("input").val();
				query.push(queryName)
				query.push(queryType)
				query.push(queryMust)
				query.push(queryDesc)
				querysArray.push(query);
				str.querysArray=querysArray;
		}

		var bodysArrays=new Array();
		var bodyList = $("#request_bodys").children("tr")
			for (var i=0;i<bodyList.length-1;i++) {
				var body = [];
				var tdArr = bodyList.eq(i).find("td");
				var bodyName = tdArr.eq(0).find("input").val();
				var bodyType = tdArr.eq(1).find("select").val();
				var bodyMust = tdArr.eq(2).find("select").val();
				var bodyDesc = tdArr.eq(3).find("input").val();
				body.push(bodyName)
				body.push(bodyType)
				body.push(bodyMust)
				body.push(bodyDesc)
				bodysArrays.push(body);
				str.bodysArrays=bodysArrays;
		}

		var codesArrays=new Array();
		var codeList = $("#request_codes").children("tr")
			for (var i=0;i<codeList.length-1;i++) {
				var codet = [];
				var tdArr = codeList.eq(i).find("td");
				var code = tdArr.eq(0).find("input").val();
				var codeName = tdArr.eq(1).find("input").val();
				var codeDesc = tdArr.eq(2).find("input").val();
				codet.push(code);
				codet.push(codeName);
				codet.push(codeDesc);
				codesArrays.push(codet);
				str.codesArrays=codesArrays;
		}


		var priceOne=$('#priceOne').val();//一次收费
		var priceHundred=$('#priceHundred').val();//100次收费
		var priceYear=$('#priceYear').val();//1年收费
		str.priceOne=priceOne;
		str.priceHundred=priceHundred;
		str.priceYear=priceYear;

		var productTags=$('#productTags').val();//标签
		var tags = new Array();
		tag=productTags.trim().split(","); //字符分割
		console.log(tag);
		tags.push(tag);
		str.tags = tags;

		var data = JSON.stringify(str);
		var productId = $('#productId').val();
		$.ajax({
	            type: "post",
	            cache: false,
	            datatype:"json",
	            url: "/admin/product/updateOrAdd?id="+productId,
	            data:{data:data},
	            success: function(d){
	    		    	 if(d.code==1){
	    		    	      alert(d.result);
	    		    	   }else{
	    		    		  window.location.href="/admin/product/list";
	    		    	   }
	    			}
	       });

	}

	function apiFunction(){//基础设置检查
		var product_name=$('#product_name').val();
		var product_description=$('#product_description').val();
		var productTags=$('#productTags').val();
		product_name_value=product_name.replace(/\n/g,'');
		product_description_value=product_description.replace(/\n/g,'');
		productTags_value=productTags.replace(/\n/g,'');
		if(javaTrim(product_name_value)==""){
			alert("请输入数据名称");
			return;
		}
		if(javaTrim(product_description_value)==""){
			alert("请输入数据简介");
			return;
		}
		if(javaTrim(productTags_value)==""){
			alert("请输入标签设置");
			return;
		}

		goto('api')
	}

	function descFunction(){//接口设置判断
		var interface_name=$('#interface_name').val();
		var url_address=$('#url_address').val();
		var request_sample=$('#request_sample').val();
		var normal_sample=$('#normal_sample').val();
		var error_sample=$('#error_sample').val();
		var app_code = $('#app_code').val();
		var time_out=$('#time_out').val();//请求超时

		interface_name_value=interface_name.replace(/\n/g,'');
		url_address_value=url_address.replace(/\n/g,'');
		request_sample_value=request_sample.replace(/\n/g,'');
		normal_sample_value=normal_sample.replace(/\n/g,'');
		error_sample_value=error_sample.replace(/\n/g,'');
		app_code_value=app_code.replace(/\n/g,'');
		if(javaTrim(interface_name_value)==""){
			alert("请输入接口名称");
			return;
		}
		if(javaTrim(app_code_value)==""){
			alert("请输入appCode");
			return;
		}
		if(!/^[0-9]+$/.test(time_out.trim()) || time_out.length > 10){
			alert("请输入正确的请求超时时长时间");
			return;
		}
		if(javaTrim(url_address_value)==""){
			alert("请输入服务地址");
			return;
		}
		var  rownum =$("#Headers tr").length
		if(rownum < 3){
			alert("至少输入一个请求参数(Headers)");
			return;
		}

		var  rownum =$("#Querys tr").length
		if(rownum < 3){
			alert("至少输入一个请求参数(Querys)");
			return;
		}

		var  rownum =$("#Bodys tr").length
		if(rownum < 3){
			alert("至少输入一个请求参数(Bodys)");
			return;
		}


		if(javaTrim(request_sample_value)==""){
			alert("请输入请求实例");
			return;
		}
		if(javaTrim(normal_sample_value)==""){
			alert("请输入正常返回示例");
			return;
		}
		if(javaTrim(error_sample_value)==""){
			alert("请输入错误返回实例");
			return;
		}

		var  rownum =$("#codes tr").length
		if(rownum < 3){
			alert("至少输入一个请求参数(codes)");
			return;
		}

		goto('desc');
	}

	function priceFunction(){//产品描述判断
		var intro=$('#intro').val();
		var highlight=$('#highlight').val();
		//var snapshot=$('#snapshot').val();//产品截图
		var service=$('#service').val();
		intro_value=intro.replace(/\n/g,'');
		highlight_value=highlight.replace(/\n/g,'');
		service_value=service.replace(/\n/g,'');
		if(javaTrim(intro_value)==""){
			alert("请输入产品介绍");
			return;
		}
		if(javaTrim(highlight_value)==""){
			alert("请输入产品亮点");
			return;
		}
		if(javaTrim(service_value)==""){
			alert("请输入售后服务");
			return;
		}
		goto('price')
	}

	function chargingFunction(){//计费设置判断
		var priceOne=$('#priceOne').val();
		var priceHundred=$('#priceHundred').val();
		var priceYear=$('#priceYear').val();
		var reg=/^[-\+]?\d+(\.\d+)?$/;

		priceOne_value=priceOne.replace(/\n/g,'');
		priceHundred_value=priceHundred.replace(/\n/g,'');
		priceYear_value=priceYear.replace(/\n/g,'');
		if(javaTrim(priceOne_value)==""){
			alert("单次费用必须填写");
			return;
		}
		if(javaTrim(priceOne_value)!=""){
			if(!reg.test(priceOne) || priceOne.length >7){
				alert("请输入正确的单次计费价格");
				return;
			}
		}
		if(javaTrim(priceHundred_value)!=""){
			if(!reg.test(priceHundred) || priceHundred.length >7){
				alert("请输入正确的多次计费价格");
				return;
			}
		}

		if(javaTrim(priceYear_value)!=""){
			if(!reg.test(priceYear) || priceYear.length >7){
				alert("请输入正确的包年计费价格");
				return;
			}
		}
		if(document.getElementById("chexkboxId").checked == false){
			alert("请认真阅读协议并同意");
			return;
		}
		myfunction();
	}

	 function javaTrim(str) {//判断输入的是否为空
	     for (var i=0; (str.charAt(i)==' ') && i<str.length; i++);
	     if (i == str.length) return ''; //whole string is space
	     var newstr = str.substr(i);
	     for (var i=newstr.length-1; newstr.charAt(i)==' ' && i>=0; i--);
	     newstr = newstr.substr(0,i+1);
	     return newstr;
	}

	function delHeaders(obj)//点击事件那边需要加this
	{
		var tr=obj.parentNode.parentNode;
		var tbody=tr.parentNode;
		tbody.removeChild(tr);
	}
</script>
<script>
    <!--文件上传-->
    $("#upload").AjaxFileUpload({
        action: '/admin/upload/logo',
        onComplete: function (filename, response) {
            if (response.error != null) {
                alert(response.error + "请重新选择");
            } else {
                var url = base_url + response.imgUrl;
                $("#logo").val(url);
                $(this).parents(".cell").addClass('hide');
                $("#close").removeClass('hide');
                $("#img").removeClass('hide').attr("src", url).attr("width", 96).attr("height", 96).attr('alt', filename);
            }
        }
    });
    $("#img").click(function () {
        $("#upload").trigger("click");
    });
    $("#close").click(function () {
        $(this).addClass('hide').prevAll('img').removeAttr('src width height alt').addClass('hide').prevAll('.cell').removeClass('hide');
        $("#upload").val("");
    });
</script>
<script>
    //查找box元素,检测当粘贴时候,
    document.querySelector('#snapshot').addEventListener('paste', function (e) {

        //判断是否是粘贴图片
        if (e.clipboardData && e.clipboardData.items[0].type.indexOf('image') > -1) {
            var that = this,
                reader = new FileReader();
            file = e.clipboardData.items[0].getAsFile();

            //ajax上传图片
            reader.onload = function (e) {
                var xhr = new XMLHttpRequest(),
                    fd = new FormData();

                xhr.open('POST', '/admin/upload/imageBase64', true);
                xhr.onload = function () {
                    var img = new Image();
                    img.src = base_url + xhr.responseText;

                    //todo 记录返回的图片地址
                    // that.innerHTML = '<img src="'+img.src+'" alt=""/>';
                    document.getElementById("img_puth").value = img.src;
                }

                // this.result得到图片的base64 (可以用作即时显示)
                fd.append('file', this.result);
                that.innerHTML = '<img src="' + this.result + '" alt=""/>';
                xhr.send(fd);
            }
            reader.readAsDataURL(file);
        }
    }, false);
</script>
</body>
</html>
