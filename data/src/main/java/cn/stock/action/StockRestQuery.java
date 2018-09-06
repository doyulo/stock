package cn.stock.action;

import cn.stock.dao.CareAboutMapper;
import cn.stock.dao.RaskAlyzMapper;
import cn.stock.model.CareAbout;
import cn.stock.model.CareAboutExample;
import cn.stock.model.RaskAlyz;
import cn.stock.model.TimeStock;
import cn.stock.service.DataBuffer;
import cn.stock.service.DataDeal;
import cn.stock.service.NoticeFetcher;
import cn.stock.service.alyz.Alyz;
import cn.stock.ui.LayuiTableData;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@RestController
public class StockRestQuery {

    @Autowired
    private RaskAlyzMapper raskAlyzMapper;
    @Autowired
    private Alyz alyz;
    @Autowired
    private DataDeal dataDeal;
    @Autowired
    private CareAboutMapper careAboutMapper;
    @Autowired
    private NoticeFetcher noticeFetcher;

    //实时分析（短线）
    @RequestMapping("/queryAlyz")
    public LayuiTableData<List<RaskAlyz>> queryAlyz(String code){
        List<RaskAlyz> raskAlyzs = alyz.alyzWeight(code, true);
        Collections.reverse(raskAlyzs);
        if(raskAlyzs.size()>300){
            raskAlyzs = raskAlyzs.subList(0,300);
        }
        return new LayuiTableData(raskAlyzs);
    }

    //筛选短线分析结果
    @RequestMapping("/considerBuy")
    public LayuiTableData<List<TimeStock>> considerBuy(boolean isAllHold){
        List<TimeStock> list = new ArrayList<>();
        Set<String> codeSet = alyz.alyzWeightNow(isAllHold);

        for (String code : codeSet) {
            TimeStock timeStock = DataBuffer.getTimeStockMap().get(code);
            if(timeStock.getPe().compareTo(BigDecimal.ZERO)<0){
                continue;
            }
            if(timeStock.getName().contains("ST")){
                continue;
            }
            if(noticeFetcher.noticeAlyz(code)<0){
                continue;
            }
            list.add(timeStock);
        }
        return new LayuiTableData(list);
    }

    //全量保存历史记录（交易日）
    @RequestMapping("/saveHistory")
    public JSONObject saveToToday(){
        JSONObject res = new JSONObject();
        try{
            dataDeal.saveToday();
            res.put("code",0);
        }catch (Exception e){
            res.put("code",1);
            res.put("error",e.getCause());
        }

        return res;
    }

    //全量重新分析
    @RequestMapping("/reAlyz")
    public JSONObject reAlyz(){
        JSONObject res = new JSONObject();
        try{
            alyz.reAlyzWeight();
            res.put("code",0);
        }catch (Exception e){
            res.put("code",1);
            res.put("error",e.getCause());
        }

        return res;
    }

    //增量分析
    @RequestMapping("/reAlyzNow")
    public JSONObject reAlyzNow(){
        JSONObject res = new JSONObject();
        try{
            alyz.saveWeightNowAll();
            res.put("code",0);
        }catch (Exception e){
            res.put("code",1);
            res.put("error",e.getCause());
        }

        return res;
    }

    //自选股列表
    @RequestMapping("/careabout")
    public LayuiTableData<List<TimeStock>> careAbout(){
        List<CareAbout> careAbouts = careAboutMapper.selectByExample(new CareAboutExample());
        List<TimeStock> timeStocks = new ArrayList<>();
        for (CareAbout careAbout : careAbouts) {
            TimeStock timeStock = DataBuffer.getTimeStockMap().get(careAbout.getCode());
            timeStocks.add(timeStock);
        }
        return new LayuiTableData(timeStocks);
    }

    @RequestMapping("/add_careabout")
    public void addCareAbout(String code){
        CareAbout careAbout = careAboutMapper.selectByPrimaryKey(code);
        if(careAbout!=null){
            return;
        }

        TimeStock timeStock = DataBuffer.getTimeStockMap().get(code);
        if(timeStock==null){
            return;
        }
        careAbout = new CareAbout();
        careAbout.setCode(code);
        careAbout.setName(timeStock.getName());
        careAboutMapper.insert(careAbout);
    }

    @RequestMapping("/del_careabout")
    public void delCareAbout(String code){
        CareAbout careAbout = careAboutMapper.selectByPrimaryKey(code);
        if(careAbout!=null){
            careAboutMapper.deleteByPrimaryKey(code);
        }

    }
}
