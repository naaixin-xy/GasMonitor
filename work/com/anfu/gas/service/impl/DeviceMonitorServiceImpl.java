package com.anfu.gas.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anfu.gas.mapper.GasAlarmMapper;
import com.anfu.gas.mapper.GasDataMapper;
import com.anfu.gas.mapper.GasFaultMapper;
import com.anfu.gas.mapper.self.SelectByPageMapper;
import com.anfu.gas.pojo.GasAlarm;
import com.anfu.gas.pojo.GasAlarmExample;
import com.anfu.gas.pojo.GasData;
import com.anfu.gas.pojo.GasFault;
import com.anfu.gas.pojo.self.GasAlarmExamplePageInfo;
import com.anfu.gas.pojo.self.GasDataExamplePageInfo;
import com.anfu.gas.pojo.self.GasFaultExamplePageInfo;
import com.anfu.gas.pojo.self.parameter.GasAlarmParameter;
import com.anfu.gas.service.DeviceMonitorService;

@Service("deviceMonitorService")
public class DeviceMonitorServiceImpl implements DeviceMonitorService{
//	@Autowired
//	GasHostMapper gasHostMapper;
//	@Autowired
//	GasDetectorMapper gasDetectorMapper;
	@Autowired
	SelectByPageMapper selectByPageMapper;
//	@Autowired
//	GasHostTypeMapper gasHostTypeMapper;	
//	@Autowired
//	GasDetectorTypeMapper gasDetectorTypeMapper;	
	@Autowired
	GasAlarmMapper gasAlarmMapper;
	@Autowired
	GasFaultMapper gasFaultMapper;	
	@Autowired
	GasDataMapper gasDataMapper;	

	@Override
	public Map<String, Object> selectGasAlarmByExampleAndPage(GasAlarmParameter gasAlarmParameter) {
		// TODO Auto-generated method stub
		int pageSize = gasAlarmParameter.getLimit();
		int pageNum = gasAlarmParameter.getPage()-1;
		int pageStart = pageNum*pageSize;
		
		GasAlarmExamplePageInfo example=null;

		example = new GasAlarmExamplePageInfo();
		GasAlarmExamplePageInfo.Criteria criteria = example.createCriteria(); 
		if(gasAlarmParameter.getHostId()!=null) {
			criteria.andHostIdEqualTo(gasAlarmParameter.getHostId());
		}
		if(gasAlarmParameter.getDetectorId()!=null) {
			criteria.andDetectorIdEqualTo(gasAlarmParameter.getDetectorId());
		}
		if(gasAlarmParameter.getProvinceId()!=null) {
			criteria.andProvinceIdEqualTo(gasAlarmParameter.getProvinceId());
		}
		if(gasAlarmParameter.getCityId()!=null) {
			criteria.andCityIdEqualTo(gasAlarmParameter.getCityId());
		}		
		if(gasAlarmParameter.getAreaId()!=null) {
			criteria.andAreaIdEqualTo(gasAlarmParameter.getAreaId());
		}	
		if(gasAlarmParameter.getStreetId()!=null) {
			criteria.andStreetIdEqualTo(gasAlarmParameter.getStreetId());
		}
		if(gasAlarmParameter.getEnterpriseId()!=null) {
			criteria.andEnterpriseIdEqualTo(gasAlarmParameter.getEnterpriseId());
		}	
		if((gasAlarmParameter.getType()!=null)&&(gasAlarmParameter.getType()!=0)) {
			criteria.andTypeEqualTo(gasAlarmParameter.getType());
		}
		if((gasAlarmParameter.getHeadTime()!=null)&&(gasAlarmParameter.getEndTime()!=null)) {
			criteria.andStartTimeBetween(gasAlarmParameter.getHeadTime(), gasAlarmParameter.getEndTime());
		}
		example.setOrderByClause("id desc");
		int totalCount=(int)gasAlarmMapper.countByExample(example);
		
		int totalPage=totalCount/pageSize;
		if(totalCount%pageSize!=0) {
			totalPage++;
		}
		if(totalCount-pageStart<pageSize) {
			pageSize=totalCount-pageStart;
		}
		example.setPageStart(pageStart);
		example.setPageSize(pageSize);
		
		List<GasAlarm> list = selectByPageMapper.selectGasAlarmByExampleAndPage(example);

		Map<String,Object> pageInfo = new HashMap<String,Object>();		
				  
		pageInfo.put("code", 0);	
		
		pageInfo.put("msg", pageSize);
		pageInfo.put("count", totalCount);
		pageInfo.put("data", list);
		return pageInfo;
	}


