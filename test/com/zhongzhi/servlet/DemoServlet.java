package com.zhongzhi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhongzhi.service.StudentService;

//@WebServlet("/pool")
public class DemoServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	StudentService ss = new StudentService();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentService ss = (StudentService)ac.getBean("studentService", StudentService.class);
		//res.setCharacterEncoding("utf-8");
		res.setContentType("text/plain;charset=utf-8");
//			Context cxt = new InitialContext();
//			DataSource ds = (DataSource) cxt.lookup("java:comp/env/test");
//			Connection conn = ds.getConnection();
//			PreparedStatement ps = conn.prepareStatement("select * from student");
//			ResultSet rs = ps.executeQuery();
//			res.setContentType("text/html;charset=utf-8");
//			PrintWriter out = res.getWriter();
//			while(rs.next()){
//				out.print(rs.getInt(1)+"&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString(2)+"<br/>");
//			}
//			out.flush();
//			out.close();
//			rs.close();
			System.out.println(ss.getAllStudent());
			res.getWriter().print(ss.getAllStudent());
}
}
