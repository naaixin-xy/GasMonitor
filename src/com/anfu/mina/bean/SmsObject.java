package com.anfu.mina.bean;

public class SmsObject {
	private String sender;// 短信发送者
	private String receiver;// 短信接受者
	private String message;// 短信内容

	public synchronized String getSender() {
		return sender;
	}

	public synchronized void setSender(String sender) {
		this.sender = sender;
	}

	public synchronized String getReceiver() {
		return receiver;
	}

	public synchronized void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public synchronized String getMessage() {
		return message;
	}

	public synchronized void setMessage(String message) {
		this.message = message;
	}
}
