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
import com.pcm.mina.service.model.ReplyBody;

public class MonitorServerDecoderReplyBody implements MessageDecoder {
	private final static Logger log = LoggerFactory.getLogger(MonitorServerDecoderReplyBody.class);
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
		ArrayList<ReplyBody> commands = new ArrayList<ReplyBody>();
		//GlobalData.STARTFIELD
		log.debug("收到数据：" + recvData);
		String[] dataPackets = recvData.replaceAll("AFGH", "").split(GlobalData.ENDFIELD);
		for (String dataPacket : dataPackets) {
			dataPacket = dataPacket.replace(GlobalData.STARTFIELD, "").trim();
			log.debug("解析命令包：" + dataPacket);
			int crc = GlobalData.CalculateCRC(dataPacket.substring(0, dataPacket.length()-GlobalData.fieldNameToLengthMap.get(GlobalData.crc)).getBytes("UTF-8"));			
			log.debug("CRC计算成功！ 数据内容：" + dataPacket + " crc=" + crc);		
			if (Integer.valueOf(dataPacket.substring(dataPacket.length()-GlobalData.fieldNameToLengthMap.get(GlobalData.crc),dataPacket.length())) != crc) {
				log.error("CRC校验失败！ 数据内容：" + dataPacket + " crc=" + crc);
				continue;
			}
			log.debug("CRC校验成功！ 数据内容：" + dataPacket + " crc=" + crc);	
			ReplyBody replayBody=new ReplyBody();
			
			int fieldStartPostion = GlobalData.fieldNameToLengthMap.get(GlobalData.dataLength);
			int fieldEndPostion = fieldStartPostion+GlobalData.fieldNameToLengthMap.get(GlobalData.requestNumber);
			replayBody.put(GlobalData.requestNumber,dataPacket.substring(fieldStartPostion,fieldEndPostion));
			log.debug("step1");
			//fieldStartPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.requestNumber);
			fieldStartPostion=fieldEndPostion;
			fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.commandNumber);
			Integer commandNumber = Integer.valueOf(dataPacket.substring(fieldStartPostion,fieldEndPostion));//获取命令编码	
			replayBody.setKey(GlobalData.COMMANDNAMES[commandNumber]);
			log.debug("step2");
			fieldStartPostion=fieldEndPostion;	
			fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.executeResult);
			String resultCode = dataPacket.substring(fieldStartPostion,fieldEndPostion);//获取命令编码	
			replayBody.setCode(resultCode);
			replayBody.setMessage(resultCode);
			log.debug("step3");
			log.debug("dataPacket length="+dataPacket.length());
			if(commandNumber==1) {//getStatusData 读取所有状态数据
				
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.hostId);
				replayBody.put(GlobalData.hostId, dataPacket.substring(fieldStartPostion,fieldEndPostion));

				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.detectorId);
				replayBody.put(GlobalData.detectorId, dataPacket.substring(fieldStartPostion,fieldEndPostion));
				
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.alarmStatus);				
				replayBody.put(GlobalData.alarmStatus, dataPacket.substring(fieldStartPostion,fieldEndPostion));
				
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.faultStatus);				
				replayBody.put(GlobalData.faultStatus, dataPacket.substring(fieldStartPostion,fieldEndPostion));
				
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.maskStatus);				
				replayBody.put(GlobalData.maskStatus, dataPacket.substring(fieldStartPostion,fieldEndPostion));
				
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.gasConcentration);				
				replayBody.put(GlobalData.gasConcentration, dataPacket.substring(fieldStartPostion,fieldEndPostion));
				
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.highAlarmBound);				
				replayBody.put(GlobalData.highAlarmBound, dataPacket.substring(fieldStartPostion,fieldEndPostion));
				
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.lowAlarmBound);				
				replayBody.put(GlobalData.lowAlarmBound, dataPacket.substring(fieldStartPostion,fieldEndPostion));
				
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.relayStatus);				
				replayBody.put(GlobalData.relayStatus, dataPacket.substring(fieldStartPostion,fieldEndPostion));
			}else if(commandNumber==2) {//reset
//				replayBody.setRequestNumber(dataPacket.substring(4,14));
//				replayBody.setKey(GlobalData.COMMANDNAMES[commandNumber]);
//				replayBody.setCode(resultCode);
//				replayBody.setMessage(resultCode);
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.hostId);
				replayBody.put(GlobalData.hostId, dataPacket.substring(fieldStartPostion,fieldEndPostion));

				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.detectorId);
				replayBody.put(GlobalData.detectorId, dataPacket.substring(fieldStartPostion,fieldEndPostion));
				
			}else if(commandNumber==3) {//stopSound
				
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.hostId);
				replayBody.put(GlobalData.hostId, dataPacket.substring(fieldStartPostion,fieldEndPostion));

				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.detectorId);
				replayBody.put(GlobalData.detectorId, dataPacket.substring(fieldStartPostion,fieldEndPostion));
				
			}else if(commandNumber==4) {//getAlarmBound
//				replayBody.setRequestNumber(dataPacket.substring(4,14));
//				replayBody.setKey(GlobalData.COMMANDNAMES[commandNumber]);
//				replayBody.setCode(resultCode);
//				replayBody.setMessage(resultCode);
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.hostId);
				replayBody.put(GlobalData.hostId, dataPacket.substring(fieldStartPostion,fieldEndPostion));

				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.detectorId);
				replayBody.put(GlobalData.detectorId, dataPacket.substring(fieldStartPostion,fieldEndPostion));

				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.highAlarmBound);				
				replayBody.put(GlobalData.highAlarmBound, dataPacket.substring(fieldStartPostion,fieldEndPostion));
				
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.lowAlarmBound);				
				replayBody.put(GlobalData.lowAlarmBound, dataPacket.substring(fieldStartPostion,fieldEndPostion));
			
			}else if(commandNumber==5) {//setAlarmBound
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.hostId);
				replayBody.put(GlobalData.hostId, dataPacket.substring(fieldStartPostion,fieldEndPostion));

				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.detectorId);
				replayBody.put(GlobalData.detectorId, dataPacket.substring(fieldStartPostion,fieldEndPostion));
			
			}else if(commandNumber==6) {//startPump
				
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.hostId);
				replayBody.put(GlobalData.hostId, dataPacket.substring(fieldStartPostion,fieldEndPostion));

				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.detectorId);
				replayBody.put(GlobalData.detectorId, dataPacket.substring(fieldStartPostion,fieldEndPostion));
			
			}else if(commandNumber==7) {//getHighAlarmBound
				
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.hostId);
				replayBody.put(GlobalData.hostId, dataPacket.substring(fieldStartPostion,fieldEndPostion));

				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.detectorId);
				replayBody.put(GlobalData.detectorId, dataPacket.substring(fieldStartPostion,fieldEndPostion));

				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.highAlarmBound);				
				replayBody.put(GlobalData.highAlarmBound, dataPacket.substring(fieldStartPostion,fieldEndPostion));

			}else if(commandNumber==8) {//setHighAlarmBound
				
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.hostId);
				replayBody.put(GlobalData.hostId, dataPacket.substring(fieldStartPostion,fieldEndPostion));

				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.detectorId);
				replayBody.put(GlobalData.detectorId, dataPacket.substring(fieldStartPostion,fieldEndPostion));
			
			}else if(commandNumber==9) {//getLowAlarmBound
				
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.hostId);
				replayBody.put(GlobalData.hostId, dataPacket.substring(fieldStartPostion,fieldEndPostion));

				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.detectorId);
				replayBody.put(GlobalData.detectorId, dataPacket.substring(fieldStartPostion,fieldEndPostion));
	
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.lowAlarmBound);				
				replayBody.put(GlobalData.lowAlarmBound, dataPacket.substring(fieldStartPostion,fieldEndPostion));

			}else if(commandNumber==10) {//setLowAlarmBound
				
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.hostId);
				replayBody.put(GlobalData.hostId, dataPacket.substring(fieldStartPostion,fieldEndPostion));

				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.detectorId);
				replayBody.put(GlobalData.detectorId, dataPacket.substring(fieldStartPostion,fieldEndPostion));
			
			}else if(commandNumber==11) {//getMaskThreshold
				
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.hostId);
				replayBody.put(GlobalData.hostId, dataPacket.substring(fieldStartPostion,fieldEndPostion));

				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.detectorId);
				replayBody.put(GlobalData.detectorId, dataPacket.substring(fieldStartPostion,fieldEndPostion));
			
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.maskThreshold);				
				replayBody.put(GlobalData.maskThreshold, dataPacket.substring(fieldStartPostion,fieldEndPostion));

			}else if(commandNumber==12) {//setMaskThreshold
				
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.hostId);
				replayBody.put(GlobalData.hostId, dataPacket.substring(fieldStartPostion,fieldEndPostion));

				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.detectorId);
				replayBody.put(GlobalData.detectorId, dataPacket.substring(fieldStartPostion,fieldEndPostion));
			
			}else if(commandNumber==13) {//getPumpRunTime
				
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.hostId);
				replayBody.put(GlobalData.hostId, dataPacket.substring(fieldStartPostion,fieldEndPostion));

				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.detectorId);
				replayBody.put(GlobalData.detectorId, dataPacket.substring(fieldStartPostion,fieldEndPostion));
			
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.pumpRunTime);				
				replayBody.put(GlobalData.pumpRunTime, dataPacket.substring(fieldStartPostion,fieldEndPostion));

			}else if(commandNumber==14) {//setPumpRunTime
				
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.hostId);
				replayBody.put(GlobalData.hostId, dataPacket.substring(fieldStartPostion,fieldEndPostion));

				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.detectorId);
				replayBody.put(GlobalData.detectorId, dataPacket.substring(fieldStartPostion,fieldEndPostion));
			
			}else if(commandNumber==15) {//getPumpPeriod
				
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.hostId);
				replayBody.put(GlobalData.hostId, dataPacket.substring(fieldStartPostion,fieldEndPostion));

				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.detectorId);
				replayBody.put(GlobalData.detectorId, dataPacket.substring(fieldStartPostion,fieldEndPostion));
			
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.pumpPeriod);				
				replayBody.put(GlobalData.pumpPeriod, dataPacket.substring(fieldStartPostion,fieldEndPostion));

			}else if(commandNumber==16) {//setPumpPeriod
				
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.hostId);
				replayBody.put(GlobalData.hostId, dataPacket.substring(fieldStartPostion,fieldEndPostion));

				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.detectorId);
				replayBody.put(GlobalData.detectorId, dataPacket.substring(fieldStartPostion,fieldEndPostion));
			
			}else if(commandNumber==17) {//getFlowDifferenceValue
				
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.hostId);
				replayBody.put(GlobalData.hostId, dataPacket.substring(fieldStartPostion,fieldEndPostion));

				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.detectorId);
				replayBody.put(GlobalData.detectorId, dataPacket.substring(fieldStartPostion,fieldEndPostion));
			
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.flowDifferenceValue);				
				replayBody.put(GlobalData.flowDifferenceValue, dataPacket.substring(fieldStartPostion,fieldEndPostion));

			}else if(commandNumber==18) {//setFlowDifferenceValue
				
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.hostId);
				replayBody.put(GlobalData.hostId, dataPacket.substring(fieldStartPostion,fieldEndPostion));

				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.detectorId);
				replayBody.put(GlobalData.detectorId, dataPacket.substring(fieldStartPostion,fieldEndPostion));
			
			}else if(commandNumber==19) {//getWaterInletFaultThreshold
				
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.hostId);
				replayBody.put(GlobalData.hostId, dataPacket.substring(fieldStartPostion,fieldEndPostion));

				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.detectorId);
				replayBody.put(GlobalData.detectorId, dataPacket.substring(fieldStartPostion,fieldEndPostion));
			
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.waterInletFaultThreshold);				
				replayBody.put(GlobalData.waterInletFaultThreshold, dataPacket.substring(fieldStartPostion,fieldEndPostion));

			}else if(commandNumber==20) {//setWaterInletFaultThreshold
				
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.hostId);
				replayBody.put(GlobalData.hostId, dataPacket.substring(fieldStartPostion,fieldEndPostion));

				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.detectorId);
				replayBody.put(GlobalData.detectorId, dataPacket.substring(fieldStartPostion,fieldEndPostion));
			
			}else if(commandNumber==21) {//getFlowFaultThreshold
				
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.hostId);
				replayBody.put(GlobalData.hostId, dataPacket.substring(fieldStartPostion,fieldEndPostion));

				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.detectorId);
				replayBody.put(GlobalData.detectorId, dataPacket.substring(fieldStartPostion,fieldEndPostion));
			
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.flowFaultThreshold);				
				replayBody.put(GlobalData.flowFaultThreshold, dataPacket.substring(fieldStartPostion,fieldEndPostion));

			}else if(commandNumber==22) {//setFlowFaultThreshold
				
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.hostId);
				replayBody.put(GlobalData.hostId, dataPacket.substring(fieldStartPostion,fieldEndPostion));

				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.detectorId);
				replayBody.put(GlobalData.detectorId, dataPacket.substring(fieldStartPostion,fieldEndPostion));
			
			}else if(commandNumber==23) {//getSensorFaultThreshold
				
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.hostId);
				replayBody.put(GlobalData.hostId, dataPacket.substring(fieldStartPostion,fieldEndPostion));

				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.detectorId);
				replayBody.put(GlobalData.detectorId, dataPacket.substring(fieldStartPostion,fieldEndPostion));
			
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.sensorFaultThreshold);				
				replayBody.put(GlobalData.sensorFaultThreshold, dataPacket.substring(fieldStartPostion,fieldEndPostion));

			}else if(commandNumber==24) {//setSensorFaultThreshold
				
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.hostId);
				replayBody.put(GlobalData.hostId, dataPacket.substring(fieldStartPostion,fieldEndPostion));

				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.detectorId);
				replayBody.put(GlobalData.detectorId, dataPacket.substring(fieldStartPostion,fieldEndPostion));
			
			}else if(commandNumber==25) {//getStaticFlowValue
				
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.hostId);
				replayBody.put(GlobalData.hostId, dataPacket.substring(fieldStartPostion,fieldEndPostion));

				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.detectorId);
				replayBody.put(GlobalData.detectorId, dataPacket.substring(fieldStartPostion,fieldEndPostion));
			
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.staticFlowValue);				
				replayBody.put(GlobalData.staticFlowValue, dataPacket.substring(fieldStartPostion,fieldEndPostion));

			}else if(commandNumber==26) {//getDynamicFlowValue
				
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.hostId);
				replayBody.put(GlobalData.hostId, dataPacket.substring(fieldStartPostion,fieldEndPostion));

				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.detectorId);
				replayBody.put(GlobalData.detectorId, dataPacket.substring(fieldStartPostion,fieldEndPostion));
			
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.dynamicFlowValue);				
				replayBody.put(GlobalData.dynamicFlowValue, dataPacket.substring(fieldStartPostion,fieldEndPostion));

			}else if(commandNumber==27) {//calibrateZeroSpot
				
				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.hostId);
				replayBody.put(GlobalData.hostId, dataPacket.substring(fieldStartPostion,fieldEndPostion));

				fieldStartPostion=fieldEndPostion;
				fieldEndPostion+=GlobalData.fieldNameToLengthMap.get(GlobalData.detectorId);
				replayBody.put(GlobalData.detectorId, dataPacket.substring(fieldStartPostion,fieldEndPostion));
			}else{
				log.error("无效命令码！ 数据内容：" + dataPacket + " commandNumber=" + commandNumber);
			}
			commands.add(replayBody);
		}
		out.write(commands);
		return MessageDecoderResult.OK;
	}

	@Override
	public void finishDecode(IoSession session, ProtocolDecoderOutput out) throws Exception {
		// undo
	}
}
