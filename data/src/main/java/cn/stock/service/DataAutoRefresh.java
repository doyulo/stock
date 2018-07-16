package cn.stock.service;

import cn.stock.model.TimeStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class DataAutoRefresh {

    @Autowired
    private TencentDataFetcher tencentDataFetcher;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    /**
     * 0: 未知
     *  1: 股票名字
     *  2: 股票代码
     *  3: 当前价格
     *  4: 昨收
     *  5: 今开
     *  6: 成交量（手）
     *  7: 外盘
     *  8: 内盘
     *  9: 买一
     * 10: 买一量（手）
     * 11-18: 买二 买五
     * 19: 卖一
     * 20: 卖一量
     * 21-28: 卖二 卖五
     * 29: 最近逐笔成交
     * 30: 时间
     * 31: 涨跌
     * 32: 涨跌%
     * 33: 最高
     * 34: 最低
     * 35: 价格/成交量（手）/成交额
     * 36: 成交量（手）
     * 37: 成交额（万）
     * 38: 换手率
     * 39: 市盈率
     * 40:
     * 41: 最高
     * 42: 最低
     * 43: 振幅
     * 44: 流通市值
     * 45: 总市值
     * 46: 市净率
     * 47: 涨停价
     * 48: 跌停价
     */
    @Scheduled(cron = "*/3 * * * * *")
    public void refreshToQQDatabuffer(){
        HashMap<String, String> data = StockURLDataBuffer.getData();
        Set<String> codeSet = data.keySet();

        for (String code : codeSet) {
            String stockStr = data.get(code);
            String[] item = stockStr.split("~");
            TimeStock ts = new TimeStock();
            ts.setBuy1_pri(new BigDecimal(item[9]));
            ts.setBuy1_qty(Integer.parseInt(item[10]));
            ts.setBuy2_pri(new BigDecimal(item[11]));
            ts.setBuy2_qty(Integer.parseInt(item[12]));
            ts.setBuy3_pri(new BigDecimal(item[13]));
            ts.setBuy3_qty(Integer.parseInt(item[14]));
            ts.setBuy4_pri(new BigDecimal(item[15]));
            ts.setBuy4_qty(Integer.parseInt(item[16]));
            ts.setBuy5_pri(new BigDecimal(item[17]));
            ts.setBuy5_qty(Integer.parseInt(item[18]));
            ts.setPb(new BigDecimal(item[46]));
            ts.setPe(new BigDecimal(item[39]));
            ts.setSell1_pri(new BigDecimal(item[19]));
            ts.setSell1_qty(Integer.parseInt(item[20]));
            ts.setSell2_pri(new BigDecimal(item[21]));
            ts.setSell2_qty(Integer.parseInt(item[22]));
            ts.setSell3_pri(new BigDecimal(item[23]));
            ts.setSell3_qty(Integer.parseInt(item[24]));
            ts.setSell4_pri(new BigDecimal(item[25]));
            ts.setSell4_qty(Integer.parseInt(item[26]));
            ts.setSell5_pri(new BigDecimal(item[27]));
            ts.setSell5_qty(Integer.parseInt(item[28]));
            ts.setBeginPri(new BigDecimal(item[5]));
            ts.setCode(code);
            ts.setName(item[1]);
            try {
                ts.setCurDate(sdf.parse(item[30]));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            ts.setCurPri(new BigDecimal(item[3]));
            ts.setDealAmt(new BigDecimal(item[37]));
            ts.setDealQty(Long.parseLong(item[36]));
            ts.setFamc(new BigDecimal(item[44]));
            ts.setInOutRate(new BigDecimal(item[38]));
            ts.setMarketCap(new BigDecimal(item[45]));
            ts.setMaxPri(new BigDecimal(item[33]));
            ts.setMinPri(new BigDecimal(item[34]));
            ts.setPrePri(new BigDecimal(item[4]));
            ts.setRate(new BigDecimal(item[32]));
            ts.setRateRange(new BigDecimal(item[43]));
            DataBuffer.getTimeStockMap().put(code,ts);
        }

    }
    @Scheduled(cron = "*/3 * * * * *")
    public void refreshQQNetData(){
        if(StockURLDataBuffer.getData().size()==0){
            List<String> codeList = jdbcTemplate.queryForList("select distinct code from stock_day where cur_date=(select max(cur_date) from stock_day where cur_date>'2018-07-10')", String.class);
            Set<String> codeSet = new HashSet<>(codeList);
            tencentDataFetcher.fetch(codeSet);
        }else {
            Set<String> codeSet = StockURLDataBuffer.getData().keySet();
            tencentDataFetcher.fetch(codeSet);
        }


    }
}
