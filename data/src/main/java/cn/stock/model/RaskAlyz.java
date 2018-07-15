package cn.stock.model;

import java.math.BigDecimal;
import java.util.Date;

public class RaskAlyz {
    private Long id;

    private String code;

    private String name;

    private BigDecimal curPri;

    private BigDecimal avrPri;

    private BigDecimal avrPri1;

    private BigDecimal avrPri2;

    private BigDecimal rate;

    private Integer slope;

    private Integer slope1;

    private Integer slope2;

    private Date dealDate;

    private Boolean hold;

    private String reversalRate;

    private String remark;

    public RaskAlyz(Long id, String code, String name, BigDecimal curPri, BigDecimal avrPri, BigDecimal avrPri1, BigDecimal avrPri2, BigDecimal rate, Integer slope, Integer slope1, Integer slope2, Date dealDate, Boolean hold, String reversalRate, String remark) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.curPri = curPri;
        this.avrPri = avrPri;
        this.avrPri1 = avrPri1;
        this.avrPri2 = avrPri2;
        this.rate = rate;
        this.slope = slope;
        this.slope1 = slope1;
        this.slope2 = slope2;
        this.dealDate = dealDate;
        this.hold = hold;
        this.reversalRate = reversalRate;
        this.remark = remark;
    }

    public RaskAlyz() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getCurPri() {
        return curPri;
    }

    public void setCurPri(BigDecimal curPri) {
        this.curPri = curPri;
    }

    public BigDecimal getAvrPri() {
        return avrPri;
    }

    public void setAvrPri(BigDecimal avrPri) {
        this.avrPri = avrPri;
    }

    public BigDecimal getAvrPri1() {
        return avrPri1;
    }

    public void setAvrPri1(BigDecimal avrPri1) {
        this.avrPri1 = avrPri1;
    }

    public BigDecimal getAvrPri2() {
        return avrPri2;
    }

    public void setAvrPri2(BigDecimal avrPri2) {
        this.avrPri2 = avrPri2;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Integer getSlope() {
        return slope;
    }

    public void setSlope(Integer slope) {
        this.slope = slope;
    }

    public Integer getSlope1() {
        return slope1;
    }

    public void setSlope1(Integer slope1) {
        this.slope1 = slope1;
    }

    public Integer getSlope2() {
        return slope2;
    }

    public void setSlope2(Integer slope2) {
        this.slope2 = slope2;
    }

    public Date getDealDate() {
        return dealDate;
    }

    public void setDealDate(Date dealDate) {
        this.dealDate = dealDate;
    }

    public Boolean getHold() {
        return hold;
    }

    public void setHold(Boolean hold) {
        this.hold = hold;
    }

    public String getReversalRate() {
        return reversalRate;
    }

    public void setReversalRate(String reversalRate) {
        this.reversalRate = reversalRate == null ? null : reversalRate.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}