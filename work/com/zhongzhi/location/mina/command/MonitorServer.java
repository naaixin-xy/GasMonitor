package com.zhongzhi.location.mina.command;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.executor.ExecutorFilter;
import org.apache.mina.filter.keepalive.KeepAliveFilter;
import org.apache.mina.filter.keepalive.KeepAliveMessageFactory;
import org.apache.mina.filter.keepalive.KeepAliveRequestTimeoutHandler;
import org.apache.mina.filter.logging.LogLevel;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.filter.util.ReferenceCountingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MonitorServer {
	public Charset cs;
	private LoggingFilter lf;
	private IoAcceptor acceptor;
	private PeriodTaskConcurrent periodTask;
	/** 30秒后超时 */
	private static final int IDELTIMEOUT = 120;
	/** 15秒发送一次心跳包 */
	private static final int HEARTBEATRATE = 90;
	/** 心跳包内容 */
	private static final String HEARTBEATREQUEST = "BFGH";
	private static final String HEARTBEATRESPONSE = "BFGD";
	
	private final static Logger log = LoggerFactory.getLogger(MonitorServer.class);	
	public MonitorServer() throws IOException{
		periodTask = new PeriodTaskConcurrent();
		periodTask.startPeriodTask();
		cs=Charset.forName("UTF-8");
		acceptor = new NioSocketAcceptor();    
		lf = new LoggingFilter(); 
		lf.setMessageReceivedLogLevel(LogLevel.ERROR);
		lf.setMessageSentLogLevel(LogLevel.ERROR);
		acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE,IDELTIMEOUT);    
		acceptor.getFilterChain().addLast("logger", lf);    
		acceptor.getFilterChain().addLast("codec",new ProtocolCodecFilter(new MonitorProtocolCodecFactory(true))); 	
		
		//acceptor.getFilterChain().addLast("exceutor", new ExecutorFilter());
		/** 过滤器配置  */
		KeepAliveMessageFactory heartBeatFactory = new KeepAliveMessageFactoryImpl();
		KeepAliveRequestTimeoutHandler heartBeatHandler = new KeepAliveRequestTimeoutHandlerImpl();
		KeepAliveFilter heartBeat = new KeepAliveFilter(heartBeatFactory, IdleStatus.BOTH_IDLE, heartBeatHandler);
		/** 是否回发 */
		heartBeat.setForwardEvent(true);
		/** 发送频率 */
		heartBeat.setRequestInterval(HEARTBEATRATE);
		
		
		
		acceptor.getFilterChain().addLast("heartbeat", heartBeat);
				
		//acceptor.getFilterChain().addLast("myIoFilter",new ReferenceCountingFilter(new MonitorServerTransactionFilter())); 		
		acceptor.setHandler(new MonitorServerHandler()); 
		try{
			acceptor.bind(new InetSocketAddress(1988)); 
		}catch(IOException e){
			e.printStackTrace();
			try{
				acceptor.bind(new InetSocketAddress(1988)); 
			}catch(Exception e1){
				e.printStackTrace();
				throw e1;
			}
		}
		log.error("服务器端启动成功!");	
	}
	public static void main(String[] args) throws Exception {    
		//Initialization.getInstance().initial();
		MonitorServer ms=new MonitorServer();
	} 
	class PeriodTaskConcurrent {
	
		ScheduledExecutorService	 service;
		private int executeCount=0;

		public PeriodTaskConcurrent() {
			;
		}

		// JAVANIOServer
		public void startPeriodTask() {
			Runnable runnable = new Runnable() {
				public void run() {
					/*
					Connection conn=null;
					try{
						ConcurrentHashMap<String,Boolean> hostMap = Initialization.getInstance().comDeviceConnectStatusMap;
						Enumeration<String> enums = hostMap.keys();
						conn = TomcatJdbcPool.getInstance().getConnection();
						conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
						conn.setAutoCommit(false);
						DataUtils dataUtil = new DataUtils(conn);
						for(;enums.hasMoreElements();){
							String hostId = enums.nextElement();
							if(hostMap.get(hostId)){
								dataUtil.modifyGasHostOnlineStatus(hostId, "在线");
							}else {
								dataUtil.modifyGasHostOnlineStatus(hostId, "离线");	
							}
							hostMap.put(hostId,false);
						}
						conn.commit();
						conn.setAutoCommit(true);
					}catch(SQLException e){
						try {
							conn.rollback();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					*/
				}
			};
			service = Executors.newSingleThreadScheduledExecutor();
			// 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
			service.scheduleAtFixedRate(runnable, 3,4200, TimeUnit.SECONDS);
		}
	}
	
	/***
	 * 这里的执行顺序是 分两条顺序 getResponse()---->isResponse();获取数据判断心跳事件（目的是判断是否触发心跳超时异常）
	 * isRequest()----->getRequest(); 写回数据是心跳事件触发的数据（目的写回给服务器（客户端）心跳包） 两条路线
	 * 没必要都实现行
	 */
	private static class KeepAliveMessageFactoryImpl implements KeepAliveMessageFactory {

		/*
		 * (non-Javadoc)
		 * 
		 * 返回给客户端的心跳包数据 return 返回结果才是客户端收到的心跳包数据
		 */
		@Override
		public Object getRequest(IoSession session) {
			System.out.println("getRequest");
			log.debug("getRequest");
			return null;//HEARTBEATREQUEST;
		}

		/*
		 * (non-Javadoc) "接受到的客户端数据包"
		 */
		@Override
		public Object getResponse(IoSession session, Object request) {
			System.out.println("getResponse");
			log.debug("getResponse");
			return HEARTBEATRESPONSE;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see 判断是否是客户端发送来的的心跳包此判断影响 KeepAliveRequestTimeoutHandler实现类
		 * 判断是否心跳包发送超时
		 */
		@Override
		public boolean isRequest(IoSession session, Object message) {
			if (message.equals(HEARTBEATREQUEST)) {
				System.out.println("isRequest");
				log.debug("isRequest");
				System.out.println("接收到客户端心数据包引发心跳事件                 心跳数据包是：" + message);
				log.debug("接收到客户端心数据包引发心跳事件                 心跳数据包是：" + message);
				return true;
			}
			return false;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * 判断发送信息是否是心跳数据包此判断影响 KeepAliveRequestTimeoutHandler实现类 判断是否心跳包发送超时
		 */
		@Override
		public boolean isResponse(IoSession session, Object message) {
//			if (message.equals(HEARTBEATRESPONSE)) {//HEARTBEATRESPONSE
//				System.out.println("isResponse");
//				log.error("isResponse");
//				System.out.println("服务器发送数据包中引发心跳事件             心跳数据包是: " + message);
//				log.error("服务器发送数据包中引发心跳事件             心跳数据包是: " + message);
//				return true;
//			}
			return false;
		}
	}

	/***
	 * 
	 * @Description: 当心跳超时时的处理，也可以用默认处理 这里like
	 *               KeepAliveRequestTimeoutHandler.LOG的处理
	 * 
	 */
	private static class KeepAliveRequestTimeoutHandlerImpl implements KeepAliveRequestTimeoutHandler {

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
			System.out.println("《*服务器端*》心跳包发送超时处理(及长时间没有发送（接受）心跳包)");
			log.error("《*服务器端*》心跳包发送超时处理(及长时间没有发送（接受）心跳包)");
		}
	}
}
