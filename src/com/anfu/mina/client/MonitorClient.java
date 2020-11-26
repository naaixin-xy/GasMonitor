package com.anfu.mina.client;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.logging.LogLevel;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfu.mina.server.MonitorProtocolCodecFactory;

public class MonitorClient {

	private IoConnector connector;
	private MonitorClientHandler handler;
	private IoSession session;
	public IoSession getSession() {
		return session;
	}


	public void setSession(IoSession session) {
		this.session = session;
	}


	private final static Logger log = LoggerFactory.getLogger(MonitorClient.class);

	public MonitorClient() throws UnknownHostException {
	
		LoggingFilter lf = new LoggingFilter();
		lf.setMessageReceivedLogLevel(LogLevel.ERROR);
		lf.setMessageSentLogLevel(LogLevel.ERROR);
		connector = new NioSocketConnector();
		connector.setConnectTimeoutMillis(30000);
		connector.getFilterChain().addLast("logger", lf);
		connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new MonitorProtocolCodecFactory(false)));
		handler = new MonitorClientHandler();
		connector.setHandler(handler);
		InetAddress addr = InetAddress.getByAddress(new byte[] { (byte) 127, (byte)0, (byte) 0, (byte) 1 });
		ConnectFuture cf = connector.connect(new InetSocketAddress(addr, 1988));
		if (cf.awaitUninterruptibly(10000)) {// 等待10000ms
			if (cf.isConnected()) {
				session = cf.getSession();
				log.error("链接服务器成功！");
				System.out.println("链接服务器成功！1");
			} else {
				log.error("链接服务器失败！");
				System.out.println("链接服务器失败！1");
			}
		} else {
			log.error("链接服务器失败！");
			System.out.println("链接服务器成功！2");
		}
		log.error("客户端启动成功!");
	}


	public static void main(String[] args) throws Throwable {
		MonitorClient  mc= new MonitorClient();
		while(true) {
			if(mc.session.isConnected()) {
				mc.session.write("AFGH123456");
			}
			Thread.sleep(2000);
		}
	} 
}
