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
    <script src="static/ace/js/dataTables/jquery.dataTables.js "></script>
    <script src="static/ace/js/dataTables/jquery.dataTables.bootstrap.js"></script>
    <script src="static/javascript/user/userList.js"></script>
</head>
<body class="no-skin" style="background-color: white;">
<div class="row">
    <button class="btn btn-white btn-info btn-round" style="margin-left: 12px;margin-bottom: 10px;">
        <i class="ace-icon fa fa-floppy-o bigger-120 blue"></i>
        新增
    </button>
    <div class="col-xs-12">
        <table class="table table-bordered table-hover">
            <thead>
                <tr>
                    <th>#</th>
                    <th>用户名</th>
                    <th>账号</th>
                    <th>所属角色</th>
                    <th>账号状态</th>
                    <th>时间</th>
                    <th>描述</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${userList}" var="obj">
                    <tr>
                        <th scope="row">${obj.id}</th>
                        <td>${obj.name}</td>
                        <td>${obj.accountname}</td>
                        <td>admin</td>
                        <td>${obj.status}</td>
                        <td>${obj.createTime}</td>
                        <td>${obj.description}</td>
                        <td>操作内容</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <nav>
            <span>总页数:0</span>
            <ul class="pagination" style="float: right;padding-right: 3px;margin-top: -2px;">
                <li>
                    <a href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li>
                    <a href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
</div>
</div>
</body>
</html>
