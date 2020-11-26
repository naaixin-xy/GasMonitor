package twm.mybatisdemo.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeviceAlarmExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeviceAlarmExample() {
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

        public Criteria andAlarmIdIsNull() {
            addCriterion("alarm_id is null");
            return (Criteria) this;
        }

        public Criteria andAlarmIdIsNotNull() {
            addCriterion("alarm_id is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmIdEqualTo(Integer value) {
            addCriterion("alarm_id =", value, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdNotEqualTo(Integer value) {
            addCriterion("alarm_id <>", value, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdGreaterThan(Integer value) {
            addCriterion("alarm_id >", value, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("alarm_id >=", value, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdLessThan(Integer value) {
            addCriterion("alarm_id <", value, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdLessThanOrEqualTo(Integer value) {
            addCriterion("alarm_id <=", value, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdIn(List<Integer> values) {
            addCriterion("alarm_id in", values, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdNotIn(List<Integer> values) {
            addCriterion("alarm_id not in", values, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdBetween(Integer value1, Integer value2) {
            addCriterion("alarm_id between", value1, value2, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdNotBetween(Integer value1, Integer value2) {
            addCriterion("alarm_id not between", value1, value2, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmCategoryIsNull() {
            addCriterion("alarm_category is null");
            return (Criteria) this;
        }

        public Criteria andAlarmCategoryIsNotNull() {
            addCriterion("alarm_category is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmCategoryEqualTo(Byte value) {
            addCriterion("alarm_category =", value, "alarmCategory");
            return (Criteria) this;
        }

        public Criteria andAlarmCategoryNotEqualTo(Byte value) {
            addCriterion("alarm_category <>", value, "alarmCategory");
            return (Criteria) this;
        }

        public Criteria andAlarmCategoryGreaterThan(Byte value) {
            addCriterion("alarm_category >", value, "alarmCategory");
            return (Criteria) this;
        }

        public Criteria andAlarmCategoryGreaterThanOrEqualTo(Byte value) {
            addCriterion("alarm_category >=", value, "alarmCategory");
            return (Criteria) this;
        }

        public Criteria andAlarmCategoryLessThan(Byte value) {
            addCriterion("alarm_category <", value, "alarmCategory");
            return (Criteria) this;
        }

        public Criteria andAlarmCategoryLessThanOrEqualTo(Byte value) {
            addCriterion("alarm_category <=", value, "alarmCategory");
            return (Criteria) this;
        }

        public Criteria andAlarmCategoryIn(List<Byte> values) {
            addCriterion("alarm_category in", values, "alarmCategory");
            return (Criteria) this;
        }

        public Criteria andAlarmCategoryNotIn(List<Byte> values) {
            addCriterion("alarm_category not in", values, "alarmCategory");
            return (Criteria) this;
        }

        public Criteria andAlarmCategoryBetween(Byte value1, Byte value2) {
            addCriterion("alarm_category between", value1, value2, "alarmCategory");
            return (Criteria) this;
        }

        public Criteria andAlarmCategoryNotBetween(Byte value1, Byte value2) {
            addCriterion("alarm_category not between", value1, value2, "alarmCategory");
            return (Criteria) this;
        }

        public Criteria andAlarmDeviceIdIsNull() {
            addCriterion("alarm_device_id is null");
            return (Criteria) this;
        }

        public Criteria andAlarmDeviceIdIsNotNull() {
            addCriterion("alarm_device_id is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmDeviceIdEqualTo(Integer value) {
            addCriterion("alarm_device_id =", value, "alarmDeviceId");
            return (Criteria) this;
        }

        public Criteria andAlarmDeviceIdNotEqualTo(Integer value) {
            addCriterion("alarm_device_id <>", value, "alarmDeviceId");
            return (Criteria) this;
        }

        public Criteria andAlarmDeviceIdGreaterThan(Integer value) {
            addCriterion("alarm_device_id >", value, "alarmDeviceId");
            return (Criteria) this;
        }

        public Criteria andAlarmDeviceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("alarm_device_id >=", value, "alarmDeviceId");
            return (Criteria) this;
        }

        public Criteria andAlarmDeviceIdLessThan(Integer value) {
            addCriterion("alarm_device_id <", value, "alarmDeviceId");
            return (Criteria) this;
        }

        public Criteria andAlarmDeviceIdLessThanOrEqualTo(Integer value) {
            addCriterion("alarm_device_id <=", value, "alarmDeviceId");
            return (Criteria) this;
        }

        public Criteria andAlarmDeviceIdIn(List<Integer> values) {
            addCriterion("alarm_device_id in", values, "alarmDeviceId");
            return (Criteria) this;
        }

        public Criteria andAlarmDeviceIdNotIn(List<Integer> values) {
            addCriterion("alarm_device_id not in", values, "alarmDeviceId");
            return (Criteria) this;
        }

        public Criteria andAlarmDeviceIdBetween(Integer value1, Integer value2) {
            addCriterion("alarm_device_id between", value1, value2, "alarmDeviceId");
            return (Criteria) this;
        }

        public Criteria andAlarmDeviceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("alarm_device_id not between", value1, value2, "alarmDeviceId");
            return (Criteria) this;
        }

        public Criteria andAlarmLongitudeIsNull() {
            addCriterion("alarm_longitude is null");
            return (Criteria) this;
        }

        public Criteria andAlarmLongitudeIsNotNull() {
            addCriterion("alarm_longitude is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmLongitudeEqualTo(Float value) {
            addCriterion("alarm_longitude =", value, "alarmLongitude");
            return (Criteria) this;
        }

        public Criteria andAlarmLongitudeNotEqualTo(Float value) {
            addCriterion("alarm_longitude <>", value, "alarmLongitude");
            return (Criteria) this;
        }

        public Criteria andAlarmLongitudeGreaterThan(Float value) {
            addCriterion("alarm_longitude >", value, "alarmLongitude");
            return (Criteria) this;
        }

        public Criteria andAlarmLongitudeGreaterThanOrEqualTo(Float value) {
            addCriterion("alarm_longitude >=", value, "alarmLongitude");
            return (Criteria) this;
        }

        public Criteria andAlarmLongitudeLessThan(Float value) {
            addCriterion("alarm_longitude <", value, "alarmLongitude");
            return (Criteria) this;
        }

        public Criteria andAlarmLongitudeLessThanOrEqualTo(Float value) {
            addCriterion("alarm_longitude <=", value, "alarmLongitude");
            return (Criteria) this;
        }

        public Criteria andAlarmLongitudeIn(List<Float> values) {
            addCriterion("alarm_longitude in", values, "alarmLongitude");
            return (Criteria) this;
        }

        public Criteria andAlarmLongitudeNotIn(List<Float> values) {
            addCriterion("alarm_longitude not in", values, "alarmLongitude");
            return (Criteria) this;
        }

        public Criteria andAlarmLongitudeBetween(Float value1, Float value2) {
            addCriterion("alarm_longitude between", value1, value2, "alarmLongitude");
            return (Criteria) this;
        }

        public Criteria andAlarmLongitudeNotBetween(Float value1, Float value2) {
            addCriterion("alarm_longitude not between", value1, value2, "alarmLongitude");
            return (Criteria) this;
        }

        public Criteria andAlarmLatitudeIsNull() {
            addCriterion("alarm_latitude is null");
            return (Criteria) this;
        }

        public Criteria andAlarmLatitudeIsNotNull() {
            addCriterion("alarm_latitude is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmLatitudeEqualTo(Float value) {
            addCriterion("alarm_latitude =", value, "alarmLatitude");
            return (Criteria) this;
        }

        public Criteria andAlarmLatitudeNotEqualTo(Float value) {
            addCriterion("alarm_latitude <>", value, "alarmLatitude");
            return (Criteria) this;
        }

        public Criteria andAlarmLatitudeGreaterThan(Float value) {
            addCriterion("alarm_latitude >", value, "alarmLatitude");
            return (Criteria) this;
        }

        public Criteria andAlarmLatitudeGreaterThanOrEqualTo(Float value) {
            addCriterion("alarm_latitude >=", value, "alarmLatitude");
            return (Criteria) this;
        }

        public Criteria andAlarmLatitudeLessThan(Float value) {
            addCriterion("alarm_latitude <", value, "alarmLatitude");
            return (Criteria) this;
        }

        public Criteria andAlarmLatitudeLessThanOrEqualTo(Float value) {
            addCriterion("alarm_latitude <=", value, "alarmLatitude");
            return (Criteria) this;
        }

        public Criteria andAlarmLatitudeIn(List<Float> values) {
            addCriterion("alarm_latitude in", values, "alarmLatitude");
            return (Criteria) this;
        }

        public Criteria andAlarmLatitudeNotIn(List<Float> values) {
            addCriterion("alarm_latitude not in", values, "alarmLatitude");
            return (Criteria) this;
        }

        public Criteria andAlarmLatitudeBetween(Float value1, Float value2) {
            addCriterion("alarm_latitude between", value1, value2, "alarmLatitude");
            return (Criteria) this;
        }

        public Criteria andAlarmLatitudeNotBetween(Float value1, Float value2) {
            addCriterion("alarm_latitude not between", value1, value2, "alarmLatitude");
            return (Criteria) this;
        }

        public Criteria andPositionTimeIsNull() {
            addCriterion("position_time is null");
            return (Criteria) this;
        }

        public Criteria andPositionTimeIsNotNull() {
            addCriterion("position_time is not null");
            return (Criteria) this;
        }

        public Criteria andPositionTimeEqualTo(Date value) {
            addCriterion("position_time =", value, "positionTime");
            return (Criteria) this;
        }

        public Criteria andPositionTimeNotEqualTo(Date value) {
            addCriterion("position_time <>", value, "positionTime");
            return (Criteria) this;
        }

        public Criteria andPositionTimeGreaterThan(Date value) {
            addCriterion("position_time >", value, "positionTime");
            return (Criteria) this;
        }

        public Criteria andPositionTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("position_time >=", value, "positionTime");
            return (Criteria) this;
        }

        public Criteria andPositionTimeLessThan(Date value) {
            addCriterion("position_time <", value, "positionTime");
            return (Criteria) this;
        }

        public Criteria andPositionTimeLessThanOrEqualTo(Date value) {
            addCriterion("position_time <=", value, "positionTime");
            return (Criteria) this;
        }

        public Criteria andPositionTimeIn(List<Date> values) {
            addCriterion("position_time in", values, "positionTime");
            return (Criteria) this;
        }

        public Criteria andPositionTimeNotIn(List<Date> values) {
            addCriterion("position_time not in", values, "positionTime");
            return (Criteria) this;
        }

        public Criteria andPositionTimeBetween(Date value1, Date value2) {
            addCriterion("position_time between", value1, value2, "positionTime");
            return (Criteria) this;
        }

        public Criteria andPositionTimeNotBetween(Date value1, Date value2) {
            addCriterion("position_time not between", value1, value2, "positionTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeIsNull() {
            addCriterion("alarm_time is null");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeIsNotNull() {
            addCriterion("alarm_time is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeEqualTo(Date value) {
            addCriterion("alarm_time =", value, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeNotEqualTo(Date value) {
            addCriterion("alarm_time <>", value, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeGreaterThan(Date value) {
            addCriterion("alarm_time >", value, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("alarm_time >=", value, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeLessThan(Date value) {
            addCriterion("alarm_time <", value, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeLessThanOrEqualTo(Date value) {
            addCriterion("alarm_time <=", value, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeIn(List<Date> values) {
            addCriterion("alarm_time in", values, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeNotIn(List<Date> values) {
            addCriterion("alarm_time not in", values, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeBetween(Date value1, Date value2) {
            addCriterion("alarm_time between", value1, value2, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeNotBetween(Date value1, Date value2) {
            addCriterion("alarm_time not between", value1, value2, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmNoteIsNull() {
            addCriterion("alarm_note is null");
            return (Criteria) this;
        }

        public Criteria andAlarmNoteIsNotNull() {
            addCriterion("alarm_note is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmNoteEqualTo(String value) {
            addCriterion("alarm_note =", value, "alarmNote");
            return (Criteria) this;
        }

        public Criteria andAlarmNoteNotEqualTo(String value) {
            addCriterion("alarm_note <>", value, "alarmNote");
            return (Criteria) this;
        }

        public Criteria andAlarmNoteGreaterThan(String value) {
            addCriterion("alarm_note >", value, "alarmNote");
            return (Criteria) this;
        }

        public Criteria andAlarmNoteGreaterThanOrEqualTo(String value) {
            addCriterion("alarm_note >=", value, "alarmNote");
            return (Criteria) this;
        }

        public Criteria andAlarmNoteLessThan(String value) {
            addCriterion("alarm_note <", value, "alarmNote");
            return (Criteria) this;
        }

        public Criteria andAlarmNoteLessThanOrEqualTo(String value) {
            addCriterion("alarm_note <=", value, "alarmNote");
            return (Criteria) this;
        }

        public Criteria andAlarmNoteLike(String value) {
            addCriterion("alarm_note like", value, "alarmNote");
            return (Criteria) this;
        }

        public Criteria andAlarmNoteNotLike(String value) {
            addCriterion("alarm_note not like", value, "alarmNote");
            return (Criteria) this;
        }

        public Criteria andAlarmNoteIn(List<String> values) {
            addCriterion("alarm_note in", values, "alarmNote");
            return (Criteria) this;
        }

        public Criteria andAlarmNoteNotIn(List<String> values) {
            addCriterion("alarm_note not in", values, "alarmNote");
            return (Criteria) this;
        }

        public Criteria andAlarmNoteBetween(String value1, String value2) {
            addCriterion("alarm_note between", value1, value2, "alarmNote");
            return (Criteria) this;
        }

        public Criteria andAlarmNoteNotBetween(String value1, String value2) {
            addCriterion("alarm_note not between", value1, value2, "alarmNote");
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