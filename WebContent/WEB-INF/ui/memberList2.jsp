<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath() + "/ui";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%!String test2 = "测试";%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="ui/css/base.css" />
<link rel="stylesheet" href="ui/css/info-mgt.css" />
<link rel="stylesheet" href="ui/css/WdatePicker.css" />
<link rel="stylesheet" type="text/css" href="ui/js/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css">
<title>移动办公自动化系统</title>
</head>

<body>
	<div class="title">
		<h2>用户管理</h2>
	</div>
	<div class="query">
		<div class="query-conditions ue-clear">
			<div class="conditions name ue-clear">
				<label>流程名称：</label>
				<div class="select-wrap">
					<div class="select-title ue-clear">
						<span>请选择</span><i class="icon"></i>
					</div>
					<ul class="select-list">
						<li>呵呵</li>
						<li>哈哈</li>
						<li>嘻嘻</li>
					</ul>
				</div>
			</div>
			<div class="conditions operate-time ue-clear">
				<label>操作时间：</label>
				<div class="select-wrap">
					<div class="select-title ue-clear">
						<span>大于或等于</span><i class="icon"></i>
					</div>
					<ul class="select-list">
						<li>呵呵</li>
						<li>哈哈</li>
						<li>嘻嘻</li>
					</ul>
				</div>
				<div class="input-box ue-clear">
					<input type="text" /> <span>小时</span>
				</div>
			</div>
			<div class="conditions time ue-clear">
				<label>时&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;间：</label>
				<div class="time-select">
					<input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="开始时间" /> <i class="icon"></i>
				</div>
				<span class="line">-</span>
				<div class="time-select">
					<input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="开始时间" /> <i class="icon"></i>
				</div>
			</div>
			<div class="conditions staff ue-clear">
				<label>人&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;员：</label> <input type="text" placeholder="可以直接输入或选择" /> <a href="javascript:;" class="staff-select">选择</a>
			</div>
		</div>
		<div class="query-btn ue-clear">
			<a href="javascript:;" class="confirm">查询</a> <a href="javascript:;" class="clear">清空条件</a>
		</div>
	</div>
	<div style="width: 100%">
		<div id="left-div" style="width: 15%; float: left; margin-right: 0%;">
			<div class="title" id="title-div" style="border-top-width: 0px">
				<h2>信息管理</h2>
			</div>
			<div class="query" style="height: 100%">
				<ul id="treeDemo" class="ztree"></ul>
			</div>
		</div>
		<c:if test=""></c:if>
		<div style="margin-left: 15%; width: 85%" id="right-div">
			<div id="right-div-up">
				<div class="table-operate ue-clear">
					<a href="javascript:;" class="add">添加</a> <a href="javascript:;" class="del">删除</a> <a href="javascript:;" class="edit">编辑</a> <a href="javascript:;" class="count">全选</a> <a href="javascript:;" class="check">审核</a>
				</div>
				<div class="table-box">
					<table>
						<thead>
							<tr>
								<th class="num">${pageInfo.headerInfo.order}</th>
								<th class="checkcontainer">${pageInfo.headerInfo.select}</th>
								<th class="w80">${pageInfo.headerInfo.id}</th>
								<th class="w120">${pageInfo.headerInfo.account}</th>
								<th class="w100">${pageInfo.headerInfo.password}</th>
								<th class="w80">${pageInfo.headerInfo.category}</th>
								<th class="w100">${pageInfo.headerInfo.name}</th>
								<th class="w80">${pageInfo.headerInfo.parentId}</th>
								<th class="w100">${pageInfo.headerInfo.phone}</th>
								<th class="w80">${pageInfo.headerInfo.deviceCount}</th>
								<th class="w100">${pageInfo.headerInfo.contact}</th>
								<%-- 								<th class="name">${pageInfo.headerInfo.createTime}</th> --%>
								<th class="w200">${pageInfo.headerInfo.modifyTime}</th>
								<th class="w120">操作</th>
								<%-- 								<th class="name">${pageInfo.headerInfo.remark}</th> --%>
							</tr>
						</thead>
						<tbody id="tableBody">

							<c:set var="order" scope="session" value="${0}" />
							<c:forEach var="itema" items="${pageInfo.dataInfo}" varStatus="status">
								<c:set var="order" scope="session" value="${order+1}" />
								<tr>
									<td class="num">${order}</td>
									<td class="checkcontainer"><input class="selectflag num" type="checkbox" name="selectflag" value="${itema.id}"></td>
									<td class="w80">${itema.id}</td>
									<td class="w120">${itema.account}</td>
									<td class="w100">${itema.password}</td>
									<td class="w80">${itema.category}</td>
									<td class="w100">${itema.name}</td>
									<td class="w80">${itema.parentId}</td>
									<td class="w100">${itema.phone}</td>
									<td class="w80">${itema.deviceCount}</td>
									<td class="w100">${itema.contact}</td>
									<%-- 									<td>${itema.createTime}</td> --%>
									<td class="w200">${itema.modifyTime}</td>
									<td><a>查看详情</a></td>
									<%-- 									<td>${itema.remark}</td> --%>
								</tr>
							</c:forEach>
							<!-- 								<tr> -->
							<%-- 									<td class="num">${order}</td> --%>
							<%-- 									<td class="checkcontainer"><input type="checkbox" name="selectflag" value="${pageInfo.dataInfo[0].id}"></td> --%>
							<%-- 									<td class="name">${pageInfo.dataInfo[0].id}</td> --%>
							<%-- 									<td class="name">${pageInfo.dataInfo[0].account}</td> --%>
							<%-- 									<td class="name">${pageInfo.dataInfo[0].password}</td> --%>
							<%-- 									<td class="name">${pageInfo.dataInfo[0].category}</td> --%>
							<%-- 									<td class="name">${pageInfo.dataInfo[0].name}</td> --%>
							<%-- 									<td class="name">${pageInfo.dataInfo[0].parentId}</td> --%>
							<%-- 									<td class="name">${pageInfo.dataInfo[0].phone}</td> --%>
							<%-- 									<td class="name">${pageInfo.dataInfo[0].deviceCount}</td> --%>
							<%-- 									<td class="name">${pageInfo.dataInfo[0].contact}</td> --%>
							<%-- 									<td class="name">${pageInfo.dataInfo[0].createTime}</td> --%>
							<%-- 									<td class="name">${pageInfo.dataInfo[0].modifyTime}</td> --%>
							<%-- 									<td class="name">${pageInfo.dataInfo[0].remark}</td> --%>
							<!-- 								</tr>							 -->
						</tbody>
					</table>
				</div>
			</div>
			<div style="height: 10px"></div>
			<div class="pagination ue-clear"></div>
		</div>
	</div>

