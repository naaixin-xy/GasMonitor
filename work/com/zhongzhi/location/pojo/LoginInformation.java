package com.zhongzhi.location.pojo;

public class LoginInformation {
	String loginName;
	int loginType;
	String password;
	String identifyingCode;
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public int getLoginType() {
		return loginType;
	}
	public void setLoginType(int loginType) {
		this.loginType = loginType;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIdentifyingCode() {
		return identifyingCode;
	}
	public void setIdentifyingCode(String identifyingCode) {
		this.identifyingCode = identifyingCode;
	}
	@Override
	public String toString() {
		return "LoginInformation [loginName=" + loginName + ", loginType=" + loginType + ", password=" + password
				+ ", identifyingCode=" + identifyingCode + "]";
	}	
	
}
