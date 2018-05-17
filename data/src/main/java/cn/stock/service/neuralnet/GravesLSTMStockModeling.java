package cn.stock.service.neuralnet;

import cn.stock.dao.StockDayMapper;
import cn.stock.model.StockDay;
import cn.stock.model.StockDayExample;
import org.deeplearning4j.nn.api.Layer;
import org.deeplearning4j.nn.conf.BackpropType;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.GravesLSTM;
import org.deeplearning4j.nn.conf.layers.RnnOutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.learning.config.RmsProp;
import org.nd4j.linalg.lossfunctions.LossFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class GravesLSTMStockModeling {

    @Autowired
    private StockDayMapper stockDayMapper;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private int lableLength=9;
    private int minBatchSize=32;
    private int exampleLength = 200;
    private int outComes = 9 ;

    private int lstmLayerSize = 200;
    private int tbpttLength = 50;

    private int numEpochs = 1;
    private int generateSamplesEveryNMinibatches = 10;


    private double priceDeal = 10000;
    private double marketCapDeal = 10000000000000.00;
    private double amtDeal = 100000000000.00;

    public void train() throws ParseException {


        Random rng = new Random(12345);
        List<List<StockDay>> lists = getSamples("2017-06-30",exampleLength);
        StockDayIterator iter = new StockDayIterator(rng,lists,minBatchSize,lableLength,exampleLength,outComes);

        MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder()
                .seed(123)
                .l2(0.0001)
                .weightInit(WeightInit.XAVIER)
                .updater(new RmsProp(0.1))
                .list()
                .layer(0, new GravesLSTM.Builder().nIn(lableLength).nOut(lstmLayerSize)
                        .activation(Activation.TANH).build())
                .layer(1, new GravesLSTM.Builder().nIn(lstmLayerSize).nOut(lstmLayerSize)
                        .activation(Activation.TANH).build())
                .layer(2, new RnnOutputLayer.Builder(LossFunctions.LossFunction.MCXENT).activation(Activation.SOFTMAX)        //MCXENT + softmax for classification
                        .nIn(lstmLayerSize).nOut(outComes).build())
                .backpropType(BackpropType.TruncatedBPTT).tBPTTForwardLength(tbpttLength).tBPTTBackwardLength(tbpttLength)
                .pretrain(false).backprop(true)
                .build();

        MultiLayerNetwork net = new MultiLayerNetwork(conf);
        net.init();
        net.setListeners(new ScoreIterationListener(1));

        //Print the  number of parameters in the network (and for each layer)
        Layer[] layers = net.getLayers();
        int totalNumParams = 0;
        for( int i=0; i<layers.length; i++ ){
            int nParams = layers[i].numParams();
            System.out.println("Number of parameters in layer " + i + ": " + nParams);
            totalNumParams += nParams;
        }
        System.out.println("Total number of network parameters: " + totalNumParams);

        int miniBatchNumber = 0;
        for( int i=0; i<numEpochs; i++ ){
            while(iter.hasNext()){
                DataSet ds = iter.next();
                net.fit(ds);
                if(++miniBatchNumber % generateSamplesEveryNMinibatches == 0){

                    StockDay stockDay1 = getTestData("2017-06-30");
                    /*StockDay stockDay2 = getTestData("2017-06-30");
                    StockDay stockDay3 = getTestData("2017-06-30");
                    StockDay stockDay4 = getTestData("2017-06-30");*/

                    System.out.println("--------------------");
                    System.out.println("Completed " + miniBatchNumber + " minibatches of size " + minBatchSize + "x" + exampleLength + " characters" );
//                    System.out.println("Sampling characters from network given initialization \"" + stockDay1.getCode() + "\"");
                    List<List<StockDay>> samples =
                            getPreditResultFromNetwork(Arrays.asList(stockDay1),net,rng,5);
                    for( int j=0; j<samples.size(); j++ ){
                        System.out.println("----- Sample " + j + " -----");
                        System.out.println(samples.get(j));
                        System.out.println();
                    }
                }
            }

            iter.reset();	//Reset iterator for another epoch
        }

        System.out.println("\n\nExample complete");

    }

    private List<List<StockDay>> getPreditResultFromNetwork(List<StockDay> stockDays,MultiLayerNetwork net,Random random,int numSamples){
        INDArray initializationInput = Nd4j.zeros(numSamples, lableLength, stockDays.size());

        for( int i=0; i<stockDays.size(); i++ ){
            for( int j=0; j<numSamples; j++ ){
                StockDay stockDay = stockDays.get(i);
                initializationInput.putScalar(new int[]{i,0,j},stockDay.getBeginPri().doubleValue()/priceDeal);
                initializationInput.putScalar(new int[]{i,1,j},stockDay.getMaxPri().doubleValue()/priceDeal);
                initializationInput.putScalar(new int[]{i,2,j},stockDay.getMinPri().doubleValue()/priceDeal);
                initializationInput.putScalar(new int[]{i,3,j},stockDay.getPrePri().doubleValue()/priceDeal);
                initializationInput.putScalar(new int[]{i,4,j},stockDay.getCurPri().doubleValue()/priceDeal);
                initializationInput.putScalar(new int[]{i,5,j},stockDay.getDealAmt().doubleValue()/amtDeal);
                initializationInput.putScalar(new int[]{i,6,j},stockDay.getRate().doubleValue());
                initializationInput.putScalar(new int[]{i,7,j},stockDay.getInOutRate().doubleValue());
                initializationInput.putScalar(new int[]{i,8,j},stockDay.getMarketCap().doubleValue()/marketCapDeal);
            }
        }

        net.rnnClearPreviousState();

        INDArray output = net.rnnTimeStep(initializationInput);
//        output.tensorAlongDimension(0,1,2,3,4,5,6,7,8);
//        output = output.tensorAlongDimension(output.size(2)-1,1,0);
        List<List<StockDay>> lists = new ArrayList<>();
        for( int i=0; i<stockDays.size(); i++ ){

            List<StockDay> days = new ArrayList<>();
            INDArray nextInput = Nd4j.zeros(numSamples, lableLength, outComes);

            for( int s=0; s<numSamples; s++ ){

                StockDay stockDay = new StockDay();
                stockDay.setCode(stockDays.get(i).getCode());
                stockDay.setName(stockDays.get(i).getName());

                stockDay.setBeginPri(new BigDecimal(output.getDouble(i,0,s)*priceDeal));
                stockDay.setMaxPri(new BigDecimal(output.getDouble(i,1,s)*priceDeal));
                stockDay.setMinPri(new BigDecimal(output.getDouble(i,2,s)*priceDeal));
                stockDay.setPrePri(new BigDecimal(output.getDouble(i,3,s)*priceDeal));
                stockDay.setCurPri(new BigDecimal(output.getDouble(i,4,s)*priceDeal));
                stockDay.setDealAmt(new BigDecimal(output.getDouble(i,5,s)*amtDeal));
                stockDay.setRate(new BigDecimal(output.getDouble(i,6,s)));
                stockDay.setInOutRate(new BigDecimal(output.getDouble(i,7,s)));
                stockDay.setMarketCap(new BigDecimal(output.getDouble(i,8,s)*marketCapDeal));

                nextInput.putScalar(new int[]{i,0,s},stockDay.getBeginPri().doubleValue()/priceDeal);
                nextInput.putScalar(new int[]{i,1,s},stockDay.getMaxPri().doubleValue()/priceDeal);
                nextInput.putScalar(new int[]{i,2,s},stockDay.getMinPri().doubleValue()/priceDeal);
                nextInput.putScalar(new int[]{i,3,s},stockDay.getPrePri().doubleValue()/priceDeal);
                nextInput.putScalar(new int[]{i,4,s},stockDay.getCurPri().doubleValue()/priceDeal);
                nextInput.putScalar(new int[]{i,5,s},stockDay.getDealAmt().doubleValue()/amtDeal);
                nextInput.putScalar(new int[]{i,6,s},stockDay.getRate().doubleValue());
                nextInput.putScalar(new int[]{i,7,s},stockDay.getInOutRate().doubleValue());
                nextInput.putScalar(new int[]{i,8,s},stockDay.getMarketCap().doubleValue()/marketCapDeal);

                days.add(stockDay);
            }
            lists.add(days);

            output = net.rnnTimeStep(nextInput);	//Do one time step of forward pass
        }

        return lists;
    }

    private StockDay getTestData(String date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Random random = new Random();
        List<String> codes = jdbcTemplate.queryForList("SELECT DISTINCT code FROM stock_day", String.class);
        StockDay stockDay = null;
        while (stockDay==null){
            String code = codes.get(random.nextInt(codes.size()));
            try {
                stockDay = stockDayMapper.getStock(code,sdf.parse(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return stockDay;
    }

    public List<List<StockDay>> getSamples(String date,Integer length/**单个样本长度*/) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        List<List<StockDay>> lists = new ArrayList<>();

        List<String> codes = jdbcTemplate.queryForList("SELECT DISTINCT code FROM stock_day", String.class);

        /*String[] codeArr = {"sz002621","sz002620","sz002626","sz002625","sz002624","sz002623","sz002629",
                "sz002628","sz002627","sh600159","sh600158","sh600157","sh600156","sh600155",
                "sh600165","sh600163","sh600162","sh600161","sh600160","sz002633",
                "sz002632","sz002631","sz002630","sz002637","sz002636","sz002635",
                "sz002634","sz002639","sz002638","sh600169","sh600168","sh600167","sh600166",
                "sh600176","sh603203","sh600175","sh600173","sz002640","sh600172","sh600171","sh600170","sh603208",
                "sz002644","sz002643","sz002642","sz002641","sz002648","sz002647","sz002646","sz002645","sz002649",
                "sh600179","sh600178","sh600177","sh603200","sz000877","sz000876","sz000875","sz000878","sh600109",
                "sh600108","sh600107","sh600106","sh600105","sh600104","sh600103","sh600101","sh600100","sh600110"};
        List<String> codes = Arrays.asList(codeArr);*/

        for (String code : codes) {
            StockDayExample stockDayExample = new StockDayExample();
            stockDayExample.createCriteria().andCodeEqualTo(code).andCurDateLessThan(sdf.parse(date));
            stockDayExample.setLimit(length);
            stockDayExample.setOrderByClause("cur_date desc");
            List<StockDay> stockDays = stockDayMapper.selectByExample(stockDayExample);
            Collections.reverse(stockDays);
            if(stockDays.size()==length){
                lists.add(stockDays);
            }
        }


        return lists;
    }



}
