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
  <title>探测器列表</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="../layuiadmin/layui/css/layui.css" media="all">
  <link rel="stylesheet" href="../layuiadmin/style/admin.css" media="all">
	
	<style type="text/css">
	#container {width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"微软雅黑";}
	</style>  
  <style>
/*    	.layui-carousel-container{ */ */
/*  	    position: absolute; */ */
/*  	    top:50px; */ */
/*  	    left:0px; */ */
/*  	    right:0px; */ */
/*  	  	bottom: 0px;  	 */ */
/*    	} */
/*    	.layui-gasdetector-carousel { */
/* 	    position: absolute; */
/* 	   bottom: 10px; */
/*    	}  */
/*  	.layui-gasdetector-carousel>*[carousel-item]>div {  */
/*     		 height: 'full-100' !important;  */
/*  	}  	  */
/* 	.layui-gasdetector-carousel .layui-carousel-ind { */
/* 	    position: absolute; */
/* 	    top: -41px; */
/* 	    text-align: right; */
/* 	}	 */
  </style>
  <script type="text/javascript" src="http://api.map.baidu.com/api?v=3.0&ak=k7FWhLNhBxNNLrxRL10m2e1cyik0XZ7H"></script>
</head>
<body>

  <div class="layui-card layadmin-header">
    <div class="layui-breadcrumb" lay-filter="breadcrumb">
      <a lay-href="">主页</a>
      <a><cite>组件</cite></a>
      <a><cite>数据表格</cite></a>
      <a><cite>探测器列表</cite></a>
    </div>
  </div>
  
  <div class="layui-fluid">
	<div class="layui-row layui-col-space15">
      <div class="layui-col-md12">
        <div class="layui-card">
          <div class="layui-card-header">探测器列表</div>
          <div class="layui-card-body">
          	<div>
				<table class="layui-hide" id="test-table-toolbar" lay-filter="test-table-toolbar"><i class="layui-icon layui-icon-loading1 layadmin-loading"></i> </table>          
 			</div>
          </div>                          
          <script type="text/html" id="test-table-toolbar-toolbarDemo">
			<div class="layui-btn-group">
                <button class="layui-btn layui-btn-sm" lay-event="add"><i class="layui-icon layui-icon-add-1"></i>增加</button>
				<button class="layui-btn layui-btn-sm layui-hide-xs" lay-event="edit"><i class="layui-icon layui-icon-edit"></i>编辑</button>
				<button class="layui-btn layui-btn-sm" lay-event="set"><i class="layui-icon layui-icon-set-sm"></i>设置</button>
                <button class="layui-btn layui-btn-sm layui-btn-danger" lay-event="delete"><i class="layui-icon layui-icon-delete"></i>删除</button>
              </div>
          </script>
             
          <script type="text/html" id="test-table-toolbar-barDemo">
			<div class="layui-btn-group">
              <a class="layui-btn layui-btn-xs" lay-event="edit"><i class="layui-icon layui-icon-edit"></i></a>
			  <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="set"><i class="layui-icon layui-icon-set-sm"></i></a>
			 </div>
          </script>
          </div>
        </div>
   
		 <div class="layui-col-md12">
	        <div class="layui-card">
	          <div class="layui-card-header">探测器列表</div>
	          <div class="layui-card-body">
				<div id="container"></div>
	          </div>                                  
	        </div>
	     </div>
	  </div>
  </div>
               	
  <script src="../layuiadmin/layui/layui.js"></script>  
  <script>
  var gtable;
  layui.config({
    base: '../layuiadmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use(['index', 'table','carousel'], function(){
	var $ = layui.$ //重点处 获取内置的Jquery模块
    var admin = layui.admin
    ,table = layui.table
    ,device = layui.device()
	,carousel = layui.carousel;
	console.log(device);
	
    table.render({
      elem: '#test-table-toolbar'
      ,url: 'device/getGasDetectorListByPage'
      ,toolbar: '#test-table-toolbar-toolbarDemo'
      ,title: '县区级行政区域列表'
   	  //,height: '50%'
   	  ,height: 'full-100'
   	  ,size: 'sm'
   	  ,limit:20 
      ,cols: [[
        {type: 'checkbox', fixed: 'left'}
        ,{field:'id', title:'ID', width:60, fixed: 'left', unresize: true, sort: true}
        ,{field:'name', title:'设备名称', width:100, edit: 'text'}
        ,{field:'enterpriseId', title:'单位ID', width:80, edit: 'text'}
        ,{field:'subArea', title:'子区域ID', width:80, edit: 'text', sort: true}
        ,{field:'typeId', title:'设备类型', width:80}
        ,{field:'longitude', title:'经度'}
        ,{field:'latitude', title:'纬度', width:80, sort: true}
        ,{field:'hostId', title:'主机ID', width:80}
        ,{field:'communicationAddress', title:'通信地址', width:80, sort: true}
        ,{field:'location', title:'安装位置', width:140}
        ,{field:'coordinateX', title:'平面X坐标', width:80}        
        ,{field:'coordinateY', title:'平面Y坐标', width:80}       
        ,{field:'governor', title:'管理人', width:80}

        ,{field:'installer', title:'安装人',sort: true, width:80}
        ,{field:'serialNumber', title:'序列号',edit: 'text', width:100}
        ,{field:'lowAlarm', title:'低限报警值',  edit: 'text', width:100}
        ,{field:'highAlarm', title:'高限报警值', edit: 'text', sort: true, width:100}
        ,{field:'status', title:'设备状态', width:80}
        ,{field:'connectionStatus', title:'连接状态', width:80}
        ,{field:'alarmStatus', title:'报警状态',  sort: true, width:80}
        ,{field:'faultStatus', title:'故障状态', width:80}
        ,{field:'note', title:'备注',sort: true, width:100}
        ,{field:'createTime', title:'创建时间时间', width:140}
        ,{field:'lastUpdateTime', title:'上次更新时间',width:140}
        
        ,{field:'currentValue', title:'当前值',width:100}       
        ,{field:'minValue', title:'最小值', width:80}         
        ,{field:'maxValue', title:'最大值',sort: true, width:80}
        ,{field:'gasType', title:'气体类型', width:100}
        ,{field:'gasUnit', title:'浓度单位', width:80}       
        
        ,{field:'provinceId', title:'省ID', width:80}       
        ,{field:'cityId', title:'城市ID', width:80}         
        ,{field:'areaId', title:'县区ID',sort: true, width:80}
        ,{field:'streetId', title:'街道ID', width:80}
        ,{field:'enterpriseName', title:'单位名称', width:100}        
        ,{field:'streetName', title:'街道名称', width:100}       
        ,{field:'areaName', title:'区名称', width:100}    
        
        ,{field:'cityName', title:'城市名称',sort: true, width:100}
        ,{field:'provinceName', title:'省名称', width:100}
        ,{fixed: 'right', title:'操作', toolbar: '#test-table-toolbar-barDemo', width:85}
      ]]
      ,page: true
      ,done: function(res, curr, count){
    	    //如果是异步请求数据方式，res即为你接口返回的信息。
    	    //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
    	    console.log(res);
    	    gtable=res;
    	    //得到当前页码
    	    console.log(curr); 
    	    
    	    //得到数据总量
    	    console.log(count);
    		for (var i = 0; i < res.data.length; i ++) {
    			var point = new BMap.Point(res.data[i].latitude,res.data[i].longitude);
    			addMarker(point);
    		}	
    		
    	  }
    });

	
    //头工具栏事件
    table.on('toolbar(test-table-toolbar)', function(obj){
      var checkStatus = table.checkStatus(obj.config.id);
      console.log(obj.config);
      console.log(obj);
      console.log(table);
      console.log(checkStatus);
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
        case 'add':
           // layer.msg(checkStatus.isAll ? '全选': '未全选');
			perContent=layer.open({
				type: 2,
				area: ["90%", "90%"],
				fix: false, //不固定
				maxmin: true,
				//resize:false,
				skin: 'layui-layer-molv',
//				skin: 'layui-layer-lan',
				border:[3,1,'#000',true],  
				shade:0.4,
				title: "<i class=\"layui-icon layui-icon-add-1\"></i>探测器添加",
				content: "device/addDetector"
			});
			//layer.full(perContent);
          break;
        case 'edit':
        	window.open("../views/component/form/group.html");
          break;
        case 'set':
            //layer.msg(checkStatus.isAll ? '全选': '未全选');
    		perContent=layer.open({
				type: 2,
				area: ["90%", "90%"],
				fix: false, //不固定
				maxmin: true,
				//resize:false,
				skin: 'layui-layer-molv',
//				skin: 'layui-layer-lan',
				border:[3,1,'#000',true],  
				shade:0.4,
				title: "<i class=\"layui-icon layui-icon-add-1\"></i>探测器添加",
				//content: "../views/device/map.html"
			});
          break;
        case 'delete':
            layer.msg(checkStatus.isAll ? '全选': '未全选');
          break;          
      };
    });
   $("#container").height($(window).height()-100);
   //$("#container").height(1000);
	$(window).resize(
			function() {
				//$(".layui-gasdetector-carousel").height($(".layui-form.layui-border-box.layui-table-view").height());
				$("#container").height($(window).height()-100);
				//$("#container").height(1000);
				
				//$(".layui-gasdetector-carousel").css("height",$(".layui-form.layui-border-box.layui-table-view").css("height"));
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
<script type="text/javascript">

    var mp = new BMap.Map("container");
    mp.centerAndZoom(new BMap.Point(116.3964,39.9093), 10);
    mp.enableScrollWheelZoom();

    var top_left_control = new BMap.ScaleControl({anchor: BMAP_ANCHOR_TOP_LEFT});// 左上角，添加比例尺
	var top_left_navigation = new BMap.NavigationControl();  //左上角，添加默认缩放平移控件
	var top_right_navigation = new BMap.NavigationControl({anchor: BMAP_ANCHOR_TOP_RIGHT, type: BMAP_NAVIGATION_CONTROL_SMALL}); //右上角，仅包含平移和缩放按钮
	

	var mapType1 = new BMap.MapTypeControl(
		{
			mapTypes: [BMAP_NORMAL_MAP,BMAP_HYBRID_MAP],
			anchor: BMAP_ANCHOR_TOP_LEFT
		}
	);
	/*缩放控件type有四种类型:
	BMAP_NAVIGATION_CONTROL_SMALL：仅包含平移和缩放按钮；BMAP_NAVIGATION_CONTROL_PAN:仅包含平移按钮；BMAP_NAVIGATION_CONTROL_ZOOM：仅包含缩放按钮*/
	
	//添加控件和比例尺
	var geolocationControl = new BMap.GeolocationControl();
	geolocationControl.addEventListener("locationSuccess", function(e){
	    // 定位成功事件
	    var address = '';
	    address += e.addressComponent.province;
	    address += e.addressComponent.city;
	    address += e.addressComponent.district;
	    address += e.addressComponent.street;
	    address += e.addressComponent.streetNumber;
	    alert("当前定位地址为：" + address);
	  });
    geolocationControl.addEventListener("locationError",function(e){
	    // 定位失败事件
	    alert(e.message);
	  });
	mp.addControl(geolocationControl);	
	
	mp.addControl(mapType1);    
	//mp.addControl(top_left_control);        
	//mp.addControl(top_left_navigation);     
	mp.addControl(top_right_navigation);  

	var size = new BMap.Size(10, 20);
	mp.addControl(new BMap.CityListControl({
	    anchor: BMAP_ANCHOR_TOP_LEFT,
	    offset: size,
	    // 切换城市之间事件
	    // onChangeBefore: function(){
	    //    alert('before');
	    // },
	    // 切换城市之后事件
	    // onChangeAfter:function(){
	    //   alert('after');
	    // }
	}));
	
	// 编写自定义函数,创建标注
	function addMarker(point){
	  var marker = new BMap.Marker(point);
	  mp.addOverlay(marker);
	}
    
</script>
</body>
</html>