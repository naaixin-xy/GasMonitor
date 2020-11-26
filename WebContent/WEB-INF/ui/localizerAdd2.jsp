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
<link rel="stylesheet" href="ui/css/localizerAdd.css" />
<title>1</title>
</head>
<!-- ID -->
<!-- 设备名 -->
<!-- 设备电话 -->
<!-- 车牌号 -->
<!-- 速度限制 -->
<!-- 联系电话 -->
<!-- 油耗 -->
<!-- 保养周期 -->
<!-- 上次保养里程 -->
<!-- 过滤LBS -->
<!-- 设备联系人 -->
<!-- 用户ID -->
<!-- 设备密码 -->
<!-- 设备状态 -->
<!-- 连接状态 -->
<!-- 设备图标 -->
<!-- IMEI -->
<!-- 设备类型 -->
<!-- 创建时间 -->
<!-- 激活时间 -->
<!-- 逾期时间 -->
<!-- 上次更新时间 -->
<!-- 备注 -->
<!-- Integer id; -->
<!-- 	String name; -->
<!-- 	String phone; -->
<!-- 	String plateNumber; -->
<!-- 	Integer speedLimit; -->
<!-- 	String contactPhone; -->
<!-- 	Float oilCoefficient; -->
<!-- 	Integer maintainDistancePeriod; -->
<!-- 	Integer lastMaintainKilometre; -->
<!-- 	Integer filterLbs; -->
<!-- 	String deviceContact; -->
<!-- 	Integer deviceUserId; -->
<!-- 	String devicePassword; -->
<!-- 	Integer deviceStatus; -->
<!-- 	Integer connectStatus; -->
<!-- 	Integer deviceIcon; -->
<!-- 	String deviceImei; -->
<!-- 	String deviceCategory; -->
<!-- 	Date createTime; -->
<!-- 	Date activeTime; -->
<!-- 	Date dueTime; -->
<!-- 	Date lastUpdateTime; -->
<!-- 	String deviceNote; -->

<body>
<!-- <div class="title"><h2>用户注册</h2></div> -->
<style type="text/css">
.main .long-input{ width:560px;float:left;}
.main .remark-input{ width:1500px;float:left;}
</style>
<div class="main">

    <p class="long-input ue-clear">
    	<label>设备名：</label>
        <input type="text" id="name" placeholder="设备名" />
    </p>
    <p class="long-input ue-clear">
    	<label>设备电话：</label>
        <input type="text" id="phone"  placeholder="设备电话" />
    </p>
    <p class="long-input ue-clear">
    	<label>车牌号：</label>
        <input type="text" id="plateNumber" placeholder="车牌号" />
    </p>  
    <p class="long-input ue-clear">
    	<label>速度限制：</label>
        <input type="text" id="speedLimit" placeholder="速度限制" />
    </p>
    <p class="long-input ue-clear">
    	<label>联系电话：</label>
        <input type="text" id="contactPhone" placeholder="联系电话"/>
    </p>
    <p class="long-input ue-clear">
    	<label>油耗：</label>
        <input type="text" id="oilCoefficient" placeholder="油耗" />
    </p>
    
     <p class="long-input ue-clear">
    	<label>保养周期：</label>
        <input type="text" id="maintainDistancePeriod" placeholder="保养周期" />
    </p>   
     <p class="long-input ue-clear">
    	<label>上次保养：</label>
        <input type="text" id="lastMaintainKilometre" placeholder="上次保养" />
    </p>   
     <p class="long-input ue-clear">
    	<label>过滤LBS：</label>
        <input type="checkbox" id="filterLbs">过滤LBS</input>
    </p>
    
     
    <p class="long-input ue-clear">
    	<label>设备联系人：</label>
        <input type="text" id="deviceContact"  placeholder="设备联系人" />
    </p>
    <p class="long-input ue-clear">
    	<label>用户ID：</label>
        <input type="text" id="deviceUserId" value="${loginUser.id}" />
    </p>
  
    <p class="long-input ue-clear">
    	<label>设备密码：</label>
        <input type="password" id="devicePassword" placeholder="设备密码" />
    </p>
    <p class="long-input ue-clear">
    	<label>确认密码：</label>
        <input type="password" id="devicePassword2"  placeholder="确认密码" />
    </p>
