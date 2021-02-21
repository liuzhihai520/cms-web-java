<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <title>Dashboard - Ace Admin</title>

    <meta name="description" content="overview &amp; stats" />
    <!-- 处理移动端标签 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="static/ace/css/bootstrap.css" />
    <link rel="stylesheet" href="static/ace/css/font-awesome.css" />

    <!-- page specific plugin styles -->

    <!-- text fonts -->
    <link rel="stylesheet" href="static/ace/css/ace-fonts.css" />

    <!-- ace styles -->
    <link rel="stylesheet" href="static/ace/css/ace.css" class="ace-main-stylesheet" id="main-ace-style" />

    <!-- tabclose -->
    <link rel="stylesheet" href="static/ace/css/tabbale_close.css" class="stylesheet"  />
    <link rel="stylesheet" href="static/ace/css/font-awesome.min.css" class="stylesheet"  />

    <!--[if lte IE 9]>
    <link rel="stylesheet" href="static/ace/css/ace-part2.css" class="ace-main-stylesheet" />
    <![endif]-->

    <!--[if lte IE 9]>
    <link rel="stylesheet" href="static/ace/css/ace-ie.css" />
    <![endif]-->

    <!-- inline styles related to this page -->

    <!-- ace settings handler -->
    <script src="static/ace/js/ace-extra.js"></script>

    <!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

    <!--[if lte IE 8]>
    <script src="static/ace/js/html5shiv.js"></script>
    <script src="static/ace/js/respond.js"></script>
    <![endif]-->
    <!-- basic scripts -->

    <!--[if !IE]> -->
    <script type="text/javascript">
        window.jQuery || document.write("<script src='static/ace/js/jquery.js'>"+"<"+"/script>");
    </script>

    <!-- <![endif]-->

    <!--[if IE]>
    <script type="text/javascript">
        window.jQuery || document.write("<script src='static/ace/js/jquery1x.js'>"+"<"+"/script>");
    </script>
    <![endif]-->
    <script type="text/javascript">
        if('ontouchstart' in document.documentElement) document.write("<script src='static/ace/js/jquery.mobile.custom.js'>"+"<"+"/script>");
    </script>
    <script type="text/javascript" src="static/js/jquery.iframe-auto-height.js"></script>
    <script type="text/javascript" src="static/js/jquery.browser.js"></script>
</head>

<body class="no-skin">

<!-- top -->
<div id="navbar" class="navbar navbar-default">
    <script type="text/javascript">
        try{ace.settings.check('navbar' , 'fixed')}catch(e){}
    </script>

    <div class="navbar-container" id="navbar-container">

        <!-- 标题 -->
        <div class="navbar-header pull-left">
            <a href="/" class="navbar-brand">
                <small>
                    <i class="fa fa-leaf"></i>
                    Ace Admin
                </small>
            </a>
        </div>

        <!-- 右边导航 -->
        <div class="navbar-buttons navbar-header pull-right" role="navigation">
            <ul class="nav ace-nav">
                <!-- 个人中心菜单 -->
                <li class="light-blue">
                    <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                        <img class="nav-user-photo" src="static/ace/avatars/user.jpg" alt="Jason's Photo" />
                            <span class="user-info"><small>Welcome,</small>Jason</span>
                        <i class="ace-icon fa fa-caret-down"></i>
                    </a>

                    <ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
                        <li>
                            <a href="logout">
                                <i class="ace-icon fa fa-power-off"></i>
                                Logout
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>

