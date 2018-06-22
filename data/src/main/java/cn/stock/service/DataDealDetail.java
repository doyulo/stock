package cn.stock.service;

import cn.stock.dao.DealDetailMapper;
import cn.stock.dao.StockDayMapper;
import cn.stock.model.DealDetail;
import cn.stock.model.DealDetailExample;
import cn.stock.model.StockDay;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataDealDetail {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StockDayMapper stockDayMapper;
    @Autowired
    private DealDetailMapper dealDetailMapper;
    @Autowired
    private DataAsyn dataAsyn;

    private SimpleDateFormat timeSdf = new SimpleDateFormat("HH:mm:ss");
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    private StockDay stockDay = null;



    private HttpHeaders headers = new HttpHeaders();

    {
        List list = new ArrayList<>();
        list.add(MediaType.valueOf("application/vnd.ms-excel"));
        headers.setAccept(list);
    }

    @Transactional
    public void saveDayDetail(String code, String deal_date) throws IOException, ParseException, BiffException, InterruptedException {

        stockDay = stockDayMapper.getStock(code,sdf.parse(deal_date));
        if(stockDay==null){
            return ;
        }

        DealDetailExample dealDetailExample = new DealDetailExample();
        dealDetailExample.createCriteria().andParentIdEqualTo(stockDay.getId());
        long count = dealDetailMapper.countByExample(dealDetailExample);
        if(count>0){
            return ;
        }

        String qc;

        if(code.startsWith("sz")){
            qc = code.replace("sz","1");
        }else{
            qc = code.replace("sh","0");
        }

        String url = "http://quotes.money.163.com/cjmx/2018/"+deal_date+"/"+qc+".xls";
       /* SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = simpleDateFormat.format(sdf.parse(deal_date));
        String url = "http://market.finance.sina.com.cn/downxls.php?date="+dateStr+"&symbol="+code;*/

        System.out.println(url);
        ResponseEntity<byte[]> response = null;

        int x = 0;

        while (response==null){
            try {
                response = restTemplate.exchange(
                        url,
                        HttpMethod.GET,
                        new HttpEntity<byte[]>(headers),
                        byte[].class);
            }catch (HttpClientErrorException e){
    //            e.printStackTrace();
                Thread.sleep(10000);
                x++;
//                return null;
                if(x>60){
                    e.printStackTrace();
                    return ;
                }
            }

        }

        byte[] result = response.getBody();

//        long l1 = System.currentTimeMillis();

        InputStream inputStream = new ByteArrayInputStream(result);

        Sheet sheet = Workbook.getWorkbook(inputStream).getSheet(0);
        inputStream.close();

        List<DealDetail> dealDetails = new ArrayList<>();

        for (int i = 1; i < sheet.getRows(); i++) {

            Cell[] row = sheet.getRow(i);

            DealDetail dealDetail = new DealDetail();
            dealDetail.setDealTime(timeSdf.parse(row[0].getContents()));
            dealDetail.setParentId(stockDay.getId());
            dealDetail.setPrice(new BigDecimal(row[1].getContents()));
            if("--".equals(row[2].getContents())){
                dealDetail.setPriceDiff(BigDecimal.ZERO);
            }else{

                dealDetail.setPriceDiff(new BigDecimal(row[2].getContents()));
            }
            dealDetail.setQty(Integer.valueOf(row[3].getContents()));
            dealDetail.setAmt(new BigDecimal(row[4].getContents()));
            String sign = row[5].getContents();
            if("买盘".equals(sign)){
                dealDetail.setSign((short)1);
            }else if("卖盘".equals(sign)){
                dealDetail.setSign((short)-1);
            }else {
                dealDetail.setSign((short)0);
            }
            dealDetails.add(dealDetail);
        }

        if(dealDetails.size()!=0){
            dealDetailMapper.insertAll(dealDetails);
//            dataAsyn.insertAllDealDetail(dealDetails);
        }
//        long l2 = System.currentTimeMillis();
//        System.out.println("耗时:"+(l2-l1));
    }


}
