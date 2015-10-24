/**
 * 方法描述:新增菜单
 * @author 小刘
 * @date 2015/10/24
 * @version v1.0
 */
$(function(){
    $('#sub').on('click', function() {
        $("#form").submit();
    });
    $("#check").click(function(){
        if($('#check').is(':checked')){
            $("#ishide").val(1);
        }else{
            $("#ishide").val(2);
        }
    });
});
