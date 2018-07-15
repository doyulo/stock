package cn.stock.service.alyz;

import cn.stock.model.RaskAlyz;
import cn.stock.model.StockDay;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WeightAlyz {
    private double weigth = 0.485;
    private double weigth1 = 0.73;
    private double weigth2 = 0.99;

    private double negtive_rate = -6;
    private int negtive_rate_days = 5;
    private int high_risk_scope = 125;
    private int high_risk_days = 20;

    public WeightAlyz(double weigth, double weigth1, double weigth2) {
        this.weigth = weigth;
        this.weigth1 = weigth1;
        this.weigth2 = weigth2;
    }

    public WeightAlyz() {
    }

    public List<RaskAlyz> alyzOneStock(List<StockDay> stockDays){
        List<RaskAlyz> raskAlyzs = new ArrayList<>();

        double tempAviPri = stockDays.get(0).getMarketCap().doubleValue()/100000000;
        double tempAviPri1 = stockDays.get(0).getMarketCap().doubleValue()/100000000;
        double tempAviPri2 = stockDays.get(0).getMarketCap().doubleValue()/100000000;

        for (int i = 1; i < stockDays.size(); i++) {
            StockDay stock = stockDays.get(i);
            double curPri = stock.getMarketCap().doubleValue()/100000000;

            RaskAlyz raskAlyz = new RaskAlyz();

            double avr_pri = curPri*(1-weigth)+tempAviPri*weigth;
            double avr_pri1 = curPri*(1-weigth1)+tempAviPri1*weigth1;
            double avr_pri2 = curPri*(1-weigth2)+tempAviPri2*weigth2;

            int slope = (int) ((avr_pri-tempAviPri)*10000/tempAviPri);
            int slope1 = (int) ((avr_pri1-tempAviPri1)*10000/tempAviPri1);
            int slope2 = (int) ((avr_pri2-tempAviPri2)*10000/tempAviPri2);

            tempAviPri = avr_pri;
            tempAviPri1 = avr_pri1;
            tempAviPri2 = avr_pri2;


            raskAlyz.setAvrPri(new BigDecimal(tempAviPri).setScale(2,BigDecimal.ROUND_HALF_UP));
            raskAlyz.setAvrPri1(new BigDecimal(tempAviPri1).setScale(2,BigDecimal.ROUND_HALF_UP));
            raskAlyz.setAvrPri2(new BigDecimal(tempAviPri2).setScale(2,BigDecimal.ROUND_HALF_UP));

            raskAlyz.setSlope(slope);
            raskAlyz.setSlope1(slope1);
            raskAlyz.setSlope2(slope2);

            raskAlyz.setCode(stock.getCode());
            raskAlyz.setName(stock.getName());
            raskAlyz.setCurPri(new BigDecimal(curPri).setScale(2,BigDecimal.ROUND_HALF_UP));
            raskAlyz.setRate(stock.getRate());
            raskAlyz.setDealDate(stock.getCurDate());
            raskAlyz.setHold(false);
            raskAlyz.setRemark("xx");

            raskAlyzs.add(raskAlyz);

//            alyzWeightActualTime(raskAlyzs);
        }

        return raskAlyzs;
    }

    public void alyzWeightActualTime(List<RaskAlyz> raskAlyzs){

        RaskAlyz lastRaskAlyz = raskAlyzs.get(raskAlyzs.size() - 1);
        RaskAlyz raskAlyz = new RaskAlyz();

        double tempAviPri = lastRaskAlyz.getAvrPri().doubleValue();
        double tempAviPri1 = lastRaskAlyz.getAvrPri1().doubleValue();
        double tempAviPri2 = lastRaskAlyz.getAvrPri2().doubleValue();
        JSONArray arr = new JSONArray();

        int negtiveToDays = 100;
        int high_risk_days=50;
        int ordinary_line_days = 0;

        for (int i = raskAlyzs.size()-1; i >= 0; i--) {
            if(raskAlyzs.get(i).getRate().compareTo(new BigDecimal(negtive_rate))<0){
                negtiveToDays = raskAlyzs.size()-1-i;
                break;
            }
        }

        for (int i = raskAlyzs.size()-1; i >= 0; i--) {

            if(raskAlyzs.get(i).getSlope2().compareTo(high_risk_scope)>0){
                high_risk_days = raskAlyzs.size()-1-i;
                break;
            }
        }

        for (int i = raskAlyzs.size()-1; i >= 0; i--) {

            int abs_scope = Math.abs(lastRaskAlyz.getSlope2());

            if(abs_scope<10){
                ordinary_line_days++;
            }else{
                break;
            }
        }

        for (int i = -10; i < 11; i++) {
            BeanUtils.copyProperties(lastRaskAlyz,raskAlyz);
            double curPri = lastRaskAlyz.getCurPri().doubleValue()*(1.0d+((double) i)/100);

            double avr_pri = curPri*(1-weigth)+tempAviPri*weigth;
            double avr_pri1 = curPri*(1-weigth1)+tempAviPri1*weigth1;
            double avr_pri2 = curPri*(1-weigth2)+tempAviPri2*weigth2;

            int slope = (int) ((avr_pri-tempAviPri)*10000/tempAviPri);
            int slope1 = (int) ((avr_pri1-tempAviPri1)*10000/tempAviPri1);
            int slope2 = (int) ((avr_pri2-tempAviPri2)*10000/tempAviPri2);

            raskAlyz.setRate(new BigDecimal(i));
            raskAlyz.setCurPri(new BigDecimal(curPri));
            raskAlyz.setAvrPri(new BigDecimal(avr_pri));
            raskAlyz.setAvrPri1(new BigDecimal(avr_pri1));
            raskAlyz.setAvrPri2(new BigDecimal(avr_pri2));
            raskAlyz.setSlope(slope);
            raskAlyz.setSlope1(slope1);
            raskAlyz.setSlope2(slope2);

            deal(lastRaskAlyz,raskAlyz,negtiveToDays,high_risk_days,ordinary_line_days);

            if(!raskAlyz.getHold().equals(lastRaskAlyz.getHold())){
                arr.add(i);

            }

        }
        lastRaskAlyz.setReversalRate(arr.toString());
    }

    public BigDecimal mockDeal(List<RaskAlyz> raskAlyzs){
        BigDecimal init_capital = new BigDecimal(100000);

        BigDecimal capital = init_capital;

        int hold_qty = 0;

        int negtiveToDays = 10;
        int high_risk_days=50;
        int ordinary_line_days = 0;

        for (int i = 30; i < raskAlyzs.size(); i++) {
            RaskAlyz pre_raskAlyz = raskAlyzs.get(i-1);
            RaskAlyz raskAlyz = raskAlyzs.get(i);
            raskAlyz.setHold(pre_raskAlyz.getHold());

            int pre_slope = pre_raskAlyz.getSlope();
            int pre_slope1 = pre_raskAlyz.getSlope1();
            int pre_slope2 = pre_raskAlyz.getSlope2();
            double pre_rate = pre_raskAlyz.getRate().doubleValue();

            int slope = raskAlyz.getSlope();
            int slope1 = raskAlyz.getSlope1();
            int slope2 = raskAlyz.getSlope2();
            double rate = raskAlyz.getRate().doubleValue();

            int abs_scope = Math.abs(pre_raskAlyz.getSlope2());

            if(abs_scope<10){
                ordinary_line_days++;
            }else {
                ordinary_line_days = 0;
            }

            if(rate<negtive_rate){
                negtiveToDays = 0;
            }else {
                negtiveToDays++;
            }

            if(slope2>this.high_risk_scope){
                high_risk_days=0;
            }

            high_risk_days++;

            deal(pre_raskAlyz,raskAlyz,negtiveToDays,high_risk_days,ordinary_line_days);

            if(!pre_raskAlyz.getHold()){

                if(raskAlyz.getHold()){
                    hold_qty = capital.divide(raskAlyz.getCurPri(),BigDecimal.ROUND_DOWN).intValue();
                    capital = capital.subtract(raskAlyz.getCurPri().multiply(new BigDecimal(hold_qty)));
                }
            }else{

                if((!raskAlyz.getHold())){
                    capital = capital.add(raskAlyz.getCurPri().multiply(new BigDecimal(hold_qty)).multiply(new BigDecimal(0.997)).setScale(2,BigDecimal.ROUND_HALF_UP));
                    hold_qty = 0;
                }
            }
            BigDecimal amt = capital.add(raskAlyz.getCurPri().multiply(new BigDecimal(hold_qty)).multiply(new BigDecimal(0.997)).setScale(2,BigDecimal.ROUND_HALF_UP));
            if("xx".equals(raskAlyz.getRemark()))
                raskAlyz.setRemark(amt.toString());

            alyzWeightActualTime(raskAlyzs.subList(0,i+1));
        }

        BigDecimal amt = capital.add(raskAlyzs.get(raskAlyzs.size()-1).getCurPri().multiply(new BigDecimal(hold_qty)).multiply(new BigDecimal(0.997)).setScale(2,BigDecimal.ROUND_HALF_UP));
        return amt.subtract(init_capital).divide(init_capital,2,BigDecimal.ROUND_HALF_UP);
    }

    private void deal(RaskAlyz pre_raskAlyz,RaskAlyz raskAlyz,int negtiveToDays,int highRiskDays,int ordinary_line_days){

        int pre_slope = pre_raskAlyz.getSlope();
        int pre_slope1 = pre_raskAlyz.getSlope1();
        int pre_slope2 = pre_raskAlyz.getSlope2();
        double pre_rate = pre_raskAlyz.getRate().doubleValue();

        int slope = raskAlyz.getSlope();
        int slope1 = raskAlyz.getSlope1();
        int slope2 = raskAlyz.getSlope2();
        double rate = raskAlyz.getRate().doubleValue();

        boolean abs_not = (negtiveToDays<this.negtive_rate_days&&slope2<20)||(rate<-9.9)||highRiskDays<this.high_risk_days;

        if(!pre_raskAlyz.getHold()){

            boolean should_buy = raskAlyz.getSlope()<-300;

            if(!should_buy){
                should_buy = rate>=6&&ordinary_line_days>50;
            }

            if(!should_buy){
                should_buy = slope>pre_slope&&slope>slope1&&slope1>pre_slope1&slope2>0;
            }

            if(should_buy&&!abs_not){
                raskAlyz.setHold(true);
            }

            if(slope1<-480&&rate>-9.9){
                raskAlyz.setHold(true);
            }

        }else{

            boolean shoud_sell = raskAlyz.getSlope()<raskAlyz.getSlope1()
                    &&raskAlyz.getSlope1()<raskAlyz.getSlope2()
                    &&raskAlyz.getSlope2()>0;

           /* if(!shoud_sell){
                shoud_sell = raskAlyz.getSlope1()+raskAlyz.getSlope2()>600&&rate<9.9;
            }*/

            if(!shoud_sell){
                if(raskAlyz.getSlope()<-10){
                    shoud_sell = true;
                }
            }

            if(!shoud_sell){
                shoud_sell = slope<pre_slope&&slope1<pre_slope1;
            }

            if((shoud_sell||abs_not)){
                raskAlyz.setHold(false);
            }
        }
    }

}
