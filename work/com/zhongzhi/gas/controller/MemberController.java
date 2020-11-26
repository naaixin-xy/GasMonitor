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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhongzhi.location.pojo.Member;
import com.zhongzhi.location.pojo.MemberQueryParam;
import com.zhongzhi.location.pojo.result.CheckResult;
import com.zhongzhi.location.pojo.result.ExecuteResult;
import com.zhongzhi.location.service.MemberService;

@Controller
public class MemberController {
	@Autowired(required=true)
	private MemberService memberService;

	@RequestMapping("index.do")
	public String jumpIndex() {
		//return "index";
		return "login";
	}
	@RequestMapping("resetPassoword")
	@ResponseBody
	public Map<String,String> resetPassoword(Member mem) {
		//return "index";
		mem.setPassword("123456");
		int i = memberService.memberModify(mem);
		Map<String,String> map = new HashMap<String,String>();
		if(i>0) {
			map.put("executeResult", "success");
		}else {
			map.put("executeResult", "fail");
		}
		return map;
		//return "login";
	}	
	@RequestMapping("memberDelete")
	@ResponseBody
	public Map<String,String> memberDelete(@RequestParam("deleteIds[]") List<Integer> deleteIds) {
	//public Map<String,String> memberDelete() {
		System.out.println("进入删除函数！");
		System.out.println(deleteIds);
		int i = memberService.memberBatchDelete(deleteIds);
		Map<String,String> map = new HashMap<String,String>();
		if(i==0) {
			map.put("executeResult", "fail");
		}else {
			map.put("executeResult", "success");
		}
		return map;
	}	
	
	@RequestMapping("getUserInfo")
	@ResponseBody
	public List<Member> getUserInfo(Member member) {
	//public Map<String,String> memberDelete() {
		List<Member> list = memberService.getMemberById(member);
		memberService.getAllParentsId(126);
		return list;
	}		
	
	@RequestMapping("memberList.do")
	public String memberList(Map<String,Object> map,MemberQueryParam mqp) {
		//System.out.println("进入控制器处理函数！");
		//System.out.println(mqp);
		//mqp.setMember(new Member());
		
		Map<String,Object> pageInfo = memberService.getMemberByPage(mqp);
		map.put("pageInfo",pageInfo);
		map.put("test","测试");
		System.out.println(pageInfo);
		return "memberList";
	}
	@RequestMapping("getChildrenMemberById")
	@ResponseBody
	public List<Member> getChildrenMemberById(HttpSession session,Integer id) {	
		System.out.println(id);
		Member member=new Member();
		Member loginUser=(Member) session.getAttribute("loginUser");
		if(id==null) {
			//member.setParentId(1);loginUser
			//member.setParentId(loginUser.getParentId());
			member.setId(loginUser.getId());
		}else {
			member.setParentId(id);		
		}
		
		//List<Member> members = memberService.memberQuery(member);
		//getChildrenMemberById
		List<Member> members = memberService.getChildrenMemberById(member);
		for (Member mem : members) {
			mem.setName(mem.getName()+"("+mem.getStock()+"/"+mem.getPurchaseQuantity()+")");
			if(mem.getCategory()==1) {
				mem.setIcon("ui/oimgs/treeicon/agent.png");
				///GpsLocation/WebContent/WEB-INF/ui/oimgs/treeicon/agent.png
			}else {
				mem.setIcon("ui/oimgs/treeicon/user.png");	
			}
		}
		return members;
	}
	@RequestMapping("getAllMemberTreeNodes")
	@ResponseBody
	public List<Member> getAllMemberTreeNodes(Member member) {		
		List<Member> members = memberService.memberQuery(member);
		for (Member mem : members) {
			mem.setName(mem.getName()+"("+mem.getStock()+"/"+mem.getPurchaseQuantity()+")");
			if(mem.getCategory()==1) {
				mem.setIcon("ui/oimgs/treeicon/agent.png");
				///GpsLocation/WebContent/WEB-INF/ui/oimgs/treeicon/agent.png
			}else {
				mem.setIcon("ui/oimgs/treeicon/user.png");	
			}
		}
		return members;
	}	
	@RequestMapping("memberList.json")
	@ResponseBody
	public Map<String,Object> memberList(MemberQueryParam mqp) {
		//System.out.println("进入控制器处理函数！");
		//System.out.println(mqp);
		//mqp.setMember(new Member());
		
		Map<String,Object> pageInfo = memberService.getMemberByPage(mqp);
		//map.put("pageInfo",pageInfo);
		//map.put("test","测试");
		//System.out.println(pageInfo);
		return pageInfo;
	}
	@RequestMapping("memberRegister")
	public String showMemberRegisterPage(Map<String,Integer> map,int parentId) {
		map.put("parentId", parentId);
		return "memberRegister";
	}	
	@RequestMapping("memberRegister.do")
	@ResponseBody
	public ExecuteResult memberRegister(Member member) {
		ExecuteResult er = new ExecuteResult();
		member.setCreateTime(new Date());
		member.setModifyTime(new Date());
		int i = memberService.memberRegister(member);
		if(i>0) {
			er.setResult("success");
		}else {
			er.setResult("fail");
		}
		return er;
	}	
	
