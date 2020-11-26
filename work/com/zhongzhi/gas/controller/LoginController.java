package com.zhongzhi.gas.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhongzhi.location.pojo.LoginInformation;
import com.zhongzhi.location.pojo.Member;
import com.zhongzhi.location.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	LoginService loginService;
	@RequestMapping(value= {"login","ui/gas/views/login"})
	public String login(Map<String,Object> map,HttpServletRequest request,LoginInformation loginInfo) {
		String identifyingCode=""; 
		System.out.println("进入longin函数");
		try {
			identifyingCode = new String((loginInfo.getIdentifyingCode().getBytes("utf-8")));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		identifyingCode = loginInfo.getIdentifyingCode();
//		System.out.println("原验证码："+request.getSession().getAttribute("identifyingCode"));
//		System.out.println("输入验证码："+loginInfo.getIdentifyingCode());
		if((null!=identifyingCode)&&!loginInfo.getIdentifyingCode().equals(request.getSession().getAttribute("identifyingCode"))) {
			map.put("executeResult", "验证码输入有误，请重新输入！");
//			System.out.println("验证码输入有误，请重新输入！");

//			try {
//				request.setCharacterEncoding("utf-8");
//			} catch (UnsupportedEncodingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			return "login";
		}
		if (loginInfo.getLoginType() == 0) {
			List<Member> members = loginService.getMemberByAccountAndPassword(loginInfo.getLoginName(), loginInfo.getPassword());
			if(members.size()>0) {
				request.getSession().setAttribute("loginUser", members.get(0));
				//request.getSession().setAttribute("selectedTreeId", members.get(0).getId());
				map.put("executeResult", "用戶登录成功！");
				System.out.println("用戶登录成功！");
				return "gas/views/index";
			}else {
				map.put("executeResult", "用戶名或密码错误，请重新输入！");
				System.out.println("用戶名或密码错误，请重新输入！");
				
				return "login";
			}
		}else {
			map.put("executeResult", "暂不支持设备登录，请选择用户名登录！");
			return "login";
		}
		//return "index";
	}

	//@RequestMapping(value = "getIdentifyingCode")
	
	@RequestMapping(value={"gas/views/user/getIdentifyingCode","getIdentifyingCode","getIdentifyingCodeSecond"})  
	// @ResponseBody
	public void getIdentifyingCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 初始化阶段，读取qy95.txt
		// web工程中读取 文件，必须使用绝对磁盘路径
		System.out.println("验证码");
		// request.setCharacterEncoding("UTF-8");
		List<String> words = new ArrayList<String>();
		String path = request.getServletContext().getRealPath("/WEB-INF/chengyu.txt");
		System.out.println(path);
		try {
			// BufferedReader reader = new BufferedReader(new FileReader(path));
			InputStreamReader fReader = new InputStreamReader(new FileInputStream(path), "UTF-8");
			BufferedReader reader = new BufferedReader(fReader);
			String line;
			while ((line = reader.readLine()) != null) {
				words.add(line);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(words);
		int width = 126;
		int height = 29;

		// 步骤一 绘制一张内存中图片
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		// 步骤二 图片绘制背景颜色 ---通过绘图对象
		Graphics graphics = bufferedImage.getGraphics();// 得到画图对象 --- 画笔
		// 绘制任何图形之前 都必须指定一个颜色
		graphics.setColor(getRandColor(200, 250));
		graphics.fillRect(0, 0, width, height);

		// 步骤三 绘制边框
		graphics.setColor(Color.WHITE);
		graphics.drawRect(0, 0, width - 1, height - 1);

		// 步骤四 四个随机数字
		Graphics2D graphics2d = (Graphics2D) graphics;
		// 设置输出字体
		graphics2d.setFont(new Font("宋体", Font.BOLD, 18));

		Random random = new Random();// 生成随机数
		int index = random.nextInt(words.size());
		String word = words.get(index);// 获得成语
		//identifyingCode
		request.getSession().setAttribute("identifyingCode", word);
		// 定义x坐标
		int x = 10;
		for (int i = 0; i < word.length(); i++) {
			// 随机颜色
			graphics2d
					.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
			// 旋转 -30 --- 30度
			int jiaodu = random.nextInt(60) - 30;
			// 换算弧度
			double theta = jiaodu * Math.PI / 180;

			// 获得字母数字
			char c = word.charAt(i);

			// 将c 输出到图片
			graphics2d.rotate(theta, x, 20);
			graphics2d.drawString(String.valueOf(c), x, 20);
			graphics2d.rotate(-theta, x, 20);
			x += 30;
		}

		// 将验证码内容保存session
		request.getSession().setAttribute("checkcode_session", word);

		// 步骤五 绘制干扰线
		graphics.setColor(getRandColor(160, 200));
		int x1;
		int x2;
		int y1;
		int y2;
		for (int i = 0; i < 30; i++) {
			x1 = random.nextInt(width);
			x2 = random.nextInt(12);
			y1 = random.nextInt(height);
			y2 = random.nextInt(12);
			graphics.drawLine(x1, y1, x1 + x2, x2 + y2);
		}

		// 将上面图片输出到浏览器 ImageIO
		graphics.dispose();// 释放资源

		// 将图片写到response.getOutputStream()中

		response.setContentType("text/html;charset=utf-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		response.addHeader("Access-Control-Max-Age", "1800");// 30 min
		ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
	}

	private Color getRandColor(int fc, int bc) {
		// 取其随机颜色
		Random random = new Random();
		if (fc > 255) {
			fc = 255;
		}
		if (bc > 255) {
			bc = 255;
		}
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
}