<!-- 菜单 -->
<div class="main-container" id="main-container">
    <script type="text/javascript">
        try{ace.settings.check('main-container' , 'fixed')}catch(e){}
    </script>

    <!-- 菜单SideBar -->
    <div id="sidebar" class="sidebar responsive">
        <script type="text/javascript">
            try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
        </script>

        <!-- 菜单顶部图标 -->
        <div class="sidebar-shortcuts" id="sidebar-shortcuts">
            <!-- 最大化显示 -->
            <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
                <button class="btn btn-success">
                    <i class="ace-icon fa fa-signal"></i>
                </button>
                <button class="btn btn-info">
                    <i class="ace-icon fa fa-pencil"></i>
                </button>
                <button class="btn btn-warning">
                    <i class="ace-icon fa fa-users"></i>
                </button>
                <button class="btn btn-danger">
                    <i class="ace-icon fa fa-cogs"></i>
                </button>
            </div>
            <!-- 最小化显示 -->
            <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
                <span class="btn btn-success"></span>
                <span class="btn btn-info"></span>
                <span class="btn btn-warning"></span>
                <span class="btn btn-danger"></span>
            </div>
        </div>

        <!-- 下拉菜单 -->
        <ul class="nav nav-list">
            <!-- 第一层菜单 -->
            <!-- active表示选中加粗 -->
            <c:forEach items="${menuList}" var="obj" varStatus="status">
                <li class="" onclick="setActive(this)">
                    <a href="javascript:;" class="dropdown-toggle">
                        <i class="menu-icon fa ${obj.icon}"></i>
                        <span class="menu-text"> ${obj.name} </span>
                        <c:if test="${obj.children != null and fn:length(obj.children) > 0}">
                            <b class="arrow fa fa-angle-down"></b>
                        </c:if>
                    </a>
                    <b class="arrow"></b>
                    <c:if test="${obj.children != null and fn:length(obj.children) > 0}">
                        <ul class="submenu">
                            <c:forEach items="${obj.children}" var="child">
                                <li class="" onclick="setActive(this)">
                                    <a href="javascript:;" onclick="url(${child.id}, '${child.url}', '${child.name}')">
                                        <i class="menu-icon fa fa-caret-right"></i>
                                        ${child.name}
                                    </a>
                                    <b class="arrow"></b>
                                </li>
                            </c:forEach>
                        </ul>
                    </c:if>
                </li>
            </c:forEach>
        </ul>

        <!-- #section:basics/sidebar.layout.minimize -->
        <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
            <i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
        </div>

        <!-- /section:basics/sidebar.layout.minimize -->
        <script type="text/javascript">
            try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
        </script>
    </div>

    <!-- 内容 -->
    <div class="main-content">
        <div class="main-content-inner">
            <!-- 导航 -->
            <div class="breadcrumbs" id="breadcrumbs">
                <script type="text/javascript">
                    try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
                </script>
                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="#">Home</a>
                    </li>
                    <li class="active">Dashboard</li>
                </ul>
            </div>

            <!-- 页面内容 -->
            <div class="page-content">
                <!-- 样式设置按钮 -->
                <div class="ace-settings-container" id="ace-settings-container">
                    <div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
                        <i class="ace-icon fa fa-cog bigger-130"></i>
                    </div>

                    <div class="ace-settings-box clearfix" id="ace-settings-box">
                        <div class="pull-left width-50">
                            <!-- 选择皮肤 -->
                            <div class="ace-settings-item">
                                <div class="pull-left">
                                    <select id="skin-colorpicker" class="hide">
                                        <option data-skin="no-skin" value="#438EB9">#438EB9</option>
                                        <option data-skin="skin-1" value="#222A2D">#222A2D</option>
                                        <option data-skin="skin-2" value="#C6487E">#C6487E</option>
                                        <option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
                                    </select>
                                </div>
                                <span>&nbsp; Choose Skin</span>
                            </div>

                            <!-- 设置navBar -->
                            <div class="ace-settings-item">
                                <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-navbar" />
                                <label class="lbl" for="ace-settings-navbar"> Fixed Navbar</label>
                            </div>

                            <!-- 设置sideBar -->
                            <div class="ace-settings-item">
                                <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-sidebar" />
                                <label class="lbl" for="ace-settings-sidebar"> Fixed Sidebar</label>
                            </div>

                            <!-- 设置breadcrumbs -->
                            <div class="ace-settings-item">
                                <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-breadcrumbs" />
                                <label class="lbl" for="ace-settings-breadcrumbs"> Fixed Breadcrumbs</label>
                            </div>

                            <!-- #设置左右菜单显示 -->
                            <div class="ace-settings-item">
                                <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl" />
                                <label class="lbl" for="ace-settings-rtl"> Right To Left (rtl)</label>
                            </div>

                            <!-- 设置居中显示 -->
                            <div class="ace-settings-item">
                                <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-add-container" />
                                <label class="lbl" for="ace-settings-add-container">
                                    Inside
                                    <b>.container</b>
                                </label>
                            </div>
                        </div>

                        <!-- 第二列显示设置 -->
                        <div class="pull-left width-50">
                            <div class="ace-settings-item">
                                <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-hover" />
                                <label class="lbl" for="ace-settings-hover"> Submenu on Hover</label>
                            </div>

                            <div class="ace-settings-item">
                                <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-compact" />
                                <label class="lbl" for="ace-settings-compact"> Compact Sidebar</label>
                            </div>

                            <div class="ace-settings-item">
                                <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-highlight" />
                                <label class="lbl" for="ace-settings-highlight"> Alt. Active Item</label>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- 导航显示
                <div class="page-header">
                    <h1>
                        Dashboard
                        <small>
                            <i class="ace-icon fa fa-angle-double-right"></i>
                            overview &amp; stats
                        </small>
                    </h1>
                </div> -->

                <div class="tabbable" id="main_tab">
                    <ul class="nav nav-tabs">
                        <li style="display:none;" class="active">
                            <a data-toggle="tab" href="#search0">占位标记</a>
														<span class="closeico">
															<i  class="icon-remove" class="close" ></i>
														</span>
                        </li>
                        <li class="active">

                            <a data-toggle="tab" href="#search1">
                                王小明
                                <span class="closeico"><i  class="icon-remove" class="close" ></i></span>
                            </a>

                        </li>

                        <li >
                            <a data-toggle="tab" href="#search2"  id="a123">
                                name：chuck
                                <span class="closeico"><i  class="icon-remove" class="close" ></i></span>
                            </a>
                        </li>
                        <li >
                            <a data-toggle="tab" href="#search3"  id="a1234">
                                aaaaaaa
                                <span class="closeico"><i  class="icon-remove" class="close" ></i></span>
                            </a>
                        </li>
                    </ul>
                    <div class="tab-content">
                        <div id="search0" class="tab-pane active" style="display:none;"> <p>占位标记</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- 页脚 -->
    <div class="footer">
        <div class="footer-inner">
            <div class="footer-content">
                <span class="bigger-120">
                    <span class="blue bolder">Ace</span>
                    Application &copy; 2013-2014
                </span>

                &nbsp; &nbsp;
                <span class="action-buttons">
                    <a href="#">
                        <i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
                    </a>

                    <a href="#">
                        <i class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
                    </a>

                    <a href="#">
                        <i class="ace-icon fa fa-rss-square orange bigger-150"></i>
                    </a>
                </span>
            </div>

        </div>
    </div>

    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
    </a>
