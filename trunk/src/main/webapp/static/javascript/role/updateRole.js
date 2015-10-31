/**
 * 方法描述:修改角色
 * @author 小刘
 * @version v1.0
 * @date 2015/10/30
 */
$(function(){

    $("#form").bootstrapValidator({
        message: '这个值无效',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            name:{
                message: '角色名无效',
                validators: {
                    notEmpty: {
                        message: '角色名不能为空'
                    },
                    stringLength: {
                        min: 2,
                        max: 6,
                        message: '角色名长度为2-6'
                    }
                }
            },
            roleKey:{
                message: 'roleKey无效',
                validators: {
                    notEmpty: {
                        message: 'roleKey不能为空'
                    },
                    stringLength: {
                        min: 4,
                        max: 12,
                        message: 'roleKey长度为2-6'
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
                window.location.href = "role/roleList";
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