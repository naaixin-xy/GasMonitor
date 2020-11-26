package com.pcm.mina.filter.codec;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.apache.mina.filter.codec.demux.MessageEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfu.gas.global.GlobalData;
import com.pcm.mina.service.model.SentBody;

public class MonitorServerEncoderSentBody implements MessageEncoder<SentBody> {
	private final static Logger log = LoggerFactory.getLogger(MonitorServerEncoderSentBody.class);

	@Override
	public void encode(IoSession session, SentBody message, ProtocolEncoderOutput out) throws Exception {
		StringBuilder sb = new StringBuilder();
		//"getStatusData","reset","stopSound","getAlarmBound","setAlarmBound","startPump"};
		if(message.getKey().equals(GlobalData.getStatusData)){
			sb=encodeGetStatusData(message);
		}else if(message.getKey().equals(GlobalData.reset)) {
			sb=encodeReset(message);
		}else if(message.getKey().equals(GlobalData.stopSound)) {
			sb=encodeStopSound(message);
		}else if(message.getKey().equals(GlobalData.getAlarmBound)) {
			sb=encodeGetAlarmBound(message);
		}else if(message.getKey().equals(GlobalData.setAlarmBound)) {
			sb=encodeSetAlarmBound(message);
		}else if(message.getKey().equals(GlobalData.startPump)) {
			sb=encodeStartPump(message);
		}else if(message.getKey().equals(GlobalData.getHighAlarmBound)) {
			sb=encodeGetHighAlarmBound(message);
		}else if(message.getKey().equals(GlobalData.setHighAlarmBound)) {
			sb=encodeSetHighAlarmBound(message);
		}else if(message.getKey().equals(GlobalData.getLowAlarmBound)) {
			sb=encodeGetLowAlarmBound(message);
		}else if(message.getKey().equals(GlobalData.setLowAlarmBound)) {
			sb=encodeSetLowAlarmBound(message);
		}else if(message.getKey().equals(GlobalData.getMaskThreshold)) {
			sb=encodeGetMaskThreshold(message);
		}else if(message.getKey().equals(GlobalData.setMaskThreshold)) {
			sb=encodeSetMaskThreshold(message);
		}else if(message.getKey().equals(GlobalData.getPumpRunTime)) {
			sb=	encodeGetPumpRunTime(message);
		}else if(message.getKey().equals(GlobalData.setPumpRunTime)) {
			sb=	encodeSetPumpRunTime(message);
		}else if(message.getKey().equals(GlobalData.getPumpPeriod)) {
			sb=encodeGetPumpPeriod(message);
		}else if(message.getKey().equals(GlobalData.setPumpPeriod)) {
			sb=encodeSetPumpPeriod(message);
		}else if(message.getKey().equals(GlobalData.getFlowDifferenceValue)) {
			sb=	encodeGetFlowDifferenceValue(message);
		}else if(message.getKey().equals(GlobalData.setFlowDifferenceValue)) {
			sb=	encodeSetFlowDifferenceValue(message);
		}else if(message.getKey().equals(GlobalData.getWaterInletFaultThreshold)) {
			sb=encodeGetWaterInletFaultThreshold(message);
		}else if(message.getKey().equals(GlobalData.setWaterInletFaultThreshold)) {
			sb=encodeSetWaterInletFaultThreshold(message);
		}else if(message.getKey().equals(GlobalData.getFlowFaultThreshold)) {
			sb=encodeGetFlowFaultThreshold(message);
		}else if(message.getKey().equals(GlobalData.setFlowFaultThreshold)) {
			sb=encodeSetFlowFaultThreshold(message);
		}else if(message.getKey().equals(GlobalData.getSensorFaultThreshold)) {
			sb=encodeGetSensorFaultThreshold(message);
		}else if(message.getKey().equals(GlobalData.setSensorFaultThreshold)) {
			sb=encodeSetSensorFaultThreshold(message);
		}else if(message.getKey().equals(GlobalData.getStaticFlowValue)) {
			sb=encodeGetStaticFlowValue(message);
		}else if(message.getKey().equals(GlobalData.getDynamicFlowValue)) {
			sb=encodeGetDynamicFlowValue(message);
		}else if(message.getKey().equals(GlobalData.calibrateZeroSpot)) {
			sb=encodeCalibrateZeroSpot(message);
		}	

		IoBuffer buffer= IoBuffer.allocate(4).setAutoExpand(true);
		buffer.putString(sb.toString(),Charset.forName("UTF-8").newEncoder());
		buffer.flip();
		out.write(buffer);
	}
	
	private StringBuilder encodeSetAlarmBound(SentBody message) throws UnsupportedEncodingException {

		StringBuilder sb = new StringBuilder();
		
		sb.append(message.get(GlobalData.requestNumber));//请求码
		sb.append(GlobalData.commandNameToNumberMap.get(message.getKey()));//命令编号
		sb.append(message.get(GlobalData.highAlarmBound));//命令编号
		sb.append(message.get(GlobalData.lowAlarmBound));
		
		log.debug(message.getKey()+"命令数据长度："+sb.length());
		sb.insert(0, String.format("%04d",sb.length()));
		int crcData = GlobalData.CalculateCRC(sb.toString().getBytes("UTF-8"));
		
		sb.insert(0, "ST");
		sb.append(String.format("%05d", crcData));
		sb.append("TL");
		return sb;	
	}	
	
