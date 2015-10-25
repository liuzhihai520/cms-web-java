/**
 * 方法描述:中心页面JS
 * @author 小刘
 * @date 2015/10/24
 * @version v1.0
 */
jQuery(function($) {
    $('iframe_id').iframeAutoHeight({debug: true});
});
//设置路劲
function url(url){
    $('#iframe_id').attr("src",url);
}

