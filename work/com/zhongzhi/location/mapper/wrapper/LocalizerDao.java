package com.zhongzhi.location.mapper.wrapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.zhongzhi.location.mapper.LocalizerMapper;
import com.zhongzhi.location.pojo.Localizer;
import com.zhongzhi.location.pojo.LocalizerQueryParam;

public class LocalizerDao {
	//@Autowired
	LocalizerMapper localizerMapper;
	
	public LocalizerMapper getLocalizerMapper() {
		return localizerMapper;
	}
	public void setLocalizerMapper(LocalizerMapper localizerMapper) {
		this.localizerMapper = localizerMapper;
	}
	public List<Localizer> localizerQuery(Localizer local){
		System.out.println("localizerQuerywervice!");
		List<Localizer> list = localizerMapper.localizerQuery(local);
		//System.out.println(list);
		return list;
	}
	public Map<String,Object> getLocalizerByPage(LocalizerQueryParam queryParam) {
		//queryParam
		int pageSize = queryParam.getPageSize();
		int pageNum = queryParam.getPageNum();
		int pageStart = pageNum*pageSize;
		queryParam.setPageStart(pageStart);
		int totalCount=localizerMapper.getLocalizerCount(queryParam);
		
		int totalPage=totalCount/pageSize;
		if(totalCount%pageSize!=0) {
			totalPage++;
		}
		if(totalCount-pageStart<pageSize) {
			pageSize=totalCount-pageStart;
			queryParam.setPageSize(pageSize);
		}
		int pageEnd=pageStart+pageSize;
		System.out.println(totalCount);
		
		List<Localizer> localizers=localizerMapper.localizerQueryByPage(queryParam);
		Map<String,Object> pageInfo = new HashMap<String,Object>();
		Map<String,Object> headerInfo = new HashMap<String,Object>();
		headerInfo.put("order", "序号");
		headerInfo.put("select", "选择");
		headerInfo.put("id", "ID");
		headerInfo.put("account", "帐户");
		headerInfo.put("password", "密码");
		headerInfo.put("category", "类型");
		headerInfo.put("name", "姓名");
		headerInfo.put("parentId", "父用户ID");
		headerInfo.put("phone", "电话");
		headerInfo.put("deviceCount", "设备数量");
		headerInfo.put("contact", "联系人");
		headerInfo.put("createTime", "创建时间");
		headerInfo.put("modifyTime", "上次修改时间");
		headerInfo.put("remark", "备注");

		
		
		pageInfo.put("pageSize", pageSize);
		pageInfo.put("pageNum", pageNum);
		pageInfo.put("pageStart", pageStart);
		pageInfo.put("pageEnd", pageEnd);
		pageInfo.put("totalPage", totalPage);
		pageInfo.put("totalCount", totalCount);
		pageInfo.put("dataInfo", localizers);
		pageInfo.put("headerInfo", headerInfo);
		pageInfo.put("test", "测试数据2");
		System.out.println(pageInfo);
		return pageInfo;
	}
	public int localizerAdd(Localizer local){
		return localizerMapper.localizerAdd(local);
	}

	public int localizerDelete(int id) {
		return localizerMapper.localizerDelete(id);
	}
	public int localizerBatchDelete(List<Integer> ids) {
		return localizerMapper.localizerDeleteBatch(ids);
	}	
	public int localizerModify(Localizer local) {
		//System.out.println("localizerModify");
		return localizerMapper.localizerUpdate(local);
	}
}
