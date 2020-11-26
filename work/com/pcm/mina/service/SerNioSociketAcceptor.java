package com.pcm.mina.service;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.executor.ExecutorFilter;
import org.apache.mina.filter.keepalive.KeepAliveFilter;
import org.apache.mina.filter.keepalive.KeepAliveMessageFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import com.anfu.gas.global.GlobalData;
import com.pcm.mina.command.ServerCommand;
import com.pcm.mina.filter.codec.MonitorProtocolCodecFactory;
import com.pcm.mina.service.filter.KeepAliveMessageFactoryImpl;

/**
 * @author ZERO
 * @Description mina服务端
 */
public class SerNioSociketAcceptor {
	private IoAcceptor acceptor;
	private IoHandler ioHandler;
	private PeriodTaskConcurrent periodTask;
	int port;
	// 记录日志
	public static Logger logger = Logger.getLogger(SerNioSociketAcceptor.class);

	// 创建bind()方法接收连接
	public void bind() throws IOException {
		// 创建 协议编码解码过滤器ProtocolCodecFilter
		// 设置序列化Object 可以自行设置自定义解码器
		ProtocolCodecFilter pf = new ProtocolCodecFilter(new MonitorProtocolCodecFactory(true));
		// getFilterChain() 获取 I/O 过滤器链，可以对 I/O 过滤器进行管理，包括添加和删除 I/O 过滤器。
		acceptor = new NioSocketAcceptor();
		// 设置缓存大小
		acceptor.getSessionConfig().setReadBufferSize(1024);
		// 设置过滤器
		//acceptor.getFilterChain().addLast("executor", new ExecutorFilter());
		acceptor.getFilterChain().addLast("logger", new LoggingFilter());
		acceptor.getFilterChain().addLast("codec", pf);
		acceptor.getFilterChain().addLast("executor", new ExecutorFilter());
		KeepAliveMessageFactory kamf = new KeepAliveMessageFactoryImpl();
		KeepAliveFilter kaf = new KeepAliveFilter(kamf, IdleStatus.BOTH_IDLE);
		kaf.setForwardEvent(true);
		kaf.setRequestInterval(30); // 本服务器为被定型心跳 即需要每30秒接受一个心跳请求 否则该连接进入空闲状态 并且发出idled方法回调
		acceptor.getFilterChain().addLast("heart", kaf);
		// 读写通道60秒内无操作进入空闲状态
		acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 60);
		// 绑定逻辑处理器
		acceptor.setHandler(ioHandler);
		// 绑定端口
		acceptor.bind(new InetSocketAddress(port));
		logger.info("Mina服务端启动成功...端口号为:" + port); // 测试使用

		periodTask = new PeriodTaskConcurrent(3, 10, TimeUnit.SECONDS);
		periodTask.startPeriodTask(); 
	}

	// 创建unbind()方法停止监听
	public void unbind() {
		acceptor.unbind();
		periodTask=null;
		logger.info("服务端停止成功");
	}

	public void setAcceptor(IoAcceptor acceptor) {
		this.acceptor = acceptor;
	}

	// 设置 I/O 处理器。该 I/O 处理器会负责处理该 I/O 服务所管理的所有 I/O 会话产生的 I/O 事件。
	public void setIoHandler(IoHandler ioHandler) {
		this.ioHandler = ioHandler;
	}

	// 设置端口
	public void setPort(int port) {
		this.port = port;
	}

