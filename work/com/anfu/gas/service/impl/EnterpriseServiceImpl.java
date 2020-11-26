package com.anfu.gas.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anfu.gas.mapper.EnterpriseMapper;
import com.anfu.gas.mapper.SubAreaMapper;
import com.anfu.gas.mapper.self.SelectByPageMapper;
import com.anfu.gas.pojo.Enterprise;
import com.anfu.gas.pojo.SubArea;
import com.anfu.gas.pojo.self.EnterpriseExamplePageInfo;
import com.anfu.gas.pojo.self.SubAreaExamplePageInfo;
import com.anfu.gas.service.EnterpriseService;

@Service("enterpriseService")
public class EnterpriseServiceImpl implements EnterpriseService{
	@Autowired
	EnterpriseMapper enterpriseMapper;	
	@Autowired
	SubAreaMapper subAreaMapper;
	@Autowired
	SelectByPageMapper selectByPageMapper;	
	@Override
	public Map<String, Object> selectEnterpriseByExampleAndPage(Enterprise enterprise, int page, int limit) {
		// TODO Auto-generated method stub
		int pageSize = limit;
		int pageNum = page-1;
		int pageStart = pageNum*pageSize;
		
		EnterpriseExamplePageInfo example=null;

		example = new EnterpriseExamplePageInfo();
		EnterpriseExamplePageInfo.Criteria criteria = example.createCriteria(); 
		
		int totalCount=(int)enterpriseMapper.countByExample(example);
		
		int totalPage=totalCount/pageSize;
		if(totalCount%pageSize!=0) {
			totalPage++;
		}
		if(totalCount-pageStart<pageSize) {
			pageSize=totalCount-pageStart;
		}
		example.setPageStart(pageStart);
		example.setPageSize(pageSize);
		
		List<Enterprise> list = selectByPageMapper.selectEnterpriseByExampleAndPage(example);

		Map<String,Object> pageInfo = new HashMap<String,Object>();		
				  
		pageInfo.put("code", 0);	
		
		pageInfo.put("msg", pageSize);
		pageInfo.put("count", totalCount);
		pageInfo.put("data", list);
		System.out.println("返回主机类型数据："+pageInfo);
		return pageInfo;
	}
	@Override
	public Map<String, Object> selectSubAreaByExampleAndPage(SubArea subArea, int page, int limit) {
		// TODO Auto-generated method stub
		int pageSize = limit;
		int pageNum = page-1;
		int pageStart = pageNum*pageSize;
		
		SubAreaExamplePageInfo example=null;

		example = new SubAreaExamplePageInfo();
		SubAreaExamplePageInfo.Criteria criteria = example.createCriteria(); 
		
		int totalCount=(int)subAreaMapper.countByExample(example);
		
		int totalPage=totalCount/pageSize;
		if(totalCount%pageSize!=0) {
			totalPage++;
		}
		if(totalCount-pageStart<pageSize) {
			pageSize=totalCount-pageStart;
		}
		example.setPageStart(pageStart);
		example.setPageSize(pageSize);
		
		List<SubArea> list = selectByPageMapper.selectSubAreaByExampleAndPage(example);

		Map<String,Object> pageInfo = new HashMap<String,Object>();		
				  
		pageInfo.put("code", 0);	
		
		pageInfo.put("msg", pageSize);
		pageInfo.put("count", totalCount);
		pageInfo.put("data", list);
		System.out.println("返回主机类型数据："+pageInfo);
		return pageInfo;
	}

}
