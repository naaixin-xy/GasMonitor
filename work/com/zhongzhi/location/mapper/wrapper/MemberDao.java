package com.zhongzhi.location.mapper.wrapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zhongzhi.location.mapper.MemberMapper;
import com.zhongzhi.location.pojo.Member;
import com.zhongzhi.location.pojo.MemberQueryParam;

public class MemberDao {
	MemberMapper memberMapper;
	
	public MemberMapper getMemberMapper() {
		return memberMapper;
	}
	public void setMemberMapper(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}
	public List<Member> memberQuery(Member member) {
		
		return memberMapper.memberQuery(member);
	}
	public Map<String,String> memberTransfer(Integer sourceUserId,Integer destinationUserId,String remark) {
		Map<String,String> map = new HashMap<String,String>();
		return map;
	}
	public List<Member> getMemberById(Member member) {
		
		return memberMapper.memberQuery(member);
	}
	public List<Member> getChildrenMemberById(Member member) {
		List<Member> list = memberMapper.memberQuery(member);
		Member tempMember=new Member();
		for(Member mem:list) {
			tempMember.setParentId(mem.getId());
			if(memberMapper.getMemberCount(tempMember)>0) {
				mem.setIsParent(true);
			}else{
				mem.setIsParent(false);
			};
			
		}
		System.out.println("设备列表"+list);
		return list;
	}
	public Map<String,Object> getMemberByPage(MemberQueryParam queryParam) {
		//queryParam
		int pageSize = queryParam.getPageSize();
		int pageNum = queryParam.getPageNum();
		int pageStart = pageNum*pageSize;
		queryParam.setPageStart(pageStart);
		int totalCount=memberMapper.getMemberCountByPage(queryParam);
		
		int totalPage=totalCount/pageSize;
		if(totalCount%pageSize!=0) {
			totalPage++;
		}
		if(totalCount-pageStart<pageSize) {
			pageSize=totalCount-pageStart;
			queryParam.setPageSize(pageSize);
		}
		int pageEnd=pageStart+pageSize;
		System.out.println("totalCount:"+totalCount);
		
		List<Member> members=memberMapper.memberQueryByPage(queryParam);
		Map<String,Object> pageInfo = new HashMap<String,Object>();
		Map<String,Object> headerInfo = new HashMap<String,Object>();
		headerInfo.put("order", "序号");
		headerInfo.put("select", "选择");
		headerInfo.put("id", "ID");
		headerInfo.put("account", "帐户");
		headerInfo.put("password", "密码");
		headerInfo.put("category", "类型");
		headerInfo.put("name", "姓名");
		headerInfo.put("parentId", "父用户ID");
		headerInfo.put("phone", "电话");
		headerInfo.put("deviceCount", "设备数量");
		headerInfo.put("contact", "联系人");
		headerInfo.put("createTime", "创建时间");
		headerInfo.put("modifyTime", "上次修改时间");
		headerInfo.put("remark", "备注");

		
		/*
		private Integer id;
		private String account;
		private String password;

		private Integer category;
		private String name;
		private Integer parentId;
		private Date modifyTime;
		private String phone;
		private Integer deviceCount;
		private String contact;
		private Date createTime;
		private String remark;*/		
		pageInfo.put("pageSize", pageSize);
		pageInfo.put("pageNum", pageNum);
		pageInfo.put("pageStart", pageStart);
		pageInfo.put("pageEnd", pageEnd);
		pageInfo.put("totalPage", totalPage);
		pageInfo.put("totalCount", totalCount);
		pageInfo.put("dataInfo", members);
		pageInfo.put("headerInfo", headerInfo);
		//pageInfo.put("headerInfo", h);
		pageInfo.put("test", "测试数据2");
		
		System.out.println(pageInfo);
		return pageInfo;
	}	
	public List<Integer> getAllParentsId(int id) {
		Member member=new Member();
		List<Integer> iDlist = new ArrayList<Integer>();
		while(id!=1) {
			member.setId(id);
			iDlist.add(id);
			List<Member> List=memberMapper.memberQuery(member);
			id=List.get(0).getParentId();
		}
		Collections.reverse(iDlist);
		return iDlist;
	}
	public List<Member> memberQueryById(List<Integer> list){
		return memberMapper.memberQueryById(list);
	}
	public List<Member> getMemberByAccountAndPassword(String account,String password) {
		
		return memberMapper.getMemberByAccountAndPassword(account, password);
	}
	public int memberRegister(Member mem) {
		return memberMapper.memberRegister(mem);
	}
	public int memberModify(Member mem) {
		return memberMapper.memberUpdate(mem);
	}
	public int memberDelete(int id) {
		return memberMapper.memberDelete(id);
	}
	public int memberBatchDelete(List<Integer> ids) {
		return memberMapper.memberDeleteBatch(ids);
	}	
}
