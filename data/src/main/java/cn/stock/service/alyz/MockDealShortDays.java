package cn.stock.service.alyz;

import cn.stock.model.RaskAlyz;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class MockDealShortDays {

    public BigDecimal mockDeal(List<RaskAlyz> raskAlyzs){
        BigDecimal init_capital = new BigDecimal(100000);

        BigDecimal capital = init_capital;

        int hold_qty = 0;

        for (int i = 30; i < raskAlyzs.size(); i++) {
            RaskAlyz pre_raskAlyz = raskAlyzs.get(i-1);
            RaskAlyz raskAlyz = raskAlyzs.get(i);
            raskAlyz.setHold(pre_raskAlyz.getHold());

            mockDeal(pre_raskAlyz,raskAlyz);


            if(!pre_raskAlyz.getHold()&&raskAlyz.getHold()){
                hold_qty = capital.divide(raskAlyz.getCurPri(),0,BigDecimal.ROUND_DOWN).intValue();
                capital = capital.subtract(raskAlyz.getCurPri().multiply(new BigDecimal(hold_qty)));
            }else if(pre_raskAlyz.getHold()&&!raskAlyz.getHold()){
                capital = capital.add(raskAlyz.getCurPri().multiply(new BigDecimal(hold_qty)).multiply(new BigDecimal(0.997)).setScale(2,BigDecimal.ROUND_HALF_UP));
                hold_qty = 0;
            }

            BigDecimal amt = capital.add(raskAlyz.getCurPri().multiply(new BigDecimal(hold_qty)).multiply(new BigDecimal(0.997)).setScale(2,BigDecimal.ROUND_HALF_UP));

            raskAlyz.setRemark(amt.toString());

        }

        BigDecimal amt = capital.add(raskAlyzs.get(raskAlyzs.size()-1).getCurPri().multiply(new BigDecimal(hold_qty)).multiply(new BigDecimal(0.997)).setScale(2,BigDecimal.ROUND_HALF_UP));
        return amt.subtract(init_capital).divide(init_capital,2,BigDecimal.ROUND_HALF_UP);
    }

    public void mockDeal(RaskAlyz pre_raskAlyz,RaskAlyz raskAlyz){

        int postiveDays = pre_raskAlyz.getPostiveDays()==null?15:pre_raskAlyz.getPostiveDays();

        int negtiveToDays = 10;
        int high_risk_days=pre_raskAlyz.getHighRiskDays()==null?50:pre_raskAlyz.getHighRiskDays();
        int ordinary_line_days = 0;

        raskAlyz.setHold(pre_raskAlyz.getHold());

        int pre_slope = pre_raskAlyz.getSlope();
        int pre_slope1 = pre_raskAlyz.getSlope1();
        int pre_slope2 = pre_raskAlyz.getSlope2();
        double pre_rate = pre_raskAlyz.getRate().doubleValue();

        int slope = raskAlyz.getSlope();
        int slope1 = raskAlyz.getSlope1();
        int slope2 = raskAlyz.getSlope2();
        double rate = raskAlyz.getRate().doubleValue();

        double pre_avr_pri2=pre_raskAlyz.getAvrPri2().doubleValue();
        double avr_pri2=raskAlyz.getAvrPri2().doubleValue();

        if(slope>280){
            postiveDays=0;
        }else{
            postiveDays++;
        }

        if(slope>800||slope2>120){
            high_risk_days = 0;
        }else{
            high_risk_days++;
        }

        raskAlyz.setHighRiskDays(high_risk_days);
        raskAlyz.setPostiveDays(postiveDays);

        if(!pre_raskAlyz.getHold()){
            if(postiveDays<15&&high_risk_days>15){
                boolean is_hold = (slope>=0&&slope-pre_slope>160&&pre_slope<100
                                &&(Math.abs(slope2)<10&&(slope2>pre_slope2))
                                &&(rate<6))
                                ||(slope<-380&&rate>-9.9)
                                ||(pre_slope<-380&&rate>1);

                if(is_hold){
                    raskAlyz.setHold(true);
                }
            }
        }else{

            boolean shoudSell = (slope<0&&rate<0)||(pre_slope-slope>100&&slope<100)
                    ||(rate>3.8&&rate<9.9);

            if(shoudSell){
                raskAlyz.setHold(false);
            }
        }
    }

}
