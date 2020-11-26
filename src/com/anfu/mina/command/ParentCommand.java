package com.anfu.mina.command;


public class ParentCommand {
	private String questNumber;
	private String system;
	private String commandName;
	private String password;
	private String machineNumber;
	private String replyFlag;
	public String getQuestNumber() {
		return questNumber;
	}
	public void setQuestNumber(String questNumber) {
		this.questNumber = questNumber;
	}
	public String getSystem() {
		return system;
	}
	public void setSystem(String system) {
		this.system = system;
	}
	public String getCommandName() {
		return commandName;
	}
	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMachineNumber() {
		return machineNumber;
	}
	public void setMachineNumber(String machineNumber) {
		this.machineNumber = machineNumber;
	}
	public String getReplyFlag() {
		return replyFlag;
	}
	public void setReplyFlag(String replyFlag) {
		this.replyFlag = replyFlag;
	}
	@Override
	public String toString() {
		return "ParentCommand [questNumber=" + questNumber + ", system=" + system + ", commandName=" + commandName + ", password=" + password + ", machineNumber=" + machineNumber + "]";
	}
	public ParentCommand(String questNumber, String system, String commandName, String password, String machineNumber, String replyFlag) {
		super();
		this.questNumber = questNumber;
		this.system = system;
		this.commandName = commandName;
		this.password = password;
		this.machineNumber = machineNumber;
		this.replyFlag = replyFlag;
	}
	public ParentCommand(){
		super();
	}
}
