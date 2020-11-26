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
  <title>县区级行政区域列表</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="../layuiadmin/layui/css/layui.css" media="all">
  <link rel="stylesheet" href="../layuiadmin/style/admin.css" media="all">
  <style type="text/css">
/*   .layui-card-header .layui-card-header-1 .layui-form{position:absolute;margin-left:200px;margin-top:-41px;} */
  .layui-card-header-1{position:absolute;margin-left:200px;margin-top:-41px;}
  </style>
</head>

<body>

  <div class="layui-card layadmin-header">
    <div class="layui-breadcrumb" lay-filter="breadcrumb">
      <a lay-href="">主页</a>
      <a><cite>组件</cite></a>
      <a><cite>数据表格</cite></a>
      <a><cite>县区级行政区域列表</cite></a>
    </div>
  </div>
  
  <div class="layui-fluid">
    <div class="layui-row layui-col-space15">
      <div class="layui-col-md12">
        <div class="layui-card">
          <div class="layui-card-header">
          	县区级行政区域列表
          	<div class="layui-card-header-1">
	          <form class="layui-form" action="" lay-filter="component-form-group">
		          <div class="layui-form-item">
		            <div class="layui-inline">
		              <label class="layui-form-label">验证手机</label>
		              <div class="layui-input-inline">
		                <input type="tel" name="phone" lay-verify="required|phone" autocomplete="off" class="layui-input layui-btn-sm">
		              </div>
		            </div>
		            <div class="layui-inline">
		              <label class="layui-form-label">验证邮箱</label>
		              <div class="layui-input-inline">
		                <input type="text" name="email" lay-verify="email" autocomplete="off" class="layui-input layui-btn-sm">
		              </div>
		            </div>
		          </div>
	          </form> 
	          </div>          
          </div>
          <div class="layui-card-body">
            <table class="layui-hide" id="test-table-toolbar" lay-filter="test-table-toolbar"></table>
            
            <script type="text/html" id="test-table-toolbar-toolbarDemo">
              <div class="layui-btn-container">
                <button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>
                <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
                <button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>
              </div>
            </script>
             
            <script type="text/html" id="test-table-toolbar-barDemo">
              <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
              <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
            </script>
          </div>
        </div>
      </div>
    </div>
  </div>
 
  <script src="../layuiadmin/layui/layui.js"></script>  
  <script>
  layui.config({
    base: '../layuiadmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use(['index','form','table'], function(){
	var $ = layui.$ //重点处 获取内置的Jquery模块
    var admin = layui.admin
    ,table = layui.table
	,form = layui.form;
	
    table.render({
      elem: '#test-table-toolbar'
      ,url: 'monitor/getGasAlarmListByPage'
      ,toolbar: '#test-table-toolbar-toolbarDemo'
      ,title: '县区级行政区域列表'
   	  ,height: 'full-100'
   	  ,limit:20  
      ,cols: [[
        {type: 'checkbox', fixed: 'left'}
        ,{field:'id', title:'ID', width:80, fixed: 'left', unresize: true, sort: true}
        ,{field:'hostId', title:'主机ID', edit: 'text'}
        ,{field:'detectorId', title:'探测器ID', edit: 'text'}
        ,{field:'hostAddress', title:'主机地址'}
        ,{field:'detectorAddress', title:'探测器地址', sort: true}   
        ,{field:'type', title:'报警类型'}
        ,{field:'detailInfo', title:'数据',sort: true}
        ,{field:'startTime', title:'开始时间'}
        ,{field:'stopTime', title:'结束时间',sort: true}        
        ,{fixed: 'right', title:'操作', toolbar: '#test-table-toolbar-barDemo', width:150}
      ]]
      ,page: true
    });
    
    //头工具栏事件
    table.on('toolbar(test-table-toolbar)', function(obj){
      var checkStatus = table.checkStatus(obj.config.id);
      switch(obj.event){
        case 'getCheckData':
          var data = checkStatus.data;
          layer.alert(JSON.stringify(data));
        break;
        case 'getCheckLength':
          var data = checkStatus.data;
          layer.msg('选中了：'+ data.length + ' 个');
        break;
        case 'isAll':
          layer.msg(checkStatus.isAll ? '全选': '未全选');
        break;
      };
    });
    
    //监听行工具事件
    table.on('tool(test-table-toolbar)', function(obj){
      var data = obj.data;
      if(obj.event === 'del'){
        layer.confirm('真的删除行么', function(index){
          obj.del();
          layer.close(index);
        });
      } else if(obj.event === 'edit'){
        layer.prompt({
          formType: 2
          ,value: data.email
        }, function(value, index){
          obj.update({
            email: value
          });
          layer.close(index);
        });
      }
    });
    form.render(null, 'component-form-group');  
  });
  </script>
</body>
</html>