</body>
<!-- <script type="text/javascript" src="js/jquery.js"></script> -->
<script type="text/javascript" src="ui/js/jquery.min.js"></script>
<script type="text/javascript" src="ui/js/lib/layer-v3.1.1/layer/layer.js"></script>
<script type="text/javascript" src="ui/js/lib/icheck/jquery.icheck.min.js"></script>
<script type="text/javascript" src="ui/js/lib/zTree/v3/js/jquery.ztree.all-3.5.js"></script>

<script type="text/javascript" src="ui/js/index.js"></script>
<script type="text/javascript" src="ui/js/common.js"></script>
<script type="text/javascript" src="ui/js/WdatePicker.js"></script>
<script type="text/javascript" src="ui/js/jquery.pagination.js"></script>

<script type="text/javascript">
$(function(){
	//layer_show(title,url,w,h);	
	$(".confirm").click(function() {
		alert("confirm button clicked!")
	});

		$("#left-div").css("height", $("#right-div-up").css("height"))


	$(".add").on("click", function() {
		layer_show("中国", "memberRegister.do", 1200, 790);
	});
	//var selectedId = new Array();
	$(".count").on("click", function() {
		//var str;
		var selectedId = new Array();
		$(".selectflag:checked").each(function(index,element){
			
			//str=str+element.value+":";
			selectedId.push(element.value);
		});
		alert(selectedId);
	});
	//jQuery.ajaxSettings.traditional = true;	
	$(".del").on("click", function() {
		//var str;
		var selectedId = new Array();
		$(".selectflag:checked").each(function(index,element){
			selectedId.push(element.value);
		});
		alert(selectedId);
		$.post("memberDelete",{
			deleteIds:selectedId
			//deleteIds:[23,24,25,26]
		}, function(result) {
			alert(JSON.stringify(result));
			location.reload();
		});		
// 		$.post("memberDelete",function(result) {
// 			alert(JSON.stringify(result));
// 			//location.reload();
// 		});		
	});
	var setting = {
			view: {
				dblClickExpand: false,
				showLine: false
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				onClick: onClick
			}
		};

		var zNodes =[
			{ id:1, pId:0, name:"根 Root", open:true},
			{ id:11, pId:1, name:"父节点 1-1", open:true},
			{ id:111, pId:11, name:"叶子节点 1-1-1"},
			{ id:112, pId:11, name:"叶子节点 1-1-2"},
			{ id:113, pId:11, name:"叶子节点 1-1-3"},
			{ id:114, pId:11, name:"叶子节点 1-1-4"},
			{ id:12, pId:1, name:"父节点 1-2", open:true},
			{ id:121, pId:12, name:"叶子节点 1-2-1"},
			{ id:122, pId:12, name:"叶子节点 1-2-2"},
			{ id:123, pId:12, name:"叶子节点 1-2-3"},
			{ id:124, pId:12, name:"叶子节点 1-2-4"},
			{ id:13, pId:1, name:"父节点 1-3", open:true},
			{ id:131, pId:13, name:"叶子节点 1-3-1"},
			{ id:132, pId:13, name:"叶子节点 1-3-2"},
			{ id:133, pId:13, name:"叶子节点 1-3-3"},
			{ id:134, pId:13, name:"叶子节点 1-3-4"}
		];

		function onClick(e,treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			//zTree.expandNode(treeNode);
		}
	
		$.fn.zTree.init($("#treeDemo"), setting, zNodes);
	})
		
