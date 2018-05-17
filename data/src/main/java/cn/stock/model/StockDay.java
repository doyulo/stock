package cn.stock.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class StockDay implements Serializable{
    private Integer id;

    private String code;

    private String name;

    private BigDecimal beginPri;

    private BigDecimal maxPri;

    private BigDecimal minPri;

    private BigDecimal prePri;

    private BigDecimal curPri;

    private Long dealQty;

    private BigDecimal dealAmt;

    private BigDecimal rate;

    private BigDecimal rateRange;

    private BigDecimal inOutRate;

    private Date curDate;

    private BigDecimal marketCap;

    private BigDecimal famc;

    public StockDay(Integer id, String code, String name, BigDecimal beginPri, BigDecimal maxPri, BigDecimal minPri, BigDecimal prePri, BigDecimal curPri, Long dealQty, BigDecimal dealAmt, BigDecimal rate, BigDecimal rateRange, BigDecimal inOutRate, Date curDate, BigDecimal marketCap, BigDecimal famc) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.beginPri = beginPri;
        this.maxPri = maxPri;
        this.minPri = minPri;
        this.prePri = prePri;
        this.curPri = curPri;
        this.dealQty = dealQty;
        this.dealAmt = dealAmt;
        this.rate = rate;
        this.rateRange = rateRange;
        this.inOutRate = inOutRate;
        this.curDate = curDate;
        this.marketCap = marketCap;
        this.famc = famc;
    }

    public StockDay() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public BigDecimal getBeginPri() {
        return beginPri;
    }

    public void setBeginPri(BigDecimal beginPri) {
        this.beginPri = beginPri;
    }

    public BigDecimal getMaxPri() {
        return maxPri;
    }

    public void setMaxPri(BigDecimal maxPri) {
        this.maxPri = maxPri;
    }

    public BigDecimal getMinPri() {
        return minPri;
    }

    public void setMinPri(BigDecimal minPri) {
        this.minPri = minPri;
    }

    public BigDecimal getPrePri() {
        return prePri;
    }

    public void setPrePri(BigDecimal prePri) {
        this.prePri = prePri;
    }

    public BigDecimal getCurPri() {
        return curPri;
    }

    public void setCurPri(BigDecimal curPri) {
        this.curPri = curPri;
    }

    public Long getDealQty() {
        return dealQty;
    }

    public void setDealQty(Long dealQty) {
        this.dealQty = dealQty;
    }

    public BigDecimal getDealAmt() {
        return dealAmt;
    }

    public void setDealAmt(BigDecimal dealAmt) {
        this.dealAmt = dealAmt;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getRateRange() {
        return rateRange;
    }

    public void setRateRange(BigDecimal rateRange) {
        this.rateRange = rateRange;
    }

    public BigDecimal getInOutRate() {
        return inOutRate;
    }

    public void setInOutRate(BigDecimal inOutRate) {
        this.inOutRate = inOutRate;
    }

    public Date getCurDate() {
        return curDate;
    }

    public void setCurDate(Date curDate) {
        this.curDate = curDate;
    }

    public BigDecimal getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(BigDecimal marketCap) {
        this.marketCap = marketCap;
    }

    public BigDecimal getFamc() {
        return famc;
    }

    public void setFamc(BigDecimal famc) {
        this.famc = famc;
    }

    @Override
    public String toString() {
        return "StockDay{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", beginPri=" + beginPri +
                ", maxPri=" + maxPri +
                ", minPri=" + minPri +
                ", prePri=" + prePri +
                ", curPri=" + curPri +
                ", dealQty=" + dealQty +
                ", dealAmt=" + dealAmt +
                ", rate=" + rate +
                ", rateRange=" + rateRange +
                ", inOutRate=" + inOutRate +
                ", curDate=" + curDate +
                ", marketCap=" + marketCap +
                ", famc=" + famc +
                '}';
    }
}