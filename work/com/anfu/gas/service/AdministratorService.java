package com.anfu.gas.service;


import java.util.List;
import java.util.Map;
import com.anfu.gas.pojo.Admin;
import com.anfu.gas.pojo.GasHost;
import com.zhongzhi.location.pojo.MemberQueryParam;

public interface AdministratorService {
	public Map<String, Object> selectAdministratorByExampleAndPage(Admin administrator,int page,int limit);
}
