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
<link rel="stylesheet" type="text/css" href="ui/js/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css">
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
	.main .long-input{ width:800px;float:left;}
	.main .remark-input{ width:1300px;float:left;}
	.error-tips{color:red;position:relative;margin-left:5px;}
</style>
<div class="main">

    <p class="long-input ue-clear">
    	<label>设备名：</label>
        <input type="text" id="name" value="${localizer.name}" placeholder="不能为空，且只能是4-10位字母汉字数字或者下划线" />
    </p>
    <p class="long-input ue-clear">
    	<label>设备电话：</label>
        <input type="text" id="phone" value="${localizer.phone}" placeholder="不能为空，且只能是5-20位数字" />
    </p>
    <p class="long-input ue-clear">
    	<label>车牌号：</label>
        <input type="text" id="plateNumber" value="${localizer.plateNumber}" placeholder="示例车牌：京A88888" />
    </p>  
    <p class="long-input ue-clear">
    	<label>速度限制：</label>
        <input type="text" id="speedLimit" value="${localizer.speedLimit}" placeholder="三位以内数字，单位公里" />
    </p>
    <p class="long-input ue-clear">
    	<label>联系电话：</label>
        <input type="text" id="contactPhone" value="${localizer.contactPhone}" placeholder="不能为空，且只能是5-20位数字"/>
    </p>
    <p class="long-input ue-clear">
    	<label>油耗：</label>
        <input type="text" id="oilCoefficient" value="${localizer.oilCoefficient}" placeholder="1000以内整数或者小数" />
    </p>
    
     <p class="long-input ue-clear">
    	<label>保养周期：</label>
        <input type="text" id="maintainDistancePeriod" value="${localizer.maintainDistancePeriod}" placeholder="6位以内整数" />
    </p>   
     <p class="long-input ue-clear">
    	<label>上次保养：</label>
        <input type="text" id="lastMaintainKilometre" value="${localizer.lastMaintainKilometre}" placeholder="8位以内整数" />
    </p>   
     <p class="long-input ue-clear">
    	<label>过滤LBS：</label>
<!--         <input type="checkbox" id="filterLbs" >过滤LBS</input> -->
        
       <input type="checkbox" id="filterLbs" <c:if test="${localizer.filterLbs==1}">checked</c:if> >过滤LBS</input>
         
    </p>
    
     
    <p class="long-input ue-clear">
    	<label>设备联系人：</label>
        <input type="text" id="deviceContact" value="${localizer.deviceContact}"  placeholder="不能为空，且只能是2-10位字母汉字数字或者下划线" />
    </p>
    <p class="long-input ue-clear">
    	<label>用户ID：</label>
        <input type="text" id="deviceUserId" value="${localizer.deviceUserId}" />
    </p>
  
    <p class="long-input ue-clear">
    	<label>设备密码：</label>
        <input type="password" id="devicePassword" value="${localizer.devicePassword}" placeholder="设备密码" />
    </p>
    <p class="long-input ue-clear">
    	<label>确认密码：</label>
        <input type="password" id="devicePassword2" value="${localizer.devicePassword}"  placeholder="确认密码" />
    </p>
<!--     <p class="long-input ue-clear"> -->
<!--     	<label>设备状态 ：</label> -->
<!--         <input type="text" id="deviceStatus" placeholder="设备状态" /> -->
<!--     </p> -->
     <div class="long-input select ue-clear">
    	<label>设备状态：</label>
        <div class="select-wrap">
        	<div class="select-title ue-clear">
        		
								<c:choose>
									<c:when test="${localizer.deviceStatus==0}"><span id="deviceStatus">0-库存</span></c:when>
									<c:when test="${localizer.deviceStatus==1}"><span id="deviceStatus">1-出厂</span></c:when>
									<c:when test="${localizer.deviceStatus==2}"><span id="deviceStatus">2-已售</span></c:when>
									<c:when test="${localizer.deviceStatus==3}"><span id="deviceStatus">3-激活</span></c:when>
									<c:when test="${localizer.deviceStatus==4}"><span id="deviceStatus">4-欠费</span></c:when>																
								</c:choose>        		
				<i class="icon"></i>
			</div>
            <ul class="select-list">
            	<li>0-库存</li>
            	<li>1-出厂</li>
                <li>2-已售</li>
                <li>3-激活</li>
                <li>4-欠费</li>
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
        	<div class="select-title ue-clear">
        		<span id="connectStatus"><c:choose><c:when test="${localizer.connectStatus==0}">0-离线</c:when><c:when test="${localizer.connectStatus==1}">1-在线</c:when></c:choose></span><i class="icon"></i>
			</div>
            <ul class="select-list">
            	<li>0-离线</li>
                <li>1-在线</li>
            </ul>
        </div>
    </div>  
    
    <p class="long-input ue-clear"> 
    	<label>IMEI：</label>
        <input type="text" id="deviceImei" value="${localizer.deviceImei}" placeholder="模块IMEI" />
    </p>
