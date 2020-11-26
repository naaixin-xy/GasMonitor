package com.anfu.mina.command.client;

import com.anfu.mina.command.ParentCommand;

public class SendMonthData extends ParentCommand{
	private String hostId;
	private String hostAddr;
	private String deteId;
	private String deteAddr;
	private String dataType;
	private String monthAveData;
	private String monthMaxData;

	private String dataTime;
	private String monthContent;
	
	
	public SendMonthData(String questNumber, String system, String commandName, String password, String machineNumber, String replyFlag, String hostId, String hostAddr, String deteId, String deteAddr,
			String dataType, String monthAveData, String monthMaxData, String dataTime, String monthContent) {
		super(questNumber, system, commandName, password, machineNumber, replyFlag);
		this.hostId = hostId;
		this.hostAddr = hostAddr;
		this.deteId = deteId;
		this.deteAddr = deteAddr;
		this.dataType = dataType;
		this.monthAveData = monthAveData;
		this.monthMaxData = monthMaxData;
		this.dataTime = dataTime;
		this.monthContent = monthContent;
	}
	public SendMonthData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SendMonthData(String questNumber, String system, String commandName, String password, String machineNumber, String replyFlag) {
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
	public String getMonthAveData() {
		return monthAveData;
	}
	public void setMonthAveData(String monthAveData) {
		this.monthAveData = monthAveData;
	}
	public String getMonthMaxData() {
		return monthMaxData;
	}
	public void setMonthMaxData(String monthMaxData) {
		this.monthMaxData = monthMaxData;
	}
	public String getDataTime() {
		return dataTime;
	}
	public void setDataTime(String dataTime) {
		this.dataTime = dataTime;
	}
	public String getMonthContent() {
		return monthContent;
	}
	public void setMonthContent(String monthContent) {
		this.monthContent = monthContent;
	}
	@Override
	public String toString() {
		return "SendMonthData [hostId=" + hostId + ", hostAddr=" + hostAddr + ", deteId=" + deteId + ", deteAddr=" + deteAddr + ", dataType=" + dataType + ", monthAveData=" + monthAveData
				+ ", monthMaxData=" + monthMaxData + ", dataTime=" + dataTime + ", monthContent=" + monthContent + "]" + " : " + super.toString();
	}
}
