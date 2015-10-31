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
    <title>系统管理 - 角色更新</title>
    <meta name="description" content="overview &amp; stats" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
    <link rel="stylesheet" href="static/ace/css/bootstrap.css" />
    <link rel="stylesheet" href="static/ace/css/font-awesome.css" />
    <link rel="stylesheet" href="static/ace/css/ace-fonts.css" />
    <link rel="stylesheet" href="static/ace/css/ace.css" class="ace-main-stylesheet" id="main-ace-style" />
    <link rel="stylesheet" href="static/js/validator/css/bootstrapValidator.min.css" />
    <script src="static/ace/js/jquery1x.js"></script>
    <script src="static/js/validator/js/bootstrapValidator.min.js"></script>
    <script src="static/javascript/user/updateRole.js?v=111111"></script>
</head>
<body class="no-skin" style="background-color: white;">
<div class="row">
    <div class="col-xs-12">
        <iframe name='hidden_frame' id="hidden_frame" style='display:none'></iframe>
        <form action="user/updateRole" class="form-horizontal" role="form" id="form" name="form" method="post" target="hidden_frame">
            <input type="hidden" id="id" name="id" value="${role.id}"/>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="name"> 角色名 </label>
                <div class="col-lg-4">
                    <input type="text" id="name" name="name" value="${role.name}" placeholder="roleName" class="form-control"/>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="roleKey"> roleKey </label>
                <div class="col-lg-4">
                    <input type="text" id="roleKey" name="roleKey" value="${role.roleKey}" placeholder="roleKey" class="form-control"/>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="description"> 描述 </label>
                <div class="col-lg-4">
                    <input type="text" id="description" name="description" value="${role.description}" placeholder="description" class="form-control"/>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="check"> 状态 </label>
                <div class="col-lg-4">
                    <label>
                        <input type="hidden" id="status" name="status" value="${role.status}"/>
                        <input id="check" name="check" <c:if test="${role.status == 1}">checked="checked"</c:if> class="ace ace-switch ace-switch-4 btn-empty" type="checkbox">
                        <span class="lbl" style="margin-top: 5px;"></span>
                    </label>
                </div>
            </div>

            <div class="clearfix form-actions">
                <div class="col-md-offset-3 col-md-9">
                    <button class="btn btn-info" type="submit" id="sub">
                        <i class="ace-icon fa fa-check bigger-110"></i>
                        Submit
                    </button>

                    &nbsp; &nbsp; &nbsp;
                    <button class="btn" type="button" id="cancel">
                        <i class="ace-icon fa fa-undo bigger-110"></i>
                        Cancel
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>