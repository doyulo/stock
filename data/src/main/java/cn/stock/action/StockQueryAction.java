package cn.stock.action;

import cn.stock.dao.EastMoneyIndestryMapper;
import cn.stock.model.EastMoneyIndestry;
import cn.stock.model.EastMoneyIndestryExample;
import cn.stock.model.TimeStock;
import cn.stock.service.DataBuffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StockQueryAction {
    @Autowired
    private EastMoneyIndestryMapper eastMoneyIndestryMapper;

    @RequestMapping("/stock/{code}")
    public String listStock(@PathVariable String code, ModelMap modelMap){
        TimeStock timeStock = DataBuffer.getTimeStockMap().get(code);
        modelMap.addAttribute("ts",timeStock);
        return "ts";
    }

    @RequestMapping("/")
    public String index(){

        return "index";
    }

    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }

    @RequestMapping("/alyz_detail/{code}")
    public String alyzDeail(@PathVariable String code, ModelMap model){
        model.addAttribute("code",code);
        return "alyzDetail";
    }

    @RequestMapping("/industry")
    public String industry(ModelMap modelMap){
        List<EastMoneyIndestry> eastMoneyIndestries = eastMoneyIndestryMapper.selectByExample(new EastMoneyIndestryExample());
        modelMap.addAttribute("industry",eastMoneyIndestries);
        return "industry";
    }

}
