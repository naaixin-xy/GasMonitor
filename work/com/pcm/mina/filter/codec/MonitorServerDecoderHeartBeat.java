package com.pcm.mina.filter.codec;

import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.apache.mina.filter.codec.demux.MessageDecoder;
import org.apache.mina.filter.codec.demux.MessageDecoderResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pcm.mina.service.model.Message;



public class MonitorServerDecoderHeartBeat implements MessageDecoder {
	private final static Logger log = LoggerFactory.getLogger(MonitorServerDecoderHeartBeat.class);

	@Override
	public MessageDecoderResult decodable(IoSession session, IoBuffer in) {
		if (in.remaining() < Message.CMD_HEARTBEAT_RESPONSE.length())
			return MessageDecoderResult.NEED_DATA;
		else {
			CharsetDecoder cd = Charset.forName("UTF-8").newDecoder();
			String temp;
			try {
				temp = in.getString(Message.CMD_HEARTBEAT_RESPONSE.length(),cd);
			} catch ( CharacterCodingException e) {
				// TODO Auto-generated catch block
				return MessageDecoderResult.NOT_OK;
			}
			if (temp.startsWith(Message.CMD_HEARTBEAT_RESPONSE)) {
				return MessageDecoderResult.OK;
			} else {
				return MessageDecoderResult.NOT_OK;
			}
		}
	}

	@Override
	public MessageDecoderResult decode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {

		CharsetDecoder cd = Charset.forName("UTF-8").newDecoder();
		String recvData = in.getString(Message.CMD_HEARTBEAT_RESPONSE.length(), cd);

		log.debug("服务端收到心跳返回数据：心跳包  解码心跳包" + recvData);
		out.write(recvData);
		return MessageDecoderResult.OK;
	}

	@Override
	public void finishDecode(IoSession session, ProtocolDecoderOutput out) throws Exception {
		// undo
	}
}
