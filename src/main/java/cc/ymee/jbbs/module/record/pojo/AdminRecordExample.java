package cc.ymee.jbbs.module.record.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public AdminRecordExample() {
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

    public void setLimitStart(int limitStart) {
        this.limitStart=limitStart;
    }

    public int getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(int limitEnd) {
        this.limitEnd=limitEnd;
    }

    public int getLimitEnd() {
        return limitEnd;
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

        public Criteria andRecordContentIsNull() {
            addCriterion("record_content is null");
            return (Criteria) this;
        }

        public Criteria andRecordContentIsNotNull() {
            addCriterion("record_content is not null");
            return (Criteria) this;
        }

        public Criteria andRecordContentEqualTo(String value) {
            addCriterion("record_content =", value, "recordContent");
            return (Criteria) this;
        }

        public Criteria andRecordContentNotEqualTo(String value) {
            addCriterion("record_content <>", value, "recordContent");
            return (Criteria) this;
        }

        public Criteria andRecordContentGreaterThan(String value) {
            addCriterion("record_content >", value, "recordContent");
            return (Criteria) this;
        }

        public Criteria andRecordContentGreaterThanOrEqualTo(String value) {
            addCriterion("record_content >=", value, "recordContent");
            return (Criteria) this;
        }

        public Criteria andRecordContentLessThan(String value) {
            addCriterion("record_content <", value, "recordContent");
            return (Criteria) this;
        }

        public Criteria andRecordContentLessThanOrEqualTo(String value) {
            addCriterion("record_content <=", value, "recordContent");
            return (Criteria) this;
        }

        public Criteria andRecordContentLike(String value) {
            addCriterion("record_content like", value, "recordContent");
            return (Criteria) this;
        }

        public Criteria andRecordContentNotLike(String value) {
            addCriterion("record_content not like", value, "recordContent");
            return (Criteria) this;
        }

        public Criteria andRecordContentIn(List<String> values) {
            addCriterion("record_content in", values, "recordContent");
            return (Criteria) this;
        }

        public Criteria andRecordContentNotIn(List<String> values) {
            addCriterion("record_content not in", values, "recordContent");
            return (Criteria) this;
        }

        public Criteria andRecordContentBetween(String value1, String value2) {
            addCriterion("record_content between", value1, value2, "recordContent");
            return (Criteria) this;
        }

        public Criteria andRecordContentNotBetween(String value1, String value2) {
            addCriterion("record_content not between", value1, value2, "recordContent");
            return (Criteria) this;
        }

        public Criteria andInTimeIsNull() {
            addCriterion("in_time is null");
            return (Criteria) this;
        }

        public Criteria andInTimeIsNotNull() {
            addCriterion("in_time is not null");
            return (Criteria) this;
        }

        public Criteria andInTimeEqualTo(Date value) {
            addCriterion("in_time =", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeNotEqualTo(Date value) {
            addCriterion("in_time <>", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeGreaterThan(Date value) {
            addCriterion("in_time >", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("in_time >=", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeLessThan(Date value) {
            addCriterion("in_time <", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeLessThanOrEqualTo(Date value) {
            addCriterion("in_time <=", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeIn(List<Date> values) {
            addCriterion("in_time in", values, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeNotIn(List<Date> values) {
            addCriterion("in_time not in", values, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeBetween(Date value1, Date value2) {
            addCriterion("in_time between", value1, value2, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeNotBetween(Date value1, Date value2) {
            addCriterion("in_time not between", value1, value2, "inTime");
            return (Criteria) this;
        }

        public Criteria andRecordKeyIsNull() {
            addCriterion("record_key is null");
            return (Criteria) this;
        }

        public Criteria andRecordKeyIsNotNull() {
            addCriterion("record_key is not null");
            return (Criteria) this;
        }

        public Criteria andRecordKeyEqualTo(String value) {
            addCriterion("record_key =", value, "recordKey");
            return (Criteria) this;
        }

        public Criteria andRecordKeyNotEqualTo(String value) {
            addCriterion("record_key <>", value, "recordKey");
            return (Criteria) this;
        }

        public Criteria andRecordKeyGreaterThan(String value) {
            addCriterion("record_key >", value, "recordKey");
            return (Criteria) this;
        }

        public Criteria andRecordKeyGreaterThanOrEqualTo(String value) {
            addCriterion("record_key >=", value, "recordKey");
            return (Criteria) this;
        }

        public Criteria andRecordKeyLessThan(String value) {
            addCriterion("record_key <", value, "recordKey");
            return (Criteria) this;
        }

        public Criteria andRecordKeyLessThanOrEqualTo(String value) {
            addCriterion("record_key <=", value, "recordKey");
            return (Criteria) this;
        }

        public Criteria andRecordKeyLike(String value) {
            addCriterion("record_key like", value, "recordKey");
            return (Criteria) this;
        }

        public Criteria andRecordKeyNotLike(String value) {
            addCriterion("record_key not like", value, "recordKey");
            return (Criteria) this;
        }

        public Criteria andRecordKeyIn(List<String> values) {
            addCriterion("record_key in", values, "recordKey");
            return (Criteria) this;
        }

        public Criteria andRecordKeyNotIn(List<String> values) {
            addCriterion("record_key not in", values, "recordKey");
            return (Criteria) this;
        }

        public Criteria andRecordKeyBetween(String value1, String value2) {
            addCriterion("record_key between", value1, value2, "recordKey");
            return (Criteria) this;
        }

        public Criteria andRecordKeyNotBetween(String value1, String value2) {
            addCriterion("record_key not between", value1, value2, "recordKey");
            return (Criteria) this;
        }

        public Criteria andAdminIdIsNull() {
            addCriterion("admin_id is null");
            return (Criteria) this;
        }

        public Criteria andAdminIdIsNotNull() {
            addCriterion("admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdminIdEqualTo(Integer value) {
            addCriterion("admin_id =", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotEqualTo(Integer value) {
            addCriterion("admin_id <>", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThan(Integer value) {
            addCriterion("admin_id >", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("admin_id >=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThan(Integer value) {
            addCriterion("admin_id <", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThanOrEqualTo(Integer value) {
            addCriterion("admin_id <=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdIn(List<Integer> values) {
            addCriterion("admin_id in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotIn(List<Integer> values) {
            addCriterion("admin_id not in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdBetween(Integer value1, Integer value2) {
            addCriterion("admin_id between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotBetween(Integer value1, Integer value2) {
            addCriterion("admin_id not between", value1, value2, "adminId");
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