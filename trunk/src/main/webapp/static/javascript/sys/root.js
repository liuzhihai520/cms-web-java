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
});
