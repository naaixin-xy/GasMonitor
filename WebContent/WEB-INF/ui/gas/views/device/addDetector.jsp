<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath() + "/ui";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>表单组合</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="../../layuiadmin/layui/css/layui.css" media="all">
  <link rel="stylesheet" href="../../layuiadmin/style/admin.css" media="all">
</head>
<body>

  <div class="layui-fluid">
    <div class="layui-card">
<!--       <div class="layui-card-header">添加探测器</div> -->
      <div class="layui-card-body" style="padding: 15px;">
        <form class="layui-form layui-form-pane" action="" lay-filter="component-form-group">
        
<!--           <div class="layui-form-item"> -->
<!--             <label class="layui-form-label">单行选择框</label> -->
<!--             <div class="layui-input-block"> -->
<!--               <select name="interest" lay-filter="aihao"> -->
<!--                 <option value=""></option> -->
<!--                 <option value="0">写作</option> -->
<!--                 <option value="1" selected="">阅读</option> -->
<!--                 <option value="2">游戏</option> -->
<!--                 <option value="3">音乐</option> -->
<!--                 <option value="4">旅行</option> -->
<!--               </select> -->
<!--             </div> -->
<!--           </div>        -->

          <div class="layui-form-item">
            <label class="layui-form-label">设备ID</label>
            <div class="layui-input-block">
              <input type="text" name="id" lay-verify="title" autocomplete="off" placeholder="设备ID" class="layui-input">
            </div>
          </div>
          <div class="layui-form-item">
            <label class="layui-form-label">设备名称</label>
            <div class="layui-input-block">
              <input type="text" name="name" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
          </div>
          
          <div class="layui-form-item">
            <label class="layui-form-label">所属机构</label>
            <div class="layui-input-block">
              <div class="layui-inline">
                <select name="provinceId">
                  <option value="">请选择省</option>
                  <option value="浙江" selected="">浙江省</option>
                  <option value="你的工号">江西省</option>
                  <option value="你最喜欢的老师">福建省</option>
                </select>
              </div>
              <div class="layui-inline">
                <select name="cityId">
                  <option value="">请选择市</option>
                  <option value="杭州">杭州</option>
                  <option value="宁波" disabled="">宁波</option>
                  <option value="温州">温州</option>
                  <option value="温州">台州</option>
                  <option value="温州">绍兴</option>
                </select>
              </div>
              <div class="layui-inline">
                <select name="areaId">
                  <option value="">请选择县/区</option>
                  <option value="西湖区">西湖区</option>
                  <option value="余杭区">余杭区</option>
                  <option value="拱墅区">临安市</option>
                </select>
              </div>
              <div class="layui-inline">
                <select name="streetId">
                  <option value="">请选择街道</option>
                  <option value="西湖区">西湖区</option>
                  <option value="余杭区">余杭区</option>
                  <option value="拱墅区">临安市</option>
                </select>
              </div>  
              <div class="layui-inline">
                <select name="enterpriseId">
                  <option value="">请选择单位</option>
                  <option value="西湖区">西湖区</option>
                  <option value="余杭区">余杭区</option>
                  <option value="拱墅区">临安市</option>
                </select>
              </div>                           
            </div>
          </div>            
           <div class="layui-form-item">
	           <div class="layui-inline">
	            <label class="layui-form-label">分区选择</label>
	            <div class="layui-input-inline">
	              <select name="subArea" lay-filter="aihao">
	                <option value=""></option>
	                <option value="0">写作</option>
	                <option value="1" selected="">阅读</option>
	                <option value="2">游戏</option>
	                <option value="3">音乐</option>
	                <option value="4">旅行</option>
	              </select>
	            </div>
	          </div>
	          
	           <div class="layui-inline">
	            <label class="layui-form-label">探测器类型</label>
	            <div class="layui-input-inline">
	              <select name="typeId" lay-filter="aihao">
	                <option value=""></option>
	                <option value="0">写作</option>
	                <option value="1" selected="">阅读</option>
	                <option value="2">游戏</option>
	                <option value="3">音乐</option>
	                <option value="4">旅行</option>
	              </select>
	            </div>
	          </div>
	          
	          
	           <div class="layui-inline">
	            <label class="layui-form-label">主机</label>
	            <div class="layui-input-inline">
	              <select name="hostId" lay-filter="aihao">
	                <option value=""></option>
	                <option value="0">写作</option>
	                <option value="1" selected="">阅读</option>
	                <option value="2">游戏</option>
	                <option value="3">音乐</option>
	                <option value="4">旅行</option>
	              </select>
	            </div>
	          </div> 	          
          </div>
         
          <div class="layui-form-item">
	            <div class="layui-inline">
	              <label class="layui-form-label">通信地址</label>
	              <div class="layui-input-inline">
	                <input type="text" name="communicationAddress" lay-verify="required" autocomplete="off" class="layui-input">
	              </div>
	            </div>
	            <div class="layui-inline">
	              <label class="layui-form-label">安装位置</label>
	              <div class="layui-input-inline">
	                <input type="text" name="location" lay-verify="required" autocomplete="off" class="layui-input">
	              </div>
	            </div>            
	            <div class="layui-inline">
	              <label class="layui-form-label">坐标X</label>
	              <div class="layui-input-inline">
	                <input type="text" name="coordinateX" lay-verify="required" autocomplete="off" class="layui-input">
	              </div>
	            </div> 
	            
	            <div class="layui-inline">
	              <label class="layui-form-label">坐标Y</label>
	              <div class="layui-input-inline">
	                <input type="text" name="coordinateY" lay-verify="required" autocomplete="off" class="layui-input">
	              </div>
	            </div> 

           </div> 
           
    
           
            <div class="layui-form-item">
	            <div class="layui-inline">
	              <label class="layui-form-label">管理人</label>
	              <div class="layui-input-inline">
	                <input type="text" name=" governor" lay-verify="required" autocomplete="off" class="layui-input">
	              </div>
	            </div>
	            
	            <div class="layui-inline">
	              <label class="layui-form-label">安装人</label>
	              <div class="layui-input-inline">
	                <input type="text" name="installer" lay-verify="required" autocomplete="off" class="layui-input">
	              </div>
	            </div>	
	            
	            

	            <div class="layui-inline">
	              <label class="layui-form-label">高限报警</label>
	              <div class="layui-input-inline">
	                <input type="text" name="lowAlarm" lay-verify="required" autocomplete="off" class="layui-input">
	              </div>
	            </div>

	           <div class="layui-inline">
	              <label class="layui-form-label">低限报警</label>
	              <div class="layui-input-inline">
	                <input type="text" name="highAlarm" lay-verify="required" autocomplete="off" class="layui-input">
	              </div>
	            </div>	                        
           </div>            
           <div class="layui-form-item">  
	              <label class="layui-form-label">序列号</label>
	              <div class="layui-input-block">
	                <input type="text" name="serialNumber" lay-verify="required" autocomplete="off" class="layui-input">
	              </div>
	       </div>
	            

         <div class="layui-form-item">
       
              <label class="layui-form-label">备注</label>
              <div class="layui-input-block">
                <input type="text" name="note" lay-verify="required" autocomplete="off" class="layui-input">
              </div>
           
           </div>      

         <div class="layui-form-item">
            <div class="layui-inline">
              <label class="layui-form-label">经度</label>
              <div class="layui-input-inline">
                <input type="text" name="longitude" lay-verify="required" autocomplete="off" class="layui-input">
              </div>
            </div>
            <div class="layui-inline">
              <label class="layui-form-label">纬度</label>
              <div class="layui-input-inline">
                <input type="text" name="latitude" lay-verify="required" autocomplete="off" class="layui-input">
              </div>
            </div>            
           </div>  
                  
           
          <div class="layui-form-item">
            <div class="layui-inline">
              <label class="layui-form-label">最小值</label>
              <div class="layui-input-inline">
                <input type="text" name="minValue" lay-verify="required" autocomplete="off" class="layui-input">
              </div>
            </div>
            <div class="layui-inline">
              <label class="layui-form-label">最大值</label>
              <div class="layui-input-inline">
                <input type="text" name="maxValue" lay-verify="required" autocomplete="off" class="layui-input">
              </div>
            </div>            
           </div>   
                                                

         <div class="layui-form-item">
            <div class="layui-inline">
              <label class="layui-form-label">气体类型</label>
              <div class="layui-input-inline">
                <input type="text" name="gasType" lay-verify="required" autocomplete="off" class="layui-input">
              </div>
            </div>
           </div> 
           
           
           
         <div class="layui-form-item">
            <div class="layui-inline">
              <label class="layui-form-label">浓度单位</label>
              <div class="layui-input-inline">
                <input type="text" name="gasUnit" lay-verify="required" autocomplete="off" class="layui-input">
              </div>
            </div>
           </div> 
           
           
         
           
           
         
                <input type="hidden" name="provinceName" lay-verify="required" autocomplete="off" class="layui-input">
   
           
    
                <input type="hidden" name="cityName" lay-verify="required" autocomplete="off" class="layui-input">
          
           
   
                <input type="hidden" name="areaName" lay-verify="required" autocomplete="off" class="layui-input">
 
           

                <input type="hidden" name="streetName" lay-verify="required" autocomplete="off" class="layui-input">

           
                                        

                <input type="hidden" name="enterpriseName" lay-verify="required" autocomplete="off" class="layui-input">
           
	          <div class="layui-form-item layui-form-text">
	            <label class="layui-form-label">备注</label>
	            <div class="layui-input-block">
	              <textarea name="note" placeholder="请输入内容" class="layui-textarea"></textarea>
	            </div>
	          </div>             
	          
 
          <div class="layui-form-item layui-layout-admin">
            <div class="layui-input-block">
              <div class="layui-footer" style="left: 0;">
                <button class="layui-btn" lay-submit="" lay-filter="component-form-demo1">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
              </div>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>

    
  <script src="../../layuiadmin/layui/layui.js"></script>  
  <script>
  layui.config({
    base: '../../layuiadmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use(['index', 'form', 'laydate'], function(){
    var $ = layui.$
    ,admin = layui.admin
    ,element = layui.element
    ,layer = layui.layer
    ,laydate = layui.laydate
    ,form = layui.form;
    
    form.render(null, 'component-form-group');

    laydate.render({
      elem: '#LAY-component-form-group-date'
    });
    
    /* 自定义验证规则 */
    form.verify({
      title: function(value){
        if(value.length < 5){
          return '标题至少得5个字符啊';
        }
      }
      ,pass: [/(.+){6,12}$/, '密码必须6到12位']
      ,content: function(value){
        layedit.sync(editIndex);
      }
    });
    
    /* 监听指定开关 */
    form.on('switch(component-form-switchTest)', function(data){
      layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
        offset: '6px'
      });
      layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
    });
    
    /* 监听提交 */
    form.on('submit(component-form-demo1)', function(data){
      parent.layer.alert(JSON.stringify(data.field), {
        title: '最终的提交信息'
      })
      return false;
    });
  });
  </script>
</body>
</html>
