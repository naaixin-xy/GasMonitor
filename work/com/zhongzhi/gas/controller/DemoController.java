package com.zhongzhi.gas.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("demo")
public class DemoController {
	@RequestMapping("demo")
	public String demo() {
		System.out.println("执行 demo");
		return "redirect:AdminLogin.jsp";
	}

	@RequestMapping("demo2")
	public String demo2() {
		System.out.println("demo2");
		return "forward:main1";
	}

	@RequestMapping("demo3")
	public String demo3() {
		System.out.println("demo3");
		return "love";
	}

	// @RequestMapping(value = "demo12", produces = "text/html;charset=utf-8")
	@RequestMapping(value = "demo12")
	@ResponseBody
	public People demo12() throws IOException {
		People p = new People();
		p.setAge(12);
		p.setName("张三");
		p.setSex("男");
		p.setId(10001);
		return p;
	}

	@RequestMapping(value = "demo13")
	@ResponseBody
	public String demo13() throws IOException {
		People p = new People();
		p.setAge(12);
		p.setName("张三");
		p.setSex("男");
		p.setId(10001);
		return "中文";
	}

	@RequestMapping(value = "getIdentifyingCode2")
	//@ResponseBody
	public void getIdentifyingCode(HttpServletRequest request,HttpServletResponse response) throws IOException {
		// 初始化阶段，读取qy95.txt
		// web工程中读取 文件，必须使用绝对磁盘路径
		System.out.println("验证码");
		//request.setCharacterEncoding("UTF-8");
		List<String> words = new ArrayList<String>();
		String path = request.getServletContext().getRealPath("/WEB-INF/chengyu.txt");
		System.out.println(path);
		try {
			//BufferedReader reader = new BufferedReader(new FileReader(path));
			InputStreamReader fReader = new InputStreamReader(new FileInputStream(path),"UTF-8");
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
		int width = 120;
		int height = 30;

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
        response.addHeader("Access-Control-Max-Age", "1800");//30 min	
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

	@RequestMapping("demo14")
	public String demo14(HttpServletRequest abc, HttpSession sessionParam) {
		// request 作用域
		abc.setAttribute("req", "req 的值");
		// session 作用域
		HttpSession session = abc.getSession();
		session.setAttribute("session", "session 的值");
		sessionParam.setAttribute("sessionParam", "sessionParam 的值");
		sessionParam.setAttribute("sessionCompare", sessionParam.getId() == session.getId());
		// appliaction 作用域
		ServletContext application = abc.getServletContext();
		application.setAttribute("application", "application 的值");
		return "forward:index.jsp";
	}

	@RequestMapping("/demo15")
	public String demo15(Map<String, Object> map) {
		System.out.println(map.getClass());
		map.put("map", "map 的值");
		map.put("mapclass", map.getClass().toString());
		return "forward:/uia/index15.jsp";
	}

	@RequestMapping("demo16")
	public String demo16(Model model) {
		model.addAttribute("model", "model 的值祖国祖国我爱你");
		model.addAttribute("modelClass", model.getClass().toString());
		return "forward:/index16.jsp";
	}

	@RequestMapping("demo17")
	public ModelAndView demo17() {
		// 参数,跳转视图
		ModelAndView mav = new ModelAndView("forward:index17.jsp");
		mav.addObject("mav", "mav 的值+++++我爱祖国");
		return mav;
	}

	@RequestMapping("download")
	public void download(String fileName, HttpServletResponse res, HttpServletRequest req) throws IOException {
		// 设置响应流中文件进行下载
		res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		// 把二进制流放入到响应体中.
		ServletOutputStream os = res.getOutputStream();
		String path = req.getServletContext().getRealPath("files");
		System.out.println(path);
		String path2 = req.getServletContext().getRealPath("/");
		System.out.println(path2);
		File file = new File(path, fileName);
		if (!file.exists()) {
			// os.close();
			System.out.println("您找的文件不存在");
			// res.getWriter().print("您找的文件不存在");
			// res.sendRedirect("/index2.htm");
		} else {
			byte[] bytes = FileUtils.readFileToByteArray(file);
			os.write(bytes);
			os.flush();
			os.close();
		}
	}

	@RequestMapping("upload")
	public String upload(MultipartFile file, String name) throws IOException {
		String fileName = file.getOriginalFilename();
		System.out.println("fileName:" + fileName);
		System.out.println("name:" + name);
		String suffix = fileName.substring(fileName.lastIndexOf("."));
		// 判断上传文件类型
		if (suffix.equalsIgnoreCase(".jpg")) {
			String uuid = UUID.randomUUID().toString();
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File("E:/" + uuid + suffix));
			return "forward:/index.jsp";
		} else {
			return "forward:error.jsp";
		}
	}
}