// 	var setting = {
// 		view : {
// 			dblClickExpand : false,
// 			showLine : true,
// 			selectedMulti : false
// 		},
// 		data : {
// 			simpleData : {
// 				enable : true,
// 				idKey : "id",
// 				pIdKey : "pId",
// 				rootPId : ""
// 			}
// 		},
// 		callback : {
// 			beforeClick : function(treeId, treeNode) {
// 				var zTree = $.fn.zTree.getZTreeObj("tree-div");
// 				{
<%-- 					url = "<%=path%> --%>
	//AreaMonitorAdapterServlet?mode=serveradd.addSubAreaTreeParent&pId="
	// // 							+ treeNode.id;
	// // 					//alert(url);
	// // 					$.post(url, function(result) {
	// // 						//alert(result);
	// // 						var json = eval("(" + result + ")");
	// // 						alert("父区域选择成功");
	// // 						ListIframe.location.reload(true);
	// // 					});
	// 					return true;
	// 				}
	// 			}
	// 		}
	// 	};

	// 	var zNodes = [ {
	// 		id : 1,
	// 		pId : 0,
	// 		name : "一级分类",
	// 		open : true
	// 	}, {
	// 		id : 11,
	// 		pId : 1,
	// 		name : "二级分类"
	// 	}, {
	// 		id : 111,
	// 		pId : 11,
	// 		name : "三级分类"
	// 	}, {
	// 		id : 112,
	// 		pId : 11,
	// 		name : "三级分类"
	// 	}, {
	// 		id : 113,
	// 		pId : 11,
	// 		name : "三级分类"
	// 	}, {
	// 		id : 114,
	// 		pId : 11,
	// 		name : "三级分类"
	// 	}, {
	// 		id : 115,
	// 		pId : 11,
	// 		name : "三级分类"
	// 	}, {
	// 		id : 12,
	// 		pId : 1,
	// 		name : "二级分类 1-2"
	// 	}, {
	// 		id : 121,
	// 		pId : 12,
	// 		name : "三级分类 1-2-1"
	// 	}, {
	// 		id : 122,
	// 		pId : 12,
	// 		name : "三级分类 1-2-2"
	// 	}, ];

	// 	var code;

	// 	function showCode(str) {
	// 		if (!code)
	// 			code = $("#code");
	// 		code.empty();
	// 		code.append("<li>" + str + "</li>");
	// 	}

	// 	function loadReady(str) {
	// 		if (!code)
	// 			code = $("#code");
	// 		code.empty();
	// 		code.append("<li>" + str + "</li>");
	// 	}
	// 	zNodes = eval("(" + zNodes + ")");
	// 	var t = $("#tree-div");
	// 	t = $.fn.zTree.init(t, setting, zNodes);
	// 	var zTree = $.fn.zTree.getZTreeObj("tree-div");
	// 		//isParent = e.data.isParent,
	// 	zTree.expandAll(true);
	// 	$(document)
	// 			.ready(
	// 					function() {
	// 						url = "
