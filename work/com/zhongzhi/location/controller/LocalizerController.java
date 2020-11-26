package com.zhongzhi.location.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhongzhi.location.pojo.Localizer;
import com.zhongzhi.location.pojo.LocalizerQueryParam;
import com.zhongzhi.location.pojo.result.ExecuteResult;
import com.zhongzhi.location.service.LocalizerService;

@Controller
public class LocalizerController {
	@Autowired
	LocalizerService localizerService;

	
	@RequestMapping(value= {"localizerAdd","ui/gas/views/localizerAdd"})
	public String localizerAdd() {
		System.out.println("localizerAdd");
		return "localizerAdd";
	}
	
	@RequestMapping("localizerResetPassword")
	@ResponseBody
	public Map<String,String> localizerResetPassword(Localizer local) {
		//System.out.println("localizerModify");
		local.setDevicePassword("123456");
		int i = localizerService.localizerModify(local);
		Map<String,String> map = new HashMap<String,String>();
		if(i>0) {
			map.put("result", "success");
		}else {
			map.put("result", "fail");
		}
		
		return map;
	}
	
	@RequestMapping("localizerOverdueTimeSet")
	public String localizerOverdueTimeSet(Map<String,Integer> map,Localizer local) {
		System.out.println("localizerOverdueTimeSet");
		map.put("id", local.getId());
		return "localizerOverdueTimeSet";
	}	
	@RequestMapping("localizerOverdueTimeSet.do")
	@ResponseBody
	public Map<String,String> localizerOverdueTimeSet(int id, int addTime) {
		System.out.println("localizerOverdueTimeSet");
		return localizerService.localizerOverdueTimeSet(id, addTime);
	}		
	@RequestMapping("localizerModify")
	public String localizerModify(Map<String,Object> map,Localizer local) {
		//System.out.println("localizerModify");
		List<Localizer> list = localizerService.localizerQuery(local);
		System.out.println(list);
		map.put("localizer", list.get(0));
		return "localizerModify";
	}
	@RequestMapping(method=RequestMethod.GET,value="localizerInfo")
	public String localizerInfo(Map<String,Object> map,Localizer local) {
		//System.out.println("localizerModify");
		List<Localizer> list = localizerService.localizerQuery(local);
		System.out.println(list);
		map.put("localizer", list.get(0));
		return "localizerInfo";
	}
	@RequestMapping(method=RequestMethod.GET,value="localizerSale")
	public String localizerSale(Map<String,Object> map,Localizer local) {
		//System.out.println("localizerModify");
		List<Localizer> list = localizerService.localizerQuery(local);
		System.out.println(list);
		map.put("localizer", list.get(0));
		return "localizerSale";
	}	
	@RequestMapping("localizerModify.do")
	@ResponseBody
	public Map<String,String> localizerModify(Localizer local) {
		System.out.println(local);
		int i = localizerService.localizerModify(local);
		Map<String,String> map = new HashMap<String,String>();
		if(i>0) {
			map.put("result", "success");
		}else{
			map.put("result", "fail");
		}
		return map;
	}
	@RequestMapping("localizerAdd.do")
	@ResponseBody
	public ExecuteResult localizerAdd(Localizer local) {
		//System.out.println("localizerAdd");
		ExecuteResult er = new ExecuteResult();
		local.setActiveTime(new Date());
		local.setCreateTime(new Date());
		local.setDueTime(new Date());
		local.setLastUpdateTime(new Date());
		System.out.println(local);
		int i=localizerService.localizerAdd(local);
		if(i>0) {
			er.setResult("success");
		}else {
			er.setResult("fail");
		}
		return er;		

	}
	
	@RequestMapping("localizerDelete")
	@ResponseBody
	public Map<String,String> localizerDelete(@RequestParam("deleteIds[]") List<Integer> deleteIds) {
		System.out.println("进入删除函数！");
		System.out.println(deleteIds);
		int i = localizerService.localizerBatchDelete(deleteIds);
		Map<String,String> map = new HashMap<String,String>();
		if(i==0) {
			map.put("executeResult", "fail");
		}else {
			map.put("executeResult", "success");
		}
		return map;		

	}	
		
	@RequestMapping("localizerActive")
	@ResponseBody
	public Map<String,String> localizerActive(int activeId) {
		System.out.println("进入激活函数！");
		System.out.println(activeId);
		Localizer local = new Localizer();
		local.setId(activeId);
		local.setDeviceStatus(3);
		int i = localizerService.localizerModify(local);
		Map<String,String> map = new HashMap<String,String>();
		if(i==0) {
			map.put("executeResult", "fail");
		}else {
			map.put("executeResult", "success");
		}
		return map;		

	}	
	
	
	@RequestMapping("localizerList")
	public String localizerList(Map<String,Object> map, Localizer local) {
		System.out.println(local);
		System.out.println("localizerList");
		List<Localizer> list = localizerService.localizerQuery(local);
		map.put("list", list);
		return "localizerList";
	}
	@RequestMapping("localizerList.do")
	public String localizerList(Map<String,Object> map,LocalizerQueryParam mqp) {
		//System.out.println("进入控制器处理函数！");
		//System.out.println(mqp);
		//mqp.setMember(new Member());
		
		Map<String,Object> pageInfo = localizerService.getLocalizerByPage(mqp);
		map.put("pageInfo",pageInfo);
		map.put("test","测试");
		System.out.println(pageInfo);
		return "localizerList";
	}
	@RequestMapping("localizerList.json")
	@ResponseBody
	public Map<String,Object> localizerList(LocalizerQueryParam mqp) {
		//System.out.println("进入控制器处理函数！");
		System.out.println("请求参数:"+mqp);
		//mqp.setMember(new Member());
		
		Map<String,Object> pageInfo = localizerService.getLocalizerByPage(mqp);
		//map.put("pageInfo",pageInfo);
		//map.put("test","测试");
		//System.out.println(pageInfo);
		return pageInfo;
	}	
}
