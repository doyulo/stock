package cn.stock.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DealDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DealDetailExample() {
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

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
        }

        public Criteria andIdDealDetailIsNull() {
            addCriterion("id_deal_detail is null");
            return (Criteria) this;
        }

        public Criteria andIdDealDetailIsNotNull() {
            addCriterion("id_deal_detail is not null");
            return (Criteria) this;
        }

        public Criteria andIdDealDetailEqualTo(Integer value) {
            addCriterion("id_deal_detail =", value, "idDealDetail");
            return (Criteria) this;
        }

        public Criteria andIdDealDetailNotEqualTo(Integer value) {
            addCriterion("id_deal_detail <>", value, "idDealDetail");
            return (Criteria) this;
        }

        public Criteria andIdDealDetailGreaterThan(Integer value) {
            addCriterion("id_deal_detail >", value, "idDealDetail");
            return (Criteria) this;
        }

        public Criteria andIdDealDetailGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_deal_detail >=", value, "idDealDetail");
            return (Criteria) this;
        }

        public Criteria andIdDealDetailLessThan(Integer value) {
            addCriterion("id_deal_detail <", value, "idDealDetail");
            return (Criteria) this;
        }

        public Criteria andIdDealDetailLessThanOrEqualTo(Integer value) {
            addCriterion("id_deal_detail <=", value, "idDealDetail");
            return (Criteria) this;
        }

        public Criteria andIdDealDetailIn(List<Integer> values) {
            addCriterion("id_deal_detail in", values, "idDealDetail");
            return (Criteria) this;
        }

        public Criteria andIdDealDetailNotIn(List<Integer> values) {
            addCriterion("id_deal_detail not in", values, "idDealDetail");
            return (Criteria) this;
        }

        public Criteria andIdDealDetailBetween(Integer value1, Integer value2) {
            addCriterion("id_deal_detail between", value1, value2, "idDealDetail");
            return (Criteria) this;
        }

        public Criteria andIdDealDetailNotBetween(Integer value1, Integer value2) {
            addCriterion("id_deal_detail not between", value1, value2, "idDealDetail");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Integer value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Integer value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Integer value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Integer value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Integer> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Integer> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Integer value1, Integer value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andDealTimeIsNull() {
            addCriterion("deal_time is null");
            return (Criteria) this;
        }

        public Criteria andDealTimeIsNotNull() {
            addCriterion("deal_time is not null");
            return (Criteria) this;
        }

        public Criteria andDealTimeEqualTo(Date value) {
            addCriterionForJDBCTime("deal_time =", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("deal_time <>", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("deal_time >", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("deal_time >=", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLessThan(Date value) {
            addCriterionForJDBCTime("deal_time <", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("deal_time <=", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeIn(List<Date> values) {
            addCriterionForJDBCTime("deal_time in", values, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("deal_time not in", values, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("deal_time between", value1, value2, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("deal_time not between", value1, value2, "dealTime");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceDiffIsNull() {
            addCriterion("price_diff is null");
            return (Criteria) this;
        }

        public Criteria andPriceDiffIsNotNull() {
            addCriterion("price_diff is not null");
            return (Criteria) this;
        }

        public Criteria andPriceDiffEqualTo(BigDecimal value) {
            addCriterion("price_diff =", value, "priceDiff");
            return (Criteria) this;
        }

        public Criteria andPriceDiffNotEqualTo(BigDecimal value) {
            addCriterion("price_diff <>", value, "priceDiff");
            return (Criteria) this;
        }

        public Criteria andPriceDiffGreaterThan(BigDecimal value) {
            addCriterion("price_diff >", value, "priceDiff");
            return (Criteria) this;
        }

        public Criteria andPriceDiffGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price_diff >=", value, "priceDiff");
            return (Criteria) this;
        }

        public Criteria andPriceDiffLessThan(BigDecimal value) {
            addCriterion("price_diff <", value, "priceDiff");
            return (Criteria) this;
        }

        public Criteria andPriceDiffLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price_diff <=", value, "priceDiff");
            return (Criteria) this;
        }

        public Criteria andPriceDiffIn(List<BigDecimal> values) {
            addCriterion("price_diff in", values, "priceDiff");
            return (Criteria) this;
        }

        public Criteria andPriceDiffNotIn(List<BigDecimal> values) {
            addCriterion("price_diff not in", values, "priceDiff");
            return (Criteria) this;
        }

        public Criteria andPriceDiffBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_diff between", value1, value2, "priceDiff");
            return (Criteria) this;
        }

        public Criteria andPriceDiffNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_diff not between", value1, value2, "priceDiff");
            return (Criteria) this;
        }

        public Criteria andQtyIsNull() {
            addCriterion("qty is null");
            return (Criteria) this;
        }

        public Criteria andQtyIsNotNull() {
            addCriterion("qty is not null");
            return (Criteria) this;
        }

        public Criteria andQtyEqualTo(Integer value) {
            addCriterion("qty =", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyNotEqualTo(Integer value) {
            addCriterion("qty <>", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyGreaterThan(Integer value) {
            addCriterion("qty >", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyGreaterThanOrEqualTo(Integer value) {
            addCriterion("qty >=", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyLessThan(Integer value) {
            addCriterion("qty <", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyLessThanOrEqualTo(Integer value) {
            addCriterion("qty <=", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyIn(List<Integer> values) {
            addCriterion("qty in", values, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyNotIn(List<Integer> values) {
            addCriterion("qty not in", values, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyBetween(Integer value1, Integer value2) {
            addCriterion("qty between", value1, value2, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyNotBetween(Integer value1, Integer value2) {
            addCriterion("qty not between", value1, value2, "qty");
            return (Criteria) this;
        }

        public Criteria andAmtIsNull() {
            addCriterion("amt is null");
            return (Criteria) this;
        }

        public Criteria andAmtIsNotNull() {
            addCriterion("amt is not null");
            return (Criteria) this;
        }

        public Criteria andAmtEqualTo(BigDecimal value) {
            addCriterion("amt =", value, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtNotEqualTo(BigDecimal value) {
            addCriterion("amt <>", value, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtGreaterThan(BigDecimal value) {
            addCriterion("amt >", value, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amt >=", value, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtLessThan(BigDecimal value) {
            addCriterion("amt <", value, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amt <=", value, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtIn(List<BigDecimal> values) {
            addCriterion("amt in", values, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtNotIn(List<BigDecimal> values) {
            addCriterion("amt not in", values, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amt between", value1, value2, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amt not between", value1, value2, "amt");
            return (Criteria) this;
        }

        public Criteria andSignIsNull() {
            addCriterion("sign is null");
            return (Criteria) this;
        }

        public Criteria andSignIsNotNull() {
            addCriterion("sign is not null");
            return (Criteria) this;
        }

        public Criteria andSignEqualTo(Short value) {
            addCriterion("sign =", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotEqualTo(Short value) {
            addCriterion("sign <>", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThan(Short value) {
            addCriterion("sign >", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThanOrEqualTo(Short value) {
            addCriterion("sign >=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThan(Short value) {
            addCriterion("sign <", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThanOrEqualTo(Short value) {
            addCriterion("sign <=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignIn(List<Short> values) {
            addCriterion("sign in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotIn(List<Short> values) {
            addCriterion("sign not in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignBetween(Short value1, Short value2) {
            addCriterion("sign between", value1, value2, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotBetween(Short value1, Short value2) {
            addCriterion("sign not between", value1, value2, "sign");
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