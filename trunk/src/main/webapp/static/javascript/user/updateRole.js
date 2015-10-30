/**
 * 方法描述:修改角色
 * @author 小刘
 * @version v1.0
 * @date 2015/10/30
 */
$(function(){
    $('#sub').on('click', function() {
        $("#form").submit();
    });

    $("#cancel").click(function(){
        javascript:history.back(-1);
    });

    $("#check").click(function(){
        if($('#check').is(':checked')){
            $("#status").val(1);
        }else{
            $("#status").val(2);
        }
    });
});

//回调函数
function callback(data){
    var obj = $.parseJSON(data);
    if(obj.code == 0){
        top.bootbox.alert({
            size: 'small',
            title:'提示:',
            message:obj.msg,
            callback: function(){
                window.location.href = "user/roleList";
            }
        });
    }else{
        top.bootbox.alert({
            size: 'small',
            title:'提示:',
            message: obj.msg
        });
    }
}