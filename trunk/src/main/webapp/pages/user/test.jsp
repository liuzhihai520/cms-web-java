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
  <script src="static/ace/js/ace/elements.colorpicker.js"></script>
  <script src="static/ace/js/ace/ace.widget-box.js"></script>
    <script type="text/javascript">
        jQuery(function($) {
            //颜色选择
            $('#simple-colorpicker-1').ace_colorpicker({pull_right:true}).on('change', function(){
                var color_class = $(this).find('option:selected').data('class');
                var new_class = 'widget-box';
                if(color_class != 'default')  new_class += ' widget-color-'+color_class;
                $(this).closest('.widget-box').attr('class', new_class);
            });
        });
    </script>
</head>
<body class="no-skin" style="background-color: white;">
    <div class="col-xs-12 col-sm-6 widget-container-col ui-sortable" style="min-height: 263px;">
        <div class="widget-box widget-color-blue ui-sortable-handle">
            <!-- 设置table颜色 -->
            <div class="widget-header">
                <h5 class="widget-title bigger lighter">
                    <i class="ace-icon fa fa-table"></i>
                    Tables &amp; Colors
                </h5>
                <!-- 颜色列表 -->
                <div class="widget-toolbar widget-toolbar-light no-border">
                    <select id="simple-colorpicker-1" class="hide">
                        <option selected="" data-class="blue" value="#307ECC">#307ECC</option>
                        <option data-class="blue2" value="#5090C1">#5090C1</option>
                        <option data-class="blue3" value="#6379AA">#6379AA</option>
                        <option data-class="green" value="#82AF6F">#82AF6F</option>
                        <option data-class="green2" value="#2E8965">#2E8965</option>
                        <option data-class="green3" value="#5FBC47">#5FBC47</option>
                        <option data-class="red" value="#E2755F">#E2755F</option>
                        <option data-class="red2" value="#E04141">#E04141</option>
                        <option data-class="red3" value="#D15B47">#D15B47</option>
                        <option data-class="orange" value="#FFC657">#FFC657</option>
                        <option data-class="purple" value="#7E6EB0">#7E6EB0</option>
                        <option data-class="pink" value="#CE6F9E">#CE6F9E</option>
                        <option data-class="dark" value="#404040">#404040</option>
                        <option data-class="grey" value="#848484">#848484</option>
                        <option data-class="default" value="#EEE">#EEE</option>
                    </select>
                </div>
            </div>

            <!-- table内容 -->
            <div class="widget-body">
                <div class="widget-main no-padding">
                    <table class="table table-striped table-bordered table-hover">
                        <thead class="thin-border-bottom">
                            <tr>
                                <th><i class="ace-icon fa fa-user"></i>User</th>

                                <th><i>@</i>Email</th>
                                <th class="hidden-480">Status</th>
                            </tr>
                        </thead>

                        <tbody>
                            <tr>
                                <td class="">Alex</td>
                                <td><a href="#">alex@email.com</a></td>
                                <td class="hidden-480"><span class="label label-warning">Pending</span></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>