package cn.stock;

import cn.stock.dao.StockDayMapper;
import cn.stock.service.DataDeal;
import cn.stock.service.DataDealStock;
import cn.stock.service.IndustrySave;
import cn.stock.service.SinaDataFetcher;
import cn.stock.service.alyz.Alyz;
import cn.stock.service.neuralnet.GravesLSTMStockModeling;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.text.ParseException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockApplicationTests {

	@Autowired
	private DataDeal dataDeal;
	@Autowired
	private SinaDataFetcher dataFetcher;
	@Autowired
	private GravesLSTMStockModeling gravesLSTMStockModeling;
    @Autowired
    private StockDayMapper stockDayMapper;
    @Autowired
	private Alyz alyz;
    @Autowired
	private DataDealStock dataDealStock;

	@Test
	public void contextLoads() {
//		System.out.println(gravesLSTMStockModeling.getTestData("2017-03-30"));

	}

	@Test
	public void saveAllTimeDeal(){
//		dataDeal.saveAllTimeDeal("20180521");
//		dataDeal.saveAllTimeDeal("20180522");
//		dataDeal.saveAllTimeDeal("20180523");
//		dataDeal.saveAllTimeDeal("20180529");
//		dataDeal.saveAllTimeDeal("20180530");
//		dataDeal.saveAllTimeDeal("20180531");
		dataDeal.saveAllTimeDeal("20180619");

		Runtime r = Runtime.getRuntime();
		try {
			r.exec("shutdown -s");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@Test
	public void testFetch(){
//		dataFetcher.saveAllTimeDeal();
	}

	@Test
	public void saveToday(){
		dataDeal.saveToday();
	}
	@Test
	public void testWeightAlzy(){
		/*try {
			dataDealStock.parseCsvToDatabase("sh000001", "19800101", "20180801");
		} catch (IOException e) {
			e.printStackTrace();
		}*/
//		dataDeal.saveToday();
		alyz.reAlyzWeight();

//		alyz.reAlyzWeight("sz300540");
//		alyz.reAlyzWeight("sz000732");
//		alyz.reAlyzWeight("sh600019");

//		alyz.reAlyzWeight();
	}

	@Autowired
	private IndustrySave industrySave;
	@Test
	public void saveIndustry(){
//		industrySave.saveEastMoneyIndustry();
		industrySave.saveRela();
	}

	@Test
	public void machineLearn() throws ParseException {
		gravesLSTMStockModeling.train();
	}

}
