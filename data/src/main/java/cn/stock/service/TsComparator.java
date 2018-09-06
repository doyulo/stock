package cn.stock.service;

import cn.stock.model.TimeStock;

import java.util.Comparator;

public class TsComparator implements Comparator<TimeStock> {

    @Override
    public int compare(TimeStock o1, TimeStock o2) {
        return o2.getRate().compareTo(o1.getRate());
    }
}
