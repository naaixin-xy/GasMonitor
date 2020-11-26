package com.anfu.gas.service.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfu.gas.pojo.self.parameter.GasAlarmParameter;

public class ServiceAdvice {
	private final static Logger log = LoggerFactory.getLogger(ServiceAdvice.class);
	
	public void mybefore(GasAlarmParameter gasAlarmParameter){
		log.info("前置"+gasAlarmParameter);
	} 
	public void mybefore1(){
		log.info("前置:");
	} 
	public void myaftering(){
		log.info("后置 2");
	} 
	public void myafter(){
		log.info("后置 1");
	} 
	public void mythrow(){
		log.info("异常");
	} 
	public Object myarround(ProceedingJoinPoint p) throws Throwable{
		log.info("执行环绕");
		log.info("环绕-前置");
		Object result = p.proceed();
		log.info("环绕后置");
		return result;
	}
}
