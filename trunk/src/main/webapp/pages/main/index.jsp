<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>/">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8" />
    <title>Login Page - Ace Admin</title>
    <meta name="description" content="User login page" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
    <link rel="stylesheet" href="static/ace/css/bootstrap.css" />
    <link rel="stylesheet" href="static/ace/css/font-awesome.css" />
    <link rel="stylesheet" href="static/ace/css/ace-fonts.css" />
    <link rel="stylesheet" href="static/ace/css/ace.css" />
    <link rel="stylesheet" href="static/ace/css/ace-rtl.css" />
    <script src="static/ace/js/jquery1x.js"></script>
    <script src="static/ace/js/bootstrap.js"></script>
    <script src="static/ace/js/ace/ace.js"></script>
    <script src="static/ace/js/bootbox.js"></script>
    <script src="static/ace/js/jquery.mobile.custom.js"></script>
    <script>
        var data = ${data};
    </script>
    <script src="static/javascript/login/login.js"></script>
</head>

<body class="login-layout">
    <div class="main-container">
        <div class="main-content">
            <div class="row">
                <div class="col-sm-10 col-sm-offset-1">
                    <div class="login-container">
                        <div class="center">
                            <h1>
                                <i class="ace-icon fa fa-leaf green"></i>
                                <span class="red">Ace</span>
                                <span class="white" id="id-text2">Application</span>
                            </h1>
                            <h4 class="blue" id="id-company-text">&copy; Company Name</h4>
                        </div>
                        <div class="space-6"></div>

                        <div class="position-relative">
                            <div id="login-box" class="login-box visible widget-box no-border">
                                <div class="widget-body">
                                    <div class="widget-main">
                                        <h4 class="header blue lighter bigger">
                                            <i class="ace-icon fa fa-coffee green"></i>
                                            请输入你的登录信息
                                        </h4>

                                        <div class="space-6"></div>
                                        <form action="sys/login" id="form" name="form" method="post">
                                            <fieldset>
                                                <label class="block clearfix">
                                                        <span class="block input-icon input-icon-right">
                                                            <input type="text" class="form-control" id="username" maxlength="20"
                                                                   name="username" placeholder="用户名"/>
                                                            <i class="ace-icon fa fa-user"></i>
                                                        </span>
                                                </label>

                                                <label class="block clearfix">
                                                        <span class="block input-icon input-icon-right">
                                                            <input type="password" id="password" name="password" maxlength="20"
                                                                   class="form-control" placeholder="密码"/>
                                                            <i class="ace-icon fa fa-lock"></i>
                                                        </span>
                                                </label>

                                                <label class="block clearfix">
                                                    <span class="block input-icon input-icon-right">
                                                        <input type="text" id="validateCode" name="validateCode" placeholder="四位字符验证码" maxlength="4"/>
                                                        <img id="captcha"src="code"/>
                                                    </span>
                                                </label>

                                                <div class="space"></div>

                                                <div class="clearfix">
                                                    <label class="inline">
                                                        <input type="checkbox" class="ace"/>
                                                        <span class="lbl"> 记住我</span>
                                                    </label>

                                                    <button type="button" class="width-35 pull-right btn btn-sm btn-primary" id="login">
                                                        <i class="ace-icon fa fa-key"></i>
                                                        <span class="bigger-110">登录</span>
                                                    </button>
                                                </div>

                                                <div class="space-4"></div>
                                            </fieldset>
                                        </form>

                                        <!--
                                        <div class="social-or-login center">
                                            <span class="bigger-110">Or Login Using</span>
                                        </div>

                                        <div class="space-6"></div>

                                        <div class="social-login center">
                                            <a class="btn btn-primary">
                                                <i class="ace-icon fa fa-facebook"></i>
                                            </a>

                                            <a class="btn btn-info">
                                                <i class="ace-icon fa fa-twitter"></i>
                                            </a>

                                            <a class="btn btn-danger">
                                                <i class="ace-icon fa fa-google-plus"></i>
                                            </a>
                                        </div>
                                        -->
                                    </div>

                                    <div class="toolbar clearfix">
                                        <div>
                                            <a href="javascript:;" data-target="#forgot-box" class="forgot-password-link">
                                                <i class="ace-icon fa fa-arrow-left"></i>I forgot my password
                                            </a>
                                        </div>
                                        <div>
                                            <a href="javascript:;" data-target="#signup-box" class="user-signup-link">
                                                I want to register
                                                <i class="ace-icon fa fa-arrow-right"></i>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- 忘记密码 -->
                            <div id="forgot-box" class="forgot-box widget-box no-border">
                                <div class="widget-body">
                                    <div class="widget-main">
                                        <h4 class="header red lighter bigger">
                                            <i class="ace-icon fa fa-key"></i>
                                            Retrieve Password
                                        </h4>

                                        <div class="space-6"></div>
                                        <p>Enter your email and to receive instructions</p>

                                        <form>
                                            <fieldset>
                                                <label class="block clearfix">
                                                        <span class="block input-icon input-icon-right">
                                                            <input type="email" class="form-control" placeholder="Email"/>
                                                            <i class="ace-icon fa fa-envelope"></i>
                                                        </span>
                                                </label>

                                                <div class="clearfix">
                                                    <button type="button" class="width-35 pull-right btn btn-sm btn-danger">
                                                        <i class="ace-icon fa fa-lightbulb-o"></i>
                                                        <span class="bigger-110">Send Me!</span>
                                                    </button>
                                                </div>
                                            </fieldset>
                                        </form>
                                    </div>

                                    <div class="toolbar center">
                                        <a href="#" data-target="#login-box" class="back-to-login-link">
                                            Back to login
                                            <i class="ace-icon fa fa-arrow-right"></i>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="navbar-fixed-top align-right">
                            <br/>
                            &nbsp;
                            <a id="btn-login-dark" href="#">Dark</a>
                            &nbsp;
                            <span class="blue">/</span>
                            &nbsp;
                            <a id="btn-login-blur" href="#">Blur</a>
                            &nbsp;
                            <span class="blue">/</span>
                            &nbsp;
                            <a id="btn-login-light" href="#">Light</a>
                            &nbsp; &nbsp; &nbsp;
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>