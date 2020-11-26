package com.zhongzhi.location.mina.server;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;

import org.apache.mina.core.future.IoFutureListener;
import org.apache.mina.core.future.WriteFuture;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.transport.socket.SocketSessionConfig;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfu.mina.command.ParentCommand;
import com.anfu.mina.command.client.DeviceRegister;
import com.anfu.mina.command.client.SendAlarmInfo;
import com.anfu.mina.command.client.SendFaultInfo;
import com.anfu.mina.command.client.SendRealtimeData;
import com.anfu.mina.command.interact.ExecuteResult;
import com.anfu.mina.command.interact.NoticeAnswer;
import com.anfu.mina.command.interact.RequestAnswer;

public class MonitorServerHandler extends IoHandlerAdapter {
	private final static Logger log = LoggerFactory.getLogger(MonitorServerHandler.class);
	// private DataUtils dataUtil = new DataUtils(session.);

	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		// session.close(true);
		super.sessionIdle(session, status);
		log.error("进入sessionIdle函数");
		System.out.println("进入sessionIdle函数");
	}

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		System.out.println("进入处理线程");
		//DataUtils dataUtil = new DataUtils((Connection) session.getAttribute("conn"));
		if (message instanceof ArrayList<?>) {
			System.out.println("进入处理线程1");
			// System.out.println("类型判断成功");
			ArrayList<ParentCommand> commands = (ArrayList<ParentCommand>) message;
		} else if(message instanceof String){
			log.info("收到心跳包："+message);
			System.out.println("进入处理线程2"+message);
			if("AFGH123456".equals(message)){
				log.info("收到心跳包："+message);
				System.out.println("进入处理线程2");
				System.out.println("收到心跳包："+message);
				System.out.println("Handler收到心跳包");
				session.write("AFGR123456");
			}else{
				log.info("收到字符串信息："+message);
				session.write("信友电器");
			}
		} else {
		}
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.sessionOpened(session);
		
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.sessionCreated(session);
		//SocketSessionConfig cfg = (SocketSessionConfig) session.getConfig();
        //cfg.setUseReadOperation(true);
        //cfg.setWriteTimeout(30);
        //cfg.setKeepAlive(true);
        //cfg.setSoLinger(0);
        //cfg.setTcpNoDelay(true);		
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		super.sessionClosed(session);
	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		// TODO Auto-generated method stub

	}
	@Test
	public void testOut(){
		System.out.println("单元测试输出");	
		new Throwable().printStackTrace();
	}
	@Test
	public void testMakeFoods(){
		System.out.println("制作食物！");
	}
}
