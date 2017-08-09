$(document).ready(function () {
    function mysumit() {
        var newsClassType=$("#newsClassType").val();
        var title=$("#title").val();
        var source=$("#source").val();
        var author=$("#author").val();
        var keywords=$("#keywords").val();
        var content=$("#content").val();
        var top=$("#top").val();


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
});