	@Override
	public Map<String, Object> selectGasFaultByExampleAndPage(GasFault gasFault, int page, int limit) {
		// TODO Auto-generated method stub
		int pageSize = limit;
		int pageNum = page-1;
		int pageStart = pageNum*pageSize;
		
		GasFaultExamplePageInfo example=null;

		example = new GasFaultExamplePageInfo();
		GasFaultExamplePageInfo.Criteria criteria = example.createCriteria(); 
		
		int totalCount=(int)gasFaultMapper.countByExample(example);
		
		int totalPage=totalCount/pageSize;
		if(totalCount%pageSize!=0) {
			totalPage++;
		}
		if(totalCount-pageStart<pageSize) {
			pageSize=totalCount-pageStart;
		}
		example.setPageStart(pageStart);
		example.setPageSize(pageSize);
		
		List<GasFault> list = selectByPageMapper.selectGasFaultByExampleAndPage(example);

		Map<String,Object> pageInfo = new HashMap<String,Object>();		
				  
		pageInfo.put("code", 0);	
		
		pageInfo.put("msg", pageSize);
		pageInfo.put("count", totalCount);
		pageInfo.put("data", list);
		return pageInfo;
	}


	@Override
	public Map<String, Object> selectGasDataByExampleAndPage(GasData gasData, int page, int limit) {
		// TODO Auto-generated method stub
		int pageSize = limit;
		int pageNum = page-1;
		int pageStart = pageNum*pageSize;
		
		GasDataExamplePageInfo example=null;

		example = new GasDataExamplePageInfo();
		GasDataExamplePageInfo.Criteria criteria = example.createCriteria(); 
		
		int totalCount=(int)gasDataMapper.countByExample(example);
		
		int totalPage=totalCount/pageSize;
		if(totalCount%pageSize!=0) {
			totalPage++;
		}
		if(totalCount-pageStart<pageSize) {
			pageSize=totalCount-pageStart;
		}
		example.setPageStart(pageStart);
		example.setPageSize(pageSize);
		
		List<GasData> list = selectByPageMapper.selectGasDataByExampleAndPage(example);
		Map<String,Object> pageInfo = new HashMap<String,Object>();			  
		pageInfo.put("code", 0);	
		
		pageInfo.put("msg", pageSize);
		pageInfo.put("count", totalCount);
		pageInfo.put("data", list);
		return pageInfo;
	}

	@Override
	public int deleteGasAlarmInfo(int id) {
		// TODO Auto-generated method stub
		return gasAlarmMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int deleteBatchGasAlarmInfo(List<Integer> ids) {
		// TODO Auto-generated method stub
		GasAlarmExample example = new GasAlarmExample();
		GasAlarmExample.Criteria criteria = example.createCriteria(); 
		criteria.andIdIn(ids);
		return gasAlarmMapper.deleteByExample(example);
	}

	@Override
	public Map<String,Object> selectGasAlarmDetailInfo(int id) {
		// TODO Auto-generated method stub
		GasAlarm gasAlarm = gasAlarmMapper.selectByPrimaryKey(id);
	    Calendar calendar = new GregorianCalendar(); 
	    calendar.setTime(gasAlarm.getStartTime()); 
	    calendar.add(Calendar.MINUTE,10);
	    Date startTime = calendar.getTime();
	    Date stopTime;
	    if(gasAlarm.getStopTime()!=null) {
		    calendar.setTime(gasAlarm.getStopTime()); 
		    calendar.add(Calendar.MINUTE,10);
		    stopTime=calendar.getTime();
	    }else {
		    calendar.setTime(gasAlarm.getStartTime()); 
		    calendar.add(Calendar.HOUR,1);	
		    stopTime=calendar.getTime();
	    }
	    
		GasDataExamplePageInfo example=null;

		example = new GasDataExamplePageInfo();
		GasDataExamplePageInfo.Criteria criteria = example.createCriteria(); 
		criteria.andProduceTimeBetween(startTime, stopTime);
		criteria.andDetectorIdEqualTo(gasAlarm.getDetectorId());
		example.setPageSize(2000);
		example.setPageStart(0);
		List<GasData> list = selectByPageMapper.selectGasDataByExampleAndPage(example); 
		
		//int totalCount=(int)gasDataMapper.countByExample(example);	    
	    Map<String,Object> map = new HashMap<String,Object>();
		return map;
	}
}
