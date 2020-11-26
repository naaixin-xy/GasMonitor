<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath() + "/ui";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//String username = request.getSession().getAttribute("admin").toString();
	String username = "nihao";
%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<script type="text/javascript" src="lib/PIE_IE678.js"></script>
<![endif]-->
<link href="ui/static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="ui/static/h-ui.admin/css/H-ui.login.css" rel="stylesheet" type="text/css" />
<link href="ui/static/h-ui.admin/css/style.css" rel="stylesheet" type="text/css" />
<link href="ui/lib/Hui-iconfont/1.0.7/iconfont.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>后台登录 - 安福在线监控平台</title>
<meta name="keywords" content="H-ui.admin v2.3,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin v2.3，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
<script type="text/javascript">
document.onkeydown=function(e){
	var keycode=document.all?event.keyCode:e.which;
	if(keycode==13){
		login();
	}
}

function login(){	
	if(document.getElementById("account").value==""){
		alert("请输入用户名");
		return false;
	}
	var userName = document.getElementById("account").value;
	var patrn=/^(\w){4,30}$/; 
    if(!patrn.exec(userName)){
		alert("只能输入4-30个字母、数字、下划线 ");   
		return false; 
    }
	if(document.getElementById("password").value==""){
		alert("请输入密码");
		return false;
	}
	var pwd = document.getElementById('password').value;
	if (pwd.length > 16 || pwd.length < 3){
		alert("密码长度应该在 3 - 16 位");
		return false;
	}
	if(document.getElementById("validatecode").value==""){
	  	alert("请输入验证码");
	  	return false;
	}
	document.mainform.submit();	
}

function init(){
	var a ="";
	if(a=="ok"){
		alert("用户名或密码错误！");
	}
}

</script>
</head>
<body>
	<input type="hidden" id="TenantId" name="TenantId" value="" />
	<div class="header">
		<div style="width: 100%; height: 100%; color: white; font-size: 40px; line-height: 60px; font-family: 隶书">
			安福在线监控平台 <i>V2.3.67</i>
		</div>
	</div>
	<div class="loginWraper">
		<div id="loginform" class="loginBox">
			<form class="form form-horizontal" name="mainform" action="<%=path%>/AdminMonitorAdapterServlet?mode=serverquery.queryAdminList.byaccount_password.admin.ad" method="post">
				<div class="row cl">
					<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
					<div class="formControls col-xs-8">
						<input id="account" name="account" type="text" placeholder="账户" class="input-text size-L">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
					<div class="formControls col-xs-8">
						<input id="password" name="password" type="password" placeholder="密码" class="input-text size-L">
					</div>
				</div>
				<div class="row cl">
					<div class="formControls col-xs-8 col-xs-offset-3">
						<input class="input-text size-L" type="text" name="validatecode" id="validatecode" placeholder="验证码" onblur="if(this.value==''){this.value='验证码:'}" onclick="if(this.value=='验证码:'){this.value='';}" value="验证码:" style="width: 150px;"> 
						&nbsp;&nbsp;&nbsp;&nbsp;
						<img name="validatecodeimg" src="<%=path%>/AdminMonitorAdapterServlet?ValidateCode=ValidateCode"> <a id="kanbuq" onclick="window.location.reload()" href="javascript:;"><span style="color:#ffffff">看不清，换一张</span></a>
					</div>
				</div>
				<div class="row cl">
					<div class="formControls col-xs-8 col-xs-offset-3">
						<label for="online"> <input type="checkbox" name="online" id="online" value=""> <span style="color:#ffffff">使我保持登录状态</span>
						</label>
						<label for="online">
							<%= (request.getSession().getAttribute("errorCode")==null)?"":request.getSession().getAttribute("errorCode").toString() %>
						</label>
					</div>
				</div>
				<div class="row cl">
					<div class="formControls col-xs-8 col-xs-offset-3" style="text-align:center;">
						<input name="" type="button" onclick="login()" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;"> 
						&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
						<input name="" type="reset" class="btn btn-default radius size-L" value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="footer">Copyright @山东临沂市安福电子有限公司</div>
	<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="static/h-ui/js/H-ui.js"></script>
	<script>
		var _hmt = _hmt || [];
		(function() {
			var hm = document.createElement("script");
			hm.src = "//hm.baidu.com/hm.js?080836300300be57b7f34f4b3e97d911";
			var s = document.getElementsByTagName("script")[0];
			s.parentNode.insertBefore(hm, s);
		})();
		var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://":" http://");
		document.write(unescape("%3Cscript src='"
			+ _bdhmProtocol
			+ "hm.baidu.com/h.js%3F080836300300be57b7f34f4b3e97d911' type='text/javascript'%3E%3C/script%3E"));
	</script>
</body>
</html>