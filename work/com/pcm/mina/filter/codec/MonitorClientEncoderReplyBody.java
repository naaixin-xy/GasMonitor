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
import com.pcm.mina.service.model.ReplyBody;

public class MonitorClientEncoderReplyBody implements MessageEncoder<ReplyBody> {
	private final static Logger log = LoggerFactory.getLogger(MonitorClientEncoderReplyBody.class);	
	@Override
	public void encode(IoSession session, ReplyBody message, ProtocolEncoderOutput out) throws Exception {
		StringBuilder sb = new StringBuilder();

		if (message.getKey().equals(GlobalData.getStatusData)) {
			sb = encodeGetStatusData(message);
		} else if (message.getKey().equals(GlobalData.reset)) {
			sb = encodeReset(message);
		} else if (message.getKey().equals(GlobalData.stopSound)) {
			sb = encodeStopSound(message);
		} else if (message.getKey().equals(GlobalData.getAlarmBound)) {
			sb = encodeGetAlarmBound(message);
		} else if (message.getKey().equals(GlobalData.setAlarmBound)) {
			sb = encodeSetAlarmBound(message);
		} else if (message.getKey().equals(GlobalData.startPump)) {
			sb = encodeStartPump(message);
		} else if (message.getKey().equals(GlobalData.getHighAlarmBound)) {
			sb = encodeGetHighAlarmBound(message);
		} else if (message.getKey().equals(GlobalData.setHighAlarmBound)) {
			sb = encodeSetHighAlarmBound(message);
		} else if (message.getKey().equals(GlobalData.getLowAlarmBound)) {
			sb = encodeGetLowAlarmBound(message);
		} else if (message.getKey().equals(GlobalData.setLowAlarmBound)) {
			sb = encodeSetLowAlarmBound(message);
		} else if (message.getKey().equals(GlobalData.getMaskThreshold)) {
			sb = encodeGetMaskThreshold(message);
		} else if (message.getKey().equals(GlobalData.setMaskThreshold)) {
			sb = encodeSetMaskThreshold(message);
		} else if (message.getKey().equals(GlobalData.getPumpRunTime)) {
			sb = encodeGetPumpRunTime(message);
		} else if (message.getKey().equals(GlobalData.setPumpRunTime)) {
			sb = encodeSetPumpRunTime(message);
		} else if (message.getKey().equals(GlobalData.getPumpPeriod)) {
			sb = encodeGetPumpPeriod(message);
		} else if (message.getKey().equals(GlobalData.setPumpPeriod)) {
			sb = encodeSetPumpPeriod(message);
		} else if (message.getKey().equals(GlobalData.getFlowDifferenceValue)) {
			sb = encodeGetFlowDifferenceValue(message);
		} else if (message.getKey().equals(GlobalData.setFlowDifferenceValue)) {
			sb = encodeSetFlowDifferenceValue(message);
		} else if (message.getKey().equals(GlobalData.getWaterInletFaultThreshold)) {
			sb = encodeGetWaterInletFaultThreshold(message);
		} else if (message.getKey().equals(GlobalData.setWaterInletFaultThreshold)) {
			sb = encodeSetWaterInletFaultThreshold(message);
		} else if (message.getKey().equals(GlobalData.getFlowFaultThreshold)) {
			sb = encodeGetFlowFaultThreshold(message);
		} else if (message.getKey().equals(GlobalData.setFlowFaultThreshold)) {
			sb = encodeSetFlowFaultThreshold(message);
		} else if (message.getKey().equals(GlobalData.getSensorFaultThreshold)) {
			sb = encodeGetSensorFaultThreshold(message);
		} else if (message.getKey().equals(GlobalData.setSensorFaultThreshold)) {
			sb = encodeSetSensorFaultThreshold(message);
		} else if (message.getKey().equals(GlobalData.getStaticFlowValue)) {
			sb = encodeGetStaticFlowValue(message);
		} else if (message.getKey().equals(GlobalData.getDynamicFlowValue)) {
			sb = encodeGetDynamicFlowValue(message);
		} else if (message.getKey().equals(GlobalData.calibrateZeroSpot)) {
			sb = encodeCalibrateZeroSpot(message);
		}

		IoBuffer buffer = IoBuffer.allocate(4).setAutoExpand(true);
		buffer.putString(sb.toString(), Charset.forName("UTF-8").newEncoder());
		buffer.flip();
		out.write(buffer);
	}

