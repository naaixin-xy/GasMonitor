package com.anfu.gas.service;

import java.util.Map;

public interface LoginService {
	//MemberMapper memberMapper;
	//MemberDao memberDao;

//	public MemberMapper getMemberMapper() {
//		return memberMapper;
//	}
//
//	public void setMemberMapper(MemberMapper memberMapper) {
//		this.memberMapper = memberMapper;
//	}
//	
	public Map<String,Object> getAdminByAccountAndPassword(String account,String password);
}
