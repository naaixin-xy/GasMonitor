package com.pcm.mina.service.handler;



import org.apache.log4j.Logger;
import org.apache.mina.core.session.IoSession;
import org.springframework.stereotype.Component;

import com.anfu.gas.global.GlobalData;
import com.pcm.mina.service.model.Message;
import com.pcm.mina.service.model.ReplyBody;
import com.pcm.mina.service.session.DefaultSessionManager;
import com.pcm.util.ContextHolder;

/**
 * @author ZERO
 * @Description 账号绑定实现
 */

public class BindHandler implements RequestHandler {
	protected final Logger logger = Logger.getLogger(BindHandler.class);

	public ReplyBody process(IoSession newSession, ReplyBody message) {
		ReplyBody reply = new ReplyBody();
		DefaultSessionManager sessionManager = ((DefaultSessionManager) ContextHolder.getBean("PcmSessionManager"));
		try {
			String hostId = message.get(Message.SESSION_KEY);
			newSession.setAttribute(GlobalData.hostId, message.get(GlobalData.hostId));
			newSession.setAttribute(GlobalData.detectorId, message.get(GlobalData.detectorId));
			/**
			 * 由于客户端断线服务端可能会无法获知的情况，客户端重连时，需要关闭旧的连接
			 */
			IoSession oldSession = sessionManager.getSession(hostId);
			// 如果是账号已经在另一台终端登录。则让另一个终端下线
			if (oldSession != null && !(oldSession.getId()==newSession.getId())) {
				oldSession.removeAttribute(Message.SESSION_KEY);
				// oldSession.write(rb);
				oldSession.close(true);
				oldSession = null;
			}
			if (oldSession == null) {
				sessionManager.addSession(hostId, newSession);
			}

			// reply.setCode(Message.ReturnCode.CODE_200);
		} catch (Exception e) {
			// reply.setCode(Message.ReturnCode.CODE_500);
			e.printStackTrace();
		}
		logger.info("绑定主机:" + message.get(Message.SESSION_KEY) + "-----------------------------" + message.getCode());
		// reply.setMessage("绑定成功");
		return reply;
	}
}
