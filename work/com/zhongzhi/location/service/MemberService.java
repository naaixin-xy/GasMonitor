package com.zhongzhi.location.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zhongzhi.location.mapper.wrapper.MemberDao;
import com.zhongzhi.location.pojo.Localizer;
import com.zhongzhi.location.pojo.Member;
import com.zhongzhi.location.pojo.MemberQueryParam;

public class MemberService {
	
	MemberDao memberDao;

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	public Map<String,String> memberTransfer(Integer sourceUserId,Integer destinationUserId,String remark) {
		System.out.println("localizerSale!");
		// int i=0;
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "success");
		List<Member> list;
		List<Integer> lists, listd;

		Member member = new Member();

		lists = memberDao.getAllParentsId(sourceUserId);
		listd = memberDao.getAllParentsId(destinationUserId);
		System.out.println(lists);
		System.out.println(listd);
		while ((lists.size() > 0) && (listd.size() > 0)&&(lists.get(0)==listd.get(0))) {
			lists.remove(0);
			listd.remove(0);
		}

		member.setId(sourceUserId);
		member.setParentId(destinationUserId);
		if(memberDao.memberModify(member)<1) {
			map.put("result", "fail");
		}
		int purchaseQuantity =  memberDao.memberQuery(member).get(0).getPurchaseQuantity();

		if(listd.size()>0) {
			list=memberDao.memberQueryById(listd);
			for(Member memb:list) {
				memb.setPurchaseQuantity(memb.getPurchaseQuantity()+purchaseQuantity);
				if (memberDao.memberModify(memb) < 1) {
					map.put("result", "fail");
				}
			}
		}
		if(lists.size()>0) {
			list=memberDao.memberQueryById(lists);
			for(Member memb:list) {
				if(memb.getId()==sourceUserId) {
					break;
				}
				memb.setPurchaseQuantity(memb.getPurchaseQuantity()-purchaseQuantity);
				if (memberDao.memberModify(memb) < 1) {
					map.put("result", "fail");
				}
			}
		}	
		return map;		
		//Map<String,String> map = memberDao.memberTransfer(sourceUserId, destinationUserId, remark);
		//return map;
	}
	public List<Member> memberQuery(Member member) {
		
		return memberDao.memberQuery(member);
	}
	public List<Member> getMemberById(Member member) {
		
		return memberDao.memberQuery(member);
	}
	public List<Member> getChildrenMemberById(Member member) {

		return memberDao.getChildrenMemberById(member);
	}
	public Map<String,Object> getMemberByPage(MemberQueryParam queryParam) {
	
		return memberDao.getMemberByPage(queryParam);
	}	
	public List<Integer> getAllParentsId(Integer id) {
		List<Integer> list = memberDao.getAllParentsId(id);
		System.out.println(list);
		return list;
	}	
		
	public List<Member> getMemberByAccountAndPassword(String account,String password) {
		
		return memberDao.getMemberByAccountAndPassword(account, password);
	}
	public int memberRegister(Member mem) {
		return memberDao.memberRegister(mem);
	}
	public int memberModify(Member mem) {
		return memberDao.memberModify(mem);
	}
	public int memberDelete(int id) {
		return memberDao.memberDelete(id);
	}
	public int memberBatchDelete(List<Integer> ids) {
		return memberDao.memberBatchDelete(ids);
	}	

}
