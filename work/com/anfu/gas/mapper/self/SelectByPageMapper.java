package com.anfu.gas.mapper.self;

import java.util.List;

import com.anfu.gas.pojo.Admin;
import com.anfu.gas.pojo.Area;
import com.anfu.gas.pojo.City;
import com.anfu.gas.pojo.Enterprise;
import com.anfu.gas.pojo.GasAlarm;
import com.anfu.gas.pojo.GasData;
import com.anfu.gas.pojo.GasDetector;
import com.anfu.gas.pojo.GasDetectorType;
import com.anfu.gas.pojo.GasFault;
import com.anfu.gas.pojo.GasHost;
import com.anfu.gas.pojo.GasHostType;
import com.anfu.gas.pojo.GasType;
import com.anfu.gas.pojo.Province;
import com.anfu.gas.pojo.Street;
import com.anfu.gas.pojo.SubArea;
import com.anfu.gas.pojo.self.AdminExamplePageInfo;
import com.anfu.gas.pojo.self.AreaExamplePageInfo;
import com.anfu.gas.pojo.self.CityExamplePageInfo;
import com.anfu.gas.pojo.self.EnterpriseExamplePageInfo;
import com.anfu.gas.pojo.self.GasAlarmExamplePageInfo;
import com.anfu.gas.pojo.self.GasDataExamplePageInfo;
import com.anfu.gas.pojo.self.GasDetectorExamplePageInfo;
import com.anfu.gas.pojo.self.GasDetectorTypeExamplePageInfo;
import com.anfu.gas.pojo.self.GasFaultExamplePageInfo;
import com.anfu.gas.pojo.self.GasHostExamplePageInfo;
import com.anfu.gas.pojo.self.GasHostTypeExamplePageInfo;
import com.anfu.gas.pojo.self.GasTypeExamplePageInfo;
import com.anfu.gas.pojo.self.ProvinceExamplePageInfo;
import com.anfu.gas.pojo.self.StreetExamplePageInfo;
import com.anfu.gas.pojo.self.SubAreaExamplePageInfo;

public interface SelectByPageMapper {
	List<Admin> selectAdminByExampleAndPage(AdminExamplePageInfo example);
    List<GasDetector> selectGasDetectorByExampleAndPage(GasDetectorExamplePageInfo example);
    List<GasHost> selectGasHostByExampleAndPage(GasHostExamplePageInfo example);
    List<Province> selectProvinceByExampleAndPage(ProvinceExamplePageInfo example);
    List<City> selectCityByExampleAndPage(CityExamplePageInfo example);
    List<Area> selectAreaByExampleAndPage(AreaExamplePageInfo example); 
    List<Street> selectStreetByExampleAndPage(StreetExamplePageInfo example);
    List<Enterprise> selectEnterpriseByExampleAndPage(EnterpriseExamplePageInfo example);
    List<SubArea> selectSubAreaByExampleAndPage(SubAreaExamplePageInfo example);
    List<GasAlarm> selectGasAlarmByExampleAndPage(GasAlarmExamplePageInfo example);
    List<GasFault> selectGasFaultByExampleAndPage(GasFaultExamplePageInfo example);
    List<GasData> selectGasDataByExampleAndPage(GasDataExamplePageInfo example);
    List<GasType> selectGasTypeByExampleAndPage(GasTypeExamplePageInfo example);
    List<GasDetectorType> selectGasDetectorTypeByExampleAndPage(GasDetectorTypeExamplePageInfo example);
    List<GasHostType> selectGasHostTypeByExampleAndPage(GasHostTypeExamplePageInfo example);
}
