package com.pcm.mina.filter.codec;

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

import com.anfu.gas.global.GlobalData;
import com.pcm.mina.service.model.ReplyBody;

public class MonitorServerDecoderJson implements MessageDecoder {
	private final static Logger log = LoggerFactory.getLogger(MonitorServerDecoderJson.class);
	private final static String startField="ST";
	private final static String endField="TL";
	@Override
	public MessageDecoderResult decodable(IoSession session, IoBuffer in) {
		StringBuilder builder = new StringBuilder();
		IoBuffer buffer = in.duplicate();
		if (buffer.remaining() < 27) {//2+4+10+4+5+2
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
			//temp = temp.replaceAll("AFGH", "");
			if (temp.startsWith(startField) && temp.endsWith(endField)) {
				return MessageDecoderResult.OK;
			} else if (temp.startsWith(startField) && !temp.endsWith(endField)) {
				return MessageDecoderResult.NEED_DATA;
			} else if (temp.contains(startField) && !temp.endsWith(endField)) {
				return MessageDecoderResult.NEED_DATA;
			} else if (!temp.startsWith(startField) && temp.endsWith(endField)) {
				return MessageDecoderResult.OK;
			} else if(temp.contains(startField)&&temp.contains(endField)&&(temp.indexOf(startField)<temp.indexOf(endField,temp.indexOf(startField)+2))) {
				return MessageDecoderResult.OK;
			} else {
				return MessageDecoderResult.NOT_OK;
			}
		}
	}
	@Override
	public MessageDecoderResult decode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
		IoBuffer buffer = in.duplicate();
		CharsetDecoder cd = Charset.forName("UTF-8").newDecoder();
		String recvData = buffer.getString(in.remaining(), cd);
		recvData = recvData.substring(0, recvData.lastIndexOf(GlobalData.ENDFIELD));
		in.getString(recvData.getBytes("UTF-8").length + 2, cd);
		ArrayList<ReplyBody> commands = new ArrayList<ReplyBody>();
		//GlobalData.STARTFIELD
		log.debug("收到数据：" + recvData);
		String[] dataPackets = recvData.replaceAll("AFGH", "").split(GlobalData.ENDFIELD);
		for (String dataPacket : dataPackets) {
			dataPacket = dataPacket.replace(GlobalData.STARTFIELD, "").trim();
			log.info("解析命令包：" + dataPacket);
			int crc = GlobalData.CalculateCRC(dataPacket.substring(0, dataPacket.length()-5).getBytes("UTF-8"));			
			if (Integer.valueOf(dataPacket.substring(dataPacket.length(),dataPacket.length())) != crc) {
				log.error("CRC校验失败！ 数据内容：" + dataPacket + " crc=" + crc);
				continue;
			}			
			Integer commandNumber = Integer.valueOf(dataPacket.substring(14,18));//获取命令编码	
			String resultCode = dataPacket.substring(18,22);//获取命令编码	
			ReplyBody replayBody=new ReplyBody();
			if(commandNumber==1) {
				replayBody.setRequestNumber(dataPacket.substring(4,14));
				replayBody.setKey(GlobalData.COMMANDNAMES[commandNumber]);
				replayBody.setCode(resultCode);
				replayBody.setMessage(resultCode);
				replayBody.put("hostId", dataPacket.substring(22,32));
				replayBody.put("detectorId", dataPacket.substring(32,42));
				replayBody.put("alarmStatus", dataPacket.substring(42,43));
				replayBody.put("faultStatus", dataPacket.substring(43,48));
				replayBody.put("maskStatus", dataPacket.substring(48,49));
				replayBody.put("gasConcentration", dataPacket.substring(48,56));
				replayBody.put("highAlarmBound", dataPacket.substring(56,64));
				replayBody.put("lowAlarmBound", dataPacket.substring(64,72));
				replayBody.put("realyStatus", dataPacket.substring(72,77));
			}else if(commandNumber==2) {
				replayBody.setRequestNumber(dataPacket.substring(4,14));
				replayBody.setKey(GlobalData.COMMANDNAMES[commandNumber]);
				replayBody.setCode(resultCode);
				replayBody.setMessage(resultCode);
				replayBody.put("hostId", dataPacket.substring(22,32));
				replayBody.put("detectorId", dataPacket.substring(32,42));				
			}else if(commandNumber==3) {
				replayBody.setRequestNumber(dataPacket.substring(4,14));
				replayBody.setKey(GlobalData.COMMANDNAMES[commandNumber]);
				replayBody.setCode(resultCode);
				replayBody.setMessage(resultCode);
				replayBody.put("hostId", dataPacket.substring(22,32));
				replayBody.put("detectorId", dataPacket.substring(32,42));				
			}else if(commandNumber==4) {
				replayBody.setRequestNumber(dataPacket.substring(4,14));
				replayBody.setKey(GlobalData.COMMANDNAMES[commandNumber]);
				replayBody.setCode(resultCode);
				replayBody.setMessage(resultCode);
				replayBody.put("hostId", dataPacket.substring(22,32));
				replayBody.put("detectorId", dataPacket.substring(32,42));
				replayBody.put("highAlarmBound", dataPacket.substring(42,50));
				replayBody.put("lowAlarmBound", dataPacket.substring(50,58));				
			}else if(commandNumber==5) {
				replayBody.setRequestNumber(dataPacket.substring(4,14));
				replayBody.setKey(GlobalData.COMMANDNAMES[commandNumber]);
				replayBody.setCode(resultCode);
				replayBody.setMessage(resultCode);
				replayBody.put("hostId", dataPacket.substring(22,32));
				replayBody.put("detectorId", dataPacket.substring(32,42));				
			}else if(commandNumber==6) {
				replayBody.setRequestNumber(dataPacket.substring(4,14));
				replayBody.setKey(GlobalData.COMMANDNAMES[commandNumber]);
				replayBody.setCode(resultCode);
				replayBody.setMessage(resultCode);
				replayBody.put("hostId", dataPacket.substring(22,32));
				replayBody.put("detectorId", dataPacket.substring(32,42));				
			}else{
				log.error("无效命令码！ 数据内容：" + dataPacket + " commandNumber=" + commandNumber);
			}
		}
		out.write(commands);
		return MessageDecoderResult.OK;
	}

	@Override
	public void finishDecode(IoSession session, ProtocolDecoderOutput out) throws Exception {
		// undo
	}
}
