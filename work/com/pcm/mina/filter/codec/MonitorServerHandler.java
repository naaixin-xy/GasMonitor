package com.pcm.mina.filter.codec;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.util.ArrayList;

import org.apache.mina.core.future.IoFutureListener;
import org.apache.mina.core.future.WriteFuture;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfu.assist.TomcatJdbcPool;
import com.anfu.mina.command.ParentCommand;
import com.anfu.mina.command.client.DeviceRegister;
import com.anfu.mina.command.client.SendAlarmInfo;
import com.anfu.mina.command.client.SendFaultInfo;
import com.anfu.mina.command.client.SendRealtimeData;
import com.anfu.mina.command.interact.ExecuteResult;
import com.anfu.mina.command.interact.NoticeAnswer;
import com.anfu.mina.command.interact.RequestAnswer;
import com.anfu.mina.util.DataUtils;
import com.anfu.mina.util.Initialization;

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
		// System.out.println("进入处理线程");
		DataUtils dataUtil = new DataUtils((Connection) session.getAttribute("conn"));
		if (message instanceof ArrayList<?>) {
			// System.out.println("类型判断成功");
			ArrayList<ParentCommand> commands = (ArrayList<ParentCommand>) message;
			String commandName;
			String systemName;
			String[] paramDataArray = new String[8];
			boolean replyFlag;// 命令是否需要返回结果
			for (ParentCommand command : commands) {
				// System.out.println("开始处理命令");
				commandName = command.getCommandName();
				systemName = command.getSystem();
				if (command.getReplyFlag() == null) {
					replyFlag = false;
				} else if ("true".equalsIgnoreCase(command.getReplyFlag().trim()) || "false".equalsIgnoreCase(command.getReplyFlag().trim())) {
					replyFlag = Boolean.valueOf(command.toString().trim());
				} else {
					log.error("命令回复标志错误：" + command.toString());
					continue;
				}
				if ((!"DeviceRegister".equals(commandName)
						&& ((session.getAttribute("HostId") == null) || Initialization.getInstance().comDeviceSessionMap.get(session.getAttribute("HostId")) == null))) {
					log.error("设备未注册！数据内容：" + command.toString());
					continue;
				} else {
					if (!"DeviceRegister".equals(commandName)) {
						log.debug("设备已注册！");
					} else {
						log.debug("正在进行设备注册！");
					}
				}
				if (systemName == null) {
					String machineNumber = command.getMachineNumber();
					String password = command.getPassword();
					String questNumber = command.getQuestNumber();

					if ((machineNumber == null) && (password == null) && (questNumber != null)) {
						if ("DeviceRegister".equals(commandName)) {
							DeviceRegister deviceRegister = (DeviceRegister) command;
							log.debug("开始执行注册命令,命令内容：" + deviceRegister.toString());
							RequestAnswer requestAnswer = new RequestAnswer(deviceRegister.getQuestNumber(), "SystemInteract", "RequestAnswer", deviceRegister.getPassword(),
									deviceRegister.getMachineNumber(), "false", "PrepareExecute");
							ExecuteResult executeResult = new ExecuteResult(deviceRegister.getQuestNumber(), "SystemInteract", "ExecuteResult", deviceRegister.getPassword(),
									deviceRegister.getMachineNumber(), "false", "ExecuteSucess");
							if (replyFlag) {
								requestAnswer.setRequestReturn("PrepareExecute");
								session.write(requestAnswer);
								log.debug("Handler发送请求应答命令！");
							}
							// 判断主机是否存在，不存在发送执行失败应答。
							if (Initialization.getInstance().comDeviceMap.get(deviceRegister.getHostId()) == null) {
								log.error("不存在相关主机注册信息！");
								if (replyFlag) {
									executeResult.setExecuteReturn("RequestReject");
									session.write(executeResult);
									// 建议做断线处理
									continue;
								}
								session.closeNow();
							}
							// 如果主机存在，判断是否已经注册完毕
							IoSession oldSession = Initialization.getInstance().comDeviceSessionMap.get(deviceRegister.getHostId());
							if (oldSession != null) {// 如果未注册继续执行注册操作，如果已经注册，判断session是否链接或者关闭。判断客户端是否唯一
								if (oldSession.isConnected()) {
									InetSocketAddress oldAddress = (InetSocketAddress) oldSession.getRemoteAddress();
									InetSocketAddress address = (InetSocketAddress) session.getRemoteAddress();
									if (!address.getAddress().getHostAddress().equals(oldAddress.getAddress().getHostAddress())) {
										log.error("不允许两台同ID主机同时在线！");
										if (replyFlag) {
											executeResult.setExecuteReturn("RequestReject");
											session.write(executeResult);// 建议做断线处理
											session.closeOnFlush();
											continue;
										}
										session.closeNow();
									}
								}
								// 链接已断开，执行下面步骤，重新注册
							}
							// if(session.getLocalAddress()){
							//
							// }
							// log.error(session.getLocalAddress().toString());
							// log.error(session.getRemoteAddress());
							Initialization.getInstance().comDeviceConnectStatusMap.put(deviceRegister.getHostId(), true);
							if ((dataUtil.modifyGasHostOnlineStatus(deviceRegister.getHostId(), "在线") > 0)) {
								log.info("更新在线信息成功！");
							} else {
								log.error("更新在线信息失败！");
								if (replyFlag) {
									executeResult.setExecuteReturn("ExecuteFailed");
									session.write(executeResult);
									continue;
								}
							}
							session.setAttribute("HostId", deviceRegister.getHostId());
							Initialization.getInstance().comDeviceSessionMap.put(deviceRegister.getHostId(), session);

							if (replyFlag) {
								executeResult.setExecuteReturn("ExecuteSucess");
								session.write(executeResult);
								log.debug("Handler发送结果应答命令！");
							}
							log.info("设备注册成功");
						} else if ("SendAlarmInfo".equals(commandName)) {
							SendAlarmInfo sendAlarmInfo = (SendAlarmInfo) command;
							NoticeAnswer noticeAnswer = new NoticeAnswer(sendAlarmInfo.getQuestNumber(), "SystemInteract", "NoticeAnswer", sendAlarmInfo.getPassword(),
									sendAlarmInfo.getMachineNumber(), "false", "AcceptSucess");
							if (Initialization.getInstance().deteMap.get(sendAlarmInfo.getDeteId()) == null) {
								log.error("不存在相关探测器信息！");
								if (replyFlag) {
									noticeAnswer.setNoticeReturn("NoticeReject");
									session.write(noticeAnswer);
								}
								continue;
							}
							if ("报警开始".equals(sendAlarmInfo.getAlarmAction())) {
								if (dataUtil.modifyDetectorAlarmStatus(sendAlarmInfo.getDeteId(), sendAlarmInfo.getAlarmType()) > 0) {
									log.debug("探测器状态更新成功！");
								} else {
									log.error("探测器状态更新失败！");
									if (replyFlag) {
										noticeAnswer.setNoticeReturn("NoticeReject");
										session.write(noticeAnswer);
									}
									continue;
								}
							} else if ("报警结束".equals(sendAlarmInfo.getAlarmAction())) {
								if (dataUtil.modifyDetectorAlarmStatus(sendAlarmInfo.getDeteId(), "正常") > 0) {
									log.debug("探测器状态更新成功！");
								} else {
									log.error("探测器状态更新失败！");
									if (replyFlag) {
										noticeAnswer.setNoticeReturn("NoticeReject");
										session.write(noticeAnswer);
									}
									continue;
								}
							} else {
								log.error("报警信息异常：AlarmAction字段内容错误");
								if (replyFlag) {
									noticeAnswer.setNoticeReturn("NoticeReject");
									session.write(noticeAnswer);
								}
								continue;
							}

							paramDataArray[1] = sendAlarmInfo.getHostId();// commandParameterJson.getString("HostId");
							paramDataArray[2] = sendAlarmInfo.getDeteId();// commandParameterJson.getString("DeteId");
							try {
								log.debug("Initialization.getInstance().comDeviceMap.get(paramDataArray[1])==null:" + (Initialization.getInstance().comDeviceMap.get(paramDataArray[1]) == null));
								log.debug("Initialization.getInstance().comDeviceMap.get(paramDataArray[1]).get('hm_comaddr')==null:"
										+ (Initialization.getInstance().comDeviceMap.get(paramDataArray[1]).get("hm_comaddr") == null));
								paramDataArray[3] = Initialization.getInstance().comDeviceMap.get(paramDataArray[1]).get("hm_comaddr").toString();// dataUtil.getHostAddrFromId(paramDataArray[1]);
								paramDataArray[4] = Initialization.getInstance().deteMap.get(paramDataArray[2]).get("dt_comaddr").toString();// dataUtil.getDetectorAddrFromId(paramDataArray[2]);
							} catch (Exception e) {
								e.printStackTrace();
								log.error("获取初始化数据信息异常！" + e + sendAlarmInfo.toString());
								if (replyFlag) {
									noticeAnswer.setNoticeReturn("NoticeReject");
									session.write(noticeAnswer);
								}
								continue;
							}
							paramDataArray[5] = sendAlarmInfo.getAlarmType();// commandParameterJson.getString("AlarmType");
							paramDataArray[6] = sendAlarmInfo.getAlarmContent();// commandParameterJson.getString("AlarmInfo");
							String floatString = sendAlarmInfo.getAlarmData().replace("[", "").replace("]", "");
							Initialization.getInstance().deteRealTimeDataMap.put(paramDataArray[2], Float.valueOf(floatString));
							if (dataUtil.addGasAlarmInfo(paramDataArray) > 0) {
								log.debug("报警信息写入成功！");
								log.debug("报警信息通知应答！");
							} else {
								log.error("报警信息写入失败！");
								log.debug("报警信息通知应答！");
								if (replyFlag) {
									noticeAnswer.setNoticeReturn("NoticeReject");
									WriteFuture writeFuture = session.write(noticeAnswer);
									writeFuture.addListener(new IoFutureListener<WriteFuture>() {
										@Override
										public void operationComplete(WriteFuture future) {
											// TODO Auto-generated method stub
											if (future.isWritten()) {
												log.debug("通知应答发送成功！");
											} else {
												log.debug("通知应答发送失败！");
											}
										}
									});
								}
								continue;
							}
							if (replyFlag) {
								noticeAnswer.setNoticeReturn("AcceptSucess");
								session.write(noticeAnswer);
							}

							// IoFutureListener<WriteFuture> ioFutureListener =
							// session.write(noticeAnswer);
							// System.out.println("报警数据写入数据库！");
						} else if ("SendFaultInfo".equals(commandName)) {

							SendFaultInfo sendFaultInfo = (SendFaultInfo) command;
							NoticeAnswer noticeAnswer = new NoticeAnswer(sendFaultInfo.getQuestNumber(), "SystemInteract", "NoticeAnswer", sendFaultInfo.getPassword(),
									sendFaultInfo.getMachineNumber(), "false", "AcceptSucess");

							if ("故障开始".equals(sendFaultInfo.getFaultAction())) {
								if (dataUtil.modifyDetectorFaultStatus(sendFaultInfo.getDeteId(), sendFaultInfo.getFaultType()) > 0) {
									log.debug("探测器状态更新成功！");
								} else {
									log.error("探测器状态更新失败！");
									if (replyFlag) {
										noticeAnswer.setNoticeReturn("NoticeReject");
										session.write(noticeAnswer);
									}
									continue;
								}
							} else if ("故障结束".equals(sendFaultInfo.getFaultAction())) {
								if (dataUtil.modifyDetectorFaultStatus(sendFaultInfo.getDeteId(), "正常") > 0) {
									log.debug("探测器状态更新成功！");
								} else {
									log.error("探测器状态更新失败！");
									if (replyFlag) {
										noticeAnswer.setNoticeReturn("NoticeReject");
										session.write(noticeAnswer);
									}
									continue;
								}
							} else {
								log.error("故障信息异常：FaultAction字段内容错误");
								if (replyFlag) {
									noticeAnswer.setNoticeReturn("NoticeReject");
									session.write(noticeAnswer);
								}
								continue;
							}

							paramDataArray[1] = sendFaultInfo.getHostId();// commandParameterJson.getString("HostId");
							paramDataArray[2] = sendFaultInfo.getDeteId();// commandParameterJson.getString("DeteId");
							try {
								paramDataArray[3] = Initialization.getInstance().comDeviceMap.get(paramDataArray[1]).get("hm_comaddr").toString();// dataUtil.getHostAddrFromId(paramDataArray[1]);
								paramDataArray[4] = Initialization.getInstance().deteMap.get(paramDataArray[2]).get("dt_comaddr").toString();// dataUtil.getDetectorAddrFromId(paramDataArray[2]);
							} catch (Exception e) {
								e.printStackTrace();
								log.error("获取初始化数据信息异常！");
								if (replyFlag) {
									noticeAnswer.setNoticeReturn("NoticeReject");
									session.write(noticeAnswer);
								}
								continue;
							}
							paramDataArray[5] = sendFaultInfo.getFaultType();// commandParameterJson.getString("FaultType");
							paramDataArray[6] = sendFaultInfo.getFaultContent();
							paramDataArray[7] = sendFaultInfo.getFaultTime();
							if (dataUtil.addGasFaultInfo(paramDataArray) > 0) {
								log.debug("故障信息写入成功！");
								log.debug("故障信息通知应答！");
							} else {
								log.error("故障信息写入失败！");
								log.debug("故障信息通知应答！");
								if (replyFlag) {
									noticeAnswer.setNoticeReturn("NoticeReject");
									session.write(noticeAnswer);
								}
							}
							if (replyFlag) {
								noticeAnswer.setNoticeReturn("AcceptSucess");
								session.write(noticeAnswer);
							}
						} else if ("SendRealtimeData".equals(commandName)) {

							SendRealtimeData sendRealtimeData = (SendRealtimeData) command;
							Initialization.getInstance().comDeviceConnectStatusMap.put(sendRealtimeData.getHostId(), true);
							StringBuilder builder = new StringBuilder();
							StringBuffer buffer = Initialization.getInstance().deteBufferMap.get(sendRealtimeData.getDeteId());
							if (buffer == null) {
								buffer = new StringBuffer();
								Initialization.getInstance().deteBufferMap.put(sendRealtimeData.getDeteId(), buffer);
							}
							synchronized (buffer) {
								builder.append(buffer);
							}
							// System.out.println(Initialization.getInstance().deteBufferMap.toString());

							String temp = builder.toString();
							String floatString = sendRealtimeData.getRealTimeData().replace("[", "").replace("]", "");

							try {
								Float.valueOf(floatString);
							} catch (Exception e) {
								e.printStackTrace();
								log.warn("实时数据格式错误 ，数据内容：" + sendRealtimeData.toString());
								continue;
							}

							if (temp.startsWith("[") && temp.endsWith("]")) {
								builder.deleteCharAt(builder.indexOf("["));
								builder.deleteCharAt(builder.indexOf("]"));
								String[] arrayTemp = temp.split(",");
								if (arrayTemp.length > 60) {
									builder.delete(builder.lastIndexOf(","), builder.length());
								}
							} else {
								builder.delete(0, builder.length());
							}
							if (builder.length() > 0) {
								builder.insert(0, "[" + floatString + ",").append("]");
							} else {
								builder.insert(0, "[" + floatString).append("]");
							}
							synchronized (buffer) {
								buffer.delete(0, buffer.length()).append(builder);
							}
							paramDataArray[1] = sendRealtimeData.getDeteId();
							paramDataArray[2] = floatString.trim();
							dataUtil.addRealDataInfo(paramDataArray);
							Initialization.getInstance().deteRealTimeDataMap.put(paramDataArray[1], Float.valueOf(floatString));
							// Initialization.getInstance().deteBufferMap.put(sendRealtimeData.getDeteId(),builder);
							log.debug("处理实时数据！");
						} else {
							log.error("收到无效命令：" + command.toString());
							continue;
						}
					} else {
						log.error("收到无效命令：" + command.toString());
						continue;
					}
				} else if ("GasDetect".equals(systemName)) {

				} else if ("SystemInteract".equals(systemName)) {

				}
			}
		} else if(message instanceof String){
			if("AFGH".equals(message)){
				log.info("收到心跳包："+message);
				System.out.println("Handler收到心跳包");
				session.write("AFGR");
			}else{
				log.info("收到字符串信息："+message);
				session.write("信友电器");
			}
		} else {
		}
	}

	private void sendNoticeAnswer(IoSession session, NoticeAnswer noticeAnswer, String noticeReturn, final ParentCommand command, boolean replyFlag) {
		if (replyFlag) {
			noticeAnswer.setNoticeReturn(noticeReturn);
			WriteFuture writeFuture = session.write(noticeAnswer);
			writeFuture.addListener(new IoFutureListener<WriteFuture>() {
				@Override
				public void operationComplete(WriteFuture future) {
					// TODO Auto-generated method stub
					if (future.isWritten()) {
						log.debug("通知应答发送成功！");
					} else {
						log.error("通知应答发送失败！命令信息：" + command.toString());
					}
				}
			});
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
		// TODO Auto-generated method stub
		// System.out.println("会话关闭函数！");
		if (session != null) {
			// System.out.println(session.getAttribute("HostId").toString());
			// System.out.println(TomcatJdbcPool.getInstance() == null);
			Connection conn = TomcatJdbcPool.getInstance().getConnection();
			// System.out.println(conn == null);
			conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
			// conn.setTransactionIsolation(Connection.TRANSACTION_NONE);
			conn.setAutoCommit(false);
			DataUtils dataUtil = new DataUtils(conn);
			if (session.getAttribute("HostId") != null) {
				if ((dataUtil.modifyGasHostOnlineStatus(session.getAttribute("HostId").toString(), "离线") > 0)) {
					log.info("更新在线信息成功！");
					System.out.println("更新在线信息成功！");
				} else {
					log.error("更新在线信息失败！");
					System.out.println("更新在线信息失败！");
				}
				if(session.getAttribute("HostId")!=null){
					Initialization.getInstance().comDeviceConnectStatusMap.put(session.getAttribute("HostId").toString(), false);
					Initialization.getInstance().comDeviceSessionMap.remove(session.getAttribute("HostId"));
				}
			} else {
				// System.out.println("主机信息为空！");
				log.error("不存在相关主机信息！");
			}
			conn.commit();
			conn.setAutoCommit(true);
		} else {
			// System.out.println("Session为空");
			log.error("session为空！");
		}
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		try {
			new Throwable().printStackTrace(pw);
			log.error("关闭原因[" + sw.toString() + "]\n");
			//System.out.println(sw.toString());
		}finally{
			pw.close();
		}

		super.sessionClosed(session);
	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
		super.exceptionCaught(session, cause);
		if (session.isConnected()) {
			session.close();
		}
		log.error("重启链接，重启员原因[" + cause + "]\n");
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		try{
			cause.printStackTrace(pw);
			log.error("详细原因[" + sw.toString() + "]\n");
			//System.out.println(sw.toString());
		}finally{
			pw.close();
		}


		//log.error("详细原因[" + cause.getLocalizedMessage() + "]\n");
		System.out.println("发生异常");
		cause.printStackTrace();
		// System.out.println(session.getAttribute("HostId").toString());
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
