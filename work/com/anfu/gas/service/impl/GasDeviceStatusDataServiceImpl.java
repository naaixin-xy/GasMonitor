package com.anfu.gas.service.impl;

import java.util.Date;
import java.util.List;

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
import com.anfu.gas.pojo.GasFault;
import com.anfu.gas.service.GasDeviceStatusDataService;
import com.pcm.mina.service.model.ReplyBody;
@Service("gasDeviceStatusDataService")
public class GasDeviceStatusDataServiceImpl implements GasDeviceStatusDataService{
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
	protected final Logger logger = Logger.getLogger(GasDeviceStatusDataServiceImpl.class);
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
	public int processGetStatusData(IoSession session, ReplyBody reply) {
		// TODO Auto-generated method stub
        int hostId=Integer.valueOf((String)reply.get(GlobalData.hostId));//reply.getData().get(Message.SESSION_KEY);
        int detectorId=Integer.valueOf((String)reply.get(GlobalData.detectorId));
        int hostAddress=hostId;
        int detectorAddress=detectorId; 
        Boolean updateFlag=false;//gasDetector信息更新标志
        GasDetector gasDetector = selectGasDecectorById(detectorId);
        logger.debug(gasDetector);
        //--------------------处理报警信息-------------------------------------
        int alarmStatus = Integer.valueOf((String)reply.get(GlobalData.alarmStatus));
        logger.debug("alarmStatus:"+alarmStatus);
        logger.debug("gasDetector.getAlarmStatus():"+gasDetector.getAlarmStatus());
        if(alarmStatus!=(int)gasDetector.getAlarmStatus()) {

        	updateFlag=true;
        	GasAlarm gasAlarm= new GasAlarm();
        	gasAlarm.setDetectorId(detectorId);
        	gasAlarm.setHostId(hostId);
        	gasAlarm.setHostAddress(hostAddress);
        	gasAlarm.setDetectorAddress(detectorAddress);
        	gasAlarm.setAlarmDataValue(Integer.valueOf(reply.get(GlobalData.gasConcentration)));
        	gasAlarm.setType((byte)alarmStatus);
        	gasAlarm.setStartTime(new Date());
        	gasAlarm.setProvinceId(gasDetector.getProvinceId());
        	gasAlarm.setCityId(gasDetector.getCityId());
        	gasAlarm.setAreaId(gasDetector.getAreaId());
        	gasAlarm.setStreetId(gasDetector.getStreetId());
        	gasAlarm.setEnterpriseId(gasDetector.getEnterpriseId());
        	gasAlarm.setProvinceName(gasDetector.getProvinceName());
        	gasAlarm.setCityName(gasDetector.getCityName());
        	gasAlarm.setAreaName(gasDetector.getAreaName());
        	gasAlarm.setStreetName(gasDetector.getStreetName());
        	gasAlarm.setEnterpriseName(gasDetector.getEnterpriseName());
        	gasAlarm.setLocation(gasDetector.getLocation());
        	gasAlarm.setLongitude(gasDetector.getLongitude());
        	gasAlarm.setLatitude(gasDetector.getLatitude());

        	//gasAlarm.setStopTime(new Date());
            if(alarmStatus==0) {
            	//报警恢复
            	if(session.getAttribute(GlobalData.MinaSessionKey.CURRENT_ALARM_ID)!=null) {
            		int currentArarmId=Integer.valueOf((Integer)session.getAttribute(GlobalData.MinaSessionKey.CURRENT_ALARM_ID));
            		GasAlarm tempGasAlarm=new GasAlarm();
            		tempGasAlarm.setId(currentArarmId);
            		tempGasAlarm.setStopTime(new Date());
            		updateGasAlarm(tempGasAlarm);
            	}else {
            		logger.error("当前报警信息ID为空："+reply.toString());
            	}
            	session.setAttribute(GlobalData.MinaSessionKey.CURRENT_ALARM_ID, null);
            }else if(alarmStatus==1) {
            	if(gasDetector.getAlarmStatus()==2) {
            		int currentArarmId=Integer.valueOf((Integer)session.getAttribute(GlobalData.MinaSessionKey.CURRENT_ALARM_ID));
            		GasAlarm tempGasAlarm=new GasAlarm();
            		tempGasAlarm.setId(currentArarmId);
            		tempGasAlarm.setStopTime(new Date());
            		updateGasAlarm(tempGasAlarm);            		
            	}
            	insertGasAlarm(gasAlarm);
            	logger.debug("新报警信息ID："+gasAlarm.getId());
            	//保存当前报警信息ID，以便用于报警结束时更新报警信息	
            	session.setAttribute(GlobalData.MinaSessionKey.CURRENT_ALARM_ID, gasAlarm.getId());
        	}else if(alarmStatus==2) {
            	if(gasDetector.getAlarmStatus()==1) {
            		int currentArarmId=Integer.valueOf((Integer)session.getAttribute(GlobalData.MinaSessionKey.CURRENT_ALARM_ID));
            		GasAlarm tempGasAlarm=new GasAlarm();
            		tempGasAlarm.setId(currentArarmId);
            		tempGasAlarm.setStopTime(new Date());
            		updateGasAlarm(tempGasAlarm);            		
            	} 
            	insertGasAlarm(gasAlarm);
            	logger.debug("新报警信息ID："+gasAlarm.getId());
        		//保存当前报警信息ID，以便用于报警结束时更新报警信息	
            	session.setAttribute(GlobalData.MinaSessionKey.CURRENT_ALARM_ID, gasAlarm.getId());	
        	}else {
        		logger.error("收到错误报警状态值："+reply.toString());
        	} 
            gasDetector.setAlarmStatus((byte) alarmStatus);
        }else {
        	logger.debug("报警信息状态未改变！："+reply.toString());
        }
        //--------------------处理故障信息-------------------------------------        
        int faultStatus = Integer.valueOf((String)reply.get(GlobalData.faultStatus));
        logger.debug("faultStatus:"+faultStatus);
        logger.debug("gasDetector.getFaultStatus():"+gasDetector.getFaultStatus());
        if(faultStatus!=(int)gasDetector.getFaultStatus()) {
        	updateFlag=true;
        	gasDetector.setFaultStatus((byte) faultStatus);
        	GasFault gasFault= new GasFault();
        	gasFault.setDetectorId(String.valueOf(detectorId));
        	gasFault.setHostId(String.valueOf(hostId));
        	gasFault.setHostAddress(String.valueOf(hostAddress));
        	gasFault.setDetectorAddress(String.valueOf(detectorAddress));
        	gasFault.setDetailInfo(reply.get(GlobalData.gasConcentration));
        	gasFault.setType((byte)faultStatus);
        	gasFault.setStartTime(new Date());
        	//gasAlarm.setStopTime(new Date());
            if(faultStatus==0) {
            	//故障恢复
            	
            	if(session.getAttribute(GlobalData.MinaSessionKey.CURRENT_FAULT_ID)!=null) {
            		int currentFaultId=Integer.valueOf((Integer)session.getAttribute(GlobalData.MinaSessionKey.CURRENT_FAULT_ID));
            		GasFault tempGasFault=new GasFault();
            		tempGasFault.setId(currentFaultId);
            		tempGasFault.setStopTime(new Date());
            		updateGasFault(tempGasFault);
            	}else {
            		logger.error("当前故障信息ID为空："+reply.toString());
            	}
            	session.setAttribute(GlobalData.MinaSessionKey.CURRENT_FAULT_ID, null);
            }else if(faultStatus<8){
            	insertGasFault(gasFault);
            	logger.debug("新故障信息ID："+gasFault.getId());
            	//保存当前报警信息ID，以便用于报警结束时更新报警信息	
            	session.setAttribute(GlobalData.MinaSessionKey.CURRENT_FAULT_ID, gasFault.getId());
            }else {
        		logger.error("收到错误故障状态值："+reply.toString());
        	}        	
        }else {
        	logger.debug("故障信息状态未改变！："+reply.toString());
        }
        
        //--------------------处理数据信息------------------------------------- 
        
    	gasDetector.setCurrentValue(Integer.valueOf(reply.get(GlobalData.gasConcentration)));
    	GasData gasData= new GasData();
    	gasData.setDetectorId(detectorId);
    	gasData.setHostId(hostId);
    	gasData.setHostAddress(hostAddress);
    	gasData.setDetectorAddress(detectorAddress);
    	gasData.setDataValue(Integer.valueOf(reply.get(GlobalData.gasConcentration)));
    	gasData.setType(0);
    	gasData.setProduceTime(new Date()); 
    	insertGasData(gasData);
        
        if(updateFlag) {
        	updateGasDetectorStatus(gasDetector);
        }
        if(session !=null){
        	logger.debug("收到"+reply.getKey()+"反馈信息："+reply.toString());
        }else{

        }		
		return 0;
	}
}
