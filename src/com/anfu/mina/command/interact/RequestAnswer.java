package com.anfu.mina.command.interact;

import com.anfu.mina.command.ParentCommand;

public class RequestAnswer extends ParentCommand{
	private String requestReturn;
	public String getRequestReturn() {
		return requestReturn;
	}
	public void setRequestReturn(String requestReturn) {
		this.requestReturn = requestReturn;
	}
	@Override
	public String toString() {
		return "RequestAnswer [requestReturn=" + requestReturn + "]" + " : " + super.toString();
	}
	public RequestAnswer(String questNumber, String system, String commandName, String password, String machineNumber, String replyFlag, String requestReturn) {
		super(questNumber, system, commandName, password, machineNumber, replyFlag);
		this.requestReturn = requestReturn;
	}
	public RequestAnswer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RequestAnswer(String questNumber, String system, String commandName, String password, String machineNumber, String replyFlag) {
		super(questNumber, system, commandName, password, machineNumber, replyFlag);
		// TODO Auto-generated constructor stub
	}
}
