package com.zhongzhi.location.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.zhongzhi.location.mapper.wrapper.LocalizerDao;
import com.zhongzhi.location.pojo.Localizer;
import com.zhongzhi.location.pojo.LocalizerQueryParam;

public class LocalizerService {
	@Autowired
	LocalizerDao localizerDao;
	
	public Map<String,String> localizerOverdueTimeSet(int id, int addTime) {
		System.out.println("addTime:"+addTime);
		Map<String,String> map =new HashMap<String,String>();
		Localizer local=new Localizer();
		local.setId(id);
		Date overdueDate=localizerDao.localizerQuery(local).get(0).getActiveTime();
		//Date date=new   Date ();//取时间 
	    Calendar calendar = new GregorianCalendar(); 
	    calendar.setTime(overdueDate); 
	    calendar.add(Calendar.DATE,addTime);
	    local.setDueTime(calendar.getTime());
	    
	    System.out.println(calendar.getTime());
	    if(localizerDao.localizerModify(local)>0) {
	    	map.put("result", "success");
	    }else{
	    	map.put("result", "fail");
	    };
		return map;
	}	
	public List<Localizer> localizerQuery(Localizer local){
		List<Localizer> list = localizerDao.localizerQuery(local);
		//System.out.println(list);
		return list;
	}
	public Map<String,Object> getLocalizerByPage(LocalizerQueryParam queryParam) {
		//queryParam
		
		return localizerDao.getLocalizerByPage(queryParam);
	}
	public int localizerAdd(Localizer local){
		return localizerDao.localizerAdd(local);
	}

	public int localizerDelete(int id) {
		return localizerDao.localizerDelete(id);
	}
	public int localizerBatchDelete(List<Integer> ids) {
		return localizerDao.localizerBatchDelete(ids);
	}	
	public int localizerModify(Localizer local) {
		//System.out.println("localizerModify");
		return localizerDao.localizerModify(local);
	}	
}
