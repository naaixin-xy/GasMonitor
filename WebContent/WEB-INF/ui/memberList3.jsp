<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<!-- <link rel="stylesheet" type="text/css" href="ui/js/lib/bootstrap-3.3.7-dist/css/bootstrap.min.css"> -->

<title>移动办公自动化系统</title>
</head>

<body>
	<div class="title">
		<h2>用户管理</h2>
	</div>
	<div id="query-div" class="query">
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
			<div class="query" style="height: 100%; overflow: auto">
				<ul id="tree-div" class="ztree"></ul>
			</div>
		</div>
		<c:if test=""></c:if>
		<div style="margin-left: 15%; width: 85%" id="right-div">
			<div id="right-div-up">
				<div class="table-operate ue-clear">
					<a href="javascript:;" class="add">添加</a> 
					<a href="javascript:;" class="del">删除</a> 
					<a href="javascript:;" class="edit">编辑</a> 
					<a href="javascript:;" class="count">全选选择</a> 
					<a href="javascript:;" class="check">审核</a>
					<a id="test" οnclick="clickDownload(this)" download="downlaod.csv" href=" ">download</a> 
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
								<th class="w80">${pageInfo.headerInfo.name}</th>
								<th class="w80">${pageInfo.headerInfo.parentId}</th>
								<th class="w100">${pageInfo.headerInfo.phone}</th>
								<th class="w80">${pageInfo.headerInfo.deviceCount}</th>
								<th class="w80">${pageInfo.headerInfo.contact}</th>
<%-- 								<th class="w120">${pageInfo.headerInfo.createTime}</th> --%>
								<th class="w120">${pageInfo.headerInfo.modifyTime}</th>
								<th class="w100">操作</th>
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
									<td class="w80">
									<c:if test="${itema.category==0}">
										用戶
									</c:if>
									<c:if test="${itema.category==1}">
										代理商
									</c:if>
										
									</td>
									<td class="w80">${itema.name}</td>
									<td class="w80">${itema.parentId}</td>
									<td class="w100">${itema.phone}</td>
									<td class="w80">${itema.deviceCount}</td>
									<td class="w80">${itema.contact}</td>
									<%-- 									<td>${itema.createTime}</td> --%>
<%-- 									<td class="w120"><fmt:formatDate value="${itema.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td> --%>
									<td class="w120"><fmt:formatDate value="${itema.modifyTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
<%-- 									<td class="w200">${itema.modifyTime}</td> --%>
									<td><a>查看详情</a></td>
									<%-- 									<td>${itema.remark}</td> --%>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<div style="height: 10px" ></div>
			<div class="pagination ue-clear" style="width:100%"></div>
		</div>
	</div>

</body>
<!-- <script type="text/javascript" src="js/jquery.js"></script> -->
<!-- /GpsLocation/WebContent/WEB-INF/ui/js/lib/bootstrap-3.3.7-dist/js/bootstrap.min.js -->
<script type="text/javascript" src="ui/js/lib/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="ui/js/jquery.min.js"></script>
<script type="text/javascript" src="ui/js/lib/layer-v3.1.1/layer/layer.js"></script>
<script type="text/javascript" src="ui/js/lib/icheck/jquery.icheck.min.js"></script>
<script type="text/javascript" src="ui/js/lib/zTree/v3/js/jquery.ztree.all-3.5.js"></script>

<script type="text/javascript" src="ui/js/index.js"></script>
<script type="text/javascript" src="ui/js/common.js"></script>
<script type="text/javascript" src="ui/js/WdatePicker.js"></script>
<script type="text/javascript" src="ui/js/jquery.pagination.js"></script>

