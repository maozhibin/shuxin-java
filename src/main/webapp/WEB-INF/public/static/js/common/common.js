/**
 * Created by yzt on 2016/10/7.
 */
/**
 * 显示对话框
 * param = {
	 type: error | success | normal | alert,  //显示类型 默认为 normal
	 close: show | hide, //是否显示右上角关闭按扭
	 closeLink: '',
	 button: show | hide, //是否显示按扭
	 btnLink: '', // 跳转链接地址
	 msg: '内容'
 * }
 * example:
 *    show_dialog({msg: '这是个内容提示'});
 */
function show_dialog(param) {
    var defaults = {
            type: 'normal',
            close: 'show',
            closeLink: 'javascript:;',
            button: 'show',
            btnLink: 'javascript:;',
            btnName: '确定',
            btnLink_alert: 'javascript:;',
            btnName_alert: '确定',
            msg: ''
        },
        width = $('body').width(),
        height = $(document).outerHeight(true),
        dialog;
    param = $.extend(defaults, param);
    if ($('body').find('.dialog-bg').index() == -1) {
        $('body').append('<div class="dialog-bg"></div>');
    }
    if ($('body').find('.dialog').index() == -1) {
        var style = param.style != undefined ? " style='" + param.style + "'" : "";
        dialog = '<div class="dialog"' + style + '>';
        if (param.close != 'hide') {
            dialog += '<a href="' + param.closeLink + '" class="btn btn-close">&times;</a>';
        }
        dialog += '<h3 class="dialog-title">';
        if (param.title != undefined) {
            dialog += param.title;
        }
        else {
            if (param.type == 'error') {
                dialog += '错误提示';
            } else if (param.type == 'success') {
                dialog += '成功提示';
            } else {
                dialog += '消息提示';
            }
        }

        dialog += '</h3>';
        dialog += '<div class="dialog-frame ';
        dialog += param.type;
        dialog += '">';
        dialog += param.msg;
        dialog += '</div>';
        if (param.button != 'hide') {
            if (param.type == 'alert') {
                dialog += '<div class="btn-bar">';
                dialog += '<a href="' + param.btnLink + '" class="btn btn-gray black">' + param.btnName + '</a>';
                dialog += '<a href="' + param.btnLink_alert + '" class="btn btn-blue white" style="margin-left:15px;">' + param.btnName_alert + '</a>';
                dialog += '</div>';
            }
            else {
                dialog += '<div class="btn-bar"><a href="' + param.btnLink + '" class="btn btn-blue white">' + param.btnName + '</a></div>';
            }
        }
        dialog += '</div>';
        $('body').append(dialog);
    }
    $('.dialog-bg').css({
        'position': 'absolute', 'width': function () {
            return width + 'px';
        },
        height: function () {
            if ($(this).outerHeight(true) > $(window).height()) {
                height = $(this).outerHeight(true);
            }
            return height;
        },
        top: 0,
        left: 0
    }).show();
    $('.dialog').css({
        left: function () {
            return (width - $(this).outerWidth(true)) / 2;
        },
        top: function () {
            return ($(window).height() - $(this).outerHeight(true)) / 2 + $(window).scrollTop() - 20;
        },
        display: 'block',
        opacity: 0
    }).animate({top: '+=20', 'opacity': 1}, 'fast');
}
function show_dialog2(param) {
    var defaults = {
            type: 'normal',
            close: 'show',
            closeLink: 'javascript:;',
            button: 'show',
            btnLink: 'javascript:;',
            btnName: '确定',
            btnLink_alert: 'javascript:;',
            btnName_alert: '确定',
            msg: ''
        },
        width = $('body').width(),
        height = $(document).outerHeight(true),
        dialog;
    param = $.extend(defaults, param);
    if ($('body').find('.dialog-bg').index() == -1) {
        $('body').append('<div class="dialog-bg"></div>');
    }
    if ($('body').find('.dialog').index() == -1) {
        var style = param.style != undefined ? " style='" + param.style + "'" : "";
        dialog = '<div class="dialog"' + style + '>';
        if (param.close != 'hide') {
            dialog += '<a href="' + param.closeLink + '" class="btn btn-close">&times;</a>';
        }
        dialog += '<h3 class="dialog-title" style="text-align: center">';
        if (param.title != undefined) {
            dialog += param.title;
        }
        else {
            if (param.type == 'error') {
                dialog += '错误提示';
            } else if (param.type == 'success') {
                dialog += '成功提示';
            } else {
                dialog += '消息提示';
            }
        }

        dialog += '</h3>';
        dialog += '<div class="dialog-frame ';
        dialog += param.type;
        dialog += '">';
        dialog += param.msg;
        dialog += '</div>';
        if (param.button != 'hide') {
            if (param.type == 'alert') {
                dialog += '<div class="btn-bar">';
                dialog += '<a href="' + param.btnLink + '" class="btn btn-gray black">' + param.btnName + '</a>';
                dialog += '<a href="' + param.btnLink_alert + '" class="btn btn-blue white" style="margin-left:15px;">' + param.btnName_alert + '</a>';
                dialog += '</div>';
            }
            else {
                dialog += '<div class="btn-bar"><a href="' + param.btnLink + '" class="btn btn-blue white">' + param.btnName + '</a></div>';
            }
        }
        dialog += '</div>';
        $('body').append(dialog);
    }
    $('.dialog-bg').css({
        'position': 'absolute', 'width': function () {
            return width + 'px';
        },
        height: function () {
            if ($(this).outerHeight(true) > $(window).height()) {
                height = $(this).outerHeight(true);
            }
            return height;
        },
        top: 0,
        left: 0
    }).show();
    $('.dialog').css({
        left: function () {
            return (width - $(this).outerWidth(true)) / 2;
        },
        top: function () {
            return ($(window).height() - $(this).outerHeight(true)) / 2 + $(window).scrollTop() - 20;
        },
        display: 'block',
        opacity: 0
    }).animate({top: '+=20', 'opacity': 1}, 'fast');
}

