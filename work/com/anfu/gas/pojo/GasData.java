package com.anfu.gas.pojo;

import java.util.Date;

public class GasData {
    private Integer id;

    private Integer hostId;

    private Integer detectorId;

    private Integer hostAddress;

    private Integer detectorAddress;

    private Integer type;

    private Integer dataValue;

    private Integer enterpriseId;

    private Date produceTime;

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

    public Integer getHostAddress() {
        return hostAddress;
    }

    public void setHostAddress(Integer hostAddress) {
        this.hostAddress = hostAddress;
    }

    public Integer getDetectorAddress() {
        return detectorAddress;
    }

    public void setDetectorAddress(Integer detectorAddress) {
        this.detectorAddress = detectorAddress;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getDataValue() {
        return dataValue;
    }

    public void setDataValue(Integer dataValue) {
        this.dataValue = dataValue;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Date getProduceTime() {
        return produceTime;
    }

    public void setProduceTime(Date produceTime) {
        this.produceTime = produceTime;
    }
}