<!--     <p class="long-input ue-clear"> -->
<!--     	<label>设备类型 ：</label> -->
<!--         <input type="text" id="deviceCategory"  placeholder="设备类型" /> -->
<!--     </p> -->
    
    
     <div class="long-input select ue-clear">
    	<label>设备类型：</label>
        <div class="select-wrap">
        	<div class="select-title ue-clear">
								<c:choose>
									<c:when test="${localizer.deviceCategory==0}"><span id="deviceCategory">0-私家车</span></c:when>
									<c:when test="${localizer.deviceCategory==1}"><span id="deviceCategory">1-厢货</span></c:when>
									<c:when test="${localizer.deviceCategory==2}"><span id="deviceCategory">2-客车</span></c:when>
									<c:when test="${localizer.deviceCategory==3}"><span id="deviceCategory">3-货车</span></c:when>
									<c:when test="${localizer.deviceCategory==4}"><span id="deviceCategory">4-摩托车</span></c:when>	
									<c:when test="${localizer.deviceCategory==5}"><span id="deviceCategory">5-轮船</span></c:when>
									<c:when test="${localizer.deviceCategory==6}"><span id="deviceCategory">6-成人</span></c:when>
									<c:when test="${localizer.deviceCategory==7}"><span id="deviceCategory">7-贵重物品</span></c:when>
									<c:when test="${localizer.deviceCategory==8}"><span id="deviceCategory">8-宠物</span></c:when>
									<c:when test="${localizer.deviceCategory==9}"><span id="deviceCategory">9-孩子</span></c:when>
								</c:choose>	
				<i class="icon"></i>
			</div>
            <ul class="select-list">
             	<li>0-私家货</li>           
            	<li>1-厢货</li>
                <li>2-客车</li>
            	<li>3-货车</li>
                <li>4-摩托车</li>
                <li>5-轮船</li>
                <li>6-成人</li>
                <li>7-贵重物品</li>
                <li>8-宠物</li>
                <li>9-孩子</li>
            </ul>
        </div>
    </div>  
        
    <p class="icon-input ue-clear">
	      <label>设备图标 ：</label>
	      <input type="radio" value="0" id="equipicon" name="deviceIcon"><img src="ui/oimgs/deviceicon/deviceicon1.gif" /></input>
	      <input type="radio" value="1" id="equipicon" name="deviceIcon" ><img src="ui/oimgs/deviceicon/deviceicon2.png"/></input>
	      <input type="radio" value="2" id="equipicon" name="deviceIcon" ><img src="ui/oimgs/deviceicon/deviceicon3.png"/></input>
	      <input type="radio" value="3" id="equipicon" name="deviceIcon" ><img src="ui/oimgs/deviceicon/deviceicon4.png"/></input>
	      <input type="radio" value="4" id="equipicon" name="deviceIcon" ><img src="ui/oimgs/deviceicon/deviceicon5.png"/></input>
	      <input type="radio" value="5" id="equipicon" name="deviceIcon" ><img src="ui/oimgs/deviceicon/deviceicon6.png"/></input>
	      <input type="radio" value="6" id="equipicon" name="deviceIcon" ><img src="ui/oimgs/deviceicon/deviceicon7.gif"/></input>
	      <input type="radio" value="7" id="equipicon" name="deviceIcon" ><img src="ui/oimgs/deviceicon/deviceicon8.gif"/></input>
	      <input type="radio" value="8" id="equipicon" name="deviceIcon" ><img src="ui/oimgs/deviceicon/deviceicon9.png"/></input>
	      <input type="radio" value="9" id="equipicon" name="deviceIcon" ><img src="ui/oimgs/deviceicon/deviceicon10.png"/></input>
    </p>       
    <p class="remark-input ue-clear">
    	<label>备注：</label>
        <textarea placeholder="请输入内容" id="deviceNote">${localizer.deviceNote}</textarea>
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
<script type="text/javascript" src="ui/js/lib/zTree/v3/js/jquery.ztree.all-3.5.js"></script>
<script type="text/javascript">
$(function (){
	
	$("#filterLbs").on("click",function(){
		alert($(this).attr("checked"));
	});
	$("input[name='deviceIcon']").on("click",function(){
		alert($(this).val());
	});

	$(".icon-input input[value='${localizer.deviceIcon}']").attr("checked",true);
	
	$("#cb1").prop("checked",true); //标准写法，推荐！
	
	$("#devicePassword").on("blur",function(){
		 $("#passwordInsertAfter").remove();
		 $("#password2InsertAfter").remove();
		if(($("#devicePassword").val()!=$("#devicePassword2").val())&&($("#devicePassword2").val()!="")){

			 $("#devicePassword").after("<span id='passwordInsertAfter' style='color:red;margin-left:10px;'>两次密码输入不一致，请重新输入</span>");		
		}
	})
	$("#devicePassword2").on("blur",function(){
		 $("#password2InsertAfter").remove();
		 $("#passwordInsertAfter").remove();
		if(($("#devicePassword").val()!=$("#devicePassword2").val())&&($("#devicePassword").val()!="")){
			 $("#devicePassword2").after("<span id='password2InsertAfter' style='color:red;margin-left:10px;'>两次输入密码不一致，请重新输入</span>");		
		}
	})	
	
	$("#name").on("focus",function(){
		 $("#nameInsertAfter").remove();			
	});
	$("#phone").on("focus",function(){
		 $("#phoneInsertAfter").remove();			
	});	
	$("#plateNumber").on("focus",function(){
		 $("#plateNumberInsertAfter").remove();			
	});	
	$("#speedLimit").on("focus",function(){
		 $("#speedLimitInsertAfter").remove();			
	});	
	$("#contactPhone").on("focus",function(){
		 $("#contactPhoneInsertAfter").remove();			
	});	
	$("#oilCoefficient").on("focus",function(){
		 $("#oilCoefficientInsertAfter").remove();			
	});	
	$("#lastMaintainKilometre").on("focus",function(){
		 $("#lastMaintainKilometreInsertAfter").remove();			
	});	
	$("#maintainDistancePeriod").on("focus",function(){
		 $("#maintainDistancePeriodInsertAfter").remove();			
	});	
	$("#deviceContact").on("focus",function(){
		 $("#deviceContactInsertAfter").remove();			
	});	
	$("#deviceImei").on("focus",function(){
		 $("#deviceImeiInsertAfter").remove();			
	});	
	$("#deviceNote").on("focus",function(){
		 $("#deviceNote").css("color","black");			
	});	

	
	$(".confirm").on("click",function(){
		var checkResult=true;
		//alert("confirm key click!");		
		if(!(/^(\w|[\u4e00-\u9fa5-]){4,10}$/.test($("#name").val()))){
			 $("#nameInsertAfter").remove();
			 $("#name").after("<span id='nameInsertAfter' style='color:red;float:left;margin-left:10px;'>设备名不能为空，且只能是4-10位字母汉字数字或者下划线!</span>");	
			 checkResult=false;
		}
		//return;
		if(!(/^\d{0,20}$/.test($("#phone").val()))){
			 $("#phoneInsertAfter").remove();
			 $("#phone").after("<span id='phoneInsertAfter' style='color:red;float:left;margin-left:10px;'>设备电话不能为空，且只能是5-20位数字!</span>");	
			 checkResult=false;
		}
		
		if(!(/^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$/.test($("#plateNumber").val()))){
			 $("#plateNumberInsertAfter").remove();
			 $("#plateNumber").after("<span id='plateNumberInsertAfter' style='color:red;float:left;margin-left:10px;'>请输入正确的车牌号码!</span>");	
			 checkResult=false;
		}		
		
		if(!(/^\d{0,3}$/.test($("#speedLimit").val()))){
			 $("#speedLimitInsertAfter").remove();
			 $("#speedLimit").after("<span id='#speedLimitInsertAfter' style='color:red;float:left;margin-left:10px;'>请输入三位及以内数字，单位公里!</span>");	
			 checkResult=false;
		}
				
		if(!(/^\d{0,20}$/.test($("#contactPhone").val()))){
			 $("#contactPhoneInsertAfter").remove();
			 $("#contactPhone").after("<span id='contactPhoneInsertAfter' style='color:red;float:left;margin-left:10px;'>联系电话不能为空，且只能是5-20位数字!</span>");	
			 checkResult=false;
		}		
		//oilCoefficient	

		
		if(!(/^\d+(\.\d+)?$/.test($("#oilCoefficient").val()))){
			 $("#oilCoefficientInsertAfter").remove();
			 $("#oilCoefficient").after("<span id='oilCoefficientInsertAfter' style='color:red;float:left;margin-left:10px;'>油耗只能是1000以内整数或者小数!</span>");	
			 checkResult=false;
		}		
		
		
		
		if(!(/^\d{0,7}$/.test($("#lastMaintainKilometre").val()))){
			 $("#lastMaintainKilometreInsertAfter").remove();
			 $("#lastMaintainKilometre").after("<span id='lastMaintainKilometreInsertAfter' style='color:red;float:left;margin-left:10px;'>请输入六位以内整数!</span>");	
			 checkResult=false;
		}			
		
		if(!(/^\d{0,7}$/.test($("#maintainDistancePeriod").val()))){
			 $("#maintainDistancePeriodInsertAfter").remove();
			 $("#maintainDistancePeriod").after("<span id='maintainDistancePeriodInsertAfter' style='color:red;float:left;margin-left:10px;'>请输入六位以内整数!</span>");	
			 checkResult=false;
		}	

		if(!(/^(\w|[\u4e00-\u9fa5-]){0,10}$/.test($("#deviceContact").val()))){
			 $("#deviceContactInsertAfter").remove();
			 $("deviceContact").after("<span id='deviceContactInsertAfter' style='color:red;float:left;margin-left:10px;'>联系人不能为空，且只能是0-10位字母汉字数字或者下划线!</span>");	
			 checkResult=false;
		}			
		if(!(/^\d{0,20}$/.test($("#deviceImei").val()))){
			 $("#deviceImeiInsertAfter").remove();
			 $("#deviceImei").after("<span id='deviceImeiInsertAfter' style='color:red;float:left;margin-left:10px;'>请输入模块IMEI!</span>");	
			 checkResult=false;
		}		
		if(!(/^\S{6,20}$/.test($("#devicePassword").val()))){
			 //$("#password").val().trim();
			 $("#passwordInsertAfter").remove();
			 $("#devicePassword").after("<span id='passwordInsertAfter' style='color:red;margin-left:10px;'>密码长度大于等于6小于20</span>");	
			 checkResult=false;						
		}	
		if(!(/^(\w|[\u4e00-\u9fa5-]){0,200}$/.test($("#deviceNote").val()))){
			
			 $("#deviceNote").css("color","red");
			 //$("#deviceNote").attr("placeholder","备注只能是字母数字下划线组合！且长度小于200");
			$("#deviceNote").val($("#deviceNote").val()+"\n备注只能是字母数字下划线组合！且长度小于200");
			 //$("#deviceNote").text("备注只能是字母数字下划线组合！且长度小于200");
			 //$("#deviceNoteInsertAfter").remove();
			 //$("#deviceNoteInsertAfter").after("<span id='deviceNoteInsertAfter' style='color:red;margin-left:10px;'>密码长度大于等于6小于20</span>");
			 checkResult=false;	
		}		
		if(!checkResult)return;
		alert($("#deviceCategory").text().substring(0,1));
		alert($(".icon-input input:radio:checked").val());
		//return;
		var postParameter={
				id:"${localizer.id}",
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
				deviceIcon:$(".icon-input input:radio:checked").val(),
				deviceImei:$("#deviceImei").val(),
				deviceCategory:$("#deviceCategory").text().substring(0,1),
				//deviceCategory:$("#deviceCategory").text().substring(0,$("#deviceCategory").text().search("-")),
				deviceNote:$("#deviceNote").val()
			};
		//postParameter.account();
		alert(JSON.stringify(postParameter));
		
		$.post("localizerModify.do",
			postParameter,
			function(result){
		        
				var index = parent.layer.getFrameIndex(window.name);
				//parent.$('.btn-refresh').click();
				if(result.result=="success"){
					alert("设备信息修改成功！");
					//parent.location.reload(); 
					parent.layer.close(index);	
				}else{
					alert("设备信息修改失败！");
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
		$(".select-list").hide();
		//alert($(this).text());
	})
})
showRemind('input[type=text], textarea','placeholder');
</script>
</html>
