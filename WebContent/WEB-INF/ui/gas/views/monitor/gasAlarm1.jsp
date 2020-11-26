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
          </div>
          <div class="layui-card-body">
	          <form class="layui-form layui-form-pane" action="" lay-filter="component-form-group">
		          <div class="layui-form-item" style="text-align:justify">
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
<!-- 		            <div class="layui-inline"> -->
<!-- 		              <label class="layui-form-label">范围</label> -->
<!-- 		              <div class="layui-input-inline" style="width: 100px;"> -->
<!-- 		                <input type="text" name="price_min" placeholder="￥" autocomplete="off" class="layui-input"> -->
<!-- 		              </div> -->
<!-- 		              <div class="layui-form-mid">-</div> -->
<!-- 		              <div class="layui-input-inline" style="width: 100px;"> -->
<!-- 		                <input type="text" name="price_max" placeholder="￥" autocomplete="off" class="layui-input"> -->
<!-- 		              </div> -->
<!-- 		            </div>	 -->
		            
<!-- 	 				<div class="layui-inline"> -->
<!-- 	                  <label class="layui-form-label">活动日期</label> -->
<!-- 	                  <div class="layui-input-inline"> -->
<!-- 	                    <input type="text" class="layui-input" id="test-laydate-start" placeholder="开始日期"> -->
<!-- 	                  </div> -->
<!-- 	                  <div class="layui-form-mid"> -->
<!-- 	                    - -->
<!-- 	                  </div> -->
<!-- 	                  <div class="layui-input-inline"> -->
<!-- 	                    <input type="text" class="layui-input" id="test-laydate-end" placeholder="结束日期"> -->
<!-- 	                  </div> -->
<!-- 	                </div>	 -->
	                <div class="layui-inline">
	                  <label class="layui-form-label">日期时间范围</label>
	                  <div class="layui-input-inline">
	                    <input type="text" class="layui-input" id="test-laydate-range-datetime" placeholder=" - ">
	                  </div>
	                </div>	
	                 <div class="layui-inline">
<!-- 	                        <label class="layui-form-label">报警类型</label> -->
				            <div class="layui-input-inline">
				              <input type="checkbox" name="like[write]" title="高报">
				              <input type="checkbox" name="like[read]" title="低报" checked="">
				            </div> 
				      </div>
				      <div class="layui-inline">
				       	 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
				       	 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
				       	 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
				      </div> 
	                 <div class="layui-inline">
			            <div class="layui-input-inline">
		                  <button class="layui-btn" lay-submit lay-filter="component-form-element">搜索</button>
		                  <button type="reset" class="layui-btn layui-btn-primary">重置</button>
		                </div>  
	                 </div>             	            	            
		          </div>
	          </form>                 
            <table class="layui-hide" id="test-table-toolbar" lay-filter="test-table-toolbar"></table>
            
            <script type="text/html" id="test-table-toolbar-toolbarDemo">
							<div class="layui-btn-group">
                				<button class="layui-btn layui-btn-sm" lay-event="add"><i class="layui-icon layui-icon-add-1"></i>增加</button>
								<button class="layui-btn layui-btn-sm layui-hide-xs" lay-event="edit"><i class="layui-icon layui-icon-edit"></i>编辑</button>
								<button class="layui-btn layui-btn-sm" lay-event="set"><i class="layui-icon layui-icon-set-sm"></i>设置</button>
                				<button class="layui-btn layui-btn-sm " lay-event="delete"><i class="layui-icon layui-icon-delete"></i>删除</button>
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
  }).use(['index','form','table','laydate'], function(){
	var $ = layui.$ //重点处 获取内置的Jquery模块
    var admin = layui.admin
    ,table = layui.table
	,form = layui.form
	,laydate = layui.laydate;	
    table.render({
      elem: '#test-table-toolbar'
      ,url: 'monitor/getGasAlarmListByPage'
      ,toolbar: '#test-table-toolbar-toolbarDemo'
      ,title: '县区级行政区域列表'
   	  ,height: 'full-155'
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
    //示例代码
    
    //开始日期
    var insStart = laydate.render({
      elem: '#test-laydate-start'
      ,min: 0
      ,done: function(value, date){
        //更新结束日期的最小日期
        insEnd.config.min = lay.extend({}, date, {
          month: date.month - 1
        });
        
        //自动弹出结束日期的选择器
       insEnd.config.elem[0].focus();
      }
    });
    
    //结束日期
    var insEnd = laydate.render({
      elem: '#test-laydate-end'
      ,min: 0
      ,done: function(value, date){
        //更新开始日期的最大日期
        insStart.config.max = lay.extend({}, date, {
          month: date.month - 1
        });
      }
    });
    
  //日期时间范围
    laydate.render({
      elem: '#test-laydate-range-datetime'
      ,type: 'datetime'
      ,range: true
    });     
    
  });  
  
 

  </script>
</body>
</html>