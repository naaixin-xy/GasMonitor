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
<link rel="stylesheet" href="ui/css/info-reg.css" />
<link rel="stylesheet" type="text/css" href="ui/js/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css">
<title>1</title>
</head>

<body>
<!-- <div class="title"><h2>用户注册</h2></div> -->
<div class="main">
    <p class="long-input ue-clear">
    	<label>帐户：</label>
        <input type="text" id="account" placeholder="帐户" />
    </p>
    <p class="long-input ue-clear">
    	<label>密码：</label>
        <input type="password" id="password"  placeholder="密码" />
    </p>
    <p class="long-input ue-clear">
    	<label>确认密码：</label>
        <input type="password" id="password2" placeholder="密码" />
    </p>
    <div class="short-input select ue-clear">
    	<label>类别：</label>
        <div class="select-wrap">
        	<div class="select-title ue-clear"><span id="category">用户</span><i class="icon"></i></div>
            <ul class="select-list">
            	<li>代理商</li>
                <li>用户</li>
            </ul>
        </div>
    </div>    
    <p class="long-input ue-clear">
    	<label>姓名</label>
        <input type="text" id="name" placeholder="姓名" />
    </p>
    <p class="long-input ue-clear">
    	<label>上级用户</label>
        <input type="text" id="parentId" disabled="disabled" value="${parentId}"/>
    </p>
    <p class="short-input ue-clear">
    	<label>电话：</label>
        <input type="text" id="phone" placeholder="电话" />
    </p>
    
     <p class="short-input ue-clear">
    	<label>设备数量：</label>
        <input type="text" id="deviceCount" placeholder="设备数量" />
    </p>   
     <p class="short-input ue-clear">
    	<label>联系人：</label>
        <input type="text" id="contact" placeholder="联系人" />
    </p>  
     <p class="short-input ue-clear">
    	<label>库存：</label>
        <input type="text" id="stock" placeholder="库存" />
    </p>  
     <p class="short-input ue-clear">
    	<label>进货量人：</label>
        <input type="text" id="purchaseQuantity" placeholder="进货量" />
    </p>  
      <p class="short-input ue-clear">
    	<label>地址：</label>
        <input type="text" id="address" placeholder="地址" />
    </p>                 
    <p class="short-input ue-clear">
    	<label>备注：</label>
        <textarea placeholder="请输入内容" id="remark"></textarea>
    </p>
    <div class="main" style="height:5px;clear:both;magin:0;padding:0"></div>    
</div>

<div class="btn ue-clear">
	<a href="javascript:;" class="confirm">确定</a>
    <a href="javascript:;" class="clear">清空内容</a>
