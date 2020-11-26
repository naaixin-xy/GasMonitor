package com.pcm.mina.service.handler;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.springframework.stereotype.Component;

import com.anfu.gas.global.GlobalData;
import com.pcm.mina.command.ServerCommand;
import com.pcm.mina.service.model.Message;
import com.pcm.mina.service.model.ReplyBody;
import com.pcm.mina.service.model.SentBody;

/**
 * @author ZERO
 * @Description I/O 处理器 客户端请求的入口，所有请求都首先经过它分发处理 业务逻辑实现
 */

@Component("sercixeMainHandler")
public class ServiceMainHandler extends IoHandlerAdapter {
	protected final Logger logger = Logger.getLogger(ServiceMainHandler.class);

	// 本地handler请求
	private HashMap<String, RequestHandler> handlers = new HashMap<String, RequestHandler>();

	// 出错时
	@Override
	public void exceptionCaught(IoSession session, Throwable cause) {
		logger.error("exceptionCaught()... from " + session.getRemoteAddress());
		logger.error(cause);
		session.getService();
		cause.printStackTrace();
	}

	// 接收到消息时
	@Override
	public void messageReceived(IoSession iosession, Object message) {
		logger.info("服务端接收到的消息..." + message.toString());
		if (message instanceof ArrayList<?>) {
			@SuppressWarnings("unchecked")
			ArrayList<ReplyBody> commands = (ArrayList<ReplyBody>) message;
			//PcmSession session = new PcmSession(iosession);
			SentBody sb = new SentBody();
			//如果IoSession，没有绑定控制器，进行绑定操作
			if(iosession.getAttribute(Message.SESSION_KEY)==null) {
				logger.info("需要客户端绑定绑定");
				RequestHandler rhandler = handlers.get("client_bind");
				rhandler.process(iosession, commands.get(0));
				
			}
			for (ReplyBody command : commands) {
				// 根据key的不同调用不同的handler
				RequestHandler rhandler = handlers.get(command.getKey());
				if (rhandler == null) {// 如果没有这个handler
					// sb.setCode(Message.ReturnCode.CODE_405);
					// sb.setMessage("服务端未定义!");
					logger.info("服务端未定义");
				} else {// 有的话
					rhandler.process(iosession, command);
					logger.info("服务端接受返回消息: " + message.toString());
				}
			}
		}
//		if (message instanceof SentBody) {
//			//SentBody sent = (SentBody) message;
//			ReplyBody rb = new ReplyBody();
//			PcmSession session = new PcmSession(iosession);
//			String key = sent.getKey();
//			if ("quit".equals(sent.get("message"))) { // 服务器断开的条件
//				try {
//					sessionClosed(iosession);
//				} catch (Exception e) {
//					rb.setCode(Message.ReturnCode.CODE_500);
//					e.printStackTrace();
//				}
//			} else {
//				// 根据key的不同调用不同的handler
//				RequestHandler rhandler = handlers.get(key);
//				if (rhandler == null) {// 如果没有这个handler
//					rb.setCode(Message.ReturnCode.CODE_405);
//					rb.setMessage("服务端未定义!");
//				} else {// 有的话
//					rb = rhandler.process(session, sent);
//				}
//			}
//			if (rb != null) {
//				rb.setKey(key);
//				session.write(rb);
//				logger.info("服务端发送的消息: " + rb.toString());
//			}
//
//		}
	}

	// 发送消息
	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		// session.close(); //发送成功后主动断开与客户端的连接 实现短连接
		logger.info("服务端发送信息成功...");
	}

	// 建立连接时
	@Override
	public void sessionCreated(IoSession session) throws Exception {
		InetSocketAddress sa = (InetSocketAddress) session.getRemoteAddress();
		String address = sa.getAddress().getHostAddress(); // 访问的ip
		session.setAttribute("address", address);
		session.setAttribute(GlobalData.MinaSessionKey.HEARTBEAT_RESPONSE_TIMEOUT_COUNT, 0);
		// 将连接的客户端ip保存到map集合中
		SentBody body = new SentBody();
		body.put("address", address);
		logger.info("访问的ip:" + address);
	}

	// 关闭连接时
	@Override
	public void sessionClosed(IoSession iosession) throws Exception {
		//PcmSession session = new PcmSession(iosession);
		logger.debug("sessionClosed()... from " + iosession.getRemoteAddress());
		try {
			RequestHandler hand = handlers.get("client_closs");
			if (hand != null && iosession.containsAttribute(Message.SESSION_KEY)) {
				hand.process(iosession, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		iosession.close(true);
		logger.info("连接关闭");
	}

	// 空闲时
	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		logger.debug("sessionIdle()... from " + session.getRemoteAddress());
	}

	// 打开连接时
	@Override
	public void sessionOpened(IoSession session) throws Exception {
		//链接开启后发送状态数据读取命令，完成客户端绑定及状态更新操作
		session.write(ServerCommand.makeGetStatusDataSentCommand());
		logger.info("开启连接...");
	}

	public HashMap<String, RequestHandler> getHandlers() {
		return handlers;
	}

	public void setHandlers(HashMap<String, RequestHandler> handlers) {
		this.handlers = handlers;
	}
}
