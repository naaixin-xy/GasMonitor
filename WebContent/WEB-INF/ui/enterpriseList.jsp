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
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="ui/css/base.css" />
<link rel="stylesheet" href="ui/css/localizerList.css" />
<link rel="stylesheet" href="ui/css/WdatePicker.css" />
<title>移动办公自动化系统</title>
</head>
<body>
<div class="title"><h2>企业管理</h2></div>
<div class="query">
	<div class="query-conditions ue-clear">
        <div class="conditions name ue-clear">
            <label>流程名称：</label>
            <div class="select-wrap">
                <div class="select-title ue-clear"><span>请选择</span><i class="icon"></i></div>
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
                <div class="select-title ue-clear"><span>大于或等于</span><i class="icon"></i></div>
                <ul class="select-list">
                    <li>呵呵</li>
                    <li>哈哈</li>
                    <li>嘻嘻</li>
                </ul>
            </div>
            <div class="input-box ue-clear">
                <input type="text" />
                <span>小时</span>
            </div>
        </div>
        <div class="conditions time ue-clear">
            <label>时&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;间：</label>
            <div class="time-select">
            	<input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="开始时间" />
                <i class="icon"></i>
            </div>
            <span class="line">-</span>
            <div class="time-select">
            	<input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="开始时间" />
                <i class="icon"></i>
            </div>
        </div>
        <div class="conditions staff ue-clear">
            <label>人&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;员：</label>
            <input type="text" placeholder="可以直接输入或选择" />
            <a href="javascript:;" class="staff-select">选择</a>
        </div>
    </div>
    <div class="query-btn ue-clear">
    	<a href="javascript:;" class="confirm">查询</a>
        <a href="javascript:;" class="clear">清空条件</a> 
    </div>
</div>
<div class="table-operate ue-clear">
	<a href="javascript:;" class="add">添加</a>
    <a href="javascript:;" class="del">删除</a>
    <a href="javascript:;" class="edit">编辑</a>
    <a href="javascript:;" class="count">全部选择</a>
    <a href="javascript:;" class="check active">激活</a>
</div>
<div class="table-box">
	<table>
    	<thead>
        	<tr>					
            	<th class="num">序号</th>
                <th class="checkcontainer">选择</th>
                <th class="w80">ID</th>
                <th class="w120">设备名</th>
                <th class="w100">设备电话</th>
                <th class="w80">车牌号</th>
             	<th class="w80">限速</th>
             	
<!--                 <th class="w100">联系电话</th> -->
<!--                 <th class="w80">油耗</th> -->
<!--                 <th class="w80">保养周期</th> -->
<!--                 <th class="w160">上次保养里程</th> -->
<!--                 <th class="w80">过滤LBS</th>                -->
<!--             	<th class="w80">联系人</th> -->
            	
                <th class="w120">用户ID</th>
<!--                 <th class="w100">设备密码</th> -->
<!--                 <th class="w100">设备状态</th> -->
                <th class="w100">连接状态</th>
<!--                 <th class="w80">图标</th>                 -->
             	<th class="w120">IMEI</th>
             	
<!--                 <th class="w80">类型</th> -->
<!--                 <th class="w160">创建时间</th> -->
<!--                 <th class="w160">激活时间</th> -->
                <th class="w160">逾期时间</th>
<!--                 <th class="w120">更新时间</th>                -->
            	<th class="w120">备注</th> 
            	<th class="w350">操作</th> 
            </tr>
        </thead>
        <tbody id="tableBody">           
            <tr>
					<c:set var="order" scope="session" value="${0}" />
					<c:forEach var="itema" items="${pageInfo.dataInfo}" varStatus="status">
						<c:set var="order" scope="session" value="${order+1}" />
						<tr>
							<td class="num">${order}</td>
							<td class="checkcontainer"><input class="selectflag num" type="checkbox" name="selectflag" value="${itema.id}"></td>
							<td class="w80">${itema.id}</td>
							<td class="w120">${itema.name}</td>
							<td class="w100">${itema.phone}</td>
							<td class="w80">${itema.plateNumber}</td>
							<td class="w80">${itema.speedLimit}</td>
							
							
<%-- 							<td class="w100">${itema.contactPhone}</td> --%>
<%-- 							<td class="w80">${itema.oilCoefficient}</td> --%>
<%-- 							<td class="w80">${itema.maintainDistancePeriod}</td> --%>
<%-- 							<td class="w100">${itema.lastMaintainKilometre}</td> --%>
<%-- 							<td class="w80">${itema.filterLbs}</td> --%>
<%-- 							<td class="w80">${itema.deviceContact}</td> --%>
							
							
							<td class="w120">${itema.member.name}(${itema.deviceUserId})</td>
