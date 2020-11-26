package com.anfu.gas.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anfu.gas.mapper.GasDetectorMapper;
import com.anfu.gas.mapper.GasDetectorTypeMapper;
import com.anfu.gas.mapper.GasHostMapper;
import com.anfu.gas.mapper.GasHostTypeMapper;
import com.anfu.gas.mapper.self.SelectByPageMapper;
import com.anfu.gas.pojo.GasDetector;
import com.anfu.gas.pojo.GasDetectorType;
import com.anfu.gas.pojo.GasHost;
import com.anfu.gas.pojo.GasHostType;
import com.anfu.gas.pojo.self.GasDetectorExamplePageInfo;
import com.anfu.gas.pojo.self.GasDetectorTypeExamplePageInfo;
import com.anfu.gas.pojo.self.GasHostExamplePageInfo;
import com.anfu.gas.pojo.self.GasHostTypeExamplePageInfo;
import com.anfu.gas.service.DeviceManageService;

@Service("deviceManageService")
public class DeviceManageServiceImpl implements DeviceManageService{
	@Autowired
	GasHostMapper gasHostMapper;
	@Autowired
	GasDetectorMapper gasDetectorMapper;
	@Autowired
	SelectByPageMapper selectByPageMapper;
	@Autowired
	GasHostTypeMapper gasHostTypeMapper;	
	@Autowired
	GasDetectorTypeMapper gasDetectorTypeMapper;	
	
	@Override
	public Map<String, Object> selectGasHostByExampleAndPage(GasHost gasHost, int page, int limit) {
		// TODO Auto-generated method stub
		int pageSize = limit;
		int pageNum = page-1;
		int pageStart = pageNum*pageSize;
		
		GasHostExamplePageInfo example=null;

		example = new GasHostExamplePageInfo();
		GasHostExamplePageInfo.Criteria criteria = example.createCriteria(); 
		
		int totalCount=(int)gasHostMapper.countByExample(example);
		
		int totalPage=totalCount/pageSize;
		if(totalCount%pageSize!=0) {
			totalPage++;
		}
		if(totalCount-pageStart<pageSize) {
			pageSize=totalCount-pageStart;
		}
		example.setPageStart(pageStart);
		example.setPageSize(pageSize);
		
		List<GasHost> list = selectByPageMapper.selectGasHostByExampleAndPage(example);

		Map<String,Object> pageInfo = new HashMap<String,Object>();		
				  
		pageInfo.put("code", 0);	
		
		pageInfo.put("msg", pageSize);
		pageInfo.put("count", totalCount);
		pageInfo.put("data", list);
		return pageInfo;
	}
	@Override
	public long countGasHostByExample(GasHost gasHost) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Map<String, Object> selectGasDetectorByExampleAndPage(GasDetector gasDetector, int page, int limit) {
		// TODO Auto-generated method stub
		int pageSize = limit;
		int pageNum = page-1;
		int pageStart = pageNum*pageSize;
		
		GasDetectorExamplePageInfo example=null;

		example = new GasDetectorExamplePageInfo();
		GasDetectorExamplePageInfo.Criteria criteria = example.createCriteria(); 
		
		int totalCount=(int)gasDetectorMapper.countByExample(example);
		
		int totalPage=totalCount/pageSize;
		if(totalCount%pageSize!=0) {
			totalPage++;
		}
		if(totalCount-pageStart<pageSize) {
			pageSize=totalCount-pageStart;
		}
		example.setPageStart(pageStart);
		example.setPageSize(pageSize);
		
		List<GasDetector> list = selectByPageMapper.selectGasDetectorByExampleAndPage(example);

		Map<String,Object> pageInfo = new HashMap<String,Object>();		
				  
		pageInfo.put("code", 0);	
		
		pageInfo.put("msg", pageSize);
		pageInfo.put("count", totalCount);
		pageInfo.put("data", list);
		return pageInfo;
	}
	@Override
	public long countGasDetectorByExample(GasDetector gasDetector) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Map<?, ?> prepareAddDetector(GasDetector gasDetector) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Map<String, Object> selectGasHostTypeByExampleAndPage(GasHostType gasHostType, int page, int limit) {
		// TODO Auto-generated method stub
		int pageSize = limit;
		int pageNum = page-1;
		int pageStart = pageNum*pageSize;
		
		GasHostTypeExamplePageInfo example=null;

		example = new GasHostTypeExamplePageInfo();
		GasHostTypeExamplePageInfo.Criteria criteria = example.createCriteria(); 
		
		int totalCount=(int)gasHostTypeMapper.countByExample(example);
		
		int totalPage=totalCount/pageSize;
		if(totalCount%pageSize!=0) {
			totalPage++;
		}
		if(totalCount-pageStart<pageSize) {
			pageSize=totalCount-pageStart;
		}
		example.setPageStart(pageStart);
		example.setPageSize(pageSize);
		
		List<GasHostType> list = selectByPageMapper.selectGasHostTypeByExampleAndPage(example);

		Map<String,Object> pageInfo = new HashMap<String,Object>();		
				  
		pageInfo.put("code", 0);	
		
		pageInfo.put("msg", pageSize);
		pageInfo.put("count", totalCount);
		pageInfo.put("data", list);
		return pageInfo;
	}
	@Override
	public Map<String, Object> selectGasDetectorTypeByExampleAndPage(GasDetectorType gasDetectorType, int page,
			int limit) {
		// TODO Auto-generated method stub
		int pageSize = limit;
		int pageNum = page-1;
		int pageStart = pageNum*pageSize;
		
		GasDetectorTypeExamplePageInfo example=null;

		example = new GasDetectorTypeExamplePageInfo();
		GasDetectorTypeExamplePageInfo.Criteria criteria = example.createCriteria(); 
		
		int totalCount=(int)gasDetectorTypeMapper.countByExample(example);
		
		int totalPage=totalCount/pageSize;
		if(totalCount%pageSize!=0) {
			totalPage++;
		}
		if(totalCount-pageStart<pageSize) {
			pageSize=totalCount-pageStart;
		}
		example.setPageStart(pageStart);
		example.setPageSize(pageSize);
		
		List<GasDetectorType> list = selectByPageMapper.selectGasDetectorTypeByExampleAndPage(example);

		Map<String,Object> pageInfo = new HashMap<String,Object>();		
				  
		pageInfo.put("code", 0);	
		
		pageInfo.put("msg", pageSize);
		pageInfo.put("count", totalCount);
		pageInfo.put("data", list);
		System.out.println("返回主机类型数据："+pageInfo);
		return pageInfo;
	}
}
