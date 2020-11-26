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
	width: 800px;
	float: left;
	border:none;
	margin:0px;
	padding-bottom:10px;
}
.btn.confirmbutton{ padding:13px 0 30px 287px; border:1px solid #c1d3de; border-top:none;}
.btn.confirmbutton a.confirm:hover{background:#6ec98a; font-size:10px;}
.btn.confirmbutton a.confirm:active{background:#009f95; font-size:10px;}

.main p.long-input input[type="text"]{ width:200px;margin-right:20px; }
.btn a{ float:left; margin-right:7px; text-align:center; border:none; border-radius:2px; font-size:14px;}
.btn a.overdueTime{ width:88px; height:28px; line-height:28px; background:#68b86c; color:#fff; }
.btn a.overdueTime:hover{background:#6ec98a; font-size:10px;}
.btn a.overdueTime:active{background:#009f95; font-size:10px;}

.error-tips {
	color: red;
	position: relative;
	margin-left: 5px;
}
</style>
	<div class="main">
		<p class="long-input btn ue-clear">
			<label style="width:100px">增加到期时间：</label> <input type="text" id="overdueTimeText" disabled="disabled" readonly="true" value="${localizer.name}" placeholder="不能为空，且只能是4-10位字母汉字数字或者下划线" />
			<label>天</label>
			
			<a href="javascript:;" class="confirm overdueTime month">一个月</a>
			<a href="javascript:;" class="confirm overdueTime year">一年</a>
			<a href="javascript:;" class="confirm overdueTime alllife">终身</a>
		</p>
		<div class="main" style="height: 1px; clear: both; magin: 0; padding: 0"></div>
	</div>

	<div class="btn ue-clear confirmbutton">
		<a href="javascript:;" class="confirm confirmbuttonso">确定</a> <a href="javascript:;" class="clear">清空内容</a>
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

	$(".overdueTime.month").on("click",	function(){
		$("#overdueTimeText").val(30);
	});
	$(".overdueTime.year").on("click",	function(){
		$("#overdueTimeText").val(365);
	});
	$(".overdueTime.alllife").on("click",	function(){
		$("#overdueTimeText").val(36500);
	});
	$(".confirm.confirmbuttonso").on("click",
		function(){
			//alert(deviceUserChildrenId.includes(customNode.id));
			//alert(selectedUserParentsId.toString());
			$.post("localizerOverdueTimeSet.do",
					{
						id:parseInt("${id}"),
						addTime:$("#overdueTimeText").val()
					},
					function(result) {
						var index = parent.layer.getFrameIndex(window.name);	
						if(result.result=="success"){alert("增加到期时间成功！");parent.layer.close(index);}else{alert("增加到期成功失败！");}
			});			
		});
	});	
	//必须紧跟其后读取selectedId的值

showRemind('input[type=text], textarea','placeholder');
</script>
</html>
