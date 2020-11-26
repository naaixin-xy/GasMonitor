package com.anfu.gas.service;

import java.util.Map;

import com.anfu.gas.pojo.GasDetector;
import com.anfu.gas.pojo.GasDetectorType;
import com.anfu.gas.pojo.GasHost;
import com.anfu.gas.pojo.GasHostType;

public interface DeviceManageService {
	public Map<String, Object> selectGasHostByExampleAndPage(GasHost gasHost,int page,int limit);
	public long countGasHostByExample(GasHost gasHost);	
	public Map<String, Object> selectGasDetectorByExampleAndPage(GasDetector gasDetector,int page,int limit);
	public long countGasDetectorByExample(GasDetector gasDetector);	
	public Map<?,?> prepareAddDetector(GasDetector gasDetector);
	public Map<String, Object> selectGasHostTypeByExampleAndPage(GasHostType gasHostType,int page,int limit);
	public Map<String, Object> selectGasDetectorTypeByExampleAndPage(GasDetectorType gasDetectorType,int page,int limit);
}
