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
    <title>系统管理 - 添加用户</title>
    <meta name="description" content="overview &amp; stats" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
    <link rel="stylesheet" href="static/ace/css/bootstrap.css" />
    <link rel="stylesheet" href="static/ace/css/font-awesome.css" />
    <link rel="stylesheet" href="static/ace/css/ace-fonts.css" />
    <link rel="stylesheet" href="static/ace/css/ace.css" class="ace-main-stylesheet" id="main-ace-style" />
    <link rel="stylesheet" href="static/js/validator/css/bootstrapValidator.min.css" />
    <script src="static/ace/js/jquery1x.js"></script>
    <script src="static/js/validator/js/bootstrapValidator.min.js"></script>
    <script src="static/javascript/sys/updateMenu.js"></script>
</head>
<body class="no-skin" style="background-color: white;">
<div class="row">
    <div class="col-xs-12">
        <iframe name='hidden_frame' id="hidden_frame" style='display:none'></iframe>
        <form action="sys/updateMenu" class="form-horizontal" role="form" id="form" name="form" method="post" target="hidden_frame">
            <input type="hidden" id="id" name="id" value="${menu.id}"/>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="resName"> 菜单名称 </label>
                <div class="col-lg-4">
                    <input type="text" id="resName" name="name" value="${menu.name}" maxlength="20" placeholder="请输入菜单名称" class="form-control"/>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="resKey"> 菜单标识 </label>
                <div class="col-lg-4">
                    <input type="text" id="resKey" name="resKey" value="${menu.resKey}" maxlength="20" placeholder="请输入菜单标识" class="form-control"/>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="resURL"> 菜单URL </label>
                <div class="col-lg-4">
                    <input type="text" id="resURL" name="url" value="${menu.url}" maxlength="20" placeholder="请输入菜单URL" class="form-control"/>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="resList"> 上级菜单 </label>
                <div class="col-lg-4">
                    <select class="col-xs-5" id="resList" name="parentId">
                        <option value="0">------顶级目录------</option>
                        <c:forEach items="${treeList}" var="obj">
                            <option value="${obj.id}" <c:if test="${menu.parentId==obj.id}">selected="selected"</c:if>>${obj.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="resType"> 菜单类型 </label>
                <div class="col-lg-4">
                    <select class="col-xs-5" id="resType" name="type">
                        <option value="1" <c:if test="${menu.type==1}">selected="selected"</c:if>>------目录------</option>
                        <option value="2" <c:if test="${menu.type==2}">selected="selected"</c:if>>------菜单------</option>
                        <option value="3" <c:if test="${menu.type==3}">selected="selected"</c:if>>------元素------</option>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="resIcon"> 菜单图标 </label>
                <div class="col-lg-4">
                    <input type="text" id="resIcon" name="icon" value="${menu.icon}" maxlength="10" placeholder="请输入icon" class="form-control"/>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="check"> 是否隐藏 </label>
                <div class="col-lg-4">
                    <label>
                        <input type="hidden" id="ishide" name="ishide" value="${menu.ishide}"/>
                        <input id="check" name="check" <c:if test="${menu.ishide==1}">checked="checked"</c:if> class="ace ace-switch ace-switch-4 btn-empty" type="checkbox">
                        <span class="lbl" style="margin-top: 5px;"></span>
                    </label>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="description"> 描述 </label>
                <div class="col-lg-4">
                    <input type="text" id="description" name="description" value="${menu.description}" maxlength="15" placeholder="请输入菜单描述" class="form-control"/>
                </div>
            </div>

            <div class="clearfix form-actions">
                <div class="col-md-offset-3 col-md-9">
                    <button class="btn btn-info" type="submit" id="sub">
                        <i class="ace-icon fa fa-check bigger-110"></i>
                        Submit
                    </button>

                    &nbsp; &nbsp; &nbsp;
                    <button class="btn" type="button" onclick="javascript:history.back(-1);">
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