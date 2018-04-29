package cn.stock.service;

import java.util.HashMap;

public class StockURLDataBuffer {
    private static HashMap<String, String> data = new HashMap<>();

    public static HashMap<String, String> getData() {
        return data;
    }

    public static void put(String code,String res){
        synchronized (data) {
            data.put(code, res);
        }
    }

    public static String getUrlData(String code){
        synchronized (data) {
            return data.get(code);
        }
    }
}
