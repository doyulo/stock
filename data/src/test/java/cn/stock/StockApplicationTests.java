package cn.stock;

import cn.stock.dao.StockDayMapper;
import cn.stock.service.DataDeal;
import cn.stock.service.DataFetcher;
import cn.stock.service.neuralnet.GravesLSTMStockModeling;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockApplicationTests {

	@Autowired
	private DataDeal dataDeal;
	@Autowired
	private DataFetcher dataFetcher;
	@Autowired
	private GravesLSTMStockModeling gravesLSTMStockModeling;
    @Autowired
    private StockDayMapper stockDayMapper;

	@Test
	public void contextLoads() {
//		System.out.println(gravesLSTMStockModeling.getTestData("2017-03-30"));

	}

	@Test
	public void saveAllTimeDeal(){
		dataDeal.saveAllTimeDeal("20180521");
		dataDeal.saveAllTimeDeal("20180522");
		dataDeal.saveAllTimeDeal("20180523");
		dataDeal.saveAllTimeDeal("20180524");
		dataDeal.saveAllTimeDeal("20180525");
	}

	@Test
	public void saveToday(){
		dataDeal.saveToday();
        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String lastDealDay = dataFetcher.getLastDealDay().replaceAll("-","");

        Date lastSaveDate = stockDayMapper.getLastSaveDay();
        String lastSaveDay;
        if(lastSaveDate==null){
            lastSaveDay = "19900101";
        }else{
            Calendar ca = Calendar.getInstance();
            if(lastDealDay.equals(sdf.format(lastSaveDate))){
                System.out.println("nothing for update!!!");
                return;
            }
            ca.setTime(lastSaveDate);
            ca.add(Calendar.DAY_OF_MONTH,1);
            lastSaveDate = ca.getTime();
            lastSaveDay = sdf.format(lastSaveDate);
        }



        dataFetcher.filterAviableCodesToBuffer();
        HashMap<String, String> data = StockURLDataBuffer.getData();
        Set<String> codeSet = data.keySet();
//        Set<String> codeSet = new HashSet<>();
//        codeSet.add("sz000047");
        for (String code : codeSet) {
            try {
                dataDeal.parseCsvToDatabase(code,lastSaveDay,lastDealDay);
                dataDeal.saveDayDetail(code,"20180509");
                dataDeal.saveDayDetail(code,"20180510");
                dataDeal.saveDayDetail(code,"20180511");
                dataDeal.saveDayDetail(code,"20180514");
                dataDeal.saveDayDetail(code,"20180515");
                dataDeal.saveDayDetail(code,"20180516");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/
	}

	@Test
	public void testFetch(){
//		dataFetcher.saveAllTimeDeal();
	}

	@Test
	public void machineLearn() throws ParseException {
		gravesLSTMStockModeling.train();
	}

}
