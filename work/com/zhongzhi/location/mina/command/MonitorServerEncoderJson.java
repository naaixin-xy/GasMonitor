package com.zhongzhi.location.mina.command;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.apache.mina.filter.codec.demux.MessageEncoder;


import com.anfu.mina.command.ParentCommand;
import com.anfu.mina.command.interact.ExecuteResult;
import com.anfu.mina.command.interact.NoticeAnswer;
import com.anfu.mina.command.interact.RequestAnswer;

public class MonitorServerEncoderJson implements MessageEncoder<ParentCommand> {
	@Override
	public void encode(IoSession session, ParentCommand message, ProtocolEncoderOutput out) throws Exception {
		String commandString;
		if (message instanceof ExecuteResult) {
			commandString = makeExecuteResult((ExecuteResult)message);
		}else if(message instanceof RequestAnswer){
			commandString = makeRequestAnswer((RequestAnswer)message);			
		}else if(message instanceof NoticeAnswer){
			commandString = makeNoticeAnswer((NoticeAnswer)message);			
		}else{	
			//无效命令
			return;
		}
		if(commandString==null){
			Exception e = new Exception();
			throw e;
		}else{
			IoBuffer buffer= IoBuffer.allocate(4).setAutoExpand(true);
			buffer.putString(commandString,Charset.forName("UTF-8").newEncoder());
			buffer.flip();
			out.write(buffer);
		}
	}
	
	private String makeExecuteResult(ExecuteResult command) {
		return "";
	}
	
	private String makeRequestAnswer(RequestAnswer command) {
		return "";
	}
	
	private String makeNoticeAnswer(NoticeAnswer command) {
		return "";
	}		
}
