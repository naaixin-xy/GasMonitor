package com.anfu.gas.controller;

import javax.servlet.http.HttpSession;

import com.anfu.gas.pojo.Admin;
import com.anfu.gas.pojo.Area;
import com.anfu.gas.pojo.City;
import com.anfu.gas.pojo.Enterprise;
import com.anfu.gas.pojo.Province;
import com.anfu.gas.pojo.Street;
import com.anfu.gas.pojo.self.parameter.ParameterData;

public class SessionData {
	public final static class SessionKey{
		public static final String LOGIN_USER="loginUser";
		public static final String LOGIN_REGION="loginRegion";
		public static final String IDENTIFYING_CODE="identifyingCode";
	}
	//public final static class sessionKeys
	public static void setParameterRegionInfoFromSession(ParameterData parameterData,HttpSession session) {

		int type=((Admin)session.getAttribute(SessionData.SessionKey.LOGIN_USER)).getLevel();
		if(type==0) {
			return;
		}
		
		Object loginRegion = session.getAttribute(SessionData.SessionKey.LOGIN_REGION);
		if(loginRegion==null) {
			return;
		}
		if(type==1) {
			parameterData.setProvinceId(((Province)loginRegion).getProvinceId());
		} else if(type==2) {
			parameterData.setCityId(((City)loginRegion).getCityId());
		} else if(type==3) {
			parameterData.setAreaId(((Area)loginRegion).getAreaId());
		} else if(type==4) {
			parameterData.setStreetId(((Street)loginRegion).getStreetId());
		} else if(type==5) {
			parameterData.setEnterpriseId(((Enterprise)loginRegion).getId());
		}  
	}
}