<%-- 							<td class="w100">${itema.devicePassword}</td>							 --%>
<!-- 							<td class="w100"> -->
<%-- 								<c:choose> --%>
<%-- 									<c:when test="${itema.deviceStatus==0}">库存</c:when> --%>
<%-- 									<c:when test="${itema.deviceStatus==1}">出厂</c:when> --%>
<%-- 									<c:when test="${itema.deviceStatus==2}">已售</c:when> --%>
<%-- 									<c:when test="${itema.deviceStatus==3}">激活</c:when> --%>
<%-- 									<c:when test="${itema.deviceStatus==4}">欠费</c:when>																 --%>
<%-- 								</c:choose> --%>
<!-- 							</td> -->

							<td class="w100">
								<c:choose>
									<c:when test="${itema.connectStatus==0}">离线</c:when>
									<c:when test="${itema.connectStatus==1}">在线</c:when>
								</c:choose>							
							</td>
<%-- 							<td class="w80">${itema.deviceIcon}</td> --%>
							<td class="w120">${itema.deviceImei}</td>
							
																				
<!-- 							<td class="w80"> -->
<%-- 								<c:choose> --%>
<%-- 									<c:when test="${itema.deviceCategory==0}">私家车</c:when> --%>
<%-- 									<c:when test="${itema.deviceCategory==1}">厢货</c:when> --%>
<%-- 									<c:when test="${itema.deviceCategory==2}">客车</c:when> --%>
<%-- 									<c:when test="${itema.deviceCategory==3}">货车</c:when> --%>
<%-- 									<c:when test="${itema.deviceCategory==4}">摩托车</c:when>	 --%>
<%-- 									<c:when test="${itema.deviceCategory==5}">轮船</c:when> --%>
<%-- 									<c:when test="${itema.deviceCategory==6}">成人</c:when> --%>
<%-- 									<c:when test="${itema.deviceCategory==7}">贵重物品</c:when> --%>
<%-- 									<c:when test="${itema.deviceCategory==8}">宠物</c:when> --%>
<%-- 									<c:when test="${itema.deviceCategory==9}">孩子</c:when> --%>
<%-- 								</c:choose>																				 --%>
<!-- 							</td> -->
<%-- 						<td class="w160"><fmt:formatDate value="${itema.createTime }" pattern="yyyy-MM-dd" /></td>							 --%>
<%-- 						<td class="w160"><fmt:formatDate value="${itema.activeTime }" pattern="yyyy-MM-dd" /></td>							 --%>
							<td class="w160"><fmt:formatDate value="${itema.dueTime }" pattern="yyyy-MM-dd" /></td>							
<%-- 						<td class="w120"><fmt:formatDate value="${itema.lastUpdateTime }" pattern="yyyy-MM-dd HH:mm:ss" /></td>							 --%>
							<td class="w120">${itema.deviceNote}</td>
							<td class="w350">
								<a class="td-operate confirm showinfo">查看</a>
								<a class="td-operate confirm sale localizerSale">销售</a>
								<a class="confirm td-operate transfer">转移</a>
								<a class="confirm td-operate resetPassword">重置密码</a>
								<a class="confirm td-operate overdueTime" >到期时间</a>								
							</td>							 
						</tr>
					</c:forEach>
				</tr> 
        </tbody> 
    </table>
