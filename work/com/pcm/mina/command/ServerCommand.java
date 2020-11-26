package com.pcm.mina.command;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.anfu.gas.global.GlobalData;
import com.pcm.mina.service.model.SentBody;

public class ServerCommand {
	public static SentBody makeGetStatusDataSentCommand() {
		SentBody sentBody=new SentBody();
		sentBody.setKey(GlobalData.getStatusData);
		sentBody.put(GlobalData.requestNumber, new SimpleDateFormat("0HHmmssSSS").format(new Date()));
		return sentBody;
	}
	
	public static SentBody makeResetSentCommand() {
		SentBody sentBody=new SentBody();
		sentBody.setKey(GlobalData.reset);
		sentBody.put(GlobalData.requestNumber, new SimpleDateFormat("0HHmmssSSS").format(new Date()));
		return sentBody;
	}
	
	public static SentBody makeStopSoundSentCommand() {
		SentBody sentBody=new SentBody();
		sentBody.setKey(GlobalData.stopSound);
		sentBody.put(GlobalData.requestNumber, new SimpleDateFormat("0HHmmssSSS").format(new Date()));
		return sentBody;
	}
	
	public static SentBody makeGetAlarmBoundSentCommand() {
		SentBody sentBody=new SentBody();
		sentBody.setKey(GlobalData.getAlarmBound);
		sentBody.put(GlobalData.requestNumber, new SimpleDateFormat("0HHmmssSSS").format(new Date()));
		return sentBody;
	}
	
