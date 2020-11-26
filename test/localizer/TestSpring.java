package localizer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhongzhi.location.pojo.Localizer;
import com.zhongzhi.location.pojo.Member;
import com.zhongzhi.location.service.LocalizerService;
import com.zhongzhi.location.service.MemberService;
import com.zhongzhi.service.StudentService;

public class TestSpring {
	@Test
	public void testDemo() {
		//ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Byte b=20;
		int i=20;
		System.out.println(b==i);
	}
	@Test
	public void testMybatis() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentService ss = (StudentService)ac.getBean("studentService", StudentService.class);
		//System.out.println(ss.getAllStudent());
		ss.demo1();
		//ss.getAllStudent();
		System.out.println(ss.getAllStudent());
		ss.demo2();
	}
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

		StudentService ss = (StudentService)ac.getBean("studentService", StudentService.class);
		System.out.println(ss.getAllStudent());
	}
	@Test
	public void testMember() {
		Member member=new Member();
		member.setId(1);
		member.setAccount("jason");
		member.setPassword("123456");
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		MemberService ms = (MemberService)ac.getBean("memberService", MemberService.class);
		//System.out.println(ss.getAllStudent());
		System.out.println(ms.getMemberById(member));
	}
	@Test
	public void testGetMember() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		MemberService ms = (MemberService)ac.getBean("memberService", MemberService.class);
		//System.out.println(ss.getAllStudent());
		System.out.println(ms.getMemberByAccountAndPassword("jason", "123456"));
	}
	@Test
	public void testGetMemberByAll() {
		Member member=new Member();
		//member.setId(1);
		member.setAccount("jason2");
		member.setPassword("12345689");
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		MemberService ms = (MemberService)ac.getBean("memberService", MemberService.class);
		//System.out.println(ss.getAllStudent());
		List<Member> list=ms.getMemberById(member);
		System.out.println(list+":length="+list.size());
	}
	@Test
	public void testAddMember() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		MemberService ms = (MemberService)ac.getBean("memberService", MemberService.class);
		//System.out.println(ss.getAllStudent());
		Member member=new Member();
		//member.setId(1);
//		member.setAccount("jason");
//		member.setPassword("123456");
//		member.setCategory(1);
//		member.setContact("孙启国");
////		member.setCreateTime(new Date());
////		member.setDeviceCount(10);
////		member.setModifyTime(new Date());
////		member.setParentId(1);
////		member.setName("李晓明");
//		member.setPhone("13888888888");
		int i=ms.memberRegister(member);
		if(i>0) {
			System.out.println("注册成功！");	
		}else {	
			System.out.println("注册失败！");		
		}
	}
	@Test
	public void testUpdateMember() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		MemberService ms = (MemberService)ac.getBean("memberService", MemberService.class);
		//System.out.println(ss.getAllStudent());
		Member member=new Member();
		member.setId(11);
		member.setAccount("zhongzhi");
		member.setPassword("123456");
		member.setCategory(5);
		member.setContact("孙启国");
		//member.setCreateTime(new Date());
		//member.setDeviceCount(11);
		member.setModifyTime(new Date());
		member.setParentId(6);
		member.setName("李晓明");
		member.setPhone("13888888888");
		int i=ms.memberModify(member);
		if(i>0) {
			System.out.println("更新成功！");	
		}else {	
			System.out.println("更新失败！");		
		}
	}
	@Test
	public void testDeleteMember() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		MemberService ms = (MemberService)ac.getBean("memberService", MemberService.class);
		int i=ms.memberDelete(2);
		if(i>0) {
			System.out.println("删除成功！");	
		}else {	
			System.out.println("删除失败！");		
		}
	}
	@Test
	public void testDeleteBatchMember() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		MemberService ms = (MemberService)ac.getBean("memberService", MemberService.class);
		ArrayList<Integer> ids = new ArrayList<Integer>();
		ids.add(2);
		ids.add(3);
		int i=ms.memberBatchDelete(ids);
		if(i>0) {
			System.out.println("删除成功！");	
		}else {	
			System.out.println("删除失败！");		
		}
	}
	@Test
	public void testLocalizerById() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		LocalizerService ms = (LocalizerService)ac.getBean("localizerService", LocalizerService.class);
		Localizer local = new Localizer();
		local.setId(1);
		List<Localizer> list=ms.localizerQuery(local);
		System.out.println(list.get(0).getDeviceImei());
	}
	
	@Test
	public void testList() {
		List<Integer> list=new ArrayList<Integer>();
		list.add(1);list.add(2);list.add(3);list.add(4);list.add(5);
		System.out.println(list);
		list.remove(0);
		System.out.println(list);
		list.remove(0);
		System.out.println(list);		
		list.remove(0);
		System.out.println(list);		
		list.remove(0);
		System.out.println(list);		
		list.remove(0);
		System.out.println(list);		
	}	
	
	
}
