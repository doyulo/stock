package cn.stock.service;

import cn.stock.dao.DealDetailMapper;
import cn.stock.dao.StockDayMapper;
import cn.stock.model.DealDetail;
import cn.stock.model.StockDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Future;

@Service
public class DataAsyn {

    @Autowired
    private DealDetailMapper dealDetailMapper;
    @Autowired
    private StockDayMapper stockDayMapper;

    @Async
    public Future<Integer> insertAllDealDetail(List<DealDetail> list){
        return new AsyncResult<Integer>( dealDetailMapper.insertAll(list));
    }

    @Async
    public Future<Integer> insertAllStockDay(List<StockDay> list){
        return new AsyncResult<Integer>(stockDayMapper.insertAll(list));
    }

}
