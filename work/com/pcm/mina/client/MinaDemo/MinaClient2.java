package com.pcm.mina.client.MinaDemo;

import java.net.InetSocketAddress;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import com.pcm.mina.filter.codec.MonitorProtocolCodecFactory;

/**
 * @author ZERO
 * @Description mina 客户端
 */
public class MinaClient2 extends  MinaClient{
	private static Logger logger = Logger.getLogger(MinaClient2.class);
	private static String HOST = "127.0.0.1";
	private static int PORT = 1255;
	
	private  IoConnector connector = new NioSocketConnector();
	private  IoSession session;
	
	private String hostId;
	private String detectorId;
	private String highAlarmAbound;
	private String lowAlarmAbound;	
	private String alarmStatus;
	private String faultStatus;
	private String maskStatus;	
	private String relayStatus;
	private String gasConcentration;
	private String maskThreshold;
	private String pumpRunTime;
	private String pumpPeriod;
	private String flowDifferenceValue;
	private String waterInletFaultThreshold;
	private String flowFaultThreshold;
	private String sensorFaultThreshold;
	private String staticFlowValue;
	private String dynamicFlowValue;
	private PeriodTaskConcurrent periodTask; 
	
	public String getAlarmStatus() {
		return alarmStatus;
	}

	public void setAlarmStatus(String alarmStatus) {
		this.alarmStatus = alarmStatus;
	}

	public String getFaultStatus() {
		return faultStatus;
	}

	public void setFaultStatus(String faultStatus) {
		this.faultStatus = faultStatus;
	}

	public String getMaskStatus() {
		return maskStatus;
	}

	public void setMaskStatus(String maskStatus) {
		this.maskStatus = maskStatus;
	}

	public String getRelayStatus() {
		return relayStatus;
	}

	public void setRelayStatus(String relayStatus) {
		this.relayStatus = relayStatus;
	}

	public String getGasConcentration() {
		//创建Random类对象
        Random random = new Random();              
         
        //产生随机数
        int number = random.nextInt(9000 - 1000 + 1) + 1000;
        gasConcentration=String.format("%08d",number);
		return gasConcentration;
	}

	public void setGasConcentration(String gasConcentration) {
		this.gasConcentration = gasConcentration;
	}

	public String getHostId() {
		return hostId;
	}

	public void setHostId(String hostId) {
		this.hostId = hostId;
	}

	public String getDetectorId() {
		return detectorId;
	}

	public void setDetectorId(String detectorId) {
		this.detectorId = detectorId;
	}

	public String getHighAlarmAbound() {
		return highAlarmAbound;
	}

	public void setHighAlarmAbound(String highAlarmAbound) {
		this.highAlarmAbound = highAlarmAbound;
	}

	public String getLowAlarmAbound() {
		return lowAlarmAbound;
	}

	public void setLowAlarmAbound(String lowAlarmAbound) {
		this.lowAlarmAbound = lowAlarmAbound;
	}

	public IoSession getSession() {
		return session;
	}

	public void setSession(IoSession session) {
		this.session = session;
	}

	public IoConnector getConnector() {
		return connector;
	}

	public void setConnector(IoConnector connector) {
		this.connector = connector;
	}

	public String getMaskThreshold() {
		return maskThreshold;
	}

	public void setMaskThreshold(String maskThreshold) {
		this.maskThreshold = maskThreshold;
	}

	public String getPumpRunTime() {
		return pumpRunTime;
	}

	public void setPumpRunTime(String pumpRunTime) {
		this.pumpRunTime = pumpRunTime;
	}

	public String getPumpPeriod() {
		return pumpPeriod;
	}

	public void setPumpPeriod(String pumpPeriod) {
		this.pumpPeriod = pumpPeriod;
	}

	public String getFlowDifferenceValue() {
		return flowDifferenceValue;
	}

	public void setFlowDifferenceValue(String flowDifferenceValue) {
		this.flowDifferenceValue = flowDifferenceValue;
	}

	public String getWaterInletFaultThreshold() {
		return waterInletFaultThreshold;
	}

	public void setWaterInletFaultThreshold(String waterInletFaultThreshold) {
		this.waterInletFaultThreshold = waterInletFaultThreshold;
	}

	public String getFlowFaultThreshold() {
		return flowFaultThreshold;
	}

	public void setFlowFaultThreshold(String flowFaultThreshold) {
		this.flowFaultThreshold = flowFaultThreshold;
	}

	public String getSensorFaultThreshold() {
		return sensorFaultThreshold;
	}

	public void setSensorFaultThreshold(String sensorFaultThreshold) {
		this.sensorFaultThreshold = sensorFaultThreshold;
	}

	public String getStaticFlowValue() {
		return staticFlowValue;
	}

	public void setStaticFlowValue(String staticFlowValue) {
		this.staticFlowValue = staticFlowValue;
	}

	public String getDynamicFlowValue() {
		return dynamicFlowValue;
	}

