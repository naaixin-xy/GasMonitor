package com.pcm.mina.filter.codec;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.apache.mina.filter.codec.demux.MessageEncoder;

import com.anfu.gas.global.GlobalData;
import com.anfu.mina.command.ParentCommand;
import com.anfu.mina.command.interact.ExecuteResult;
import com.anfu.mina.command.interact.NoticeAnswer;
import com.anfu.mina.command.interact.RequestAnswer;

import net.sf.json.JSONObject;

public class MonitorServerEncoderJson implements MessageEncoder<ParentCommand> {
	@Override
	public void encode(IoSession session, ParentCommand message, ProtocolEncoderOutput out) throws Exception {
		String commandString;
		if (message instanceof ExecuteResult) {
			commandString = makeExecuteResult((ExecuteResult)message);
		}else if(message instanceof RequestAnswer){
			commandString = makeRequestAnswer((RequestAnswer)message);			
		}else if(message instanceof NoticeAnswer){
			commandString = makeNoticeAnswer((NoticeAnswer)message);			
		}else{	
			//无效命令
			return;
		}
		if(commandString==null){
			Exception e = new Exception();
			throw e;
		}else{
			IoBuffer buffer= IoBuffer.allocate(4).setAutoExpand(true);
			buffer.putString(commandString,Charset.forName("UTF-8").newEncoder());
			buffer.flip();
			out.write(buffer);
		}
	}
	
	private String makeExecuteResult(ExecuteResult command) {
		JSONObject commandJsonObject = null;
		try {
			commandJsonObject = new JSONObject();
			if (command.getSystem() != null) {
				commandJsonObject.put("ST", "SystemInteract");
			}
			commandJsonObject.put("CN", command.getCommandName());
			if (command.getPassword() != null) {
				commandJsonObject.put("PW", command.getPassword());
			}
			if (command.getMachineNumber() != null) {
				commandJsonObject.put("MN", command.getMachineNumber());
			}
			if (command.getReplyFlag() != null) {
				commandJsonObject.put("Flag", "false");
			}

			JSONObject commandParameterJson = new JSONObject();
			commandParameterJson.put("QN", command.getQuestNumber());
			commandParameterJson.put("ExeRtn", command.getExecuteReturn());
			commandJsonObject.put("CP", commandParameterJson);
			JSONObject dataPacketJson = new JSONObject();
			String commandString = commandJsonObject.toString();
			try {
				dataPacketJson.put("DataLen", commandString.getBytes("UTF-8").length);
				dataPacketJson.put("DataContent", commandString);
				dataPacketJson.put("DataCRC", GlobalData.CalculateCRC(commandString.getBytes("UTF-8")));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			commandString = dataPacketJson.toString();
			StringBuilder strBuilder = new StringBuilder();
			strBuilder.append("开始@@@@@@@@@@start").append(commandString).append("end@@@@@@@@@@结束");
			return strBuilder.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private String makeRequestAnswer(RequestAnswer command) {
		JSONObject commandJsonObject = null;
		try {
			commandJsonObject = new JSONObject();
			if (command.getSystem() != null) {
				commandJsonObject.put("ST", "SystemInteract");
			}
			commandJsonObject.put("CN", command.getCommandName());
			if (command.getPassword() != null) {
				commandJsonObject.put("PW", command.getPassword());
			}
			if (command.getMachineNumber() != null) {
				commandJsonObject.put("MN", command.getMachineNumber());
			}
			if (command.getReplyFlag() != null) {
				commandJsonObject.put("Flag", "false");
			}

			JSONObject commandParameterJson = new JSONObject();
			commandParameterJson.put("QN", command.getQuestNumber());
			commandParameterJson.put("QnRtn", command.getRequestReturn());
			commandJsonObject.put("CP", commandParameterJson);
			JSONObject dataPacketJson = new JSONObject();
			String commandString = commandJsonObject.toString();
			try {
				dataPacketJson.put("DataLen", commandString.getBytes("UTF-8").length);
				dataPacketJson.put("DataContent", commandString);
				dataPacketJson.put("DataCRC", GlobalData.CalculateCRC(commandString.getBytes("UTF-8")));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			commandString = dataPacketJson.toString();
			StringBuilder strBuilder = new StringBuilder();
			strBuilder.append("开始@@@@@@@@@@start").append(commandString).append("end@@@@@@@@@@结束");
			return strBuilder.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private String makeNoticeAnswer(NoticeAnswer command) {
		JSONObject commandJsonObject = null;
		try {
			commandJsonObject = new JSONObject();
			if (command.getSystem() != null) {
				commandJsonObject.put("ST", "SystemInteract");
			}
			commandJsonObject.put("CN", command.getCommandName());
			if (command.getPassword() != null) {
				commandJsonObject.put("PW", command.getPassword());
			}
			if (command.getMachineNumber() != null) {
				commandJsonObject.put("MN", command.getMachineNumber());
			}
			if (command.getReplyFlag() != null) {
				commandJsonObject.put("Flag", "false");
			}

			JSONObject commandParameterJson = new JSONObject();
			commandParameterJson.put("QN", command.getQuestNumber());
			commandParameterJson.put("NtcRtn", command.getNoticeReturn());
			commandJsonObject.put("CP", commandParameterJson);
			JSONObject dataPacketJson = new JSONObject();
			String commandString = commandJsonObject.toString();
			try {
				dataPacketJson.put("DataLen", commandString.getBytes("UTF-8").length);
				dataPacketJson.put("DataContent", commandString);
				dataPacketJson.put("DataCRC", GlobalData.CalculateCRC(commandString.getBytes("UTF-8")));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			commandString = dataPacketJson.toString();
			StringBuilder strBuilder = new StringBuilder();
			strBuilder.append("开始@@@@@@@@@@start").append(commandString).append("end@@@@@@@@@@结束");
			return strBuilder.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}		
}
