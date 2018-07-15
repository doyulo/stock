package cn.stock.service;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Set;

@Component
public class DataAutoRefresh {

    public void refresh(){
        HashMap<String, String> data = StockURLDataBuffer.getData();
        Set<String> codeSet = data.keySet();

        for (String code : codeSet) {

        }

    }

}
