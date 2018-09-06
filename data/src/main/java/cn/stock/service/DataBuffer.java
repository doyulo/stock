package cn.stock.service;

import cn.stock.model.TimeStock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBuffer {

    private static Map<String,String> codeRelaIndustry = new HashMap<>();

    private static Map<String,TimeStock> timeStockMap = new HashMap<>();

    private static Map<String,List<TimeStock>> industryMap = new HashMap<>();

    public static Map<String, TimeStock> getTimeStockMap() {
        return timeStockMap;
    }

    public static Map<String, List<TimeStock>> getIndustryMap() {
        return industryMap;
    }

    public static Map<String, String> getCodeRelaIndustry() {
        return codeRelaIndustry;
    }
}
