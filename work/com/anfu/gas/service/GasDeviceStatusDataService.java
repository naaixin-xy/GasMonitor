package com.anfu.gas.service;

import java.util.List;

import org.apache.mina.core.session.IoSession;

import com.anfu.gas.pojo.GasAlarm;
import com.anfu.gas.pojo.GasData;
import com.anfu.gas.pojo.GasDetector;
import com.anfu.gas.pojo.GasFault;
import com.pcm.mina.service.model.ReplyBody;

public interface GasDeviceStatusDataService {
	public int insertGasAlarm(GasAlarm gasAlarm);
	public int insertGasFault(GasFault gasFault);
	public int insertGasData(GasData gasData);
	public int updateGasAlarm(GasAlarm gasAlarm);
	public int updateGasFault(GasFault gasFault);
	public int updateGasDetectorStatus(GasDetector gasDetector);
	public GasDetector selectGasDecectorById(int id);
	public int processGetStatusData(IoSession session, ReplyBody reply);
}
