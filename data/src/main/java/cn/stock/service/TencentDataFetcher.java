package cn.stock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class TencentDataFetcher {
    @Autowired
    private RestTemplate restTemplate;

    private String url = "http://web.sqt.gtimg.cn/q={0}";
    private Integer batchSize = 250;

    public void fetch(Set<String> codeBatch){
        List<String> list = new ArrayList<>(codeBatch);
        Collections.sort(list);
        Integer batchCount = list.size()/batchSize;
        for (int i = 0; i < batchCount; i++) {
            String cs = String.join(",", list.subList(batchSize*i,batchSize*(i+1)));
            String res = restTemplate.getForObject(url, String.class, cs);
            putToBuffer(res);
//            System.out.println(res);
        }

        if(list.size()%batchSize!=0){
            String cs = String.join(",", list.subList(batchSize*batchCount,list.size()));
            String res = restTemplate.getForObject(url, String.class, cs);
            putToBuffer(res);
//            System.out.println(res);
        }
//        System.out.println(StockURLDataBuffer.getData().size());
    }

    public void filterAviableCodesToBuffer(){
        Set<String> sz300 = getCodes("sz300");
        Set<String> sz000 = getCodes("sz000");
        Set<String> sz002 = getCodes("sz002");
        Set<String> sh600 = getCodes("sh600");
        Set<String> sh601 = getCodes("sh601");
        Set<String> sh603 = getCodes("sh603");
        Set<String> allSet = new HashSet<>();
        allSet.addAll(sz300);
        allSet.addAll(sz000);
        allSet.addAll(sz002);
        allSet.addAll(sh600);
        allSet.addAll(sh601);
        allSet.addAll(sh603);
//        allSet.add("")
        fetch(allSet);
    }

    private void putToBuffer(String res){
        res = res.replaceAll("v_","");
        res = res.replaceAll("\n","");
        String[] code_value = res.split(";");
        for (String cv : code_value) {
            String[] v = cv.split("=");
            v[1] = v[1].replaceAll("\"","");
            StockURLDataBuffer.putTencent(v[0],v[1]);
        }
    }

    private Set<String> getCodes(String codeHead){
        Set<String> codes = new HashSet<>();

        for (int i = 0; i <999 ; i++) {
            if(i<10){
                codes.add(codeHead+"00"+i);
            }else if(i<100){
                codes.add(codeHead+"0"+i);
            }else {
                codes.add(codeHead+i);
            }
        }
        return codes;
    }

    public String getLastDealDay(){
        String res = restTemplate.getForObject(url, String.class, "sh000001");
        res = res.replaceAll("v_","");
        res = res.replaceAll("\"","");
        res = res.replaceAll(";","");
        String[] split = res.split("=");
        return split[1].split(",")[30].substring(0,8);
    }
}
