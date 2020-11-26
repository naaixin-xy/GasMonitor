package com.anfu.gas.pojo.self.parameter;

public class HualuDalianUploadParamter {
	private String userName;
	private String password;
	private String command;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public HualuDalianUploadParamter(String userName, String password, String command) {
		super();
		this.userName = userName;
		this.password = password;
		this.command = command;
	}
}
