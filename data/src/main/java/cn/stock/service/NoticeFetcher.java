package cn.stock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.regex.Pattern;

@Service
public class NoticeFetcher {
    public static final Pattern negtiveRex=Pattern.compile("((诉讼)|(预亏)|(减)|(不理想)|(违规)|(律师函)|(退市)|(亏损)|(暂停上市)|(被冻结)|(辞职)|(调查)|(终止))");
    public static final Pattern postitiveRex=Pattern.compile("((超预期)|(目标)|(补助)|(签订))");

    @Autowired
    private RestTemplate restTemplate;

    public Integer noticeAlyz(String code){
        int codeType = 0;
        String dealCode;
        if(code.startsWith("sz")){
            codeType=1;
        }
        dealCode = code.substring(2);

        String res = restTemplate.getForObject("http://newsnotice.eastmoney.com/webapi/api/Notice?Time=&FirstNodeType=0&SecNodeType=0&PageIndex=1&callback=stocknoticehandler&CodeType={0}&StockCode={1}&PageSize=5", String.class, codeType, dealCode);
        System.out.println(code+":\n"+res);
        if(negtiveRex.matcher(res).find()){
            return -1;
        }else if(postitiveRex.matcher(res).find()){
            return 1;
        }

        return 0;
    }

}
