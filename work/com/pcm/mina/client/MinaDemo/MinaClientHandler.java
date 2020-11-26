package com.pcm.mina.client.MinaDemo;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

import com.anfu.gas.global.GlobalData;
import com.pcm.mina.command.ClientCommand;
import com.pcm.mina.service.handler.RequestHandler;
import com.pcm.mina.service.model.Message;
import com.pcm.mina.service.model.ReplyBody;
import com.pcm.mina.service.model.SentBody;

/**
 * @author ZERO
 * @Description 客户端handle
 */
public class MinaClientHandler extends IoHandlerAdapter {
	private static Logger logger = Logger.getLogger(MinaClientHandler.class);
	MinaClient client;
	public MinaClientHandler(MinaClient client) {
		this.client=client;
	}
//	public MinaClientHandler(MinaClient2 client) {
//		this.client=client;
//	}	
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		logger.debug("客户端接收到的消息..." + message.toString());
		if (message instanceof ArrayList<?>) {
			@SuppressWarnings("unchecked")
			ArrayList<SentBody> commands = (ArrayList<SentBody>) message;
			ReplyBody replyBody = new ReplyBody();
			for (SentBody sentBody : commands) {
				if(sentBody.getKey().equals(GlobalData.getStatusData)) {
					replyBody=ClientCommand.makeGetStatusDataReplyCommand(client, sentBody);
				}else if(sentBody.getKey().equals(GlobalData.reset)) {
					replyBody=ClientCommand.makeResetReplyCommand(client, sentBody);
				}else if(sentBody.getKey().equals(GlobalData.stopSound)) {
					replyBody=ClientCommand.makeStopSoundReplyCommand(client, sentBody);
				}else if(sentBody.getKey().equals(GlobalData.getAlarmBound)) {
					replyBody=ClientCommand.makeGetAlarmBoundReplyCommand(client, sentBody);
				}else if(sentBody.getKey().equals(GlobalData.setAlarmBound)) {
					client.setLowAlarmAbound(sentBody.get(GlobalData.lowAlarmBound));
					client.setHighAlarmAbound(sentBody.get(GlobalData.highAlarmBound));
					replyBody=ClientCommand.makeSetAlarmBoundReplyCommand(client, sentBody);
				}else if(sentBody.getKey().equals(GlobalData.startPump)) {
					replyBody=ClientCommand.makeStartPumpReplyCommand(client, sentBody);
				}else if(sentBody.getKey().equals(GlobalData.getHighAlarmBound)) {
					replyBody=ClientCommand.makeGetHighAlarmBoundReplyCommand(client, sentBody);
				}else if(sentBody.getKey().equals(GlobalData.setHighAlarmBound)) {
					client.setHighAlarmAbound(sentBody.get(GlobalData.highAlarmBound));
					replyBody=ClientCommand.makeSetLowAlarmBoundReplyCommand(client, sentBody);
				}else if(sentBody.getKey().equals(GlobalData.getLowAlarmBound)) {
					replyBody=ClientCommand.makeGetLowAlarmBoundReplyCommand(client, sentBody);
				}else if(sentBody.getKey().equals(GlobalData.setLowAlarmBound)) {
					client.setLowAlarmAbound(sentBody.get(GlobalData.lowAlarmBound));
					replyBody=ClientCommand.makeSetLowAlarmBoundReplyCommand(client, sentBody);
				}else if(sentBody.getKey().equals(GlobalData.getMaskThreshold)) {
					replyBody=ClientCommand.makeGetMaskThresholdReplyCommand(client, sentBody);
				}else if(sentBody.getKey().equals(GlobalData.setMaskThreshold)) {
					client.setHighAlarmAbound(sentBody.get(GlobalData.maskThreshold));
					replyBody=ClientCommand.makeSetMaskThresholdReplyCommand(client, sentBody);				
				}else if(sentBody.getKey().equals(GlobalData.getPumpRunTime)) {
					replyBody=ClientCommand.makeGetPumpRunTimeReplyCommand(client, sentBody);
				}else if(sentBody.getKey().equals(GlobalData.setPumpRunTime)) {
					client.setHighAlarmAbound(sentBody.get(GlobalData.pumpRunTime));
					replyBody=ClientCommand.makeSetPumpRunTimeReplyCommand(client, sentBody);				
				}else if(sentBody.getKey().equals(GlobalData.getPumpPeriod)) {
					replyBody=ClientCommand.makeGetPumpPeriodReplyCommand(client, sentBody);
				}else if(sentBody.getKey().equals(GlobalData.setPumpPeriod)) {
					client.setHighAlarmAbound(sentBody.get(GlobalData.pumpPeriod));
					replyBody=ClientCommand.makeSetPumpPeriodReplyCommand(client, sentBody);
				}else if(sentBody.getKey().equals(GlobalData.getFlowDifferenceValue)) {
					replyBody=ClientCommand.makeGetFlowDifferenceValueReplyCommand(client, sentBody);
				}else if(sentBody.getKey().equals(GlobalData.setFlowDifferenceValue)) {
					client.setHighAlarmAbound(sentBody.get(GlobalData.flowDifferenceValue));
					replyBody=ClientCommand.makeSetFlowDifferenceValueReplyCommand(client, sentBody);
				}else if(sentBody.getKey().equals(GlobalData.getWaterInletFaultThreshold)) {
					replyBody=ClientCommand.makeGetWaterInletFaultThresholdReplyCommand(client, sentBody);
				}else if(sentBody.getKey().equals(GlobalData.setWaterInletFaultThreshold)) {
					client.setHighAlarmAbound(sentBody.get(GlobalData.waterInletFaultThreshold));
					replyBody=ClientCommand.makeSetWaterInletFaultThresholdReplyCommand(client, sentBody);
				}else if(sentBody.getKey().equals(GlobalData.getFlowFaultThreshold)) {
					replyBody=ClientCommand.makeGetFlowFaultThresholdReplyCommand(client, sentBody);
				}else if(sentBody.getKey().equals(GlobalData.setFlowFaultThreshold)) {
					client.setHighAlarmAbound(sentBody.get(GlobalData.flowFaultThreshold));
					replyBody=ClientCommand.makeSetFlowDifferenceValueReplyCommand(client, sentBody);
				}else if(sentBody.getKey().equals(GlobalData.getSensorFaultThreshold)) {
					replyBody=ClientCommand.makeGetSensorFaultThresholdReplyCommand(client, sentBody);
				}else if(sentBody.getKey().equals(GlobalData.setSensorFaultThreshold)) {
					client.setHighAlarmAbound(sentBody.get(GlobalData.sensorFaultThreshold));
					replyBody=ClientCommand.makeSetSensorFaultThresholdReplyCommand(client, sentBody);
				}else if(sentBody.getKey().equals(GlobalData.getStaticFlowValue)) {
					replyBody=ClientCommand.makeGetStaticFlowValueReplyCommand(client, sentBody);
				}else if(sentBody.getKey().equals(GlobalData.getDynamicFlowValue)) {
					replyBody=ClientCommand.makeGetDynamicFlowValueReplyCommand(client, sentBody);
				}else if(sentBody.getKey().equals(GlobalData.calibrateZeroSpot)) {
					replyBody=ClientCommand.makeCalibrateZeroSpotReplyCommand(client, sentBody);
				}else {
					logger.debug("客户端收到无效消息" + message.toString());
				}
				session.write(replyBody);// 发送消息
				logger.debug("客户端<"+replyBody.get(GlobalData.hostId)+">发送"+replyBody.getKey()+"命令，命令内筒为为:"+replyBody);
			}
		}else if(message instanceof String ) {
			if(message.equals(Message.CMD_HEARTBEAT_REQUEST)) {
				logger.debug("收到服务端发来的心跳请求包，内容为:"+message);
				session.write(Message.CMD_HEARTBEAT_RESPONSE);
				logger.debug("发送心跳返回包，内容为:"+Message.CMD_HEARTBEAT_RESPONSE);
			}
		}
	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		logger.error("发生错误...", cause);
	}
}
