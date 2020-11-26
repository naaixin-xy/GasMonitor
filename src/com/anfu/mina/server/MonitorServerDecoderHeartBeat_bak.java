package com.anfu.mina.server;

import java.io.UnsupportedEncodingException;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.MalformedInputException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.apache.mina.filter.codec.demux.MessageDecoder;
import org.apache.mina.filter.codec.demux.MessageDecoderResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfu.mina.command.ParentCommand;
import com.anfu.mina.command.client.DeviceRegister;
import com.anfu.mina.command.client.SendAlarmInfo;
import com.anfu.mina.command.client.SendFaultInfo;
import com.anfu.mina.command.client.SendRealtimeData;

public class MonitorServerDecoderHeartBeat_bak implements MessageDecoder {
	private final static Logger log = LoggerFactory.getLogger(MonitorServerDecoderHeartBeat_bak.class);

	@Override
	public MessageDecoderResult decodable(IoSession session, IoBuffer in) {
		//StringBuilder builder = new StringBuilder();
		// "开始@@@@@@@@@@start" + dataPacketJson.toString() + "end@@@@@@@@@@结束"
		// builder.
		IoBuffer buffer = in.duplicate();
		if (buffer.remaining() < 4)
			return MessageDecoderResult.NEED_DATA;
		else {
			CharsetDecoder cd = Charset.forName("UTF-8").newDecoder();
			String temp;
			//buffer.flip();
			try {
				temp = new String(Arrays.copyOf(buffer.array(), buffer.remaining()), "UTF-8").trim();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				return MessageDecoderResult.NOT_OK;
			}
			if (temp.startsWith("AFGH")) {
				return MessageDecoderResult.OK;
			} else {
				return MessageDecoderResult.NOT_OK;
			}
		}
	}

	@Override
	public MessageDecoderResult decode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
		IoBuffer buffer = in.duplicate();
		//buffer.flip();
		CharsetDecoder cd = Charset.forName("UTF-8").newDecoder();
		String recvData = buffer.getString(in.remaining(), cd);
		recvData = recvData.substring(0, 4);
		in.getString(recvData.getBytes("UTF-8").length, cd);
		in.flip();

		log.debug("收到数据：心跳包" + recvData);
		out.write(recvData);
		return MessageDecoderResult.OK;
	}

	@Override
	public void finishDecode(IoSession session, ProtocolDecoderOutput out) throws Exception {
		// undo
	}
}
