package com.zhongzhi.location.pojo;

import java.util.List;

public class LocalizerSaleParam {
	private Integer sourceUserId;
	private Integer destinationUserId;
	private Integer deviceId;
	private String name;
	private String phone;
	private String deviceNote;
	private boolean childFlag;
	private List<Integer> sourceParentsId;
	private List<Integer> destinationParentsId;
	public Integer getSourceUserId() {
		return sourceUserId;
	}
	public void setSourceUserId(Integer sourceUserId) {
		this.sourceUserId = sourceUserId;
	}
	public Integer getDestinationUserId() {
		return destinationUserId;
	}
	public void setDestinationUserId(Integer destinationUserId) {
		this.destinationUserId = destinationUserId;
	}
	public Integer getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDeviceNote() {
		return deviceNote;
	}
	public void setDeviceNote(String deviceNote) {
		this.deviceNote = deviceNote;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isChildFlag() {
		return childFlag;
	}
	public void setChildFlag(boolean childFlag) {
		this.childFlag = childFlag;
	}
	
	public List<Integer> getSourceParentsId() {
		return sourceParentsId;
	}
	public void setSourceParentsId(List<Integer> sourceParentsId) {
		this.sourceParentsId = sourceParentsId;
	}
	public List<Integer> getDestinationParentsId() {
		return destinationParentsId;
	}
	public void setDestinationParentsId(List<Integer> destinationParentsId) {
		this.destinationParentsId = destinationParentsId;
	}
	@Override
	public String toString() {
		return "LocalizerSaleParam [sourceUserId=" + sourceUserId + ", destinationUserId=" + destinationUserId
				+ ", deviceId=" + deviceId + ", name=" + name + ", phone=" + phone + ", deviceNote=" + deviceNote
				+ ", childFlag=" + childFlag + ", sourceParentsId=" + sourceParentsId + ", destinationParentsId="
				+ destinationParentsId + "]";
	}
}
