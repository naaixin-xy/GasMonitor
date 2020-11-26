<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<link rel="stylesheet" href="ui/css/home.css" />
<link rel="stylesheet" href="ui/css/info-mgt.css" />
<link rel="stylesheet" href="ui/css/WdatePicker.css" />
<link rel="stylesheet" type="text/css" href="ui/js/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css">
<link rel="stylesheet" type="text/css" href="ui/js/lib/basicContext/basicContext.min.css">
<link rel="stylesheet" type="text/css" href="ui/js/lib/basicContext/themes/default.min.css">
<link rel="stylesheet" type="text/css" href="ui/js/lib/basicContext/themes/light.min.css">
<link rel="stylesheet" type="text/css" href="ui/js/lib/basicContext/themes/dark.min.css">
<link rel="stylesheet" type="text/css" href="ui/js/lib/basicContext/themes/bright.min.css">
<link rel="stylesheet" type="text/css" href="ui/js/lib/basicContext/icon/ionicons.min.css">

<!-- <link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css"> -->
<!-- <link rel="stylesheet" type="text/css" href="ui/js/lib/bootstrap-3.3.7-dist/css/bootstrap.min.css"> -->

<title>移动办公自动化系统</title>
<style type="text/css">
/* ::-webkit-scrollbar-track-piece { //滚动条凹槽的颜色，还可以设置边框属性 */
/* background-color:#f8f8f8; */
/* } */
/* ::-webkit-scrollbar {//滚动条的宽度 */
/* width:9px; */
/* height:9px; */
/* } */
/* ::-webkit-scrollbar-thumb {//滚动条的设置 */
/* background-color:#dddddd; */
/* background-clip:padding-box; */
/* min-height:28px; */
/* } */
/* ::-webkit-scrollbar-thumb:hover { */
/* background-color:#bbb; */
/* } */
</style>
</head>
<link rel="stylesheet" type="text/css" href="ui/js/lib/basicContext/basicContext.min.css">
<link rel="stylesheet" type="text/css" href="ui/js/lib/basicContext/themes/default.min.css">
<link rel="stylesheet" type="text/css" href="ui/js/lib/basicContext/themes/light.min.css">
<link rel="stylesheet" type="text/css" href="ui/js/lib/basicContext/themes/dark.min.css">
<link rel="stylesheet" type="text/css" href="ui/js/lib/basicContext/themes/bright.min.css">
<link rel="stylesheet" type="text/css" href="ui/css/info-reg.css" />
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
				<h2>用户列表</h2>
			</div>
			<div class="query" style="height: 100%; overflow: auto">
				<ul id="tree-div" class="ztree"></ul>
			</div>
		</div>

		<div style="margin-left: 15%; width: 85%;" id="right-div">
			<div class="article matter">
				<div class="wrap-r">
			        <div class="title ue-clear" style="margin-left:0px;border-top:0px;background-color:">
			            <h2 class="title-list" style="font-size:12px">
			                <ul class="ue-clear">
			                    <li class="current"><a href="javascript:;">下级用户</a></li>
			                    <li><a href="javascript:;">设备列表</a></li>
			                     <li><a href="javascript:;">用户详情</a></li>
			                </ul>
			            </h2>
			            <a href="javascript:;" class="more">更多</a>
			        </div>
			        <div class="content" id="right-div-up" style="margin-left:0px;border:0px;padding:0px;margin:0px">
			        	<div class="matter-content current ue-clear">
							<div class="table-operate ue-clear">
								<a href="javascript:;" class="add">添加</a> 
								<a href="javascript:;" class="del">删除</a> 
								<a href="javascript:;" class="edit">编辑</a> 
								<a href="javascript:;" class="count">全部选择</a> 
								<a href="javascript:;" class="check">审核</a> 
							</div>
							<div class="table-box">
								<table>
									<thead>
										<tr>
											<th class="num">${pageInfo.headerInfo.order}</th>
											<th class="checkcontainer">${pageInfo.headerInfo.select}</th>
											<th class="w80">${pageInfo.headerInfo.id}</th>
											<th class="w120">${pageInfo.headerInfo.account}</th>
