package com.pcm.mina.command;

import com.anfu.gas.global.GlobalData;
import com.pcm.mina.client.MinaDemo.MinaClient;
import com.pcm.mina.service.model.ReplyBody;
import com.pcm.mina.service.model.SentBody;

public class ClientCommand {
	public static ReplyBody makeGetStatusDataReplyCommand(MinaClient client,SentBody sentBody) {
		ReplyBody replyBody=new ReplyBody();
		replyBody.setKey(sentBody.getKey());
		replyBody.setCode(GlobalData.ReturnCode.EXECUTE_SUCCESS);
		replyBody.put(GlobalData.requestNumber, sentBody.get(GlobalData.requestNumber));
		replyBody.put(GlobalData.hostId, client.getHostId());
		replyBody.put(GlobalData.detectorId, client.getDetectorId());
		replyBody.put(GlobalData.alarmStatus, client.getAlarmStatus());
		replyBody.put(GlobalData.faultStatus, client.getFaultStatus());
		replyBody.put(GlobalData.maskStatus, client.getMaskStatus());		
		replyBody.put(GlobalData.gasConcentration, client.getGasConcentration());		
		replyBody.put(GlobalData.highAlarmBound, client.getHighAlarmAbound());		
		replyBody.put(GlobalData.lowAlarmBound, client.getLowAlarmAbound());
		replyBody.put(GlobalData.relayStatus, client.getRelayStatus());	

		return replyBody;
	}
	
	public static ReplyBody makeResetReplyCommand(MinaClient client,SentBody sentBody) {	
		
		ReplyBody replyBody=new ReplyBody();
		replyBody.setKey(sentBody.getKey());
		replyBody.setCode(GlobalData.ReturnCode.EXECUTE_SUCCESS);
		replyBody.put(GlobalData.requestNumber, sentBody.get(GlobalData.requestNumber));
		replyBody.put(GlobalData.hostId, client.getHostId());
		replyBody.put(GlobalData.detectorId, client.getDetectorId());
		
		return replyBody;
	}
	
	public static ReplyBody makeStopSoundReplyCommand(MinaClient client,SentBody sentBody) {
		ReplyBody replyBody=new ReplyBody();
		replyBody.setKey(sentBody.getKey());
		replyBody.setCode(GlobalData.ReturnCode.EXECUTE_SUCCESS);
		replyBody.put(GlobalData.requestNumber, sentBody.get(GlobalData.requestNumber));
		replyBody.put(GlobalData.hostId, client.getHostId());
		replyBody.put(GlobalData.detectorId, client.getDetectorId());
		
		return replyBody;
	}
	
	public static ReplyBody makeGetAlarmBoundReplyCommand(MinaClient client,SentBody sentBody) {
		ReplyBody replyBody=new ReplyBody();
		replyBody.setKey(sentBody.getKey());
		replyBody.setCode(GlobalData.ReturnCode.EXECUTE_SUCCESS);
		replyBody.put(GlobalData.requestNumber, sentBody.get(GlobalData.requestNumber));
		replyBody.put(GlobalData.hostId, client.getHostId());
		replyBody.put(GlobalData.detectorId, client.getDetectorId());
		replyBody.put(GlobalData.highAlarmBound, client.getHighAlarmAbound());
		replyBody.put(GlobalData.lowAlarmBound, client.getLowAlarmAbound());
		return replyBody;
	}
	
