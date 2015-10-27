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
    $("#login").click(function(){
      $("#form").submit();
   });
});
