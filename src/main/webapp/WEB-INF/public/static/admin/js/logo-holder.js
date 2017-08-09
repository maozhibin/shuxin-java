$(document).ready(function () {
    $('#upLogo').change(function () {
        console.log('2323');
        formSubmit();
    });
    //form 表单提交
    function formSubmit(){
        var opt = {
            type:'post',
            datatype:'json',
            url:'/admin/upload/img',
            success : function(data) {
                 if(false){
                    return false;
                }else{
                    if(data.code){/*请求 200*/
                        var inImgs='<div class="f-imgshow"><div class="shade hide"><i class="close"></i></div><img src="'+data.object.imgUrl+'" alt="" id="logo" height="150" class="showImg"/></div>';//显示图片
                        $(".logoBtn").prepend(inImgs);
                    }else{
                        $('.logoBtn').append('<span class="red">'+data.msg+'</span>')
                    }
                }
            },
            error : function(data) {
                console.log($( '#upLogo').val());
                console.log(data);
            }
        };
        $("#show").ajaxSubmit(opt);//相当于from.submit()
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
    });

});