	public void setDynamicFlowValue(String dynamicFlowValue) {
		this.dynamicFlowValue = dynamicFlowValue;
	}

	public MinaClient2(String hostId, String detectorId, String highAlarmAbound, String lowAlarmAbound,
			String alarmStatus, String faultStatus, String maskStatus, String relayStatus, String gasConcentration) {
		super();
		this.hostId = hostId;
		this.detectorId = detectorId;
		this.highAlarmAbound = highAlarmAbound;
		this.lowAlarmAbound = lowAlarmAbound;
		this.alarmStatus = alarmStatus;
		this.faultStatus = faultStatus;
		this.maskStatus = maskStatus;
		this.relayStatus = relayStatus;
		this.gasConcentration = gasConcentration;
	}
	
	public MinaClient2(String hostId, String detectorId, String highAlarmAbound, String lowAlarmAbound,
			String alarmStatus, String faultStatus, String maskStatus, String relayStatus, String gasConcentration,
			String maskThreshold, String pumpRunTime, String pumpPeriod, String flowDifferenceValue,
			String waterInletFaultThreshold, String flowFaultThreshold, String sensorFaultThreshold,
			String staticFlowValue, String dynamicFlowValue) {
		super();
		periodTask = new PeriodTaskConcurrent(5, 10, TimeUnit.SECONDS);
		periodTask.startPeriodTask(); 
		this.hostId = hostId;
		this.detectorId = detectorId;
		this.highAlarmAbound = highAlarmAbound;
		this.lowAlarmAbound = lowAlarmAbound;
		this.alarmStatus = alarmStatus;
		this.faultStatus = faultStatus;
		this.maskStatus = maskStatus;
		this.relayStatus = relayStatus;
		this.gasConcentration = gasConcentration;
		this.maskThreshold = maskThreshold;
		this.pumpRunTime = pumpRunTime;
		this.pumpPeriod = pumpPeriod;
		this.flowDifferenceValue = flowDifferenceValue;
		this.waterInletFaultThreshold = waterInletFaultThreshold;
		this.flowFaultThreshold = flowFaultThreshold;
		this.sensorFaultThreshold = sensorFaultThreshold;
		this.staticFlowValue = staticFlowValue;
		this.dynamicFlowValue = dynamicFlowValue;
	}

	public MinaClient2() {
//		periodTask = new PeriodTaskConcurrent(3, 20, TimeUnit.SECONDS);
//		periodTask.startPeriodTask(); 
	}
	/*
	 * 测试服务端与客户端程序！ a. 启动服务端，然后再启动客户端 b. 服务端接收消息并处理成功;
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// 设置链接超时时间
		MinaClient2 [] clients = new MinaClient2[800];
		String deteId;
		for(int i=0;i<80;i++) {
			if(i<36) {
				deteId=String.format("%010d", 1001+i+1000000000);
			}else {
				deteId=String.format("%010d", 1001+i);
			}
			
			clients[i] = new MinaClient2(
						String.format("%010d", 1001+i),
						deteId,
						"00002000",
						"00001000",
						"0",
						"00000",
						"0",
						"00000",
						"00000868",
						"0088",
						"00000888",
						"0088",
						"0088",
						"0088",
						"0088",
						"0088",
						"0088",
						"0088"				
					);
			IoConnector connector=clients[i].getConnector();
			IoSession session;
			connector.setConnectTimeout(30000);
			// 添加过滤器 可序列话的对象
			connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new MonitorProtocolCodecFactory(false)));
			// 添加业务逻辑处理器类
			connector.setHandler(new MinaClientHandler(clients[i]));
			ConnectFuture future = connector.connect(new InetSocketAddress(HOST, PORT));// 创建连接
			future.awaitUninterruptibly();// 等待连接创建完成
			session = future.getSession();// 获得session
			clients[i].setSession(session);
		}
		
		
//		while(true) {
//			//client.replyResetCommand();
//			try {
//				Thread.sleep(10000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		// pushstart();
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
					if(MinaClient2.this.getAlarmStatus().equals("0")) {
						MinaClient2.this.setAlarmStatus("1");
					}else if(MinaClient2.this.getAlarmStatus().equals("1")){
						MinaClient2.this.setAlarmStatus("2");
					}else {
						MinaClient2.this.setAlarmStatus("0");
					}
					
					if(MinaClient2.this.getFaultStatus().equals("00000")) {
						MinaClient2.this.setFaultStatus("00001");
					}else {
						MinaClient2.this.setFaultStatus("00000");
					}
					
					
					System.out.println("MinaClient.this.getAlarmStatus():"+MinaClient2.this.getAlarmStatus());
					System.out.println("MinaClient.this.getFaultStatus():"+MinaClient2.this.getFaultStatus());
				}
			};
			service = Executors.newSingleThreadScheduledExecutor();
			// 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
			service.scheduleAtFixedRate(runnable, initialDelay, period, unit);
		}
	}
}
