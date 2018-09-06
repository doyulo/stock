package cn.stock.action;

import cn.stock.dao.EastMoneyIndestryMapper;
import cn.stock.model.EastMoneyIndestry;
import cn.stock.model.EastMoneyIndestryExample;
import cn.stock.model.TimeStock;
import cn.stock.service.alyz.IndustryAlyz;
import cn.stock.ui.LayuiTableData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndustryQuery {

    @Autowired
    private IndustryAlyz industryAlyz;
    @Autowired
    private EastMoneyIndestryMapper eastMoneyIndestryMapper;

    @RequestMapping("/industry/{industry_code}")
    public LayuiTableData<List<TimeStock>> indutstryTimeStock(@PathVariable String industry_code){
        return new LayuiTableData(industryAlyz.getStock(industry_code,1,100));
    }

    @RequestMapping("/all_industry")
    public LayuiTableData<List<EastMoneyIndestry>> allIndustry(){
        List<EastMoneyIndestry> eastMoneyIndestries = eastMoneyIndestryMapper.selectByExample(new EastMoneyIndestryExample());
        return new LayuiTableData(eastMoneyIndestries);
    }

}
