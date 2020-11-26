package com.pcm.mina.service.handler;

import org.apache.log4j.Logger;
import org.apache.mina.core.session.IoSession;

import com.pcm.mina.service.model.Message;
import com.pcm.mina.service.model.ReplyBody;
import com.pcm.mina.service.session.DefaultSessionManager;
import com.pcm.util.ContextHolder;

/**
 * @author ZERO
 * @Description  断开连接，清除session
 */
public class SessionClosedHandler implements RequestHandler {
    protected final Logger logger = Logger.getLogger(SessionClosedHandler.class);
    public ReplyBody process(IoSession ios, ReplyBody message) {

        DefaultSessionManager sessionManager  =  ((DefaultSessionManager) ContextHolder.getBean("PcmSessionManager"));

        if(ios.getAttribute(Message.SESSION_KEY)==null)
        {
            return null;
        }
        String hostId = ios.getAttribute(Message.SESSION_KEY).toString();
        sessionManager.removeSession(hostId);
        return null;
    }
}
