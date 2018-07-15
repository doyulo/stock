package cn.stock.service.alyz;

import cn.stock.model.RaskAlyz;

import java.math.BigDecimal;
import java.util.List;

public interface AlyzyInf {
    BigDecimal mockDeal(List<RaskAlyz> raskAlyzs);
}
