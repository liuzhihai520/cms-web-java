/**
 * 方法描述:添加用户
 * @author 小刘
 * @date 2015/10/26
 * @version v1.0
 */
$(function(){
   $("#sub").click(function(){
       $("#form").submit();
   });
});

//回调函数
function callback(status){
    var data = parseInt(status);
    if(data == 0){
        top.bootbox.alert({
            size: 'small',
            title:'提示:',
            message: "添加用户已成功",
            callback: function(){
                //跳转到用户列表
            }
        });
    }else{
        top.bootbox.alert({
            size: 'small',
            title:'提示:',
            message: "添加用户已失败",
            callback: function(){}
        });
    }
}
