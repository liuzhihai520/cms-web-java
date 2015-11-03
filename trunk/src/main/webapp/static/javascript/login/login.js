/**
 * 方法描述:登陆JS
 * @author 小刘
 * @date ${DATE}
 * @version v1.0
 */
$(function(){

    var _topWin = window;
    while (_topWin != _topWin.parent.window) {
        _topWin = _topWin.parent.window;
    }

    if (window != _topWin){
        _topWin.document.location.href = "/trunk";
    }

    $('#btn-login-dark').on('click', function(e) {
        $('body').attr('class', 'login-layout');
        $('#id-text2').attr('class', 'white');
        $('#id-company-text').attr('class', 'blue');
        e.preventDefault();
    });

    $('#btn-login-light').on('click', function(e) {
        $('body').attr('class', 'login-layout light-login');
        $('#id-text2').attr('class', 'grey');
        $('#id-company-text').attr('class', 'blue');
        e.preventDefault();
    });

    $('#btn-login-blur').on('click', function(e) {
        $('body').attr('class', 'login-layout blur-login');
        $('#id-text2').attr('class', 'white');
        $('#id-company-text').attr('class', 'light-blue');
        e.preventDefault();
    });

    $(document).on('click', '.toolbar a[data-target]', function(e) {
        e.preventDefault();
        var target = $(this).data('target');
        //hide others
        $('.widget-box.visible').removeClass('visible');
        //show target
        $(target).addClass('visible');
    });

    $("#login").click(function(){
        $("#form").submit();
    });

    var obj;
    if(data != null && data != ''){
        obj = data;
        if(obj.code != 0){
            bootbox.alert({
                size: 'small',
                title:'提示:',
                message: obj.msg,
                callback:function(){
                    $("#username").focus();
                }
            });
        }
    }
});