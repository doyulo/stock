package cn.stock.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RaskAlyzExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RaskAlyzExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
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

        public Criteria andCurPriIsNull() {
            addCriterion("cur_pri is null");
            return (Criteria) this;
        }

        public Criteria andCurPriIsNotNull() {
            addCriterion("cur_pri is not null");
            return (Criteria) this;
        }

        public Criteria andCurPriEqualTo(BigDecimal value) {
            addCriterion("cur_pri =", value, "curPri");
            return (Criteria) this;
        }

        public Criteria andCurPriNotEqualTo(BigDecimal value) {
            addCriterion("cur_pri <>", value, "curPri");
            return (Criteria) this;
        }

        public Criteria andCurPriGreaterThan(BigDecimal value) {
            addCriterion("cur_pri >", value, "curPri");
            return (Criteria) this;
        }

        public Criteria andCurPriGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cur_pri >=", value, "curPri");
            return (Criteria) this;
        }

        public Criteria andCurPriLessThan(BigDecimal value) {
            addCriterion("cur_pri <", value, "curPri");
            return (Criteria) this;
        }

        public Criteria andCurPriLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cur_pri <=", value, "curPri");
            return (Criteria) this;
        }

        public Criteria andCurPriIn(List<BigDecimal> values) {
            addCriterion("cur_pri in", values, "curPri");
            return (Criteria) this;
        }

        public Criteria andCurPriNotIn(List<BigDecimal> values) {
            addCriterion("cur_pri not in", values, "curPri");
            return (Criteria) this;
        }

        public Criteria andCurPriBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cur_pri between", value1, value2, "curPri");
            return (Criteria) this;
        }

        public Criteria andCurPriNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cur_pri not between", value1, value2, "curPri");
            return (Criteria) this;
        }

        public Criteria andAvrPriIsNull() {
            addCriterion("avr_pri is null");
            return (Criteria) this;
        }

        public Criteria andAvrPriIsNotNull() {
            addCriterion("avr_pri is not null");
            return (Criteria) this;
        }

        public Criteria andAvrPriEqualTo(BigDecimal value) {
            addCriterion("avr_pri =", value, "avrPri");
            return (Criteria) this;
        }

        public Criteria andAvrPriNotEqualTo(BigDecimal value) {
            addCriterion("avr_pri <>", value, "avrPri");
            return (Criteria) this;
        }

        public Criteria andAvrPriGreaterThan(BigDecimal value) {
            addCriterion("avr_pri >", value, "avrPri");
            return (Criteria) this;
        }

        public Criteria andAvrPriGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("avr_pri >=", value, "avrPri");
            return (Criteria) this;
        }

        public Criteria andAvrPriLessThan(BigDecimal value) {
            addCriterion("avr_pri <", value, "avrPri");
            return (Criteria) this;
        }

        public Criteria andAvrPriLessThanOrEqualTo(BigDecimal value) {
            addCriterion("avr_pri <=", value, "avrPri");
            return (Criteria) this;
        }

        public Criteria andAvrPriIn(List<BigDecimal> values) {
            addCriterion("avr_pri in", values, "avrPri");
            return (Criteria) this;
        }

        public Criteria andAvrPriNotIn(List<BigDecimal> values) {
            addCriterion("avr_pri not in", values, "avrPri");
            return (Criteria) this;
        }

        public Criteria andAvrPriBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("avr_pri between", value1, value2, "avrPri");
            return (Criteria) this;
        }

        public Criteria andAvrPriNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("avr_pri not between", value1, value2, "avrPri");
            return (Criteria) this;
        }

        public Criteria andAvrPri1IsNull() {
            addCriterion("avr_pri_1 is null");
            return (Criteria) this;
        }

        public Criteria andAvrPri1IsNotNull() {
            addCriterion("avr_pri_1 is not null");
            return (Criteria) this;
        }

        public Criteria andAvrPri1EqualTo(BigDecimal value) {
            addCriterion("avr_pri_1 =", value, "avrPri1");
            return (Criteria) this;
        }

        public Criteria andAvrPri1NotEqualTo(BigDecimal value) {
            addCriterion("avr_pri_1 <>", value, "avrPri1");
            return (Criteria) this;
        }

        public Criteria andAvrPri1GreaterThan(BigDecimal value) {
            addCriterion("avr_pri_1 >", value, "avrPri1");
            return (Criteria) this;
        }

        public Criteria andAvrPri1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("avr_pri_1 >=", value, "avrPri1");
            return (Criteria) this;
        }

        public Criteria andAvrPri1LessThan(BigDecimal value) {
            addCriterion("avr_pri_1 <", value, "avrPri1");
            return (Criteria) this;
        }

        public Criteria andAvrPri1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("avr_pri_1 <=", value, "avrPri1");
            return (Criteria) this;
        }

        public Criteria andAvrPri1In(List<BigDecimal> values) {
            addCriterion("avr_pri_1 in", values, "avrPri1");
            return (Criteria) this;
        }

        public Criteria andAvrPri1NotIn(List<BigDecimal> values) {
            addCriterion("avr_pri_1 not in", values, "avrPri1");
            return (Criteria) this;
        }

        public Criteria andAvrPri1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("avr_pri_1 between", value1, value2, "avrPri1");
            return (Criteria) this;
        }

        public Criteria andAvrPri1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("avr_pri_1 not between", value1, value2, "avrPri1");
            return (Criteria) this;
        }

        public Criteria andAvrPri2IsNull() {
            addCriterion("avr_pri_2 is null");
            return (Criteria) this;
        }

        public Criteria andAvrPri2IsNotNull() {
            addCriterion("avr_pri_2 is not null");
            return (Criteria) this;
        }

        public Criteria andAvrPri2EqualTo(BigDecimal value) {
            addCriterion("avr_pri_2 =", value, "avrPri2");
            return (Criteria) this;
        }

        public Criteria andAvrPri2NotEqualTo(BigDecimal value) {
            addCriterion("avr_pri_2 <>", value, "avrPri2");
            return (Criteria) this;
        }

        public Criteria andAvrPri2GreaterThan(BigDecimal value) {
            addCriterion("avr_pri_2 >", value, "avrPri2");
            return (Criteria) this;
        }

        public Criteria andAvrPri2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("avr_pri_2 >=", value, "avrPri2");
            return (Criteria) this;
        }

        public Criteria andAvrPri2LessThan(BigDecimal value) {
            addCriterion("avr_pri_2 <", value, "avrPri2");
            return (Criteria) this;
        }

        public Criteria andAvrPri2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("avr_pri_2 <=", value, "avrPri2");
            return (Criteria) this;
        }

        public Criteria andAvrPri2In(List<BigDecimal> values) {
            addCriterion("avr_pri_2 in", values, "avrPri2");
            return (Criteria) this;
        }

        public Criteria andAvrPri2NotIn(List<BigDecimal> values) {
            addCriterion("avr_pri_2 not in", values, "avrPri2");
            return (Criteria) this;
        }

        public Criteria andAvrPri2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("avr_pri_2 between", value1, value2, "avrPri2");
            return (Criteria) this;
        }

        public Criteria andAvrPri2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("avr_pri_2 not between", value1, value2, "avrPri2");
            return (Criteria) this;
        }

        public Criteria andRateIsNull() {
            addCriterion("rate is null");
            return (Criteria) this;
        }

        public Criteria andRateIsNotNull() {
            addCriterion("rate is not null");
            return (Criteria) this;
        }

        public Criteria andRateEqualTo(BigDecimal value) {
            addCriterion("rate =", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotEqualTo(BigDecimal value) {
            addCriterion("rate <>", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThan(BigDecimal value) {
            addCriterion("rate >", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rate >=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThan(BigDecimal value) {
            addCriterion("rate <", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rate <=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateIn(List<BigDecimal> values) {
            addCriterion("rate in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotIn(List<BigDecimal> values) {
            addCriterion("rate not in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rate between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rate not between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andSlopeIsNull() {
            addCriterion("slope is null");
            return (Criteria) this;
        }

        public Criteria andSlopeIsNotNull() {
            addCriterion("slope is not null");
            return (Criteria) this;
        }

        public Criteria andSlopeEqualTo(Integer value) {
            addCriterion("slope =", value, "slope");
            return (Criteria) this;
        }

        public Criteria andSlopeNotEqualTo(Integer value) {
            addCriterion("slope <>", value, "slope");
            return (Criteria) this;
        }

        public Criteria andSlopeGreaterThan(Integer value) {
            addCriterion("slope >", value, "slope");
            return (Criteria) this;
        }

        public Criteria andSlopeGreaterThanOrEqualTo(Integer value) {
            addCriterion("slope >=", value, "slope");
            return (Criteria) this;
        }

        public Criteria andSlopeLessThan(Integer value) {
            addCriterion("slope <", value, "slope");
            return (Criteria) this;
        }

        public Criteria andSlopeLessThanOrEqualTo(Integer value) {
            addCriterion("slope <=", value, "slope");
            return (Criteria) this;
        }

        public Criteria andSlopeIn(List<Integer> values) {
            addCriterion("slope in", values, "slope");
            return (Criteria) this;
        }

        public Criteria andSlopeNotIn(List<Integer> values) {
            addCriterion("slope not in", values, "slope");
            return (Criteria) this;
        }

        public Criteria andSlopeBetween(Integer value1, Integer value2) {
            addCriterion("slope between", value1, value2, "slope");
            return (Criteria) this;
        }

        public Criteria andSlopeNotBetween(Integer value1, Integer value2) {
            addCriterion("slope not between", value1, value2, "slope");
            return (Criteria) this;
        }

        public Criteria andSlope1IsNull() {
            addCriterion("slope1 is null");
            return (Criteria) this;
        }

        public Criteria andSlope1IsNotNull() {
            addCriterion("slope1 is not null");
            return (Criteria) this;
        }

        public Criteria andSlope1EqualTo(Integer value) {
            addCriterion("slope1 =", value, "slope1");
            return (Criteria) this;
        }

        public Criteria andSlope1NotEqualTo(Integer value) {
            addCriterion("slope1 <>", value, "slope1");
            return (Criteria) this;
        }

        public Criteria andSlope1GreaterThan(Integer value) {
            addCriterion("slope1 >", value, "slope1");
            return (Criteria) this;
        }

        public Criteria andSlope1GreaterThanOrEqualTo(Integer value) {
            addCriterion("slope1 >=", value, "slope1");
            return (Criteria) this;
        }

        public Criteria andSlope1LessThan(Integer value) {
            addCriterion("slope1 <", value, "slope1");
            return (Criteria) this;
        }

        public Criteria andSlope1LessThanOrEqualTo(Integer value) {
            addCriterion("slope1 <=", value, "slope1");
            return (Criteria) this;
        }

        public Criteria andSlope1In(List<Integer> values) {
            addCriterion("slope1 in", values, "slope1");
            return (Criteria) this;
        }

        public Criteria andSlope1NotIn(List<Integer> values) {
            addCriterion("slope1 not in", values, "slope1");
            return (Criteria) this;
        }

        public Criteria andSlope1Between(Integer value1, Integer value2) {
            addCriterion("slope1 between", value1, value2, "slope1");
            return (Criteria) this;
        }

        public Criteria andSlope1NotBetween(Integer value1, Integer value2) {
            addCriterion("slope1 not between", value1, value2, "slope1");
            return (Criteria) this;
        }

        public Criteria andSlope2IsNull() {
            addCriterion("slope2 is null");
            return (Criteria) this;
        }

        public Criteria andSlope2IsNotNull() {
            addCriterion("slope2 is not null");
            return (Criteria) this;
        }

        public Criteria andSlope2EqualTo(Integer value) {
            addCriterion("slope2 =", value, "slope2");
            return (Criteria) this;
        }

        public Criteria andSlope2NotEqualTo(Integer value) {
            addCriterion("slope2 <>", value, "slope2");
            return (Criteria) this;
        }

        public Criteria andSlope2GreaterThan(Integer value) {
            addCriterion("slope2 >", value, "slope2");
            return (Criteria) this;
        }

        public Criteria andSlope2GreaterThanOrEqualTo(Integer value) {
            addCriterion("slope2 >=", value, "slope2");
            return (Criteria) this;
        }

        public Criteria andSlope2LessThan(Integer value) {
            addCriterion("slope2 <", value, "slope2");
            return (Criteria) this;
        }

        public Criteria andSlope2LessThanOrEqualTo(Integer value) {
            addCriterion("slope2 <=", value, "slope2");
            return (Criteria) this;
        }

        public Criteria andSlope2In(List<Integer> values) {
            addCriterion("slope2 in", values, "slope2");
            return (Criteria) this;
        }

        public Criteria andSlope2NotIn(List<Integer> values) {
            addCriterion("slope2 not in", values, "slope2");
            return (Criteria) this;
        }

        public Criteria andSlope2Between(Integer value1, Integer value2) {
            addCriterion("slope2 between", value1, value2, "slope2");
            return (Criteria) this;
        }

        public Criteria andSlope2NotBetween(Integer value1, Integer value2) {
            addCriterion("slope2 not between", value1, value2, "slope2");
            return (Criteria) this;
        }

        public Criteria andDealDateIsNull() {
            addCriterion("deal_date is null");
            return (Criteria) this;
        }

        public Criteria andDealDateIsNotNull() {
            addCriterion("deal_date is not null");
            return (Criteria) this;
        }

        public Criteria andDealDateEqualTo(Date value) {
            addCriterionForJDBCDate("deal_date =", value, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("deal_date <>", value, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateGreaterThan(Date value) {
            addCriterionForJDBCDate("deal_date >", value, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("deal_date >=", value, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateLessThan(Date value) {
            addCriterionForJDBCDate("deal_date <", value, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("deal_date <=", value, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateIn(List<Date> values) {
            addCriterionForJDBCDate("deal_date in", values, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("deal_date not in", values, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("deal_date between", value1, value2, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("deal_date not between", value1, value2, "dealDate");
            return (Criteria) this;
        }

        public Criteria andHoldIsNull() {
            addCriterion("hold is null");
            return (Criteria) this;
        }

        public Criteria andHoldIsNotNull() {
            addCriterion("hold is not null");
            return (Criteria) this;
        }

        public Criteria andHoldEqualTo(Boolean value) {
            addCriterion("hold =", value, "hold");
            return (Criteria) this;
        }

        public Criteria andHoldNotEqualTo(Boolean value) {
            addCriterion("hold <>", value, "hold");
            return (Criteria) this;
        }

        public Criteria andHoldGreaterThan(Boolean value) {
            addCriterion("hold >", value, "hold");
            return (Criteria) this;
        }

        public Criteria andHoldGreaterThanOrEqualTo(Boolean value) {
            addCriterion("hold >=", value, "hold");
            return (Criteria) this;
        }

        public Criteria andHoldLessThan(Boolean value) {
            addCriterion("hold <", value, "hold");
            return (Criteria) this;
        }

        public Criteria andHoldLessThanOrEqualTo(Boolean value) {
            addCriterion("hold <=", value, "hold");
            return (Criteria) this;
        }

        public Criteria andHoldIn(List<Boolean> values) {
            addCriterion("hold in", values, "hold");
            return (Criteria) this;
        }

        public Criteria andHoldNotIn(List<Boolean> values) {
            addCriterion("hold not in", values, "hold");
            return (Criteria) this;
        }

        public Criteria andHoldBetween(Boolean value1, Boolean value2) {
            addCriterion("hold between", value1, value2, "hold");
            return (Criteria) this;
        }

        public Criteria andHoldNotBetween(Boolean value1, Boolean value2) {
            addCriterion("hold not between", value1, value2, "hold");
            return (Criteria) this;
        }

        public Criteria andReversalRateIsNull() {
            addCriterion("reversal_rate is null");
            return (Criteria) this;
        }

        public Criteria andReversalRateIsNotNull() {
            addCriterion("reversal_rate is not null");
            return (Criteria) this;
        }

        public Criteria andReversalRateEqualTo(String value) {
            addCriterion("reversal_rate =", value, "reversalRate");
            return (Criteria) this;
        }

        public Criteria andReversalRateNotEqualTo(String value) {
            addCriterion("reversal_rate <>", value, "reversalRate");
            return (Criteria) this;
        }

        public Criteria andReversalRateGreaterThan(String value) {
            addCriterion("reversal_rate >", value, "reversalRate");
            return (Criteria) this;
        }

        public Criteria andReversalRateGreaterThanOrEqualTo(String value) {
            addCriterion("reversal_rate >=", value, "reversalRate");
            return (Criteria) this;
        }

        public Criteria andReversalRateLessThan(String value) {
            addCriterion("reversal_rate <", value, "reversalRate");
            return (Criteria) this;
        }

        public Criteria andReversalRateLessThanOrEqualTo(String value) {
            addCriterion("reversal_rate <=", value, "reversalRate");
            return (Criteria) this;
        }

        public Criteria andReversalRateLike(String value) {
            addCriterion("reversal_rate like", value, "reversalRate");
            return (Criteria) this;
        }

        public Criteria andReversalRateNotLike(String value) {
            addCriterion("reversal_rate not like", value, "reversalRate");
            return (Criteria) this;
        }

        public Criteria andReversalRateIn(List<String> values) {
            addCriterion("reversal_rate in", values, "reversalRate");
            return (Criteria) this;
        }

        public Criteria andReversalRateNotIn(List<String> values) {
            addCriterion("reversal_rate not in", values, "reversalRate");
            return (Criteria) this;
        }

        public Criteria andReversalRateBetween(String value1, String value2) {
            addCriterion("reversal_rate between", value1, value2, "reversalRate");
            return (Criteria) this;
        }

        public Criteria andReversalRateNotBetween(String value1, String value2) {
            addCriterion("reversal_rate not between", value1, value2, "reversalRate");
            return (Criteria) this;
        }

        public Criteria andHighRiskDaysIsNull() {
            addCriterion("high_risk_days is null");
            return (Criteria) this;
        }

        public Criteria andHighRiskDaysIsNotNull() {
            addCriterion("high_risk_days is not null");
            return (Criteria) this;
        }

        public Criteria andHighRiskDaysEqualTo(Integer value) {
            addCriterion("high_risk_days =", value, "highRiskDays");
            return (Criteria) this;
        }

        public Criteria andHighRiskDaysNotEqualTo(Integer value) {
            addCriterion("high_risk_days <>", value, "highRiskDays");
            return (Criteria) this;
        }

        public Criteria andHighRiskDaysGreaterThan(Integer value) {
            addCriterion("high_risk_days >", value, "highRiskDays");
            return (Criteria) this;
        }

        public Criteria andHighRiskDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("high_risk_days >=", value, "highRiskDays");
            return (Criteria) this;
        }

        public Criteria andHighRiskDaysLessThan(Integer value) {
            addCriterion("high_risk_days <", value, "highRiskDays");
            return (Criteria) this;
        }

        public Criteria andHighRiskDaysLessThanOrEqualTo(Integer value) {
            addCriterion("high_risk_days <=", value, "highRiskDays");
            return (Criteria) this;
        }

        public Criteria andHighRiskDaysIn(List<Integer> values) {
            addCriterion("high_risk_days in", values, "highRiskDays");
            return (Criteria) this;
        }

        public Criteria andHighRiskDaysNotIn(List<Integer> values) {
            addCriterion("high_risk_days not in", values, "highRiskDays");
            return (Criteria) this;
        }

        public Criteria andHighRiskDaysBetween(Integer value1, Integer value2) {
            addCriterion("high_risk_days between", value1, value2, "highRiskDays");
            return (Criteria) this;
        }

        public Criteria andHighRiskDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("high_risk_days not between", value1, value2, "highRiskDays");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andPostiveDaysIsNull() {
            addCriterion("postive_days is null");
            return (Criteria) this;
        }

        public Criteria andPostiveDaysIsNotNull() {
            addCriterion("postive_days is not null");
            return (Criteria) this;
        }

        public Criteria andPostiveDaysEqualTo(Integer value) {
            addCriterion("postive_days =", value, "postiveDays");
            return (Criteria) this;
        }

        public Criteria andPostiveDaysNotEqualTo(Integer value) {
            addCriterion("postive_days <>", value, "postiveDays");
            return (Criteria) this;
        }

        public Criteria andPostiveDaysGreaterThan(Integer value) {
            addCriterion("postive_days >", value, "postiveDays");
            return (Criteria) this;
        }

        public Criteria andPostiveDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("postive_days >=", value, "postiveDays");
            return (Criteria) this;
        }

        public Criteria andPostiveDaysLessThan(Integer value) {
            addCriterion("postive_days <", value, "postiveDays");
            return (Criteria) this;
        }

        public Criteria andPostiveDaysLessThanOrEqualTo(Integer value) {
            addCriterion("postive_days <=", value, "postiveDays");
            return (Criteria) this;
        }

        public Criteria andPostiveDaysIn(List<Integer> values) {
            addCriterion("postive_days in", values, "postiveDays");
            return (Criteria) this;
        }

        public Criteria andPostiveDaysNotIn(List<Integer> values) {
            addCriterion("postive_days not in", values, "postiveDays");
            return (Criteria) this;
        }

        public Criteria andPostiveDaysBetween(Integer value1, Integer value2) {
            addCriterion("postive_days between", value1, value2, "postiveDays");
            return (Criteria) this;
        }

        public Criteria andPostiveDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("postive_days not between", value1, value2, "postiveDays");
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