package cn.stock.service;

import cn.stock.dao.DealDetailMapper;
import cn.stock.dao.StockDayMapper;
import cn.stock.model.DealDetail;
import cn.stock.model.DealDetailExample;
import cn.stock.model.StockDay;
import com.csvreader.CsvReader;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class DataDeal {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StockDayMapper stockDayMapper;
    @Autowired
    private DataFetcher dataFetcher;
    @Autowired
    private DealDetailMapper dealDetailMapper;

    final String APPLICATION_CSV = "application/csv";
    private SimpleDateFormat timeSdf = new SimpleDateFormat("HH:mm:ss");
    private SimpleDateFormat dateSdf = new SimpleDateFormat("yyyy-MM-dd");


    /**
     * 分日成交
     * @param code
     * @param startDate
     * @param endDate
     * @throws IOException
     */
    @Async
    public void parseCsvToDatabase(String code,String startDate,String endDate) throws IOException {

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
        if(stockDays.size()>0){
            stockDayMapper.insertAll(stockDays);
        }
        reader.close();
    }

    @Async
    public void saveDayDetail(String code,String deal_date) throws IOException, ParseException, BiffException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        StockDay stockDay = stockDayMapper.getStock(code,sdf.parse(deal_date));
        if(stockDay==null){
            return;
        }

        DealDetailExample dealDetailExample = new DealDetailExample();
        dealDetailExample.createCriteria().andParentIdEqualTo(stockDay.getId());
        long count = dealDetailMapper.countByExample(dealDetailExample);
        if(count>0){
            return;
        }

        HttpHeaders headers = new HttpHeaders();
        InputStream inputStream = null;
        List list = new ArrayList<>();
        list.add(MediaType.valueOf("application/vnd.ms-excel"));
        headers.setAccept(list);

        String qc;

        if(code.startsWith("sz")){
            qc = code.replace("sz","1");
        }else{
            qc = code.replace("sh","0");
        }

        String url = "http://quotes.money.163.com/cjmx/2018/"+deal_date+"/"+qc+".xls";
        System.out.println(url);
        ResponseEntity<byte[]> response = null;

        try {
            response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    new HttpEntity<byte[]>(headers),
                    byte[].class);
        }catch (HttpClientErrorException e){
            e.printStackTrace();
            return;
        }

        byte[] result = response.getBody();

        inputStream = new ByteArrayInputStream(result);

        Workbook wb = Workbook.getWorkbook(inputStream);
        Sheet sheet = wb.getSheet(0);
//        Excel reader = new CsvReader(new InputStreamReader(inputStream,"GBK"));
//        reader.readHeaders();

        List<DealDetail> dealDetails = new ArrayList<>();


        for (int i = 1; i < sheet.getRows(); i++) {
            DealDetail dealDetail = new DealDetail();
            dealDetail.setDealTime(timeSdf.parse(sheet.getCell(0,i).getContents()));
            dealDetail.setParentId(stockDay.getId());
            dealDetail.setPrice(new BigDecimal(sheet.getCell(1,i).getContents()));
            dealDetail.setPriceDiff(new BigDecimal(sheet.getCell(2,i).getContents()));
            dealDetail.setQty(Integer.valueOf(sheet.getCell(3,i).getContents()));
            dealDetail.setAmt(new BigDecimal(sheet.getCell(4,i).getContents()));
            String sign = sheet.getCell(5,i).getContents();
            if("买盘".equals(sign)){
                dealDetail.setSign((short)1);
            }else if("卖盘".equals(sign)){
                dealDetail.setSign((short)-1);
            }else {
                dealDetail.setSign((short)0);
            }
            dealDetails.add(dealDetail);
        }

        if (dealDetails.size()>0){
            dealDetailMapper.insertAll(dealDetails);
        }

    }

    public void saveToday(){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String lastDealDay = dataFetcher.getLastDealDay().replaceAll("-","");

        Date lastSaveDate = stockDayMapper.getLastSaveDay();
        String lastSaveDay;
        if(lastSaveDate==null){
            lastSaveDay = "19900101";
        }else{
            Calendar ca = Calendar.getInstance();
            if(lastDealDay.equals(sdf.format(lastSaveDate))){
                System.out.println("nothing for update!!!");
                return;
            }
            ca.setTime(lastSaveDate);
            ca.add(Calendar.DAY_OF_MONTH,1);
            lastSaveDate = ca.getTime();
            lastSaveDay = sdf.format(lastSaveDate);
        }



        dataFetcher.filterAviableCodesToBuffer();
        HashMap<String, String> data = StockURLDataBuffer.getData();
        Set<String> codeSet = data.keySet();
//        Set<String> codeSet = new HashSet<>();
//        codeSet.add("sz000047");
        for (String code : codeSet) {
            try {
                parseCsvToDatabase(code,lastSaveDay,lastDealDay);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        saveAllTimeDeal("20180521");
        saveAllTimeDeal("20180522");
        saveAllTimeDeal("20180523");
        saveAllTimeDeal("20180524");
        saveAllTimeDeal("20180525");

    }

    public void saveAllTimeDeal(String dealDate){
        dataFetcher.filterAviableCodesToBuffer();
        HashMap<String, String> data = StockURLDataBuffer.getData();
        Set<String> codeSet = data.keySet();
//        Set<String> codeSet = new HashSet<>();
//        codeSet.add("sh000001");
        for (String code : codeSet) {
            try {
//                parseCsvToDatabase(code,"19900101","20200101");
                saveDayDetail(code,dealDate);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (BiffException e) {
                e.printStackTrace();
            }
        }
    }
}
