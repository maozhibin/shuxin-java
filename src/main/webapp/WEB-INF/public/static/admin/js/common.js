/**
 * Created by Administrator on 2016/5/18.
 */
function trim(str){ //删除左右两端的空格
    return str.replace(/(^\s*)|(\s*$)/g, "");
}
function ltrim(str){ //删除左边的空格
    return str.replace(/(^\s*)/g,"");
}
function rtrim(str){ //删除右边的空格
    return str.replace(/(\s*$)/g,"");
}

/**
 * 确认是否删除
 */
function delete_confirm(object, url, value) {
    $('.' + object + '').attr('data-toggle', 'modal');
    $('.' + object + '').attr('data-target', '#fade_alert');
    var con = '<div class="modal fade" id="fade_alert">' +
        '<div class="modal-dialog">' +
        '<div class="modal-content">' +
        '<div class="modal-header">' +
        '<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>' +
        '<h4 class="modal-title"><i class="yellow fa fa-warning"></i>确认</h4>' +
        '</div>' +
        '<div class="modal-body">' +
        '<p>一旦确认删除，将不可恢复哦！</p>' +
        '</div>' +
        '<div class="modal-footer">' +
        '<button type="button" id="delete" class="btn" url="">确认删除</button>' +
        '<button type="button" class="btn" data-dismiss="modal">取消</button>' +
        '</div>' +
        '</div>' +
        '</div>' +
        '</div>';
    console.log($(con).html());
    $('body').append(con);
    $('#delete').on('click', function (e) {
        $('#fade_alert').hide();
        window.location.href = url;
    });
}