<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta charset="utf-8"/>
    <title>系统管理 - 用户管理</title>
    <link rel="stylesheet" href="static/ace/css/bootstrap.css"/>
    <link rel="stylesheet" href="static/ace/css/font-awesome.css"/>
    <link rel="stylesheet" href="static/ace/css/ace-fonts.css"/>
    <link rel="stylesheet" href="static/ace/css/ace.css" class="ace-main-stylesheet" id="main-ace-style"/>
    <link rel="stylesheet" href="static/js/zTree/css/zTreeStyle/metro.css"/>
    <script src="static/ace/js/jquery1x.js"></script>
    <script src="static/ace/js/bootstrap.js"></script>
    <script src="static/ace/js/ace/ace.js"></script>
    <script src="static/ace/js/ace/ace.js"></script>
    <script src="static/js/zTree/js/jquery.ztree.core-3.5.min.js"></script>
    <script src="static/js/zTree/js/jquery.ztree.excheck-3.5.min.js"></script>
    <script>
        var treeList = ${treeList};
    </script>
    <script src="static/javascript/user/root.js"></script>
</head>
<body class="no-skin" style="background-color: white;">
    <div class="row" id="zTree">

    </div>
</body>
</html>
