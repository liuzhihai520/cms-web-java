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
    <script src="static/ace/js/jquery1x.js"></script>
</head>
<body class="no-skin" style="background-color: white;">
<div class="row">
    <div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->

        <!-- #section:pages/error -->
        <div class="error-container">
            <div class="well">
                <h1 class="grey lighter smaller">
                    <span class="blue bigger-125">
                        <i class="ace-icon fa fa-sitemap"></i>
                        404
                    </span>
                    Page Not Found
                </h1>

                <hr>
                <h3 class="lighter smaller">We looked everywhere but we couldn't find it!</h3>

                <div>

                    <div class="space"></div>
                    <h4 class="smaller">Try one of the following:</h4>

                    <ul class="list-unstyled spaced inline bigger-110 margin-15">
                        <li>
                            <i class="ace-icon fa fa-hand-o-right blue"></i>
                            Re-check the url for typos
                        </li>

                        <li>
                            <i class="ace-icon fa fa-hand-o-right blue"></i>
                            Read the faq
                        </li>

                        <li>
                            <i class="ace-icon fa fa-hand-o-right blue"></i>
                            Tell us about it
                        </li>
                    </ul>
                </div>

                <hr>
                <div class="space"></div>

                <div class="center">
                    <a href="javascript:history.back()" class="btn btn-grey">
                        <i class="ace-icon fa fa-arrow-left"></i>
                        Go Back
                    </a>

                    <a href="#" class="btn btn-primary">
                        <i class="ace-icon fa fa-tachometer"></i>
                        Dashboard
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>