	@RequestMapping("isUserExist")
	@ResponseBody
	public CheckResult isUserExist(HttpServletResponse response,String account) {
		response.setContentType("text/plain;charset=utf-8");
		CheckResult result=new CheckResult();
		Member member=new Member();
		member.setAccount(account);
		List<Member> list=memberService.getMemberById(member);
		if(list.size()==0) {
			result.setResult("success");			
		}else {
			result.setResult("fail");
		}
		System.out.println(list);
		return result;	
	}
	@RequestMapping("memberModify")
	public String memberModify(Map<String,Object> map,Member member) {
		//memberService.memberModify(member);
		System.out.println(member);
		List<Member> list=memberService.getMemberById(member);
		System.out.println(list);
		map.put("members", list);
		return "memberModify";
	}
	
	@RequestMapping("memberTransfer")
	public String memberTransfer(Map<String,Object> map,Member member) {
		//memberService.memberModify(member);
		System.out.println(member);
		List<Member> list=memberService.getMemberById(member);
		System.out.println(list);
		map.put("members", list);
		return "memberTransfer";
	}	
	
	@RequestMapping("memberTransfer.do")
	@ResponseBody
	public Map<String,String> memberTransfer(Map<String,Object> map,
												Integer sourceUserId,
												Integer destinationUserId,
												String remark) {
		return memberService.memberTransfer(sourceUserId, destinationUserId, remark);
	}	
	
	@RequestMapping("memberOfflineAlarmTimeSet")
	public String memberOfflineAlarmTimeSet(Map<String,Object> map,Member member) {
		//memberService.memberModify(member);
		System.out.println(member);
		List<Member> list=memberService.getMemberById(member);
		System.out.println(list);
		map.put("members", list);
		return "memberOfflineAlarmTimeSet";
	}
	@RequestMapping("memberOfflineAlarmTimeSet.do")
	@ResponseBody
	public Map<String,String> memberOfflineAlarmTimeSet(Member member) {
		//memberService.memberModify(member);
		System.out.println(member);
		int i=memberService.memberModify(member);
		Map<String,String> map = new HashMap<String,String>();
		if(i>0) {
			map.put("result", "success");
		}else {
			map.put("result", "fail");	
		}
		return map;
	}
	public Map<String,String> memberModify(Member member) {
	//public Map<String,String> memberDelete() {
		System.out.println(member);
		int i = memberService.memberModify(member);
		Map<String,String> map = new HashMap<String,String>();
		if(i==0) {
			map.put("executeResult", "fail");
		}else {
			map.put("executeResult", "success");
		}
		return map;
	}
	
	@RequestMapping(value = "getIdentifyingCode3")
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
}