	private StringBuilder encodeGetAlarmBound(ReplyBody message) throws UnsupportedEncodingException {

		StringBuilder sb = new StringBuilder();

		sb.append(message.get(GlobalData.requestNumber));// 请求码
		sb.append(GlobalData.commandNameToNumberMap.get(message.getKey()));// 命令编号
		sb.append(message.getCode());// 执行结果
		sb.append(message.get(GlobalData.hostId));// hostId
		sb.append(message.get(GlobalData.detectorId));
		sb.append(message.get(GlobalData.highAlarmBound));// 命令编号
		sb.append(message.get(GlobalData.lowAlarmBound));

		log.debug("getAlarmBound命令数据长度：" + sb.length());
		sb.insert(0, String.format("%04d", sb.length()));
		int crcData = GlobalData.CalculateCRC(sb.toString().getBytes("UTF-8"));

		sb.insert(0, "ST");
		sb.append(String.format("%05d", crcData));
		sb.append("TL");
		return sb;
	}

	// "getStatusData","reset","stopSound","getAlarmBound","startPump"};
	private StringBuilder encodeGetStatusData(ReplyBody message) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();

		sb.append(message.get(GlobalData.requestNumber));// 请求码
		sb.append(GlobalData.commandNameToNumberMap.get(message.getKey()));// 命令编号
		sb.append(message.getCode());// 执行结果
		sb.append(message.get(GlobalData.hostId));// hostId
		sb.append(message.get(GlobalData.detectorId));
		sb.append(message.get(GlobalData.alarmStatus));
		sb.append(message.get(GlobalData.faultStatus));
		sb.append(message.get(GlobalData.maskStatus));
		sb.append(message.get(GlobalData.gasConcentration));
		sb.append(message.get(GlobalData.highAlarmBound));
		sb.append(message.get(GlobalData.lowAlarmBound));
		sb.append(message.get(GlobalData.relayStatus));

		log.debug(message.getKey() + "命令数据长度：" + sb.length());
		sb.insert(0, String.format("%04d", sb.length()));
		int crcData = GlobalData.CalculateCRC(sb.toString().getBytes("UTF-8"));

