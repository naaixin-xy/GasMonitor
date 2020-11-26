package com.anfu.gas.service;

import java.util.List;
import java.util.Map;

import com.anfu.gas.pojo.Area;
import com.anfu.gas.pojo.AreaExample;
import com.anfu.gas.pojo.City;
import com.anfu.gas.pojo.CityExample;
import com.anfu.gas.pojo.Province;
import com.anfu.gas.pojo.ProvinceExample;
import com.anfu.gas.pojo.Street;
import com.anfu.gas.pojo.StreetExample;

public interface RegionService {
	public Map<String, Object> selectProvinceByExampleAndPage(Province province,int page,int limit);
	public long countProvinceByExample(Province province);	
	public Map<String, Object> selectCityByExampleAndPage(City city,int page,int limit);
	public long countCityByExample(City city);	
	public Map<String, Object> selectAreaByExampleAndPage(Area area,int page,int limit);
	public long countAreaByExample(Area area);	
	public Map<String, Object> selectStreetByExampleAndPage(Street street,int page,int limit);
	public long countStreetByExample(Street Street);	
}
