package com.pcm.mina.service.handler;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.mina.core.session.IoSession;

import com.anfu.gas.global.GlobalData;
import com.anfu.gas.pojo.GasAlarm;
import com.anfu.gas.pojo.GasData;
import com.anfu.gas.pojo.GasDetector;
import com.anfu.gas.pojo.GasFault;
import com.anfu.gas.service.GasDeviceStatusDataService;
import com.pcm.mina.service.model.ReplyBody;

/**
 * @author ZERO
 * @Description  推送消息
 */ 
public class GetStatusDataHandlerBak implements RequestHandler {
	@Resource(name="gasDeviceStatusDataService")
	GasDeviceStatusDataService gasDeviceStatusDataService;
    protected final Logger logger = Logger.getLogger(GetStatusDataHandlerBak.class);
    public ReplyBody process(IoSession session, ReplyBody reply) {
        int hostId=Integer.valueOf((String)reply.get(GlobalData.hostId));//reply.getData().get(Message.SESSION_KEY);
        int detectorId=Integer.valueOf((String)reply.get(GlobalData.detectorId));
        int hostAddress=hostId;
        int detectorAddress=detectorId; 
        Boolean updateFlag=false;//gasDetector信息更新标志
        GasDetector gasDetector = gasDeviceStatusDataService.selectGasDecectorById(detectorId);
        System.out.println(gasDetector);
        //--------------------处理报警信息-------------------------------------
        int alarmStatus = Integer.valueOf((String)reply.get(GlobalData.alarmStatus));
        System.out.println("alarmStatus:"+alarmStatus);
        System.out.println("gasDetector.getAlarmStatus():"+gasDetector.getAlarmStatus());
        if(alarmStatus!=(int)gasDetector.getAlarmStatus()) {
        	updateFlag=true;
        	gasDetector.setAlarmStatus((byte) alarmStatus);
        	GasAlarm gasAlarm= new GasAlarm();
        	gasAlarm.setDetectorId(detectorId);
        	gasAlarm.setHostId(hostId);
        	gasAlarm.setHostAddress(hostAddress);
        	gasAlarm.setDetectorAddress(detectorAddress);
        	gasAlarm.setDetailInfo(reply.get(GlobalData.gasConcentration));
        	gasAlarm.setType((byte)alarmStatus);
        	gasAlarm.setStartTime(new Date());
        	//gasAlarm.setStopTime(new Date());
            if(alarmStatus==0) {
            	//报警恢复
            	
            	if(session.getAttribute(GlobalData.MinaSessionKey.CURRENT_ALARM_ID)!=null) {
            		int currentArarmId=Integer.valueOf((Integer)session.getAttribute(GlobalData.MinaSessionKey.CURRENT_ALARM_ID));
            		GasAlarm tempGasAlarm=new GasAlarm();
            		tempGasAlarm.setId(currentArarmId);
            		tempGasAlarm.setStopTime(new Date());
            		gasDeviceStatusDataService.updateGasAlarm(tempGasAlarm);
            	}else {
            		logger.error("当前报警信息ID为空："+reply.toString());
            	}
            	session.setAttribute(GlobalData.MinaSessionKey.CURRENT_ALARM_ID, null);
            }else if(alarmStatus==1) {
            	gasDeviceStatusDataService.insertGasAlarm(gasAlarm);
            	System.out.println("新报警信息ID："+gasAlarm.getId());
            	//保存当前报警信息ID，以便用于报警结束时更新报警信息	
            	session.setAttribute(GlobalData.MinaSessionKey.CURRENT_ALARM_ID, gasAlarm.getId());
        	}else if(alarmStatus==2) {
        		gasDeviceStatusDataService.insertGasAlarm(gasAlarm);
        		System.out.println("新报警信息ID："+gasAlarm.getId());
        		//保存当前报警信息ID，以便用于报警结束时更新报警信息	
            	session.setAttribute(GlobalData.MinaSessionKey.CURRENT_ALARM_ID, gasAlarm.getId());	
        	}else {
        		logger.error("收到错误报警状态值："+reply.toString());
        	}        	
        }else {
        	logger.error("报警信息状态未改变！："+reply.toString());
        }
        //--------------------处理故障信息-------------------------------------        
        int faultStatus = Integer.valueOf((String)reply.get(GlobalData.faultStatus));
        System.out.println("faultStatus:"+faultStatus);
        System.out.println("gasDetector.getFaultStatus():"+gasDetector.getFaultStatus());
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
            		gasDeviceStatusDataService.updateGasFault(tempGasFault);
            	}else {
            		logger.error("当前故障信息ID为空："+reply.toString());
            	}
            	session.setAttribute(GlobalData.MinaSessionKey.CURRENT_FAULT_ID, null);
            }else if(faultStatus<8){
            	gasDeviceStatusDataService.insertGasFault(gasFault);
            	System.out.println("新故障信息ID："+gasFault.getId());
            	//保存当前报警信息ID，以便用于报警结束时更新报警信息	
            	session.setAttribute(GlobalData.MinaSessionKey.CURRENT_FAULT_ID, gasFault.getId());
            }else {
        		logger.error("收到错误故障状态值："+reply.toString());
        	}        	
        }else {
        	logger.error("故障信息状态未改变！："+reply.toString());
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
    	
    	gasDeviceStatusDataService.insertGasData(gasData);
        
        if(updateFlag) {
        	gasDeviceStatusDataService.updateGasDetectorStatus(gasDetector);
        }
        if(session !=null){
        	logger.info("收到"+reply.getKey()+"反馈信息："+reply.toString());
        }else{

        }
        return reply;
    }
}