<%-- <%=path%> --%>
	//AreaMonitorAdapterServlet?mode=serverquery.querySubAreaList.queryAll.subarea.sa";
	// 						//alert(url);
	// 						$.post(url, function(result) {
	// 							//alert(result);
	// 							var json = eval("(" + result + ")");
	// 							//	 		alert(json);

	// 							zNodes = result.replace(/sa_/g, "");
	// 							//zNodes=[];
	// 							//alert(zNodes);				

	// 							var t = $("#TreeArea");
	// 							var parentNode;
	// 							var nodeArray;
	// 							for (var i = 0; i < json.length; i++) {
	// 								//	 			parentNode = zTree.getNodeByTId(json[i].sa_pId);
	// 								//	 			if (i!=0) {
	// 								//	 				treeNode = zTree.addNodes(parentNode, {id:json[i].sa_id, pId:228,isParent:true,name:json[i].sa_name});
	// 								//	 			} else {
	// 								//	 				treeNode = zTree.addNodes(null,  {id:json[i].sa_id, pId:json[i].sa_pId,isParent:true,name:json[i].sa_name});
	// 								//	 			}
	// 								if (i == 0) {
	// 									nodeArray = "[{id:" + json[i].sa_id
	// 											+ ", pId:" + json[i].sa_pId
	// 											+ ",isParen:true,name:'"
	// 											+ json[i].sa_name + "'},";
	// 									//treeNode = zTree.addNodes(parentNode, {id:json[i].sa_id, pId:228,isParent:true,name:json[i].sa_name});
	// 								} else if (i == json.length - 1) {
	// 									nodeArray += "{id:" + json[i].sa_id
	// 											+ ", pId:" + json[i].sa_pId
	// 											+ ",isParen:true,name:'"
	// 											+ json[i].sa_name + "'}]";
	// 								} else {
	// 									nodeArray += "{id:" + json[i].sa_id
	// 											+ ", pId:" + json[i].sa_pId
	// 											+ ",isParen:true,name:'"
	// 											+ json[i].sa_name + "'},";
	// 								}
	// 							}
	// 							//zNodes=eval("(" + nodeArray + ")");
	// 							zNodes = eval("(" + zNodes + ")");
	// 							t = $.fn.zTree.init(t, setting, zNodes);
	// 							var zTree = $.fn.zTree.getZTreeObj("TreeArea");
	// 							//isParent = e.data.isParent,
	// 							zTree.expandAll(true);
	// 							zTree.selectNode(zTree.getNodeByParam("id",
	// 									'${sessionScope.subArea_pId}'));
	// 							nodes = zTree.getNodes();
	// 							treeNode = nodes[0];
	// 							//ListIframe = $("#ListIframe");
	// 							//ListIframe.bind("load", loadReady);
	// 							//var zTree = $.fn.zTree.getZTreeObj("TreeArea");
	// 							//zTree.selectNode(zTree.getNodeByParam("id",'228'));		

	// 							//	 		var htmltext='<option value="">请选择主机</option>';
	// 							//	 		//alert(result);
	// 							//	 		for(var i=0; i<json.length; i++){
	// 							//	 			if(json[i].hm_id=="${requestScope.list[0].dt_host}"){
	// 							//	 				htmltext += '<option value="' + json[i].hm_id + '" selected="selected">' + json[i].hm_name + '</option>';
	// 							//	 			}else{
	// 							//	 				htmltext += '<option value="' + json[i].hm_id + '">' + json[i].hm_name + '</option>';				
	// 							//	 			}
	// 							//	 		}
	// 							//	 		document.getElementById("host").innerHTML= htmltext;
	// 							//document.getElementById("test").innerHTML= zNodes;
	// 						});
	// 						//zTree.expandAll(true);
	// 					});
