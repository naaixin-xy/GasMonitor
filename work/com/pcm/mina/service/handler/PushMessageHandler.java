package com.pcm.mina.service.handler;
import org.apache.log4j.Logger;
import org.apache.mina.core.session.IoSession;

import com.pcm.mina.service.model.Message;
import com.pcm.mina.service.model.ReplyBody;
import com.pcm.mina.service.session.DefaultSessionManager;
import com.pcm.util.ContextHolder;

/**
 * @author ZERO
 * @Description  推送消息
 */ 
public class PushMessageHandler implements RequestHandler {

    protected final Logger logger = Logger.getLogger(PushMessageHandler.class);
    public ReplyBody process(IoSession ios, ReplyBody sent) {
        ReplyBody reply = new ReplyBody();
        String account=(String) sent.getData().get(Message.SESSION_KEY);
        DefaultSessionManager sessionManager=(DefaultSessionManager) ContextHolder.getBean("PcmSessionManager");
        IoSession session=sessionManager.getSession(account);
        if(session !=null){
            sent.remove(Message.SESSION_KEY);
            reply.setKey(sent.getKey());
            reply.setMessage("推送的消息");
            reply.setData(sent.getData());
            reply.setCode(Message.ReturnCode.CODE_200); 
            session.write(reply); //转发获取的消息
            logger.info("推送的消息是:"+reply.toString());
        }else{
            reply.setCode(Message.ReturnCode.CODE_403);
            reply.setMessage("推送失败");
        }
        return reply;
    }
}
