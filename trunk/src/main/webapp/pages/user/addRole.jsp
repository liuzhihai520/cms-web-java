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
  <!-- 处理移动端标签 -->
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
  <!-- bootstrap & fontawesome -->
  <link rel="stylesheet" href="static/ace/css/bootstrap.css" />
  <link rel="stylesheet" href="static/ace/css/font-awesome.css" />
  <!-- text fonts -->
  <link rel="stylesheet" href="static/ace/css/ace-fonts.css" />
  <!-- ace styles -->
  <link rel="stylesheet" href="static/ace/css/ace.css" class="ace-main-stylesheet" id="main-ace-style" />
  <script src="static/ace/js/jquery1x.js"></script>
  <script src="static/ace/js/jquery.validate.js"></script>
  <script src="static/javascript/user/role.js"></script>
</head>
<body class="no-skin" style="background-color: white;">
    <div class="row">
      <div class="col-xs-12">
        <form action="user/addRole" class="form-horizontal" role="form" id="form" name="form" method="post">

          <div class="form-group">
            <label class="col-sm-3 control-label no-padding-right" for="roleName"> 角色名 </label>
            <div class="col-sm-9">
              <input type="text" id="roleName" name="roleName" placeholder="roleName" class="col-xs-10 col-sm-5"/>
              <span class="help-inline col-xs-12 col-sm-7">
                  <span class="middle">Inline help text</span>
              </span>
            </div>
          </div>

          <div class="form-group">
            <label class="col-sm-3 control-label no-padding-right" for="roleKey"> roleKey </label>
            <div class="col-sm-9">
              <input type="text" id="roleKey" name="roleKey" placeholder="roleKey" class="col-xs-10 col-sm-5"/>
              <span class="help-inline col-xs-12 col-sm-7">
                  <span class="middle">Inline help text</span>
              </span>
            </div>
          </div>

          <div class="form-group">
            <label class="col-sm-3 control-label no-padding-right" for="description"> 描述 </label>
            <div class="col-sm-9">
              <input type="text" id="description" name="description" placeholder="description" class="col-xs-10 col-sm-5"/>
              <span class="help-inline col-xs-12 col-sm-7">
                  <span class="middle">Inline help text</span>
              </span>
            </div>
          </div>

          <div class="form-group">
            <label class="col-sm-3 control-label no-padding-right" for="check"> 状态 </label>
            <div class="col-sm-9">
                <label>
                    <input type="hidden" id="status" name="status" value="1"/>
                    <input id="check" name="check" checked="checked" class="ace ace-switch ace-switch-4 btn-empty" type="checkbox">
                    <span class="lbl" style="margin-top: 5px;"></span>
                </label>
            </div>
          </div>

          <div class="clearfix form-actions">
            <div class="col-md-offset-3 col-md-9">
              <button class="btn btn-info" type="button" id="sub">
                <i class="ace-icon fa fa-check bigger-110"></i>
                Submit
              </button>

              &nbsp; &nbsp; &nbsp;
              <button class="btn" type="reset">
                <i class="ace-icon fa fa-undo bigger-110"></i>
                Reset
              </button>
            </div>
          </div>
        </form>
      </div>
    </div>
</body>
</html>
