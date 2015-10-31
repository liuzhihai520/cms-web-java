/**
 * 方法描述:修改用户
 * @author 小刘
 * @date 2015/10/26
 * @version v1.0
 */
$(function(){
    $("#form").bootstrapValidator({
        message: '这个值无效',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        live:'enabled',
        excluded:[':disabled'],
        fields: {
            username:{
                message: '用户名无效',
                validators: {
                    notEmpty: {
                        message: '用户名不能为空'
                    },
                    stringLength: {
                        min: 2,
                        max: 12,
                        message: '用户名长度为2-12'
                    }
                }
            },
            description:{
                message: '描述无效',
                validators: {
                    notEmpty: {
                        message: '描述不能为空'
                    },
                    stringLength: {
                        min: 2,
                        max: 12,
                        message: '描述长度为2-12'
                    }
                }
            }
        }
    });

    $("#cancel").click(function(){
        javascript:history.back(-1);
    });
});

//回调函数
function callback(data){
    var obj = $.parseJSON(data);
    if(obj.code == 0){
        top.bootbox.alert({
            size: 'small',
            title:'提示:',
            message: obj.msg,
            callback: function(){
                window.location.href = "user/userList";
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
