/**
 * 方法描述:修改菜单
 * @author 小刘
 * @date 2015/10/24
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
            name:{
                message: '菜单名称',
                validators: {
                    notEmpty: {
                        message: '菜单名不能为空'
                    },
                    stringLength: {
                        min: 2,
                        max: 12,
                        message: '菜单名长度为2-12'
                    }
                }
            },
            resKey:{
                message: 'resKey无效',
                validators: {
                    notEmpty: {
                        message: 'resKey不能为空'
                    },
                    stringLength: {
                        min: 2,
                        max: 12,
                        message: 'resKey长度为4-12'
                    }
                }
            },
            url:{
                message: 'url无效',
                validators: {
                    notEmpty: {
                        message: 'url不能为空'
                    },
                    stringLength: {
                        min: 1,
                        max: 30,
                        message: 'url长度为1-30'
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

    $("#reset").click(function(){
        validate.data('bootstrapValidator').resetForm(true);
    });

    $("#check").click(function(){
        if($('#check').is(':checked')){
            $("#ishide").val(1);
        }else{
            $("#ishide").val(2);
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
            message: obj.msg,
            callback: function(){
                window.location.href = "sys/menusList";
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
