/**
 * 方法描述:中心页面JS
 * @author 小刘
 * @date 2015/10/24
 * @version v1.0
 */
var tab;
$(function($) {
    tab = new Tab();
    $('iframe_id').iframeAutoHeight({debug: true});
});

//设置路劲
function url(id, url,title){
    tab.addItem({id:id, title:title, url: url});
    //$('#iframe_id').attr("src",url);
}

//设置class元素
function setActive(obj){
    //$(".nav .nav-list li").removeClass("active");
    //$(obj).addClass("active");
}

