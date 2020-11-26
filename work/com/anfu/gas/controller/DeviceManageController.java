package com.anfu.gas.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anfu.gas.pojo.GasDetector;
import com.anfu.gas.pojo.GasDetectorType;
import com.anfu.gas.pojo.GasHost;
import com.anfu.gas.pojo.GasHostType;
import com.anfu.gas.service.DeviceManageService;
@Controller
public class DeviceManageController {
	@Resource(name="deviceManageService")
	DeviceManageService deviceManageService;
	
	
	@RequestMapping(value= {"ui/gas/views/gasDetector"})
	public String jumpToGasDetector() {
		System.out.println("进入GasDetector跳转函数");
		return "gas/views/device/gasDetector";		
	}
	@RequestMapping(value= {"ui/gas/views/device/getGasDetectorListByPage"},method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getGasDetectorListByPage(GasDetector gasDetector,int page, int limit) {
		System.out.println("进入城市数据操作函数");
		
		return deviceManageService.selectGasDetectorByExampleAndPage(gasDetector, page, limit);		
	}

	@RequestMapping(value= {"ui/gas/views/device/addDetector"})
	public String jumpToAddDetector(Map<?,?> map) {
		System.out.println("进入addDetector跳转函数");
		//map();
		return "gas/views/device/addDetector";		
	}	
	
	
	@RequestMapping(value= {"ui/gas/views/gasHost"})
	public String jumpToGasHost() {
		System.out.println("进入gasHost跳转函数");
		return "gas/views/device/gasHost";		
	}
	@RequestMapping(value= {"ui/gas/views/device/getGasHostListByPage"},method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getGasHostListByPage(GasHost gasHost,int page, int limit) {
		System.out.println("进入城市数据操作函数");
		
		return deviceManageService.selectGasHostByExampleAndPage(gasHost, page, limit);		
	}
	
	

	@RequestMapping(value= {"ui/gas/views/gasDetectorType"})
	public String jumpToGasDetectorType() {
		System.out.println("进入GasDetectorType跳转函数");
		return "gas/views/device/gasDetectorType";		
	}
	@RequestMapping(value= {"ui/gas/views/device/getGasDetectorTypeListByPage"},method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getGasDetectorTypeListByPage(GasDetectorType gasDetectorType,int page, int limit) {
		System.out.println("进入城市数据操作函数");
		
		return deviceManageService.selectGasDetectorTypeByExampleAndPage(gasDetectorType, page, limit);		
	}	
	
	
	@RequestMapping(value= {"ui/gas/views/gasHostType"})
	public String jumpToGasHostType() {
		System.out.println("进入gasHostType跳转函数");
		return "gas/views/device/gasHostType";		
	}
	@RequestMapping(value= {"ui/gas/views/device/getGasHostTypeListByPage"},method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getGasHostTypeListByPage(GasHostType gasHostType,int page, int limit) {
		System.out.println("进入城市数据操作函数");
		
		return deviceManageService.selectGasHostTypeByExampleAndPage(gasHostType, page, limit);		
	}	
	
	
}