<script type="text/javascript">
	$(function() {
		//layer_show(title,url,w,h);	
		$(".confirm").click(function() {
			alert("confirm button clicked!")
		});

		//$("#left-div").css("height", $("#right-div-up").css("height"))
		//$("#left-div").css("height", parent.$(".sidebar").css("height"));
		//alert(parent.$(".sidebar").height()-$("#query-div").height());
		//alert(parent.$(".sidebar").height());
		//alert($("#query-div").css("height"));
		//var px = $('#sampleDiv').css('marginLeft');  // px = '400px'
		//var num= parseInt( $('#right-div').css('margin-left')); 
		//alert($('#right-div').css('margin-left'));
		$("#left-div").height(
				function() {
					if ($("#right-div").height() > (parent.$(".sidebar").height()- $("#query-div").height() - 130)) {
						//alert("up");
						return $("#right-div").height();
						
					} else {
						//alert("bottom");
						return parent.$(".sidebar").height()- $("#query-div").height() - 130;
						
					}
				});
		$(window).resize(
				function() {
					//$("#left-div").height(parent.$(".sidebar").height()-$("#query-div").height()-130);
					$("#left-div").height(
							function() {
								if ($("#right-div").height() > (parent.$(".sidebar").height() - $("#query-div").height() - 130)) {
									return $("#right-div").height();
								} else {
									return parent.$(".sidebar").height() - $("#query-div").height() - 130;
								}
							});
					// 		 parseInt( $('#right-div').css('margin-left'))
					// 		if($("#left-div").width()>parseInt( $('#right-div').css('margin-left'))){
					// 			//$("#left-div").width(parseInt( $('#right-div').css('margin-left')));
					// 			$('#right-div').css('margin-left',$("#left-div").width()+"px");
					// 			alert($('#right-div').css('margin-left'));
					// 			alert($("#left-div").width());
					// 			alert($("#treeDemo").width());
					// 		}else{
					// 			$("#right-div").css("margin-left", "15%");
					// 			$("#left-div").css("width", "15%");
					// 		}	
					//alert($(document).width());
					if ($("#left-div").width() < 200) {
						$("#left-div").width(200);
						$('#right-div').css('margin-left', "200px");
						$('#right-div').width($(document).width() - 200);

						//}else if($('#right-div').width()>1133){
					} else if ($(document).width() > 1333) {
						$("#right-div").css("margin-left", "15%");
						$("#left-div").css("width", "15%");
						$('#right-div').css("width", "85%");
					}
				});
		//alert(parent.$(".sidebar").css("height"));
		$(".add").on("click", function() {
			layer_show("新用户注册", "memberRegister.do", 1200, 790);
		});
		//var selectedId = new Array();
		$(".count").on("click", function() {
			//var str;
			//var selectedId = new Array();
			if ($(".count").text() == "全部选择") {
				$(".count").text("全部取消");
			} else {
				$(".count").text("全部选择");
			}
			$(".selectflag").each(function(index, element) {

				//str=str+element.value+":";
				if ($(".count").text() == "全部选择") {
					$(this).prop("checked", false);
				} else {
					$(this).prop("checked", true);
				}
			});
			//alert(selectedId);
		});

		$(".edit").on(
				"click",
				function() {
					//alert("edit!");
					var selectedId = new Array();
					$(".selectflag:checked").each(function(index, element) {
						selectedId.push(element.value);
					});
					if (selectedId.length > 1) {
						alert("每次只能选择一项进行编辑！您当前选择了[" + selectedId + "] 共"
								+ selectedId.length + "项！");
						return;
					}
					if (selectedId.length == 0) {
						alert("您当前未选择任何数据，请选择需要修改的行！");
						return;
					}
					layer_show("用户信息修改", "memberModify?id=" + selectedId[0],
							1200, 790);
				});
		//jQuery.ajaxSettings.traditional = true;	
		$(".del").on("click", function() {
			//var str;
			var selectedId = new Array();
			$(".selectflag:checked").each(function(index, element) {
				selectedId.push(element.value);
			});
			if (selectedId.length == 0) {
				alert("您当前未选择任何数据，请选择需要删除的行！");
				return;
			}
			alert(selectedId);
			$.post("memberDelete", {
				deleteIds : selectedId
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
					var zTree = $.fn.zTree.getZTreeObj("tree-div");
				}
			}
		}
		var zNodes = [];
		var t = $("#tree-div");
		$.fn.zTree.init(t, setting, zNodes);
		var zTree = $.fn.zTree.getZTreeObj("tree-div");
		zTree.expandAll(true);

		$.post("getAllMemberTreeNodes", function(result) {

			//isParent = e.data.isParent,
			zNodes = result;
			$.fn.zTree.init(t, setting, result);
			var memberTree = $.fn.zTree.getZTreeObj("tree-div");
			nodes = memberTree.getNodes();
			//alert(JSON.stringify(nodes));
			//treeNode = nodes[0];
		});
	});
	//zTree.expandAll(true);
</script>

<script type="text/javascript">
	function clickDownload(aLink)
    {
         var str = "栏位1,栏位2,栏位3\n值1,值2,值3";
         str =  encodeURIComponent(str);
         aLink.href = "data:text/csv;charset=utf-8,\ufeff"+str;
         aLink.click();
    }
	$(function() {
		//background-color:rgb(239, 246, 250);

		function showJsonValue(jasonObj) {
			var htmlString = "";
			var listSize = jasonObj.dataInfo.length;
			for (i = 0; i < listSize; i++) {
				var start;
				if (i % 2 == 0) {
					start = "<tr>";
				} else {
					start = "<tr style=\"background-color:rgb(239, 246, 250)\">";
				}
				var cateString;
				if(jasonObj.dataInfo[i].category==0){
					cateString="用戶";
				}else{
					cateString="代理商";
				}
				htmlString += "<tr>" + "<td class=\"num\">"
						+ i
						+ "</td>"
						+ "<td class=\"checkcontainer\"><input class=\"selectflag num\" type=\"checkbox\" name=\"selectflag\" value=\"" + jasonObj.dataInfo[i].id + "\"></td>"
						+ "<td class=\"w80\">" + jasonObj.dataInfo[i].id
						+ "</td>" + "<td class=\"w120\">"
						+ jasonObj.dataInfo[i].account + "</td>"
						+ "<td class=\"w100\">" + jasonObj.dataInfo[i].password
						+ "</td>" + "<td class=\"w80\">"
						+ cateString + "</td>"
						+ "<td class=\"w80\">" + jasonObj.dataInfo[i].name
						+ "</td>" + "<td class=\"w80\">"
						+ jasonObj.dataInfo[i].parentId + "</td>"
						+ "<td class=\"w100\">" + jasonObj.dataInfo[i].phone
						+ "</td>" + "<td class=\"w80\">"
						+ jasonObj.dataInfo[i].deviceCount + "</td>"
						+ "<td class=\"w80\">" + jasonObj.dataInfo[i].contact
						//+ "</td>" + "<td class=\"w120\">"
						//+ jasonObj.dataInfo[i].createTime + "</td>"						
						+ "</td>" + "<td class=\"w120\">"
						+ jasonObj.dataInfo[i].modifyTime + "</td>"
						+ "<td ><a>查看详情</a></td>" + "</tr>";
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
					$(this).parent($(".select-list")).siblings(
							$(".select-title")).find("span").text(txt);
					//alert($(this).text());
				})
		var pageSize = parseInt("${pageInfo.pageSize}");
		//alert(pageSize);
		var totalCount = parseInt("${pageInfo.totalCount}");
		var pageNum = parseInt("${pageInfo.pageNum}");

		$('.pagination').pagination(totalCount, {
			callback : function(page) {
				//alert(page);
				$.post("memberList.json", {
					pageSize : pageSize,
					pageNum : page
				}, function(result) {
					//showJsonValue(result);

					$("#tableBody").html(showJsonValue(result));
					//alert(JSON.stringify(result));
					//return true;
				});
				return true;
			},
			current_page : pageNum,
			items_per_page : pageSize,
			display_msg : true,
			setPageNo : true,
		});

		$("tbody").find("tr:odd").css("background-color", "#eff6fa");

	});
	showRemind('input[type=text], textarea', 'placeholder');
</script>
</html>
