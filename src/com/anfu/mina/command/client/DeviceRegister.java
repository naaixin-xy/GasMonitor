package com.anfu.mina.command.client;

import java.util.HashMap;
import java.util.Map;

import com.anfu.mina.command.ParentCommand;

public class DeviceRegister extends ParentCommand{
	private String hostId;
	private String hostAddr;
	private Map<String,String> deteMap;
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
	public Map<String, String> getDeteMap() {
		return deteMap;
	}
	public void setDeteMap(Map<String, String> deteMap) {
		this.deteMap = deteMap;
	}
	public DeviceRegister(String questNumber, String system, String commandName, String password, String machineNumber, String replyFlag, String hostId, String hostAddr, Map<String, String> deteMap) {
		super(questNumber, system, commandName, password, machineNumber, replyFlag);
		this.hostId = hostId;
		this.hostAddr = hostAddr;
		this.deteMap = deteMap;
	}
	public DeviceRegister(String questNumber, String system, String commandName, String password, String machineNumber, String replyFlag) {
		super(questNumber, system, commandName, password, machineNumber, replyFlag);
		// TODO Auto-generated constructor stub
	}
	public DeviceRegister(){
		deteMap = new HashMap<String,String>();
	}
	@Override
	public String toString() {
		return "DeviceRegister [hostId=" + hostId + ", hostAddr=" + hostAddr + ", deteMap=" + deteMap +  "]" + " : " + super.toString();
	}
}
