package cn.stock.service;

import cn.stock.model.TimeStock;

import java.util.HashMap;
import java.util.Map;

public class DataBuffer {
    private static Map<String,TimeStock> timeStockMap = new HashMap<>();

    public static Map<String, TimeStock> getTimeStockMap() {
        return timeStockMap;
    }

    public static void setTimeStockMap(Map<String, TimeStock> timeStockMap) {
        DataBuffer.timeStockMap = timeStockMap;
    }
}