<%-- 											<th class="w100">${pageInfo.headerInfo.password}</th> --%>
											<th class="w80">${pageInfo.headerInfo.category}</th>
											<th class="w80">${pageInfo.headerInfo.name}</th>
											<th class="w80">${pageInfo.headerInfo.parentId}</th>
											<th class="w100">${pageInfo.headerInfo.phone}</th>
											<th class="w80">${pageInfo.headerInfo.deviceCount}</th>
											<th class="w80">${pageInfo.headerInfo.contact}</th>	
											<th class="w120">${pageInfo.headerInfo.modifyTime}</th>
											<th class="w100">操作</th>
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
<%-- 												<td class="w100">${itema.password}</td> --%>
												<td class="w80"><c:if test="${itema.category==0}">
													用戶
												</c:if> <c:if test="${itema.category==1}">
													代理商
												</c:if></td>
												<td class="w80">${itema.name}</td>
												<td class="w80">${itema.parentId}</td>
												<td class="w100">${itema.phone}</td>
												<td class="w80">${itema.deviceCount}</td>
												<td class="w80">${itema.contact}</td>
												<td class="w120"><fmt:formatDate value="${itema.modifyTime }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
												<td><a class="confirm" style="height:18px;width:50px">查看</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>	
							<div class="pagination ue-clear"></div>		    
			            </div>
			            <div class="matter-content ue-clear localizer-list" overflow="auto" width="100%" height="100%">
							<iframe src="localizerList.do?pageSize=19&pageNum=0&deviceUserId=${loginUser.id}" id="localizerframe" width="100%" height="100%" frameborder="0"></iframe>		    
			            </div>
		            <div class="matter-content ue-clear">
		            	<div id="userInfoDiv" class="main" style="padding:20px 300px 0px 300px;">
							<p class="short-input ue-clear newstyle">
						    	<label>会员名：</label>uimaker
						    </p>
						    <p class="short-input ue-clear newstyle">
						    	<label>姓名：</label>UI制造者
						    </p>
						    <p class="long-input ue-clear newstyle">
						    	<label>性别：</label>男
						    </p>
						    <p class="long-input ue-clear newstyle">
						    	<label>电子邮件：</label>admin@uimaker.com
						    </p>
						    <p class="long-input ue-clear newstyle">
						    	<label>移动电话：</label>13913915658
						    </p>
						    <p class="short-input ue-clear newstyle">
						    	<label>公司名称：</label>南京信息科技股份有限公司
						    </p>   
						    <p class="short-input ue-clear newstyle">
						    	<label>国家地区：</label>China
						    </p>
						    <p class="short-input ue-clear newstyle">
						    	<label>接收邮件语言：</label>英文
						    </p>
						    <p class="short-input ue-clear newstyle">2014-08-27 16:49:20
						    	<label>注册日期：</label>
						    </p>
					    </div>
						<div class="btn1 ue-clear" style="padding-left:460px;height:40px;padding-bottom:18px">
							<a href="javascript:;" class="confirm">确定</a>
						    <a href="javascript:;" class="clear">清空内容</a>
						</div>					    	            
			        </div>
			    </div>
			</div>			
		</div>
	</div>
	<div id="testshow" style="clear:both">
	
	</div>
</body>
<!-- <script type="text/javascript" src="js/jquery.js"></script> -->
<!-- /GpsLocation/WebContent/WEB-INF/ui/js/lib/bootstrap-3.3.7-dist/js/bootstrap.min.js -->
<!-- <script type="text/javascript" src="ui/js/lib/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script> -->
<script type="text/javascript" src="ui/js/jquery.min.js"></script>
<script type="text/javascript" src="ui/js/lib/layer-v3.1.1/layer/layer.js"></script>
<script type="text/javascript" src="ui/js/lib/icheck/jquery.icheck.min.js"></script>
<!-- <script type="text/javascript" src="ui/js/lib/zTree/v3/js/jquery.ztree.all-3.5.js"></script> -->
<script type="text/javascript" src="ui/js/lib/zTree/v3/js/jquery.ztree.all.js"></script>
<!-- <script type="text/javascript" src="ui/js/index.js"></script> -->
<script type="text/javascript" src="ui/js/common.js"></script>
<script type="text/javascript" src="ui/js/WdatePicker.js"></script>
<script type="text/javascript" src="ui/js/jquery.pagination.js"></script>
<script type="text/javascript" src="ui/js/lib/basicContext/basicContext.min.js"></script>

