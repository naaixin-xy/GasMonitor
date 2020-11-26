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
<link rel="stylesheet" href="ui/css/localizerSale.css" />
<link rel="stylesheet" type="text/css" href="ui/js/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css">
<title>1</title>
<style type="text/css">
</style>

</head>
<body>
	<!-- <div class="title"><h2>用户注册</h2></div> -->
<style type="text/css">
.main .long-input {
	width: 540px;
	float: left;
}

.main .remark-input {
	width: 540px;
	float: left;
}

.error-tips {
	color: red;
	position: relative;
	margin-left: 5px;
}
</style>
	<div class="main">
		<div class="long-input select ue-clear">
			<b style="color: red; font-size: 16px">*</b><label>客户名称：</label>
			<div class="select-wrap">
				<div class="select-title ue-clear">
					<span id="customname">请选择您要转移的客户</span> <i class="icon"></i>
				</div>
				<!-- 	            <ul id="treeul" class="select-list ztree"> -->
				<!-- 	            </ul> -->
				<ul id="treeul" class="select-list ztree" style="width: 330px; height: 330px; overflow: auto">
				</ul>
			</div>
		</div>
		<p class="long-input ue-clear">
			<b style="color: red; font-size: 16px">*</b><label>设备ID：</label> <input type="text" id="localizerid" value="${localizer.id}" disabled="disabled" placeholder="不能为空，且只能是4-10位字母汉字数字或者下划线" />
		</p>
		<p class="long-input ue-clear">
			<b style="color: red; font-size: 16px">*</b><label>设备名：</label> <input type="text" id="name" disabled="disabled" readonly="true" value="${localizer.name}" placeholder="不能为空，且只能是4-10位字母汉字数字或者下划线" />
		</p>
		<p class="long-input ue-clear">
			<label>设备属于：</label> <input type="text" id="deviceUserId" disabled="disabled" readonly="true" value="${localizer.member.name}" />
		</p>
		<p class="long-input ue-clear">
			<label>设备电话：</label> <input type="text" id="phone" value="${localizer.phone}" placeholder="不能为空，且只能是5-20位数字" />
		</p>
		<p class="remark-input ue-clear">
			<label>备注：</label>
			<textarea placeholder="请输入内容" id="deviceNote">${localizer.deviceNote}</textarea>
		</p>
		<div class="main" style="height: 5px; clear: both; magin: 0; padding: 0"></div>
	</div>

	<div class="btn ue-clear">
		<a href="javascript:;" class="confirm">确定</a> <a href="javascript:;" class="clear">清空内容</a>
	</div>
	<!-- <div style="width:600px;height:600px;"> -->
	<!--     <ul id="tree-div" class="ztree" style="width:320px; height:500px;overflow: auto" > -->
	<!-- 	</ul> -->
	<!-- </div> -->
</body>
<script type="text/javascript" src="ui/js/jquery.min.js"></script>
<!-- <script type="text/javascript" src="ui/js/jquery.js"></script> -->
<script type="text/javascript" src="ui/js/common.js"></script>
<script type="text/javascript" src="ui/js/WdatePicker.js"></script>
<!-- <script type="text/javascript" src="ui/js/lib/zTree/v3/js/jquery.ztree.all-3.5.js"></script> -->
<script type="text/javascript" src="ui/js/lib/zTree/v3/js/jquery.ztree.all.js"></script>
<!-- <script type="text/javascript" src="ui/js/lib/zTree/v3/js/jquery.ztree.core-3.5.js"></script> -->
<script type="text/javascript">

