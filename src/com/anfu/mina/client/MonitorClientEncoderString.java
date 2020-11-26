package com.anfu.mina.client;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Random;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.apache.mina.filter.codec.demux.MessageEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MonitorClientEncoderString implements MessageEncoder<String> {
	private final static Logger log = LoggerFactory.getLogger(MonitorClientEncoderString.class);
	@Override
	public void encode(IoSession session, String message, ProtocolEncoderOutput out) throws Exception {
		String commandString=null;
		if (message instanceof String) {
			commandString = makeHeartBeatInfo(message);
		}else {
			return;
		}
		if(commandString==null){
			Exception e = new Exception();
			throw e;
		}else{
			IoBuffer buffer= IoBuffer.allocate(10).setAutoExpand(true);
			buffer.putString(commandString,Charset.forName("UTF-8").newEncoder());
			buffer.flip();
			System.out.println("进入字符串编码器！");
			out.write(buffer);
		}		
	}
	
	private String makeHeartBeatInfo(String heartBeat) {
		return heartBeat;
	}
}
