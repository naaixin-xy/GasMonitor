package com.anfu.gas.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anfu.gas.mapper.AdminMapper;
import com.anfu.gas.mapper.AreaMapper;
import com.anfu.gas.mapper.CityMapper;
import com.anfu.gas.mapper.EnterpriseMapper;
import com.anfu.gas.mapper.ProvinceMapper;
import com.anfu.gas.mapper.StreetMapper;
import com.anfu.gas.pojo.Admin;
import com.anfu.gas.pojo.AdminExample;
import com.anfu.gas.pojo.Area;
import com.anfu.gas.pojo.City;
import com.anfu.gas.pojo.Enterprise;
import com.anfu.gas.pojo.Province;
import com.anfu.gas.pojo.Street;
import com.anfu.gas.service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService{
	//MemberMapper memberMapper;
	@Autowired
	AdminMapper adminMapper;
	@Autowired
	ProvinceMapper provinceMapper;
	@Autowired
	CityMapper cityMapper;
	@Autowired
	AreaMapper areaMapper;
	@Autowired
	StreetMapper streetMapper;
	@Autowired
	EnterpriseMapper enterpriseMapper;
//	public MemberMapper getMemberMapper() {
//		return memberMapper;
//	}
//
//	public void setMemberMapper(MemberMapper memberMapper) {
//		this.memberMapper = memberMapper;
//	}
//	
	public Map<String,Object> getAdminByAccountAndPassword(String account,String password){
		
		AdminExample adminExample = new AdminExample();
		AdminExample.Criteria criteria = adminExample.createCriteria();
		criteria.andAccountEqualTo(account).andPasswordEqualTo(password);
		List<Admin> list = adminMapper.selectByExample(adminExample);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("list", list);
		if(list.get(0).getLevel()==0) {
			map.put("adminRegion", "china");
		}else if(list.get(0).getLevel()==1) {
			Province province = provinceMapper.selectByPrimaryKey(list.get(0).getRegionId());
			map.put("adminRegion", province);
		}else if(list.get(0).getLevel()==2) {
			City city = cityMapper.selectByPrimaryKey(list.get(0).getRegionId());
			map.put("adminRegion",city);
		}else if(list.get(0).getLevel()==3) {
			Area area = areaMapper.selectByPrimaryKey(list.get(0).getRegionId());
			map.put("adminRegion",area);
		}else if(list.get(0).getLevel()==4) {
			Street street = streetMapper.selectByPrimaryKey(list.get(0).getRegionId());
			map.put("adminRegion",street);
		}else if(list.get(0).getLevel()==5) {
			Enterprise enterprise = enterpriseMapper.selectByPrimaryKey(list.get(0).getRegionId());
			map.put("adminRegion",enterprise);
		}else if(list.get(0).getLevel()==6) {
			//SubArea subArea;
		}	
		return map;
	}
	
	@Test
	public void testAdmin() {
		Map<String,Object> map = getAdminByAccountAndPassword("superboss","superboss");
		System.out.println(map);
	}
}
