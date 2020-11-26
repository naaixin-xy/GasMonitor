package com.anfu.gas.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anfu.gas.mapper.AdminMapper;
import com.anfu.gas.mapper.self.SelectByPageMapper;
import com.anfu.gas.pojo.Admin;
import com.anfu.gas.pojo.self.AdminExamplePageInfo;
import com.anfu.gas.service.AdministratorService;

@Service("administratorService")
public class AdministratorServiceImpl implements AdministratorService{
	@Autowired
	AdminMapper administratorMapper;
	@Autowired
	SelectByPageMapper selectByPageMapper;	
	
	@Override
	public Map<String, Object> selectAdministratorByExampleAndPage(Admin administrator, int page, int limit) {
		// TODO Auto-generated method stub
		int pageSize = limit;
		int pageNum = page-1;
		int pageStart = pageNum*pageSize;
		
		AdminExamplePageInfo example=null;

		example = new AdminExamplePageInfo();
		AdminExamplePageInfo.Criteria criteria = example.createCriteria(); 
		
		int totalCount=(int)administratorMapper.countByExample(example);
		
		int totalPage=totalCount/pageSize;
		if(totalCount%pageSize!=0) {
			totalPage++;
		}
		if(totalCount-pageStart<pageSize) {
			pageSize=totalCount-pageStart;
		}
		example.setPageStart(pageStart);
		example.setPageSize(pageSize);
		
		List<Admin> list = selectByPageMapper.selectAdminByExampleAndPage(example);

		Map<String,Object> pageInfo = new HashMap<String,Object>();		
				  
		pageInfo.put("code", 0);	
		
		pageInfo.put("msg", pageSize);
		pageInfo.put("count", totalCount);
		pageInfo.put("data", list);
		return pageInfo;
	}
	
}
