package com.anfu.gas.pojo;

import java.util.Date;

public class GasLinkage {
    private Integer id;

    private Integer hostId;

    private Integer deteId;

    private Integer hostAddress;

    private Integer detectorAddress;

    private Integer type;

    private String detailInfo;

    private Date operateTime;

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

    public Integer getDeteId() {
        return deteId;
    }

    public void setDeteId(Integer deteId) {
        this.deteId = deteId;
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

    public String getDetailInfo() {
        return detailInfo;
    }

    public void setDetailInfo(String detailInfo) {
        this.detailInfo = detailInfo == null ? null : detailInfo.trim();
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }
}