package cn.stock.action;

import cn.stock.model.TimeStock;
import cn.stock.service.DataBuffer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StockQueryAction {

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

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


}