</div>


<script src="static/ace/js/bootstrap.js"></script>

<!-- 手机访问时的jquery触摸插件 -->
<script src="static/ace/js/jquery-ui.custom.js"></script>
<script src="static/ace/js/jquery.ui.touch-punch.js"></script>
<!-- ace scripts -->
<script type="text/javascript" src="static/ace/js/ace/elements.scroller.js"></script>
<script src="static/ace/js/ace/elements.colorpicker.js"></script>
<script src="static/ace/js/ace/elements.wysiwyg.js"></script>
<script src="static/ace/js/ace/elements.spinner.js"></script>
<script src="static/ace/js/ace/elements.wizard.js"></script>
<script src="static/ace/js/ace/elements.aside.js"></script>
<script src="static/ace/js/ace/ace.js"></script>
<script src="static/ace/js/ace/ace.ajax-content.js"></script>
<script src="static/ace/js/ace/ace.touch-drag.js"></script>
<script src="static/ace/js/ace/ace.sidebar.js"></script>
<script src="static/ace/js/ace/ace.sidebar-scroll-1.js"></script>
<script src="static/ace/js/ace/ace.submenu-hover.js"></script>
<script src="static/ace/js/ace/ace.widget-box.js"></script>
<script src="static/ace/js/ace/ace.settings.js"></script>
<script src="static/ace/js/ace/ace.settings-rtl.js"></script>
<script src="static/ace/js/ace/ace.settings-skin.js"></script>
<script src="static/ace/js/ace/ace.widget-on-reload.js"></script>
<script src="static/ace/js/bootbox.js"></script>

<!-- 与此页相关的内联脚本 -->
<script src="static/javascript/main/main.js"></script>
<script src="static/javascript/common/Tab.js"></script>
</body>
</html>