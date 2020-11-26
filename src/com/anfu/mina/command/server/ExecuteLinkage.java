package com.anfu.mina.command.server;

import com.anfu.mina.command.ParentCommand;

public class ExecuteLinkage extends ParentCommand{
	private String hostId;
	private String hostAddr;
	private String deteId;
	private String deteAddr;
	private String operateTarget;

	public ExecuteLinkage(String questNumber, String system, String commandName, String password, String machineNumber, String replyFlag, String hostId, String hostAddr, String deteId,
			String deteAddr, String operateTarget) {
		super(questNumber, system, commandName, password, machineNumber, replyFlag);
		this.hostId = hostId;
		this.hostAddr = hostAddr;
		this.deteId = deteId;
		this.deteAddr = deteAddr;
		this.operateTarget = operateTarget;
	}
	public ExecuteLinkage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExecuteLinkage(String questNumber, String system, String commandName, String password, String machineNumber, String replyFlag) {
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
	public String getOperateTarget() {
		return operateTarget;
	}
	public void setOperateTarget(String operateTarget) {
		this.operateTarget = operateTarget;
	}
	@Override
	public String toString() {
		return "ExecuteLinkage [hostId=" + hostId + ", hostAddr=" + hostAddr + ", deteId=" + deteId + ", deteAddr=" + deteAddr + ", operateTarget=" + operateTarget + "]" + " : " + super.toString();
	}
	
}
