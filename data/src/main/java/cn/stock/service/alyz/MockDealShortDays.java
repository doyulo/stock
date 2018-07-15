package cn.stock.service.alyz;

import cn.stock.model.RaskAlyz;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class MockDealShortDays {

    public BigDecimal mockDeal(List<RaskAlyz> raskAlyzs){
        BigDecimal init_capital = new BigDecimal(100000);

        BigDecimal capital = init_capital;

        int hold_qty = 0;
        boolean is_hold= false;

        int postiveDays = 15;

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

            if(!is_hold){

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    if(raskAlyz.getDealDate().equals(sdf.parse("2018-01-31"))){
                        System.out.println();
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                if(postiveDays<15&&high_risk_days>15){
                    is_hold = (slope>=0&&slope-pre_slope>160&&pre_slope<100)||(slope<-380&&rate>-9.9);

                    if(is_hold){
                        hold_qty = capital.divide(raskAlyz.getCurPri(),BigDecimal.ROUND_DOWN).intValue();
                        capital = capital.subtract(raskAlyz.getCurPri().multiply(new BigDecimal(hold_qty)));
                    }
                }
            }else{

                boolean shoudSell = slope<0||(pre_slope-slope>100&&slope<100);

                if(shoudSell){
                    is_hold = false;
                    capital = capital.add(raskAlyz.getCurPri().multiply(new BigDecimal(hold_qty)).multiply(new BigDecimal(0.997)).setScale(2,BigDecimal.ROUND_HALF_UP));
                    hold_qty = 0;
                }
            }

            raskAlyz.setHold(is_hold);

            BigDecimal amt = capital.add(raskAlyz.getCurPri().multiply(new BigDecimal(hold_qty)).multiply(new BigDecimal(0.997)).setScale(2,BigDecimal.ROUND_HALF_UP));

            raskAlyz.setRemark(amt.toString());

        }

        BigDecimal amt = capital.add(raskAlyzs.get(raskAlyzs.size()-1).getCurPri().multiply(new BigDecimal(hold_qty)).multiply(new BigDecimal(0.997)).setScale(2,BigDecimal.ROUND_HALF_UP));
        return amt.subtract(init_capital).divide(init_capital,2,BigDecimal.ROUND_HALF_UP);
    }


}
