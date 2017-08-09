$(document).ready(function(){
	var imgLength=$('.f-imgshow').length;
	$("#all").text(imgLength);
	$("#num").text(6-imgLength);
    /*tab 跳转函数*/
    function goto(tab) {
        $('.container').attr('hidden', 'hidden');
        $('.container.' + tab).removeAttr('hidden');
        $('.tab').removeClass('active');
        $('.tab.' + tab).addClass('active');
        scroll(0, 0);
    }
    /*数据加载*/
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
        $('#product_class').change(function(){
            var classValue=$('#product_class').find('option:selected').val();
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
    /* END* select数据加载 *END*/

    /*数据填写*/
    $(".input-ctrl").blur(function () {
        //失焦
        if(!$(this).val()){
            $(this).attr('placeholder','请填写！').addClass('animation');
        }
    }).focus(function () {
        $(this).removeClass('animation').attr('placeholder','').css('border-color','');
    });
    //请求时常 填写
    $("#time_out").blur(function () {
        if($(this).val().length>10||$(this).val().split('.').length>2||!$(this).val()){
            $(this).addClass('animation').val('').attr('placeholder','请输入10位长度的数字');
        }else{
            var timeVal=$(this).val().split('.');
            if(!(timeVal.length>2)&&!(timeVal.length==1)){
                if(timeVal[1].length>2){
                    console.log(timeVal[1]);
                    $(this).addClass('animation').val('').attr('placeholder','数字要求小数点后最多2位');
                }
            }
        }
    });

    /*下一步 button*/
    $('input[value="下一步"]').click(function () {
        var dataUrl =$(this).attr('data-url');
        examineData(dataUrl);
    });
    /*下一步按钮 ：如果从必选项里移除且输入为空，则跳转失败*/
    function examineData(tab){
        if(tab == 'api'){
            for(var l=0;l<$('.base').find('.input-ctrl').length;l++){
                if($('.base').find(".input-ctrl").eq(l).is('.animation')){
                    $('.base').find('.animation').attr('placeholder','').css('border-color','red').focus();
                    return ;
                }
            }
            apiFunction();
            goto(tab);
        }else if(tab == 'desc'){
            for(var m=0;m<$('.api').find('.input-ctrl').length;m++){
                if($('.api').find('.input-ctrl').eq(m).is('.animation')){
                    $('.api').find('.animation').attr('placeholder','').css('border-color','red').focus();
                    return ;
                }
            }
            descFunction();
            goto(tab);
        }else{
            for(var n=0;n<$('.desc').find('.input-ctrl').length;n++){
                if($('.desc').find('.input-ctrl').eq(n).is('.animation')){
                    $('.desc').find('.animation').attr('placeholder','').css('border-color','red').focus();
                    return ;
                }
            }
            priceFunction();
            goto(tab);
        }

    }
    /*提交发布*/
    $('#submit_btn').click(function () {
        chargingFunction();
    });
    /*增加按钮*/
    $('tbody').on("click",".add-line",function(){
        console.log('2323');
        var tr = $(this).parents('tr');
        var row=$(tr).html();
        $(this).parents('tbody').append("<tr>"+row+"</tr>");
        $(this).removeClass("add_query").addClass("deleteTr").removeClass('add-line add_header').text("删除");
    });
    /*删除按钮*/
    $('tbody').on("click",".deleteTr",function(){
        //点击事件那边需要加this
        var tr=$(this).parents('tr');
        console.log(tr);
        console.log($(this).parents('tbody').children('tr'));
        tr.empty();
        $(this).parents('tbody').remove(tr);
    });

    //请求参数如果必选，则input必须都不能为空
    $('tbody').on("blur","input[name='headerDesc'],input[name='queryDesc'],input[name='bodyDesc']",function(){
        console.log('567rtghdfg');
        var tr = $(this).parents('tr');
        var tdName =tr.children().eq(0).find(".input");
        var headerSelect =tr.children().eq(2).find("select").val();
        if(headerSelect == 1){
            // 必选时
            console.log($(this).val());
            if (!$(this).val()){ //描述为空
                $(this).attr('placeholder','请填写！').addClass('animation');
            }else{
                if(!$(tdName).val()){
                    console.log($(tdName).val());
                    // 名称为空
                    $(tdName).attr('placeholder','请填写！').addClass('animation');
                }
            }
        }
    }).on('focus','input.animation',function () {
        $(this).removeClass('animation').attr('placeholder','');
    });
    //错误码定义 必填
    $('#request_codes').on('blur','input',function () {
        if (!$(this).val()){ //描述为空
            $(this).attr('placeholder','请填写！').addClass('animation');
        }
    }).on('focus','input.animation',function () {
        $(this).removeClass('animation').attr('placeholder','');
    });

    //请求参数 三选一必填
    function queryParam(){
        /*请求头*/
        var headersBln;
        var headersSelect=$('#request_headers').find('select');
        for (var i=0;i<headersSelect.length;i++){
            if(!headersSelect[i].val()){
                headersBln=false;
            }else{
                headersBln=mustSelect(headersSelect);
            }
        }
        /*请求参数*/
        var paramBln;
        var paramSelect=$('#request_querys').find('select');
        for (var i=0;i<paramSelect.length;i++){
            if(!paramSelect[i].val()){
                paramBln=false;
            }else{
                paramBln=mustSelect(paramSelect);
            }
        }
        /*请求体*/
        var bodyBln;
        var bodySelect=$('#request_bodys').find('select');
        for (var i=0;i<bodySelect.length;i++){
            if(!bodySelect[i].val()){
                bodyBln=false;
            }else{
                bodyBln=mustSelect(bodySelect);
            }
        }
        if(!headersBln&&!paramBln&&!bodyBln){
            alert('请求参数必须填一个');
        }
    }
    //select为必选，则两端的值不能为空
    function mustSelect($select){
        if($select == 1){
            var inputName=$select.parents('tr').find('input').eq(0).val();
            var inputDesc=$select.parents('tr').find('input').eq(1).val();
            if(!inputDesc || !inputName){
                $select.parents('tr').find('input').eq(0).addClass('animation');
                $select.parents('tr').find('input').eq(1).addClass('animation');
                return false;
            }else if(inputName&&inputDesc){
                return inputName+','+$select.val()+','+inputDesc;
            }
        }
    }

    //请求参数（Query）
    // $('#request_querys').on("click","button.add_query",function(){
    //     var tr = $(this).parents('tr');
    //     var td1 =tr.children().eq(0).find(".input").val();
    //     var td4 =tr.children().eq(3).find(".input").val();
    //     if(td1.length<=0){
    //         alert("参数名称不能为空");
    //         return;
    //     }
    //     if(td4.length<=0){
    //         alert("参数描述不能为空");
    //         return;
    //     }
    //     var row=$(tr).html();
    //     $('#request_querys').append("<tr>"+row+"</tr>");
    //     $(this).removeClass("add_query").addClass("deleteTr").text("删除").attr("onclick","delHeaders(this)");
    // });
    //请求参数（Body）
    // $('#request_bodys').on("click","button.add_body",function(){
    //     var tr = $(this).parents('tr');
    //     var td1 =tr.children().eq(0).find(".input").val();
    //     var td4 =tr.children().eq(3).find(".input").val();
    //     if(td1.length<=0){
    //         alert("参数名称不能为空");
    //         return;
    //     }
    //     if(td4.length<=0){
    //         alert("参数描述不能为空");
    //         return;
    //     }
    //     var row=$(tr).html();
    //     $('#request_bodys').append("<tr>"+row+"</tr>");
    //     $(this).removeClass("add_body").addClass("deleteTr").text("删除").attr("onclick","delHeaders(this)");
    // });
    //错误码定义
    // $('#request_codes').on("click","button.add_code",function(){
    //     var tr = $(this).parents('tr');
    //     var td1 =tr.children().eq(0).find(".input").val();
    //     var td2 =tr.children().eq(1).find(".input").val();
    //     var td3 =tr.children().eq(2).find(".input").val();
    //     if(td1.length<=0){
    //         alert("错误码不能为空");
    //         return;
    //     }
    //     if(td2.length<=0){
    //         alert("状态码名称不能为空");
    //         return;
    //     }
    //     if(td3.length<=0){
    //         alert("描述不能为空");
    //         return;
    //     }
    //     var row=$(tr).html();
    //     $('#request_codes').append("<tr>"+row+"</tr>");
    //     $(this).removeClass("add_code").addClass("deleteTr").text("删除").attr("onclick","delHeaders(this)");
    // });



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
        if(!update()){
            return ;
        }

        var productName=$('#product_name').val();//产品名
        var frequent=$('#frequent').val();//更新频率
        var productClass=$('#product_class').val();//产品类型
        var productBase=$('#product_base').val();//产品子类型
        var productType=$('#product_type').val();//数据类型
        var city=$('#city').val();//区域
        var userName=$('#user_name').val();//发布人
        var productDescription=$('#product_description').val();//数据简介
        var icon = $('#logo').attr('src');//图片logo
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
        /*产品截图*/
        var imgs=[];
        for(var o=0;o<$('.f-imgshow').find('img').length;o++){
            imgs.push($('.f-imgshow').find('img').eq(o).attr('src'));
        }
        console.log(imgs);
        if(!icon){
            goto('base');
            $('#icon').addClass('animation');
        }else if(imgs.length<1){
            goto('desc');
            $('#inResult').addClass('animation');
        }

        str.imgs=imgs;
        str.productName=productName;
        str.frequent=frequent;
        str.productClass=productClass;
        str.productBase=productBase;
        str.productType=productType;
        str.city=city;
        str.userName=userName;
        str.productDescription=productDescription;
        str.icon = icon;
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
        var headerList = $("#request_headers").children("tr");
        for (var i=0;i<headerList.length-1;i++) {
            var headers=[];
            var tdArr = headerList.eq(i).find("td");
            var headerName = tdArr.eq(0).find("input").val();
            var headerType = tdArr.eq(1).find("select").val();
            var headerMust = tdArr.eq(2).find("select").val();
            var headerDesc = tdArr.eq(3).find("input").val();
            headers.push(headerName);
            headers.push(headerType);
            headers.push(headerMust);
            headers.push(headerDesc);
            headersArray.push(headers);
            str.headersArray=headersArray;
        }

        var querysArray=new Array();
        var queryList = $("#request_querys").children("tr");
        for (var i=0;i<queryList.length-1;i++) {
            var query = [];
            var tdArr = queryList.eq(i).find("td");
            var queryName = tdArr.eq(0).find("input").val();
            var queryType = tdArr.eq(1).find("select").val();
            var queryMust = tdArr.eq(2).find("select").val();
            var queryDesc = tdArr.eq(3).find("input").val();
            query.push(queryName);
            query.push(queryType);
            query.push(queryMust);
            query.push(queryDesc);
            querysArray.push(query);
            str.querysArray=querysArray;
        }

        var bodysArrays=new Array();
        var bodyList = $("#request_bodys").children("tr");
        for (var i=0;i<bodyList.length-1;i++) {
            var body = [];
            var tdArr = bodyList.eq(i).find("td");
            var bodyName = tdArr.eq(0).find("input").val();
            var bodyType = tdArr.eq(1).find("select").val();
            var bodyMust = tdArr.eq(2).find("select").val();
            var bodyDesc = tdArr.eq(3).find("input").val();
            body.push(bodyName);
            body.push(bodyType);
            body.push(bodyMust);
            body.push(bodyDesc);
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
                if(d.code==0){
                    alert(d.result);
                }else{
                    window.location.href="/admin/product/list";
                }
            }
        });

    }

    var base={},api={},desc={};
    function apiFunction(){//基础设置检查
        base.product_name=$('#product_name').val();
        base.product_description=$('#product_description').val();
        base.productTags=$('#productTags').val();
        base.imgBtn==$('#imgBtn').find('img');
    }
    function descFunction(){//接口设置判断
        var request_sample_value=trim($('#request_sample').val()),//请求示例
        normal_sample_value=trim($('#normal_sample').val()),//正常返回示例
        error_sample_value=trim($('#error_sample').val());//错误返回示例

        api.interface_name=trim($('#interface_name').val());//接口名称
        api.app_code=trim($('#app_code').val());//appCode
        api.time_out=trim($('#time_out').val());//请求超时时长
        api.url_address=trim($('#url_address').val());//URL 地址

        var  headerRow =$("#request_headers").find('tr').length;
        if(headerRow < 2){
            // alert("至少输入一个请求参数(Headers)");
            api.request_headers=false;
        }else{
            api.request_headers=true;
            $('#request_headers').removeClass('animation');
        }

        var  queryRow =$("#request_querys").find('tr').length;
        if(queryRow < 2){
            api.request_querys=false;
        }else{
            api.request_querys=true;
            $('#request_querys').removeClass('animation');
        }

        var  bodyRow =$("#request_bodys").find('tr').length;
        if(bodyRow < 2){
            api.request_bodys=false;
        }else{
            api.request_bodys=true;
            $('#request_bodys').removeClass('animation');
        }


        if(request_sample_value==""){
            api.request_sample=false;
        }else {
            api.request_sample=true;
            $('#request_sample').removeClass('animation');
        }
        if(normal_sample_value==""){
            api.normal_sample=false;
        }else {
            api.normal_sample=true;
            $('#normal_sample').removeClass('animation');
        }
        if(error_sample_value==""){
            api.error_sample=false;
        }else {
            api.error_sample=true;
            $('#error_sample').removeClass('animation');
        }

        var  codeRow =$("#request_codes").find('tr').length;
        if(codeRow < 2){
            api.request_codes=false;
        }else {
            api.request_codes=true;
            $('#request_codes').removeClass('animation');
        }

    }
    function priceFunction(){//产品描述判断
        var intro_value=trim($('#intro').val()),
        highlight_value=trim($('#highlight').val()),
        service_value=trim($('#service').val()),
            imgs=$("#inResult").find('img');
        if(intro_value==""){
            desc.intro=false;
        }else {
            desc.intro=true;
            $('#intro').removeClass('animation');
        }

        if(highlight_value==""){
            desc.highlight=false;
        }else {
            desc.highlight=true;
            $('#highlight').removeClass('animation');
        }

        if(imgs.length<0){
            desc.imgShow=false;
        }else {
            desc.imgShow=true;
            $('#imgShow').removeClass('animation');
        }
        if(service_value==""){
            desc.service=false;
        }else {
            desc.service=true;
            $('#service').removeClass('animation');
        }
    }

    function baseError(base){
        $('#'+base).addClass('animation');
    }
    function apiError(api){
        $('#'+api).addClass('animation');
    }
    function descError(desc){
        console.log("为空的： "+desc);
        $('#'+desc).addClass('animation');
        console.log($('#'+desc).attr('id'));
    }
    /*数据更新*/
    function update() {
        var bln=false;
        for (var k in base){
            if(!trim(base[k])){
                goto('base');
                console.log(k);
                baseError(k);
                return false;
            }else{
                bln=true;
            }
        }
        for (var a in api){
            if(!api[a]){
                goto('api');
                apiError(a);
                return false;
            }else{
                bln=true;
            }
        }
        for (var b in desc){
            if(!desc[b]){
                console.log(desc[b]+" Value: "+b);
                goto('desc');
                descError(b);
                return false;
            }else{
                bln=true;
            }
        }
        return bln;
    }
    function chargingFunction(){//计费设置判断
        apiFunction();
        descFunction();
        priceFunction();
        var priceOne=$('#priceOne').val();
        var priceHundred=$('#priceHundred').val();
        var priceYear=$('#priceYear').val();
        var reg=/^[-\+]?\d+(\.\d+)?$/;

        priceOne_value=trim(priceOne);
        priceHundred_value=trim(priceHundred);
        priceYear_value=trim(priceYear);

        //请求时常 最大为10
        if($("#time_out").val().length>11){
            $('#time_out').addClass('animation').val('').attr('placeholder','请输入10位长度的数字');
            return false;
        }
        if(priceOne_value==""){
            $('#priceOne').addClass('animation');
            return ;
        }
        if(priceOne_value!=""){
            if(!reg.test(priceOne) || priceOne.length >7){
                $('#priceOne').addClass('animation').val('').attr('placeholder','请输入7位长度的数字');
                return ;
            }
        }
        if(priceHundred_value!=""){
            if(!reg.test(priceHundred) || priceHundred.length >7){
                $('#priceHundred').addClass('animation').val('').attr('placeholder','请输入7位长度的数字');
                return ;
            }
        }
        if(priceYear_value!=""){
            if(!reg.test(priceYear) || priceYear.length >7){
                $('#priceYear').addClass('animation').val('').attr('placeholder','请输入7位长度的数字');
                return ;
            }
        }
        if($("#chexkboxId").checked == false){
            alert("请认真阅读协议并同意");
            $('#chexkboxId').addClass('animation');
            return ;
        }
        myfunction();
    }

    });

