package com.pcm.mina.service.filter;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.keepalive.KeepAliveFilter;
import org.apache.mina.filter.keepalive.KeepAliveRequestTimeoutHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfu.gas.global.GlobalData;
import com.anfu.gas.service.aop.ServiceAdvice;

public class KeepAliveRequestTimeoutHandlerImpl implements KeepAliveRequestTimeoutHandler {
	private final static Logger log = LoggerFactory.getLogger(KeepAliveRequestTimeoutHandlerImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.apache.mina.filter.keepalive.KeepAliveRequestTimeoutHandler#
	 * keepAliveRequestTimedOut
	 * (org.apache.mina.filter.keepalive.KeepAliveFilter,
	 * org.apache.mina.core.session.IoSession)
	 */
	@Override
	public void keepAliveRequestTimedOut(KeepAliveFilter filter, IoSession session) throws Exception {
		//System.out.println("《*服务器端*》心跳包发送超时处理(及长时间没有发送（接受）心跳包)");
		log.error("《*服务器端*》心跳包发送超时处理(及长时间没有发送（接受）心跳包)");
		int timeoutCount = (Integer)session.getAttribute(GlobalData.MinaSessionKey.HEARTBEAT_RESPONSE_TIMEOUT_COUNT);
		timeoutCount++;
		if(timeoutCount>3) {
			session.setAttribute(GlobalData.MinaSessionKey.HEARTBEAT_RESPONSE_TIMEOUT_COUNT, timeoutCount);			
		}else {
			session.setAttribute(GlobalData.MinaSessionKey.HEARTBEAT_RESPONSE_TIMEOUT_COUNT, timeoutCount);	
		}
	}
}