package com.anfu.mina.bean;

public class SmsObject {
	private String sender;// ���ŷ�����
	private String receiver;// ���Ž�����
	private String message;// ��������

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
