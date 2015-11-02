/**
 * 方法描述:菜单管理列表
 * @author 小刘
 * @date 2015/10/27
 * @version v1.0
 */
$(function(){
    $("#addMenu").click(function(){
      window.location.href = "menu/initMenu";
    });
});

//删除菜单
function deleteMenu(menuId){
    top.bootbox.confirm({
        message: "<span class='bigger-110' style='color: red;'>注意!!删除菜单会删除该菜单所有子菜单,是否继续?</span>",
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
                $.ajax({
                    type:"POST",
                    url:"sys/deleteMenu",
                    dataType:"json",
                    data:{menuId:menuId},
                    success:function(data){
                        var obj = data;
                        if(obj.code == 0){
                            top.bootbox.alert({
                                size: 'small',
                                title:'提示:',
                                message: data.msg,
                                callback: function(){
                                    window.location.href = "menu/menusList";
                                }
                            });
                        }else{
                            top.bootbox.alert({
                                size: 'small',
                                title:'提示:',
                                message: data.msg
                            });
                        }
                    },
                    error:function(){
                        top.bootbox.alert({
                            size: 'small',
                            title:'提示:',
                            message: '系统异常,请联系管理员'
                        });
                    }
                });
            }
        }
    });
}
