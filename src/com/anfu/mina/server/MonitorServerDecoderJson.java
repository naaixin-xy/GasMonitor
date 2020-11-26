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
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class MonitorServerDecoderJson implements MessageDecoder {
	private final static Logger log = LoggerFactory.getLogger(MonitorServerDecoderJson.class);

	@Override
	public MessageDecoderResult decodable(IoSession session, IoBuffer in) {
		StringBuilder builder = new StringBuilder();
		// "开始@@@@@@@@@@start" + dataPacketJson.toString() + "end@@@@@@@@@@结束"
		// builder.
		IoBuffer buffer = in.duplicate();
		if (buffer.remaining() < 60) {
			//return MessageDecoderResult.NEED_DATA;
			return NEED_DATA;
		}else {
			CharsetDecoder cd = Charset.forName("UTF-8").newDecoder();
			String temp;
			try {
				temp = new String(Arrays.copyOf(buffer.array(), buffer.remaining()), "UTF-8").trim();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return MessageDecoderResult.NOT_OK;
			}
			temp = temp.replaceAll("AFGH", "");
			if (temp.startsWith("开始@@@@@@@@@@start") && temp.endsWith("end@@@@@@@@@@结束")) {
				return MessageDecoderResult.OK;
			} else if (temp.startsWith("开始@@@@@@@@@@start") && !temp.endsWith("end@@@@@@@@@@结束")) {
				return MessageDecoderResult.NEED_DATA;
			} else if (temp.contains("开始@@@@@@@@@@start") && !temp.endsWith("end@@@@@@@@@@结束")) {
				return MessageDecoderResult.NEED_DATA;
			} else if (!temp.startsWith("开始@@@@@@@@@@start") && temp.endsWith("end@@@@@@@@@@结束")) {
				return MessageDecoderResult.OK;
			} else {
				return MessageDecoderResult.NOT_OK;
			}
		}
		//IoBuffer buffer = in.duplicate();
//		if (in.remaining() < 60)
//			return MessageDecoderResult.NEED_DATA;
//		else {
//			CharsetDecoder cd = Charset.forName("UTF-8").newDecoder();
//			String temp;
//			try {
//				temp = in.getString(in.remaining(),cd);
//			} catch ( CharacterCodingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				return MessageDecoderResult.NOT_OK;
//			}
//			temp = temp.replaceAll("AFGH", "");
//			if (temp.startsWith("开始@@@@@@@@@@start") && temp.endsWith("end@@@@@@@@@@结束")) {
//				return MessageDecoderResult.OK;
//			} else if (temp.startsWith("开始@@@@@@@@@@start") && !temp.endsWith("end@@@@@@@@@@结束")) {
//				return MessageDecoderResult.NEED_DATA;
//			} else if (temp.contains("开始@@@@@@@@@@start") && !temp.endsWith("end@@@@@@@@@@结束")) {
//				return MessageDecoderResult.NEED_DATA;
//			} else if (!temp.startsWith("开始@@@@@@@@@@start") && temp.endsWith("end@@@@@@@@@@结束")) {
//				return MessageDecoderResult.OK;
//			} else {
//				return MessageDecoderResult.NOT_OK;
//			}
//		}
	}

	@Override
	public MessageDecoderResult decode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
		IoBuffer buffer = in.duplicate();
		//buffer.flip();
		CharsetDecoder cd = Charset.forName("UTF-8").newDecoder();
		String recvData = buffer.getString(in.remaining(), cd);
		recvData = recvData.substring(0, recvData.lastIndexOf("end@@@@@@@@@@结束"));
		in.getString(recvData.getBytes("UTF-8").length + 19, cd);
		ArrayList<ParentCommand> commands = new ArrayList<ParentCommand>();

		log.debug("收到数据：" + recvData);
		String[] dataPackets = recvData.replaceAll("AFGH", "").split("end@@@@@@@@@@结束");
		for (String dataPacket : dataPackets) {
			dataPacket = dataPacket.replace("开始@@@@@@@@@@start", "").replace("AFGH", "").trim();
			log.info("解析命令包：" + dataPacket);
			if (!(dataPacket.startsWith("{") && dataPacket.endsWith("}"))) {
				log.error("指令格式出错！  数据内容：" + dataPacket);
				continue;
			} else {
				int startCount = 0, startIndex = 0, endCount = 0, endIndex = 0;
				while (((startIndex = dataPacket.indexOf("{", startIndex)) != -1) && (startIndex < dataPacket.length())) {
					startCount++;
					startIndex++;
				}
				while (((endIndex = dataPacket.indexOf("}", endIndex)) != -1) && (endIndex < dataPacket.length())) {
					endCount++;
					endIndex++;
				}
				if (startCount != endCount) {
					log.error("指令格式出错！  数据内容：" + dataPacket);
					continue;
				}
			}
			ObjectMapper mapper = new ObjectMapper(); 
			final String TREE_MODEL_BINDING = "{\"treekey1\":\"treevalue1\",\"treekey2\":\"treevalue2\",\"children\":[{\"childkey1\":\"childkey1\"}]}"; 
			JsonNode rootNode = mapper.readTree(TREE_MODEL_BINDING);  
		}
		out.write(commands);
		return MessageDecoderResult.OK;
	}

	@Override
	public void finishDecode(IoSession session, ProtocolDecoderOutput out) throws Exception {
		// undo
	}
}