</div>
<div class="pagination ue-clear"></div>
</body>
<script type="text/javascript" src="ui/js/jquery.js">
{
	{
		[{text: '取消'}, {text: '确认'}]
	}
}
</script>
<script type="text/javascript" src="ui/js/common.js"></script>
<script type="text/javascript" src="ui/js/WdatePicker.js"></script>
<script type="text/javascript" src="ui/js/jquery.pagination.js"></script>
<script type="text/javascript" src="ui/js/lib/layer-v3.1.1/layer/layer.js"></script>
<script type="text/javascript">
	var tempLayer=layer;
	if(parent.window.name=="memberList"){
		tempLayer=parent.layer;
	}
	$(function() {
		
		if(parent.window.name=="memberList"){
			$(".query").hide();
			$(".title").hide();
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
				})


		//ajax用户列表处理----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
		var pageSize = parseInt("${pageInfo.pageSize}");
		//alert(pageSize);
		var totalCount = parseInt("${pageInfo.totalCount}");
		var pageNum = parseInt("${pageInfo.pageNum}");
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
				
				var deviceStatus;
				switch(jasonObj.dataInfo[i].deviceStatus){
					case 0:
						deviceStatus="库存";
						break;
					case 1:
						deviceStatus="出厂";
						break;
					case 2:
						deviceStatus="已售";
						break;
					case 3:
						deviceStatus="激活";
						break;
					case 4:
						deviceStatus="欠费";
						break;														
				}
				
				var connectStatus;
				if(jasonObj.dataInfo[i].connectStatus==1){
					connectStatus="在线";
				}else{
					connectStatus="离线";
				}

				var deviceCategory;
				switch(jasonObj.dataInfo[i].deviceCategory){
					case 0:
						deviceCategory="私家车";
						break;
					case 1:
						deviceCategory="厢货";
						break;
					case 2:
						deviceCategory="客车";
						break;
					case 3:
						deviceCategory="货车";
						break;
					case 4:
						deviceCategory="摩托车";
						break;
					case 5:
						deviceCategory="轮船";
						break;
					case 6:
						deviceCategory="成人";
						break;
					case 7:
						deviceCategory="贵重物品";
						break;
					case 8:
						deviceCategory="宠物";
						break;
					case 9:
						deviceCategory="孩子";
						break;							
				}				
				
				
					
				htmlString += "<tr>" + "<td class=\"num\">"
						+ i
						+ "</td>"
						+ "<td class=\"checkcontainer\"><input class=\"selectflag num\" type=\"checkbox\" name=\"selectflag\" value=\"" + jasonObj.dataInfo[i].id + "\"></td>"
						+ "<td class=\"w80\">"
						+ jasonObj.dataInfo[i].id
						+ "</td>"
						+ "<td class=\"w120\">"
						+ jasonObj.dataInfo[i].name
						+ "</td>"
						+ "<td class=\"w100\">"
						+ jasonObj.dataInfo[i].phone
						+ "</td>"
						+ "<td class=\"w80\">"
						+ jasonObj.dataInfo[i].plateNumber
						+ "</td>"
						+ "<td class=\"w80\">"
						+ jasonObj.dataInfo[i].speedLimit
						+ "</td>"
						+ "<td class=\"w120\">"
						+ jasonObj.dataInfo[i].member.name+"("+jasonObj.dataInfo[i].deviceUserId+")"						
						+ "</td>"
// 						+ "<td class=\"w80\">"
// 						+ deviceStatus
// 						+ "</td>"
						+ "<td class=\"w100\">"
						+ connectStatus
						+ "</td>"
// 						+ "<td class=\"w80\">"
// 						+ jasonObj.dataInfo[i].deviceIcon
// 						+ "</td>"
						+ "<td class=\"w80\">"
						+ jasonObj.dataInfo[i].deviceImei						
						+ "</td>"
// 						+ "<td class=\"w80\">"  
// 						+ deviceCategory						
// 						+ "</td>"
// 						+ "<td class=\"w160\">"  						
// 						+ jasonObj.dataInfo[i].createTime
// 						+ "</td>"
// 						+ "<td class=\"w160\">"
// 						+ jasonObj.dataInfo[i].activeTime						
// 						+ "</td>"
						+ "<td class=\"w160\">"
						+ jasonObj.dataInfo[i].dueTime
						+ "</td>"
						+ "<td class=\"w160\">"
						+ jasonObj.dataInfo[i].deviceNote					
						+ "</td><td class=\"w350\">"
						+ "<a class=\"td-operate confirm showinfo\">查看</a>"
						+ "<a class=\"td-operate confirm sale localizerSale\">销售</a>"
						+ "<a class=\"confirm td-operate transfer\">转移</a>"
						+ "<a class=\"confirm td-operate resetPassword\">重置密码</a>"
						+ "<a class=\"confirm td-operate overdueTime\">到期时间</a>"					
						+ "</td>"
						+ "</tr>";
			}
			return htmlString;
		}
		$('.pagination').pagination(totalCount, {
			callback : function(page) {
			var param={pageSize:pageSize,pageNum:page}
			if(parent.window.name=="memberList"){
				param.deviceUserId=parent.memberTree.getSelectedNodes()[0].id;
			}
			//alert(JSON.stringify(param));
				$.post("localizerList.json", param, function(result) {
					//showJsonValue(result);

					$("#tableBody").html(showJsonValue(result));
					$(".showinfo").on("click",function(){
						//alert("id");
						var id = $(this).parents("td").siblings("td").eq(1).find("input").attr("value");
						//alert(id);
						layer_show("查看设备信息","localizerInfo?id="+id,1600, 790);	
					});	
					$(".localizerSale").on("click",function(){
						//alert("id");
						var id = $(this).parents("td").siblings("td").eq(1).find("input").attr("value");
						//alert(id);
						layer_show_notmax("设备销售","localizerSale?id="+id,620, 500);	
					});
					$(".overdueTime").on("click",function(){
						//alert("id");
						var id = $(this).parents("td").siblings("td").eq(1).find("input").attr("value");
						//alert(id);
						layer_show_notmax("设备销售","localizerOverdueTimeSet?id="+id,1000, 200);	
					});		
					$(".resetPassword").on("click",function(){
						//alert("id");
						var id = $(this).parents("td").siblings("td").eq(1).find("input").attr("value");
						alert("密码重置操作将把密码更改为【123456】，请牢记新密码！");
						$.post("localizerResetPassword", {
							id : id
						}, function(result) {
							if(result.result=="success"){
								alert("密码重置成功！");
								location.reload();
							}else{
								alert("密码重置失败！");
							}
						});		
					});
					//alert(JSON.stringify(result));
					//return true;
				});
				return true;
			},
			current_page : pageNum,
			items_per_page : pageSize,
			display_msg : true,
			setPageNo : false
		});

		$("tbody").find("tr:odd").css("backgroundColor", "#eff6fa");
		
		//工具栏按钮处理函数------------------------------------------------------------------------------------------------------------------------------------------------------------//
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
			perContent=tempLayer.open({
				type: 2,
				area: [w+'px', h +'px'],
				fix: false, //不固定
				maxmin: true,
				//resize:false,
				skin: 'layui-layer-molv',
//				skin: 'layui-layer-lan',
				border:[3,1,'#000',true],  
				shade:0.4,
				title: title,
				content: url
			});
			tempLayer.full(perContent);
		}
		
		function layer_show_notmax(title,url,w,h){
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
			perContent=tempLayer.open({
				type: 2,
				area: [w+'px', h +'px'],
				fix: false, //不固定
				maxmin: true,
				//resize:false,
				skin: 'layui-layer-molv',
//				skin: 'layui-layer-lan',
				border:[3,1,'#000',true],  
				shade:0.4,
				title: title,
				content: url
			});
			//layer.full(perContent);
		}		
		
		$(".showinfo").on("click",function(){
			//alert("id");
			var id = $(this).parents("td").siblings("td").eq(1).find("input").attr("value");
			//alert(id);
			layer_show("查看设备信息","localizerInfo?id="+id,1600, 790);	
		});	
			
		$(".localizerSale").on("click",function(){
			//alert("id");
			var id = $(this).parents("td").siblings("td").eq(1).find("input").attr("value");
			//alert(id);
			layer_show_notmax("设备销售","localizerSale?id="+id,620, 500);	
		});	
		
		$(".transfer").on("click",function(){
			//alert("id");
			var id = $(this).parents("td").siblings("td").eq(1).find("input").attr("value");
			//alert(id);
			layer_show_notmax("设备销售","localizerSale?id="+id,620, 500);	
		});	
				
		
		$(".resetPassword").on("click",function(){
			//alert("id");
			var id = $(this).parents("td").siblings("td").eq(1).find("input").attr("value");
			alert("密码重置操作将把密码更改为【123456】，请牢记新密码！");
			$.post("localizerResetPassword", {
				id : id
			}, function(result) {
				if(result.result=="success"){
					alert("密码重置成功！");
					location.reload();
				}else{
					alert("密码重置失败！");
				}
			});		
		});	
		
		$(".overdueTime").on("click",function(){
			//alert("id");
			var id = $(this).parents("td").siblings("td").eq(1).find("input").attr("value");
			//alert(id);
			layer_show_notmax("增加到期时间","localizerOverdueTimeSet?id="+id,1000, 200);	
		});			
		
		
		
		$(".add").on("click",function() {
					layer_show("设备添加","localizerAdd",1600, 790);
				});

		$(".count").on("click", function() {
			if ($(".count").text() == "全部选择") {
				$(".count").text("全部取消");
			} else {
				$(".count").text("全部选择");
			}
			$(".selectflag").each(function(index, element) {
				if ($(".count").text() == "全部选择") {
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
					layer_show("设备信息修改", "localizerModify?id=" + selectedId[0],1200, 790);
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
			$.post("localizerDelete", {
				deleteIds : selectedId
			}, function(result) {
				alert(JSON.stringify(result));
				location.reload();
			});//active//check
		});
		$(".check.active").on("click", function() {
			//var str;
			var selectedId = new Array();
			$(".selectflag:checked").each(function(index, element) {
				selectedId.push(element.value);
			});
			if (selectedId.length == 0) {
				alert("您当前未选择任何数据，请选择需要激活的设备！");
				return;
			}
			if (selectedId.length > 1) {
				alert("每次只能选择一项进行编辑！您当前选择了[" + selectedId + "] 共"
						+ selectedId.length + "项！");
				return;
			}			
			alert(selectedId);
			$.post("localizerActive", {
				activeId : selectedId[0]
			}, function(result) {
				alert(JSON.stringify(result));
				location.reload();
			});	
		});
	})
	showRemind('input[type=text], textarea', 'placeholder');
</script>
</html>
