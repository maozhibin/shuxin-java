$(document).ready(function () {
    function mysumit() {
        var newsClassType=$("#newsClassType").val();
        var title=$("#title").val();
        var source=$("#source").val();
        var author=$("#author").val();
        var top=$("#top").val();
        var isDisplay=$("#isDisplay").val();
        var keywords=$("#keywords").val();


        if(!newsClassType.val()){//当上面获取的值为空时
            newsClassType.addClass('animation');
            return false;//返回false（不提交表单）
        }
        if(!title.val()){
            newsClassType.addClass('animation');
            return false;
        }
        if(!source.val()){
            newsClassType.addClass('animation');
            return false;
        }
        if(!author.val()){
            newsClassType.addClass('animation');
            return false;
        }
        if(!keywords.val()){
            newsClassType.addClass('animation');
            return false;
        }
        document.getElementById("formid").submit();
    }
});