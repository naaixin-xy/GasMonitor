package com.zhongzhi.location.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.zhongzhi.location.mapper.LocalizerMapper;
import com.zhongzhi.location.mapper.MemberMapper;
import com.zhongzhi.location.mapper.wrapper.MemberDao;
import com.zhongzhi.location.pojo.Localizer;
import com.zhongzhi.location.pojo.LocalizerSaleParam;
import com.zhongzhi.location.pojo.Member;

public class SaleService {
//	@Autowired
//	private MemberMapper memberMapper;
	@Autowired
	private LocalizerMapper localizerMapper;
	@Autowired
	private MemberDao memberDao;
	// (lsp,sourceParentsId,destinationParentsId)
	// public Map<String,String> localizerSale(LocalizerSaleParam lsp,List<Integer>
	// sourceParentsId,List<Integer> destinationParentsId ){
	public Map<String, String> localizerSale(LocalizerSaleParam lsp) {
		System.out.println("localizerSale!");
		// int i=0;
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "success");
		List<Member> list;
		List<Integer> lists, listd;
		Localizer local = new Localizer();
		local.setId(lsp.getDeviceId());
		local.setPhone(lsp.getPhone());
		local.setName(lsp.getName());
		local.setDeviceUserId(lsp.getDestinationUserId());
		local.setDeviceNote(lsp.getDeviceNote());
		Member member = new Member();
				
		if (localizerMapper.localizerUpdate(local) < 1) {
			// throw new Exception("更新定位器信息失败");
			map.put("result", "fail");
		}
		;
		//lists = lsp.getSourceParentsId();
		lists = memberDao.getAllParentsId(lsp.getSourceUserId());
		//listd = lsp.getDestinationParentsId();
		listd = memberDao.getAllParentsId(lsp.getDestinationUserId());
		System.out.println(lists);
		System.out.println(listd);
		while ((lists.size() > 0) && (listd.size() > 0)&&(lists.get(0)==listd.get(0))) {
			lists.remove(0);
			listd.remove(0);
		}

//		list=memberMapper.memberQueryById(listd);
//		System.out.println(list);
//		System.out.println(lsp.isChildFlag());

		member.setId(lsp.getSourceUserId());
		list = memberDao.memberQuery(member);
		list.get(0).setStock(list.get(0).getStock() - 1);
		if (memberDao.memberModify(list.get(0)) < 1) {
			map.put("result", "fail");
		};

		member.setId(lsp.getDestinationUserId());
		list = memberDao.memberQuery(member);
		list.get(0).setStock(list.get(0).getStock() + 1);
		//list.get(0).setPurchaseQuantity(list.get(0).getPurchaseQuantity() + 1);
		if (memberDao.memberModify(list.get(0)) < 1) {
			map.put("result", "fail");
		}
		if(listd.size()>0) {
			list=memberDao.memberQueryById(listd);
			for(Member memb:list) {
				memb.setPurchaseQuantity(memb.getPurchaseQuantity()+1);
				if (memberDao.memberModify(memb) < 1) {
					map.put("result", "fail");
				}
			}
		}
		if(lists.size()>0) {
			list=memberDao.memberQueryById(lists);
			for(Member memb:list) {
				memb.setPurchaseQuantity(memb.getPurchaseQuantity()-1);
				if (memberDao.memberModify(memb) < 1) {
					map.put("result", "fail");
				}
			}
		}
		//System.out.println(list);
		//System.out.println(lsp.isChildFlag());		
		return map;
	}
}
