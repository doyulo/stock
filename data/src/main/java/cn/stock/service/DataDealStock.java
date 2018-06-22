package cn.stock.service;

import cn.stock.dao.StockDayMapper;
import cn.stock.model.StockDay;
import com.csvreader.CsvReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataDealStock {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StockDayMapper stockDayMapper;
    @Autowired
    private DataAsyn dataAsyn;

    final private String APPLICATION_CSV = "application/csv";

    private SimpleDateFormat dateSdf = new SimpleDateFormat("yyyy-MM-dd");



    /**
     * 分日成交
     * @param code
     * @param startDate
     * @param endDate
     * @throws IOException
     */
    @Transactional
    public Integer parseCsvToDatabase(String code,String startDate,String endDate) throws IOException {

        System.out.println(code+"================================================");

        HttpHeaders headers = new HttpHeaders();
        InputStream inputStream = null;
        List list = new ArrayList<>();
        list.add(MediaType.valueOf(APPLICATION_CSV));
        headers.setAccept(list);

        String qc;

        if(code.startsWith("sz")){
            qc = code.replace("sz","1");
        }else{
            qc = code.replace("sh","0");
        }

        ResponseEntity<byte[]> response = restTemplate.exchange(
                "http://quotes.money.163.com/service/chddata.html?code="+qc+"&start="+startDate+"&end="+endDate+"&fields=TCLOSE;HIGH;LOW;TOPEN;LCLOSE;CHG;PCHG;TURNOVER;VOTURNOVER;VATURNOVER;TCAP;MCAP",
                HttpMethod.GET,
                new HttpEntity<byte[]>(headers),
                byte[].class);

        byte[] result = response.getBody();

        inputStream = new ByteArrayInputStream(result);

        CsvReader reader = new CsvReader(new InputStreamReader(inputStream,"gbk"));
        reader.readHeaders();

        List<StockDay> stockDays = new ArrayList<>();
        while (reader.readRecord()) {
            System.out.println(reader.getRawRecord());
            String[] values = reader.getValues();
            StockDay stockDay = new StockDay();
            try {
                stockDay.setCurDate(dateSdf.parse(values[0]));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            stockDay.setCode(code);
            stockDay.setName(values[2]);
            stockDay.setCurPri(new BigDecimal(values[3]));
            stockDay.setMaxPri(new BigDecimal(values[4]));
            stockDay.setMinPri(new BigDecimal(values[5]));
            stockDay.setBeginPri(new BigDecimal(values[6]));
            stockDay.setPrePri(new BigDecimal(values[7]));
            if("None".equals(values[9])){
                stockDay.setRate(BigDecimal.ZERO);
            }else{
                stockDay.setRate(new BigDecimal(values[9]));
                if(stockDay.getRate().compareTo(new BigDecimal("999.99"))>0){
                    stockDay.setRate(new BigDecimal("999.99"));
                }
            }
            if("None".equals(values[10])){
                stockDay.setInOutRate(BigDecimal.ZERO);
            }else{
                Double doubles = Double.valueOf(values[10]);
                if(doubles.compareTo(99.99)>0){
                    doubles = 99.99;
                }
                stockDay.setInOutRate(new BigDecimal(doubles));
            }
            if("None".equals(values[11])){
                stockDay.setDealQty(0L);
            }else{
                stockDay.setDealQty(Long.parseLong(values[11]));
            }
            stockDay.setDealAmt(new BigDecimal(values[12]));
            stockDay.setMarketCap(new BigDecimal(values[13]));
            stockDay.setFamc(new BigDecimal(values[14]));
            BigDecimal rateRange;
            if(stockDay.getBeginPri().compareTo(BigDecimal.ZERO)==0){
                rateRange = BigDecimal.ZERO;
            }else{
                rateRange = stockDay.getMaxPri().subtract(stockDay.getMinPri()).multiply(new BigDecimal(100))
                        .divide(stockDay.getBeginPri(),2,BigDecimal.ROUND_HALF_UP);
            }
            stockDay.setRateRange(rateRange);
            stockDays.add(stockDay);
//            stockDayMapper.insertSelective(stockDay);
        }
        /*if(stockDays.size()>3200){
            stockDayMapper.insertAll(stockDays.subList(0, 3200));
            stockDayMapper.insertAll(stockDays.subList(3200,stockDays.size()));
        }else if(stockDays.size()>0){
        }*/
        reader.close();
        if(stockDays.size()>0){
            Integer count = stockDayMapper.insertAll(stockDays);
            return count;
        }
        return null;
    }
}
