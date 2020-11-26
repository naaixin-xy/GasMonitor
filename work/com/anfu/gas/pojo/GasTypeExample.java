package com.anfu.gas.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GasTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GasTypeExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andCommunicationModeIsNull() {
            addCriterion("communication_mode is null");
            return (Criteria) this;
        }

        public Criteria andCommunicationModeIsNotNull() {
            addCriterion("communication_mode is not null");
            return (Criteria) this;
        }

        public Criteria andCommunicationModeEqualTo(Integer value) {
            addCriterion("communication_mode =", value, "communicationMode");
            return (Criteria) this;
        }

        public Criteria andCommunicationModeNotEqualTo(Integer value) {
            addCriterion("communication_mode <>", value, "communicationMode");
            return (Criteria) this;
        }

        public Criteria andCommunicationModeGreaterThan(Integer value) {
            addCriterion("communication_mode >", value, "communicationMode");
            return (Criteria) this;
        }

        public Criteria andCommunicationModeGreaterThanOrEqualTo(Integer value) {
            addCriterion("communication_mode >=", value, "communicationMode");
            return (Criteria) this;
        }

        public Criteria andCommunicationModeLessThan(Integer value) {
            addCriterion("communication_mode <", value, "communicationMode");
            return (Criteria) this;
        }

        public Criteria andCommunicationModeLessThanOrEqualTo(Integer value) {
            addCriterion("communication_mode <=", value, "communicationMode");
            return (Criteria) this;
        }

        public Criteria andCommunicationModeIn(List<Integer> values) {
            addCriterion("communication_mode in", values, "communicationMode");
            return (Criteria) this;
        }

        public Criteria andCommunicationModeNotIn(List<Integer> values) {
            addCriterion("communication_mode not in", values, "communicationMode");
            return (Criteria) this;
        }

        public Criteria andCommunicationModeBetween(Integer value1, Integer value2) {
            addCriterion("communication_mode between", value1, value2, "communicationMode");
            return (Criteria) this;
        }

        public Criteria andCommunicationModeNotBetween(Integer value1, Integer value2) {
            addCriterion("communication_mode not between", value1, value2, "communicationMode");
            return (Criteria) this;
        }

        public Criteria andGasTypeIsNull() {
            addCriterion("gas_type is null");
            return (Criteria) this;
        }

        public Criteria andGasTypeIsNotNull() {
            addCriterion("gas_type is not null");
            return (Criteria) this;
        }

        public Criteria andGasTypeEqualTo(Integer value) {
            addCriterion("gas_type =", value, "gasType");
            return (Criteria) this;
        }

        public Criteria andGasTypeNotEqualTo(Integer value) {
            addCriterion("gas_type <>", value, "gasType");
            return (Criteria) this;
        }

        public Criteria andGasTypeGreaterThan(Integer value) {
            addCriterion("gas_type >", value, "gasType");
            return (Criteria) this;
        }

        public Criteria andGasTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("gas_type >=", value, "gasType");
            return (Criteria) this;
        }

        public Criteria andGasTypeLessThan(Integer value) {
            addCriterion("gas_type <", value, "gasType");
            return (Criteria) this;
        }

        public Criteria andGasTypeLessThanOrEqualTo(Integer value) {
            addCriterion("gas_type <=", value, "gasType");
            return (Criteria) this;
        }

        public Criteria andGasTypeIn(List<Integer> values) {
            addCriterion("gas_type in", values, "gasType");
            return (Criteria) this;
        }

        public Criteria andGasTypeNotIn(List<Integer> values) {
            addCriterion("gas_type not in", values, "gasType");
            return (Criteria) this;
        }

        public Criteria andGasTypeBetween(Integer value1, Integer value2) {
            addCriterion("gas_type between", value1, value2, "gasType");
            return (Criteria) this;
        }

        public Criteria andGasTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("gas_type not between", value1, value2, "gasType");
            return (Criteria) this;
        }

        public Criteria andMeasureUnitIsNull() {
            addCriterion("measure_unit is null");
            return (Criteria) this;
        }

        public Criteria andMeasureUnitIsNotNull() {
            addCriterion("measure_unit is not null");
            return (Criteria) this;
        }

        public Criteria andMeasureUnitEqualTo(String value) {
            addCriterion("measure_unit =", value, "measureUnit");
            return (Criteria) this;
        }

        public Criteria andMeasureUnitNotEqualTo(String value) {
            addCriterion("measure_unit <>", value, "measureUnit");
            return (Criteria) this;
        }

        public Criteria andMeasureUnitGreaterThan(String value) {
            addCriterion("measure_unit >", value, "measureUnit");
            return (Criteria) this;
        }

        public Criteria andMeasureUnitGreaterThanOrEqualTo(String value) {
            addCriterion("measure_unit >=", value, "measureUnit");
            return (Criteria) this;
        }

        public Criteria andMeasureUnitLessThan(String value) {
            addCriterion("measure_unit <", value, "measureUnit");
            return (Criteria) this;
        }

        public Criteria andMeasureUnitLessThanOrEqualTo(String value) {
            addCriterion("measure_unit <=", value, "measureUnit");
            return (Criteria) this;
        }

        public Criteria andMeasureUnitLike(String value) {
            addCriterion("measure_unit like", value, "measureUnit");
            return (Criteria) this;
        }

        public Criteria andMeasureUnitNotLike(String value) {
            addCriterion("measure_unit not like", value, "measureUnit");
            return (Criteria) this;
        }

        public Criteria andMeasureUnitIn(List<String> values) {
            addCriterion("measure_unit in", values, "measureUnit");
            return (Criteria) this;
        }

        public Criteria andMeasureUnitNotIn(List<String> values) {
            addCriterion("measure_unit not in", values, "measureUnit");
            return (Criteria) this;
        }

        public Criteria andMeasureUnitBetween(String value1, String value2) {
            addCriterion("measure_unit between", value1, value2, "measureUnit");
            return (Criteria) this;
        }

        public Criteria andMeasureUnitNotBetween(String value1, String value2) {
            addCriterion("measure_unit not between", value1, value2, "measureUnit");
            return (Criteria) this;
        }

        public Criteria andMeasureRangeIsNull() {
            addCriterion("measure_range is null");
            return (Criteria) this;
        }

        public Criteria andMeasureRangeIsNotNull() {
            addCriterion("measure_range is not null");
            return (Criteria) this;
        }

        public Criteria andMeasureRangeEqualTo(Integer value) {
            addCriterion("measure_range =", value, "measureRange");
            return (Criteria) this;
        }

        public Criteria andMeasureRangeNotEqualTo(Integer value) {
            addCriterion("measure_range <>", value, "measureRange");
            return (Criteria) this;
        }

        public Criteria andMeasureRangeGreaterThan(Integer value) {
            addCriterion("measure_range >", value, "measureRange");
            return (Criteria) this;
        }

        public Criteria andMeasureRangeGreaterThanOrEqualTo(Integer value) {
            addCriterion("measure_range >=", value, "measureRange");
            return (Criteria) this;
        }

        public Criteria andMeasureRangeLessThan(Integer value) {
            addCriterion("measure_range <", value, "measureRange");
            return (Criteria) this;
        }

        public Criteria andMeasureRangeLessThanOrEqualTo(Integer value) {
            addCriterion("measure_range <=", value, "measureRange");
            return (Criteria) this;
        }

        public Criteria andMeasureRangeIn(List<Integer> values) {
            addCriterion("measure_range in", values, "measureRange");
            return (Criteria) this;
        }

        public Criteria andMeasureRangeNotIn(List<Integer> values) {
            addCriterion("measure_range not in", values, "measureRange");
            return (Criteria) this;
        }

        public Criteria andMeasureRangeBetween(Integer value1, Integer value2) {
            addCriterion("measure_range between", value1, value2, "measureRange");
            return (Criteria) this;
        }

        public Criteria andMeasureRangeNotBetween(Integer value1, Integer value2) {
            addCriterion("measure_range not between", value1, value2, "measureRange");
            return (Criteria) this;
        }

        public Criteria andResolutionRatioIsNull() {
            addCriterion("resolution_ratio is null");
            return (Criteria) this;
        }

        public Criteria andResolutionRatioIsNotNull() {
            addCriterion("resolution_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andResolutionRatioEqualTo(Integer value) {
            addCriterion("resolution_ratio =", value, "resolutionRatio");
            return (Criteria) this;
        }

        public Criteria andResolutionRatioNotEqualTo(Integer value) {
            addCriterion("resolution_ratio <>", value, "resolutionRatio");
            return (Criteria) this;
        }

        public Criteria andResolutionRatioGreaterThan(Integer value) {
            addCriterion("resolution_ratio >", value, "resolutionRatio");
            return (Criteria) this;
        }

        public Criteria andResolutionRatioGreaterThanOrEqualTo(Integer value) {
            addCriterion("resolution_ratio >=", value, "resolutionRatio");
            return (Criteria) this;
        }

        public Criteria andResolutionRatioLessThan(Integer value) {
            addCriterion("resolution_ratio <", value, "resolutionRatio");
            return (Criteria) this;
        }

        public Criteria andResolutionRatioLessThanOrEqualTo(Integer value) {
            addCriterion("resolution_ratio <=", value, "resolutionRatio");
            return (Criteria) this;
        }

        public Criteria andResolutionRatioIn(List<Integer> values) {
            addCriterion("resolution_ratio in", values, "resolutionRatio");
            return (Criteria) this;
        }

        public Criteria andResolutionRatioNotIn(List<Integer> values) {
            addCriterion("resolution_ratio not in", values, "resolutionRatio");
            return (Criteria) this;
        }

        public Criteria andResolutionRatioBetween(Integer value1, Integer value2) {
            addCriterion("resolution_ratio between", value1, value2, "resolutionRatio");
            return (Criteria) this;
        }

        public Criteria andResolutionRatioNotBetween(Integer value1, Integer value2) {
            addCriterion("resolution_ratio not between", value1, value2, "resolutionRatio");
            return (Criteria) this;
        }

        public Criteria andLowAlarmIsNull() {
            addCriterion("low_alarm is null");
            return (Criteria) this;
        }

        public Criteria andLowAlarmIsNotNull() {
            addCriterion("low_alarm is not null");
            return (Criteria) this;
        }

        public Criteria andLowAlarmEqualTo(Integer value) {
            addCriterion("low_alarm =", value, "lowAlarm");
            return (Criteria) this;
        }

        public Criteria andLowAlarmNotEqualTo(Integer value) {
            addCriterion("low_alarm <>", value, "lowAlarm");
            return (Criteria) this;
        }

        public Criteria andLowAlarmGreaterThan(Integer value) {
            addCriterion("low_alarm >", value, "lowAlarm");
            return (Criteria) this;
        }

        public Criteria andLowAlarmGreaterThanOrEqualTo(Integer value) {
            addCriterion("low_alarm >=", value, "lowAlarm");
            return (Criteria) this;
        }

        public Criteria andLowAlarmLessThan(Integer value) {
            addCriterion("low_alarm <", value, "lowAlarm");
            return (Criteria) this;
        }

        public Criteria andLowAlarmLessThanOrEqualTo(Integer value) {
            addCriterion("low_alarm <=", value, "lowAlarm");
            return (Criteria) this;
        }

        public Criteria andLowAlarmIn(List<Integer> values) {
            addCriterion("low_alarm in", values, "lowAlarm");
            return (Criteria) this;
        }

        public Criteria andLowAlarmNotIn(List<Integer> values) {
            addCriterion("low_alarm not in", values, "lowAlarm");
            return (Criteria) this;
        }

        public Criteria andLowAlarmBetween(Integer value1, Integer value2) {
            addCriterion("low_alarm between", value1, value2, "lowAlarm");
            return (Criteria) this;
        }

        public Criteria andLowAlarmNotBetween(Integer value1, Integer value2) {
            addCriterion("low_alarm not between", value1, value2, "lowAlarm");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
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

        public Criteria andHighAlarmIsNull() {
            addCriterion("high_alarm is null");
            return (Criteria) this;
        }

        public Criteria andHighAlarmIsNotNull() {
            addCriterion("high_alarm is not null");
            return (Criteria) this;
        }

        public Criteria andHighAlarmEqualTo(Integer value) {
            addCriterion("high_alarm =", value, "highAlarm");
            return (Criteria) this;
        }

        public Criteria andHighAlarmNotEqualTo(Integer value) {
            addCriterion("high_alarm <>", value, "highAlarm");
            return (Criteria) this;
        }

        public Criteria andHighAlarmGreaterThan(Integer value) {
            addCriterion("high_alarm >", value, "highAlarm");
            return (Criteria) this;
        }

        public Criteria andHighAlarmGreaterThanOrEqualTo(Integer value) {
            addCriterion("high_alarm >=", value, "highAlarm");
            return (Criteria) this;
        }

        public Criteria andHighAlarmLessThan(Integer value) {
            addCriterion("high_alarm <", value, "highAlarm");
            return (Criteria) this;
        }

        public Criteria andHighAlarmLessThanOrEqualTo(Integer value) {
            addCriterion("high_alarm <=", value, "highAlarm");
            return (Criteria) this;
        }

        public Criteria andHighAlarmIn(List<Integer> values) {
            addCriterion("high_alarm in", values, "highAlarm");
            return (Criteria) this;
        }

        public Criteria andHighAlarmNotIn(List<Integer> values) {
            addCriterion("high_alarm not in", values, "highAlarm");
            return (Criteria) this;
        }

        public Criteria andHighAlarmBetween(Integer value1, Integer value2) {
            addCriterion("high_alarm between", value1, value2, "highAlarm");
            return (Criteria) this;
        }

        public Criteria andHighAlarmNotBetween(Integer value1, Integer value2) {
            addCriterion("high_alarm not between", value1, value2, "highAlarm");
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