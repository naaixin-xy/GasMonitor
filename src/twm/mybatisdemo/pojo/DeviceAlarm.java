package twm.mybatisdemo.pojo;

import java.util.Date;

public class DeviceAlarm {
    private Integer alarmId;

    private Byte alarmCategory;

    private Integer alarmDeviceId;

    private Float alarmLongitude;

    private Float alarmLatitude;

    private Date positionTime;

    private Date alarmTime;

    private String alarmNote;

    public Integer getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(Integer alarmId) {
        this.alarmId = alarmId;
    }

    public Byte getAlarmCategory() {
        return alarmCategory;
    }

    public void setAlarmCategory(Byte alarmCategory) {
        this.alarmCategory = alarmCategory;
    }

    public Integer getAlarmDeviceId() {
        return alarmDeviceId;
    }

    public void setAlarmDeviceId(Integer alarmDeviceId) {
        this.alarmDeviceId = alarmDeviceId;
    }

    public Float getAlarmLongitude() {
        return alarmLongitude;
    }

    public void setAlarmLongitude(Float alarmLongitude) {
        this.alarmLongitude = alarmLongitude;
    }

    public Float getAlarmLatitude() {
        return alarmLatitude;
    }

    public void setAlarmLatitude(Float alarmLatitude) {
        this.alarmLatitude = alarmLatitude;
    }

    public Date getPositionTime() {
        return positionTime;
    }

    public void setPositionTime(Date positionTime) {
        this.positionTime = positionTime;
    }

    public Date getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(Date alarmTime) {
        this.alarmTime = alarmTime;
    }

    public String getAlarmNote() {
        return alarmNote;
    }

    public void setAlarmNote(String alarmNote) {
        this.alarmNote = alarmNote == null ? null : alarmNote.trim();
    }
}