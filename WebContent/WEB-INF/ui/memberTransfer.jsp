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
			<b style="color: red; font-size: 16px">*</b><label>上级客户：</label>
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
			<b style="color: red; font-size: 16px">*</b><label>客户名称：</label> <input type="text" id="localizerid" value="${members[0].name}(${members[0].id})" disabled="disabled" placeholder="不能为空，且只能是4-10位字母汉字数字或者下划线" />
		</p>
		<p class="remark-input ue-clear">
			<label>备注：</label>
			<textarea placeholder="请输入内容" id="remark">${members[0].remark}</textarea>
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

//var customNode

$(function (){
	
		//用户列表树型控件产生--------------------------------------------------------------------------------------------------------------------------------------------//
		var setting = {
			async: {
					enable: true,
					url:"getChildrenMemberById",
					autoParam:["id"],
					//otherParam: ["id",id]
					//otherParam:{"otherParam":"zTreeAsyncTest"},
					//dataFilter: filter
			},	
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
					$("#customname").text(treeNode.name);
					//alert(deviceUserChildrenId);
					//alert("${localizer.id}");						
					customNode=treeNode;
					if("${members[0].id}"==treeNode.id){
						alert("您不能把自己转给自己!");
						return;
					}
					$(".select-list").hide();
				}
			}
		}
		var zNodes = [];
		var t = $("#treeul");
		$.fn.zTree.init(t, setting, zNodes);		
	//var deviceNode;
	$(".select-title").on("click",function(){
		//$(".select-list").hide();
		$(this).siblings($(".select-list")).show();
		//var zTree = $.fn.zTree.getZTreeObj("#tree-div");

// 		var memberTree = $.fn.zTree.getZTreeObj("treeul");
// 		memberTree.expandAll(true);
 		treeObj = $.fn.zTree.getZTreeObj("treeul");
		var nodes = treeObj.getSelectedNodes();
		if (nodes.length>0) {
			treeObj.reAsyncChildNodes(nodes[0], "refresh");
		}
		return false;
	})
	

	
	$(".confirm").on("click",
		function(){
			//alert(deviceUserChildrenId.includes(customNode.id));
			//alert(selectedUserParentsId.toString());
			$.post("memberTransfer.do",
					{
						sourceUserId:parseInt("${members[0].id}"),
						destinationUserId:customNode.id,
						remark:$("#remark").val()
					},
					function(result) {
						var index = parent.layer.getFrameIndex(window.name);	
						if(result.result=="success"){alert("转移成功！");parent.layer.close(index);}else{alert("转移失败");}
			});			
		});
	});	
	//必须紧跟其后读取selectedId的值

showRemind('input[type=text], textarea','placeholder');
</script>
</html>
