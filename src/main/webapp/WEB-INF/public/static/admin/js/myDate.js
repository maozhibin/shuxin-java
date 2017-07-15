/**
 * Created by Yali on 2017/7/14.
 */
$(document).ready(function(){
    $('body').click(function(){
        // console.log($(".drp-popup").css('display'));
        if($(".drp-popup").css('display') == 'none'){
            $(".btn-close").addClass('hidden');
        }
    });
    /*onload 储存上次的状态*/
    // if({$_POST['startime']}&&{$_POST['startime']}&&{$_POST['startime']}){
    // if($("#start").val()&&$("#end").val()||$("#category").val()){
    //     $(".timePoint").val($("#start").val()+" - "+$("#end").val());
    //     $(".category").find('span[data="'+$("#category").val()+'"]').addClass('selected').siblings('span').removeClass('selected');
    // }

    /*time*/
    var startTime,endTime;
    $(".timePoint").click(function () {
        $("#wrap").removeClass("hidden");
        $(".btn-close").removeClass('hidden');
        // $('.drp-timeline-presets').find('li').removeClass('drp-selected').find("li:first-child").addClass('drp-selected');
    });
    $('.custom-date').click(function () {
        $(".btn-close").removeClass('hidden');
        console.log(startTime);
        console.log(endTime);
    });
    $(".drp-popup").click(function(event) {
        startTime=$(".drp-calendar-start .drp-calendar-date").text();
        endTime=$(".drp-calendar-end .drp-calendar-date").text();
        // $("#start").val(startTime);
        // $("#end").val(endTime);
        console.log(startTime);
        console.log(endTime);
        console.log($('select.custom-date').val());
        // $(this).hide();
    });

    $('.btn-close').click(function () {
        $(".drp-popup").hide();
        $(this).addClass('hidden');
    });
    $("#searchBtn").click(function(){
        /*提交数据*/

    });
});