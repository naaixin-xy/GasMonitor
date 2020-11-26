package com.anfu.mina.client;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.apache.mina.filter.codec.demux.MessageDecoder;
import org.apache.mina.filter.codec.demux.MessageDecoderResult;

import com.anfu.mina.bean.ResultMessage;


public class MonitorClientDecoderJson implements MessageDecoder {
	@Override
	public MessageDecoderResult decodable(IoSession session, IoBuffer in) {
		if (in.remaining() < 15)
			return MessageDecoderResult.NEED_DATA;
		else if (in.remaining() == 15)
			return MessageDecoderResult.OK;
		else
			return MessageDecoderResult.NOT_OK;
	}

	@Override
	public MessageDecoderResult decode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
		ResultMessage rm = new ResultMessage();
		rm.setResult(in.getInt());
	
		out.write(rm);
		
		return MessageDecoderResult.OK;
	}

	@Override
	public void finishDecode(IoSession session, ProtocolDecoderOutput out) throws Exception {
		// undo
	}
}
