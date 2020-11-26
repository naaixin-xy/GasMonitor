package com.zhongzhi.location.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhongzhi.location.pojo.Member;
import com.zhongzhi.location.pojo.MemberQueryParam;

public interface MemberMapper {
	public int memberRegister(Member mem);
	public int memberDelete(int id);
	public int memberDeleteBatch(List<Integer> ids);
	public int memberUpdate(Member member);
	public int getMemberCountByPage(MemberQueryParam queryParam);
	public int getMemberCount(Member member);	
	public List<Member> memberQueryByPage(MemberQueryParam queryParam);
	public List<Member> memberQuery(Member member);
	public List<Member> memberQueryById(List<Integer> list);
	public List<Member> getMemberByAccountAndPassword(@Param("account") String account, @Param("password") String password);
}