</div>
</body>
<!-- <script type="text/javascript" src="ui/js/jquery.min.js"></script> -->
<script type="text/javascript" src="ui/js/jquery.js"></script>
<script type="text/javascript" src="ui/js/common.js"></script>
<script type="text/javascript" src="ui/js/WdatePicker.js"></script>
<script type="text/javascript" src="ui/js/lib/zTree/v3/js/jquery.ztree.all-3.5.js"></script>
<script type="text/javascript">
$(function (){
	$("#account").on("blur",function(){
		//alert("账户名失去焦点!");	
		if($("#account").val()==''){
			 $("#accountInsertAfter").remove();
			 $("#account").after("<span id='accountInsertAfter' style='color:red'>账户名不能为空！</span>");
		}else{
			if(/^\w{3,20}$/.test($("#account").val())){
				$.post("isUserExist",{account:$("#account").val()},function(result){
			        $("#accountInsertAfter").remove();
			        if(result.result=="success"){
			        	$("#account").after("<span id='accountInsertAfter' style='color:green'>用戶名可用</span>");
			        }else{
			        	$("#account").after("<span id='accountInsertAfter' style='color:red'>用戶名已被占用请重新选择</span>");	
			        }
			    });					
			}else{
				 $("#accountInsertAfter").remove();
				 $("#account").after("<span id='accountInsertAfter' style='color:red'>账户名只能是字幕数字下划线的组合！且长度大于3小于20！</span>");
			}
		}
	})
	
	$("#password").on("blur",function(){
		 $("#passwordInsertAfter").remove();
		 $("#password2InsertAfter").remove();
		if(($("#password").val()!=$("#password2").val())&&($("#password2").val()!="")){

			 $("#password").after("<span id='passwordInsertAfter' style='color:red'>两次密码输入不一致，请重新输入</span>");		
		}
	})
	$("#password2").on("blur",function(){
		 $("#password2InsertAfter").remove();
		 $("#passwordInsertAfter").remove();
		if(($("#password").val()!=$("#password2").val())&&($("#password").val()!="")){
			 $("#password2").after("<span id='password2InsertAfter' style='color:red'>两次输入密码不一致，请重新输入</span>");		
		}
	})	
	$(".confirm").on("click",function(){
		var checkResult=true;
		//alert("confirm key click!");
		
		
		if(!(/^\w{3,20}$/.test($("#account").val()))){
			 $("#accountInsertAfter").remove();
			 $("#account").after("<span id='accountInsertAfter' style='color:red'>账户名只能是字母数字下划线的组合！且长度大于3小于20！</span>");	
			 checkResult=false;
		}	
		
		if(!(/^\S{6,20}$/.test($("#password").val()))){
			 //$("#password").val().trim();
			 $("#passwordInsertAfter").remove();
			 $("#password").after("<span id='passwordInsertAfter' style='color:red'>密码不能包空白符，且长度大于等于6小于20</span>");	
			 checkResult=false;						
		}		
		
		if($("#name").val()==""){
			 $("#nameInsertAfter").remove();
			 $("#name").after("<span id='nameInsertAfter' style='color:red'>用户名不能为空</span>");							
			checkResult=false;		
		}		
		
		if(!(/^\d{1,15}$/.test($("#parentId").val()))){
			 $("#parentIdInsertAfter").remove();
			 $("#parentId").after("<span id='parentIdInsertAfter' style='color:red'>父用户id必须为1到15位数字</span>");	
			 checkResult=false;	
		}
		
		if(!(/^\d{7,18}$/.test($("#phone").val()))){
			 $("#phoneInsertAfter").remove();
			 $("#phone").after("<span id='phoneInsertAfter' style='color:red'>手机号码必须为7到15位数字</span>");	
			 checkResult=false;	
		}		
		
		if(!(/^\d{1,10}$/.test($("#deviceCount").val()))){
			 $("#deviceCountInsertAfter").remove();
			 $("#deviceCount").after("<span id='deviceCountInsertAfter' style='color:red'>设备数量为1到10位数字</span>");	
			 checkResult=false;	
		}
		
		if($("#contact").val()==""){
			 $("#contactInsertAfter").remove();
			 $("#contact").after("<span id='contactInsertAfter' style='color:red'>联系人不能为空</span>");							
			checkResult=false;		
		}			
		if($("#remark").val()==""){
			// $("#remarkInsertAfter").remove();
			 $("#remark").css("color","red");
			 $("#remark").text("备注备注不能为空");
			 //html("<span id='remarkInsertAfter' style='color:red'>备注备注不能为空</span>");							
			checkResult=false;		
		}	
		
		if(!checkResult){return;}		
		
		var postParameter={
				account:$("#account").val(),
				password:$("#password").val(),
				//category:$("#category").val(),
				category:function (){if($("#category").text()=="用户"){return 0}else{return 1}},
				name:$("#name").val(),
				parentId:$("#parentId").val(),
				phone:$("#phone").val(),
				deviceCount:$("#deviceCount").val(),
				contact:$("#contact").val(),
				stock:$("#stock").val(),
				purchaseQuantity:$("#purchaseQuantity").val(),
				address:$("#address").val(),
				remark:$("#remark").val()
			};
		//postParameter.account();
		//alert(checkResult);
		
		$.post("memberRegister.do",
			postParameter,
			function(result){
		        
				var index = parent.layer.getFrameIndex(window.name);
				//parent.$('.btn-refresh').click();
				if(result.result=="success"){
					alert("新用户注册成功！");
					//parent.location.reload(); 
					parent.layer.close(index);	
				}else{
					alert("新用户注册失败！");
				}
	    	}
		);				
	})		
	$(".select-title").on("click",function(){
		$(".select-list").hide();
		$(this).siblings($(".select-list")).show();
		return false;
	})
	$(".select-list").on("click","li",function(){
		var txt = $(this).text();
		$(this).parent($(".select-list")).siblings($(".select-title")).find("span").text(txt);
		$(".select-list").hide();
		//alert($(this).text());
	})
})
showRemind('input[type=text], textarea','placeholder');
</script>
</html>
