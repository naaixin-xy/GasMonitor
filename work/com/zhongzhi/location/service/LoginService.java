package com.zhongzhi.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zhongzhi.location.mapper.wrapper.MemberDao;
import com.zhongzhi.location.pojo.Member;

public class LoginService {
	//MemberMapper memberMapper;
	@Autowired
	MemberDao memberDao;

//	public MemberMapper getMemberMapper() {
//		return memberMapper;
//	}
//
//	public void setMemberMapper(MemberMapper memberMapper) {
//		this.memberMapper = memberMapper;
//	}
//	
	public List<Member> getMemberByAccountAndPassword(String account,String password){
		return memberDao.getMemberByAccountAndPassword(account, password);
	}
}