//关闭对话框
function close_dialog_fast() {
    $(".dialog").remove();
    $('.dialog-bg').remove();
}

/**
 * 移除错误提示
 * @parm    obj        $        对应的 input 选择器
 */
show_success = function (obj) {
    // obj.removeClass('error');
    obj.parent().find("p.error").remove();
}

/**
 * 错误提示
 * @parm    msg        String    显示的消息
 * @parm    obj        $        对应的 input 选择器
 */
show_error = function (msg, obj) {
    //先正常化
    show_success(obj);
    var html = '';
    html = '<p class="error"><i class="ico-font">&#xf06a;</i>' + msg + '</p>';
    //外部插入
    obj.after(html);
    //2秒后自动消失
    setTimeout(function () {
        show_success(obj);
    }, 3000);
    // show_success(obj);
};


//检查手机号码
check_mobile = function (mobile) {
    var reg = /^1[34578]\d{9}$/;
    //成功 返回true
    return reg.test(mobile);
};

//手机验证
check_phone =function(obj) {
    var obj=obj.replace(/(^\s+)|(\s+$)|(\s)/g,"");//去掉空格
    var obj=obj.replace(/(^\s+)|(\s+$)|(\s)/g,"_");//去掉下划线
    var reg = /^1[34578]\d{9}$/;
    var result=new Array();
    result['error']=reg.test(obj);
    result['data']=obj;
    return result ;
};

