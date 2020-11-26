package com.anfu.gas.pojo;

import java.util.Date;

public class GasRealtimeData {
    private Long id;

    private Integer deteid;

    private Float value;

    private Date dateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDeteid() {
        return deteid;
    }

    public void setDeteid(Integer deteid) {
        this.deteid = deteid;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}