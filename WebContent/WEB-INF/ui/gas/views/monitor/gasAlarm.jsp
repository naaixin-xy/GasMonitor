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
/*   .layui-card-header-1{position:absolute;margin-left:200px;margin-top:-41px;} */
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
		          <div class="layui-form-item">
		            <div class="layui-inline">
		              <label class="layui-form-label">主机ID</label>
		              <div class="layui-input-inline">
		                <input type="tel" name="hostId" lay-verify="hostId" autocomplete="off" class="layui-input">
		              </div>
		            </div>
		            <div class="layui-inline">
		              <label class="layui-form-label">探测器ID</label>
		              <div class="layui-input-inline">
		                <input type="text" name="detectorId" lay-verify="detectorId" autocomplete="off" class="layui-input ">
		              </div>
		            </div>
		            
	 				<div class="layui-inline">
	                  <label class="layui-form-label">报警时间</label>
	                  <div class="layui-input-inline">
	                    <input type="datetime" name="headTime" class="layui-input"  id="test-laydate-start" placeholder="开始日期">
	                  </div>
	                  <div class="layui-form-mid layui-hide-xs">
	                    -
	                  </div>
	                  <div class="layui-input-inline">
	                    <input type="datetime"  name="endTime" class="layui-input"  id="test-laydate-end" placeholder="结束日期">
	                  </div>
	                </div>
		            <div class="layui-inline">
		              <label class="layui-form-label">报警类型</label>
		              <div class="layui-input-inline">
		                <select name="type">
		                  <option value="">全选</option>
		                  <option value="1">低报</option>
		                  <option value="2">高报</option>
		                </select>
		              </div>
		            </div>	                
                	