	//"getStatusData","reset","stopSound","getAlarmBound","startPump"};
	private StringBuilder encodeGetStatusData(SentBody message) throws UnsupportedEncodingException {
		return encodeSentBodyWithNoParameter(message);
	}
	
	private StringBuilder encodeReset(SentBody message) throws UnsupportedEncodingException {
		return encodeSentBodyWithNoParameter(message);
	}

	private StringBuilder encodeStopSound(SentBody message) throws UnsupportedEncodingException {
		return encodeSentBodyWithNoParameter(message);
	}
	
	private StringBuilder encodeGetAlarmBound(SentBody message) throws UnsupportedEncodingException {
		return encodeSentBodyWithNoParameter(message);
	}
	
	private StringBuilder encodeStartPump(SentBody message) throws UnsupportedEncodingException {
		return encodeSentBodyWithNoParameter(message);
	}	
	
	//"getStatusData","reset","stopSound","getAlarmBound","startPump"};
	private StringBuilder encodeSentBodyWithNoParameter(SentBody message) throws UnsupportedEncodingException {

		StringBuilder sb = new StringBuilder();
		
		sb.append(message.get(GlobalData.requestNumber));//请求码
		sb.append(GlobalData.commandNameToNumberMap.get(message.getKey()));//命令编号
		
		log.debug(message.getKey()+"命令数据长度："+sb.length());
		sb.insert(0, String.format("%04d",sb.length()));
		int crcData = GlobalData.CalculateCRC(sb.toString().getBytes("UTF-8"));
		
		sb.insert(0, "ST");
		sb.append(String.format("%05d", crcData));
		sb.append("TL");
		return sb;	
	}
	private StringBuilder encodeGetHighAlarmBound(SentBody message) throws UnsupportedEncodingException {
		return encodeSentBodyWithNoParameter(message);
	}
	private StringBuilder encodeSetHighAlarmBound(SentBody message) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		
		sb.append(message.get(GlobalData.requestNumber));//请求码
		sb.append(GlobalData.commandNameToNumberMap.get(message.getKey()));//命令编号
		sb.append(message.get(GlobalData.highAlarmBound));
		
		log.debug(message.getKey()+"命令数据长度："+sb.length());
		sb.insert(0, String.format("%04d",sb.length()));
		int crcData = GlobalData.CalculateCRC(sb.toString().getBytes("UTF-8"));
		
