package com.anfu.gas.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anfu.gas.mapper.AreaMapper;
import com.anfu.gas.mapper.CityMapper;
import com.anfu.gas.mapper.ProvinceMapper;
import com.anfu.gas.mapper.StreetMapper;
import com.anfu.gas.mapper.self.SelectByPageMapper;
import com.anfu.gas.pojo.Area;
import com.anfu.gas.pojo.City;
import com.anfu.gas.pojo.Province;
import com.anfu.gas.pojo.Street;
import com.anfu.gas.pojo.self.AreaExamplePageInfo;
import com.anfu.gas.pojo.self.CityExamplePageInfo;
import com.anfu.gas.pojo.self.ProvinceExamplePageInfo;
import com.anfu.gas.pojo.self.StreetExamplePageInfo;
import com.anfu.gas.service.RegionService;

@Service("regionService")
public class RegionServiceImpl implements RegionService{
	@Autowired
	ProvinceMapper provinceMapper;
	@Autowired
	CityMapper cityMapper;
	@Autowired
	AreaMapper areaMapper;
	@Autowired
	StreetMapper streetMapper;
	@Autowired
	SelectByPageMapper selectByPageMapper;	
	@Override
	public Map<String, Object> selectProvinceByExampleAndPage(Province province, int page, int limit) {
		// TODO Auto-generated method stub
		int pageSize = limit;
		int pageNum = page-1;
		int pageStart = pageNum*pageSize;
		
		ProvinceExamplePageInfo example=null;

		example = new ProvinceExamplePageInfo();
		ProvinceExamplePageInfo.Criteria criteria = example.createCriteria(); 
		
		int totalCount=(int)provinceMapper.countByExample(example);
		
		int totalPage=totalCount/pageSize;
		if(totalCount%pageSize!=0) {
			totalPage++;
		}
		if(totalCount-pageStart<pageSize) {
			pageSize=totalCount-pageStart;
		}
		example.setPageStart(pageStart);
		example.setPageSize(pageSize);
		
		List<Province> list = selectByPageMapper.selectProvinceByExampleAndPage(example);

		Map<String,Object> pageInfo = new HashMap<String,Object>();		
				  
		pageInfo.put("code", 0);
		pageInfo.put("msg", pageSize);
		pageInfo.put("count", totalCount);
		pageInfo.put("data", list);
		return pageInfo;
	}
	@Override
	public Map<String,Object> selectCityByExampleAndPage(City city, int page, int limit) {
		// TODO Auto-generated method stub
		
		int pageSize = limit;
		int pageNum = page-1;
		int pageStart = pageNum*pageSize;
		
		CityExamplePageInfo example=null;

		example = new CityExamplePageInfo();
		CityExamplePageInfo.Criteria criteria = example.createCriteria(); 
		
		int totalCount=(int)cityMapper.countByExample(example);
		
		int totalPage=totalCount/pageSize;
		if(totalCount%pageSize!=0) {
			totalPage++;
		}
		if(totalCount-pageStart<pageSize) {
			pageSize=totalCount-pageStart;
		}
		example.setPageStart(pageStart);
		example.setPageSize(pageSize);
		
		List<City> list = selectByPageMapper.selectCityByExampleAndPage(example);

		Map<String,Object> pageInfo = new HashMap<String,Object>();		
				  
		pageInfo.put("code", 0);	
		
		pageInfo.put("msg", pageSize);
		pageInfo.put("count", totalCount);
		pageInfo.put("data", list);
		return pageInfo;
	}
	@Override
	public Map<String, Object> selectAreaByExampleAndPage(Area area, int page, int limit) {
		// TODO Auto-generated method stub
		
		int pageSize = limit;
		int pageNum = page-1;
		int pageStart = pageNum*pageSize;
		
		AreaExamplePageInfo example=null;

		example = new AreaExamplePageInfo();
		AreaExamplePageInfo.Criteria criteria = example.createCriteria(); 
		
		int totalCount=(int)areaMapper.countByExample(example);
		
		int totalPage=totalCount/pageSize;
		if(totalCount%pageSize!=0) {
			totalPage++;
		}
		if(totalCount-pageStart<pageSize) {
			pageSize=totalCount-pageStart;
		}
		example.setPageStart(pageStart);
		example.setPageSize(pageSize);
		
		List<Area> list = selectByPageMapper.selectAreaByExampleAndPage(example);

		Map<String,Object> pageInfo = new HashMap<String,Object>();		
				  
		pageInfo.put("code", 0);	
		
		pageInfo.put("msg", pageSize);
		pageInfo.put("count", totalCount);
		pageInfo.put("data", list);
		return pageInfo;
	}
	@Override
	public Map<String, Object> selectStreetByExampleAndPage(Street street, int page, int limit) {
		// TODO Auto-generated method stub
		
		int pageSize = limit;
		int pageNum = page-1;
		int pageStart = pageNum*pageSize;
		
		StreetExamplePageInfo example=null;

		example = new StreetExamplePageInfo();
		StreetExamplePageInfo.Criteria criteria = example.createCriteria(); 
		
		int totalCount=(int)streetMapper.countByExample(example);
		
		int totalPage=totalCount/pageSize;
		if(totalCount%pageSize!=0) {
			totalPage++;
		}
		if(totalCount-pageStart<pageSize) {
			pageSize=totalCount-pageStart;
		}
		example.setPageStart(pageStart);
		example.setPageSize(pageSize);
		
		List<Street> list = selectByPageMapper.selectStreetByExampleAndPage(example);

		Map<String,Object> pageInfo = new HashMap<String,Object>();		
				  
		pageInfo.put("code", 0);	
		
		pageInfo.put("msg", pageSize);
		pageInfo.put("count", totalCount);
		pageInfo.put("data", list);
		return pageInfo;
	}
	@Override
	public long countProvinceByExample(Province province) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public long countCityByExample(City city) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public long countAreaByExample(Area area) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public long countStreetByExample(Street Street) {
		// TODO Auto-generated method stub
		return 0;
	}
}
