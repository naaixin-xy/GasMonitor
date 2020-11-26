package com.pcm.mina.service.handler;
import org.apache.log4j.Logger;
import org.apache.mina.core.session.IoSession;

import com.pcm.mina.service.model.Message;
import com.pcm.mina.service.model.ReplyBody;

/**
 * @author ZERO
 * @Description  推送消息
 */ 
public class GetPumpPeriodHandler implements RequestHandler {

    protected final Logger logger = Logger.getLogger(GetPumpPeriodHandler.class);
    public ReplyBody process(IoSession session, ReplyBody reply) {
        String hostId=(String) reply.getData().get(Message.SESSION_KEY);
        //DefaultSessionManager sessionManager=(DefaultSessionManager) ContextHolder.getBean("PcmSessionManager");
        //IoSession session=sessionManager.getSession(hostId);
        if(session !=null){
        	logger.info("收到"+reply.getKey()+"反馈信息："+reply.toString());
        }else{

        }
        return reply;
    }
}