</script>

<script type="text/javascript">

$(function(){
	//background-color:rgb(239, 246, 250);
	function showJsonValue(jasonObj){
		var htmlString="";
		var listSize=jasonObj.dataInfo.length;
		for(i=0;i<listSize;i++){
			var start;
			if(i%2==0){
				start="<tr>";
			}else{
				start="<tr style=\"background-color:rgb(239, 246, 250)\">";
			}
			htmlString+="<tr>"
				+"<td class=\"num\">"+i+"</td>"
				+"<td class=\"checkcontainer\"><input class=\"selectflag num\" type=\"checkbox\" name=\"selectflag\" value=\"" + jasonObj.dataInfo[i].id + "\"></td>"
				+"<td class=\"w80\">"+jasonObj.dataInfo[i].id+"</td>"
				+"<td class=\"w120\">"+jasonObj.dataInfo[i].account+"</td>"
				+"<td class=\"w100\">"+jasonObj.dataInfo[i].password+"</td>"
				+"<td class=\"w80\">"+jasonObj.dataInfo[i].category+"</td>"				
				+"<td class=\"w100\">"+jasonObj.dataInfo[i].name+"</td>"				
				+"<td class=\"w80\">"+jasonObj.dataInfo[i].parentId+"</td>"				
				+"<td class=\"w100\">"+jasonObj.dataInfo[i].phone+"</td>"
				+"<td class=\"w80\">"+jasonObj.dataInfo[i].deviceCount+"</td>"				
				+"<td class=\"w100\">"+jasonObj.dataInfo[i].contact+"</td>"
				+"<td class=\"w200\">"+jasonObj.dataInfo[i].modifyTime+"</td>"
				+"<td ><a>查看详情</a></td>"
				+"</tr>";			
		}	
		//alert(htmlString);
		return htmlString;
	}
	
	$(".select-title").on("click", function() {
		$(".select-list").hide();
		$(this).siblings($(".select-list")).show();
		return false;
	})
	$(".select-list").on(
			"click",
			"li",
			function() {
				var txt = $(this).text();
				$(this).parent($(".select-list")).siblings($(".select-title"))
						.find("span").text(txt);
				//alert($(this).text());
			})
	var pageSize = "${pageInfo.totalCount}";
	alert(pageSize);

	$('.pagination').pagination(${pageInfo.totalCount}, 
		{
			callback: function(page) {
				//alert(page);
				$.post("memberList.json", 
					{
						pageSize : ${pageInfo.pageSize},
						pageNum : page
					},
					function(result) {
						//showJsonValue(result);
					
						$("#tableBody").html(showJsonValue(result));
						//alert(JSON.stringify(result));
						return true;
					}
					);
				},
 			current_page:${pageInfo.pageNum},
 			items_per_page:${pageInfo.pageSize},
			display_msg: true,
			setPageNo: true
		}
	);

	$("tbody").find("tr:odd").css("background-color", "#eff6fa");
	
});
	showRemind('input[type=text], textarea', 'placeholder');
</script>
</html>
