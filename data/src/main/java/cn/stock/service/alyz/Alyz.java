package cn.stock.service.alyz;

import cn.stock.dao.RaskAlyzMapper;
import cn.stock.dao.StockDayMapper;
import cn.stock.model.RaskAlyz;
import cn.stock.model.RaskAlyzExample;
import cn.stock.model.StockDay;
import cn.stock.model.StockDayExample;
import cn.stock.service.SinaDataFetcher;
import cn.stock.service.StockURLDataBuffer;
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
    private SinaDataFetcher dataFetcher;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public void alyzWeight(String code){
        Date earlier_day = null;
        try {
            earlier_day  = simpleDateFormat.parse("2014-01-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        StockDayExample stockDayExample = new StockDayExample();
        stockDayExample.createCriteria().andCodeEqualTo(code).andCurDateGreaterThan(earlier_day)
                .andCurPriNotEqualTo(BigDecimal.ZERO).andMarketCapNotEqualTo(BigDecimal.ZERO);
        stockDayExample.setOrderByClause(" cur_date asc");
        stockDayExample.setStart(20);
        List<StockDay> stockDays = stockDayMapper.selectByExample(stockDayExample);

        if(stockDays.size()>650){
            stockDays = stockDays.subList(stockDays.size()-600,stockDays.size());
        }

        if(stockDays.size()<30){
            return;
        }

        WeightAlyz weightAlyz = new WeightAlyz();
        MockDealShortDays mockDealShortDays = new MockDealShortDays();

        List<RaskAlyz> raskAlyzs = weightAlyz.alyzOneStock(stockDays);
        BigDecimal profit = mockDealShortDays.mockDeal(raskAlyzs);
        System.out.println(code+"利润："+profit.toString());
//        weightAlyz.alyzWeightActualTime(raskAlyzs);

        raskAlyzMapper.insertAll(raskAlyzs);

    }

    public void reAlyzWeight(String code){
        RaskAlyzExample raskAlyzExample = new RaskAlyzExample();
        raskAlyzExample.createCriteria().andCodeEqualTo(code);
        raskAlyzMapper.deleteByExample(raskAlyzExample);
            alyzWeight(code);

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
            alyzWeight(code);
        }

    }

}