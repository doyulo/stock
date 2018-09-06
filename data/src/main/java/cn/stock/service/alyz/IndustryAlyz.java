package cn.stock.service.alyz;

import cn.stock.model.TimeStock;
import cn.stock.service.DataBuffer;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class IndustryAlyz {
    private String url = "http://nufm.dfcfw.com/EM_Finance2014NumericApplication/JS.aspx?type=CT&token=4f1862fc3b5e77c150a2b985b12db0fd&js=(%7Bdata%3A%5B(x)%5D%2CrecordsTotal%3A(tot)%2CrecordsFiltered%3A(tot)%7D)&sty=FCOIATC&cmd=C.{0}1&st=(ChangePercent)&sr=-1&p={2}&ps={3}&_={1}";

    @Autowired
    private RestTemplate template;

    public List<TimeStock> getStock(String industry_code,Integer pageIndex,Integer count){

        String res = template.getForObject(url,String.class,industry_code,System.currentTimeMillis(),pageIndex,count);

        res = res.replace("(","");
        res = res.replace(")","");

        JSONArray arr = JSONArray.parseArray(res);

        List<TimeStock> list = new ArrayList<>();

        for (Object o : arr) {
            String stock = o.toString();
            String[] item = stock.split(",");
            if(item[0].equals("1")){
                item[1] = "sh"+item[1];
            }else{
                item[1] = "sz"+item[1];
            }
            list.add(DataBuffer.getTimeStockMap().get(item[1]));
        }

        return list;

    }


}
