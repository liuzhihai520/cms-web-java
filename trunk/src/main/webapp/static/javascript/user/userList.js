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
