package com.pcm.mina.filter.codec;

import org.apache.mina.filter.codec.demux.DemuxingProtocolCodecFactory;

import com.pcm.mina.service.model.ReplyBody;
import com.pcm.mina.service.model.SentBody;

public class MonitorProtocolCodecFactory extends DemuxingProtocolCodecFactory {
	public MonitorProtocolCodecFactory(boolean server) {
		if (server) {
			super.addMessageEncoder(SentBody.class, MonitorServerEncoderSentBody.class);
			super.addMessageEncoder(String.class, MonitorServerEncoderHeartBeat.class);
			super.addMessageDecoder(MonitorServerDecoderHeartBeat.class);
			super.addMessageDecoder(MonitorServerDecoderReplyBody.class);
			
		} else {
			super.addMessageEncoder(ReplyBody.class, MonitorClientEncoderReplyBody.class);	
			super.addMessageEncoder(String.class, MonitorClientEncoderHeartBeat.class);
			super.addMessageDecoder(MonitorClientDecoderHeartBeat.class);
			super.addMessageDecoder(MonitorClientDecoderSentBody.class);
			
		}
	}
}