/**
 * 方法描述:用户角色
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
            $("#status").val(1);
        }else{
            $("#status").val(2);
        }
    });
});
