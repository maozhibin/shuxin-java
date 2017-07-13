function popup_show(elem){
    $(elem).show().find('.window').css({
        opacity:0,
        left: function(){
            var $this=$(this);
            return ($(elem).width() - $this.outerWidth(true)) / 2
        },
        top: function(){
            var $this=$(this);
            return ($(elem).height() - $this.outerHeight(true)) / 2
        }
    }).animate({opacity:1}, 200);
}
function popup_close(elem, remove){
    $(elem).addClass('closed')
        .find('.window')
        .animate({opacity:0, top: '-100%'}, 200, function () {
            $(elem).hide().removeClass('closed');
            if (!!remove){
                $(elem).remove();
            }
        });
}

$(function () {
    var url_js=base_url+"static/js/jquery.placeholder.js";
    $.getScript(url_js, function(){
        $('input, textarea').placeholder();
    });

    $(document).on('click', 'a[href^="javascript"]', function (e) {
        e.preventDefault();
    });

    $(document).on('click', '.dialog .btn-close', function(){
        popup_close($(this).closest('.dialog'));
    });

    $(document).on('click', '[data-href]', function (e) {
        e.preventDefault();
        location.href = $(this).data('href');
    });

    $('.fixed-frame').gotop();

});
+(function ($) {
    $.fn.gotop = function (opts) {
        var defaults = {
            'margin': 60, //���
            'scrollSpeed': 500
        };
        return this.each(function () {
            var $fixed = $(this);
            var $window = $(window);
            var $fixedHeight = $fixed.outerHeight(true);
            var $fixedBottom = parseInt($fixed.css('bottom'));
            var opt = $.extend({}, defaults, opts);
            $(window).resize(function () {
                var offset = opt.margin; //���
                var $bodyWidth = parseInt($('body').css('min-width'));
                var $width = $fixed.width();
                var value = ($window.width() - $bodyWidth) / 2;
                $fixed.css({
                    right: function () {
                        return value < $width+offset ? 0 : (value - $width - offset);
                    }
                });
            }).resize();

            $(document).on("mousewheel DOMMouseScroll", function (e) {
                var value = e.originalEvent.wheelDelta || -e.originalEvent.detail;
                var delta = Math.max(-1, Math.min(1, value));
            });
            $('.gotop').click(function (e) {
                e.preventDefault();
                $('html,body').animate({
                    scrollTop:0
                }, opt.scrollSpeed);
            });
        });
    }
})(jQuery);
+(function ($) {
    $.fn.tabs = function (opts) {
        var defaults = {
            'tab': '.tab',
            'box': '.container',
            'act': 'active',
            'handle': 'click'
        };
        return this.each(function () {
            var $this = $(this);
            var index = 0;
            var opt = $.extend({}, defaults, opts);
            var $container = $this.find(opt.box);

            $this.find(opt.tab).on(opt.handle, function (e) {
                var $btn = $(this);
                e.preventDefault();

                if(!$btn.hasClass(opt.act)){
                    $btn.addClass(opt.act).siblings(opt.tab).removeClass(opt.act);
                    index = $btn.index();
                }
                $container.eq(index).show().siblings(opt.box).hide();
            });
        });
    }
})(jQuery);