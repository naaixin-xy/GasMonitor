package com.anfu.gas.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.mina.core.session.IoSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anfu.gas.global.GlobalData;
import com.anfu.gas.mapper.GasAlarmMapper;
import com.anfu.gas.mapper.GasDataMapper;
import com.anfu.gas.mapper.GasDetectorMapper;
import com.anfu.gas.mapper.GasFaultMapper;
import com.anfu.gas.mapper.self.SelectByPageMapper;
import com.anfu.gas.pojo.GasAlarm;
import com.anfu.gas.pojo.GasData;
import com.anfu.gas.pojo.GasDetector;
import com.anfu.gas.pojo.GasDetectorExample;
import com.anfu.gas.pojo.GasFault;
import com.anfu.gas.pojo.self.HualuDalianUploadParamter;
import com.anfu.gas.service.ExternalInterfaceService;
import com.pcm.mina.service.model.ReplyBody;
@Service("externalInterfaceService")
public class ExternalInterfaceServiceImpl implements ExternalInterfaceService{
	@Autowired
	GasAlarmMapper gasAlarmMapper;
	@Autowired
	GasFaultMapper gasFaultMapper;
	@Autowired
	GasDataMapper gasDataMapper;
	@Autowired
	GasDetectorMapper gasDetectorMapper;
	@Autowired
	SelectByPageMapper selectByPageMapper;
	protected final Logger logger = Logger.getLogger(ExternalInterfaceServiceImpl.class);
	@Override
	public int insertGasAlarm(GasAlarm gasAlarm) {
		// TODO Auto-generated method stub
		return gasAlarmMapper.insert(gasAlarm);
	}

	@Override
	public int insertGasFault(GasFault gasFault) {
		// TODO Auto-generated method stub
		return gasFaultMapper.insert(gasFault);
	}

	@Override
	public int insertGasData(GasData gasData) {
		// TODO Auto-generated method stub
		return gasDataMapper.insert(gasData);
	}

	@Override
	public int updateGasDetectorStatus(GasDetector gasDetector) {
		// TODO Auto-generated method stub
		return gasDetectorMapper.updateByPrimaryKeySelective(gasDetector);
	}

	@Override
	public GasDetector selectGasDecectorById(int id) {
		// TODO Auto-generated method stub
		return  gasDetectorMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateGasAlarm(GasAlarm gasAlarm) {
		// TODO Auto-generated method stub
		return gasAlarmMapper.updateByPrimaryKeySelective(gasAlarm);
	}

	@Override
	public int updateGasFault(GasFault gasFault) {
		// TODO Auto-generated method stub
		return gasFaultMapper.updateByPrimaryKeySelective(gasFault);
	}

	@Override
	public List<GasDetector> selectAllGasDecector(GasDetector gasDetector) {
		// TODO Auto-generated method stub
		GasDetectorExample example = new GasDetectorExample();
		GasDetectorExample.Criteria criteria = example.createCriteria();
				
		//Integer enterprise_id = 40;
		criteria.andEnterpriseIdEqualTo(gasDetector.getEnterpriseId()); // 设置条件：ItemId等于40

		List<GasDetector> list = gasDetectorMapper.selectByExample(example);
		return list;
	}

	@Override
	public Map<String, Object> HunluDalianUpload(HualuDalianUploadParamter hualuDalianUploadParamter) {
		// TODO Auto-generated method stub
		Map<String,Object> returnMap = new HashMap<String,Object>();
		if(!"HUALUANFU2019".equals(hualuDalianUploadParamter.getUserName())) {
			returnMap.put("command", "getAllDetectorData");
			returnMap.put("executeResult", "UserNameError");
			
		}else if(!"123456".equals(hualuDalianUploadParamter.getPassword())) {
			returnMap.put("command", "getAllDetectorData");
			returnMap.put("executeResult", "PasswordError");			
			
		}else if(!"getAllDetectorData".equals(hualuDalianUploadParamter.getCommand())) {
			returnMap.put("command", "getAllDetectorData");
			returnMap.put("executeResult", "CommandError");				
			
		}else {
			String[] connectStatusString= {"离线","在线"};
			String[] alarmStatusString= {"正常","低报","高报"};
			String[] faultStatusString= {"正常","进水故障","流量故障","进水故障|流量故障","传感器故障","进水故障|传感器故障","流量故障|传感器故障","进水故障|流量故障|传感器故障"};
			GasDetector gasDetector = new GasDetector();
			gasDetector.setEnterpriseId(256);
			List<GasDetector> gasDetectors = selectAllGasDecector(gasDetector);
			Iterator<GasDetector> it = gasDetectors.iterator();
			List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
			int i=0;
			while (it.hasNext()) {
				gasDetector = it.next();
				Map<String,Object> map =  new HashMap<String,Object>();
				map.put("hostId", gasDetector.getHostId());
				map.put("deteId", gasDetector.getId());
				map.put("realtimeData", gasDetector.getCurrentValue());
				map.put("lowAlarmLimit", gasDetector.getLowAlarm());
				map.put("highAlarmLimit", gasDetector.getHighAlarm());
				map.put("connectStatus", connectStatusString[gasDetector.getConnectionStatus()]);
				map.put("alarmStatus", alarmStatusString[gasDetector.getAlarmStatus()]);
				map.put("faultStatus", faultStatusString[gasDetector.getFaultStatus()]);
				map.put("latitude", gasDetector.getLatitude());
				map.put("longitude", gasDetector.getLatitude());
//				map.put("minValue", gasDetector.getMinValue());
//				map.put("maxValue", gasDetector.getMaxValue());
//				map.put("gasType", gasDetector.getGasType());
//				map.put("gasUint", gasDetector.getGasUnit());
				mapList.add(map);
			}
			returnMap.put("executeResult", "ExecuteSucess");
			returnMap.put("command", "getAllDetectorData");
			returnMap.put("deteInfoList", mapList);			
		}
		return returnMap;
	}
}
