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
          <div class="layui-card-header">县区级行政区域列表</div>
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
  }).use(['index', 'table'], function(){
	var $ = layui.$ //重点处 获取内置的Jquery模块
    var admin = layui.admin
    ,table = layui.table;
    table.render({
      elem: '#test-table-toolbar'
      ,url: 'device/getGasHostListByPage'
      ,toolbar: '#test-table-toolbar-toolbarDemo'
      ,title: '县区级行政区域列表'
   	  ,height: 'full-100'
   	  ,limit:20  
      ,cols: [[
        {type: 'checkbox', fixed: 'left'}
        ,{field:'id', title:'ID', width:80, fixed: 'left', unresize: true, sort: true}
        ,{field:'name', title:'设备名称', width:100, edit: 'text'}
        ,{field:'enterpriseId', title:'单位ID', width:140, edit: 'text'}
        ,{field:'type', title:'主机ID', width:120}
        ,{field:'communicationAddress', title:'通信地址', width:140, sort: true}   
        ,{field:'governor', title:'管理人', width:120}
        ,{field:'installer', title:'安装人',sort: true, width:100}
 
        ,{field:'longitude', title:'经度', width:100}
        ,{field:'latitude', title:'维度',sort: true, width:100}        
        
        
        ,{field:'serialNumber', title:'序列号',edit: 'text', width:100}
        ,{field:'status', title:'设备状态', width:100}
        ,{field:'connectionStatus', title:'连接状态', width:100}
        ,{field:'note', title:'备注',sort: true, width:100}
        ,{field:'createTime', title:'创建时间时间', width:140}
        ,{field:'lastUpdateTime', title:'上次更新时间',width:140}      
        
        ,{field:'provinceId', title:'省ID', width:100}       
        ,{field:'cityId', title:'城市ID', width:100}         
        ,{field:'areaId', title:'县区ID',sort: true, width:100}
        ,{field:'streetId', title:'街道ID', width:100}
        ,{field:'enterpriseName', title:'单位名称', width:100}        
        ,{field:'streetName', title:'街道名称', width:100}       
        ,{field:'areaName', title:'区名称', width:100}         
        
        ,{field:'cityName', title:'城市名称',sort: true, width:100}
        ,{field:'provinceName', title:'省名称', width:100}
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
  
  });
  </script>
</body>
</html>