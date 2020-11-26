package com.anfu.gas.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anfu.gas.pojo.Area;
import com.anfu.gas.pojo.City;
import com.anfu.gas.pojo.Province;
import com.anfu.gas.pojo.Street;
import com.anfu.gas.service.RegionService;
@Controller
public class RegionController {
	@Resource(name="regionService")
	RegionService regionService;
	
	
	@RequestMapping(value= {"ui/gas/views/province"})
	public String jumpToProvince() {
		System.out.println("进入province跳转函数");
		return "gas/views/region/province";		
	}
	
	@RequestMapping(value= {"ui/gas/views/region/getProvinceListByPage"},method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getProvinceListByPage(Province province,int page, int limit) {
		System.out.println("进入城市数据操作函数");
		
		return regionService.selectProvinceByExampleAndPage(province, page, limit);		
	}
	
	@RequestMapping(value= {"ui/gas/views/city"})
	public String jumpToCity() {
		System.out.println("进入city跳转函数");
		return "gas/views/region/city";		
	}
	
	@RequestMapping(value= {"ui/gas/views/region/getCityListByPage"},method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getCityListByPage(City city,int page, int limit) {
		System.out.println("进入城市数据操作函数");
		
		return regionService.selectCityByExampleAndPage(city, page, limit);		
	}
	
	@RequestMapping(value= {"ui/gas/views/area"})
	public String jumpToArea() {
		System.out.println("进入area跳转函数");
		return "gas/views/region/area";		
	}
	
	@RequestMapping(value= {"ui/gas/views/region/getAreaListByPage"},method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getAreaListByPage(Area area,int page, int limit) {
		System.out.println("进入Area数据操作函数");
		
		return regionService.selectAreaByExampleAndPage(area, page, limit);		
	}
	
	@RequestMapping(value= {"ui/gas/views/street"})
	public String jumpToStreet() {
		System.out.println("进入area跳转函数");
		return "gas/views/region/street";		
	}
	
	@RequestMapping(value= {"ui/gas/views/region/getStreetListByPage"},method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getStreetListByPage(Street street,int page, int limit) {
		System.out.println("进入street数据操作函数");
		
		return regionService.selectStreetByExampleAndPage(street, page, limit);		
	}	
}
