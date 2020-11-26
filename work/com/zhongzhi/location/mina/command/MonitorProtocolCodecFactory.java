package com.zhongzhi.location.mina.command;

import org.apache.mina.filter.codec.demux.DemuxingProtocolCodecFactory;

import com.anfu.mina.bean.ResultMessage;
import com.anfu.mina.bean.SendMessage;
import com.anfu.mina.client.MonitorClientDecoderHeartBeat;
import com.anfu.mina.client.MonitorClientDecoderJson;
import com.anfu.mina.client.MonitorClientEncoderJson;
import com.anfu.mina.client.MonitorClientEncoderString;
import com.anfu.mina.command.ParentCommand;

public class MonitorProtocolCodecFactory extends DemuxingProtocolCodecFactory {
	public MonitorProtocolCodecFactory(boolean server) {
		if (server) {
			super.addMessageEncoder(ParentCommand.class, MonitorServerEncoderJson.class);
			super.addMessageEncoder(String.class, MonitorServerEncoderHeartBeat.class);
			//super.addMessageDecoder(MonitorServerDecoderOther.class);
			super.addMessageDecoder(MonitorServerDecoderJson.class);
			super.addMessageDecoder(MonitorServerDecoderHeartBeat.class);
		} else {
			super.addMessageEncoder(ParentCommand.class, MonitorClientEncoderJson.class);	
			super.addMessageEncoder(String.class, MonitorClientEncoderString.class);
			super.addMessageDecoder(MonitorClientDecoderJson.class);
			super.addMessageDecoder(MonitorClientDecoderHeartBeat.class);
		}
	}
}
