package com.anfu.gas.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anfu.gas.pojo.Admin;
import com.anfu.gas.service.AdministratorService;

@Controller
public class AdministratorController {
	@Resource(name="administratorService")
	private AdministratorService administratorService;

	@RequestMapping(value= {"ui/gas/views/administrator"})
	public String jumpToAdministrator() {
		System.out.println("进入province跳转函数");
		return "gas/views/admin/administrator";		
	}
	@RequestMapping(value= {"ui/gas/views/admin/getAdministratorListByPage"},method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getAdministratorListByPage(Admin administrator,int page, int limit) {
		System.out.println("进入城市数据操作函数");
		
		return administratorService.selectAdministratorByExampleAndPage(administrator, page, limit);		
	}
}
