package com.anfu.gas.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GasDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GasDataExample() {
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

        public Criteria andHostIdIsNull() {
            addCriterion("host_id is null");
            return (Criteria) this;
        }

        public Criteria andHostIdIsNotNull() {
            addCriterion("host_id is not null");
            return (Criteria) this;
        }

        public Criteria andHostIdEqualTo(Integer value) {
            addCriterion("host_id =", value, "hostId");
            return (Criteria) this;
        }

        public Criteria andHostIdNotEqualTo(Integer value) {
            addCriterion("host_id <>", value, "hostId");
            return (Criteria) this;
        }

        public Criteria andHostIdGreaterThan(Integer value) {
            addCriterion("host_id >", value, "hostId");
            return (Criteria) this;
        }

        public Criteria andHostIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("host_id >=", value, "hostId");
            return (Criteria) this;
        }

        public Criteria andHostIdLessThan(Integer value) {
            addCriterion("host_id <", value, "hostId");
            return (Criteria) this;
        }

        public Criteria andHostIdLessThanOrEqualTo(Integer value) {
            addCriterion("host_id <=", value, "hostId");
            return (Criteria) this;
        }

        public Criteria andHostIdIn(List<Integer> values) {
            addCriterion("host_id in", values, "hostId");
            return (Criteria) this;
        }

        public Criteria andHostIdNotIn(List<Integer> values) {
            addCriterion("host_id not in", values, "hostId");
            return (Criteria) this;
        }

        public Criteria andHostIdBetween(Integer value1, Integer value2) {
            addCriterion("host_id between", value1, value2, "hostId");
            return (Criteria) this;
        }

        public Criteria andHostIdNotBetween(Integer value1, Integer value2) {
            addCriterion("host_id not between", value1, value2, "hostId");
            return (Criteria) this;
        }

        public Criteria andDetectorIdIsNull() {
            addCriterion("detector_id is null");
            return (Criteria) this;
        }

        public Criteria andDetectorIdIsNotNull() {
            addCriterion("detector_id is not null");
            return (Criteria) this;
        }

        public Criteria andDetectorIdEqualTo(Integer value) {
            addCriterion("detector_id =", value, "detectorId");
            return (Criteria) this;
        }

        public Criteria andDetectorIdNotEqualTo(Integer value) {
            addCriterion("detector_id <>", value, "detectorId");
            return (Criteria) this;
        }

        public Criteria andDetectorIdGreaterThan(Integer value) {
            addCriterion("detector_id >", value, "detectorId");
            return (Criteria) this;
        }

        public Criteria andDetectorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("detector_id >=", value, "detectorId");
            return (Criteria) this;
        }

        public Criteria andDetectorIdLessThan(Integer value) {
            addCriterion("detector_id <", value, "detectorId");
            return (Criteria) this;
        }

        public Criteria andDetectorIdLessThanOrEqualTo(Integer value) {
            addCriterion("detector_id <=", value, "detectorId");
            return (Criteria) this;
        }

        public Criteria andDetectorIdIn(List<Integer> values) {
            addCriterion("detector_id in", values, "detectorId");
            return (Criteria) this;
        }

        public Criteria andDetectorIdNotIn(List<Integer> values) {
            addCriterion("detector_id not in", values, "detectorId");
            return (Criteria) this;
        }

        public Criteria andDetectorIdBetween(Integer value1, Integer value2) {
            addCriterion("detector_id between", value1, value2, "detectorId");
            return (Criteria) this;
        }

        public Criteria andDetectorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("detector_id not between", value1, value2, "detectorId");
            return (Criteria) this;
        }

        public Criteria andHostAddressIsNull() {
            addCriterion("host_address is null");
            return (Criteria) this;
        }

        public Criteria andHostAddressIsNotNull() {
            addCriterion("host_address is not null");
            return (Criteria) this;
        }

        public Criteria andHostAddressEqualTo(Integer value) {
            addCriterion("host_address =", value, "hostAddress");
            return (Criteria) this;
        }

        public Criteria andHostAddressNotEqualTo(Integer value) {
            addCriterion("host_address <>", value, "hostAddress");
            return (Criteria) this;
        }

        public Criteria andHostAddressGreaterThan(Integer value) {
            addCriterion("host_address >", value, "hostAddress");
            return (Criteria) this;
        }

        public Criteria andHostAddressGreaterThanOrEqualTo(Integer value) {
            addCriterion("host_address >=", value, "hostAddress");
            return (Criteria) this;
        }

        public Criteria andHostAddressLessThan(Integer value) {
            addCriterion("host_address <", value, "hostAddress");
            return (Criteria) this;
        }

        public Criteria andHostAddressLessThanOrEqualTo(Integer value) {
            addCriterion("host_address <=", value, "hostAddress");
            return (Criteria) this;
        }

        public Criteria andHostAddressIn(List<Integer> values) {
            addCriterion("host_address in", values, "hostAddress");
            return (Criteria) this;
        }

        public Criteria andHostAddressNotIn(List<Integer> values) {
            addCriterion("host_address not in", values, "hostAddress");
            return (Criteria) this;
        }

        public Criteria andHostAddressBetween(Integer value1, Integer value2) {
            addCriterion("host_address between", value1, value2, "hostAddress");
            return (Criteria) this;
        }

        public Criteria andHostAddressNotBetween(Integer value1, Integer value2) {
            addCriterion("host_address not between", value1, value2, "hostAddress");
            return (Criteria) this;
        }

        public Criteria andDetectorAddressIsNull() {
            addCriterion("detector_address is null");
            return (Criteria) this;
        }

        public Criteria andDetectorAddressIsNotNull() {
            addCriterion("detector_address is not null");
            return (Criteria) this;
        }

        public Criteria andDetectorAddressEqualTo(Integer value) {
            addCriterion("detector_address =", value, "detectorAddress");
            return (Criteria) this;
        }

        public Criteria andDetectorAddressNotEqualTo(Integer value) {
            addCriterion("detector_address <>", value, "detectorAddress");
            return (Criteria) this;
        }

        public Criteria andDetectorAddressGreaterThan(Integer value) {
            addCriterion("detector_address >", value, "detectorAddress");
            return (Criteria) this;
        }

        public Criteria andDetectorAddressGreaterThanOrEqualTo(Integer value) {
            addCriterion("detector_address >=", value, "detectorAddress");
            return (Criteria) this;
        }

        public Criteria andDetectorAddressLessThan(Integer value) {
            addCriterion("detector_address <", value, "detectorAddress");
            return (Criteria) this;
        }

        public Criteria andDetectorAddressLessThanOrEqualTo(Integer value) {
            addCriterion("detector_address <=", value, "detectorAddress");
            return (Criteria) this;
        }

        public Criteria andDetectorAddressIn(List<Integer> values) {
            addCriterion("detector_address in", values, "detectorAddress");
            return (Criteria) this;
        }

        public Criteria andDetectorAddressNotIn(List<Integer> values) {
            addCriterion("detector_address not in", values, "detectorAddress");
            return (Criteria) this;
        }

        public Criteria andDetectorAddressBetween(Integer value1, Integer value2) {
            addCriterion("detector_address between", value1, value2, "detectorAddress");
            return (Criteria) this;
        }

        public Criteria andDetectorAddressNotBetween(Integer value1, Integer value2) {
            addCriterion("detector_address not between", value1, value2, "detectorAddress");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andDataValueIsNull() {
            addCriterion("data_value is null");
            return (Criteria) this;
        }

        public Criteria andDataValueIsNotNull() {
            addCriterion("data_value is not null");
            return (Criteria) this;
        }

        public Criteria andDataValueEqualTo(Integer value) {
            addCriterion("data_value =", value, "dataValue");
            return (Criteria) this;
        }

        public Criteria andDataValueNotEqualTo(Integer value) {
            addCriterion("data_value <>", value, "dataValue");
            return (Criteria) this;
        }

        public Criteria andDataValueGreaterThan(Integer value) {
            addCriterion("data_value >", value, "dataValue");
            return (Criteria) this;
        }

        public Criteria andDataValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("data_value >=", value, "dataValue");
            return (Criteria) this;
        }

        public Criteria andDataValueLessThan(Integer value) {
            addCriterion("data_value <", value, "dataValue");
            return (Criteria) this;
        }

        public Criteria andDataValueLessThanOrEqualTo(Integer value) {
            addCriterion("data_value <=", value, "dataValue");
            return (Criteria) this;
        }

        public Criteria andDataValueIn(List<Integer> values) {
            addCriterion("data_value in", values, "dataValue");
            return (Criteria) this;
        }

        public Criteria andDataValueNotIn(List<Integer> values) {
            addCriterion("data_value not in", values, "dataValue");
            return (Criteria) this;
        }

        public Criteria andDataValueBetween(Integer value1, Integer value2) {
            addCriterion("data_value between", value1, value2, "dataValue");
            return (Criteria) this;
        }

        public Criteria andDataValueNotBetween(Integer value1, Integer value2) {
            addCriterion("data_value not between", value1, value2, "dataValue");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdIsNull() {
            addCriterion("enterprise_id is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdIsNotNull() {
            addCriterion("enterprise_id is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdEqualTo(Integer value) {
            addCriterion("enterprise_id =", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotEqualTo(Integer value) {
            addCriterion("enterprise_id <>", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdGreaterThan(Integer value) {
            addCriterion("enterprise_id >", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("enterprise_id >=", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdLessThan(Integer value) {
            addCriterion("enterprise_id <", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdLessThanOrEqualTo(Integer value) {
            addCriterion("enterprise_id <=", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdIn(List<Integer> values) {
            addCriterion("enterprise_id in", values, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotIn(List<Integer> values) {
            addCriterion("enterprise_id not in", values, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdBetween(Integer value1, Integer value2) {
            addCriterion("enterprise_id between", value1, value2, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("enterprise_id not between", value1, value2, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andProduceTimeIsNull() {
            addCriterion("produce_time is null");
            return (Criteria) this;
        }

        public Criteria andProduceTimeIsNotNull() {
            addCriterion("produce_time is not null");
            return (Criteria) this;
        }

        public Criteria andProduceTimeEqualTo(Date value) {
            addCriterion("produce_time =", value, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeNotEqualTo(Date value) {
            addCriterion("produce_time <>", value, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeGreaterThan(Date value) {
            addCriterion("produce_time >", value, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("produce_time >=", value, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeLessThan(Date value) {
            addCriterion("produce_time <", value, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeLessThanOrEqualTo(Date value) {
            addCriterion("produce_time <=", value, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeIn(List<Date> values) {
            addCriterion("produce_time in", values, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeNotIn(List<Date> values) {
            addCriterion("produce_time not in", values, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeBetween(Date value1, Date value2) {
            addCriterion("produce_time between", value1, value2, "produceTime");
            return (Criteria) this;
        }

        public Criteria andProduceTimeNotBetween(Date value1, Date value2) {
            addCriterion("produce_time not between", value1, value2, "produceTime");
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