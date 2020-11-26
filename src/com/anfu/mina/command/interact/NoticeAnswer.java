package com.anfu.mina.command.interact;

import com.anfu.mina.command.ParentCommand;

public class NoticeAnswer extends ParentCommand{
	private String noticeReturn;
	public String getNoticeReturn() {
		return noticeReturn;
	}
	public void setNoticeReturn(String noticeReturn) {
		this.noticeReturn = noticeReturn;
	}
	@Override
	public String toString() {
		return "NoticeAnswer [noticeReturn=" + noticeReturn + "]" + " : " + super.toString();
	}
	public NoticeAnswer(String questNumber, String system, String commandName, String password, String machineNumber, String replyFlag, String noticeReturn) {
		super(questNumber, system, commandName, password, machineNumber, replyFlag);
		this.noticeReturn = noticeReturn;
	}
	public NoticeAnswer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NoticeAnswer(String questNumber, String system, String commandName, String password, String machineNumber, String replyFlag) {
		super(questNumber, system, commandName, password, machineNumber, replyFlag);
		// TODO Auto-generated constructor stub
	}
	
}
