package com.zhongzhi.location.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//@JsonIgnoreProperties(value={"member"})
public class Localizer {
	Integer id;
	String name;
	String phone;
	String plateNumber;
	Integer speedLimit;
	String contactPhone;
	Float oilCoefficient;
	Integer maintainDistancePeriod;
	Integer lastMaintainKilometre;
	Integer filterLbs;
	String deviceContact;
	Integer deviceUserId;
	String devicePassword;
	Integer deviceStatus;
	Integer connectStatus;
	Integer deviceIcon;
	String deviceImei;
	Integer deviceCategory;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	Date createTime;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	Date activeTime;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	Date dueTime;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	//@JsonFormat(pattern = "yyyy-MM-dd")
	Date lastUpdateTime;
	String deviceNote;
	//@JsonIgnore
	Member member;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public Integer getSpeedLimit() {
		return speedLimit;
	}

	public void setSpeedLimit(Integer speedLimit) {
		this.speedLimit = speedLimit;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public Float getOilCoefficient() {
		return oilCoefficient;
	}

	public void setOilCoefficient(Float oilCoefficient) {
		this.oilCoefficient = oilCoefficient;
	}

	public Integer getMaintainDistancePeriod() {
		return maintainDistancePeriod;
	}

	public void setMaintainDistancePeriod(Integer maintainDistancePeriod) {
		this.maintainDistancePeriod = maintainDistancePeriod;
	}

	public Integer getLastMaintainKilometre() {
		return lastMaintainKilometre;
	}

	public void setLastMaintainKilometre(Integer lastMaintainKilometre) {
		this.lastMaintainKilometre = lastMaintainKilometre;
	}

	public Integer getFilterLbs() {
		return filterLbs;
	}

	public void setFilterLbs(Integer filterLbs) {
		this.filterLbs = filterLbs;
	}

	public String getDeviceContact() {
		return deviceContact;
	}

	public void setDeviceContact(String deviceContact) {
		this.deviceContact = deviceContact;
	}

	public Integer getDeviceUserId() {
		return deviceUserId;
	}

	public void setDeviceUserId(Integer deviceUserId) {
		this.deviceUserId = deviceUserId;
	}

	public String getDevicePassword() {
		return devicePassword;
	}

	public void setDevicePassword(String devicePassword) {
		this.devicePassword = devicePassword;
	}

	public Integer getDeviceStatus() {
		return deviceStatus;
	}

	public void setDeviceStatus(Integer deviceStatus) {
		this.deviceStatus = deviceStatus;
	}

	public Integer getConnectStatus() {
		return connectStatus;
	}

	public void setConnectStatus(Integer connectStatus) {
		this.connectStatus = connectStatus;
	}

	public Integer getDeviceIcon() {
		return deviceIcon;
	}

	public void setDeviceIcon(Integer deviceIcon) {
		this.deviceIcon = deviceIcon;
	}

	public String getDeviceImei() {
		return deviceImei;
	}

	public void setDeviceImei(String deviceImei) {
		this.deviceImei = deviceImei;
	}

	public Integer getDeviceCategory() {
		return deviceCategory;
	}

	public void setDeviceCategory(Integer deviceCategory) {
		this.deviceCategory = deviceCategory;
	}

	public Date getActiveTime() {
		return activeTime;
	}

	public void setActiveTime(Date activeTime) {
		this.activeTime = activeTime;
	}

	public Date getDueTime() {
		return dueTime;
	}

	public void setDueTime(Date dueTime) {
		this.dueTime = dueTime;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getDeviceNote() {
		return deviceNote;
	}

	public void setDeviceNote(String deviceNote) {
		this.deviceNote = deviceNote;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "Localizer [id=" + id + ", name=" + name + ", phone=" + phone + ", plateNumber=" + plateNumber
				+ ", speedLimit=" + speedLimit + ", contactPhone=" + contactPhone + ", oilCoefficient=" + oilCoefficient
				+ ", maintainDistancePeriod=" + maintainDistancePeriod + ", lastMaintainKilometre="
				+ lastMaintainKilometre + ", filterLbs=" + filterLbs + ", deviceContact=" + deviceContact
				+ ", deviceUserId=" + deviceUserId + ", devicePassword=" + devicePassword + ", deviceStatus="
				+ deviceStatus + ", connectStatus=" + connectStatus + ", deviceIcon=" + deviceIcon + ", deviceImei="
				+ deviceImei + ", deviceCategory=" + deviceCategory + ", createTime=" + createTime + ", activeTime="
				+ activeTime + ", dueTime=" + dueTime + ", lastUpdateTime=" + lastUpdateTime + ", deviceNote="
				+ deviceNote + "]";
	}
}
