<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath() + "/ui";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>登入 - layuiAdmin</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="/GasMonitor/ui/gas/layuiadmin/layui/css/layui.css" media="all">
  <link rel="stylesheet" href="/GasMonitor/ui/gas/layuiadmin/style/admin.css" media="all">
  <link rel="stylesheet" href="/GasMonitor/ui/gas/layuiadmin/style/login.css" media="all">
</head>
<body>

  <div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" style="display: none;">

    <div class="layadmin-user-login-main">
      <div class="layadmin-user-login-box layadmin-user-login-header">
        <h2>layuiAdmin</h2>
        <p>XXXXXXXXXXXXXXXXXXXXXX</p>
      </div>
      <div class="layadmin-user-login-box layadmin-user-login-body layui-form">
        <div class="layui-form-item">
          <label class="layadmin-user-login-icon layui-icon layui-icon-username" for="LAY-user-login-username"></label>
          <input type="text" name="loginName" id="LAY-user-login-username" lay-verify="required" placeholder="用户名" class="layui-input">
        </div>
        <div class="layui-form-item">
          <label class="layadmin-user-login-icon layui-icon layui-icon-password" for="LAY-user-login-password"></label>
          <input type="password" name="password" id="LAY-user-login-password" lay-verify="required" placeholder="密码" class="layui-input">
        </div>
        <div class="layui-form-item">
          <div class="layui-row">
            <div class="layui-col-xs7">
              <label class="layadmin-user-login-icon layui-icon layui-icon-vercode" for="LAY-user-login-vercode"></label>
              <input type="text" name="identifyingCode" id="LAY-user-login-vercode" lay-verify="required" placeholder="图形验证码" class="layui-input">
            </div>
            <div class="layui-col-xs5">
              <div style="margin-left: 10px;">
                <img src="gas/views/user/getIdentifyingCode" class="layadmin-user-login-codeimg" id="LAY-user-get-vercode">
              </div>
            </div>
          </div>
        </div>
        <div class="layui-form-item" style="margin-bottom: 20px;">
          <input type="checkbox" name="remember" lay-skin="primary" title="记住密码">
        </div>
        <div class="layui-form-item">
          <button class="layui-btn layui-btn-fluid" id="submit-id" lay-submit lay-filter="LAY-user-login-submit">登 入</button>
        </div>
      </div>
    </div>
    

    
    <!--<div class="ladmin-user-login-theme">
      <script type="text/html" template>
        <ul>
          <li data-theme=""><img src="{{ layui.setter.base }}style/res/bg-none.jpg"></li>
          <li data-theme="#03152A" style="background-color: #03152A;"></li>
          <li data-theme="#2E241B" style="background-color: #2E241B;"></li>
          <li data-theme="#50314F" style="background-color: #50314F;"></li>
          <li data-theme="#344058" style="background-color: #344058;"></li>
          <li data-theme="#20222A" style="background-color: #20222A;"></li>
        </ul>
      </script>
    </div>-->
    
  </div>

  <script src="/GasMonitor/ui/gas/layuiadmin/layui/layui.js"></script>  
  <script>
  layui.config({
    base: '/GasMonitor/ui/gas/layuiadmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use(['index', 'user'], function(){
    var $ = layui.$
    ,setter = layui.setter
    ,admin = layui.admin
    ,form = layui.form
    ,router = layui.router()
    ,search = router.search;

    form.render();
	console.log(layui.setter);
	console.log(layui.cache);
	console.log(layui.index);
	console.log(layui.data);
    //提交
    
    
	$("#submit-id").on("click",function(){  
    
    	var postParameter={
			loginName:$("#LAY-user-login-username").val(),
			loginType:0,
			password:$("#LAY-user-login-password").val(),
			identifyingCode:$("#LAY-user-login-vercode").val()
		};      
		$.post("login",
			postParameter,
			function(result){
	        
			}
		);    
		
	});		
//     form.on('submit(LAY-user-login-submit)', function(obj){
    
// 		//请求登入接口
// 	 	var postParameter={
// 			loginName:$("#LAY-user-login-username").val(),
// 			loginType:0,
// 			password:$("#LAY-user-login-password").val(),
// 			identifyingCode:$("#LAY-user-login-vercode").val()
// 		};      
// 		$.post("login",
// 			postParameter,
// 			function(result){
	        
// 			}
// 		);     
      
// //       admin.req({
// //         url: 'login' //实际使用请改成服务端真实接口
// //         ,data: obj.field
// //         ,done: function(res){
        
// //           //请求成功后，写入 access_token
// // //           layui.data(setter.tableName, {
// // //             key: setter.request.tokenName
// // //             ,value: res.data.access_token
// // //           });
          
// //           //登入成功的提示与跳转
// //           alert("登入成功");
// //           layer.msg('登入成功', {
// //             offset: '15px'
// //             ,icon: 1
// //             ,time: 1000
// //           }, function(){
// //             location.href = '/GasMonitor/ui/gas/views/user/index.html'; //后台主页
// //           });
// //         }
// //       });
      
//     });
    
    
    //实际使用时记得删除该代码
    layer.msg('为了方便演示，用户名密码可随意输入', {
      offset: '15px'
      ,icon: 1
    });

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
//     	$.post("login",
//     		postParameter,
//     		function(result){
    	        
//     			//var index = parent.layer.getFrameIndex(window.name);
//     			//parent.$('.btn-refresh').click();
//     			alert(result);
//     			if(result.result=="success"){
//     				alert("新用户注册成功！");
//     				//parent.location.reload(); 
//     				parent.layer.close(index);	
//     			}else{
//     				alert("新用户注册失败！");
//     			}
//     		}
//     	);					
    });
    
    
  });
  </script>
</body>
</html>