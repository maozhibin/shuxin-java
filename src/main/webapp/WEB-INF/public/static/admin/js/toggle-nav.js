/**
 * Created by Yali on 2017/7/3.
 */
$.ready(function () {
    /*点击导航，相关条目展示*/
    $('.collapse >li').click(function () {
        $('.navbar-nav').find('li').removeClass('active').find('ul').removeClass('in').find('li').removeClass('nav-active');
        $(this).addClass('nav-active').parent('ul').addClass('in').parents('li').addClass('active');
    });
});