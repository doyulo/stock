package cn.stock.service.alyz;

import cn.stock.dao.RaskAlyzMapper;
import cn.stock.dao.StockDayMapper;
import cn.stock.model.*;
import cn.stock.service.DataBuffer;
import cn.stock.service.StockURLDataBuffer;
import cn.stock.service.TencentDataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class Alyz {
    @Autowired
    private RaskAlyzMapper raskAlyzMapper;
    @Autowired
    private StockDayMapper stockDayMapper;
    @Autowired
    private TencentDataFetcher dataFetcher;
    @Autowired
    private MockDealShortDays mockDealShortDays;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyyMMdd");

    public void saveAlyzWeight(String code){
        List<RaskAlyz> raskAlyzs = alyzWeight(code);

        if (raskAlyzs!=null&&raskAlyzs.size()!=0){
            raskAlyzMapper.insertAll(raskAlyzs);
        }

    }

    public List<RaskAlyz> alyzWeight(String code){
        return alyzWeight(code,false);
    }


    public List<RaskAlyz> alyzWeight(String code,boolean now){
        Date earlier_day = null;
        try {
            earlier_day  = simpleDateFormat.parse("2014-01-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date curDealDate = new Date();

        try {
            curDealDate = simpleDateFormat2.parse(dataFetcher.getLastDealDay());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        StockDayExample stockDayExample = new StockDayExample();
        stockDayExample.createCriteria().andCodeEqualTo(code).andCurDateGreaterThan(earlier_day)
                .andCurPriNotEqualTo(BigDecimal.ZERO).andMarketCapNotEqualTo(BigDecimal.ZERO)
                .andCurDateLessThan(curDealDate);
        stockDayExample.setOrderByClause(" cur_date asc");
        stockDayExample.setStart(20);
        List<StockDay> stockDays = stockDayMapper.selectByExample(stockDayExample);

        if(stockDays.size()>650){
            stockDays = stockDays.subList(stockDays.size()-600,stockDays.size());
        }

        if(stockDays.size()<30){
            return null;
        }

        if(now){
            TimeStock timeStock = DataBuffer.getTimeStockMap().get(code);
            if(!timeStock.getCurPri().equals(BigDecimal.ZERO)&&!timeStock.getMarketCap().equals(BigDecimal.ZERO)){
                stockDays.add(timeStock);
            }
        }

        WeightAlyz weightAlyz = new WeightAlyz();

        List<RaskAlyz> raskAlyzs = weightAlyz.alyzOneStock(stockDays);

        BigDecimal profit = mockDealShortDays.mockDeal(raskAlyzs);
        System.out.println(code+"利润："+profit.toString());

        return raskAlyzs;
    }


    public void reAlyzWeight(String code){
        RaskAlyzExample raskAlyzExample = new RaskAlyzExample();
        raskAlyzExample.createCriteria().andCodeEqualTo(code);
        raskAlyzMapper.deleteByExample(raskAlyzExample);
        saveAlyzWeight(code);

    }

    public void reAlyzWeight(){

        RaskAlyzExample raskAlyzExample = new RaskAlyzExample();
        raskAlyzMapper.deleteByExample(raskAlyzExample);

        dataFetcher.filterAviableCodesToBuffer();
        HashMap<String, String> data = StockURLDataBuffer.getData();
        Set<String> codeSet = data.keySet();
        List<String> codeList = new ArrayList<>(codeSet);
        Collections.sort(codeList);

        for (String code : codeList) {
            saveAlyzWeight(code);
        }

    }

    public Set<String> alyzWeightNow(boolean isAll){
        Set<String> codeSet = new HashSet<>();
        Date lastAlyzDay = raskAlyzMapper.getLastAlyzDay();

        //判断是否已保存结果
        Date curDealDate ;
        try {
            curDealDate = simpleDateFormat2.parse(dataFetcher.getLastDealDay());
            if(lastAlyzDay.equals(curDealDate)){
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(curDealDate);
                calendar.add(Calendar.DATE, -1);
                lastAlyzDay = calendar.getTime();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        RaskAlyzExample raskAlyzExample = new RaskAlyzExample();
        raskAlyzExample.createCriteria().andDealDateEqualTo(lastAlyzDay);
        List<RaskAlyz> raskAlyzs = raskAlyzMapper.selectByExample(raskAlyzExample);
        WeightAlyz weightAlyz = new WeightAlyz();
        for (RaskAlyz pre_raskAlyz : raskAlyzs) {
            RaskAlyz raskAlyz = weightAlyz.initRaskAlyz(pre_raskAlyz, DataBuffer.getTimeStockMap().get(pre_raskAlyz.getCode()));
            mockDealShortDays.mockDeal(pre_raskAlyz,raskAlyz);
            if(raskAlyz.getHold()){
                if(isAll){
                    codeSet.add(raskAlyz.getCode());
                }else if(!pre_raskAlyz.getHold()){
                    codeSet.add(raskAlyz.getCode());
                }
            }
        }
        return codeSet;
    }

    public void saveWeightNowAll(){
        Collection<TimeStock> values = DataBuffer.getTimeStockMap().values();

        Date curDealDate = new Date();
        try {
            curDealDate = simpleDateFormat2.parse(dataFetcher.getLastDealDay());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        StockDayExample stockDayExample = new StockDayExample();
        stockDayExample.createCriteria().andCurDateEqualTo(curDealDate);
        stockDayMapper.deleteByExample(stockDayExample);

        for (TimeStock ts : values) {
            ts.setCurDate(curDealDate);
            stockDayMapper.insertSelective(ts);
        }

        Date lastAlyzDay = raskAlyzMapper.getLastAlyzDay();
        RaskAlyzExample raskAlyzExample = new RaskAlyzExample();
        raskAlyzExample.createCriteria().andDealDateEqualTo(lastAlyzDay);
        List<RaskAlyz> raskAlyzs = raskAlyzMapper.selectByExample(raskAlyzExample);
        WeightAlyz weightAlyz = new WeightAlyz();
        List<RaskAlyz> raskAlyzsNow = new ArrayList<>();

        for (RaskAlyz pre_raskAlyz : raskAlyzs) {
            RaskAlyz raskAlyz = weightAlyz.initRaskAlyz(pre_raskAlyz, DataBuffer.getTimeStockMap().get(pre_raskAlyz.getCode()));
            mockDealShortDays.mockDeal(pre_raskAlyz, raskAlyz);
            raskAlyzsNow.add(raskAlyz);
        }
        if(raskAlyzsNow.size()>0){
            raskAlyzMapper.insertAll(raskAlyzsNow);
        }
    }

}
