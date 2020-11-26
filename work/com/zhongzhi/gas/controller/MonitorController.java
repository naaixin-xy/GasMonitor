package com.zhongzhi.gas.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhongzhi.location.service.MonitorService;

@Controller
//@RequestMapping("demo")
public class MonitorController {
	@Autowired
	MonitorService monitorService;
	//monitorDeviceMapView
	@RequestMapping("monitorDeviceMapView")
	public String monitorDeviceMapView() {
		System.out.println("monitorDeviceMapView");
		return "monitorDeviceMapView";
	}	
}
