package cn.stock.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stock")
public class StockQueryAction {

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
