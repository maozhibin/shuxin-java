$(function() {
    // 改变选中状态
    function changeActive(ele) {
        ele.siblings().removeClass('active');
        if (ele.is('.active')) {
            ele.removeClass('active');
        } else {
            ele.addClass('active');
        }
    }

    // 导航
    $('.nav-item-header').on('click', function() {
       changeActive($(this).parent());
    })

    $('.nav-sub-item').on('click', function() {
        $('.nav-sub-item').removeClass('active');
        $(this).addClass('active');
    })

    // tab
     $('.tab .item').on('click', function() {
        changeActive($(this));
    })
})