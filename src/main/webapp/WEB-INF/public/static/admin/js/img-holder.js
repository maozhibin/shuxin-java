$(document).ready(function () {
    var result = $("#result");
    var input = document.getElementById("update");
    var inResult = $('#inResult');

    var a=0;
    $('#update').click(function () {
        a++;
        console.log(a);
        input.addEventListener('change',formSubmit);
        // for(var i=0;i<a;i++){
        //     if(typeof FileReader === 'undefined'){
        //
        //         input.addEventListener('change',formSubmit);
        //     }else{
        //         input.addEventListener('change',readFile,false);
        //     }
        // }
    });
    function readFile(){
        var file = this.files[0];
        var fsize = parseInt((file.size)/1024); //计算图片大小，默认是B，转换成KB
        if(!/image\/\w+/.test(file.type)){
            alert("请确保文件为图像类型");
            return false;
        }
        var reader = new FileReader();
        reader.readAsDataURL(file);

        reader.onload = function(e){
            if(parseInt($('#all').text())<9){
                var inImgs='<div class="f-imgshow"><div class="shade hide"><i class="close"></i></div><img src="'+this.result+'" alt="" id="img" width="150" class="showImg"/></div>';//显示图片
                // var arr = input.value.split('\\'); //分割图片路径
                // inImgs+="<span class='imgInfo'>"+arr[arr.length-1]+"</span>";//显示图片名字
                $("#inResult").append(inImgs);
                var i=$('.f-imgshow').length;
                $('#all').text(i);
                $('#num').text('').text(9-i);
            }else{
                e.preventDefault();
                $('#imgBtn').append('<span class="red">最多上传9张图片</span>')
            }
        };
    }
    /*图片鼠标移入*/
    $(document).on('mouseover','.f-imgshow',function(){
            $(this).children('.shade').removeClass('hide');
        }).on('mouseout','.f-imgshow',function(){
        $(this).children('.shade').addClass('hide');
    });
    /*图片鼠标移入 可点击删除*/
    $(document).on('click','.close',function(e){
        $(this).parents('.f-imgshow').remove();
        var i=$('.f-imgshow').length;
        $('#all').text(i);
        $('#num').text('').text(9-i);
    });
    //form 表单提交
    function formSubmit(){
        $.ajax({
            url : "http://192.168.3.42:8080/admin/upload/logo",
            type : "POST",
            data : {file:$( '#update').val()},
            success : function(data) {
                console.log('3434');
            },
            error : function(data) {
                console.log($( '#update').val());
                console.log(data);
            }
        });
    }


});