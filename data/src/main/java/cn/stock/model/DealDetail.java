package cn.stock.model;

import java.math.BigDecimal;
import java.util.Date;

public class DealDetail {
    private Integer idDealDetail;

    private Integer parentId;

    private Date dealTime;

    private BigDecimal price;

    private BigDecimal priceDiff;

    private Integer qty;

    private BigDecimal amt;

    private Short sign;

    public DealDetail(Integer idDealDetail, Integer parentId, Date dealTime, BigDecimal price, BigDecimal priceDiff, Integer qty, BigDecimal amt, Short sign) {
        this.idDealDetail = idDealDetail;
        this.parentId = parentId;
        this.dealTime = dealTime;
        this.price = price;
        this.priceDiff = priceDiff;
        this.qty = qty;
        this.amt = amt;
        this.sign = sign;
    }

    public DealDetail() {
        super();
    }

    public Integer getIdDealDetail() {
        return idDealDetail;
    }

    public void setIdDealDetail(Integer idDealDetail) {
        this.idDealDetail = idDealDetail;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceDiff() {
        return priceDiff;
    }

    public void setPriceDiff(BigDecimal priceDiff) {
        this.priceDiff = priceDiff;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public BigDecimal getAmt() {
        return amt;
    }

    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }

    public Short getSign() {
        return sign;
    }

    public void setSign(Short sign) {
        this.sign = sign;
    }
}