		sb.insert(0, "ST");
		sb.append(String.format("%05d", crcData));
		sb.append("TL");
		return sb;
	}

	private StringBuilder encodeReset(ReplyBody message) throws UnsupportedEncodingException {
		return encodeReplyBodyWithNoParameter(message);
	}

	private StringBuilder encodeStopSound(ReplyBody message) throws UnsupportedEncodingException {
		return encodeReplyBodyWithNoParameter(message);
	}

	private StringBuilder encodeSetAlarmBound(ReplyBody message) throws UnsupportedEncodingException {
		return encodeReplyBodyWithNoParameter(message);
	}

	private StringBuilder encodeStartPump(ReplyBody message) throws UnsupportedEncodingException {
		return encodeReplyBodyWithNoParameter(message);
	}

	// "getStatusData","reset","stopSound","getAlarmBound","startPump"};
	private StringBuilder encodeReplyBodyWithNoParameter(ReplyBody message) throws UnsupportedEncodingException {

		StringBuilder sb = new StringBuilder();

		sb.append(message.get(GlobalData.requestNumber));// 请求码
		sb.append(GlobalData.commandNameToNumberMap.get(message.getKey()));// 命令编号
		sb.append(message.getCode());// 执行结果
		sb.append(message.get(GlobalData.hostId));// hostId
		sb.append(message.get(GlobalData.detectorId));

		log.debug(message.getKey() + "命令数据长度：" + sb.length());
		sb.insert(0, String.format("%04d", sb.length()));
		int crcData = GlobalData.CalculateCRC(sb.toString().getBytes("UTF-8"));
		sb.insert(0, "ST");
		sb.append(String.format("%05d", crcData));
		sb.append("TL");

		return sb;
	}

	private StringBuilder encodeGetHighAlarmBound(ReplyBody message) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();

		sb.append(message.get(GlobalData.requestNumber));// 请求码
		sb.append(GlobalData.commandNameToNumberMap.get(message.getKey()));// 命令编号
		sb.append(message.getCode());// 执行结果
		sb.append(message.get(GlobalData.hostId));// hostId
		sb.append(message.get(GlobalData.detectorId));
		sb.append(message.get(GlobalData.highAlarmBound));// 命令编号

		log.debug("getAlarmBound命令数据长度：" + sb.length());
		sb.insert(0, String.format("%04d", sb.length()));
		int crcData = GlobalData.CalculateCRC(sb.toString().getBytes("UTF-8"));

		sb.insert(0, "ST");
		sb.append(String.format("%05d", crcData));
		sb.append("TL");
		return sb;
	}

	private StringBuilder encodeSetHighAlarmBound(ReplyBody message) throws UnsupportedEncodingException {
		return encodeReplyBodyWithNoParameter(message);
	}

	private StringBuilder encodeGetLowAlarmBound(ReplyBody message) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();

		sb.append(message.get(GlobalData.requestNumber));// 请求码
		sb.append(GlobalData.commandNameToNumberMap.get(message.getKey()));// 命令编号
		sb.append(message.getCode());// 执行结果
		sb.append(message.get(GlobalData.hostId));// hostId
		sb.append(message.get(GlobalData.detectorId));
		sb.append(message.get(GlobalData.lowAlarmBound));

		log.debug("getAlarmBound命令数据长度：" + sb.length());
		sb.insert(0, String.format("%04d", sb.length()));
		int crcData = GlobalData.CalculateCRC(sb.toString().getBytes("UTF-8"));

		sb.insert(0, "ST");
		sb.append(String.format("%05d", crcData));
		sb.append("TL");
		return sb;
	}

	private StringBuilder encodeSetLowAlarmBound(ReplyBody message) throws UnsupportedEncodingException {
		return encodeReplyBodyWithNoParameter(message);
	}

	private StringBuilder encodeGetMaskThreshold(ReplyBody message) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();

		sb.append(message.get(GlobalData.requestNumber));// 请求码
		sb.append(GlobalData.commandNameToNumberMap.get(message.getKey()));// 命令编号
		sb.append(message.getCode());// 执行结果
		sb.append(message.get(GlobalData.hostId));// hostId
		sb.append(message.get(GlobalData.detectorId));
		sb.append(message.get(GlobalData.maskThreshold));

		log.debug("getAlarmBound命令数据长度：" + sb.length());
		sb.insert(0, String.format("%04d", sb.length()));
		int crcData = GlobalData.CalculateCRC(sb.toString().getBytes("UTF-8"));

		sb.insert(0, "ST");
		sb.append(String.format("%05d", crcData));
		sb.append("TL");
		return sb;
	}

	private StringBuilder encodeSetMaskThreshold(ReplyBody message) throws UnsupportedEncodingException {
		return encodeReplyBodyWithNoParameter(message);
	}

	private StringBuilder encodeGetPumpRunTime(ReplyBody message) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();

		sb.append(message.get(GlobalData.requestNumber));// 请求码
		sb.append(GlobalData.commandNameToNumberMap.get(message.getKey()));// 命令编号
		sb.append(message.getCode());// 执行结果
		sb.append(message.get(GlobalData.hostId));// hostId
		sb.append(message.get(GlobalData.detectorId));
		sb.append(message.get(GlobalData.pumpRunTime));

		log.debug("getAlarmBound命令数据长度：" + sb.length());
		sb.insert(0, String.format("%04d", sb.length()));
		int crcData = GlobalData.CalculateCRC(sb.toString().getBytes("UTF-8"));

		sb.insert(0, "ST");
		sb.append(String.format("%05d", crcData));
		sb.append("TL");
		return sb;
	}

	private StringBuilder encodeSetPumpRunTime(ReplyBody message) throws UnsupportedEncodingException {
		return encodeReplyBodyWithNoParameter(message);
	}

	private StringBuilder encodeGetPumpPeriod(ReplyBody message) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();

		sb.append(message.get(GlobalData.requestNumber));// 请求码
		sb.append(GlobalData.commandNameToNumberMap.get(message.getKey()));// 命令编号
		sb.append(message.getCode());// 执行结果
		sb.append(message.get(GlobalData.hostId));// hostId
		sb.append(message.get(GlobalData.detectorId));
		sb.append(message.get(GlobalData.pumpPeriod));

		log.debug("getAlarmBound命令数据长度：" + sb.length());
		sb.insert(0, String.format("%04d", sb.length()));
		int crcData = GlobalData.CalculateCRC(sb.toString().getBytes("UTF-8"));

		sb.insert(0, "ST");
		sb.append(String.format("%05d", crcData));
		sb.append("TL");
		return sb;
	}

	private StringBuilder encodeSetPumpPeriod(ReplyBody message) throws UnsupportedEncodingException {
		return encodeReplyBodyWithNoParameter(message);
	}

	private StringBuilder encodeGetFlowDifferenceValue(ReplyBody message) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();

		sb.append(message.get(GlobalData.requestNumber));// 请求码
		sb.append(GlobalData.commandNameToNumberMap.get(message.getKey()));// 命令编号
		sb.append(message.getCode());// 执行结果
		sb.append(message.get(GlobalData.hostId));// hostId
		sb.append(message.get(GlobalData.detectorId));
		sb.append(message.get(GlobalData.flowDifferenceValue));

		log.debug("getAlarmBound命令数据长度：" + sb.length());
		sb.insert(0, String.format("%04d", sb.length()));
		int crcData = GlobalData.CalculateCRC(sb.toString().getBytes("UTF-8"));

		sb.insert(0, "ST");
		sb.append(String.format("%05d", crcData));
		sb.append("TL");
		return sb;
	}

	private StringBuilder encodeSetFlowDifferenceValue(ReplyBody message) throws UnsupportedEncodingException {
		return encodeReplyBodyWithNoParameter(message);
	}

	private StringBuilder encodeGetWaterInletFaultThreshold(ReplyBody message) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();

		sb.append(message.get(GlobalData.requestNumber));// 请求码
		sb.append(GlobalData.commandNameToNumberMap.get(message.getKey()));// 命令编号
		sb.append(message.getCode());// 执行结果
		sb.append(message.get(GlobalData.hostId));// hostId
		sb.append(message.get(GlobalData.detectorId));
		sb.append(message.get(GlobalData.waterInletFaultThreshold));

		log.debug("getAlarmBound命令数据长度：" + sb.length());
		sb.insert(0, String.format("%04d", sb.length()));
		int crcData = GlobalData.CalculateCRC(sb.toString().getBytes("UTF-8"));

		sb.insert(0, "ST");
		sb.append(String.format("%05d", crcData));
		sb.append("TL");
		return sb;
	}

	private StringBuilder encodeSetWaterInletFaultThreshold(ReplyBody message) throws UnsupportedEncodingException {
		return encodeReplyBodyWithNoParameter(message);
	}

	private StringBuilder encodeGetFlowFaultThreshold(ReplyBody message) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();

		sb.append(message.get(GlobalData.requestNumber));// 请求码
		sb.append(GlobalData.commandNameToNumberMap.get(message.getKey()));// 命令编号
		sb.append(message.getCode());// 执行结果
		sb.append(message.get(GlobalData.hostId));// hostId
		sb.append(message.get(GlobalData.detectorId));
		sb.append(message.get(GlobalData.flowFaultThreshold));

		log.debug("getAlarmBound命令数据长度：" + sb.length());
		sb.insert(0, String.format("%04d", sb.length()));
		int crcData = GlobalData.CalculateCRC(sb.toString().getBytes("UTF-8"));

		sb.insert(0, "ST");
		sb.append(String.format("%05d", crcData));
		sb.append("TL");
		return sb;
	}

	private StringBuilder encodeSetFlowFaultThreshold(ReplyBody message) throws UnsupportedEncodingException {
		return encodeReplyBodyWithNoParameter(message);
	}

	private StringBuilder encodeGetSensorFaultThreshold(ReplyBody message) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();

		sb.append(message.get(GlobalData.requestNumber));// 请求码
		sb.append(GlobalData.commandNameToNumberMap.get(message.getKey()));// 命令编号
		sb.append(message.getCode());// 执行结果
		sb.append(message.get(GlobalData.hostId));// hostId
		sb.append(message.get(GlobalData.detectorId));
		sb.append(message.get(GlobalData.sensorFaultThreshold));

		log.debug("getAlarmBound命令数据长度：" + sb.length());
		sb.insert(0, String.format("%04d", sb.length()));
		int crcData = GlobalData.CalculateCRC(sb.toString().getBytes("UTF-8"));

		sb.insert(0, "ST");
		sb.append(String.format("%05d", crcData));
		sb.append("TL");
		return sb;
	}

	private StringBuilder encodeSetSensorFaultThreshold(ReplyBody message) throws UnsupportedEncodingException {
		return encodeReplyBodyWithNoParameter(message);
	}

	private StringBuilder encodeGetStaticFlowValue(ReplyBody message) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();

		sb.append(message.get(GlobalData.requestNumber));// 请求码
		sb.append(GlobalData.commandNameToNumberMap.get(message.getKey()));// 命令编号
		sb.append(message.getCode());// 执行结果
		sb.append(message.get(GlobalData.hostId));// hostId
		sb.append(message.get(GlobalData.detectorId));
		sb.append(message.get(GlobalData.staticFlowValue));

		log.debug("getAlarmBound命令数据长度：" + sb.length());
		sb.insert(0, String.format("%04d", sb.length()));
		int crcData = GlobalData.CalculateCRC(sb.toString().getBytes("UTF-8"));

		sb.insert(0, "ST");
		sb.append(String.format("%05d", crcData));
		sb.append("TL");
		return sb;
	}

	private StringBuilder encodeGetDynamicFlowValue(ReplyBody message) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();

		sb.append(message.get(GlobalData.requestNumber));// 请求码
		sb.append(GlobalData.commandNameToNumberMap.get(message.getKey()));// 命令编号
		sb.append(message.getCode());// 执行结果
		sb.append(message.get(GlobalData.hostId));// hostId
		sb.append(message.get(GlobalData.detectorId));
		sb.append(message.get(GlobalData.dynamicFlowValue));

		log.debug("getAlarmBound命令数据长度：" + sb.length());
		sb.insert(0, String.format("%04d", sb.length()));
		int crcData = GlobalData.CalculateCRC(sb.toString().getBytes("UTF-8"));

		sb.insert(0, "ST");
		sb.append(String.format("%05d", crcData));
		sb.append("TL");
		return sb;
	}

	private StringBuilder encodeCalibrateZeroSpot(ReplyBody message) throws UnsupportedEncodingException {
		return encodeReplyBodyWithNoParameter(message);
	}
}