<!-- 	                <div class="layui-inline"> -->
<!-- 	                	<label class="layui-form-label">报警类型</label> -->
<!-- 						<div class="layui-input-inline"> -->
<!-- 				  			<input type="checkbox" name="type[0]" value="1" title="高报"> -->
<!-- 							<input type="checkbox" name="type[1]"  value="1" title="低报" checked=""> -->
<!-- 				        </div>  -->
<!-- 				     </div> -->
<!-- 				   </div> -->
				   </div>
				   <div class="layui-form-item">	                
	                 <div class="layui-inline">
			            <div class="layui-input-inline">
		                  <button class="layui-btn" lay-submit lay-filter="component-form-element">搜索</button>
		                  <button type="reset" class="layui-btn layui-btn-primary">重置</button>
		                </div>  
	                 </div>             	            	            
		          </div>
	          </form>                 
       	  </div>
      </div>
	</div>
	</div>
	         
    <div class="layui-row layui-col-space15">
      <div class="layui-col-md12">
        <div class="layui-card">
          <div class="layui-card-body">
          
            <table class="layui-hide" id="test-table-toolbar" lay-filter="test-table-toolbar"></table>
            <script type="text/html" id="test-table-toolbar-toolbarDemo">
				<div class="layui-btn-group">
                    <button class="layui-btn layui-btn-sm layui-hide-xs" lay-event="getCheckLength"><i class="layui-icon layui-icon-about"/>选中数目</button>
                    <button class="layui-btn layui-btn-sm layui-hide-xs" lay-event="isAll"><i class="layui-icon layui-icon-ok-circle"></i>是否全选</button>
                	<button class="layui-btn layui-btn-sm " lay-event="delete"><i class="layui-icon layui-icon-delete"></i>批量删除</button>
				</div>
            </script>
             
            <script type="text/html" id="test-table-toolbar-barDemo">
				<div class="layui-btn-group">
					<a class="layui-btn layui-btn-xs" lay-event="detail"><i class="layui-icon layui-icon-list"></i><span class="layui-hide-xs"></span></a>
			  		<a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="delete"><i class="layui-icon layui-icon-delete"></i><span class="layui-hide-xs"></span></a>
			 	</div>
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
			
			var tableIns = table.render({
				
			      elem: '#test-table-toolbar'
			      ,url: 'monitor/getGasAlarmListByPage'
			      ,toolbar: '#test-table-toolbar-toolbarDemo'
			      ,title: '县区级行政区域列表'
			   	  ,height: 'full-245'
			   	  ,limit:10 
			   	  ,page: true
			   	  
			      ,cols: [[
			        {type: 'checkbox', fixed: 'left'}
			        ,{field:'id', title:'ID', width:80, fixed: 'left', unresize: true, sort: true}
			        ,{field:'hostId', title:'主机ID', edit: 'text',width:120}
			        ,{field:'detectorId', title:'探测器ID', edit: 'text',width:120}
			        ,{field:'hostAddress', title:'主机地址',width:100}
			        ,{field:'detectorAddress', title:'探测器地址', sort: true,width:120}   
			        ,{field:'type', title:'报警类型',width:100}
			        ,{field:'alarmDataValue', title:'数据',sort: true,width:120}
		        
			        
			        ,{field:'provinceId', title:'省ID', width:100}       
			        ,{field:'cityId', title:'城市ID', width:100}         
			        ,{field:'areaId', title:'县区ID',sort: true, width:100}
			        ,{field:'streetId', title:'街道ID', width:100}
			        ,{field:'enterpriseId', title:'单位ID', width:100, edit: 'text'}			        
			        ,{field:'location', title:'安装位置', width:140}			        
			        ,{field:'enterpriseName', title:'单位名称', width:100}        
			        ,{field:'streetName', title:'街道名称', width:100}       
			        ,{field:'areaName', title:'区名称', width:100}    
			        ,{field:'cityName', title:'城市名称',sort: true, width:100}
			        ,{field:'provinceName', title:'省名称', width:100}			        
			        ,{field:'startTime', title:'开始时间',width:160}
			        ,{field:'stopTime', title:'结束时间',sort: true,width:160}     
			        
			        
			        ,{field:'longitude', title:'经度',width:180}
			        ,{field:'latitude', title:'纬度', width:180, sort: true}				        
			        ,{fixed: 'right', title:'操作', toolbar: '#test-table-toolbar-barDemo',width:85}
			      ]] 
				  ,parseData: function(res){ //res 即为原始返回的数据
					  Date.prototype.format = function(fmt) { 
						     var o = { 
						        "M+" : this.getMonth()+1,                 //月份 
						        "d+" : this.getDate(),                    //日 
						        "h+" : this.getHours(),                   //小时 
						        "m+" : this.getMinutes(),                 //分 
						        "s+" : this.getSeconds(),                 //秒 
						        "q+" : Math.floor((this.getMonth()+3)/3), //季度 
						        "S"  : this.getMilliseconds()             //毫秒 
						    }; 
						    if(/(y+)/.test(fmt)) {
						            fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
						    }
						     for(var k in o) {
						        if(new RegExp("("+ k +")").test(fmt)){
						             fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
						         }
						     }
						    return fmt; 
						}  

					    var dataLength=res.data.length,i;
				  		var typeName=["","低报","高报"];
				  		for(i=0;i<dataLength;i++){
				  			res.data[i].type=typeName[res.data[i].type];
				  			res.data[i].startTime=new Date(res.data[i].startTime).format("yyyy-MM-dd hh:mm:ss");
				  			if(res.data[i].stopTime!=null){
				  				res.data[i].stopTime=new Date(res.data[i].stopTime).format("yyyy-MM-dd hh:mm:ss");
				  			}
				  		}
					  	console.log(res);
					    return {
					        "code": res.code, //解析接口状态
					        "msg": res.count, //解析提示文本
					        "count": res.count, //解析数据长度
					        "data": res.data//解析数据列表
					    };
				  }
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
				        case 'delete':
					          layer.msg('删除函数');
					          var data = checkStatus.data;
 							  var selectedId = new Array();
 							  var length = data.length;
 							  if(length<1){
 								 layer.msg('您尚未选择任何数据，请选择要删除的行！');  
 								 return;
 							  }
 							  for (var i=0;i<length;i++){
 							  		selectedId.push(data[i].id);	
 							  }	
 							  //alert(selectedId);
 						        layer.confirm('真的删除所选行么', function(index){
 						        	layer.close(index);  
 							       	$.post("monitor/deleteBatchGasAlarmInfo",
 							       		{ids:selectedId},
 							       		function(result){
 							      	        
 							       			if(result.result=="success"){
 							       				tableIns.reload();
 							       			 	layer.msg('删除成功');
 							       			}else{
 							       			 	layer.msg('删除失败');
 							       			}
 							       		}
 							       	);	
 						        }); 							  
					    break;
			      };
		    });
		    
		    //监听行工具事件
		    table.on('tool(test-table-toolbar)', function(obj){
		    	
			      var data = obj.data;
			      console.log(obj);
			      if(obj.event === 'delete'){
				        layer.confirm('真的删除行么', function(index){
				        	layer.close(index); 
					       	$.post("monitor/deleteGasAlarmInfo",
					       		{id:data.id},
					       		function(result){
					      	        
					       			if(result.result=="success"){
					       			 	obj.del();
					       			 	layer.msg('删除成功');
					       			}else{
					       			 	layer.msg('删除失败');
					       			}
					       		}
					       	);	
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
			      } else if(obj.event === 'detail'){
			    		perContent=layer.open({
							type: 2,
							area: ["100%", "100%"],
							fix: false, //不固定
							//maxmin: true,
							//resize:false,
							skin: 'layui-layer-molv',
//							skin: 'layui-layer-lan',
							border:[3,1,'#000',true],  
							shade:0.4,
							//title: "<i class=\"layui-icon layui-icon-add-1\"></i>探测器添加",
							title: 0,//去除标题
							closeBtn:0,//去除x按钮
							content: "monitor/jumpToGasAlarmDetailInfo?alarmInfoId="+data.id
						});
						//alert("查看详情:"+data.id);
			      }
		    });
		    form.render(null, 'component-form-group'); 
		    //示例代码
		    
		    //开始日期
		    var insStart = laydate.render({
			      elem: '#test-laydate-start'
			      ,type: 'datetime'
			      ,done: function(value, date){
				      //更新结束日期的最小日期
				      insEnd.config.min = lay.extend({}, date, {
				          month: date.month - 1
				          ,hours: date.hours
				          ,minutes: date.minutes
				          ,seconds: date.seconds
				      });
				        
				        //自动弹出结束日期的选择器
				     insEnd.config.elem[0].focus();
			      }
		    });
		    
		    //结束日期
		    var insEnd = laydate.render({
			      elem: '#test-laydate-end'
			      ,type: 'datetime'
			      ,done: function(value, date){
			        //更新开始日期的最大日期
				        console.log(date);
				        insStart.config.max = lay.extend({}, date, {
					          month: date.month - 1
					          ,hours: date.hours
					          ,minutes: date.minutes
					          ,seconds: date.seconds
				        });
			      }
		    });  
		    
		    
		    /* 监听提交 */
		    form.on('submit(component-form-element)', function(data){
		    	  tableIns.reload({
		    		  where: data.field	    		 
		    		 ,page: {
		    			    curr: 1 //重新从第 1 页开始
		    		 }
		    	  });
			      return false;
		    });
		    
		    
		    /* 自定义验证规则 */
		    form.verify({
			      title: function(value){
				        if(value.length < 5){
				          return '标题至少得5个字符啊';
				        }
			      }
			      ,pass: [/(.+){6,12}$/, '密码必须6到12位']
			      ,username: function(value, item){ //value：表单的值、item：表单的DOM对象
			    	    if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
			    	      return '用户名不能有特殊字符';
			    	    }
			    	    if(/(^\_)|(\__)|(\_+$)/.test(value)){
			    	      return '用户名首尾不能出现下划线\'_\'';
			    	    }
			    	    if(/^\d+\d+\d$/.test(value)){
			    	      return '用户名不能全为数字';
			    	    }
			      }
			    	  
			      //我们既支持上述函数式的方式，也支持下述数组的形式
			      //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
			      ,pass: [
			    	    /^[0-9]*$/
			    	    ,'密码必须6到12位，且不能出现空格'
			       ]
			      ,hostId: [
			    	    /^[0-9]{0,10}$/
			    	    ,'主机ID，必须为空或者是数字'
			       ]			      
			     
			      ,detectorId: [
			    	    /^[0-9]{0,10}$/
			    	    ,'探测器ID，必须为空或者是数据'
			       ]
		    });		    
		    
	  });  
  
  </script>
</body>
</html>