<!-- <script type="text/javascript" src="http://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script> -->

<script type="text/javascript">
	window.name="memberList"
		var parentId="${loginUser.id}"
		var pageSize = parseInt("${pageInfo.pageSize}");
		var totalCount = parseInt("${pageInfo.totalCount}");
		var pageNum = parseInt("${pageInfo.pageNum}");
		var aIndex=0;	
	//alert(window.name);
	//alert(parent.window.name);
	/*弹出层*/
	/*
		参数解释：
		title	标题
		url		请求的url
		id		需要操作的数据id
		w		弹出层宽度（缺省调默认值）
		h		弹出层高度（缺省调默认值）
	*/
	function layer_show(title,url,w,h){
		if (title == null || title == '') {
			title=false;
		};
		if (url == null || url == '') {
			url="404.html";
		};
		if (w == null || w == '') {
			w=800;
		};
		if (h == null || h == '') {
			h=($(window).height() - 50);
		};
		layer.open({
			type: 2,
			area: [w+'px', h +'px'],
			fix: false, //不固定
			maxmin: true,
			//resize:false,
			skin: 'layui-layer-molv',
			//skin: 'layui-layer-lan',
			border:[3,1,'#000',true],  
			shade:0.4,
			title: title,
			content: url
		});
	}

	var memberTree;
	$(function() {
		//layer_show(title,url,w,h	
		$(".confirm").click(function() {
			alert("confirm button clicked!")
		});
		//控件尺寸调整------------------------------------------------------------------------------------------------------------------------------//
		$("#right-div-up").height($("#right-div").height()-35);
		$(".localizer-list").height(parent.$(".sidebar").height()- $("#query-div").height() - 100);
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
					$("#right-div-up").height($("#right-div").height()-35);
					$("#left-div").height(
							function() {
								if ($("#right-div").height() > (parent.$(".sidebar").height() - $("#query-div").height() - 130)) {
									return $("#right-div").height();
								} else {
									return parent.$(".sidebar").height() - $("#query-div").height() - 130;
								}
							});
					if ($("#left-div").width() < 200) {
						$("#left-div").width(200);
						$('#right-div').css('margin-left', "200px");
						$('#right-div').width($(document).width() - 200);

					} else if ($(document).width() > 1333) {
						$("#right-div").css("margin-left", "15%");
						$("#left-div").css("width", "15%");
						$('#right-div').css("width", "85%");
					}
				});
		// 用户表格操作事件处理函数--------------------------------------------------------------------------------------------------------------------------------------------//
		//alert(parent.$(".sidebar").css("height"));
		$(".add").on("click", function() {
				var selectedId = new Array();
				$(".selectflag:checked").each(function(index, element) {
					selectedId.push(element.value);
				});
				if (selectedId.length > 1) {
					alert("只能选择一项作为父用户！您当前选择了[" + selectedId + "] 共"
							+ selectedId.length + "项！");
					return;
				}
				if (selectedId.length == 0) {
					alert("您当前未选择任何数据，请选择父用户！");
					return;
				}
			layer_show("新用户注册", "memberRegister?parentId="+selectedId[0], 1200, 790);
		});

		$(".count").on("click", function() {
			if ($(".count").text()=="全部选择") {
				$(".count").text("全部取消");
			} else {
				$(".count").text("全部选择");
			}
			$(".selectflag").each(function(index, element) {
				if ($(".count").text()=="全部选择") {
					$(this).prop("checked", false);
				} else {
					$(this).prop("checked", true);
				}
			});
		});

		$(".edit").on(
				"click",
				function() {
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
					layer_show("用户信息修改", "memberModify?id=" + selectedId[0],1200, 790);
				});
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
			}, function(result) {
				alert(JSON.stringify(result));
				location.reload();
			});	
		});
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
					var zTree = $.fn.zTree.getZTreeObj("tree-div");
				},
				beforeRightClick:function(treeId, treeNode) {
					return true;
				},
				onRightClick:function(e,treeId, treeNode) {
					//alert(treeId);
					//alert(treeNode.id);
					showMenu(e,treeNode);
				},
				onClick:function(e,treeId, treeNode) {
					parentId=memberTree.getSelectedNodes()[0].id;
					if(aIndex==0){
						showClickMemberList();						
					}else if(aIndex==1){
						window.frames[0].location = "localizerList.do?pageSize=19&pageNum=0&deviceUserId="+memberTree.getSelectedNodes()[0].id;	
					}else if(aIndex==2){
						$.post("getUserInfo", {
							id : memberTree.getSelectedNodes()[0].id
						}, function(result) {
							//showJsonValue(result);
							$("#userInfoDiv").html(showUserInfo(result[0]));
						});
						return true;							
					}

		 		}				
			}
		}

		var zNodes = [];
		var t = $("#tree-div");
		$.fn.zTree.init(t, setting, zNodes);
		memberTree = $.fn.zTree.getZTreeObj("tree-div");
		memberTree.expandAll(true);

