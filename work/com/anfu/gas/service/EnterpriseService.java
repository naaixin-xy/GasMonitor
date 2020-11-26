package com.anfu.gas.service;

import java.util.Map;

import com.anfu.gas.pojo.Enterprise;
import com.anfu.gas.pojo.SubArea;

public interface EnterpriseService {
	public Map<String, Object> selectEnterpriseByExampleAndPage(Enterprise enterprise,int page,int limit);
	public Map<String, Object> selectSubAreaByExampleAndPage(SubArea subArea,int page,int limit);
}
