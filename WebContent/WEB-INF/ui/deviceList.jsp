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
<link rel="stylesheet" href="css/base.css" />
<link rel="stylesheet" href="css/info-mgt.css" />
<link rel="stylesheet" href="css/WdatePicker.css" />
<title>移动办公自动化系统</title>
</head>

<body>
<div class="title"><h2>设备管理</h2></div>
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
    <a href="javascript:;" class="count">统计</a>
    <a href="javascript:;" class="check">审核</a>
</div>
<div class="table-box">
	<table>
    	<thead>
        	<tr>
            	<th class="num">序号</th>
                <th class="name">姓名</th>
                <th class="process">流程</th>
                <th class="node">节点</th>
                <th class="time">操作时间<span>（小时）</span></th>
                <th class="operate">操作</th>
            </tr>
        </thead>
        <tbody>
        	<tr>
            	<td class="num">1</td>
                <td class="name">admin</td>
                <td class="process">收文</td>
                <td class="node">登记</td>
                <td class="time">未完成</td>
                <td class="operate"><a href="javascript:;">查看</a></td>
            </tr>
            <tr>
            	<td class="num">1</td>
                <td class="name">admin</td>
                <td class="process">收文</td>
                <td class="node">登记</td>
                <td class="time">未完成</td>
                <td class="operate"><a href="javascript:;">查看</a></td>
            </tr>
            <tr>
            	<td class="num">1</td>
                <td class="name">admin</td>
                <td class="process">收文</td>
                <td class="node">登记</td>
                <td class="time">未完成</td>
                <td class="operate"><a href="javascript:;">查看</a></td>
            </tr>
            <tr>
            	<td class="num">1</td>
                <td class="name">admin</td>
                <td class="process">收文</td>
                <td class="node">登记</td>
                <td class="time">未完成</td>
                <td class="operate"><a href="javascript:;">查看</a></td>
            </tr>
            <tr>
            	<td class="num">1</td>
                <td class="name">admin</td>
                <td class="process">收文</td>
                <td class="node">登记</td>
                <td class="time">未完成</td>
                <td class="operate"><a href="javascript:;">查看</a></td>
            </tr>
            <tr>
            	<td class="num">1</td>
                <td class="name">admin</td>
                <td class="process">收文</td>
                <td class="node">登记</td>
                <td class="time">未完成</td>
                <td class="operate"><a href="javascript:;">查看</a></td>
            </tr>
            <tr>
            	<td class="num">1</td>
                <td class="name">admin</td>
                <td class="process">收文</td>
                <td class="node">登记</td>
                <td class="time">未完成</td>
                <td class="operate"><a href="javascript:;">查看</a></td>
            </tr>
            <tr>
            	<td class="num">1</td>
                <td class="name">admin</td>
                <td class="process">收文</td>
                <td class="node">登记</td>
                <td class="time">未完成</td>
                <td class="operate"><a href="javascript:;">查看</a></td>
            </tr>
            <tr>
            	<td class="num">1</td>
                <td class="name">admin</td>
                <td class="process">收文</td>
                <td class="node">登记</td>
                <td class="time">未完成</td>
                <td class="operate"><a href="javascript:;">查看</a></td>
            </tr>
			<tr>
            	<td >1</td>
                <td >admin</td>
                <td >收文</td>
                <td >登记</td>
                <td >未完成</td>
                <td ><a href="javascript:;">查看</a></td>
            </tr>
			<tr>
            	<td >1</td>
                <td >admin</td>
                <td >收文</td>
                <td >登记</td>
                <td >未完成</td>
                <td ><a href="javascript:;">查看</a></td>
            </tr>
			<tr>
            	<td >1</td>
                <td >admin</td>
                <td >收文</td>
                <td >登记</td>
                <td >未完成</td>
                <td ><a href="javascript:;">查看</a></td>
            </tr>
			<tr>
            	<td >1</td>
                <td >admin</td>
                <td >收文</td>
                <td >登记</td>
                <td >未完成</td>
                <td ><a href="javascript:;">查看</a></td>
            </tr>
			<tr>
            	<td >1</td>
                <td >admin</td>
                <td >收文</td>
                <td >登记</td>
                <td >未完成</td>
                <td ><a href="javascript:;">查看</a></td>
            </tr>
			<tr>
            	<td >1</td>
                <td >admin</td>
                <td >收文</td>
                <td >登记</td>
                <td >未完成</td>
                <td ><a href="javascript:;">查看</a></td>
            </tr>
			<tr>
            	<td >1</td>
                <td >admin</td>
                <td >收文</td>
                <td >登记</td>
                <td >未完成</td>
                <td ><a href="javascript:;">查看</a></td>
            </tr>


        </tbody>
    </table>
</div>
<div class="pagination ue-clear"></div>
</body>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/WdatePicker.js"></script>
<script type="text/javascript" src="js/jquery.pagination.js"></script>
<script type="text/javascript">
$(".select-title").on("click",function(){
	$(".select-list").hide();
	$(this).siblings($(".select-list")).show();
	return false;
})
$(".select-list").on("click","li",function(){
	var txt = $(this).text();
	$(this).parent($(".select-list")).siblings($(".select-title")).find("span").text(txt);
})

$('.pagination').pagination(100,{
	callback: function(page){
		alert(page);	
	},
	display_msg: true,
	setPageNo: true
});

$("tbody").find("tr:odd").css("backgroundColor","#eff6fa");

showRemind('input[type=text], textarea','placeholder');
</script>
</html>