// 		$.post("getAllMemberTreeNodes", function(result) {
// 			zNodes = result;
// 			$.fn.zTree.init(t, setting, result);
// 			var memberTree = $.fn.zTree.getZTreeObj("tree-div");
// 			nodes = memberTree.getNodes();
// 			memberTree.expandAll(true);
// 			memberTree.selectNode(zNodes[2]);
// 		});
 	});

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
//						+ "<td class=\"w100\">" + jasonObj.dataInfo[i].password + "</td>" 
					+ "<td class=\"w80\">"
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
					+ "<td ><a class=\"confirm\" style=\"height:18px;width:50px\">查看</a></td>" + "</tr>";
		}
		return htmlString;
	}		
</script>
<script type="text/javascript">
 	$(function() {
		//模拟列表框控件处理------------------------------------------------------------------------------------------------------------------------//
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
				})
		//ajax用户列表处理----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
		showPagination();
		//TAB页切换函数---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
		$(".title-list ul").on("click","li",function(){
			aIndex = $(this).index();
			//alert(aIndex);
			//alert(memberTree.getSelectedNodes()[0].id);
			$(this).addClass("current").siblings().removeClass("current");
			$(".matter-content").removeClass("current").eq(aIndex).addClass("current");
			if(aIndex==0){
				showClickMemberList();				
			}else if(aIndex==1){
				//$(".localizer-list").height($("#right-div").height()-35);	
				window.frames[0].location = "localizerList.do?pageSize=19&pageNum=0&deviceUserId="+memberTree.getSelectedNodes()[0].id;	
			}else if(aIndex==2){
				$.post("getUserInfo", {
					id : memberTree.getSelectedNodes()[0].id
				}, function(result) {
					//showJsonValue(result);
					$("#userInfoDiv").html(showUserInfo(result[0]));
				});
				return true;	
			}
		});			
	}); 
	//上下文菜单分类处理函数---------------------------------------------------------------------------------------------------------------------------//
	function showClickMemberList(){
		$.post("memberList.json", {
			parentId:parentId,
			pageSize : 20,
			pageNum :0
		}, function(result) {
			//showJsonValue(result);
			pageSize = result.pageSize;
			totalCount = result.totalCount;
			pageNum =  result.pageNum;	

			$("#tableBody").html(showJsonValue(result));
			//alert(totalCount);
			if(result.dataInfo.length>0){
				showPagination();
			}
		});	
		
	}
	function showPagination(){
		$('.pagination').pagination(totalCount, {
			callback : function(page) {
				//alert(page);
				$.post("memberList.json", {
					parentId:parentId,
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
			setPageNo : false,
		});				
	}
	function showUserInfo(result){
		
		var pHeadInfo = "<p class=\"short-input ue-clear newstyle\" style=\"margin-top:8px\"><label>";
		var usertype;
		if(result.category==0){usertype="用户"}else{usertype="代理商"}
		var htmlString = pHeadInfo + "用户ID：</label>" + result.id
						+pHeadInfo + "账户名：</label>" + result.account
						+pHeadInfo + "密码：</label>" + result.password
						+pHeadInfo + "用户类别：</label>" + usertype
						+pHeadInfo + "姓名：</label>" +  result.name
						+pHeadInfo + "父用户ID：</label>" +  result.parentId
						+pHeadInfo + "电话：</label>" +  result.phone
						+pHeadInfo + "设备数量：</label>" +  result.deviceCount					
						+pHeadInfo + "联系人：</label>" +  result.contact
						+pHeadInfo + "库存：</label>" +  result.stock
						+pHeadInfo + "总进货量：</label>" +  result.purchaseQuantity
						+pHeadInfo + "离线报警时间：</label>" +  result.offlineAlarmTime
						+pHeadInfo + "创建时间：</label>" +  result.createTime	
						+pHeadInfo + "修改时间：</label>" +  result.modifyTime
						+pHeadInfo + "备注：</label>" +  result.remark;
		return htmlString;
	}
	function showMenu(e,treeNode) {    
		var userAdd = function() {layer_show("新用户注册", "memberRegister?parentId=" + treeNode.id, 1200, 790);}
		//var userAdd = function() {}
		var userModify = function() {layer_show("用户信息修改", "memberModify?id=" + treeNode.id,1200, 790);}
		//var userDel = function() {}
		var userDel = function(){
			if(treeNode.isParent){
				alert("当前用户包含子用户，无法进行删除！");
				return;
			}
			var selectedId = new Array();
			selectedId.push(treeNode.id);
			$.post("memberDelete", {
				deleteIds : selectedId
				}, function(result) {
					alert(JSON.stringify(result));
					location.reload();
				});	
			};

		var resetPassoword = function(){
			alert("本操作将会把密码重置为【123456】,请牢记密码！");
			if(treeNode.password=="123456"){
				alert("操作成功！");
				return;
			}
			$.post("resetPassoword", {
					id : treeNode.id,
					password:treeNode.password
				}, function(result) {
					//alert(JSON.stringify(result));
					if(result.executeResult=="success"){
						alert("密码重置成功");
					}else{
						alert("密码重置失败");	
					}
					location.reload();
				});	
			};
		var userTransfer = function() {layer_show("用户转移", "memberTransfer?id=" + treeNode.id,620, 380);}
		var userOfflineAlarmTimeSet = function() {layer_show("离线报警时间设置", "memberOfflineAlarmTimeSet?id=" + treeNode.id,600, 300);}
		//var clicked=function(){alert(1)};
		
		//var clicked2=function(){alert(2)};		  
		var items = [
			{ title: '新增客户', icon: 'ion-plus-round', fn: userAdd},      
			{ title: '管理客户', icon: 'ion-person', fn: userModify},  
			{},    
			{ title: '删除客户', icon: 'ion-help-buoy', fn: userDel},      
			//{ title: '重置密码', icon: 'ion-minus-circled', fn: clicked, disabled: true }, 
			{ title: '重置密码', icon: 'ion-minus-circled', fn: resetPassoword},      
			//{ title: 'Invisible', icon: 'ion-eye-disabled', fn: clicked, visible: false },   
			{ title: '客户转移', icon: 'ion-log-out', fn: userTransfer },   
			{}, 
			{ title: '离线设置', icon: 'ion-log-out', fn: userOfflineAlarmTimeSet }    
		]    
		basicContext.show(items, e.originalEvent)
	}	
	
	showRemind('input[type=text], textarea', 'placeholder');
</script>
</html>
