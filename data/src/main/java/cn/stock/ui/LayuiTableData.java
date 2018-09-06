package cn.stock.ui;

import java.io.Serializable;
import java.util.List;

public class LayuiTableData<T> implements Serializable {
    private Integer code = 0;
    private String msg;
    private Integer count=1000;
    private List<T> data;

    public LayuiTableData(List<T> data) {
        this.data = data;
        count = data.size();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
