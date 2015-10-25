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
            var html = "";
            for(var i=0;i<json.length;i++){
                html += "<ul class='submenu'><li>"+
                            "<a href='"+json[i].url+"' class='dropdown-toggle'>"+
                                "<i class='menu-icon fa fa-caret-right'></i>"+
                                "<span class='menu-text'>"+json[i].name+"</span>"+
                                "<b class='arrow fa fa-angle-down'></b>"+
                            "</a>"+
                        "</li></ul>";
            }
            $("#menu_"+menuId+" .submenu").html("");
            $("#menu_"+menuId).append(html);
        }
    });
}
