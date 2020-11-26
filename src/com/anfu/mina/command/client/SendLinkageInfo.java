package com.anfu.mina.command.client;

import com.anfu.mina.command.ParentCommand;

public class SendLinkageInfo extends ParentCommand{
	private String hostId;
	private String hostAddr;
	private String deteId;
	private String deteAddr;
	private String linkageType;
	private String linkageNote;
	private String linkageTime;

	public SendLinkageInfo(String questNumber, String system, String commandName, String password, String machineNumber, String replyFlag, String hostId, String hostAddr, String deteId,
			String deteAddr, String linkageType, String linkageNote, String linkageTime) {
		super(questNumber, system, commandName, password, machineNumber, replyFlag);
		this.hostId = hostId;
		this.hostAddr = hostAddr;
		this.deteId = deteId;
		this.deteAddr = deteAddr;
		this.linkageType = linkageType;
		this.linkageNote = linkageNote;
		this.linkageTime = linkageTime;
	}
	public SendLinkageInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SendLinkageInfo(String questNumber, String system, String commandName, String password, String machineNumber, String replyFlag) {
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
	public String getLinkageType() {
		return linkageType;
	}
	public void setLinkageType(String linkageType) {
		this.linkageType = linkageType;
	}
	public String getLinkageNote() {
		return linkageNote;
	}
	public void setLinkageNote(String linkageNote) {
		this.linkageNote = linkageNote;
	}
	public String getLinkageTime() {
		return linkageTime;
	}
	public void setLinkageTime(String linkageTime) {
		this.linkageTime = linkageTime;
	}
	@Override
	public String toString() {
		return "SendLinkageInfo [hostId=" + hostId + ", hostAddr=" + hostAddr + ", deteId=" + deteId + ", deteAddr=" + deteAddr + ", linkageType=" + linkageType + ", linkageNote=" + linkageNote
				+ ", linkageTime=" + linkageTime + "]" + " : " + super.toString();
	}
}