//检查手机验证码是否正确
check_seccode = function (mobile, seccode, neww, url) {

    var posts = {
        'mobile': mobile,
        'vcode': seccode,
        'new': neww,
        'is_voice': 0
    }
    // if(seccode == '1234'){
    // 	return true;
    // }
    // return false;
    $.post(url, posts,
        function (r) {
            alert(r.error);
            return 1;
        }, "json");


}
//检测密码，密码强度
check_password = function (password) {
    // var reg = /^[\w!@#$%^&*()-=,.]{8,20}$/;
    // var reg = /^[\W]{0,}/;
    //成功返回 true
    var d = new RegExp(/^\d+$/).test(password);//是否为纯数字
    var l = new RegExp(/^\D+$/ig).test(password);//是否为纯非数字
    var r = new RegExp(/^[\w!@#$%^&*()-=,.]{8,20}$/).test(password);//8,20位字母，数字
    if (d || l || !r) {
        return false;
    }
    return true;
}

//密码一致
check_repassword = function (password, password2) {
    if (password != password2) {
        //密码不一致
        return false;
    }
    //密码一致
    return true;
}

//推荐人是否存在
check_tuijian = function (baseurl, tuijian) {
}

//验证邮箱
check_email = function (email) {
    var patten = new RegExp(/^[\w-\_]+(\.[\w-]+)*@([\w-]+\.)+[a-zA-Z]+$/);
    return patten.test(email);
};

//登录账户检测   //允许中文
check_account = function (account) {
    if (account == '') {
        //为空
        return false;
    }
    //允许中文
    // var reg = /^[\w]{6,15}$/;
    // var reg = /^[\W]{0,}/;
    //成功返回 true
    // if(!reg.test(account)){
    // 	return false;
    // }
    //合法
    return true;
}

//用户名是否合法  //允许中文
check_username = function (username) {
    var length = username.length;
    if (length < 6 || length > 15) {
        return false;
    }
    //var reg = /^[\w]{6,15}$/;
    // var reg = /^[\W]{0,}/;
    //成功返回 true
    //return reg.test(username);
    return true;
}

//真实姓名
check_truename = function (truename) {
    var reg = /^[\u4e00-\u9fa5]{2,}$/;
    if (truename != '') {
        return reg.test(truename);
    }
    return false;
}

//身份证号码
check_id_number = function (id_number) {
    var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
    //符合返回true
    return reg.test(id_number);
}

//验证重复输入的身份证号码是否一致
check_re_id_number = function (id_number, id_number2) {
    if (id_number == id_number2) {
        //一致
        return true;
    }
    return false;
}


//js页面跳转
jump_url = function (url, second) {
    setInterval(function () {
        second--;
        if (second > 0) {

        }
        else {
            window.location.href = url;
        }
    }, 1000);

}

//关闭对话框
function close_dialog(elem) {
    elem.animate({top: '-=20', opacity: 0}, 'fast', function () {
        $(this).remove();
        $('.dialog-bg').remove();
    });
}
//显示弹出层
function popup_show_old(elem) {
    var width = $('body').width();
    var height = $(document).outerHeight(true);

    var top;
    elem.css({
        left: function () {
            return (width - $(this).outerWidth(true)) / 2;
        },
        top: function () {
            if (elem.outerHeight(true) > height) {
                top = -20;
                return top;
            } else {
                top = ($(window).height() - $(this).outerHeight(true)) / 2 + $(window).scrollTop() - 20;
                return top < -20 ? -20 : top;
            }
        },
        display: 'block',
        opacity: 0
    }).animate({top: '+=20', 'opacity': 1}, 'fast');
    $('.popup-bg').css({
        'position': 'absolute', 'width': function () {
            return width + 'px';
        },
        height: function () {
            if (elem.outerHeight(true) > height) {
                height = elem.outerHeight(true);
            }
            return height;
        },
        top: 0,
        left: 0
    }).show();
}
//关闭弹出层
function popup_close_old(elem, remove) {
    elem.animate({top: '-=20', opacity: 0}, 'fast', function () {
        if (!!remove) {
            $(this).remove();
            $('.popup-bg').remove();
        } else {
            $(this).hide();
            $('.popup-bg').hide();
        }
    });
}
//网银充值返回弹窗
// status: true | false
function returnDeposite(status) {
    var html = '';
    html += '<div class="popup-bg"></div>';
    html += '<div class="popup return-deposite">';
    html += '  <button class="btn btn-close">&times;</button>';
    html += '  <h3 class="popup-title">网银充值</h3>';
    if (status) {
        html += '  <div class="popup-frame center">';
        html += '    <span class="status">充值成功</span>';
        html += '    <p class="f14 m_t10"><a href="" class="color-blue">查看充值记录</a></p>';
        html += '  </div>';
    } else {
        html += '  <p class="tip">请在新打开的网银页面完成充值</p>';
        html += '  <div class="popup-frame center">';
        html += '    <span class="status error">充值失败</span>';
        html += '    <p class="f14 m_t10"><a href="" class="color-blue">选择其他充值方式</a> 或  <a href="" class="color-blue">重新充值</a></p>';
        html += '  </div>';
    }
    html += '  <div class="bottom center">';
    html += '    <a href="">帮助中心</a> &nbsp; | &nbsp; <a href="">充值指南</a>';
    html += '  </div>';
    html += '</div>';
    $('body').append(html);
    popup_show($('.return-deposite'));
}
$(function () {
    // $.getScript(base_url+'static/scripts/jquery.placeholder.js', function(){
    // 	$('input, textarea').placeholder();
    // });
    $(document).on('click', '.dialog .btn-close, .dialog .btn-blue, .dialog .btn-gray', function () {
        close_dialog($(this).closest('.dialog'));
    });


    $(document).on('click', '.popup .btn-close', function () {
        popup_close_old($(this).closest('.popup'));
    });

    //投资计算器
    // $(document).on('click', '.btn-calc', function(){
    // 	popup_show($('.popup-calc'));
    // });

    //微信点击
    $(document).on('click', '.weixin', function () {
        popup_show_old($('.popup-weixin'));
    });

    //返回顶部
    $(document).on('click', '.goto-top', function () {
        $(window).scrollTop(0);
    });

    $(document).on('click', 'a[href^="javascript"]', function () {
        return false;
    });
});

//头部缩放按扭
;
(function ($) {
    var c = 1;//当前缩放
    $.zoom = function () {
        //ctrl:17 +:187 -:189 0:48
        $('.header .top-tools .size').click(function (e) {
            var $this = $(this),
                d = 1,
                z = 0.1;
            if ($this.find('.f14').index() != -1) {
                c += z;
            } else if ($this.find('.f12').index() != -1) {
                c -= z;
            } else {
                c = d;
            }
            $('body').css({
                'zoom': function () {
                    return c;
                },
                '-webkit-transform': function () {
                    return 'scale(' + c + ',' + c + ')';
                },
                '-webkit-transform-origin': function () {
                    return 'center top';
                },
                '-moz-transform': function () {
                    return 'scale(' + c + ',' + c + ')';
                },
                '-moz-transform-origin': function () {
                    return 'center top';
                },
                '-ms-transform': function () {
                    return 'scale(' + c + ',' + c + ')';
                },
                '-ms-transform-origin': function () {
                    return 'center top';
                },
                'transform': function () {
                    return 'scale(' + c + ',' + c + ')';
                },
                'transform-origin': function () {
                    return 'center top';
                }
            });
        });
    }
    $(function () {
        $.zoom();
    });
})(jQuery);

//浙金动态左右滑动JS
(function ($) {
    $.fn.sliderNews = function () {
        return this.each(function () {
            var $this = $(this),
                _index = 0,
                counter;

            function slider(to) {
                var $li = $this.find('.list li'), css = {};
                if ($this.data('status') == 'stop' || !$this.data('status')) {
                    if (to == 'prev') {
                        _index--;
                        if (_index >= 0) {
                            css.left = '+=100%';
                        } else {
                            _index = ($li.length - 1);
                            css.left = '-=' + ($li.length - 1) * 100 + '%';
                        }
                    } else {
                        _index++;
                        if (_index < $li.length) {
                            css.left = '-=100%';
                        } else {
                            _index = 0;
                            css.left = '+=' + ($li.length - 1) * 100 + '%';
                        }
                    }
                    $this.data('status', 'runing');
                    $li.animate(css, 'slow', function () {
                        $this.data('status', 'stop');
                    });
                }
            }

            function run() {
                counter = window.setInterval(function () {
                    slider();
                }, 5000);
            }

            function pause() {
                window.clearInterval(counter);
            }

            run();

            $this.find('.list li').each(function (index, element) {
                $(element).css({
                    'position': 'absolute',
                    top: 0,
                    left: function () {
                        return (index * 100) + '%';
                    }
                });
            });
            $this.find('.btn').click(function () {
                var elem = $(this), to = '';
                if (elem.hasClass('prev')) {
                    to = 'prev';
                } else {
                    to = 'next';
                }
                slider(to);
            });

            $this.hover(
                function () {
                    pause();
                },
                function () {
                    run();
                }
            );
        });
    }
    $(function () {
        $('.slider-new').sliderNews();
    });
})(jQuery);


//执行请求
function request(api, params, callback) {
    if (typeof(params) != 'object')params = {};
    $.post(site_url(api), params, function (r, status, xhr) {
        try {
            if (typeof(r) != "object") {
                r = $.parseJSON(r);
            }
            if (r.error == 3) {
                document.location.reload(true);
                return;
            }
            if (r.error == 4) {
                ip_unlock();
                return;
            }
            if (r.error == 15) {
                document.location.href = site_url('user_money/need_return');
                return;
            }
            if (r.error != undefined && window.location.href.indexOf('login') == -1 && window.location.href.indexOf('register') == -1 && (r.data == '用户未登录' || r.data == 'Not logged in yet!')) {
                window.location.href = site_url('user/login_index');
            }
        }
        catch (e) {
        } finally {
            callback(r);
        }
    });
}
function pay_request(api, params, callback) {
    if (typeof(params) != 'object')params = {};
    $.ajax({
        type: "post",
        url: site_url('server/' + api),
        data: params,
        async: false,
        beforeSend: function (XMLHttpRequest) {
        },
        success: function (r, textStatus) {
            try {
                if (typeof(r) != "object") {
                    r = $.parseJSON(r);
                }
                if (r.error == 3) {
                    document.location.reload(true);
                    return;
                }
                if (r.error == 4) {
                    ip_unlock();
                    return;
                }
                if (r.error == 15) {
                    document.location.href = site_url('user_money/need_return');
                    return;
                }
                if (r.error != undefined && window.location.href.indexOf('login') == -1 && window.location.href.indexOf('register') == -1 && (r.data == '用户未登录' || r.data == 'Not logged in yet!')) {
                    window.location.href = site_url('login');
                }
                callback(r);
            }
            catch (e) {
            }
        },
        complete: function (XMLHttpRequest, textStatus) {
        },
        error: function () {
        }
    });
}
$(function ($) {
    //退出
    $(".logout").click(function (event) {
        request('user/logout', {},
            function (r) {
                if (r.error == 0) {
                    //退出成功 刷新页面
                    var url = window.location.href;
                    if (url.indexOf("#") > 0) {
                        window.location.href = url.substring(0, url.indexOf("#"));
                    } else {
                        window.document.location.reload();
                    }
                } else if (r.error == 1) {
                    //退出失败
                    alert(r.data);
                }
            });

    });
    //单击用户名 页面跳转到 账户资产上
    $("#uname").click(function (event) {
        var url = $("#uname").data("url");
        window.location.href = url;
    });

});

function site_url(uri) {
    if (typeof(uri) == 'undefined')uri = 'index';
    return base_url + uri + '?' + new Date().getTime() + Math.random();
}
var is_ie8 = /msie 8\.0/i.test(window.navigator.userAgent.toLowerCase());
if(navigator.userAgent.indexOf("MSIE 9.0")>0 && !window.innerWidth){
    is_ie8 = true;
}
var _g_total_payment_check = 0;
var _pay_action_list = {
    to_register: {name: '绑定', link_name: '查看绑定状态', link_url: site_url('user_account/bind_payment')},
    to_recharge: {name: '充值', link_name: '查看我的资金', link_url: site_url('user_money')},
    to_transfer_u2p: {name: '转账到平台', link_name: '查看我的资金', link_url: site_url('user_money')},
    to_withdraw: {name: '提现', link_name: '查看我的资金', link_url: site_url('user_money')},
    to_bind_bank_card: {name: '绑定银行卡', link_name: '查看绑定状态', link_url: site_url('user_account/bind_card')},
    to_unbind_bank_card: {name: '解除绑定银行卡', link_name: '查看绑定状态', link_url: site_url('user_account/bind_card')},
    to_cp_repayment: {name: '还款', link_name: '查看我的还款记录', link_url: site_url('user_money/repayment')},
    to_cp_transaction: {name: '支付', link_name: '查看我的投资', link_url: site_url('user_product')},
    to_cp_transfer: {name: '转让', link_name: '查看我的投资', link_url: site_url('user_product')},
    to_authorize_auto_repayment: {name: '还款授权', link_name: '查看我的投资', link_url: site_url('user_product')},
    to_auto_withdraw: {name: '自动提现授权', link_name: '查看我的投资', link_url: site_url('user_product')},
    to_cancel_auto_withdraw: {name: '取消自动提现', link_name: '查看我的投资', link_url: site_url('user_product')},
    to_cp_transaction_direct: {name: '用户转账', link_name: '用户转账', link_url: site_url('user_product')},
    to_reset_mobile: {name: '修改手机号码', link_name: '修改手机号码', link_url: site_url('user_set/identify')},
    to_c2c_transfer: {name: '转账', link_name: '转账', link_url: site_url('user_money')},
    to_reset_password: {name: '修改交易密码',link_name: '修改交易密码',link_url: site_url('user_set/password')},
    return2finance: {name: '用户退还多付利息', link_name: '用户退还多付利息', link_url: site_url('user_money')},
    to_register_beijing_bank:{name:'开通北京银行存管账户', link_name:'开通北京银行存管账户',link_url: site_url('user_set/identify')},
    customer_transfer_platform:{name:'易宝余额转账至平台账户', link_name:'易宝余额转账至平台账户', link_url:site_url('user_money/withdraw')},
    yeepay_blance_withdraw:{name:'易宝余额提现', link_name:'易宝余额提现', link_url:site_url('user_money/withdraw')}
};
var _g_pay_cfg = {};
var _g_pay_action = "";
var _g_pay_request = "";
function _pay_failed() {
    if (_g_pay_action == "" || _g_pay_request == "") {
        return;
    }
    _g_total_payment_check = 600;
    request("payment/failed", {type: _g_pay_action, "id": _g_pay_request}, function (r) {});
    $('.dialog').remove();
    window.setTimeout(function(){
        show_dialog({title: _g_pay_cfg.name + '提示',
            msg: '<div class="center f18 mt15 mb35">很抱歉，' + _g_pay_cfg.name + '失败<br />如果您有任何疑问，请致400-658-7788</div><div class="btn-bar"></div>', 'button': 'show',btnName:'重新' + _g_pay_cfg.name});
    }, 200);
}

function _pay_ok() {
    if (_g_pay_action == "") {
        return;
    }
    window.location.href = _g_pay_cfg.link_url;
}
function _pay_bind() {
    $("#_pay_not_done").on("click", function () {
        _pay_failed();
    });
    $("#_pay_done").on("click", function () {
        _pay_ok();
    });
}

function _check_complete() {
    if ($("#_pay_not_done").attr("ref") != _g_pay_request) {
        return;
    }
    request('payment/check_complete', {request_no: _g_pay_request}, function (c) {
        if (c.error == 0) {
            $('.dialog').remove();
            _pay_ok();
        } else {
            _g_total_payment_check = _g_total_payment_check + 1;
            if (_g_total_payment_check > 500) {
                _pay_failed($("#_pay_not_done"));
            } else {
                window.setTimeout(_check_complete, 2000);
            }
        }
    });
}
function payment(action, param) {
    if (typeof(_pay_action_list[action]) == 'undefined') {
        show_dialog({msg: '未指定操作', 'type': 'error'});
        return false;
    }
    _g_pay_cfg = _pay_action_list[action];
    _g_pay_action = action;
    $('.dialog').remove();
    show_dialog({
        msg: '<img src="' + base_url + 'static/images/select2-spinner.gif" />&nbsp;&nbsp;请求正在发送中...<br /><br /><br />&nbsp;',
        'type': 'normal',
        'button': 'hide',
        'close': 'hide'
    });
    _g_total_payment_check = 0;
    pay_request('payment/' + action, param, function (r) {
        if (typeof(r) == 'string') {
            $('.dialog').remove();
            show_dialog({msg: '系统错误，请与管理员联系。', 'type': 'error'});
        } else {
            var c_id = "yeepay_controller";
            if (r.error == 0) {
                if ($('body').find('#' + c_id).index() == -1) {
                    $("body").append("<div id='" + c_id + "' style='display:none'></div>");
                }
                document.getElementById(c_id).innerHTML = r.data.form;
                var _pay_f = $("#payment_form");
                if (/**_pay_f.attr("action") != undefined && !is_ie8**/false) {
                    _pay_f.attr("action", $('#yeepay').attr("action"));
                    _pay_f.find("textarea").remove();
                    _pay_f.append($('#yeepay').html());
                    _pay_f.submit();
                } else {
                    //如果不行，切换到当前窗口
                    $("#yeepay").removeAttr("target");
                    $('#yeepay').submit();
                }
                $('.dialog').remove();
                var _msg = '<div class="center f18 mt15 mb35">请您在新打开的第三方支付页面上' + _g_pay_cfg.name + '<br />' +
                    '完成前请不要关闭此窗口</div><div style="text-align: left; border-bottom: 1px solid #efefef;" class="pb5"><i class="fa color-red f18 mr5">&#xf06a;</i><span>完成' + _g_pay_cfg.name + '后请根据您的情况点击下面按钮：</span></div>';
                _msg += '<div><button class="btn-gray mt10 mr10" style="cursor: pointer;" id="_pay_not_done" ref="' + r.data.request_no + '">' + _g_pay_cfg.name + '遇到问题</button> <button class="btn-blue mt10" style="height: 45px;cursor: pointer;" id="_pay_done">已完成' + _g_pay_cfg.name + '</button></div>';
                show_dialog({title: _g_pay_cfg.name + '提示', msg: _msg, 'button': 'hide', style: 'width:550px'});
                _pay_bind();
                _g_pay_request = r.data.request_no;
                window.setTimeout(_check_complete, 2000);
            } else {
                $('.dialog').remove();
                show_dialog({msg: r.data, 'type': 'error'});
            }
        }
    });
    return false;
}
function ip_unlock() {
    var _msg = "<!--验证码弹出窗-->";
    _msg += '<div class="popup-frame">';
    _msg += '<p class="f14 color-red" id="safety_msg"></p>';
    _msg += '<dt class="lt" style="line-height: 45px;">验证码：</dt>';
    _msg += '<dd class="lt"><input type="text" class="input-ctrl" placeholder="请输入验证码" id="seccode"></dd>';
    _msg += ' <dd class="lt pad-l25"><img src="' + base_url + 'server/seccode' + '" width="100" height="45" onclick="this.src = this.src.replace(/\\\?[0-9\\\.]+/,\'\') + \'?\' + Math.random()"> </dd>';
    _msg += '</dl>';
    _msg += '<div class="clearfix"><button class="btn btn-blue" id="unlock_btn">提交</button></div>';
    _msg += '</div>';
    _msg += '<div class="popup-bg"></div>';
    $('.dialog').remove();
    show_dialog({msg: _msg, title: '为了您的账号安全请输入验证码', 'button': 'hide', close: 'hide', style: 'width:500px'});
    $("#unlock_btn").click(function () {
        $(this).html("正在提交中...");
        request("safety/unlock", {seccode: $('#seccode').val()}, function (r) {
            $("#unlock_btn").html("提交");
            if (r.error != 0) {
                $("#safety_msg").html(r.data);
            } else {
                $('.dialog').remove();
                show_dialog({
                    msg: '验证成功<br /><br /><br /><div class="btn-bar"><button class="btn btn-blue" onclick="">确定</button></div>',
                    'type': 'success',
                    'button': 'hide'
                });
            }
        })
        return false;
    })
}
function check_bind_payment() {
    request('payment/check_bind', {}, function (r) {

        if (typeof(r) == 'string') {
            $('.dialog').remove();
            show_dialog({msg: '系统错误，请与管理员联系。', 'type': 'error'});
        }
        else {
            if (r.error != 0) {
                $('.dialog').remove();
                show_dialog({msg: r.data, 'type': 'error'});
            }
        }

    })
}
var __sw;
function share(e, data, call_back) {
    if (e != "wechat") {
        __sw = window.open('about:blank', '', 'left=20,top=20,width=400,height=300,toolbar=0,resizable=1');
    }
    data["platform"] = e;
    request("misc/share", data, function (r) {
        if (r.error == 0) {
            if (e == "wechat") {
                $('#weixin_qrcode').html('');
                $('#weixin_qrcode').qrcode({width: 260, height: 260, render: "table", text: r.data.u});
                popup_show_old($(".weixin_qrcode_frame"));
            } else {
                __sw.location.replace(r.data.u);
            }
            call_back(r.data);
        }
    });
    return false;
}
function send_sms(mobile, is_new, type, obj, domain, callback) {
    var posts = {'mobile': mobile, 'new': is_new, 'is_voice': type, 'domain': domain};
    if (posts.mobile == '') {
        show_error("请填写手机号码", obj);
        return;
    }
    if (!check_mobile(posts.mobile)) {
        show_error(obj.data("error"), obj);
        return;
    }
    request('user/send_mobile_code', posts, callback);
}
function is_mobile_exist(mobile, obj, callback) {
    var posts = {'mobile': mobile};
    if (posts.mobile == '') {
        return;
    }
    if (!check_mobile(posts.mobile)) {
        show_error(obj.data("error"), obj);
        return;
    } else {
        show_success(obj);
    }
    request('user/mobile_exist', posts, callback);
}
function num2cn(num) {
    if (num > 10000000000) return "数字过大";
    if (num == 0) return "零元整";
    var AA = new Array("零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖");
    var BB = new Array("", "拾", "佰", "仟", "万", "亿", "元", "");
    var CC = new Array("角", "分", "厘");
    var a = ("" + num).replace(/(^0*)/g, "").split("."), k = 0, re = "";
    for (var i = a[0].length - 1; i >= 0; i--) {
        switch (k) {
            case 0 :
                re = BB[7] + re;
                break;
            case 4 :
                if (!new RegExp("0{4}//d{" + (a[0].length - i - 1) + "}$").test(a[0]))
                    re = BB[4] + re;
                break;
            case 8 :
                re = BB[5] + re;
                BB[7] = BB[5];
                k = 0;
                break;
        }
        if (k % 4 == 2 && a[0].charAt(i) == "0" && a[0].charAt(i + 2) != "0") re = AA[0] + re;
        if (a[0].charAt(i) != 0) re = AA[a[0].charAt(i)] + BB[k % 4] + re;
        k++;
    }
    if (a.length > 1) {
        re += BB[6];
        for (var i = 0; i < a[1].length; i++) {
            if (a[1].charAt(i) == '0') {
                continue;
            }
            re += AA[a[1].charAt(i)] + CC[i];
            if (i == 2) break;
        }
        if (a[1].charAt(0) == "0" && a[1].charAt(1) == "0") {
            re += "整";
        }
    } else {
        re += BB[6] + "整";
    }
    return re;
}

function request_new(api, params, callback) {
    if (typeof(params) != 'object')params = {};
    $.post(site_url('server/' + api), params, function (r, status, xhr) {
        try {
            if (typeof(r) != "object") {
                r = $.parseJSON(r);
            }
            if (r.error == 3) {
                document.location.reload(true);
                return;
            }
            if (r.error == 4) {
                ip_unlock();
                return;
            }
            if (r.error == 15) {
                document.location.href = site_url('user_money/need_return');
                return;
            }
            if (r.error != undefined && window.location.href.indexOf('login') == -1 && window.location.href.indexOf('register') == -1 && (r.data == '用户未登录' || r.data == 'Not logged in yet!')) {
                $(document).on('click', '.dialog .btn-close, .dialog .btn-blue, .dialog .btn-gray', function () {
                    close_dialog($(this).closest('.dialog'));
                    window.location.href = site_url('login');
                });
                //window.location.href = site_url('login');
            }
        }
        catch (e) {
        } finally {
            callback(r);
        }
    });
}


function post_request(api, params, callback) {
    if (typeof(params) != 'object')params = {};
    $.post(site_url(api), params, function (r, status, xhr) {
        try {
            if (typeof(r) != "object") {
                r = $.parseJSON(r);
            }
            if (r.error == 3) {
                document.location.reload(true);
                return;
            }
        }
        catch (e) {
        } finally {
            callback(r);
        }
    });
}
output_error = function (msg, obj) {
    //先正常化
    output_success(obj);
    var html = '';
    html = "<div class='error-tip'>" + msg + "</div>";
    //外部插入
    obj.after(html);
    //2秒后自动消失
    setTimeout(function () {
        output_success(obj);
    }, 3000);
};
output_success = function (obj) {
    // obj.removeClass('error');
    obj.parent().find("div.error-tip").remove();
};

//检查会员名称5-25字符
check_username_new = function (name) {
    var reg = /^[0-9A-Za-z\u4e00-\u9fa5]{5,25}$/;
    //成功 返回true
    return reg.test($.trim(name));
};
function sms_time(o,time) {
    if (time == 0) {
        time = 60;
        is_send = 0;//标记为可发送短信状态
        o.html("发送验证码");
        //60秒后显示语音
        $("#send_voice_row").show();
    } else {
        time--;
        is_send = 1;//标记为已发送短信状态
        o.html("(" + time + ")秒后可重发");
        setTimeout(function () {
            sms_time(o,time)
        }, 1000)
    }
}

//检查机构信用位数
check_org = function (code) {
    var reg = /^[0-9A-Za-z]{18}$/;
    //成功 返回true
    return reg.test(code);
};
check_number = function (code) {
    var reg = /^[0-9]{1,}$/;
    //成功 返回true
    return reg.test(code);
};
check_password_new = function (password) {
    // var reg = /^[\w!@#$%^&*()-=,.]{8,20}$/;
    // var reg = /^[\W]{0,}/;
    //成功返回 true
    var d = new RegExp(/^\d+$/).test(password);//是否为纯数字
    var l = new RegExp(/^\D+$/ig).test(password);//是否为纯非数字
    var r = new RegExp(/^[\w!@#$%^&*()-=,.][^\s]{6,20}$/).test(password);//8,20位字母，数字
    if (d || l || !r) {
        return false;
    }
    return true;
}
function bankCardNo(obj) {
    var reg = /^\d{10,22}$/;
    return reg.test(obj);
}
function checkPrice(price) {
    return (/^(([1-9]\d*)|\d)(\.\d{1,2})?$/).test(price.toString());
}
