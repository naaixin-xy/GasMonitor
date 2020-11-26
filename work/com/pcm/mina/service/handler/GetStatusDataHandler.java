package com.pcm.mina.service.handler;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.mina.core.session.IoSession;
import com.anfu.gas.service.GasDeviceStatusDataService;
import com.pcm.mina.service.model.ReplyBody;

/**
 * @author ZERO
 * @Description  推送消息
 */ 
public class GetStatusDataHandler implements RequestHandler {
	@Resource(name="gasDeviceStatusDataService")
	GasDeviceStatusDataService gasDeviceStatusDataService;
    protected final Logger logger = Logger.getLogger(GetStatusDataHandler.class);
    public ReplyBody process(IoSession session, ReplyBody reply) {
    	gasDeviceStatusDataService.processGetStatusData(session,reply);
        return reply;
    }
}
