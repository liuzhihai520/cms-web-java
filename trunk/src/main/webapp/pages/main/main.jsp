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
    <title>Dashboard - Ace Admin</title>

    <meta name="description" content="overview &amp; stats" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="static/ace/css/bootstrap.css" />
    <link rel="stylesheet" href="static/ace/css/font-awesome.css" />

    <!-- page specific plugin styles -->

    <!-- text fonts -->
    <link rel="stylesheet" href="static/ace/css/ace-fonts.css" />

    <!-- ace styles -->
    <link rel="stylesheet" href="static/ace/css/ace.css" class="ace-main-stylesheet" id="main-ace-style" />

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
</head>

<body class="no-skin">
<!-- #section:basics/navbar.layout -->
<div id="navbar" class="navbar navbar-default">
    <script type="text/javascript">
        try{ace.settings.check('navbar' , 'fixed')}catch(e){}
    </script>

    <div class="navbar-container" id="navbar-container">

        <!-- 标题 -->
        <div class="navbar-header pull-left">
            <a href="#" class="navbar-brand">
                <small>
                    <i class="fa fa-leaf"></i>
                    Ace Admin
                </small>
            </a>
        </div>

        <!-- 右边导航 -->
        <div class="navbar-buttons navbar-header pull-right" role="navigation">
            <ul class="nav ace-nav">

                <!-- 菜单 -->
                <li class="light-blue">
                    <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                        <img class="nav-user-photo" src="static/ace/avatars/user.jpg" alt="Jason's Photo" />
                            <span class="user-info"><small>Welcome,</small>Jason</span>
                        <i class="ace-icon fa fa-caret-down"></i>
                    </a>

                    <ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
                        <li>
                            <a href="#">
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

    <!-- 菜单图片 -->
    <div id="sidebar" class="sidebar responsive">
        <script type="text/javascript">
            try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
        </script>

        <div class="sidebar-shortcuts" id="sidebar-shortcuts">
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

            <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
                <span class="btn btn-success"></span>

                <span class="btn btn-info"></span>

                <span class="btn btn-warning"></span>

                <span class="btn btn-danger"></span>
            </div>
        </div>

        <!-- 下拉菜单 -->
        <ul class="nav nav-list">
            <li class="active">
                <a href="index.html">
                    <i class="menu-icon fa fa-tachometer"></i>
                    <span class="menu-text"> Dashboard </span>
                </a>
                <b class="arrow"></b>
            </li>

            <li class="">
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon fa fa-desktop"></i>
							<span class="menu-text">
								UI &amp; Elements
							</span>

                    <b class="arrow fa fa-angle-down"></b>
                </a>

                <b class="arrow"></b>

                <ul class="submenu">
                    <li class="">
                        <a href="#" class="dropdown-toggle">
                            <i class="menu-icon fa fa-caret-right"></i>

                            Layouts
                            <b class="arrow fa fa-angle-down"></b>
                        </a>

                        <b class="arrow"></b>

                        <ul class="submenu">
                            <li class="">
                                <a href="top-menu.html">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Top Menu
                                </a>

                                <b class="arrow"></b>
                            </li>

                            <li class="">
                                <a href="two-menu-1.html">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Two Menus 1
                                </a>

                                <b class="arrow"></b>
                            </li>

                            <li class="">
                                <a href="two-menu-2.html">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Two Menus 2
                                </a>

                                <b class="arrow"></b>
                            </li>

                            <li class="">
                                <a href="mobile-menu-1.html">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Default Mobile Menu
                                </a>

                                <b class="arrow"></b>
                            </li>

                            <li class="">
                                <a href="mobile-menu-2.html">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Mobile Menu 2
                                </a>

                                <b class="arrow"></b>
                            </li>

                            <li class="">
                                <a href="mobile-menu-3.html">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    Mobile Menu 3
                                </a>

                                <b class="arrow"></b>
                            </li>
                        </ul>
                    </li>

                    <li class="">
                        <a href="typography.html">
                            <i class="menu-icon fa fa-caret-right"></i>
                            Typography
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="">
                        <a href="elements.html">
                            <i class="menu-icon fa fa-caret-right"></i>
                            Elements
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="">
                        <a href="buttons.html">
                            <i class="menu-icon fa fa-caret-right"></i>
                            Buttons &amp; Icons
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="">
                        <a href="content-slider.html">
                            <i class="menu-icon fa fa-caret-right"></i>
                            Content Sliders
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="">
                        <a href="treeview.html">
                            <i class="menu-icon fa fa-caret-right"></i>
                            Treeview
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="">
                        <a href="jquery-ui.html">
                            <i class="menu-icon fa fa-caret-right"></i>
                            jQuery UI
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="">
                        <a href="nestable-list.html">
                            <i class="menu-icon fa fa-caret-right"></i>
                            Nestable Lists
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="">
                        <a href="#" class="dropdown-toggle">
                            <i class="menu-icon fa fa-caret-right"></i>

                            Three Level Menu
                            <b class="arrow fa fa-angle-down"></b>
                        </a>

                        <b class="arrow"></b>

                        <ul class="submenu">
                            <li class="">
                                <a href="#">
                                    <i class="menu-icon fa fa-leaf green"></i>
                                    Item #1
                                </a>

                                <b class="arrow"></b>
                            </li>

                            <li class="">
                                <a href="#" class="dropdown-toggle">
                                    <i class="menu-icon fa fa-pencil orange"></i>

                                    4th level
                                    <b class="arrow fa fa-angle-down"></b>
                                </a>

                                <b class="arrow"></b>

                                <ul class="submenu">
                                    <li class="">
                                        <a href="#">
                                            <i class="menu-icon fa fa-plus purple"></i>
                                            Add Product
                                        </a>

                                        <b class="arrow"></b>
                                    </li>

                                    <li class="">
                                        <a href="#">
                                            <i class="menu-icon fa fa-eye pink"></i>
                                            View Products
                                        </a>

                                        <b class="arrow"></b>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                </ul>
            </li>
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

                <!-- 搜索 -->
                <div class="nav-search" id="nav-search">
                    <form class="form-search">
								<span class="input-icon">
									<input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
									<i class="ace-icon fa fa-search nav-search-icon"></i>
								</span>
                    </form>
                </div>
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

                <!-- 导航显示 -->
                <div class="page-header">
                    <h1>
                        Dashboard
                        <small>
                            <i class="ace-icon fa fa-angle-double-right"></i>
                            overview &amp; stats
                        </small>
                    </h1>
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
<script src="static/ace/js/bootstrap.js"></script>

<!-- page specific plugin scripts -->

<!--[if lte IE 8]>
<script src="static/ace/js/excanvas.js"></script>
<![endif]-->
<script src="static/ace/js/jquery-ui.custom.js"></script>
<script src="static/ace/js/jquery.ui.touch-punch.js"></script>
<!-- ace scripts -->
<script src="static/ace/js/ace/elements.scroller.js"></script>
<script src="static/ace/js/ace/elements.colorpicker.js"></script>
<script src="static/ace/js/ace/elements.fileinput.js"></script>
<script src="static/ace/js/ace/elements.typeahead.js"></script>
<script src="static/ace/js/ace/elements.wysiwyg.js"></script>
<script src="static/ace/js/ace/elements.spinner.js"></script>
<script src="static/ace/js/ace/elements.treeview.js"></script>
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
<script src="static/ace/js/ace/ace.searchbox-autocomplete.js"></script>

<!-- 与此页相关的内联脚本 -->
<script type="text/javascript" src="static/javascript/main/main.js"></script>
</body>
</html>