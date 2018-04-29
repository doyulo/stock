package cn.stock.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class StockDayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StockDayExample() {
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

        public Criteria andBeginPriIsNull() {
            addCriterion("begin_pri is null");
            return (Criteria) this;
        }

        public Criteria andBeginPriIsNotNull() {
            addCriterion("begin_pri is not null");
            return (Criteria) this;
        }

        public Criteria andBeginPriEqualTo(BigDecimal value) {
            addCriterion("begin_pri =", value, "beginPri");
            return (Criteria) this;
        }

        public Criteria andBeginPriNotEqualTo(BigDecimal value) {
            addCriterion("begin_pri <>", value, "beginPri");
            return (Criteria) this;
        }

        public Criteria andBeginPriGreaterThan(BigDecimal value) {
            addCriterion("begin_pri >", value, "beginPri");
            return (Criteria) this;
        }

        public Criteria andBeginPriGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("begin_pri >=", value, "beginPri");
            return (Criteria) this;
        }

        public Criteria andBeginPriLessThan(BigDecimal value) {
            addCriterion("begin_pri <", value, "beginPri");
            return (Criteria) this;
        }

        public Criteria andBeginPriLessThanOrEqualTo(BigDecimal value) {
            addCriterion("begin_pri <=", value, "beginPri");
            return (Criteria) this;
        }

        public Criteria andBeginPriIn(List<BigDecimal> values) {
            addCriterion("begin_pri in", values, "beginPri");
            return (Criteria) this;
        }

        public Criteria andBeginPriNotIn(List<BigDecimal> values) {
            addCriterion("begin_pri not in", values, "beginPri");
            return (Criteria) this;
        }

        public Criteria andBeginPriBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("begin_pri between", value1, value2, "beginPri");
            return (Criteria) this;
        }

        public Criteria andBeginPriNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("begin_pri not between", value1, value2, "beginPri");
            return (Criteria) this;
        }

        public Criteria andMaxPriIsNull() {
            addCriterion("max_pri is null");
            return (Criteria) this;
        }

        public Criteria andMaxPriIsNotNull() {
            addCriterion("max_pri is not null");
            return (Criteria) this;
        }

        public Criteria andMaxPriEqualTo(BigDecimal value) {
            addCriterion("max_pri =", value, "maxPri");
            return (Criteria) this;
        }

        public Criteria andMaxPriNotEqualTo(BigDecimal value) {
            addCriterion("max_pri <>", value, "maxPri");
            return (Criteria) this;
        }

        public Criteria andMaxPriGreaterThan(BigDecimal value) {
            addCriterion("max_pri >", value, "maxPri");
            return (Criteria) this;
        }

        public Criteria andMaxPriGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("max_pri >=", value, "maxPri");
            return (Criteria) this;
        }

        public Criteria andMaxPriLessThan(BigDecimal value) {
            addCriterion("max_pri <", value, "maxPri");
            return (Criteria) this;
        }

        public Criteria andMaxPriLessThanOrEqualTo(BigDecimal value) {
            addCriterion("max_pri <=", value, "maxPri");
            return (Criteria) this;
        }

        public Criteria andMaxPriIn(List<BigDecimal> values) {
            addCriterion("max_pri in", values, "maxPri");
            return (Criteria) this;
        }

        public Criteria andMaxPriNotIn(List<BigDecimal> values) {
            addCriterion("max_pri not in", values, "maxPri");
            return (Criteria) this;
        }

        public Criteria andMaxPriBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("max_pri between", value1, value2, "maxPri");
            return (Criteria) this;
        }

        public Criteria andMaxPriNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("max_pri not between", value1, value2, "maxPri");
            return (Criteria) this;
        }

        public Criteria andMinPriIsNull() {
            addCriterion("min_pri is null");
            return (Criteria) this;
        }

        public Criteria andMinPriIsNotNull() {
            addCriterion("min_pri is not null");
            return (Criteria) this;
        }

        public Criteria andMinPriEqualTo(BigDecimal value) {
            addCriterion("min_pri =", value, "minPri");
            return (Criteria) this;
        }

        public Criteria andMinPriNotEqualTo(BigDecimal value) {
            addCriterion("min_pri <>", value, "minPri");
            return (Criteria) this;
        }

        public Criteria andMinPriGreaterThan(BigDecimal value) {
            addCriterion("min_pri >", value, "minPri");
            return (Criteria) this;
        }

        public Criteria andMinPriGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("min_pri >=", value, "minPri");
            return (Criteria) this;
        }

        public Criteria andMinPriLessThan(BigDecimal value) {
            addCriterion("min_pri <", value, "minPri");
            return (Criteria) this;
        }

        public Criteria andMinPriLessThanOrEqualTo(BigDecimal value) {
            addCriterion("min_pri <=", value, "minPri");
            return (Criteria) this;
        }

        public Criteria andMinPriIn(List<BigDecimal> values) {
            addCriterion("min_pri in", values, "minPri");
            return (Criteria) this;
        }

        public Criteria andMinPriNotIn(List<BigDecimal> values) {
            addCriterion("min_pri not in", values, "minPri");
            return (Criteria) this;
        }

        public Criteria andMinPriBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("min_pri between", value1, value2, "minPri");
            return (Criteria) this;
        }

        public Criteria andMinPriNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("min_pri not between", value1, value2, "minPri");
            return (Criteria) this;
        }

        public Criteria andPrePriIsNull() {
            addCriterion("pre_pri is null");
            return (Criteria) this;
        }

        public Criteria andPrePriIsNotNull() {
            addCriterion("pre_pri is not null");
            return (Criteria) this;
        }

        public Criteria andPrePriEqualTo(BigDecimal value) {
            addCriterion("pre_pri =", value, "prePri");
            return (Criteria) this;
        }

        public Criteria andPrePriNotEqualTo(BigDecimal value) {
            addCriterion("pre_pri <>", value, "prePri");
            return (Criteria) this;
        }

        public Criteria andPrePriGreaterThan(BigDecimal value) {
            addCriterion("pre_pri >", value, "prePri");
            return (Criteria) this;
        }

        public Criteria andPrePriGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pre_pri >=", value, "prePri");
            return (Criteria) this;
        }

        public Criteria andPrePriLessThan(BigDecimal value) {
            addCriterion("pre_pri <", value, "prePri");
            return (Criteria) this;
        }

        public Criteria andPrePriLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pre_pri <=", value, "prePri");
            return (Criteria) this;
        }

        public Criteria andPrePriIn(List<BigDecimal> values) {
            addCriterion("pre_pri in", values, "prePri");
            return (Criteria) this;
        }

        public Criteria andPrePriNotIn(List<BigDecimal> values) {
            addCriterion("pre_pri not in", values, "prePri");
            return (Criteria) this;
        }

        public Criteria andPrePriBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pre_pri between", value1, value2, "prePri");
            return (Criteria) this;
        }

        public Criteria andPrePriNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pre_pri not between", value1, value2, "prePri");
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

        public Criteria andDealQtyIsNull() {
            addCriterion("deal_qty is null");
            return (Criteria) this;
        }

        public Criteria andDealQtyIsNotNull() {
            addCriterion("deal_qty is not null");
            return (Criteria) this;
        }

        public Criteria andDealQtyEqualTo(Long value) {
            addCriterion("deal_qty =", value, "dealQty");
            return (Criteria) this;
        }

        public Criteria andDealQtyNotEqualTo(Long value) {
            addCriterion("deal_qty <>", value, "dealQty");
            return (Criteria) this;
        }

        public Criteria andDealQtyGreaterThan(Long value) {
            addCriterion("deal_qty >", value, "dealQty");
            return (Criteria) this;
        }

        public Criteria andDealQtyGreaterThanOrEqualTo(Long value) {
            addCriterion("deal_qty >=", value, "dealQty");
            return (Criteria) this;
        }

        public Criteria andDealQtyLessThan(Long value) {
            addCriterion("deal_qty <", value, "dealQty");
            return (Criteria) this;
        }

        public Criteria andDealQtyLessThanOrEqualTo(Long value) {
            addCriterion("deal_qty <=", value, "dealQty");
            return (Criteria) this;
        }

        public Criteria andDealQtyIn(List<Long> values) {
            addCriterion("deal_qty in", values, "dealQty");
            return (Criteria) this;
        }

        public Criteria andDealQtyNotIn(List<Long> values) {
            addCriterion("deal_qty not in", values, "dealQty");
            return (Criteria) this;
        }

        public Criteria andDealQtyBetween(Long value1, Long value2) {
            addCriterion("deal_qty between", value1, value2, "dealQty");
            return (Criteria) this;
        }

        public Criteria andDealQtyNotBetween(Long value1, Long value2) {
            addCriterion("deal_qty not between", value1, value2, "dealQty");
            return (Criteria) this;
        }

        public Criteria andDealAmtIsNull() {
            addCriterion("deal_amt is null");
            return (Criteria) this;
        }

        public Criteria andDealAmtIsNotNull() {
            addCriterion("deal_amt is not null");
            return (Criteria) this;
        }

        public Criteria andDealAmtEqualTo(BigDecimal value) {
            addCriterion("deal_amt =", value, "dealAmt");
            return (Criteria) this;
        }

        public Criteria andDealAmtNotEqualTo(BigDecimal value) {
            addCriterion("deal_amt <>", value, "dealAmt");
            return (Criteria) this;
        }

        public Criteria andDealAmtGreaterThan(BigDecimal value) {
            addCriterion("deal_amt >", value, "dealAmt");
            return (Criteria) this;
        }

        public Criteria andDealAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("deal_amt >=", value, "dealAmt");
            return (Criteria) this;
        }

        public Criteria andDealAmtLessThan(BigDecimal value) {
            addCriterion("deal_amt <", value, "dealAmt");
            return (Criteria) this;
        }

        public Criteria andDealAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("deal_amt <=", value, "dealAmt");
            return (Criteria) this;
        }

        public Criteria andDealAmtIn(List<BigDecimal> values) {
            addCriterion("deal_amt in", values, "dealAmt");
            return (Criteria) this;
        }

        public Criteria andDealAmtNotIn(List<BigDecimal> values) {
            addCriterion("deal_amt not in", values, "dealAmt");
            return (Criteria) this;
        }

        public Criteria andDealAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deal_amt between", value1, value2, "dealAmt");
            return (Criteria) this;
        }

        public Criteria andDealAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deal_amt not between", value1, value2, "dealAmt");
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

        public Criteria andRateRangeIsNull() {
            addCriterion("rate_range is null");
            return (Criteria) this;
        }

        public Criteria andRateRangeIsNotNull() {
            addCriterion("rate_range is not null");
            return (Criteria) this;
        }

        public Criteria andRateRangeEqualTo(BigDecimal value) {
            addCriterion("rate_range =", value, "rateRange");
            return (Criteria) this;
        }

        public Criteria andRateRangeNotEqualTo(BigDecimal value) {
            addCriterion("rate_range <>", value, "rateRange");
            return (Criteria) this;
        }

        public Criteria andRateRangeGreaterThan(BigDecimal value) {
            addCriterion("rate_range >", value, "rateRange");
            return (Criteria) this;
        }

        public Criteria andRateRangeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rate_range >=", value, "rateRange");
            return (Criteria) this;
        }

        public Criteria andRateRangeLessThan(BigDecimal value) {
            addCriterion("rate_range <", value, "rateRange");
            return (Criteria) this;
        }

        public Criteria andRateRangeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rate_range <=", value, "rateRange");
            return (Criteria) this;
        }

        public Criteria andRateRangeIn(List<BigDecimal> values) {
            addCriterion("rate_range in", values, "rateRange");
            return (Criteria) this;
        }

        public Criteria andRateRangeNotIn(List<BigDecimal> values) {
            addCriterion("rate_range not in", values, "rateRange");
            return (Criteria) this;
        }

        public Criteria andRateRangeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rate_range between", value1, value2, "rateRange");
            return (Criteria) this;
        }

        public Criteria andRateRangeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rate_range not between", value1, value2, "rateRange");
            return (Criteria) this;
        }

        public Criteria andInOutRateIsNull() {
            addCriterion("in_out_rate is null");
            return (Criteria) this;
        }

        public Criteria andInOutRateIsNotNull() {
            addCriterion("in_out_rate is not null");
            return (Criteria) this;
        }

        public Criteria andInOutRateEqualTo(BigDecimal value) {
            addCriterion("in_out_rate =", value, "inOutRate");
            return (Criteria) this;
        }

        public Criteria andInOutRateNotEqualTo(BigDecimal value) {
            addCriterion("in_out_rate <>", value, "inOutRate");
            return (Criteria) this;
        }

        public Criteria andInOutRateGreaterThan(BigDecimal value) {
            addCriterion("in_out_rate >", value, "inOutRate");
            return (Criteria) this;
        }

        public Criteria andInOutRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("in_out_rate >=", value, "inOutRate");
            return (Criteria) this;
        }

        public Criteria andInOutRateLessThan(BigDecimal value) {
            addCriterion("in_out_rate <", value, "inOutRate");
            return (Criteria) this;
        }

        public Criteria andInOutRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("in_out_rate <=", value, "inOutRate");
            return (Criteria) this;
        }

        public Criteria andInOutRateIn(List<BigDecimal> values) {
            addCriterion("in_out_rate in", values, "inOutRate");
            return (Criteria) this;
        }

        public Criteria andInOutRateNotIn(List<BigDecimal> values) {
            addCriterion("in_out_rate not in", values, "inOutRate");
            return (Criteria) this;
        }

        public Criteria andInOutRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("in_out_rate between", value1, value2, "inOutRate");
            return (Criteria) this;
        }

        public Criteria andInOutRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("in_out_rate not between", value1, value2, "inOutRate");
            return (Criteria) this;
        }

        public Criteria andCurDateIsNull() {
            addCriterion("cur_date is null");
            return (Criteria) this;
        }

        public Criteria andCurDateIsNotNull() {
            addCriterion("cur_date is not null");
            return (Criteria) this;
        }

        public Criteria andCurDateEqualTo(Date value) {
            addCriterionForJDBCDate("cur_date =", value, "curDate");
            return (Criteria) this;
        }

        public Criteria andCurDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("cur_date <>", value, "curDate");
            return (Criteria) this;
        }

        public Criteria andCurDateGreaterThan(Date value) {
            addCriterionForJDBCDate("cur_date >", value, "curDate");
            return (Criteria) this;
        }

        public Criteria andCurDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("cur_date >=", value, "curDate");
            return (Criteria) this;
        }

        public Criteria andCurDateLessThan(Date value) {
            addCriterionForJDBCDate("cur_date <", value, "curDate");
            return (Criteria) this;
        }

        public Criteria andCurDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("cur_date <=", value, "curDate");
            return (Criteria) this;
        }

        public Criteria andCurDateIn(List<Date> values) {
            addCriterionForJDBCDate("cur_date in", values, "curDate");
            return (Criteria) this;
        }

        public Criteria andCurDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("cur_date not in", values, "curDate");
            return (Criteria) this;
        }

        public Criteria andCurDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("cur_date between", value1, value2, "curDate");
            return (Criteria) this;
        }

        public Criteria andCurDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("cur_date not between", value1, value2, "curDate");
            return (Criteria) this;
        }

        public Criteria andMarketCapIsNull() {
            addCriterion("market_cap is null");
            return (Criteria) this;
        }

        public Criteria andMarketCapIsNotNull() {
            addCriterion("market_cap is not null");
            return (Criteria) this;
        }

        public Criteria andMarketCapEqualTo(BigDecimal value) {
            addCriterion("market_cap =", value, "marketCap");
            return (Criteria) this;
        }

        public Criteria andMarketCapNotEqualTo(BigDecimal value) {
            addCriterion("market_cap <>", value, "marketCap");
            return (Criteria) this;
        }

        public Criteria andMarketCapGreaterThan(BigDecimal value) {
            addCriterion("market_cap >", value, "marketCap");
            return (Criteria) this;
        }

        public Criteria andMarketCapGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("market_cap >=", value, "marketCap");
            return (Criteria) this;
        }

        public Criteria andMarketCapLessThan(BigDecimal value) {
            addCriterion("market_cap <", value, "marketCap");
            return (Criteria) this;
        }

        public Criteria andMarketCapLessThanOrEqualTo(BigDecimal value) {
            addCriterion("market_cap <=", value, "marketCap");
            return (Criteria) this;
        }

        public Criteria andMarketCapIn(List<BigDecimal> values) {
            addCriterion("market_cap in", values, "marketCap");
            return (Criteria) this;
        }

        public Criteria andMarketCapNotIn(List<BigDecimal> values) {
            addCriterion("market_cap not in", values, "marketCap");
            return (Criteria) this;
        }

        public Criteria andMarketCapBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("market_cap between", value1, value2, "marketCap");
            return (Criteria) this;
        }

        public Criteria andMarketCapNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("market_cap not between", value1, value2, "marketCap");
            return (Criteria) this;
        }

        public Criteria andFamcIsNull() {
            addCriterion("famc is null");
            return (Criteria) this;
        }

        public Criteria andFamcIsNotNull() {
            addCriterion("famc is not null");
            return (Criteria) this;
        }

        public Criteria andFamcEqualTo(BigDecimal value) {
            addCriterion("famc =", value, "famc");
            return (Criteria) this;
        }

        public Criteria andFamcNotEqualTo(BigDecimal value) {
            addCriterion("famc <>", value, "famc");
            return (Criteria) this;
        }

        public Criteria andFamcGreaterThan(BigDecimal value) {
            addCriterion("famc >", value, "famc");
            return (Criteria) this;
        }

        public Criteria andFamcGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("famc >=", value, "famc");
            return (Criteria) this;
        }

        public Criteria andFamcLessThan(BigDecimal value) {
            addCriterion("famc <", value, "famc");
            return (Criteria) this;
        }

        public Criteria andFamcLessThanOrEqualTo(BigDecimal value) {
            addCriterion("famc <=", value, "famc");
            return (Criteria) this;
        }

        public Criteria andFamcIn(List<BigDecimal> values) {
            addCriterion("famc in", values, "famc");
            return (Criteria) this;
        }

        public Criteria andFamcNotIn(List<BigDecimal> values) {
            addCriterion("famc not in", values, "famc");
            return (Criteria) this;
        }

        public Criteria andFamcBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("famc between", value1, value2, "famc");
            return (Criteria) this;
        }

        public Criteria andFamcNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("famc not between", value1, value2, "famc");
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