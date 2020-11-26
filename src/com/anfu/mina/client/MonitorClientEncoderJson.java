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


import com.anfu.mina.command.ParentCommand;

public class MonitorClientEncoderJson implements MessageEncoder<ParentCommand> {
	private final static Logger log = LoggerFactory.getLogger(MonitorClientEncoderJson.class);
	String  commandString="";
	@Override
	public void encode(IoSession session, ParentCommand message, ProtocolEncoderOutput out) throws Exception {
		if (message instanceof ParentCommand) {
			commandString = "AAAAAAAAAAAAA";
		}else {
			return;
		}
		//String commandString="";
		IoBuffer buffer= IoBuffer.allocate(4).setAutoExpand(true);
		buffer.putString(commandString,Charset.forName("UTF-8").newEncoder());
		buffer.flip();
		out.write(buffer);		
	}
}
