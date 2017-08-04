$(document).ready(function(){
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

    /*数据更新*/
    function update() {
        for (var k in base){
            if(!trim(base[k])){
                goto('base');
                console.log(k);
                apiError(k);
                return ;
            }
        }
        for (var a in api){
            console.log(api[k]);
            console.log('XXXXXXXXXXXXXXXXXXXXXXX');
            if(!api[a]){
                goto('api');
                apiError(a);
                return ;
            }
        }
        for (var b in desc){
            if(!desc[b]){
                goto('price');
                descError(b);
                return ;
            }
        }
    }
    function myfunction(){
        var str = {};
        update();

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

    var base={},api={},desc={};
    function apiFunction(){//基础设置检查
        base.product_name=$('#product_name').val();
        base.product_description=$('#product_description').val();
        base.productTags=$('#productTags').val();
        console.log(base);
    }
    function descFunction(){//接口设置判断
        var request_sample_value=trim($('#request_sample').val()),
        normal_sample_value=trim($('#normal_sample').val()),
        error_sample_value=trim($('#error_sample').val());

        api.interface_name=trim($('#interface_name').val());
        api.app_code=trim($('#app_code').val());
        api.time_out=trim($('#time_out').val());
        api.url_address=trim($('#url_address').val());

        var  headerRow =$("#request_headers").find('tr').length;
        if(headerRow < 2){
            // alert("至少输入一个请求参数(Headers)");
            api.request_headers=false;
        }

        var  queryRow =$("#request_querys").find('tr').length;
        if(queryRow < 2){
            // alert("至少输入一个请求参数(Querys)");
            api.request_querys=false;
        }

        var  bodyRow =$("#request_bodys").find('tr').length;
        if(bodyRow < 2){
            // alert("至少输入一个请求参数(Bodys)");
            api.request_bodys=false;
        }


        if(request_sample_value==""){
            api.request_sample=false;
        }
        if(normal_sample_value==""){
            api.normal_sample=false;
        }
        if(error_sample_value==""){
            api.error_sample=false;
        }

        var  codeRow =$("#request_codes").find('tr').length;
        if(codeRow < 3){
            // alert("至少输入一个错误码定义");
            api.request_codes=false;
        }

    }
    function priceFunction(){//产品描述判断
        var intro_value=trim($('#intro').val()),
        highlight_value=trim($('#highlight').val()),
        service_value=trim($('#service').val());
        if(intro_value==""){
            desc.intro=false;
        }
        if(highlight_value==""){
            desc.highlight=false;
        }
        if(service_value==""){
            desc.service=false;
        }
    }

    function baseError(base){
        $('#'+base).addClass('animation');
    }
    function apiError(api){
        $('#'+api).addClass('animation');
    }
    function descError(desc){
        $('#'+desc).addClass('animation');
    }

    function chargingFunction(){//计费设置判断
        apiFunction();
        descFunction();
        priceFunction();

        var priceOne=$('#priceOne').val();
        var priceHundred=$('#priceHundred').val();
        var priceYear=$('#priceYear').val();
        var reg=/^[-\+]?\d+(\.\d+)?$/;

        priceOne_value=priceOne.replace(/\n/g,'');
        priceHundred_value=priceHundred.replace(/\n/g,'');
        priceYear_value=priceYear.replace(/\n/g,'');
        if(priceOne_value==""){
            // alert("单次费用必须填写");
            $('#priceOne').addClass('animation');
            return;
        }
        if(priceOne_value!=""){
            if(!reg.test(priceOne) || priceOne.length >7){
                // alert("请输入正确的单次计费价格");
                $('#priceOne').addClass('animation');
                return;
            }
        }
        if(priceHundred_value!=""){
            if(!reg.test(priceHundred) || priceHundred.length >7){
                // alert("请输入正确的多次计费价格");
                $('#priceHundred').addClass('animation');
                return;
            }
        }

        if(priceYear_value!=""){
            if(!reg.test(priceYear) || priceYear.length >7){
                // alert("请输入正确的包年计费价格");
                $('#priceYear').addClass('animation');
                return;
            }
        }
        if($("#chexkboxId").checked == false){
            alert("请认真阅读协议并同意");
            $('#chexkboxId').addClass('animation');
            return;
        }
        myfunction();
    }

    function delHeaders(obj){//点击事件那边需要加this
        var tr=obj.parentNode.parentNode;
        var tbody=tr.parentNode;
        tbody.removeChild(tr);
    }

    });

