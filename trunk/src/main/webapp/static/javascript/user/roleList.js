/**
 * 方法描述:角色列表
 * @author 小刘
 * @date 2015/10/27
 * @version v1.0
 */
$(function(){
    $("#addRole").click(function(){
        window.location.href = "pages/user/role.jsp"
    });
});

function deleteRole(roleId){
    top.bootbox.confirm({
        message: "<span class='bigger-110' style='color: red;'>是否删除该角色?删除后不可恢复!!!</span>",
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
                window.location.href = "user/deleteRole?role_id="+roleId;
            }
        }
    });
}