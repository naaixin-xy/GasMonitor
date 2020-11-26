package com.anfu.mina.client;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfu.mina.bean.ResultMessage;
import com.anfu.mina.bean.SendMessage;
import com.anfu.mina.command.client.DeviceRegister;
import com.anfu.mina.command.client.SendAlarmInfo;
import com.anfu.mina.command.client.SendFaultInfo;
import com.anfu.mina.command.client.SendRealtimeData;

public class MonitorClientHandler extends IoHandlerAdapter {

	
	@Override
	public void sessionOpened(IoSession session) throws Exception {
//		SendMessage sm = new SendMessage();
//		sm.setI(100);
//		sm.setJ(99);
//		sm.setSymbol('+');
//		session.write(sm);
//		sm.setI(100);
//		sm.setJ(99);
//		sm.setSymbol('-');
//		session.write(sm);
	}

	@Override
	public void messageReceived(IoSession session, Object message) {			
		System.out.println(message);
	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
		super.exceptionCaught(session, cause);
		//session.close();
	}
}
