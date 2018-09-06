package cn.stock.service;

import cn.stock.dao.DealDetailMapper;
import cn.stock.dao.StockDayMapper;
import cn.stock.model.DealDetail;
import jxl.read.biff.BiffException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class DataDeal {

    @Autowired
    private StockDayMapper stockDayMapper;
    @Autowired
    private SinaDataFetcher dataFetcher;
    @Autowired
    private DataDealStock dataDealStock;
    @Autowired
    private DataDealDetail dataDealDetail;
    @Autowired
    private DealDetailMapper dealDetailMapper;

    @Transactional
    public void saveToday()  {

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
        List<String> codeList = new ArrayList<>(codeSet);
        Collections.sort(codeList);

        for (String code : codeList) {
            try {
                dataDealStock.parseCsvToDatabase(code, lastSaveDay, lastDealDay);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    @Transactional
    public void saveAllTimeDeal(String dealDate){
        dataFetcher.filterAviableCodesToBuffer();
        HashMap<String, String> data = StockURLDataBuffer.getData();
        Set<String> codeSet = data.keySet();
        List<String> codeList = new ArrayList<>(codeSet);
        Collections.sort(codeList);

        for (int i = 0; i < codeList.size(); i++) {
            try {
                dataDealDetail.saveDayDetail(codeList.get(i), dealDate);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (BiffException e) {
                e.printStackTrace();
            }
        }

        System.out.println("等待结束");
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void dealBatch(List<DealDetail> lists) {
        int x = dealDetailMapper.insertAll(lists);
        System.out.println("插入："+x);
        lists.clear();
    }


}