		sb.insert(0, "ST");
		sb.append(String.format("%05d", crcData));
		sb.append("TL");
		return sb;
	}	
	private StringBuilder encodeGetLowAlarmBound(SentBody message) throws UnsupportedEncodingException {
		return encodeSentBodyWithNoParameter(message);
	}	
	private StringBuilder encodeSetLowAlarmBound(SentBody message) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		
		sb.append(message.get(GlobalData.requestNumber));//请求码
		sb.append(GlobalData.commandNameToNumberMap.get(message.getKey()));//命令编号
		sb.append(message.get(GlobalData.lowAlarmBound));
		
		log.debug(message.getKey()+"命令数据长度："+sb.length());
		sb.insert(0, String.format("%04d",sb.length()));
		int crcData = GlobalData.CalculateCRC(sb.toString().getBytes("UTF-8"));
		
		sb.insert(0, "ST");
		sb.append(String.format("%05d", crcData));
		sb.append("TL");
		return sb;
	}		
	private StringBuilder encodeGetMaskThreshold(SentBody message) throws UnsupportedEncodingException {
		return encodeSentBodyWithNoParameter(message);
	}		
	private StringBuilder encodeSetMaskThreshold(SentBody message) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		
		sb.append(message.get(GlobalData.requestNumber));//请求码
		sb.append(GlobalData.commandNameToNumberMap.get(message.getKey()));//命令编号
		sb.append(message.get(GlobalData.maskThreshold));
		
		log.debug(message.getKey()+"命令数据长度："+sb.length());
		sb.insert(0, String.format("%04d",sb.length()));
		int crcData = GlobalData.CalculateCRC(sb.toString().getBytes("UTF-8"));
		
		sb.insert(0, "ST");
		sb.append(String.format("%05d", crcData));
		sb.append("TL");
		return sb;
	}		
	private StringBuilder encodeGetPumpRunTime(SentBody message) throws UnsupportedEncodingException {
		return encodeSentBodyWithNoParameter(message);
	}
	private StringBuilder encodeSetPumpRunTime(SentBody message) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		
		sb.append(message.get(GlobalData.requestNumber));//请求码
		sb.append(GlobalData.commandNameToNumberMap.get(message.getKey()));//命令编号
		sb.append(message.get(GlobalData.pumpRunTime));
		
		log.debug(message.getKey()+"命令数据长度："+sb.length());
		sb.insert(0, String.format("%04d",sb.length()));
		int crcData = GlobalData.CalculateCRC(sb.toString().getBytes("UTF-8"));
		
		sb.insert(0, "ST");
		sb.append(String.format("%05d", crcData));
		sb.append("TL");
		return sb;
	}	
	private StringBuilder encodeGetPumpPeriod(SentBody message) throws UnsupportedEncodingException {
		return encodeSentBodyWithNoParameter(message);
	}	
	private StringBuilder encodeSetPumpPeriod(SentBody message) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		
		sb.append(message.get(GlobalData.requestNumber));//请求码
		sb.append(GlobalData.commandNameToNumberMap.get(message.getKey()));//命令编号
		sb.append(message.get(GlobalData.pumpPeriod));
		
		log.debug(message.getKey()+"命令数据长度："+sb.length());
		sb.insert(0, String.format("%04d",sb.length()));
		int crcData = GlobalData.CalculateCRC(sb.toString().getBytes("UTF-8"));
		
		sb.insert(0, "ST");
		sb.append(String.format("%05d", crcData));
		sb.append("TL");
		return sb;
	}		
	private StringBuilder encodeGetFlowDifferenceValue(SentBody message) throws UnsupportedEncodingException {
		return encodeSentBodyWithNoParameter(message);
	}		
	private StringBuilder encodeSetFlowDifferenceValue(SentBody message) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		
		sb.append(message.get(GlobalData.requestNumber));//请求码
		sb.append(GlobalData.commandNameToNumberMap.get(message.getKey()));//命令编号
		sb.append(message.get(GlobalData.flowDifferenceValue));
		
		log.debug(message.getKey()+"命令数据长度："+sb.length());
		sb.insert(0, String.format("%04d",sb.length()));
		int crcData = GlobalData.CalculateCRC(sb.toString().getBytes("UTF-8"));
		
		sb.insert(0, "ST");
		sb.append(String.format("%05d", crcData));
		sb.append("TL");
		return sb;
	}		
	private StringBuilder encodeGetWaterInletFaultThreshold(SentBody message) throws UnsupportedEncodingException {
		return encodeSentBodyWithNoParameter(message);
	}
	private StringBuilder encodeSetWaterInletFaultThreshold(SentBody message) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		
		sb.append(message.get(GlobalData.requestNumber));//请求码
		sb.append(GlobalData.commandNameToNumberMap.get(message.getKey()));//命令编号
		sb.append(message.get(GlobalData.waterInletFaultThreshold));
		
		log.debug(message.getKey()+"命令数据长度："+sb.length());
		sb.insert(0, String.format("%04d",sb.length()));
		int crcData = GlobalData.CalculateCRC(sb.toString().getBytes("UTF-8"));
		
		sb.insert(0, "ST");
		sb.append(String.format("%05d", crcData));
		sb.append("TL");
		return sb;
	}	
	private StringBuilder encodeGetFlowFaultThreshold(SentBody message) throws UnsupportedEncodingException {
		return encodeSentBodyWithNoParameter(message);
	}	
	private StringBuilder encodeSetFlowFaultThreshold(SentBody message) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		
		sb.append(message.get(GlobalData.requestNumber));//请求码
		sb.append(GlobalData.commandNameToNumberMap.get(message.getKey()));//命令编号
		sb.append(message.get(GlobalData.flowFaultThreshold));
		
		log.debug(message.getKey()+"命令数据长度："+sb.length());
		sb.insert(0, String.format("%04d",sb.length()));
		int crcData = GlobalData.CalculateCRC(sb.toString().getBytes("UTF-8"));
		
		sb.insert(0, "ST");
		sb.append(String.format("%05d", crcData));
		sb.append("TL");
		return sb;
	}		
	private StringBuilder encodeGetSensorFaultThreshold(SentBody message) throws UnsupportedEncodingException {
		return encodeSentBodyWithNoParameter(message);
	}		
	private StringBuilder encodeSetSensorFaultThreshold(SentBody message) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		
		sb.append(message.get(GlobalData.requestNumber));//请求码
		sb.append(GlobalData.commandNameToNumberMap.get(message.getKey()));//命令编号
		sb.append(message.get(GlobalData.sensorFaultThreshold));
		
		log.debug(message.getKey()+"命令数据长度："+sb.length());
		sb.insert(0, String.format("%04d",sb.length()));
		int crcData = GlobalData.CalculateCRC(sb.toString().getBytes("UTF-8"));
		
		sb.insert(0, "ST");
		sb.append(String.format("%05d", crcData));
		sb.append("TL");
		return sb;
	}		
	private StringBuilder encodeGetStaticFlowValue(SentBody message) throws UnsupportedEncodingException {
		return encodeSentBodyWithNoParameter(message);
	}
	private StringBuilder encodeGetDynamicFlowValue(SentBody message) throws UnsupportedEncodingException {
		return encodeSentBodyWithNoParameter(message);
	}	
	private StringBuilder encodeCalibrateZeroSpot(SentBody message) throws UnsupportedEncodingException {
		return encodeSentBodyWithNoParameter(message);
	}	
}
