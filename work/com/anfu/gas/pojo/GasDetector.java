package com.anfu.gas.pojo;

import java.util.Date;

public class GasDetector {
    private Integer id;

    private String name;

    private Integer enterpriseId;

    private Integer subArea;

    private Integer typeId;

    private Integer hostId;

    private Integer communicationAddress;

    private String location;

    private Integer coordinateX;

    private Integer coordinateY;

    private String governor;

    private String installer;

    private String serialNumber;

    private Integer lowAlarm;

    private Integer highAlarm;

    private Byte status;

    private Byte connectionStatus;

    private Byte alarmStatus;

    private Byte faultStatus;

    private String note;

    private Date createTime;

    private Date lastUpdateTime;

    private Double longitude;

    private Double latitude;

    private Integer currentValue;

    private Integer minValue;

    private Integer maxValue;

    private String gasType;

    private String gasUnit;

    private Integer provinceId;

    private Integer cityId;

    private Integer areaId;

    private Integer streetId;

    private String enterpriseName;

    private String streetName;

    private String areaName;

    private String cityName;

    private String provinceName;

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
        this.name = name == null ? null : name.trim();
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Integer getSubArea() {
        return subArea;
    }

    public void setSubArea(Integer subArea) {
        this.subArea = subArea;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getHostId() {
        return hostId;
    }

    public void setHostId(Integer hostId) {
        this.hostId = hostId;
    }

    public Integer getCommunicationAddress() {
        return communicationAddress;
    }

    public void setCommunicationAddress(Integer communicationAddress) {
        this.communicationAddress = communicationAddress;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Integer getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(Integer coordinateX) {
        this.coordinateX = coordinateX;
    }

    public Integer getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(Integer coordinateY) {
        this.coordinateY = coordinateY;
    }

    public String getGovernor() {
        return governor;
    }

    public void setGovernor(String governor) {
        this.governor = governor == null ? null : governor.trim();
    }

    public String getInstaller() {
        return installer;
    }

    public void setInstaller(String installer) {
        this.installer = installer == null ? null : installer.trim();
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    public Integer getLowAlarm() {
        return lowAlarm;
    }

    public void setLowAlarm(Integer lowAlarm) {
        this.lowAlarm = lowAlarm;
    }

    public Integer getHighAlarm() {
        return highAlarm;
    }

    public void setHighAlarm(Integer highAlarm) {
        this.highAlarm = highAlarm;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getConnectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(Byte connectionStatus) {
        this.connectionStatus = connectionStatus;
    }

    public Byte getAlarmStatus() {
        return alarmStatus;
    }

    public void setAlarmStatus(Byte alarmStatus) {
        this.alarmStatus = alarmStatus;
    }

    public Byte getFaultStatus() {
        return faultStatus;
    }

    public void setFaultStatus(Byte faultStatus) {
        this.faultStatus = faultStatus;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
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

    public Integer getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Integer currentValue) {
        this.currentValue = currentValue;
    }

    public Integer getMinValue() {
        return minValue;
    }

    public void setMinValue(Integer minValue) {
        this.minValue = minValue;
    }

    public Integer getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Integer maxValue) {
        this.maxValue = maxValue;
    }

    public String getGasType() {
        return gasType;
    }

    public void setGasType(String gasType) {
        this.gasType = gasType == null ? null : gasType.trim();
    }

    public String getGasUnit() {
        return gasUnit;
    }

    public void setGasUnit(String gasUnit) {
        this.gasUnit = gasUnit == null ? null : gasUnit.trim();
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

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName == null ? null : enterpriseName.trim();
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName == null ? null : streetName.trim();
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
    }
}