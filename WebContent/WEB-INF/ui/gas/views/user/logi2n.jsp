
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
  <title>ç»å¥ - layuiAdmin</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="/GasMonitor/ui/src/layuiadmin/layui/css/layui.css" media="all">
  <link rel="stylesheet" href="/GasMonitor/ui/src/layuiadmin/style/admin.css" media="all">
  <link rel="stylesheet" href="/GasMonitor/ui/src/layuiadmin/style/login.css" media="all">
</head>
<body>

  <div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" style="display: none;">

    <div class="layadmin-user-login-main">
      <div class="layadmin-user-login-box layadmin-user-login-header">
        <h2>layuiAdmin</h2>
        <p>layui å®æ¹åºåçåé¡µé¢åå°ç®¡çæ¨¡æ¿ç³»ç»</p>
      </div>
      <div class="layadmin-user-login-box layadmin-user-login-body layui-form">
        <div class="layui-form-item">
          <label class="layadmin-user-login-icon layui-icon layui-icon-username" for="LAY-user-login-username"></label>
          <input type="text" name="username" id="LAY-user-login-username" lay-verify="required" placeholder="ç¨æ·å" class="layui-input">
        </div>
        <div class="layui-form-item">
          <label class="layadmin-user-login-icon layui-icon layui-icon-password" for="LAY-user-login-password"></label>
          <input type="password" name="password" id="LAY-user-login-password" lay-verify="required" placeholder="å¯ç " class="layui-input">
        </div>
        <div class="layui-form-item">
          <div class="layui-row">
            <div class="layui-col-xs7">
              <label class="layadmin-user-login-icon layui-icon layui-icon-vercode" for="LAY-user-login-vercode"></label>
              <input type="text" name="vercode" id="LAY-user-login-vercode" lay-verify="required" placeholder="å¾å½¢éªè¯ç " class="layui-input">
            </div>
            <div class="layui-col-xs5">
              <div style="margin-left: 10px;">
                <img src="src/views/user/getIdentifyingCode" class="layadmin-user-login-codeimg" id="LAY-user-get-vercode">
              </div>
            </div>
          </div>
        </div>
        <div class="layui-form-item" style="margin-bottom: 20px;">
          <input type="checkbox" name="remember" lay-skin="primary" title="è®°ä½å¯ç ">
          <a href="forget.html" class="layadmin-user-jump-change layadmin-link" style="margin-top: 7px;">å¿è®°å¯ç ï¼</a>
        </div>
        <div class="layui-form-item">
          <button class="layui-btn layui-btn-fluid" lay-submit lay-filter="LAY-user-login-submit">ç» å¥</button>
        </div>
        <div class="layui-trans layui-form-item layadmin-user-login-other">
          <label>ç¤¾äº¤è´¦å·ç»å¥</label>
          <a href="javascript:;"><i class="layui-icon layui-icon-login-qq"></i></a>
          <a href="javascript:;"><i class="layui-icon layui-icon-login-wechat"></i></a>
          <a href="javascript:;"><i class="layui-icon layui-icon-login-weibo"></i></a>
          
          <a href="reg.html" class="layadmin-user-jump-change layadmin-link">æ³¨åå¸å·</a>
        </div>
      </div>
    </div>
    
    <div class="layui-trans layadmin-user-login-footer">
      
      <p>Â© 2018 <a href="http://www.layui.com/" target="_blank">layui.com</a></p>
      <p>
        <span><a href="http://www.layui.com/admin/#get" target="_blank">è·åææ</a></span>
        <span><a href="http://www.layui.com/admin/pro/" target="_blank">å¨çº¿æ¼ç¤º</a></span>
        <span><a href="http://www.layui.com/admin/" target="_blank">åå¾å®ç½</a></span>
      </p>
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

  <script src="../../layuiadmin/layui/layui.js"></script>  
  <script>
  layui.config({
    base: '../../layuiadmin/' //éæèµæºæå¨è·¯å¾
  }).extend({
    index: 'lib/index' //ä¸»å¥å£æ¨¡å
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
    //æäº¤
    form.on('submit(LAY-user-login-submit)', function(obj){
    
      //è¯·æ±ç»å¥æ¥å£
      admin.req({
        url: layui.setter.base + 'json/user/login.js' //å®éä½¿ç¨è¯·æ¹ææå¡ç«¯çå®æ¥å£
        ,data: obj.field
        ,done: function(res){
        
          //è¯·æ±æååï¼åå¥ access_token
          layui.data(setter.tableName, {
            key: setter.request.tokenName
            ,value: res.data.access_token
          });
          
          //ç»å¥æåçæç¤ºä¸è·³è½¬
          layer.msg('ç»å¥æå', {
            offset: '15px'
            ,icon: 1
            ,time: 1000
          }, function(){
            location.href = '../'; //åå°ä¸»é¡µ
          });
        }
      });
      
    });
    
    
    //å®éä½¿ç¨æ¶è®°å¾å é¤è¯¥ä»£ç 
    layer.msg('ä¸ºäºæ¹ä¾¿æ¼ç¤ºï¼ç¨æ·åå¯ç å¯éæè¾å¥', {
      offset: '15px'
      ,icon: 1
    });
    
  });
  </script>
</body>
</html>