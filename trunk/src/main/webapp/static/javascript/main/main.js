/**
 * 方法描述:中心页面JS
 * @author 小刘
 * @date 2015/10/24
 * @version v1.0
 */
jQuery(function($) {
    $('iframe_id').iframeAutoHeight({debug: true});
});

function subMenu(menuId){
    $.ajax({
        type: "post",
        url: "sys/menuList",
        data: {menuId:menuId},
        dataType: "text",
        success: function(data){
            var json = $.parseJSON(data);
            console.log(json);
        }
    });
}
