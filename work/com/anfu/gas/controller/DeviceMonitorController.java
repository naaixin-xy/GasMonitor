package com.anfu.gas.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anfu.gas.pojo.GasAlarm;
import com.anfu.gas.pojo.GasData;
import com.anfu.gas.pojo.GasFault;
import com.anfu.gas.pojo.self.parameter.GasAlarmParameter;
import com.anfu.gas.service.DeviceMonitorService;
@Controller
public class DeviceMonitorController {
	@Resource(name="deviceMonitorService")
	DeviceMonitorService deviceMonitorService;
	
	
	@RequestMapping(value= {"ui/gas/views/gasAlarm"})
	public String jumpToGasAlarm() {
		System.out.println("进入GasAlarm跳转函数");
		return "gas/views/monitor/gasAlarm";		
	}
	@RequestMapping(value= {"ui/gas/views/monitor/getGasAlarmListByPage"},method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getGasAlarmListByPage(HttpSession session,GasAlarmParameter gasAlarmParameter) {
		System.out.println("查询GasAlarm列表参数："+gasAlarmParameter);
		SessionData.setParameterRegionInfoFromSession(gasAlarmParameter, session);
		return deviceMonitorService.selectGasAlarmByExampleAndPage(gasAlarmParameter);		
	}

	@RequestMapping(value= {"ui/gas/views/monitor/deleteGasAlarmInfo"})
	@ResponseBody
	public Map<String,Object> deleteGasAlarmInfo(int id) {
		Map<String,Object> map = new HashMap<String,Object>();
		if( deviceMonitorService.deleteGasAlarmInfo(id)>0) {
			map.put("result", "success");
		}else{
			map.put("result", "fail");
		}
		return map;
	}	
	
	@RequestMapping(value= {"ui/gas/views/monitor/deleteBatchGasAlarmInfo"})
	@ResponseBody
	public Map<String,Object> deleteBatchGasAlarmInfo(@RequestParam("ids[]") List<Integer> ids) {
		Map<String,Object> map = new HashMap<String,Object>();
		if( deviceMonitorService.deleteBatchGasAlarmInfo(ids)>0) {
			map.put("result", "success");
		}else{
			map.put("result", "fail");
		}
		return map;				
	}
	
	@RequestMapping(value= {"ui/gas/views/monitor/getGasAlarmDetailInfo"})
	@ResponseBody
	public Map<String,Object> getGasAlarmDetailInfo(int id) {
		//GasAlarm gasAlarm = deviceMonitorService.selectGasAlarmDetailInfo(id);
		return deviceMonitorService.selectGasAlarmDetailInfo(id);		
	}
	
	@RequestMapping(value= {"ui/gas/views/monitor/jumpToGasAlarmDetailInfo"})
	//@ResponseBody showAlarmDetailInfo
	public String jumpToGasAlarmDetailInfo(int alarmInfoId) {
		//GasAlarm
		return "gas/views/monitor/gasAlarmDetailInfo";		
	}	
	@RequestMapping(value= {"ui/gas/views/gasFault"})
	public String jumpToGasFault() {
		System.out.println("进入GasFault跳转函数");
		return "gas/views/monitor/gasFault";		
	}
	@RequestMapping(value= {"ui/gas/views/monitor/getGasFaultListByPage"},method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getGasFaultListByPage(GasFault gasFault,int page, int limit) {
		System.out.println("进入城市数据操作函数");
		
		return deviceMonitorService.selectGasFaultByExampleAndPage(gasFault, page, limit);		
	}
	
	

	@RequestMapping(value= {"ui/gas/views/gasData"})
	public String jumpToGasData() {
		System.out.println("进入GasData跳转函数");
		return "gas/views/monitor/gasData";		
	}
	@RequestMapping(value= {"ui/gas/views/monitor/getGasDataListByPage"},method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getGasDataListByPage(GasData gasData,int page, int limit) {
		System.out.println("进入城市数据操作函数");
		
		return deviceMonitorService.selectGasDataByExampleAndPage(gasData, page, limit);		
	}	
}
