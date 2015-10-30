<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8" />
    <title>系统管理 - 角色权限分配</title>
    <meta name="description" content="overview &amp; stats" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
    <link rel="stylesheet" href="static/ace/css/bootstrap.css" />
    <link rel="stylesheet" href="static/ace/css/font-awesome.css" />
    <link rel="stylesheet" href="static/ace/css/ace-fonts.css" />
    <link rel="stylesheet" href="static/ace/css/ace.css" class="ace-main-stylesheet" id="main-ace-style" />
    <link rel="stylesheet" href="static/js/zTree/css/metroStyle/metroStyle.css"/>
    <script src="static/ace/js/jquery1x.js"></script>
    <script src="static/js/zTree/js/jquery.ztree.core-3.5.min.js"></script>
    <script src="static/js/zTree/js/jquery.ztree.excheck-3.5.min.js"></script>
    <script type="text/javascript">
        var treeList = ${treeList};
    </script>
    <script type="text/javascript" src="static/javascript/sys/root.js"></script>
</head>
<body class="no-skin" style="background-color: white;">
<input type="hidden" id="roleId" name="roleId" value="${roleId}"/>
<div class="row">
    <div class="col-xs-12">
        <div class="widget-box widget-color-blue2">
            <div class="widget-header">
                <h4 class="widget-title lighter smaller">Choose Categories</h4>
            </div>

            <div class="widget-body">
                <div class="widget-main padding-8">
                    <ul id="tree" class="ztree" role="tree"></ul>
                </div>
            </div>
        </div>
        <button class="btn btn-info" type="button" id="sub">
            <i class="ace-icon fa fa-check bigger-110"></i>
            Submit
        </button>

        &nbsp; &nbsp; &nbsp;
        <button class="btn" type="button">
            <i class="ace-icon fa fa-undo bigger-110"></i>
            Cancel
        </button>
    </div>
</div>
</body>
</html>