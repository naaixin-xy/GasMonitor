package com.anfu.gas.pojo;

import java.util.Date;

public class GasDetectorType {
    private Integer id;

    private String name;

    private Integer communicationMode;

    private Integer gasType;

    private String measureUnit;

    private Integer measureRange;

    private Integer resolutionRatio;

    private Integer lowAlarm;

    private String note;

    private Date createTime;

    private Date lastUpdateTime;

    private Integer highAlarm;

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

    public Integer getCommunicationMode() {
        return communicationMode;
    }

    public void setCommunicationMode(Integer communicationMode) {
        this.communicationMode = communicationMode;
    }

    public Integer getGasType() {
        return gasType;
    }

    public void setGasType(Integer gasType) {
        this.gasType = gasType;
    }

    public String getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(String measureUnit) {
        this.measureUnit = measureUnit == null ? null : measureUnit.trim();
    }

    public Integer getMeasureRange() {
        return measureRange;
    }

    public void setMeasureRange(Integer measureRange) {
        this.measureRange = measureRange;
    }

    public Integer getResolutionRatio() {
        return resolutionRatio;
    }

    public void setResolutionRatio(Integer resolutionRatio) {
        this.resolutionRatio = resolutionRatio;
    }

    public Integer getLowAlarm() {
        return lowAlarm;
    }

    public void setLowAlarm(Integer lowAlarm) {
        this.lowAlarm = lowAlarm;
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

    public Integer getHighAlarm() {
        return highAlarm;
    }

    public void setHighAlarm(Integer highAlarm) {
        this.highAlarm = highAlarm;
    }
}