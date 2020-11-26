package com.anfu.gas.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {
	
	
	//在进入控制器之前执行
	//如果返回值为 false,阻止进入控制器
	//控制代码
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("进入登录判断拦截器");
		// 其他情况判断session中是否有key，有的话继续用户的操作
		if (request.getSession() != null && request.getSession().getAttribute("loginUser") != null&&request.getSession().getAttribute("loginRegion") != null) {
			return true;
		}
		
		// 最后的情况就是进入登录页面
		response.sendRedirect(request.getContextPath() + "/login");
		return false;
	}
	
	// 控制器执行完成,进入到 jsp 之前执行.
	//日志记录.
	//敏感词语过滤
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) {
	//			throws Exception {
	//		System.out.println("往" + arg3.getViewName() + "跳转");
	//		System.out.println("model 的值" + arg3.getModel().get("model"));
	//		String word = arg3.getModel().get("model").toString();
	//		String newWord = word.replace("祖国", "**");
	//		arg3.getModel().put("model", newWord);
	//		// arg3.getModel().put("model", "修改后的内容");
	//		System.out.println("postHandle");
	}
	
	// jsp 执行完成后执行
	//记录执行过程中出现的异常.
	//可以把异常记录到日志中
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		//System.out.println("afterCompletion" + arg3.getMessage());
	}
}
