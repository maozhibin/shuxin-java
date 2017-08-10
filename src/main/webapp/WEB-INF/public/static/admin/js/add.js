$(document).ready(function () {
        var newsClassType=$("#newsClassType");
        var title=$("#title");
        var source=$("#source");
        var author=$("#author");
        var keywords=$("#keywords");
        var content=$("#content");
        var top=$("#top");
        function examVal(){
        if(!trim(newsClassType.val())){//当上面获取的值为空时
            newsClassType.addClass('animation');
            return false;//返回false（不提交表单）
        }
        if(!trim(title.val())){
        	title.addClass('animation');
            return false;
        }
        if(!trim(source.val())){
        	source.addClass('animation');
            return false;
        }
        if(!trim(author.val())){
        	author.addClass('animation');
            return false;
        }
        if(!trim(keywords.val())){
        	keywords.addClass('animation');
            return false;
        }
        if($(".logoBtn").find('.f-logoshow').length<1){
        	$('#imgbtn').addClass('animation');
            return false;
        }
        if(!trim(content.val())){
        	content.addClass('animation');
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
            console.log($('.f-logoshow').find('img').attr('src'));
            console.log($('input:checked').val());
            console.log($('input[name="isDisplay"]:checked').val());
            $.ajax({
                type: "POST",
                url: "/admin/news/updateAndAdd",
                data: {
                    id:trim($('#typeValue').val()),
                    newsClassType:trim(newsClassType.val()),
                    title:trim(title.val()),
                    source:trim(source.val()),
                    author:trim(author.val()),
                    top:$('input[name="top"]:checked').val(),
                    isDisplay:$('input[name="isDisplay"]:checked').val(),
                    image:$('.f-logoshow').find('img').attr('src'),
                    keywords:trim(keywords.val()),
                    content:trim(content.val())
                },

                dataType: "json",
                success: function(result){
	                console.log(result.code);
	                console.log(result.data);
				},
				error:function(result){
					conole.log(result.code);
				}
            });
        });
});