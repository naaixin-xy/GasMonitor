package twm.mybatisdemo.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AllDeviceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AllDeviceExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andDeviceIdIsNull() {
            addCriterion("device_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNotNull() {
            addCriterion("device_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdEqualTo(Integer value) {
            addCriterion("device_id =", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotEqualTo(Integer value) {
            addCriterion("device_id <>", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThan(Integer value) {
            addCriterion("device_id >", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_id >=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThan(Integer value) {
            addCriterion("device_id <", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThanOrEqualTo(Integer value) {
            addCriterion("device_id <=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIn(List<Integer> values) {
            addCriterion("device_id in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotIn(List<Integer> values) {
            addCriterion("device_id not in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdBetween(Integer value1, Integer value2) {
            addCriterion("device_id between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("device_id not between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIsNull() {
            addCriterion("device_name is null");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIsNotNull() {
            addCriterion("device_name is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceNameEqualTo(String value) {
            addCriterion("device_name =", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotEqualTo(String value) {
            addCriterion("device_name <>", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameGreaterThan(String value) {
            addCriterion("device_name >", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameGreaterThanOrEqualTo(String value) {
            addCriterion("device_name >=", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLessThan(String value) {
            addCriterion("device_name <", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLessThanOrEqualTo(String value) {
            addCriterion("device_name <=", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLike(String value) {
            addCriterion("device_name like", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotLike(String value) {
            addCriterion("device_name not like", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIn(List<String> values) {
            addCriterion("device_name in", values, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotIn(List<String> values) {
            addCriterion("device_name not in", values, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameBetween(String value1, String value2) {
            addCriterion("device_name between", value1, value2, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotBetween(String value1, String value2) {
            addCriterion("device_name not between", value1, value2, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDevicePhoneIsNull() {
            addCriterion("device_phone is null");
            return (Criteria) this;
        }

        public Criteria andDevicePhoneIsNotNull() {
            addCriterion("device_phone is not null");
            return (Criteria) this;
        }

        public Criteria andDevicePhoneEqualTo(String value) {
            addCriterion("device_phone =", value, "devicePhone");
            return (Criteria) this;
        }

        public Criteria andDevicePhoneNotEqualTo(String value) {
            addCriterion("device_phone <>", value, "devicePhone");
            return (Criteria) this;
        }

        public Criteria andDevicePhoneGreaterThan(String value) {
            addCriterion("device_phone >", value, "devicePhone");
            return (Criteria) this;
        }

        public Criteria andDevicePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("device_phone >=", value, "devicePhone");
            return (Criteria) this;
        }

        public Criteria andDevicePhoneLessThan(String value) {
            addCriterion("device_phone <", value, "devicePhone");
            return (Criteria) this;
        }

        public Criteria andDevicePhoneLessThanOrEqualTo(String value) {
            addCriterion("device_phone <=", value, "devicePhone");
            return (Criteria) this;
        }

        public Criteria andDevicePhoneLike(String value) {
            addCriterion("device_phone like", value, "devicePhone");
            return (Criteria) this;
        }

        public Criteria andDevicePhoneNotLike(String value) {
            addCriterion("device_phone not like", value, "devicePhone");
            return (Criteria) this;
        }

        public Criteria andDevicePhoneIn(List<String> values) {
            addCriterion("device_phone in", values, "devicePhone");
            return (Criteria) this;
        }

        public Criteria andDevicePhoneNotIn(List<String> values) {
            addCriterion("device_phone not in", values, "devicePhone");
            return (Criteria) this;
        }

        public Criteria andDevicePhoneBetween(String value1, String value2) {
            addCriterion("device_phone between", value1, value2, "devicePhone");
            return (Criteria) this;
        }

        public Criteria andDevicePhoneNotBetween(String value1, String value2) {
            addCriterion("device_phone not between", value1, value2, "devicePhone");
            return (Criteria) this;
        }

        public Criteria andPlateNumberIsNull() {
            addCriterion("plate_number is null");
            return (Criteria) this;
        }

        public Criteria andPlateNumberIsNotNull() {
            addCriterion("plate_number is not null");
            return (Criteria) this;
        }

        public Criteria andPlateNumberEqualTo(String value) {
            addCriterion("plate_number =", value, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberNotEqualTo(String value) {
            addCriterion("plate_number <>", value, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberGreaterThan(String value) {
            addCriterion("plate_number >", value, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberGreaterThanOrEqualTo(String value) {
            addCriterion("plate_number >=", value, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberLessThan(String value) {
            addCriterion("plate_number <", value, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberLessThanOrEqualTo(String value) {
            addCriterion("plate_number <=", value, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberLike(String value) {
            addCriterion("plate_number like", value, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberNotLike(String value) {
            addCriterion("plate_number not like", value, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberIn(List<String> values) {
            addCriterion("plate_number in", values, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberNotIn(List<String> values) {
            addCriterion("plate_number not in", values, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberBetween(String value1, String value2) {
            addCriterion("plate_number between", value1, value2, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberNotBetween(String value1, String value2) {
            addCriterion("plate_number not between", value1, value2, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andSpeedLimitIsNull() {
            addCriterion("speed_limit is null");
            return (Criteria) this;
        }

        public Criteria andSpeedLimitIsNotNull() {
            addCriterion("speed_limit is not null");
            return (Criteria) this;
        }

        public Criteria andSpeedLimitEqualTo(Short value) {
            addCriterion("speed_limit =", value, "speedLimit");
            return (Criteria) this;
        }

        public Criteria andSpeedLimitNotEqualTo(Short value) {
            addCriterion("speed_limit <>", value, "speedLimit");
            return (Criteria) this;
        }

        public Criteria andSpeedLimitGreaterThan(Short value) {
            addCriterion("speed_limit >", value, "speedLimit");
            return (Criteria) this;
        }

        public Criteria andSpeedLimitGreaterThanOrEqualTo(Short value) {
            addCriterion("speed_limit >=", value, "speedLimit");
            return (Criteria) this;
        }

        public Criteria andSpeedLimitLessThan(Short value) {
            addCriterion("speed_limit <", value, "speedLimit");
            return (Criteria) this;
        }

        public Criteria andSpeedLimitLessThanOrEqualTo(Short value) {
            addCriterion("speed_limit <=", value, "speedLimit");
            return (Criteria) this;
        }

        public Criteria andSpeedLimitIn(List<Short> values) {
            addCriterion("speed_limit in", values, "speedLimit");
            return (Criteria) this;
        }

        public Criteria andSpeedLimitNotIn(List<Short> values) {
            addCriterion("speed_limit not in", values, "speedLimit");
            return (Criteria) this;
        }

        public Criteria andSpeedLimitBetween(Short value1, Short value2) {
            addCriterion("speed_limit between", value1, value2, "speedLimit");
            return (Criteria) this;
        }

        public Criteria andSpeedLimitNotBetween(Short value1, Short value2) {
            addCriterion("speed_limit not between", value1, value2, "speedLimit");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIsNull() {
            addCriterion("contact_phone is null");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIsNotNull() {
            addCriterion("contact_phone is not null");
            return (Criteria) this;
        }

        public Criteria andContactPhoneEqualTo(String value) {
            addCriterion("contact_phone =", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotEqualTo(String value) {
            addCriterion("contact_phone <>", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneGreaterThan(String value) {
            addCriterion("contact_phone >", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("contact_phone >=", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLessThan(String value) {
            addCriterion("contact_phone <", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLessThanOrEqualTo(String value) {
            addCriterion("contact_phone <=", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLike(String value) {
            addCriterion("contact_phone like", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotLike(String value) {
            addCriterion("contact_phone not like", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIn(List<String> values) {
            addCriterion("contact_phone in", values, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotIn(List<String> values) {
            addCriterion("contact_phone not in", values, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneBetween(String value1, String value2) {
            addCriterion("contact_phone between", value1, value2, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotBetween(String value1, String value2) {
            addCriterion("contact_phone not between", value1, value2, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andOilCoefficientIsNull() {
            addCriterion("oil_coefficient is null");
            return (Criteria) this;
        }

        public Criteria andOilCoefficientIsNotNull() {
            addCriterion("oil_coefficient is not null");
            return (Criteria) this;
        }

        public Criteria andOilCoefficientEqualTo(Float value) {
            addCriterion("oil_coefficient =", value, "oilCoefficient");
            return (Criteria) this;
        }

        public Criteria andOilCoefficientNotEqualTo(Float value) {
            addCriterion("oil_coefficient <>", value, "oilCoefficient");
            return (Criteria) this;
        }

        public Criteria andOilCoefficientGreaterThan(Float value) {
            addCriterion("oil_coefficient >", value, "oilCoefficient");
            return (Criteria) this;
        }

        public Criteria andOilCoefficientGreaterThanOrEqualTo(Float value) {
            addCriterion("oil_coefficient >=", value, "oilCoefficient");
            return (Criteria) this;
        }

        public Criteria andOilCoefficientLessThan(Float value) {
            addCriterion("oil_coefficient <", value, "oilCoefficient");
            return (Criteria) this;
        }

        public Criteria andOilCoefficientLessThanOrEqualTo(Float value) {
            addCriterion("oil_coefficient <=", value, "oilCoefficient");
            return (Criteria) this;
        }

        public Criteria andOilCoefficientIn(List<Float> values) {
            addCriterion("oil_coefficient in", values, "oilCoefficient");
            return (Criteria) this;
        }

        public Criteria andOilCoefficientNotIn(List<Float> values) {
            addCriterion("oil_coefficient not in", values, "oilCoefficient");
            return (Criteria) this;
        }

        public Criteria andOilCoefficientBetween(Float value1, Float value2) {
            addCriterion("oil_coefficient between", value1, value2, "oilCoefficient");
            return (Criteria) this;
        }

        public Criteria andOilCoefficientNotBetween(Float value1, Float value2) {
            addCriterion("oil_coefficient not between", value1, value2, "oilCoefficient");
            return (Criteria) this;
        }

        public Criteria andMaintainDistancePeriodIsNull() {
            addCriterion("maintain_distance_period is null");
            return (Criteria) this;
        }

        public Criteria andMaintainDistancePeriodIsNotNull() {
            addCriterion("maintain_distance_period is not null");
            return (Criteria) this;
        }

        public Criteria andMaintainDistancePeriodEqualTo(Integer value) {
            addCriterion("maintain_distance_period =", value, "maintainDistancePeriod");
            return (Criteria) this;
        }

        public Criteria andMaintainDistancePeriodNotEqualTo(Integer value) {
            addCriterion("maintain_distance_period <>", value, "maintainDistancePeriod");
            return (Criteria) this;
        }

        public Criteria andMaintainDistancePeriodGreaterThan(Integer value) {
            addCriterion("maintain_distance_period >", value, "maintainDistancePeriod");
            return (Criteria) this;
        }

        public Criteria andMaintainDistancePeriodGreaterThanOrEqualTo(Integer value) {
            addCriterion("maintain_distance_period >=", value, "maintainDistancePeriod");
            return (Criteria) this;
        }

        public Criteria andMaintainDistancePeriodLessThan(Integer value) {
            addCriterion("maintain_distance_period <", value, "maintainDistancePeriod");
            return (Criteria) this;
        }

        public Criteria andMaintainDistancePeriodLessThanOrEqualTo(Integer value) {
            addCriterion("maintain_distance_period <=", value, "maintainDistancePeriod");
            return (Criteria) this;
        }

        public Criteria andMaintainDistancePeriodIn(List<Integer> values) {
            addCriterion("maintain_distance_period in", values, "maintainDistancePeriod");
            return (Criteria) this;
        }

        public Criteria andMaintainDistancePeriodNotIn(List<Integer> values) {
            addCriterion("maintain_distance_period not in", values, "maintainDistancePeriod");
            return (Criteria) this;
        }

        public Criteria andMaintainDistancePeriodBetween(Integer value1, Integer value2) {
            addCriterion("maintain_distance_period between", value1, value2, "maintainDistancePeriod");
            return (Criteria) this;
        }

        public Criteria andMaintainDistancePeriodNotBetween(Integer value1, Integer value2) {
            addCriterion("maintain_distance_period not between", value1, value2, "maintainDistancePeriod");
            return (Criteria) this;
        }

        public Criteria andLastMaintainKilometreIsNull() {
            addCriterion("last_maintain_kilometre is null");
            return (Criteria) this;
        }

        public Criteria andLastMaintainKilometreIsNotNull() {
            addCriterion("last_maintain_kilometre is not null");
            return (Criteria) this;
        }

        public Criteria andLastMaintainKilometreEqualTo(Integer value) {
            addCriterion("last_maintain_kilometre =", value, "lastMaintainKilometre");
            return (Criteria) this;
        }

        public Criteria andLastMaintainKilometreNotEqualTo(Integer value) {
            addCriterion("last_maintain_kilometre <>", value, "lastMaintainKilometre");
            return (Criteria) this;
        }

        public Criteria andLastMaintainKilometreGreaterThan(Integer value) {
            addCriterion("last_maintain_kilometre >", value, "lastMaintainKilometre");
            return (Criteria) this;
        }

        public Criteria andLastMaintainKilometreGreaterThanOrEqualTo(Integer value) {
            addCriterion("last_maintain_kilometre >=", value, "lastMaintainKilometre");
            return (Criteria) this;
        }

        public Criteria andLastMaintainKilometreLessThan(Integer value) {
            addCriterion("last_maintain_kilometre <", value, "lastMaintainKilometre");
            return (Criteria) this;
        }

        public Criteria andLastMaintainKilometreLessThanOrEqualTo(Integer value) {
            addCriterion("last_maintain_kilometre <=", value, "lastMaintainKilometre");
            return (Criteria) this;
        }

        public Criteria andLastMaintainKilometreIn(List<Integer> values) {
            addCriterion("last_maintain_kilometre in", values, "lastMaintainKilometre");
            return (Criteria) this;
        }

        public Criteria andLastMaintainKilometreNotIn(List<Integer> values) {
            addCriterion("last_maintain_kilometre not in", values, "lastMaintainKilometre");
            return (Criteria) this;
        }

        public Criteria andLastMaintainKilometreBetween(Integer value1, Integer value2) {
            addCriterion("last_maintain_kilometre between", value1, value2, "lastMaintainKilometre");
            return (Criteria) this;
        }

        public Criteria andLastMaintainKilometreNotBetween(Integer value1, Integer value2) {
            addCriterion("last_maintain_kilometre not between", value1, value2, "lastMaintainKilometre");
            return (Criteria) this;
        }

        public Criteria andFilterLbsIsNull() {
            addCriterion("filter_lbs is null");
            return (Criteria) this;
        }

        public Criteria andFilterLbsIsNotNull() {
            addCriterion("filter_lbs is not null");
            return (Criteria) this;
        }

        public Criteria andFilterLbsEqualTo(Boolean value) {
            addCriterion("filter_lbs =", value, "filterLbs");
            return (Criteria) this;
        }

        public Criteria andFilterLbsNotEqualTo(Boolean value) {
            addCriterion("filter_lbs <>", value, "filterLbs");
            return (Criteria) this;
        }

        public Criteria andFilterLbsGreaterThan(Boolean value) {
            addCriterion("filter_lbs >", value, "filterLbs");
            return (Criteria) this;
        }

        public Criteria andFilterLbsGreaterThanOrEqualTo(Boolean value) {
            addCriterion("filter_lbs >=", value, "filterLbs");
            return (Criteria) this;
        }

        public Criteria andFilterLbsLessThan(Boolean value) {
            addCriterion("filter_lbs <", value, "filterLbs");
            return (Criteria) this;
        }

        public Criteria andFilterLbsLessThanOrEqualTo(Boolean value) {
            addCriterion("filter_lbs <=", value, "filterLbs");
            return (Criteria) this;
        }

        public Criteria andFilterLbsIn(List<Boolean> values) {
            addCriterion("filter_lbs in", values, "filterLbs");
            return (Criteria) this;
        }

        public Criteria andFilterLbsNotIn(List<Boolean> values) {
            addCriterion("filter_lbs not in", values, "filterLbs");
            return (Criteria) this;
        }

        public Criteria andFilterLbsBetween(Boolean value1, Boolean value2) {
            addCriterion("filter_lbs between", value1, value2, "filterLbs");
            return (Criteria) this;
        }

        public Criteria andFilterLbsNotBetween(Boolean value1, Boolean value2) {
            addCriterion("filter_lbs not between", value1, value2, "filterLbs");
            return (Criteria) this;
        }

        public Criteria andDeviceContactIsNull() {
            addCriterion("device_contact is null");
            return (Criteria) this;
        }

        public Criteria andDeviceContactIsNotNull() {
            addCriterion("device_contact is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceContactEqualTo(String value) {
            addCriterion("device_contact =", value, "deviceContact");
            return (Criteria) this;
        }

        public Criteria andDeviceContactNotEqualTo(String value) {
            addCriterion("device_contact <>", value, "deviceContact");
            return (Criteria) this;
        }

        public Criteria andDeviceContactGreaterThan(String value) {
            addCriterion("device_contact >", value, "deviceContact");
            return (Criteria) this;
        }

        public Criteria andDeviceContactGreaterThanOrEqualTo(String value) {
            addCriterion("device_contact >=", value, "deviceContact");
            return (Criteria) this;
        }

        public Criteria andDeviceContactLessThan(String value) {
            addCriterion("device_contact <", value, "deviceContact");
            return (Criteria) this;
        }

        public Criteria andDeviceContactLessThanOrEqualTo(String value) {
            addCriterion("device_contact <=", value, "deviceContact");
            return (Criteria) this;
        }

        public Criteria andDeviceContactLike(String value) {
            addCriterion("device_contact like", value, "deviceContact");
            return (Criteria) this;
        }

        public Criteria andDeviceContactNotLike(String value) {
            addCriterion("device_contact not like", value, "deviceContact");
            return (Criteria) this;
        }

        public Criteria andDeviceContactIn(List<String> values) {
            addCriterion("device_contact in", values, "deviceContact");
            return (Criteria) this;
        }

        public Criteria andDeviceContactNotIn(List<String> values) {
            addCriterion("device_contact not in", values, "deviceContact");
            return (Criteria) this;
        }

        public Criteria andDeviceContactBetween(String value1, String value2) {
            addCriterion("device_contact between", value1, value2, "deviceContact");
            return (Criteria) this;
        }

        public Criteria andDeviceContactNotBetween(String value1, String value2) {
            addCriterion("device_contact not between", value1, value2, "deviceContact");
            return (Criteria) this;
        }

        public Criteria andDeviceUserIdIsNull() {
            addCriterion("device_user_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceUserIdIsNotNull() {
            addCriterion("device_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceUserIdEqualTo(Integer value) {
            addCriterion("device_user_id =", value, "deviceUserId");
            return (Criteria) this;
        }

        public Criteria andDeviceUserIdNotEqualTo(Integer value) {
            addCriterion("device_user_id <>", value, "deviceUserId");
            return (Criteria) this;
        }

        public Criteria andDeviceUserIdGreaterThan(Integer value) {
            addCriterion("device_user_id >", value, "deviceUserId");
            return (Criteria) this;
        }

        public Criteria andDeviceUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_user_id >=", value, "deviceUserId");
            return (Criteria) this;
        }

        public Criteria andDeviceUserIdLessThan(Integer value) {
            addCriterion("device_user_id <", value, "deviceUserId");
            return (Criteria) this;
        }

        public Criteria andDeviceUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("device_user_id <=", value, "deviceUserId");
            return (Criteria) this;
        }

        public Criteria andDeviceUserIdIn(List<Integer> values) {
            addCriterion("device_user_id in", values, "deviceUserId");
            return (Criteria) this;
        }

        public Criteria andDeviceUserIdNotIn(List<Integer> values) {
            addCriterion("device_user_id not in", values, "deviceUserId");
            return (Criteria) this;
        }

        public Criteria andDeviceUserIdBetween(Integer value1, Integer value2) {
            addCriterion("device_user_id between", value1, value2, "deviceUserId");
            return (Criteria) this;
        }

        public Criteria andDeviceUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("device_user_id not between", value1, value2, "deviceUserId");
            return (Criteria) this;
        }

        public Criteria andDevicePasswordIsNull() {
            addCriterion("device_password is null");
            return (Criteria) this;
        }

        public Criteria andDevicePasswordIsNotNull() {
            addCriterion("device_password is not null");
            return (Criteria) this;
        }

        public Criteria andDevicePasswordEqualTo(String value) {
            addCriterion("device_password =", value, "devicePassword");
            return (Criteria) this;
        }

        public Criteria andDevicePasswordNotEqualTo(String value) {
            addCriterion("device_password <>", value, "devicePassword");
            return (Criteria) this;
        }

        public Criteria andDevicePasswordGreaterThan(String value) {
            addCriterion("device_password >", value, "devicePassword");
            return (Criteria) this;
        }

        public Criteria andDevicePasswordGreaterThanOrEqualTo(String value) {
            addCriterion("device_password >=", value, "devicePassword");
            return (Criteria) this;
        }

        public Criteria andDevicePasswordLessThan(String value) {
            addCriterion("device_password <", value, "devicePassword");
            return (Criteria) this;
        }

        public Criteria andDevicePasswordLessThanOrEqualTo(String value) {
            addCriterion("device_password <=", value, "devicePassword");
            return (Criteria) this;
        }

        public Criteria andDevicePasswordLike(String value) {
            addCriterion("device_password like", value, "devicePassword");
            return (Criteria) this;
        }

        public Criteria andDevicePasswordNotLike(String value) {
            addCriterion("device_password not like", value, "devicePassword");
            return (Criteria) this;
        }

        public Criteria andDevicePasswordIn(List<String> values) {
            addCriterion("device_password in", values, "devicePassword");
            return (Criteria) this;
        }

        public Criteria andDevicePasswordNotIn(List<String> values) {
            addCriterion("device_password not in", values, "devicePassword");
            return (Criteria) this;
        }

        public Criteria andDevicePasswordBetween(String value1, String value2) {
            addCriterion("device_password between", value1, value2, "devicePassword");
            return (Criteria) this;
        }

        public Criteria andDevicePasswordNotBetween(String value1, String value2) {
            addCriterion("device_password not between", value1, value2, "devicePassword");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusIsNull() {
            addCriterion("device_status is null");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusIsNotNull() {
            addCriterion("device_status is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusEqualTo(Byte value) {
            addCriterion("device_status =", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusNotEqualTo(Byte value) {
            addCriterion("device_status <>", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusGreaterThan(Byte value) {
            addCriterion("device_status >", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("device_status >=", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusLessThan(Byte value) {
            addCriterion("device_status <", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusLessThanOrEqualTo(Byte value) {
            addCriterion("device_status <=", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusIn(List<Byte> values) {
            addCriterion("device_status in", values, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusNotIn(List<Byte> values) {
            addCriterion("device_status not in", values, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusBetween(Byte value1, Byte value2) {
            addCriterion("device_status between", value1, value2, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("device_status not between", value1, value2, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andConnectStatusIsNull() {
            addCriterion("connect_status is null");
            return (Criteria) this;
        }

        public Criteria andConnectStatusIsNotNull() {
            addCriterion("connect_status is not null");
            return (Criteria) this;
        }

        public Criteria andConnectStatusEqualTo(Byte value) {
            addCriterion("connect_status =", value, "connectStatus");
            return (Criteria) this;
        }

        public Criteria andConnectStatusNotEqualTo(Byte value) {
            addCriterion("connect_status <>", value, "connectStatus");
            return (Criteria) this;
        }

        public Criteria andConnectStatusGreaterThan(Byte value) {
            addCriterion("connect_status >", value, "connectStatus");
            return (Criteria) this;
        }

        public Criteria andConnectStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("connect_status >=", value, "connectStatus");
            return (Criteria) this;
        }

        public Criteria andConnectStatusLessThan(Byte value) {
            addCriterion("connect_status <", value, "connectStatus");
            return (Criteria) this;
        }

        public Criteria andConnectStatusLessThanOrEqualTo(Byte value) {
            addCriterion("connect_status <=", value, "connectStatus");
            return (Criteria) this;
        }

        public Criteria andConnectStatusIn(List<Byte> values) {
            addCriterion("connect_status in", values, "connectStatus");
            return (Criteria) this;
        }

        public Criteria andConnectStatusNotIn(List<Byte> values) {
            addCriterion("connect_status not in", values, "connectStatus");
            return (Criteria) this;
        }

        public Criteria andConnectStatusBetween(Byte value1, Byte value2) {
            addCriterion("connect_status between", value1, value2, "connectStatus");
            return (Criteria) this;
        }

        public Criteria andConnectStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("connect_status not between", value1, value2, "connectStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceIconIsNull() {
            addCriterion("device_icon is null");
            return (Criteria) this;
        }

        public Criteria andDeviceIconIsNotNull() {
            addCriterion("device_icon is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceIconEqualTo(Byte value) {
            addCriterion("device_icon =", value, "deviceIcon");
            return (Criteria) this;
        }

        public Criteria andDeviceIconNotEqualTo(Byte value) {
            addCriterion("device_icon <>", value, "deviceIcon");
            return (Criteria) this;
        }

        public Criteria andDeviceIconGreaterThan(Byte value) {
            addCriterion("device_icon >", value, "deviceIcon");
            return (Criteria) this;
        }

        public Criteria andDeviceIconGreaterThanOrEqualTo(Byte value) {
            addCriterion("device_icon >=", value, "deviceIcon");
            return (Criteria) this;
        }

        public Criteria andDeviceIconLessThan(Byte value) {
            addCriterion("device_icon <", value, "deviceIcon");
            return (Criteria) this;
        }

        public Criteria andDeviceIconLessThanOrEqualTo(Byte value) {
            addCriterion("device_icon <=", value, "deviceIcon");
            return (Criteria) this;
        }

        public Criteria andDeviceIconIn(List<Byte> values) {
            addCriterion("device_icon in", values, "deviceIcon");
            return (Criteria) this;
        }

        public Criteria andDeviceIconNotIn(List<Byte> values) {
            addCriterion("device_icon not in", values, "deviceIcon");
            return (Criteria) this;
        }

        public Criteria andDeviceIconBetween(Byte value1, Byte value2) {
            addCriterion("device_icon between", value1, value2, "deviceIcon");
            return (Criteria) this;
        }

        public Criteria andDeviceIconNotBetween(Byte value1, Byte value2) {
            addCriterion("device_icon not between", value1, value2, "deviceIcon");
            return (Criteria) this;
        }

        public Criteria andDeviceImeiIsNull() {
            addCriterion("device_imei is null");
            return (Criteria) this;
        }

        public Criteria andDeviceImeiIsNotNull() {
            addCriterion("device_imei is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceImeiEqualTo(String value) {
            addCriterion("device_imei =", value, "deviceImei");
            return (Criteria) this;
        }

        public Criteria andDeviceImeiNotEqualTo(String value) {
            addCriterion("device_imei <>", value, "deviceImei");
            return (Criteria) this;
        }

        public Criteria andDeviceImeiGreaterThan(String value) {
            addCriterion("device_imei >", value, "deviceImei");
            return (Criteria) this;
        }

        public Criteria andDeviceImeiGreaterThanOrEqualTo(String value) {
            addCriterion("device_imei >=", value, "deviceImei");
            return (Criteria) this;
        }

        public Criteria andDeviceImeiLessThan(String value) {
            addCriterion("device_imei <", value, "deviceImei");
            return (Criteria) this;
        }

        public Criteria andDeviceImeiLessThanOrEqualTo(String value) {
            addCriterion("device_imei <=", value, "deviceImei");
            return (Criteria) this;
        }

        public Criteria andDeviceImeiLike(String value) {
            addCriterion("device_imei like", value, "deviceImei");
            return (Criteria) this;
        }

        public Criteria andDeviceImeiNotLike(String value) {
            addCriterion("device_imei not like", value, "deviceImei");
            return (Criteria) this;
        }

        public Criteria andDeviceImeiIn(List<String> values) {
            addCriterion("device_imei in", values, "deviceImei");
            return (Criteria) this;
        }

        public Criteria andDeviceImeiNotIn(List<String> values) {
            addCriterion("device_imei not in", values, "deviceImei");
            return (Criteria) this;
        }

        public Criteria andDeviceImeiBetween(String value1, String value2) {
            addCriterion("device_imei between", value1, value2, "deviceImei");
            return (Criteria) this;
        }

        public Criteria andDeviceImeiNotBetween(String value1, String value2) {
            addCriterion("device_imei not between", value1, value2, "deviceImei");
            return (Criteria) this;
        }

        public Criteria andDeviceCategoryIsNull() {
            addCriterion("device_category is null");
            return (Criteria) this;
        }

        public Criteria andDeviceCategoryIsNotNull() {
            addCriterion("device_category is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceCategoryEqualTo(Byte value) {
            addCriterion("device_category =", value, "deviceCategory");
            return (Criteria) this;
        }

        public Criteria andDeviceCategoryNotEqualTo(Byte value) {
            addCriterion("device_category <>", value, "deviceCategory");
            return (Criteria) this;
        }

        public Criteria andDeviceCategoryGreaterThan(Byte value) {
            addCriterion("device_category >", value, "deviceCategory");
            return (Criteria) this;
        }

        public Criteria andDeviceCategoryGreaterThanOrEqualTo(Byte value) {
            addCriterion("device_category >=", value, "deviceCategory");
            return (Criteria) this;
        }

        public Criteria andDeviceCategoryLessThan(Byte value) {
            addCriterion("device_category <", value, "deviceCategory");
            return (Criteria) this;
        }

        public Criteria andDeviceCategoryLessThanOrEqualTo(Byte value) {
            addCriterion("device_category <=", value, "deviceCategory");
            return (Criteria) this;
        }

        public Criteria andDeviceCategoryIn(List<Byte> values) {
            addCriterion("device_category in", values, "deviceCategory");
            return (Criteria) this;
        }

        public Criteria andDeviceCategoryNotIn(List<Byte> values) {
            addCriterion("device_category not in", values, "deviceCategory");
            return (Criteria) this;
        }

        public Criteria andDeviceCategoryBetween(Byte value1, Byte value2) {
            addCriterion("device_category between", value1, value2, "deviceCategory");
            return (Criteria) this;
        }

        public Criteria andDeviceCategoryNotBetween(Byte value1, Byte value2) {
            addCriterion("device_category not between", value1, value2, "deviceCategory");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeIsNull() {
            addCriterion("active_time is null");
            return (Criteria) this;
        }

        public Criteria andActiveTimeIsNotNull() {
            addCriterion("active_time is not null");
            return (Criteria) this;
        }

        public Criteria andActiveTimeEqualTo(Date value) {
            addCriterion("active_time =", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeNotEqualTo(Date value) {
            addCriterion("active_time <>", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeGreaterThan(Date value) {
            addCriterion("active_time >", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("active_time >=", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeLessThan(Date value) {
            addCriterion("active_time <", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeLessThanOrEqualTo(Date value) {
            addCriterion("active_time <=", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeIn(List<Date> values) {
            addCriterion("active_time in", values, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeNotIn(List<Date> values) {
            addCriterion("active_time not in", values, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeBetween(Date value1, Date value2) {
            addCriterion("active_time between", value1, value2, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeNotBetween(Date value1, Date value2) {
            addCriterion("active_time not between", value1, value2, "activeTime");
            return (Criteria) this;
        }

        public Criteria andDueTimeIsNull() {
            addCriterion("due_time is null");
            return (Criteria) this;
        }

        public Criteria andDueTimeIsNotNull() {
            addCriterion("due_time is not null");
            return (Criteria) this;
        }

        public Criteria andDueTimeEqualTo(Date value) {
            addCriterion("due_time =", value, "dueTime");
            return (Criteria) this;
        }

        public Criteria andDueTimeNotEqualTo(Date value) {
            addCriterion("due_time <>", value, "dueTime");
            return (Criteria) this;
        }

        public Criteria andDueTimeGreaterThan(Date value) {
            addCriterion("due_time >", value, "dueTime");
            return (Criteria) this;
        }

        public Criteria andDueTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("due_time >=", value, "dueTime");
            return (Criteria) this;
        }

        public Criteria andDueTimeLessThan(Date value) {
            addCriterion("due_time <", value, "dueTime");
            return (Criteria) this;
        }

        public Criteria andDueTimeLessThanOrEqualTo(Date value) {
            addCriterion("due_time <=", value, "dueTime");
            return (Criteria) this;
        }

        public Criteria andDueTimeIn(List<Date> values) {
            addCriterion("due_time in", values, "dueTime");
            return (Criteria) this;
        }

        public Criteria andDueTimeNotIn(List<Date> values) {
            addCriterion("due_time not in", values, "dueTime");
            return (Criteria) this;
        }

        public Criteria andDueTimeBetween(Date value1, Date value2) {
            addCriterion("due_time between", value1, value2, "dueTime");
            return (Criteria) this;
        }

        public Criteria andDueTimeNotBetween(Date value1, Date value2) {
            addCriterion("due_time not between", value1, value2, "dueTime");
            return (Criteria) this;
        }

        public Criteria andDeviceNoteIsNull() {
            addCriterion("device_note is null");
            return (Criteria) this;
        }

        public Criteria andDeviceNoteIsNotNull() {
            addCriterion("device_note is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceNoteEqualTo(String value) {
            addCriterion("device_note =", value, "deviceNote");
            return (Criteria) this;
        }

        public Criteria andDeviceNoteNotEqualTo(String value) {
            addCriterion("device_note <>", value, "deviceNote");
            return (Criteria) this;
        }

        public Criteria andDeviceNoteGreaterThan(String value) {
            addCriterion("device_note >", value, "deviceNote");
            return (Criteria) this;
        }

        public Criteria andDeviceNoteGreaterThanOrEqualTo(String value) {
            addCriterion("device_note >=", value, "deviceNote");
            return (Criteria) this;
        }

        public Criteria andDeviceNoteLessThan(String value) {
            addCriterion("device_note <", value, "deviceNote");
            return (Criteria) this;
        }

        public Criteria andDeviceNoteLessThanOrEqualTo(String value) {
            addCriterion("device_note <=", value, "deviceNote");
            return (Criteria) this;
        }

        public Criteria andDeviceNoteLike(String value) {
            addCriterion("device_note like", value, "deviceNote");
            return (Criteria) this;
        }

        public Criteria andDeviceNoteNotLike(String value) {
            addCriterion("device_note not like", value, "deviceNote");
            return (Criteria) this;
        }

        public Criteria andDeviceNoteIn(List<String> values) {
            addCriterion("device_note in", values, "deviceNote");
            return (Criteria) this;
        }

        public Criteria andDeviceNoteNotIn(List<String> values) {
            addCriterion("device_note not in", values, "deviceNote");
            return (Criteria) this;
        }

        public Criteria andDeviceNoteBetween(String value1, String value2) {
            addCriterion("device_note between", value1, value2, "deviceNote");
            return (Criteria) this;
        }

        public Criteria andDeviceNoteNotBetween(String value1, String value2) {
            addCriterion("device_note not between", value1, value2, "deviceNote");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNull() {
            addCriterion("last_update_time is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNotNull() {
            addCriterion("last_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeEqualTo(Date value) {
            addCriterion("last_update_time =", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotEqualTo(Date value) {
            addCriterion("last_update_time <>", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThan(Date value) {
            addCriterion("last_update_time >", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_update_time >=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThan(Date value) {
            addCriterion("last_update_time <", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_update_time <=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIn(List<Date> values) {
            addCriterion("last_update_time in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotIn(List<Date> values) {
            addCriterion("last_update_time not in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("last_update_time between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_update_time not between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(Double value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(Double value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(Double value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(Double value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(Double value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<Double> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<Double> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(Double value1, Double value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(Double value1, Double value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(Double value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(Double value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(Double value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(Double value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(Double value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<Double> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<Double> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(Double value1, Double value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(Double value1, Double value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}