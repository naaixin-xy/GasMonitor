package twm.mybatisdemo.pojo;

import java.util.Date;

public class AllDevice {
    private Integer deviceId;

    private String deviceName;

    private String devicePhone;

    private String plateNumber;

    private Short speedLimit;

    private String contactPhone;

    private Float oilCoefficient;

    private Integer maintainDistancePeriod;

    private Integer lastMaintainKilometre;

    private Boolean filterLbs;

    private String deviceContact;

    private Integer deviceUserId;

    private String devicePassword;

    private Byte deviceStatus;

    private Byte connectStatus;

    private Byte deviceIcon;

    private String deviceImei;

    private Byte deviceCategory;

    private Date createTime;

    private Date activeTime;

    private Date dueTime;

    private String deviceNote;

    private Date lastUpdateTime;

    private Double latitude;

    private Double longitude;

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName == null ? null : deviceName.trim();
    }

    public String getDevicePhone() {
        return devicePhone;
    }

    public void setDevicePhone(String devicePhone) {
        this.devicePhone = devicePhone == null ? null : devicePhone.trim();
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber == null ? null : plateNumber.trim();
    }

    public Short getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(Short speedLimit) {
        this.speedLimit = speedLimit;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
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

    public Boolean getFilterLbs() {
        return filterLbs;
    }

    public void setFilterLbs(Boolean filterLbs) {
        this.filterLbs = filterLbs;
    }

    public String getDeviceContact() {
        return deviceContact;
    }

    public void setDeviceContact(String deviceContact) {
        this.deviceContact = deviceContact == null ? null : deviceContact.trim();
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
        this.devicePassword = devicePassword == null ? null : devicePassword.trim();
    }

    public Byte getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(Byte deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public Byte getConnectStatus() {
        return connectStatus;
    }

    public void setConnectStatus(Byte connectStatus) {
        this.connectStatus = connectStatus;
    }

    public Byte getDeviceIcon() {
        return deviceIcon;
    }

    public void setDeviceIcon(Byte deviceIcon) {
        this.deviceIcon = deviceIcon;
    }

    public String getDeviceImei() {
        return deviceImei;
    }

    public void setDeviceImei(String deviceImei) {
        this.deviceImei = deviceImei == null ? null : deviceImei.trim();
    }

    public Byte getDeviceCategory() {
        return deviceCategory;
    }

    public void setDeviceCategory(Byte deviceCategory) {
        this.deviceCategory = deviceCategory;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public String getDeviceNote() {
        return deviceNote;
    }

    public void setDeviceNote(String deviceNote) {
        this.deviceNote = deviceNote == null ? null : deviceNote.trim();
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}