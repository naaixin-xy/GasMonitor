package com.pcm.mina.service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PeriodTaskConcurrent {
	ScheduledExecutorService service;
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
