$(document).ready(function () {
        var newsClassType=$("#newsClassType").val();
        var title=$("#title").val();
        var source=$("#source").val();
        var author=$("#author").val();
        var keywords=$("#keywords").val();
        var content=$("#content").val();
        var top=$("#top").val();
        function examVal(){
        if(!trim(newsClassType.val())){//当上面获取的值为空时
            newsClassType.addClass('animation');
            return false;//返回false（不提交表单）
        }
        if(!trim(title.val())){
            newsClassType.addClass('animation');
            return false;
        }
        if(!trim(source.val())){
            newsClassType.addClass('animation');
            return false;
        }
        if(!trim(author.val())){
            newsClassType.addClass('animation');
            return false;
        }
        if(!trim(keywords.val())){
            newsClassType.addClass('animation');
            return false;
        }
    }

        $('.input-ctrl').blur(function () {
            if(!trim($(this).val())){
                $(this).addClass('animation').attr('placeholder','请填写');
            }
        }).focus(function () {
            if($(this).is('.animation')){
                $(this).removeClass('animation').attr('placeholder','');
            }
        });
        $('#upLogo').change(function (e) {
            var logoLength=$(".logoBtn").find('.f-logoshow').length;
            console.log(logoLength);
            if(logoLength<1){
                formSubmit();
            }else{
                e.preventDefault();
            }
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
                            var inImgs='<div class="f-logoshow"><div class="logoShade hide"><i class="closeLogo"></i></div><img src="'+data.object.imgUrl+'" alt="" id="logo" height="150" class="showLogo"/></div>';//显示图片
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
        $(document).on('mouseover','.f-logoshow',function(){
            $(this).children('.logoShade').removeClass('hide');
        }).on('mouseout','.f-logoshow',function(){
            $(this).children('.logoShade').addClass('hide');
        });
        /*图片鼠标移入 可点击删除*/
        $(document).on('click','.closeLogo',function(e){
            $(this).parents('.f-logoshow').remove();
        });

        $('#mySubmit').click(function () {
            examVal();
            $.ajax({
                url:'/admin/news/updateAndAdd'
            });
        });
});