/**
 * 方法描述:分配权限
 * @author 小刘
 * @version v1.0
 * @date 2015/10/28
 */
$(function(){
    var setting = {
        check: {
            enable: true
        },
        data: {
            simpleData: {
                enable: true,
                idKey: "id",
                pIdKey: "parentId",
                rootPId: null
            }
        }
    };

    //获取JSON数据集
    var zNodes = treeList;

    //初始化树
    $.fn.zTree.init($("#tree"), setting, zNodes);

    //提交权限
    $("#sub").click(function(){
        var treeObj = $.fn.zTree.getZTreeObj("tree");
        var checkCount = treeObj.getCheckedNodes(true);
        var treeArray = "";
        for(var i=0;i<checkCount.length;i++) {
            treeArray += checkCount[i].id +",";
        }
        $.ajax({
            type:"POST",
            url:"menu/roleRoot",
            dataType:"json",
            data:{treeList:treeArray,role_id:$("#roleId").val()},
            success:function(data){
                var code = parseInt(data.code);
                if(code == 0){
                    top.bootbox.alert({
                        size: 'small',
                        title:'提示:',
                        message: data.msg,
                        callback: function(){
                            //跳转到用户列表
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
    });
});
