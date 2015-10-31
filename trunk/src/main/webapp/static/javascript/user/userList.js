/**
 * 方法描述:用户列表
 * @author 小刘
 * @date 2015/10/25
 * @version v1.0
 */
$(function(){
    //颜色选择
    $('#simple-colorpicker-1').ace_colorpicker({pull_right:true}).on('change', function(){
        var color_class = $(this).find('option:selected').data('class');
        var new_class = 'widget-box';
        if(color_class != 'default')  new_class += ' widget-color-'+color_class;
        $(this).closest('.widget-box').attr('class', new_class);
    });
    //新增用户
    $("#addUser").click(function(){
       window.location.href="user/initUser";
    });
});

//删除用户
function deleteUser(userId){
    top.bootbox.confirm({
        message: "<span class='bigger-110' style='color: red;'>是否删除该用户?删除后不可恢复!!!</span>",
        buttons: {
            confirm: {
                label: "OK",
                className: "btn-primary btn-sm",
            },
            cancel: {
                label: "Cancel",
                className: "btn-sm",
            }
        },
        callback: function(result) {
            if(result){
                window.location.href = "user/deleteUser?userId="+userId;
            }
        }
    });
}
