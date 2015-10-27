/**
 * 方法描述:TODO
 * @author 小刘
 * @date 2015/10/27
 * @version v1.0
 */
$(function(){

    var remoteUrl = 'user/treeView';

    var remoteDateSource = function(options, callback) {
        var parent_id = null
        if( !('text' in options || 'type' in options) ){
            parent_id = 0;//load first level data
        }
        else if('type' in options && options['type'] == 'folder') {//it has children
            if('additionalParameters' in options && 'children' in options.additionalParameters)
                parent_id = options.additionalParameters['id']
        }

        if(parent_id !== null) {
            $.ajax({
                url: remoteUrl,
                data: 'id='+parent_id,
                type: 'POST',
                dataType: 'json',
                success : function(response) {
                    if(response.status == "OK")
                        callback({ data: response.data })
                },
                error: function(response) {
                    //console.log(response);
                }
            })
        }
    }

    $('#treeView').ace_tree({
        dataSource: list,
        multiSelect: true,
        loadingHTML: '<div class="tree-loading"><i class="ace-icon fa fa-refresh fa-spin blue"></i></div>',
        'open-icon' : 'ace-icon tree-minus',
        'close-icon' : 'ace-icon tree-plus',
        'selectable' : true,
        'selected-icon' : 'ace-icon fa fa-check',
        'unselected-icon' : 'ace-icon fa fa-times',
        cacheItems: true,
        folderSelect: false
    });
});
