$(document).ready(function () {
    var result = $("#result");
    var input = document.getElementById("update");
    var inResult = $('#inResult');

   
    $('#update').change(function () {
        formSubmit();
    });
    /*图片鼠标移入*/
    $(document).on('mouseover','.f-imgshow',function(){
            $(this).children('.shade').removeClass('hide');
        }).on('mouseout','.f-imgshow',function(){
        $(this).children('.shade').addClass('hide');
    });
    /*图片鼠标移入 可点击删除*/
    $(document).on('click','.close',function(e){
        $(this).parents('.f-imgshow').remove();
        debugger;
        var i=$('.f-imgshow').length;
        $('#all').text(i);
        $('#num').text('').text(9-i);
    });
    //form 表单提交
    function formSubmit(){
        var opt = {
            type:'post',
            datatype:'json',
            url:'/admin/upload/img',
            success : function(data) {
                console.log($('#num').text());
                console.log($('#all').text());
                if(parseInt($('#all').text())==6){
                    return false;
                }else{
                    if(data.code){/*请求 200*/
                        var inImgs='<div class="f-imgshow"><div class="shade hide"><i class="close"></i></div><img src="'+data.object.imgUrl+'" alt="" id="img" height="150" class="showImg"/></div>';//显示图片
                        $("#inResult").append(inImgs);
                        var i=$('.f-imgshow').length;
                        $('#all').text(i);
                        $('#num').text('').text(6-i);
                    }else{
                        $('.imgBtn').append('<span class="red">'+data.msg+'</span>')
                    }
                }
            },
            error : function(data) {
                console.log($( '#update').val());
                console.log(data);
            }
        };
        $("#image-upload").ajaxSubmit(opt);//相当于from.submit()
    }


});