var customNode
$(function (){
// 	$(".confirm").on("click",function(){
// 		var postParameter={
// 				//id:customname
// 			};
// 		//postParameter.account();
// 		//alert(JSON.stringify(postParameter));
		
// 		$.post("localizerModify.do",
// 			postParameter,
// 			function(result){
		        
// 				var index = parent.layer.getFrameIndex(window.name);
// 				//parent.$('.btn-refresh').click();
// 				if(result.result=="success"){
// 					alert("设备信息修改成功！");
// 					//parent.location.reload(); 
// 					parent.layer.close(index);	
// 				}else{
// 					alert("设备信息修改失败！");
// 				}
// 	    	}
// 		);				
// 	})	
		//用户列表树型控件产生--------------------------------------------------------------------------------------------------------------------------------------------//
		var setting = {
			view : {
				dblClickExpand : false,
				showLine : true,
				selectedMulti : false
			},
			data : {
				simpleData : {
					enable : true,
					idKey : "id",
					pIdKey : "parentId",
					rootPId : null
				}
			},
			callback : {
				beforeClick : function(treeId, treeNode) {
					//var zTree = $.fn.zTree.getZTreeObj("treeul");
					//getSelectedItemChildren(treeNode);
				},
				onClick:function(e,treeId, treeNode) {
					//selectedId=[];			
					selectedUserParentsId=getAllParentItemsId(treeNode);
					deviceUserParentsId=getAllParentItemsId(deviceNode);
					//alert(selectedUserParentsId);
					//alert(deviceUserParentsId);
// 					var i=0;
// 					while((selectedUserParentsId.length>0)&&(deviceUserParentsId.length>0)){
// 						if(selectedUserParentsId[i]==deviceUserParentsId[i]){
// 							selectedUserParentsId.splice(0,1);
// 							deviceUserParentsId.splice(0,1);
// 						}else{
// 							break;
// 						}
// 						i++
// 					}
// 					alert(selectedUserParentsId);
// 					alert(deviceUserParentsId);
					//alert(treeNode.level);
					$("#customname").text(treeNode.name);
					//alert(deviceUserChildrenId);
					//alert("${localizer.id}");						
					customNode=treeNode;
					if(customNode==deviceNode){
						alert("您不能把产品销售给自己!");
						return;
					}
					$(".select-list").hide();
				}
			}
		}
		var zNodes = [];
	//var deviceNode;
	$(".select-title").on("click",function(){
		//$(".select-list").hide();
		$(this).siblings($(".select-list")).show();
		//var zTree = $.fn.zTree.getZTreeObj("#tree-div");
		var t = $("#treeul");
		$.fn.zTree.init(t, setting, zNodes);
		$.post("getAllMemberTreeNodes", function(result) {
			zNodes = result;
			$.fn.zTree.init(t, setting, result);
			var memberTree = $.fn.zTree.getZTreeObj("treeul");
			nodes = memberTree.getNodes();
// 			var i;
			//获取设备所属节点的的子节点id
			deviceNode = memberTree.getNodeByParam("id", parseInt("${localizer.deviceUserId}"), null);
			getSelectedItemChildren(deviceNode)
			deviceUserChildrenId=selectedId;
// 			for(i=0;i<zNodes.length;i++){
// 				if(${localizer.deviceUserId}==zNodes[i].id){
// 					alert(zNodes[i].id);
// 					deviceNode=zNodes[i];
// 				}
// 			};
			memberTree.expandAll(true);
			memberTree.selectNode(zNodes[2]);
		});		
		return false;
	})
	

	
	$(".confirm").on("click",
		function(){
			//alert(deviceUserChildrenId.includes(customNode.id));
			//alert(selectedUserParentsId.toString());
			$.post("localizerSale",
					{
						sourceUserId:deviceNode.id,
						destinationUserId:customNode.id,
						deviceId:parseInt("${localizer.id}"),
						name:$("#name").val(),
						phone:$("#phone").val(),
						deviceNote:$("#deviceNote").val(),
						childFlag:function(){
							return deviceUserChildrenId.includes(customNode.id);
						},
						sourceParentsId:deviceUserParentsId.toString(),
						destinationParentsId:selectedUserParentsId.toString()
					},
					function(result) {
						var index = parent.layer.getFrameIndex(window.name);	
						if(result.result=="success"){alert("销售成功！");parent.layer.close(index);}else{alert("销售失败");}
			});			
		});
	});	
	var selectedId=new Array();
	var deviceNode;
	var deviceUserChildrenId=new Array();
	var deviceUserParentsId=new Array();
	var selectedUserParentsId=new Array();
	//必须紧跟其后读取selectedId的值
	function getSelectedItemChildren(treeNode){	
		if(treeNode.children!=null){
			var i;
			for(i=0;i<treeNode.children.length;i++){
				selectedId.push(treeNode.children[i].id);
				if(treeNode.children[i].isParent){
					getSelectedItemChildren(treeNode.children[i]);		
				}
			}
		}
		//alert(selectedId);
	}
	function getAllChildrenItemsId(treeNode){	
		if(treeNode.children!=null){
			var i;
			for(i=0;i<treeNode.children.length;i++){
				selectedId.push(treeNode.children[i].id);
				if(treeNode.children[i].isParent){
					getAllChildrenItemsId(treeNode.children[i]);		
				}
			}
		}
		//return selectedId;
	}
	function getAllParentItemsId(treeNode){	
		var parents=treeNode.getPath(),i,parentArray=new Array();
		for(i=0;i<parents.length;i++){
			parentArray.push(parents[i].id);
		}
		//alert(parentArray);
		//alert(selectedId);
		return parentArray;
	}	
	
showRemind('input[type=text], textarea','placeholder');
</script>
</html>
