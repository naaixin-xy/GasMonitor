package com.anfu.mina.command.client;

import com.anfu.mina.command.ParentCommand;

public class SendHourData extends ParentCommand{
	private String hostId;
	private String hostAddr;
	private String deteId;
	private String deteAddr;
	private String dataType;
	private String hourAveData;
	private String hourMaxData;
	private String dataTime;
	private String dataHour;
	
	public SendHourData(String questNumber, String system, String commandName, String password, String machineNumber, String replyFlag, String hostId, String hostAddr, String deteId, String deteAddr,
			String dataType, String hourAveData, String hourMaxData, String dataTime, String dataHour) {
		super(questNumber, system, commandName, password, machineNumber, replyFlag);
		this.hostId = hostId;
		this.hostAddr = hostAddr;
		this.deteId = deteId;
		this.deteAddr = deteAddr;
		this.dataType = dataType;
		this.hourAveData = hourAveData;
		this.hourMaxData = hourMaxData;
		this.dataTime = dataTime;
		this.dataHour = dataHour;
	}
	public SendHourData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SendHourData(String questNumber, String system, String commandName, String password, String machineNumber, String replyFlag) {
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
	public String getHourAveData() {
		return hourAveData;
	}
	public void setHourAveData(String hourAveData) {
		this.hourAveData = hourAveData;
	}
	public String getHourMaxData() {
		return hourMaxData;
	}
	public void setHourMaxData(String hourMaxData) {
		this.hourMaxData = hourMaxData;
	}
	public String getDataTime() {
		return dataTime;
	}
	public void setDataTime(String dataTime) {
		this.dataTime = dataTime;
	}
	public String getDataHour() {
		return dataHour;
	}
	public void setDataHour(String dataHour) {
		this.dataHour = dataHour;
	}
	@Override
	public String toString() {
		return "SendHourData [hostId=" + hostId + ", hostAddr=" + hostAddr + ", deteId=" + deteId + ", deteAddr=" + deteAddr + ", dataType=" + dataType + ", hourAveData=" + hourAveData
				+ ", hourMaxData=" + hourMaxData + ", dataTime=" + dataTime + ", dataHour=" + dataHour + "]" + " : " + super.toString();
	}
}
