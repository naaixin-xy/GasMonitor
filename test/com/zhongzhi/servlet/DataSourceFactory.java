package com.zhongzhi.servlet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataSourceFactory {
	//private static DataSourceFactory dsf;
	public static DataSource  ds;
	private DataSourceFactory() {
		
	}
	
	public static DataSource createInstance() throws NamingException {
		Context cxt = new InitialContext();
		ds= (DataSource) cxt.lookup("java:comp/env/test");
		return ds;
	}
}
