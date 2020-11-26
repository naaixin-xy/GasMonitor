package com.anfu.mina.command.client;

import com.anfu.mina.command.ParentCommand;

public class SendFaultInfo extends ParentCommand{
	private String hostId;
	private String hostAddr;
	private String deteId;
	private String deteAddr;
	private String faultType;
	private String faultAction;
	private String faultNote;
	private String faultTime;
	private String faultContent;

	public SendFaultInfo(String questNumber, String system, String commandName, String password, String machineNumber, String replyFlag, String hostId, String hostAddr, String deteId, String deteAddr,
			String faultType, String faultAction, String faultNote, String faultTime, String faultContent) {
		super(questNumber, system, commandName, password, machineNumber, replyFlag);
		this.hostId = hostId;
		this.hostAddr = hostAddr;
		this.deteId = deteId;
		this.deteAddr = deteAddr;
		this.faultType = faultType;
		this.faultAction = faultAction;
		this.faultNote = faultNote;
		this.faultTime = faultTime;
		this.faultContent = faultContent;
	}
	public SendFaultInfo(String questNumber, String system, String commandName, String password, String machineNumber, String replyFlag) {
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
	public String getFaultType() {
		return faultType;
	}
	public void setFaultType(String faultType) {
		this.faultType = faultType;
	}
	public String getFaultAction() {
		return faultAction;
	}
	public void setFaultAction(String faultAction) {
		this.faultAction = faultAction;
	}
	public String getFaultNote() {
		return faultNote;
	}
	public void setFaultNote(String faultNote) {
		this.faultNote = faultNote;
	}
	public String getFaultTime() {
		return faultTime;
	}
	public void setFaultTime(String faultTime) {
		this.faultTime = faultTime;
	}
	public String getFaultContent() {
		return faultContent;
	}
	public void setFaultContent(String faultContent) {
		this.faultContent = faultContent;
	}
	public SendFaultInfo(){
		
	}
	public SendFaultInfo(String hostId, String hostAddr, String deteId, String deteAddr, String faultType, String faultAction, String faultNote, String faultTime, String faultContent) {
		super();
		this.hostId = hostId;
		this.hostAddr = hostAddr;
		this.deteId = deteId;
		this.deteAddr = deteAddr;
		this.faultType = faultType;
		this.faultAction = faultAction;
		this.faultNote = faultNote;
		this.faultTime = faultTime;
		this.faultContent = faultContent;
	}
	@Override
	public String toString() {
		return "SendFaultInfo [hostId=" + hostId + ", hostAddr=" + hostAddr + ", deteId=" + deteId + ", deteAddr=" + deteAddr + ", faultType=" + faultType + ", faultAction=" + faultAction
				+ ", faultNote=" + faultNote + ", faultTime=" + faultTime + ", faultContent=" + faultContent + "]" + " : " + super.toString();
	}

}