<!--     <p class="long-input ue-clear"> -->
<!--     	<label>设备状态 ：</label> -->
<!--         <input type="text" id="deviceStatus" placeholder="设备状态" /> -->
<!--     </p> -->
     <div class="long-input select ue-clear">
    	<label>设备状态：</label>
        <div class="select-wrap">
        	<div class="select-title ue-clear"><span id="deviceStatus">0-未售</span><i class="icon"></i></div>
            <ul class="select-list">
            	<li>0-未售</li>
                <li>1-已售</li>
                <li>2-激活</li>
                <li>3-欠费</li>
            </ul>
        </div>
    </div>    
<!--      <p class="long-input ue-clear"> -->
<!--     	<label>连接状态：</label> -->
<!--         <input type="text" id="connectStatus" placeholder="连接状态" /> -->
<!--     </p>      -->


     <div class="long-input select ue-clear">
    	<label>连接状态：</label>
        <div class="select-wrap">
        	<div class="select-title ue-clear"><span id="connectStatus">1-离线</span><i class="icon"></i></div>
            <ul class="select-list">
            	<li>0-在线</li>
                <li>1-离线</li>
            </ul>
        </div>
    </div>  
    
    <p class="long-input ue-clear"> 
    	<label>IMEI：</label>
        <input type="text" id="deviceImei" placeholder="IMEI" />
    </p>
<!--     <p class="long-input ue-clear"> -->
<!--     	<label>设备类型 ：</label> -->
<!--         <input type="text" id="deviceCategory"  placeholder="设备类型" /> -->
<!--     </p> -->
    
    
     <div class="long-input select ue-clear">
    	<label>设备类型：</label>
        <div class="select-wrap">
        	<div class="select-title ue-clear"><span id="deviceCategory">10-</span><i class="icon"></i></div>
            <ul class="select-list">
             	<li>0-</li>           
            	<li>1-</li>
                <li>2-</li>
            	<li>3-</li>
                <li>4-</li>
                <li>5-</li>
                <li>6-</li>
                <li>7-</li>
                <li>8-</li>
                <li>9-</li>
                <li>10-</li>
                
            </ul>
        </div>
    </div>  
        
    <p class="icon-input ue-clear">
	      <label>设备图标 ：</label>
	      <input type="radio" value="0" id="equipicon" name="deviceIcon" ><img src="ui/oimgs/deviceicon/deviceicon1.gif" /></input>
	      <input type="radio" value="2" id="equipicon" name="deviceIcon" ><img src="ui/oimgs/deviceicon/deviceicon2.png"/></input>
	      <input type="radio" value="3" id="equipicon" name="deviceIcon" ><img src="ui/oimgs/deviceicon/deviceicon3.png"/></input>
	      <input type="radio" value="4" id="equipicon" name="deviceIcon" ><img src="ui/oimgs/deviceicon/deviceicon4.png"/></input>
	      <input type="radio" value="5" id="equipicon" name="deviceIcon" ><img src="ui/oimgs/deviceicon/deviceicon5.png"/></input>
	      <input type="radio" value="6" id="equipicon" name="deviceIcon" ><img src="ui/oimgs/deviceicon/deviceicon6.png"/></input>
	      <input type="radio" value="7" id="equipicon" name="deviceIcon" ><img src="ui/oimgs/deviceicon/deviceicon7.gif"/></input>
	      <input type="radio" value="8" id="equipicon" name="deviceIcon" ><img src="ui/oimgs/deviceicon/deviceicon8.gif"/></input>
	      <input type="radio" value="9" id="equipicon" name="deviceIcon" ><img src="ui/oimgs/deviceicon/deviceicon9.png"/></input>
	      <input type="radio" value="10" id="equipicon" name="deviceIcon" ><img src="ui/oimgs/deviceicon/deviceicon10.png"/></input>
    </p>       
    <p class="remark-input ue-clear">
    	<label>备注：</label>
        <textarea placeholder="请输入内容" id="deviceNote"></textarea>
    </p>  
<div class="main" style="height:5px;clear:both;magin:0;padding:0"></div> 
</div>

<div class="btn ue-clear">
	<a href="javascript:;" class="confirm">确定</a>
    <a href="javascript:;" class="clear">清空内容</a>
