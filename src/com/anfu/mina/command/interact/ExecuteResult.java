package com.anfu.mina.command.interact;

import com.anfu.mina.command.ParentCommand;

public class ExecuteResult extends ParentCommand{
	private String executeReturn;
	public String getExecuteReturn() {
		return executeReturn;
	}
	public void setExecuteReturn(String executeReturn) {
		this.executeReturn = executeReturn;
	}
	@Override
	public String toString() {
		return "ExecuteResult [executeReturn=" + executeReturn + "]" + " : " + super.toString();
	}
	public ExecuteResult(String questNumber, String system, String commandName, String password, String machineNumber, String replyFlag,String executeReturn) {
		super(questNumber, system, commandName, password, machineNumber, replyFlag);
		this.executeReturn = executeReturn;
	}
	public ExecuteResult() {
		super();
	}
	public ExecuteResult(String questNumber, String system, String commandName, String password, String machineNumber, String replyFlag) {
		super(questNumber, system, commandName, password, machineNumber, replyFlag);
		// TODO Auto-generated constructor stub
	}
}
