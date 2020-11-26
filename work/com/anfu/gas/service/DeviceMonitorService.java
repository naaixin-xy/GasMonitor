package com.anfu.gas.service;

import java.util.List;
import java.util.Map;

import com.anfu.gas.pojo.GasAlarm;
import com.anfu.gas.pojo.GasData;
import com.anfu.gas.pojo.GasFault;
import com.anfu.gas.pojo.self.parameter.GasAlarmParameter;

public interface DeviceMonitorService {

	public int deleteGasAlarmInfo(int id);
	public int deleteBatchGasAlarmInfo(List<Integer> ids);
	public Map<String, Object> selectGasAlarmDetailInfo(int id);
	
	public Map<String, Object> selectGasAlarmByExampleAndPage(GasAlarmParameter gasAlarmParameter);
	public Map<String, Object> selectGasFaultByExampleAndPage(GasFault gasFault,int page,int limit);
	public Map<String, Object> selectGasDataByExampleAndPage(GasData gasData,int page,int limit);
	
}
