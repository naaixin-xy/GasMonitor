package com.anfu.gas.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anfu.gas.pojo.GasDetector;
import com.anfu.gas.pojo.self.HualuDalianUploadParamter;
import com.anfu.gas.service.ExternalInterfaceService;


@Controller
public class ExternalInterfaceController {
	@Resource(name="externalInterfaceService")
	ExternalInterfaceService externalInterfaceService;
	
	@RequestMapping(value= {"/external/interface/upload.do"})	
	@ResponseBody
	public Map<String,Object> HunluDalianUpload(HttpServletRequest request,
			HttpServletResponse  response,
			@RequestParam("UserName") String userName,
			@RequestParam("Password") String password,
			@RequestParam("Command") String command
		) {
		
		response.setContentType("text/html;charset=utf-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        response.addHeader("Access-Control-Max-Age", "1800");//30 min		
		HualuDalianUploadParamter hualuDalianUploadParamter = new HualuDalianUploadParamter(userName,password,command);
		return externalInterfaceService.HunluDalianUpload(hualuDalianUploadParamter);
	}
}
