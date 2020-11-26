package com.zhongzhi.location.mina.server;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.apache.mina.filter.codec.demux.MessageDecoder;
import org.apache.mina.filter.codec.demux.MessageDecoderResult;

import com.anfu.mina.bean.SendMessage;

public class MonitorServerDecoderOther implements MessageDecoder {
	public static int i=1;
	@Override
	public MessageDecoderResult decodable(IoSession session, IoBuffer in) {
		System.out.println("执行次数为："+ (i++));
		if (in.remaining() < 2)
			return MessageDecoderResult.NEED_DATA;
		else {
			char symbol = in.getChar();
			if (symbol == '+') {
				return MessageDecoderResult.OK;
			} else {
				return MessageDecoderResult.NOT_OK;
			}
		}
	}

	@Override
	public MessageDecoderResult decode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
		SendMessage sm = new SendMessage();
		sm.setSymbol(in.getChar());
		sm.setI(in.getInt());
		sm.setJ(in.getInt());
		out.write(sm);
		return MessageDecoderResult.OK;
	}

	@Override
	public void finishDecode(IoSession session, ProtocolDecoderOutput out) throws Exception {
		// undo
	}
}