	public static SentBody makeSetAlarmBoundSentCommand(int lowAlarmBound,int highAlarmBound) {
		SentBody sentBody=new SentBody();
		sentBody.setKey(GlobalData.setAlarmBound);
		sentBody.put(GlobalData.requestNumber, new SimpleDateFormat("0HHmmssSSS").format(new Date()));
		sentBody.put(GlobalData.lowAlarmBound, String.format("%08d", lowAlarmBound));
		sentBody.put(GlobalData.highAlarmBound, String.format("%08d", highAlarmBound));
		return sentBody;
	}
	public static SentBody makeStartPumpSentCommand() {
		SentBody sentBody=new SentBody();
		sentBody.setKey(GlobalData.startPump);
		sentBody.put(GlobalData.requestNumber, new SimpleDateFormat("0HHmmssSSS").format(new Date()));
		return sentBody;
	}
	/*
	 * ******************************************************************************************************
	 * 二次修改新增命令
	 ******************************************************************************************************
	 */
	public static SentBody makeGetHighAlarmBoundSentCommand() {
		SentBody sentBody=new SentBody();
		sentBody.setKey(GlobalData.getHighAlarmBound);
		sentBody.put(GlobalData.requestNumber, new SimpleDateFormat("0HHmmssSSS").format(new Date()));
		return sentBody;
	}
	public static SentBody makeSetHighAlarmBoundSentCommand(int highAlarmBound) {
		SentBody sentBody=new SentBody();
		sentBody.setKey(GlobalData.setHighAlarmBound);
		sentBody.put(GlobalData.requestNumber, new SimpleDateFormat("0HHmmssSSS").format(new Date()));
		sentBody.put(GlobalData.highAlarmBound, String.format("%08d", highAlarmBound));
		return sentBody;
	}
	public static SentBody makeGetLowAlarmBoundSentCommand() {
		SentBody sentBody=new SentBody();
		sentBody.setKey(GlobalData.getLowAlarmBound);
		sentBody.put(GlobalData.requestNumber, new SimpleDateFormat("0HHmmssSSS").format(new Date()));
		return sentBody;
	}
	public static SentBody makeSetLowAlarmBoundSentCommand(int lowAlarmBound) {
		SentBody sentBody=new SentBody();
		sentBody.setKey(GlobalData.setLowAlarmBound);
		sentBody.put(GlobalData.requestNumber, new SimpleDateFormat("0HHmmssSSS").format(new Date()));
		sentBody.put(GlobalData.lowAlarmBound, String.format("%08d", lowAlarmBound));
		return sentBody;
	}
	public static SentBody makeGetMaskThresholdSentCommand() {
		SentBody sentBody=new SentBody();
		sentBody.setKey(GlobalData.getMaskThreshold);
		sentBody.put(GlobalData.requestNumber, new SimpleDateFormat("0HHmmssSSS").format(new Date()));
		return sentBody;
	}
	public static SentBody makeSetMaskThresholdSentCommand(int maskThreshold) {
		SentBody sentBody=new SentBody();
		sentBody.setKey(GlobalData.setMaskThreshold);
		sentBody.put(GlobalData.requestNumber, new SimpleDateFormat("0HHmmssSSS").format(new Date()));
		sentBody.put(GlobalData.maskThreshold,String.format("%08d", maskThreshold));
		return sentBody;
	}
	public static SentBody makeGetPumpRunTimeSentCommand() {
		SentBody sentBody=new SentBody();
		sentBody.setKey(GlobalData.getPumpRunTime);
		sentBody.put(GlobalData.requestNumber, new SimpleDateFormat("0HHmmssSSS").format(new Date()));
		return sentBody;
	}
	public static SentBody makeSetPumpRunTimeSentCommand(int pumpRunTime) {
		SentBody sentBody=new SentBody();
		sentBody.setKey(GlobalData.setPumpRunTime);
		sentBody.put(GlobalData.requestNumber, new SimpleDateFormat("0HHmmssSSS").format(new Date()));
		sentBody.put(GlobalData.pumpRunTime, String.format("%04d", pumpRunTime));
		return sentBody;
	}
	public static SentBody makeGetPumpPeriodSentCommand() {
		SentBody sentBody=new SentBody();
		sentBody.setKey(GlobalData.getPumpPeriod);
		sentBody.put(GlobalData.requestNumber, new SimpleDateFormat("0HHmmssSSS").format(new Date()));
		return sentBody;
	}
	public static SentBody makeSetPumpPeriodSentCommand(int pumpPeriod) {
		SentBody sentBody=new SentBody();
		sentBody.setKey(GlobalData.setPumpPeriod);
		sentBody.put(GlobalData.requestNumber, new SimpleDateFormat("0HHmmssSSS").format(new Date()));
		sentBody.put(GlobalData.pumpPeriod, String.format("%08d", pumpPeriod));
		return sentBody;
	}
	public static SentBody makeGetFlowDifferenceValueSentCommand() {
		SentBody sentBody=new SentBody();
		sentBody.setKey(GlobalData.getFlowDifferenceValue);
		sentBody.put(GlobalData.requestNumber, new SimpleDateFormat("0HHmmssSSS").format(new Date()));
		return sentBody;
	}
	public static SentBody makeSetFlowDifferenceValueSentCommand(int flowDifferenceValue) {
		SentBody sentBody=new SentBody();
		sentBody.setKey(GlobalData.setFlowDifferenceValue);
		sentBody.put(GlobalData.requestNumber, new SimpleDateFormat("0HHmmssSSS").format(new Date()));
		sentBody.put(GlobalData.flowDifferenceValue, String.format("%04d", flowDifferenceValue));
		return sentBody;
	}
	public static SentBody makeGetWaterInletFaultThresholdSentCommand() {
		SentBody sentBody=new SentBody();
		sentBody.setKey(GlobalData.getWaterInletFaultThreshold);
		sentBody.put(GlobalData.requestNumber, new SimpleDateFormat("0HHmmssSSS").format(new Date()));
		return sentBody;
	}
	public static SentBody makeSetWaterInletFaultThresholdSentCommand(int waterInletFaultThreshold) {
		SentBody sentBody=new SentBody();
		sentBody.setKey(GlobalData.setWaterInletFaultThreshold);
		sentBody.put(GlobalData.requestNumber, new SimpleDateFormat("0HHmmssSSS").format(new Date()));
		sentBody.put(GlobalData.waterInletFaultThreshold, String.format("%04d", waterInletFaultThreshold));
		return sentBody;
	}
	public static SentBody makeGetFlowFaultThresholdSentCommand() {
		SentBody sentBody=new SentBody();
		sentBody.setKey(GlobalData.getFlowFaultThreshold);
		sentBody.put(GlobalData.requestNumber, new SimpleDateFormat("0HHmmssSSS").format(new Date()));
		return sentBody;
	}
	public static SentBody makeSetFlowFaultThresholdSentCommand(int flowFaultThreshold) {
		SentBody sentBody=new SentBody();
		sentBody.setKey(GlobalData.setFlowFaultThreshold);
		sentBody.put(GlobalData.requestNumber, new SimpleDateFormat("0HHmmssSSS").format(new Date()));
		sentBody.put(GlobalData.flowFaultThreshold, String.format("%04d", flowFaultThreshold));
		return sentBody;
	}
	public static SentBody makeGetSensorFaultThresholdSentCommand() {
		SentBody sentBody=new SentBody();
		sentBody.setKey(GlobalData.getSensorFaultThreshold);
		sentBody.put(GlobalData.requestNumber, new SimpleDateFormat("0HHmmssSSS").format(new Date()));
		return sentBody;
	}
	public static SentBody makeSetSensorFaultThresholdSentCommand(int sensorFaultThreshold) {
		SentBody sentBody=new SentBody();
		sentBody.setKey(GlobalData.setSensorFaultThreshold);
		sentBody.put(GlobalData.requestNumber, new SimpleDateFormat("0HHmmssSSS").format(new Date()));
		sentBody.put(GlobalData.sensorFaultThreshold, String.format("%04d", sensorFaultThreshold));
		return sentBody;
	}
	public static SentBody makeGetStaticFlowValueSentCommand() {
		SentBody sentBody=new SentBody();
		sentBody.setKey(GlobalData.getStaticFlowValue);
		sentBody.put(GlobalData.requestNumber, new SimpleDateFormat("0HHmmssSSS").format(new Date()));
		return sentBody;
	}
	public static SentBody makeGetDynamicFlowValueSentCommand() {
		SentBody sentBody=new SentBody();
		sentBody.setKey(GlobalData.getDynamicFlowValue);
		sentBody.put(GlobalData.requestNumber, new SimpleDateFormat("0HHmmssSSS").format(new Date()));
		return sentBody;
	}
	public static SentBody makeCalibrateZeroSpotSentCommand() {
		SentBody sentBody=new SentBody();
		sentBody.setKey(GlobalData.calibrateZeroSpot);
		sentBody.put(GlobalData.requestNumber, new SimpleDateFormat("0HHmmssSSS").format(new Date()));
		return sentBody;
	}
}
