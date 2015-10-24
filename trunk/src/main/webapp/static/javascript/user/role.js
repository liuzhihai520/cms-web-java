/**
 * 方法描述:用户角色
 * @author 小刘
 * @date 2015/10/24
 * @version v1.0
 */
$(function(){
    $("body").on("shown.bs.modal", ".modal", function() {
        $(this).find('div.modal-dialog').css("top",$(parent.window.document).scrollTop());
    });
    $('#submit').on('click', function() {
        top.bootbox.confirm('Are you sure?', function(result) {
            if(result) {
            }else{
            }
        })
    })
});
