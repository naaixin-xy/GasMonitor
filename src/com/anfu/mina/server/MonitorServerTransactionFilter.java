package com.anfu.mina.server;

import java.sql.Connection;
import java.util.Date;

import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.filterchain.IoFilterAdapter;
import org.apache.mina.core.filterchain.IoFilterChain;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.write.WriteRequest;

public class MonitorServerTransactionFilter extends  IoFilterAdapter  {
	//TomcatJdbcPool sqlPool = TomcatJdbcPool.getInstance();
	@Override
	public void messageReceived(NextFilter nextFilter, IoSession session, Object message) throws Exception {
//		// TODO Auto-generated method stub
//		//System.out.println("进入事物滤波器设置函数！");
//		//Connection conn = sqlPool.getConnection();
//		conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
//		//conn.setTransactionIsolation(Connection.TRANSACTION_NONE);
//		conn.setAutoCommit(false);
//		Date start = new Date();
//		session.setAttribute("conn", conn);			
//		super.messageReceived(nextFilter, session, message);
//		//System.out.println("退出事物处理函数！");
//		//nextFilter.messageReceived(session, message);
//		conn.commit();
//		conn.setAutoCommit(true);
//		session.removeAttribute("conn");
//		//System.out.println("本次执行总共耗时："+(new Date().getTime()-start.getTime())+"ms");
	}	
}
//public class MonitorServerTransactionFilter implements IoFilter {
//	TomcatJdbcPool sqlPool = TomcatJdbcPool.getInstance();
//	@Override
//	public void destroy() throws Exception {
//		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%destroy");
//	}
//
//	@Override
//	public void exceptionCaught(NextFilter nextFilter, IoSession session, Throwable cause) throws Exception {
//		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%exceptionCaught");
//		nextFilter.exceptionCaught(session, cause);
//	}
//
//	@Override
//	public void filterClose(NextFilter nextFilter, IoSession session) throws Exception {
//		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%filterClose");
//		nextFilter.filterClose(session);
//	}
//
//	@Override
//	public void filterWrite(NextFilter nextFilter, IoSession session, WriteRequest writeRequest) throws Exception {
//		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%filterWrite");
//		nextFilter.filterWrite(session, writeRequest);
//	}
//
//	@Override
//	public void init() throws Exception {
//		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%init");
//	}
//
//	@Override
//	public void messageReceived(NextFilter nextFilter, IoSession session, Object message) throws Exception {
//		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%messageReceived");
//		
//		Connection conn = sqlPool.getConnection();
//		conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
//		conn.setAutoCommit(false);
//		session.setAttribute("conn", conn);		
//		nextFilter.messageReceived(session, message);
//		conn.commit();
//		conn.setAutoCommit(true);
//		session.removeAttribute("conn");	
//	}
//
//	@Override
//	public void messageSent(NextFilter nextFilter, IoSession session, WriteRequest writeRequest) throws Exception {
//		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%messageSent");
//		nextFilter.messageSent(session, writeRequest);
//	}
//
//	@Override
//	public void onPostAdd(IoFilterChain parent, String name, NextFilter nextFilter) throws Exception {
//		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%onPostAdd");
//	}
//
//	@Override
//	public void onPostRemove(IoFilterChain parent, String name, NextFilter nextFilter) throws Exception {
//		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%onPostRemove");
//	}
//
//	@Override
//	public void onPreAdd(IoFilterChain parent, String name, NextFilter nextFilter) throws Exception {
//		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%onPreAdd");
//	}
//
//	@Override
//	public void onPreRemove(IoFilterChain parent, String name, NextFilter nextFilter) throws Exception {
//		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%onPreRemove");
//	}
//
//	@Override
//	public void sessionClosed(NextFilter nextFilter, IoSession session) throws Exception {
//		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%sessionClosed");
//		nextFilter.sessionClosed(session);
//	}
//
//	@Override
//	public void sessionCreated(NextFilter nextFilter, IoSession session) throws Exception {
//		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%sessionCreated");
//		nextFilter.sessionCreated(session);
//	}
//
//	@Override
//	public void sessionIdle(NextFilter nextFilter, IoSession session, IdleStatus status) throws Exception {
//		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%sessionIdle");
//		nextFilter.sessionIdle(session, status);
//	}
//
//	@Override
//	public void sessionOpened(NextFilter nextFilter, IoSession session) throws Exception {
//		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%sessionOpened");
//		nextFilter.sessionOpened(session);
//	}
//
//	@Override
//	public void inputClosed(NextFilter nextFilter, IoSession session) throws Exception {
//		// TODO Auto-generated method stub	
//	}
//}
