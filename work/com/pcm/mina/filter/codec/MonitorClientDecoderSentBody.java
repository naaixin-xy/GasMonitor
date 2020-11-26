package com.pcm.mina.filter.codec;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.ArrayList;
import java.util.Arrays;




import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.apache.mina.filter.codec.demux.MessageDecoder;
import org.apache.mina.filter.codec.demux.MessageDecoderResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfu.gas.global.GlobalData;
import com.pcm.mina.service.model.SentBody;

public class MonitorClientDecoderSentBody implements MessageDecoder {
	private final static Logger log = LoggerFactory.getLogger(MonitorClientDecoderSentBody.class);
	private final static String startField="ST";
	private final static String endField="TL";
	@Override
	public MessageDecoderResult decodable(IoSession session, IoBuffer in) {
		//StringBuilder builder = new StringBuilder();
		IoBuffer buffer = in.duplicate();
		if (buffer.remaining() < 27) {//2+4+10+4+5+2
			return NEED_DATA;
		}else {
			//CharsetDecoder cd = Charset.forName("UTF-8").newDecoder();
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
		in.getString(recvData.getBytes("UTF-8").length + GlobalData.fieldNameToLengthMap.get(GlobalData.end), cd);
		ArrayList<SentBody> commands = new ArrayList<SentBody>();
		//GlobalData.STARTFIELD
		log.debug("收到数据：" + recvData);
		String[] dataPackets = recvData.replaceAll("AFGH", "").split(GlobalData.ENDFIELD);
		for (String dataPacket : dataPackets) {
			dataPacket = dataPacket.replace(GlobalData.STARTFIELD, "").trim();
			log.info("解析命令包：" + dataPacket);
			int crc = GlobalData.CalculateCRC(dataPacket.substring(0, dataPacket.length()-GlobalData.fieldNameToLengthMap.get(GlobalData.crc)).getBytes("UTF-8"));			
			if (Integer.valueOf(dataPacket.substring(dataPacket.length()-GlobalData.fieldNameToLengthMap.get(GlobalData.crc),dataPacket.length())) != crc) {
				log.error("CRC校验失败！ 数据内容：" + dataPacket + " crc=" + crc);
				continue;
			}
			SentBody sentBody=new SentBody();
			
			int fieldStartPostion = GlobalData.fieldNameToLengthMap.get(GlobalData.dataLength);
			int fieldEndPostion = fieldStartPostion+GlobalData.fieldNameToLengthMap.get(GlobalData.requestNumber);
			sentBody.put(GlobalData.requestNumber,dataPacket.substring(fieldStartPostion,fieldEndPostion));

			fieldStartPostion=fieldEndPostion;
			fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.commandNumber);
			Integer commandNumber = Integer.valueOf(dataPacket.substring(fieldStartPostion,fieldEndPostion));//获取命令编码	
			sentBody.setKey(GlobalData.COMMANDNAMES[commandNumber]);
			
			if(sentBody.getKey().equals(GlobalData.getStatusData)) {
				
			}else if(sentBody.getKey().equals(GlobalData.reset)) {
			
			}else if(sentBody.getKey().equals(GlobalData.stopSound)) {
					
			}else if(sentBody.getKey().equals(GlobalData.getAlarmBound)) {
	
			}else if(sentBody.getKey().equals(GlobalData.setAlarmBound)) {
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.highAlarmBound);
				sentBody.put(GlobalData.highAlarmBound, dataPacket.substring(fieldStartPostion,fieldEndPostion));

				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.lowAlarmBound);
				sentBody.put(GlobalData.lowAlarmBound, dataPacket.substring(fieldStartPostion,fieldEndPostion));
				
			}else if(sentBody.getKey().equals(GlobalData.startPump)) {
	
			}else if(sentBody.getKey().equals(GlobalData.getHighAlarmBound)) {
				
			}else if(sentBody.getKey().equals(GlobalData.setHighAlarmBound)) {
				
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.highAlarmBound);
				sentBody.put(GlobalData.highAlarmBound, dataPacket.substring(fieldStartPostion,fieldEndPostion));

			}else if(sentBody.getKey().equals(GlobalData.getLowAlarmBound)) {
				
			}else if(sentBody.getKey().equals(GlobalData.setLowAlarmBound)) {
				
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.lowAlarmBound);
				sentBody.put(GlobalData.lowAlarmBound, dataPacket.substring(fieldStartPostion,fieldEndPostion));				

			}else if(sentBody.getKey().equals(GlobalData.getMaskThreshold)) {
				
			}else if(sentBody.getKey().equals(GlobalData.setMaskThreshold)) {
				
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.maskThreshold);
				sentBody.put(GlobalData.maskThreshold, dataPacket.substring(fieldStartPostion,fieldEndPostion));				
				
			}else if(sentBody.getKey().equals(GlobalData.getPumpRunTime)) {
				
			}else if(sentBody.getKey().equals(GlobalData.setPumpRunTime)) {
				
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.pumpRunTime);
				sentBody.put(GlobalData.pumpRunTime, dataPacket.substring(fieldStartPostion,fieldEndPostion));				
				
			}else if(sentBody.getKey().equals(GlobalData.getPumpPeriod)) {
				
			}else if(sentBody.getKey().equals(GlobalData.setPumpPeriod)) {
				
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.pumpPeriod);
				sentBody.put(GlobalData.pumpPeriod, dataPacket.substring(fieldStartPostion,fieldEndPostion));				
				
			}else if(sentBody.getKey().equals(GlobalData.getFlowDifferenceValue)) {
				
			}else if(sentBody.getKey().equals(GlobalData.setFlowDifferenceValue)) {
				
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.flowDifferenceValue);
				sentBody.put(GlobalData.flowDifferenceValue, dataPacket.substring(fieldStartPostion,fieldEndPostion));				
				
			}else if(sentBody.getKey().equals(GlobalData.getWaterInletFaultThreshold)) {
				
			}else if(sentBody.getKey().equals(GlobalData.setWaterInletFaultThreshold)) {
				
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.waterInletFaultThreshold);
				sentBody.put(GlobalData.waterInletFaultThreshold, dataPacket.substring(fieldStartPostion,fieldEndPostion));				
				
			}else if(sentBody.getKey().equals(GlobalData.getFlowFaultThreshold)) {
				
			}else if(sentBody.getKey().equals(GlobalData.setFlowFaultThreshold)) {
				
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.flowFaultThreshold);
				sentBody.put(GlobalData.flowFaultThreshold, dataPacket.substring(fieldStartPostion,fieldEndPostion));				
				
			}else if(sentBody.getKey().equals(GlobalData.getSensorFaultThreshold)) {
				
			}else if(sentBody.getKey().equals(GlobalData.setSensorFaultThreshold)) {
				
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.sensorFaultThreshold);
				sentBody.put(GlobalData.sensorFaultThreshold, dataPacket.substring(fieldStartPostion,fieldEndPostion));				
				
			}else if(sentBody.getKey().equals(GlobalData.getStaticFlowValue)) {
				
			}else if(sentBody.getKey().equals(GlobalData.getDynamicFlowValue)) {
				
			}else if(sentBody.getKey().equals(GlobalData.calibrateZeroSpot)) {
				
			}else{
				log.error("无效命令码！ 数据内容：" + dataPacket + " commandNumber=" + commandNumber);
			}
			commands.add(sentBody);
		}
		out.write(commands);
		return MessageDecoderResult.OK;
	}

	@Override
	public void finishDecode(IoSession session, ProtocolDecoderOutput out) throws Exception {
		// undo
	}
}
