package com.pcm.mina.filter.codec;

import java.nio.charset.Charset;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.apache.mina.filter.codec.demux.MessageEncoder;

public class MonitorServerEncoderHeartBeat implements MessageEncoder<String> {
	@Override
	public void encode(IoSession session, String message, ProtocolEncoderOutput out) throws Exception {
		String commandString;
		if (message instanceof String) {
			commandString = message;
		}else{	
			//无效命令
			return;
		}

		IoBuffer buffer = IoBuffer.allocate(4).setAutoExpand(true);
		buffer.putString(commandString, Charset.forName("UTF-8").newEncoder());
		buffer.flip();
		out.write(buffer);
	}
}
