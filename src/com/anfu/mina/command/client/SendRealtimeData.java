package com.anfu.mina.command.client;

import com.anfu.mina.command.ParentCommand;

public class SendRealtimeData extends ParentCommand{
	private String hostId;
	private String hostAddr;
	private String deteId;
	private String deteAddr;
	private String dataType;
	private String realTimeData;
	public SendRealtimeData(String questNumber, String system, String commandName, String password, String machineNumber, String replyFlag, String hostId, String hostAddr, String deteId,
			String deteAddr, String dataType, String realTimeData) {
		super(questNumber, system, commandName, password, machineNumber, replyFlag);
		this.hostId = hostId;
		this.hostAddr = hostAddr;
		this.deteId = deteId;
		this.deteAddr = deteAddr;
		this.dataType = dataType;
		this.realTimeData = realTimeData;
	}	
	public SendRealtimeData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SendRealtimeData(String questNumber, String system, String commandName, String password, String machineNumber, String replyFlag) {
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
	public String getRealTimeData() {
		return realTimeData;
	}
	public void setRealTimeData(String realTimeData) {
		this.realTimeData = realTimeData;
	}
	@Override
	public String toString() {
		return "SendRealtimeData [hostId=" + hostId + ", hostAddr=" + hostAddr + ", deteId=" + deteId + ", deteAddr=" + deteAddr + ", dataType=" + dataType + ", realTimeData=" + realTimeData + "]" + " : " + super.toString();
	}
}
