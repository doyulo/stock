package cn.stock.action;

import cn.stock.dao.RaskAlyzMapper;
import cn.stock.model.RaskAlyz;
import cn.stock.model.TimeStock;
import cn.stock.service.DataBuffer;
import cn.stock.service.alyz.Alyz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class StockRestQuery {

    @Autowired
    private RaskAlyzMapper raskAlyzMapper;
    @Autowired
    private Alyz alyz;

    @RequestMapping("/codeList")
    public List<TimeStock> codeList(){
        return new ArrayList<>(DataBuffer.getTimeStockMap().values());
    }

    @RequestMapping("/queryAlyz")
    public List<RaskAlyz> queryAlyz(String code){
        return alyz.alyzWeight(code,true);
    }

    @RequestMapping("/considerBuy")
    public List<TimeStock> considerBuy(boolean isAllHold){
        List<TimeStock> list = new ArrayList<>();
        Set<String> codeSet = DataBuffer.getTimeStockMap().keySet();
        for (String code : codeSet) {
            List<RaskAlyz> raskAlyzs = alyz.alyzWeight(code, true);
            if(raskAlyzs==null||raskAlyzs.size()==0){
                continue;
            }
            if(isAllHold){
                if(raskAlyzs.get(raskAlyzs.size() - 1).getHold()){
                    list.add(DataBuffer.getTimeStockMap().get(code));
                }
            }else {
                if(raskAlyzs.get(raskAlyzs.size() - 1).getHold()&&!raskAlyzs.get(raskAlyzs.size() - 2).getHold()){
                    list.add(DataBuffer.getTimeStockMap().get(code));
                }
            }

        }
        return list;
    }
}
