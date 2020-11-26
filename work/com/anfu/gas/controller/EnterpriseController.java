package com.anfu.gas.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anfu.gas.pojo.Enterprise;
import com.anfu.gas.pojo.SubArea;
import com.anfu.gas.service.EnterpriseService;
@Controller
public class EnterpriseController {
	@Resource(name="enterpriseService")
	EnterpriseService enterpriseService;
	
	@RequestMapping(value= {"ui/gas/views/enterprise"})
	public String jumpToEnterprise() {
		System.out.println("进入province跳转函数");
		return "gas/views/enterprise/enterprise";		
	}
	
	@RequestMapping(value= {"ui/gas/views/enterprise/getEnterpriseListByPage"},method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getEnterpriseListByPage(Enterprise enterprise,int page, int limit) {
		System.out.println("进入城市数据操作函数");
		
		return enterpriseService.selectEnterpriseByExampleAndPage(enterprise, page, limit);		
	}
	
	@RequestMapping(value= {"ui/gas/views/subArea"})
	public String jumpToSubArea() {
		System.out.println("进入province跳转函数");
		return "gas/views/enterprise/subArea";		
	}
	
	
	@RequestMapping(value= {"ui/gas/views/enterprise/getSubAreaListByPage"},method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getSubAreaListByPage(SubArea subArea,int page, int limit) {
		System.out.println("进入城市数据操作函数");
		
		return enterpriseService.selectSubAreaByExampleAndPage(subArea, page, limit);		
	}	
	
}
