package com.anfu.mina.command.client;

import com.anfu.mina.command.ParentCommand;

public class SendDayData extends ParentCommand{
	private String hostId;
	private String hostAddr;
	private String deteId;
	private String deteAddr;
	private String dataType;
	private String dayAveData;
	private String dayMaxData;

	private String dataTime;
	private String dataContent;
	
	public SendDayData(String questNumber, String system, String commandName, String password, String machineNumber, String replyFlag, String hostId, String hostAddr, String deteId, String deteAddr,
			String dataType, String dayAveData, String dayMaxData, String dataTime, String dataContent) {
		super(questNumber, system, commandName, password, machineNumber, replyFlag);
		this.hostId = hostId;
		this.hostAddr = hostAddr;
		this.deteId = deteId;
		this.deteAddr = deteAddr;
		this.dataType = dataType;
		this.dayAveData = dayAveData;
		this.dayMaxData = dayMaxData;
		this.dataTime = dataTime;
		this.dataContent = dataContent;
	}
	public SendDayData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SendDayData(String questNumber, String system, String commandName, String password, String machineNumber, String replyFlag) {
		super(questNumber, system, commandName, password, machineNumber, replyFlag);
		// TODO Auto-generated constructor stub
	}
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
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getDayAveData() {
		return dayAveData;
	}
	public void setDayAveData(String dayAveData) {
		this.dayAveData = dayAveData;
	}
	public String getDayMaxData() {
		return dayMaxData;
	}
	public void setDayMaxData(String dayMaxData) {
		this.dayMaxData = dayMaxData;
	}
	public String getDataTime() {
		return dataTime;
	}
	public void setDataTime(String dataTime) {
		this.dataTime = dataTime;
	}
	public String getDataContent() {
		return dataContent;
	}
	public void setDataContent(String dataContent) {
		this.dataContent = dataContent;
	}
	@Override
	public String toString() {
		return "SendDayData [hostId=" + hostId + ", hostAddr=" + hostAddr + ", deteId=" + deteId + ", deteAddr=" + deteAddr + ", dataType=" + dataType + ", dayAveData=" + dayAveData + ", dayMaxData="
				+ dayMaxData + ", dataTime=" + dataTime + ", dataContent=" + dataContent + "]" + " : " + super.toString();
	}
}
