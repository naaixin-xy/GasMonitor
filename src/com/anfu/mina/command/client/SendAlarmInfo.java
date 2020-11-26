package com.anfu.mina.command.client;

import com.anfu.mina.command.ParentCommand;

public class SendAlarmInfo extends ParentCommand{
	private String hostId;
	private String hostAddr;
	private String deteId;
	private String deteAddr;
	private String alarmType;
	private String alarmAction;
	private String alarmData;
	private String alarmTime;
	private String alarmContent;
	public String getHostId() {
		return hostId;
	}
	public void setHostId(String hostId) {
		this.hostId = hostId;
	}
	public String getHostAddr() {
		return hostAddr;
	}
	public void setHostAddr(String hostAddr) {
		this.hostAddr = hostAddr;
	}
	public String getDeteId() {
		return deteId;
	}
	public void setDeteId(String deteId) {
		this.deteId = deteId;
	}
	public String getDeteAddr() {
		return deteAddr;
	}
	public void setDeteAddr(String deteAddr) {
		this.deteAddr = deteAddr;
	}
	public String getAlarmType() {
		return alarmType;
	}
	public void setAlarmType(String alarmType) {
		this.alarmType = alarmType;
	}
	public String getAlarmAction() {
		return alarmAction;
	}
	public void setAlarmAction(String alarmAction) {
		this.alarmAction = alarmAction;
	}
	public String getAlarmData() {
		return alarmData;
	}
	public void setAlarmData(String alarmData) {
		this.alarmData = alarmData;
	}
	public String getAlarmTime() {
		return alarmTime;
	}
	public void setAlarmTime(String alarmTime) {
		this.alarmTime = alarmTime;
	}
	public String getAlarmContent() {
		return alarmContent;
	}
	public void setAlarmContent(String alarmContent) {
		this.alarmContent = alarmContent;
	}
	
	public SendAlarmInfo(String questNumber, String system, String commandName, String password, String machineNumber, String replyFlag, String hostId, String hostAddr, String deteId, String deteAddr,
			String alarmType, String alarmAction, String alarmData, String alarmTime, String alarmContent) {
		super(questNumber, system, commandName, password, machineNumber, replyFlag);
		this.hostId = hostId;
		this.hostAddr = hostAddr;
		this.deteId = deteId;
		this.deteAddr = deteAddr;
		this.alarmType = alarmType;
		this.alarmAction = alarmAction;
		this.alarmData = alarmData;
		this.alarmTime = alarmTime;
		this.alarmContent = alarmContent;
	}
	public SendAlarmInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SendAlarmInfo(String questNumber, String system, String commandName, String password, String machineNumber, String replyFlag) {
		super(questNumber, system, commandName, password, machineNumber, replyFlag);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SendAlarmInfo [hostId=" + hostId + ", hostAddr=" + hostAddr + ", deteId=" + deteId + ", deteAddr=" + deteAddr + ", alarmType=" + alarmType + ", alarmAction=" + alarmAction
				+ ", alarmData=" + alarmData + ", alarmTime=" + alarmTime + ", alarmContent=" + alarmContent + "]" + " : " + super.toString();
	}
}
