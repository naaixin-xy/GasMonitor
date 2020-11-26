package com.anfu.gas.service;

import java.util.List;
import java.util.Map;

import com.anfu.gas.pojo.GasAlarm;
import com.anfu.gas.pojo.GasData;
import com.anfu.gas.pojo.GasDetector;
import com.anfu.gas.pojo.GasFault;
import com.anfu.gas.pojo.self.HualuDalianUploadParamter;

public interface ExternalInterfaceService {
	public int insertGasAlarm(GasAlarm gasAlarm);
	public int insertGasFault(GasFault gasFault);
	public int insertGasData(GasData gasData);
	public int updateGasAlarm(GasAlarm gasAlarm);
	public int updateGasFault(GasFault gasFault);
	public int updateGasDetectorStatus(GasDetector gasDetector);
	public GasDetector selectGasDecectorById(int id);
	public List<GasDetector> selectAllGasDecector(GasDetector gasDetector);
	public Map<String,Object> HunluDalianUpload(HualuDalianUploadParamter hualuDalianUploadParamter);
}
