package cn.stock.service;

import cn.stock.model.TimeStock;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
@Order(1)
public class StockInitRunner implements CommandLineRunner {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private TencentDataFetcher tencentDataFetcher;
    @Autowired
    private DataAutoRefresh dataAutoRefresh;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

    @Override
    public void run(String... args) throws Exception {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select code,industry from code_industry_rela");
        for (Map<String, Object> map : maps) {
            DataBuffer.getCodeRelaIndustry().put(map.get("code").toString(),map.get("industry").toString());
        }

        List<String> codeList = jdbcTemplate.queryForList("select distinct code from stock_day where cur_date=(select max(cur_date) from stock_day where cur_date>'2018-07-10')", String.class);
        Set<String> codeSet = new HashSet<>(codeList);
        tencentDataFetcher.fetch(codeSet);

        HashMap<String, String> data = StockURLDataBuffer.getData();
        for (String code : codeSet) {
            String stockStr = data.get(code);
            String[] item = stockStr.split("~");

            if(item.length<49){
                continue;
            }

            if(StringUtils.isEmpty(item[44])){
                continue;
            }

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
            ts.setDealAmt(new BigDecimal(item[37]).multiply(new BigDecimal(10000)));
            ts.setDealQty(Long.parseLong(item[36])*100);
            ts.setFamc(new BigDecimal(item[44]).multiply(new BigDecimal(100000000)));
            ts.setInOutRate(new BigDecimal(item[38]));
            ts.setMarketCap(new BigDecimal(item[45]).multiply(new BigDecimal(100000000)));
            ts.setMaxPri(new BigDecimal(item[33]));
            ts.setMinPri(new BigDecimal(item[34]));
            ts.setPrePri(new BigDecimal(item[4]));
            ts.setRate(new BigDecimal(item[32]));
            ts.setRateRange(new BigDecimal(item[43]));
            DataBuffer.getTimeStockMap().put(code,ts);
        }

        Map<String, String> codeRelaIndustry = DataBuffer.getCodeRelaIndustry();
        for (String code : codeSet) {
            TimeStock timeStock = DataBuffer.getTimeStockMap().get(code);
            String industry = codeRelaIndustry.get(code);
            if(DataBuffer.getIndustryMap().get(industry)==null){
                List<TimeStock> tsList = new ArrayList<>();
                DataBuffer.getIndustryMap().put(industry,tsList);
            }
            DataBuffer.getIndustryMap().get(industry).add(timeStock);
        }
    }
}
