<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath() + "/ui";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="ui/css/base.css" />
<link rel="stylesheet" type="text/css" href="ui/css/jquery.dialog.css" />
<link rel="stylesheet" href="ui/css/index.css" />

<title>移动办公自动化系统</title>
</head>

<body>
<div id="container">
	<div id="hd">
    	<div class="hd-wrap ue-clear">
        	<div class="top-light"></div>
            <h1 class="logo">
				<span style="font-size:15pt;color:white;bold:30;font-style:italic">
				GPS远程定位监控系统
				</span><br>
				<span style="font-size:8pt;color:black;bold:30">
				Gps positioning and monitoring system 
				</span>
			</h1>
			
            <div class="login-info ue-clear">
                <div class="welcome ue-clear"><span>欢迎您,</span><a href="javascript:;" class="user-name">Admin</a></div>
                <div class="login-msg ue-clear">
                    <a href="javascript:;" class="msg-txt">消息</a>
                    <a href="javascript:;" class="msg-num">10</a>
                </div>
            </div>
            <div class="toolbar ue-clear">
                <a href="javascript:;" class="home-btn">首页</a>
                <a href="javascript:;" class="quit-btn exit"></a>
            </div>
        </div>
    </div>
    <div id="bd">
    	<div class="wrap ue-clear">
        	<div class="sidebar">
            	<h2 class="sidebar-header"><p>功能导航</p></h2>
                <ul class="nav">
                	<li class="office current">
						<div class="nav-header"><a href="javascript:;"  class="ue-clear"><span>设备管理</span><i class="icon"></i></a></div>
					    <ul class="subnav">
                        	<li><a href="javascript:;" date-src="localizerList.do?pageSize=20&pageNum=0">设备列表</a></li>
                            <li><a href="javascript:;" date-src="info-mgt.html">信息管理</a></li>
                            <li><a href="javascript:;" date-src="info-det.html">领导值岗管理</a></li>
                            <li><a href="javascript:;">中层领导管理</a></li>
                            <li><a href="javascript:;">领导值班记录</a></li>
                        </ul>
					</li>
                    <li class="gongwen"><div class="nav-header"><a href="javascript:;" class="ue-clear"><span>充值管理</span><i class="icon"></i></a></div></li>
                    <li class="nav-info">
                    	<div class="nav-header"><a href="javascript:;" class="ue-clear"><span>定位监控</span><i class="icon"></i></a></div>
                        <ul class="subnav">
                        	<li><a href="javascript:;" date-src="monitorDeviceMapView">设备地图显示</a></li>
                            <li><a href="javascript:;" date-src="info-mgt.html">电子栅栏</a></li>
                            <li><a href="javascript:;" date-src="info-det.html">设备位置数据</a></li>
                            <li><a href="javascript:;">中层领导管理</a></li>
                            <li><a href="javascript:;">领导值班记录</a></li>
                        </ul>
                    </li>
                    
                    <li class="konwledge"><div class="nav-header"><a href="javascript:;" class="ue-clear"><span>统计报表</span><i class="icon"></i></a></div></li>
                    <li class="agency">
                    	<div class="nav-header"><a href="javascript:;" class="ue-clear"><span>会员管理</span><i class="icon"></i></a></div>
					    <ul class="subnav">
                        	<li><a href="javascript:;" date-src="memberList.do?parentId=${loginUser.parentId}&pageSize=20&pageNum=0">会员信息列表</a></li>
                            <li><a href="ui/src/views/index.html">闲心主页</a></li>
                            <li><a href="javascript:;" date-src="enterpriseList.do?pageSize=20&pageNum=0">企业管理</a></li>
                            <li><a href="javascript:;">中层领导管理</a></li>
                            <li><a href="javascript:;">领导值班记录</a></li>
                        </ul>                    
                    </li>
                    <li class="email"><div class="nav-header"><a href="javascript:;" class="ue-clear"><span>报警信息管理</span><i class="icon"></i></a></div></li>
                    <li class="system"><div class="nav-header"><a href="javascript:;" class="ue-clear"><span>系统管理</span><i class="icon"></i></a></div></li>
                </ul>
            </div>
            <div class="content">
            	<iframe src="info-mgt.html" id="iframe" width="100%" height="100%" frameborder="0"></iframe>
            </div>
        </div>
    </div>
    <div id="ft" class="ue-clear">
    	<div class="ft-left">
            <span>众智物联</span>
            <em>Office&nbsp;System</em>
        </div>
        <div class="ft-right">
            <span>Automation</span>
            <em>V2.0&nbsp;2014</em>
        </div>
    </div>
</div>
<div class="exitDialog">
	<div class="dialog-content">
    	<div class="ui-dialog-icon"></div>
        <div class="ui-dialog-text">
        	<p class="dialog-content">你确定要退出系统？</p>
            <p class="tips">如果是请点击“确定”，否则点“取消”</p>           
            <div class="buttons">
                <input type="button" class="button long2 ok" value="确定" />
                <input type="button" class="button long2 normal" value="取消" />
            </div>
        </div>       
    </div>
</div>
</body>
<script type="text/javascript" src="ui/js/jquery.js"></script>
<script type="text/javascript" src="ui/js/common.js"></script>
<script type="text/javascript" src="ui/js/core.js"></script>
<script type="text/javascript" src="ui/js/jquery.dialog.js"></script>
<script type="text/javascript" src="ui/js/index.js"></script>
<script type="text/javascript">
	window.name="index";
</script>
</html>