//  获取该 I/O 服务所管理的 I/O 会话。
	public Map<Long, IoSession> getManagedSessions() {
		return acceptor.getManagedSessions();
	}

	class PeriodTaskConcurrent {

		ScheduledExecutorService service;
		private int executeCount = 0;
		long initialDelay;
		long period;
		TimeUnit unit;

		public PeriodTaskConcurrent() {
			;
		}

		public PeriodTaskConcurrent(long initialDelay, long period, TimeUnit unit) {
			super();
			this.initialDelay = initialDelay;
			this.period = period;
			this.unit = unit;
		}

		// JAVANIOServer
		public void startPeriodTask() {
			Runnable runnable = new Runnable() {
				public void run() {
					
					Map<Long, IoSession> sessionMap = SerNioSociketAcceptor.this.getManagedSessions();
					Set<Entry<Long,IoSession>> entrys = sessionMap.entrySet();
					logger.info("Session总个数："+entrys.size());
					System.out.println("Session总个数："+entrys.size());
					
					for(Entry<Long,IoSession> entry:entrys) {
						int commandNum = (int)(1+Math.random()*(GlobalData.COMMANDNAMES.length-1));
						IoSession session = entry.getValue();
						if(!session.isConnected())return;
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());
						session.write(ServerCommand.makeGetStatusDataSentCommand());	
						switch(commandNum){
							case 1:
								//session.write(ServerCommand.makeGetStatusDataSentCommand());
								break;
							case 2:
								session.write(ServerCommand.makeResetSentCommand());
								break;
							case 3:
								session.write(ServerCommand.makeStopSoundSentCommand());
								break;	
							case 4:
								session.write(ServerCommand.makeGetAlarmBoundSentCommand());
								break;
							case 5:
								session.write(ServerCommand.makeSetAlarmBoundSentCommand(1000, 2000));
								break;
							case 6:
								session.write(ServerCommand.makeStartPumpSentCommand());
								break;
							case 7:
								session.write(ServerCommand.makeGetHighAlarmBoundSentCommand());
								break;								
							case 8:
								session.write(ServerCommand.makeSetHighAlarmBoundSentCommand(3000));
								break;								
							case 9:
								session.write(ServerCommand.makeGetLowAlarmBoundSentCommand());
								break;								
							case 10:
								session.write(ServerCommand.makeSetLowAlarmBoundSentCommand(1500));
								break;																		
							case 11:
								session.write(ServerCommand.makeGetMaskThresholdSentCommand());
								break;								
							case 12:
								session.write(ServerCommand.makeSetMaskThresholdSentCommand(100));
								break;										
							case 13:
								session.write(ServerCommand.makeGetPumpRunTimeSentCommand());
								break;								
							case 14:
								session.write(ServerCommand.makeSetPumpRunTimeSentCommand(100));
								break;		
							case 15:
								session.write(ServerCommand.makeGetPumpPeriodSentCommand());
								break;								
							case 16:
								session.write(ServerCommand.makeSetPumpPeriodSentCommand(1000));
								break;										
							case 17:
								session.write(ServerCommand.makeGetFlowDifferenceValueSentCommand());
								break;								
							case 18:
								session.write(ServerCommand.makeSetFlowDifferenceValueSentCommand(1000));
								break;										
							case 19:
								session.write(ServerCommand.makeGetWaterInletFaultThresholdSentCommand());
								break;								
							case 20:
								session.write(ServerCommand.makeSetWaterInletFaultThresholdSentCommand(100));
								break;										
							case 21:
								session.write(ServerCommand.makeGetFlowFaultThresholdSentCommand());
								break;								
							case 22:
								session.write(ServerCommand.makeSetFlowFaultThresholdSentCommand(100));
								break;										
							case 23:
								session.write(ServerCommand.makeGetSensorFaultThresholdSentCommand());
								break;								
							case 24:
								session.write(ServerCommand.makeSetSensorFaultThresholdSentCommand(100));
								break;										
							case 25:
								session.write(ServerCommand.makeGetStaticFlowValueSentCommand());
								break;								
							case 26:
								session.write(ServerCommand.makeGetDynamicFlowValueSentCommand());
								break;										
							case 27:
								session.write(ServerCommand.makeCalibrateZeroSpotSentCommand());
								break;																		
							default:
								session.write(ServerCommand.makeGetStatusDataSentCommand());
								break;									
						}
					}
					logger.info("Session总个数："+entrys.size());
				}
			};
			service = Executors.newSingleThreadScheduledExecutor();
			// 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
			service.scheduleAtFixedRate(runnable, initialDelay, period, unit);
			//service.shutdown();
		}
	}
}
