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
<link rel="stylesheet" href="ui/css/info-reg.css" />
<link rel="stylesheet" type="text/css" href="ui/js/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css">
<title>1</title>
</head>

<body>
<!-- <div class="title"><h2>用户注册</h2></div> -->
<div class="main">
    <div class="short-input select ue-clear">
    	<label style="width:120px">离线报警时间：</label>
        <div class="select-wrap">
        	<div class="select-title ue-clear">
  				<c:if test="${members[0].offlineAlarmTime==0}">
  					<span id="offlineAlarmTime">10分钟</span>
  				</c:if>
  				<c:if test="${members[0].offlineAlarmTime==1}">
  					<span id="offlineAlarmTime">60分钟</span>
  				</c:if>  	
 				<c:if test="${members[0].offlineAlarmTime==2}">
  					<span id="offlineAlarmTime">1天</span>
  				</c:if>
  				<c:if test="${members[0].offlineAlarmTime==3}">
  					<span id="offlineAlarmTime">3天</span>
  				</c:if>  
  				<c:if test="${members[0].offlineAlarmTime==4}">
  					<span id="offlineAlarmTime">5天</span>
  				</c:if>      				  							
        		<i class="icon"></i></div>
            <ul class="select-list">
            	<li>10分钟</li>
                <li>60分钟</li>
                <li>1天</li>
                <li>3天</li>               
                <li>5天</li>                                
            </ul>
        </div>
    </div>    
        
</div>
<div class="main" style="height:5px;clear:both;magin:0;padding:0"></div>
<div class="btn ue-clear" style="padding-left:152px">
	<a href="javascript:;" class="confirm">确定</a>
    <a href="javascript:;" class="clear">清空内容</a>
</div>
</body>
<!-- <script type="text/javascript" src="ui/js/jquery.min.js"></script> -->
<script type="text/javascript" src="ui/js/jquery.js"></script>
<script type="text/javascript" src="ui/js/common.js"></script>
<script type="text/javascript" src="ui/js/WdatePicker.js"></script>
<!-- <script type="text/javascript" src="ui/js/lib/zTree/v3/js/jquery.ztree.all-3.5.js"></script> -->
<script type="text/javascript" src="ui/js/lib/zTree/v3/js/jquery.ztree.all.js"></script>
<script type="text/javascript">
$(function (){

	$(".confirm").on("click",function(){
		//alert($("#offlineAlarmTime").text());
		var postParameter={
				id:"${members[0].id}",
				offlineAlarmTime:function(){
					var data={"10分钟":0,"60分钟":1,"1天":2,"3天":3,"5天":4};
					return data[$("#offlineAlarmTime").text()];
				}
			};
		
		
		$.post("memberOfflineAlarmTimeSet.do",
			postParameter,
			function(result){
				//alert(JSON.stringify(postParameter));
				var index = parent.layer.getFrameIndex(window.name);
				//parent.$('.btn-refresh').click();
				if(result.result=="success"){
					alert("离线报警时间设置成功！");
					//parent.location.reload(); 
					parent.layer.close(index);	
				}else{
					alert("离线报警时间设置失败！");
				}
	    	}
		);
	});
	$(".select-title").on("click",function(){
		$(".select-list").hide();
		$(this).siblings($(".select-list")).show();
		return false;
	})
	$(".select-list").on("click","li",function(){
		var txt = $(this).text();
		$(this).parent($(".select-list")).siblings($(".select-title")).find("span").text(txt);
		$(".select-list").hide();
		//alert($(this).text());
	})
})
showRemind('input[type=text], textarea','placeholder');
</script>
</html>