	public static ReplyBody makeSetAlarmBoundReplyCommand(MinaClient client,SentBody sentBody) {
		ReplyBody replyBody=new ReplyBody();
		replyBody.setKey(sentBody.getKey());
		replyBody.setCode(GlobalData.ReturnCode.EXECUTE_SUCCESS);
		replyBody.put(GlobalData.requestNumber, sentBody.get(GlobalData.requestNumber));
		replyBody.put(GlobalData.hostId, client.getHostId());
		replyBody.put(GlobalData.detectorId, client.getDetectorId());
		return replyBody;
	}
	public static ReplyBody makeStartPumpReplyCommand(MinaClient client,SentBody sentBody) {
		ReplyBody replyBody=new ReplyBody();
		replyBody.setKey(sentBody.getKey());
		replyBody.setCode(GlobalData.ReturnCode.EXECUTE_SUCCESS);
		replyBody.put(GlobalData.requestNumber, sentBody.get(GlobalData.requestNumber));
		replyBody.put(GlobalData.hostId, client.getHostId());
		replyBody.put(GlobalData.detectorId, client.getDetectorId());
		return replyBody;
	}
	/*
	 * ******************************************************************************************************
	 * 二次修改新增命令
	 ******************************************************************************************************
	 */
	public static ReplyBody makeGetHighAlarmBoundReplyCommand(MinaClient client,SentBody sentBody) {
		ReplyBody replyBody=new ReplyBody();
		replyBody.setKey(sentBody.getKey());
		replyBody.setCode(GlobalData.ReturnCode.EXECUTE_SUCCESS);
		replyBody.put(GlobalData.requestNumber, sentBody.get(GlobalData.requestNumber));
		replyBody.put(GlobalData.hostId, client.getHostId());
		replyBody.put(GlobalData.detectorId, client.getDetectorId());
		replyBody.put(GlobalData.highAlarmBound, client.getHighAlarmAbound());
		return replyBody;
	}
	public static ReplyBody makeSetHighAlarmBoundReplyCommand(MinaClient client,SentBody sentBody) {
		ReplyBody replyBody=new ReplyBody();
		replyBody.setKey(sentBody.getKey());
		replyBody.setCode(GlobalData.ReturnCode.EXECUTE_SUCCESS);
		replyBody.put(GlobalData.requestNumber, sentBody.get(GlobalData.requestNumber));
		replyBody.put(GlobalData.hostId, client.getHostId());
		replyBody.put(GlobalData.detectorId, client.getDetectorId());
		return replyBody;
	}
	public static ReplyBody makeGetLowAlarmBoundReplyCommand(MinaClient client,SentBody sentBody) {
		ReplyBody replyBody=new ReplyBody();
		replyBody.setKey(sentBody.getKey());
		replyBody.setCode(GlobalData.ReturnCode.EXECUTE_SUCCESS);
		replyBody.put(GlobalData.requestNumber, sentBody.get(GlobalData.requestNumber));
		replyBody.put(GlobalData.hostId, client.getHostId());
		replyBody.put(GlobalData.detectorId, client.getDetectorId());
		replyBody.put(GlobalData.lowAlarmBound, client.getLowAlarmAbound());
		return replyBody;
	}
	public static ReplyBody makeSetLowAlarmBoundReplyCommand(MinaClient client,SentBody sentBody) {
		ReplyBody replyBody=new ReplyBody();
		replyBody.setKey(sentBody.getKey());
		replyBody.setCode(GlobalData.ReturnCode.EXECUTE_SUCCESS);
		replyBody.put(GlobalData.requestNumber, sentBody.get(GlobalData.requestNumber));
		replyBody.put(GlobalData.hostId, client.getHostId());
		replyBody.put(GlobalData.detectorId, client.getDetectorId());
		return replyBody;
	}
	public static ReplyBody makeGetMaskThresholdReplyCommand(MinaClient client,SentBody sentBody) {
		ReplyBody replyBody=new ReplyBody();
		replyBody.setKey(sentBody.getKey());
		replyBody.setCode(GlobalData.ReturnCode.EXECUTE_SUCCESS);
		replyBody.put(GlobalData.requestNumber, sentBody.get(GlobalData.requestNumber));
		replyBody.put(GlobalData.hostId, client.getHostId());
		replyBody.put(GlobalData.detectorId, client.getDetectorId());
		replyBody.put(GlobalData.maskThreshold, client.getMaskThreshold());
		return replyBody;
	}
	public static ReplyBody makeSetMaskThresholdReplyCommand(MinaClient client,SentBody sentBody) {
		ReplyBody replyBody=new ReplyBody();
		replyBody.setKey(sentBody.getKey());
		replyBody.setCode(GlobalData.ReturnCode.EXECUTE_SUCCESS);
		replyBody.put(GlobalData.requestNumber, sentBody.get(GlobalData.requestNumber));
		replyBody.put(GlobalData.hostId, client.getHostId());
		replyBody.put(GlobalData.detectorId, client.getDetectorId());
		return replyBody;
	}
	public static ReplyBody makeGetPumpRunTimeReplyCommand(MinaClient client,SentBody sentBody) {
		ReplyBody replyBody=new ReplyBody();
		replyBody.setKey(sentBody.getKey());
		replyBody.setCode(GlobalData.ReturnCode.EXECUTE_SUCCESS);
		replyBody.put(GlobalData.requestNumber, sentBody.get(GlobalData.requestNumber));
		replyBody.put(GlobalData.hostId, client.getHostId());
		replyBody.put(GlobalData.detectorId, client.getDetectorId());
		replyBody.put(GlobalData.pumpRunTime, client.getPumpRunTime());
		return replyBody;
	}
	public static ReplyBody makeSetPumpRunTimeReplyCommand(MinaClient client,SentBody sentBody) {
		ReplyBody replyBody=new ReplyBody();
		replyBody.setKey(sentBody.getKey());
		replyBody.setCode(GlobalData.ReturnCode.EXECUTE_SUCCESS);
		replyBody.put(GlobalData.requestNumber, sentBody.get(GlobalData.requestNumber));
		replyBody.put(GlobalData.hostId, client.getHostId());
		replyBody.put(GlobalData.detectorId, client.getDetectorId());
		return replyBody;
	}
	public static ReplyBody makeGetPumpPeriodReplyCommand(MinaClient client,SentBody sentBody) {
		ReplyBody replyBody=new ReplyBody();
		replyBody.setKey(sentBody.getKey());
		replyBody.setCode(GlobalData.ReturnCode.EXECUTE_SUCCESS);
		replyBody.put(GlobalData.requestNumber, sentBody.get(GlobalData.requestNumber));
		replyBody.put(GlobalData.hostId, client.getHostId());
		replyBody.put(GlobalData.detectorId, client.getDetectorId());
		replyBody.put(GlobalData.pumpPeriod, client.getPumpPeriod());
		return replyBody;
	}
	public static ReplyBody makeSetPumpPeriodReplyCommand(MinaClient client,SentBody sentBody) {
		ReplyBody replyBody=new ReplyBody();
		replyBody.setKey(sentBody.getKey());
		replyBody.setCode(GlobalData.ReturnCode.EXECUTE_SUCCESS);
		replyBody.put(GlobalData.requestNumber, sentBody.get(GlobalData.requestNumber));
		replyBody.put(GlobalData.hostId, client.getHostId());
		replyBody.put(GlobalData.detectorId, client.getDetectorId());
		return replyBody;
	}
	public static ReplyBody makeGetFlowDifferenceValueReplyCommand(MinaClient client,SentBody sentBody) {
		ReplyBody replyBody=new ReplyBody();
		replyBody.setKey(sentBody.getKey());
		replyBody.setCode(GlobalData.ReturnCode.EXECUTE_SUCCESS);
		replyBody.put(GlobalData.requestNumber, sentBody.get(GlobalData.requestNumber));
		replyBody.put(GlobalData.hostId, client.getHostId());
		replyBody.put(GlobalData.detectorId, client.getDetectorId());
		replyBody.put(GlobalData.flowDifferenceValue, client.getFlowDifferenceValue());
		return replyBody;
	}
	public static ReplyBody makeSetFlowDifferenceValueReplyCommand(MinaClient client,SentBody sentBody) {
		ReplyBody replyBody=new ReplyBody();
		replyBody.setKey(sentBody.getKey());
		replyBody.setCode(GlobalData.ReturnCode.EXECUTE_SUCCESS);
		replyBody.put(GlobalData.requestNumber, sentBody.get(GlobalData.requestNumber));
		replyBody.put(GlobalData.hostId, client.getHostId());
		replyBody.put(GlobalData.detectorId, client.getDetectorId());
		return replyBody;
	}
	public static ReplyBody makeGetWaterInletFaultThresholdReplyCommand(MinaClient client,SentBody sentBody) {
		ReplyBody replyBody=new ReplyBody();
		replyBody.setKey(sentBody.getKey());
		replyBody.setCode(GlobalData.ReturnCode.EXECUTE_SUCCESS);
		replyBody.put(GlobalData.requestNumber, sentBody.get(GlobalData.requestNumber));
		replyBody.put(GlobalData.hostId, client.getHostId());
		replyBody.put(GlobalData.detectorId, client.getDetectorId());
		replyBody.put(GlobalData.waterInletFaultThreshold, client.getWaterInletFaultThreshold());
		return replyBody;
	}
	public static ReplyBody makeSetWaterInletFaultThresholdReplyCommand(MinaClient client,SentBody sentBody) {
		ReplyBody replyBody=new ReplyBody();
		replyBody.setKey(sentBody.getKey());
		replyBody.setCode(GlobalData.ReturnCode.EXECUTE_SUCCESS);
		replyBody.put(GlobalData.requestNumber, sentBody.get(GlobalData.requestNumber));
		replyBody.put(GlobalData.hostId, client.getHostId());
		replyBody.put(GlobalData.detectorId, client.getDetectorId());
		return replyBody;
	}
	public static ReplyBody makeGetFlowFaultThresholdReplyCommand(MinaClient client,SentBody sentBody) {
		ReplyBody replyBody=new ReplyBody();
		replyBody.setKey(sentBody.getKey());
		replyBody.setCode(GlobalData.ReturnCode.EXECUTE_SUCCESS);
		replyBody.put(GlobalData.requestNumber, sentBody.get(GlobalData.requestNumber));
		replyBody.put(GlobalData.hostId, client.getHostId());
		replyBody.put(GlobalData.detectorId, client.getDetectorId());
		replyBody.put(GlobalData.flowFaultThreshold, client.getFlowDifferenceValue());
		return replyBody;
	}
	public static ReplyBody makeSetFlowFaultThresholdReplyCommand(MinaClient client,SentBody sentBody) {
		ReplyBody replyBody=new ReplyBody();
		replyBody.setKey(sentBody.getKey());
		replyBody.setCode(GlobalData.ReturnCode.EXECUTE_SUCCESS);
		replyBody.put(GlobalData.requestNumber, sentBody.get(GlobalData.requestNumber));
		replyBody.put(GlobalData.hostId, client.getHostId());
		replyBody.put(GlobalData.detectorId, client.getDetectorId());
		return replyBody;
	}
	public static ReplyBody makeGetSensorFaultThresholdReplyCommand(MinaClient client,SentBody sentBody) {
		ReplyBody replyBody=new ReplyBody();
		replyBody.setKey(sentBody.getKey());
		replyBody.setCode(GlobalData.ReturnCode.EXECUTE_SUCCESS);
		replyBody.put(GlobalData.requestNumber, sentBody.get(GlobalData.requestNumber));
		replyBody.put(GlobalData.hostId, client.getHostId());
		replyBody.put(GlobalData.detectorId, client.getDetectorId());
		replyBody.put(GlobalData.sensorFaultThreshold, client.getSensorFaultThreshold());
		return replyBody;
	}
	public static ReplyBody makeSetSensorFaultThresholdReplyCommand(MinaClient client,SentBody sentBody) {
		ReplyBody replyBody=new ReplyBody();
		replyBody.setKey(sentBody.getKey());
		replyBody.setCode(GlobalData.ReturnCode.EXECUTE_SUCCESS);
		replyBody.put(GlobalData.requestNumber, sentBody.get(GlobalData.requestNumber));
		replyBody.put(GlobalData.hostId, client.getHostId());
		replyBody.put(GlobalData.detectorId, client.getDetectorId());
		return replyBody;
	}
	public static ReplyBody makeGetStaticFlowValueReplyCommand(MinaClient client,SentBody sentBody) {
		ReplyBody replyBody=new ReplyBody();
		replyBody.setKey(sentBody.getKey());
		replyBody.setCode(GlobalData.ReturnCode.EXECUTE_SUCCESS);
		replyBody.put(GlobalData.requestNumber, sentBody.get(GlobalData.requestNumber));
		replyBody.put(GlobalData.hostId, client.getHostId());
		replyBody.put(GlobalData.detectorId, client.getDetectorId());
		replyBody.put(GlobalData.staticFlowValue, client.getStaticFlowValue());
		return replyBody;
	}
	public static ReplyBody makeGetDynamicFlowValueReplyCommand(MinaClient client,SentBody sentBody) {
		ReplyBody replyBody=new ReplyBody();
		replyBody.setKey(sentBody.getKey());
		replyBody.setCode(GlobalData.ReturnCode.EXECUTE_SUCCESS);
		replyBody.put(GlobalData.requestNumber, sentBody.get(GlobalData.requestNumber));
		replyBody.put(GlobalData.hostId, client.getHostId());
		replyBody.put(GlobalData.detectorId, client.getDetectorId());
		replyBody.put(GlobalData.dynamicFlowValue, client.getDynamicFlowValue());
		return replyBody;
	}
	public static ReplyBody makeCalibrateZeroSpotReplyCommand(MinaClient client,SentBody sentBody) {
		ReplyBody replyBody=new ReplyBody();
		replyBody.setKey(sentBody.getKey());
		replyBody.setCode(GlobalData.ReturnCode.EXECUTE_SUCCESS);
		replyBody.put(GlobalData.requestNumber, sentBody.get(GlobalData.requestNumber));
		replyBody.put(GlobalData.hostId, client.getHostId());
		replyBody.put(GlobalData.detectorId, client.getDetectorId());
		return replyBody;
	}	
}
