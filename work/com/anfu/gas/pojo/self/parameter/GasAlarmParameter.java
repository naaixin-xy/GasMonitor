package com.anfu.gas.pojo.self.parameter;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class GasAlarmParameter extends ParameterData{

    protected Integer id;

    protected Integer hostId;

    protected Integer detectorId;

    protected Byte type;

    protected Integer alarmDataValue;

//    protected Integer provinceId;
//
//    protected Integer cityId;
//
//    protected Integer areaId;
//
//    protected Integer streetId;
//    
//    protected Integer enterpriseId;
//    protected String enterpriseName;
//
//    protected String streetName;
//
//    protected String areaName;
//
//    protected String cityName;
//
//    protected String provinceName;

//    protected String location;

    protected Double longitude;

    protected Double latitude;

    protected Date startTime;

    protected Date stopTime;
	
	
	private int page;
	private int limit;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date headTime;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date endTime;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	public Date getHeadTime() {
		return headTime;
	}
	public void setHeadTime(Date headTime) {
		this.headTime = headTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getHostId() {
		return hostId;
	}
	public void setHostId(Integer hostId) {
		this.hostId = hostId;
	}
	public Integer getDetectorId() {
		return detectorId;
	}
	public void setDetectorId(Integer detectorId) {
		this.detectorId = detectorId;
	}
	public Byte getType() {
		return type;
	}
	public void setType(Byte type) {
		this.type = type;
	}
	public Integer getAlarmDataValue() {
		return alarmDataValue;
	}
	public void setAlarmDataValue(Integer alarmDataValue) {
		this.alarmDataValue = alarmDataValue;
	}
	public Integer getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public Integer getStreetId() {
		return streetId;
	}
	public void setStreetId(Integer streetId) {
		this.streetId = streetId;
	}
	public Integer getEnterpriseId() {
		return enterpriseId;
	}
	public void setEnterpriseId(Integer enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getStopTime() {
		return stopTime;
	}
	public void setStopTime(Date stopTime) {
		this.stopTime = stopTime;
	}
	@Override
	public String toString() {
		return "GasAlarmParameter [id=" + id + ", hostId=" + hostId + ", detectorId=" + detectorId + ", type=" + type
				+ ", alarmDataValue=" + alarmDataValue + ", provinceId=" + provinceId + ", cityId=" + cityId
				+ ", areaId=" + areaId + ", streetId=" + streetId + ", enterpriseId=" + enterpriseId + ", longitude="
				+ longitude + ", latitude=" + latitude + ", startTime=" + startTime + ", stopTime=" + stopTime
				+ ", page=" + page + ", limit=" + limit + ", headTime=" + headTime + ", endTime=" + endTime + "]";
	}	
}
