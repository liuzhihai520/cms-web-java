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
</head>
<body class="no-skin">
  <div class="row">
    <div class="col-xs-12">
    <form class="form-horizontal" role="form">

      <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 用户名: </label>
        <div class="col-sm-9">
          <input type="text" id="form-field-1" placeholder="Username" class="col-xs-10 col-sm-5">
        </div>
      </div>

      <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 昵称: </label>
        <div class="col-sm-9">
          <input type="text" id="accountName" placeholder="nick" class="col-xs-10 col-sm-5">
        </div>
      </div>

      <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 密码: </label>
        <div class="col-sm-9">
          <input type="password" id="form-field-2" placeholder="Password" class="col-xs-10 col-sm-5" value="123456" readonly/>
          <span class="help-inline col-xs-12 col-sm-7">
              <span class="middle">Inline help text</span>
          </span>
        </div>
      </div>

      <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 角色: </label>
        <div class="col-sm-9">
          <select class="col-xs-5" id="role">
            <option value="1">管理员</option>
            <option value="2">普通用户</option>
          </select>
          <span class="help-inline col-xs-12 col-sm-7">
              <span class="middle">Inline help text</span>
          </span>
        </div>
      </div>

      <div class="clearfix form-actions">
        <div class="col-md-offset-3 col-md-9">
          <button class="btn btn-info" type="button">
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
