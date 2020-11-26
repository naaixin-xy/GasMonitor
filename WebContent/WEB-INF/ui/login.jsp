<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath() + "/ui";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%!String test2 = "测试";%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="ui/css/base.css" />
	<link rel="stylesheet" href="ui/css/login.css" />
	<title>气体监控系统</title>
</head>
<body>
	<div id="container">
		<div id="bd">
			<div class="login1">
				<div class="login-top" style="vertical-align:middle;">
					<h1 class="logo" style="vertical-align:middle;padding:25pt;">
					<span style="font-size:30pt;color:white;bold:30;font-style:italic;">
					气体采集系统
					</span><br>
					<span style="font-size:16pt;color:black;bold:30">
					Gas monitoring system 
					</span>
					</h1>
				</div>	
				
				
                <div class="login-input">
                <form name="mainform" action="ui/gas/views/login" method="post">
                	<p class="user ue-clear">
                    	<label>登录名</label>
                        <input type="text" name="loginName" id="loginName"/> 
                   		<input name="loginType" type="radio" checked="checked" style="width:18px;height:18px;magin:0px;padding:0px;vertical-align:middle;font-size:18px" value="0"/>用戶名  
                        <input name="loginType" style="width:18px;height:18px;magin:0px;padding:0px;margin-left:5px;vertical-align:middle;font-size:18px" type="radio" value="1"/>车牌/IMEI                         
                    </p>
                    <p class="password ue-clear" >
                    	<label>密&nbsp;&nbsp;&nbsp;码</label>
                        <input type="text" name="password" id="password"/>
                    </p>
                    <p class="yzm ue-clear" style="vertical-align:middle">
                    	<label>验证码</label>
                        <input type="text" name="identifyingCode" id="identifyingCode"/>
                        <cite>
							<label><a href="#" onclick="changeIdentifyingCode()" >换一张</a></label>&nbsp;&nbsp;&nbsp;
							<span id="codespan" style="display:inline;width:120px;height:30px;padding:4px;padding-right:16px;border:1px">
							<img id="vcode" src="getIdentifyingCode"  style="display:inline;width:120px;height:30px;padding:4px;padding-right:16px;"/>
							</span>
						</cite>
					</p>
				</form>
                </div>
                <div class="login-btn ue-clear">
                	<a class="btn loginbutton">登录</a>
                    <div class="remember ue-clear">
                    	<input type="checkbox" id="remember" />
                        <em></em>
                        <label for="remember">记住密码</label>
                    </div>
                </div>
            </div>
		</div>
	</div>
    <div id="ft">CopyRight&nbsp;2014&nbsp;&nbsp;版权所有&nbsp;&nbsp;众智物联专注于ui设计&nbsp;&nbsp;</div>
</body>
<script type="text/javascript" src="ui/js/jquery.js"></script>
<script type="text/javascript" src="ui/js/common.js"></script>
<script type="text/javascript">
var height = $(window).height();
$("#container").height(height);
$("#bd").css("padding-top",(height/2 - $("#bd").height()/2));

$(window).resize(function(){
	var height = $(window).height();
	$("#bd").css("padding-top",$(window).height()/2 - $("#bd").height()/2);
	$("#container").height(height);
	
});

$('#remember').focus(function(){
   $(this).blur();
});

$('#remember').click(function(e) {
	checkRemember($(this));
});

function checkRemember($this){
	if(!-[1,]){
		 if($this.prop("checked")){
			$this.parent().addClass('checked');
		}else{
			$this.parent().removeClass('checked');
		}
	}
}

function changeIdentifyingCode(){
	//$("#vcode").attr("src","http://localhost/localizer/ui/getIdentifyingCode");
	//alert("click!");
	location.reload();
	if($("#codespan").html){
		$("#codespan").html("<img id=\"vcode\" src=\"getIdentifyingCode\"  style=\"display:inline;width:120px;height:30px;padding:4px;padding-right:16px;\"/>");
	}
	//$("#vcode").attr("src", "getIdentifyingCode");
	//$("#vcode").attr("src", "getIdentifyingCode12");
// 	if($("#vcode").attr("src")=="getIdentifyingCode"){
// 		$("#vcode").attr("src", "getIdentifyingCode3");
// 	}else{
// 		$("#vcode").attr("src", "getIdentifyingCode");	
// 	}
	//$("#vcode").load("http://localhost/localizer/ui/getIdentifyingCode")
}
$(".loginbutton").on("click",function(){
	//var checkResult=true;
	if(!(/^\w{3,20}$/.test($("#loginName").val()))){alert("登录名只能是字母数字下划线的组合！且长度大于3小于20！");return false;}	
	if(!(/^\S{6,20}$/.test($("#password").val()))){alert("密码不能包空白符，且长度大于等于6小于20");return false;}
	if($("#identifyingCode").val()==""){alert("密码输入有误！");return false;}	
	var postParameter={
			loginName:$("#loginName").val(),
			loginType:$("input:radio:checked").val(),
			password:$("#password").val(),
			identifyingCode:$("#identifyingCode").val()
		};
	//postParameter.account();
	//alert(checkResult);
	document.mainform.submit();	
// 	$.post("login",
// 		postParameter,
// 		function(result){
	        
// 			//var index = parent.layer.getFrameIndex(window.name);
// 			//parent.$('.btn-refresh').click();
// 			alert(result);
// 			if(result.result=="success"){
// 				alert("新用户注册成功！");
// 				//parent.location.reload(); 
// 				parent.layer.close(index);	
// 			}else{
// 				alert("新用户注册失败！");
// 			}
// 		}
// 	);					
});
$("input[name='loginType']:radio").on("click",function(){
	alert($("input:radio:checked").val());
})
var executeResult="${executeResult}";
if(executeResult!=""){
	alert(executeResult);
}
</script>
</html>