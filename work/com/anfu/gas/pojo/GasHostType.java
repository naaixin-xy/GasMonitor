package com.anfu.gas.pojo;

import java.util.Date;

public class GasHostType {
    private Integer id;

    private String name;

    private Integer maxDetectorCount;

    private Integer commnicationMode;

    private Integer uploadMode;

    private String note;

    private Date createTime;

    private Date lastUpdateTime;

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

    public Integer getMaxDetectorCount() {
        return maxDetectorCount;
    }

    public void setMaxDetectorCount(Integer maxDetectorCount) {
        this.maxDetectorCount = maxDetectorCount;
    }

    public Integer getCommnicationMode() {
        return commnicationMode;
    }

    public void setCommnicationMode(Integer commnicationMode) {
        this.commnicationMode = commnicationMode;
    }

    public Integer getUploadMode() {
        return uploadMode;
    }

    public void setUploadMode(Integer uploadMode) {
        this.uploadMode = uploadMode;
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
}