</div>
</body>
<script type="text/javascript" src="ui/js/jquery.min.js"></script>
<!-- <script type="text/javascript" src="ui/js/jquery.js"></script> -->
<script type="text/javascript" src="ui/js/common.js"></script>
<script type="text/javascript" src="ui/js/WdatePicker.js"></script>
<script type="text/javascript">
$(function (){
	
	$("#filterLbs").on("click",function(){
		alert($(this).attr("checked"));
	});
	$("input[name='deviceIcon']").on("click",function(){
		alert($(this).val());
	});

	
	$("#devicePassword").on("blur",function(){
		 $("#passwordInsertAfter").remove();
		 $("#password2InsertAfter").remove();
		if(($("#devicePassword").val()!=$("#devicePassword2").val())&&($("#devicePassword2").val()!="")){

			 $("#devicePassword").after("<span id='passwordInsertAfter' style='color:red'>两次密码输入不一致，请重新输入</span>");		
		}
	})
	$("#devicePassword2").on("blur",function(){
		 $("#password2InsertAfter").remove();
		 $("#passwordInsertAfter").remove();
		if(($("#devicePassword").val()!=$("#devicePassword2").val())&&($("#devicePassword").val()!="")){
			 $("#devicePassword2").after("<span id='password2InsertAfter' style='color:red'>两次输入密码不一致，请重新输入</span>");		
		}
	})	
	$(".confirm").on("click",function(){
		var checkResult=true;
		//alert("confirm key click!");
		
		
		if(!(/^(\w|[\u4e00-\u9fa5-]){4,10}$/.test($("#name").val()))){
// 			 $("#accountInsertAfter").remove();
// 			 $("#account").after("<span id='accountInsertAfter' style='color:red'>账户名只能是字母数字下划线的组合！且长度大于3小于20！</span>");	
// 			 checkResult=false;
			alert("设备名不能为空，只能是8-12位字母汉字数字或者下划线!");
		}else{
			alert(true);
		}
		return;
	
		if(!(/^\S{6,20}$/.test($("#devicePassword").val()))){
			 //$("#password").val().trim();
			 $("#passwordInsertAfter").remove();
			 $("#devicePassword").after("<span id='passwordInsertAfter' style='color:red'>密码长度大于等于6小于20</span>");	
			 checkResult=false;						
		}					
		var postParameter={
				name:$("#name").val(),
				phone:$("#phone").val(),
				plateNumber:$("#plateNumber").val(),
				speedLimit:$("#speedLimit").val(),
				contactPhone:$("#contactPhone").val(),
				oilCoefficient:$("#oilCoefficient").val(),
				maintainDistancePeriod:$("#maintainDistancePeriod").val(),
				lastMaintainKilometre:$("#lastMaintainKilometre").val(),			
				filterLbs:function(){if($("#filterLbs").attr("checked")=="checked"){return 1}else{return 0}},
				deviceContact:$("#deviceContact").val(),
				deviceUserId:$("#deviceUserId").val(),
				devicePassword:$("#devicePassword").val(),
				deviceStatus:$("#deviceStatus").text().substring(0,1),
				connectStatus:$("#connectStatus").text().substring(0,1),
				deviceIcon:$("#deviceIcon").val(),
				deviceImei:$("#deviceImei").val(),
				deviceCategory:$("#deviceCategory").text().substring(0,$("#deviceCategory").text().search("-")),
				deviceNote:$("#deviceNote").val(),
			};
		//postParameter.account();
		alert(JSON.stringify(postParameter));
		
		$.post("localizerAdd.do",
			postParameter,
			function(result){
		        
				var index = parent.layer.getFrameIndex(window.name);
				//parent.$('.btn-refresh').click();
				if(result.result=="success"){
					alert("新用户注册成功！");
					//parent.location.reload(); 
					parent.layer.close(index);	
				}else{
					alert("新用户注册失败！");
				}
	    	}
		);				
	})		
	$(".select-title").on("click",function(){
		$(".select-list").hide();
		$(this).siblings($(".select-list")).show();
		return false;
	})
	$(".select-list").on("click","li",function(){
		var txt = $(this).text();
		$(this).parent($(".select-list")).siblings($(".select-title")).find("span").text(txt);
		//alert($(this).text());
	})
})
showRemind('input[type=text], textarea','placeholder');
</script>
</html>
