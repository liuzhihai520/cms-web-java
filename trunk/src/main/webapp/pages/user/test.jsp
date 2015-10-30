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
  <script src="static/ace/js/jquery1x.js"></script>
  <script src="static/ace/js/bootstrap.js"></script>
  <script src="static/ace/js/ace/ace.js"></script>
  <script src="static/ace/js/ace-elements.js"></script>
  <script src="static/ace/js/fuelux/fuelux.tree.js"></script>
  <script>
      var list = ${ns};
  </script>
  <script src="static/javascript/user/test.js"></script>
</head>
<body class="no-skin" style="background-color: white;">
    <div class="col-sm-6">
        <div class="widget-box widget-color-blue2">
            <div class="widget-header">
                <h4 class="widget-title lighter smaller">Choose Categories</h4>
            </div>
            <div class="widget-body">
                <div class="widget-main padding-8">
                    <ul id="treeView" class="tree tree-selectable" role="tree"></ul>
                </div>
                <div class="hr"></div>
                <button id="submit-button" type="button" class="btn btn-sm btn-primary pull-right">
                    <i class="ace-icon fa fa-check"></i>
                    Submit
                </button>
            </div>
        </div>
    </div>
</body>
</html>