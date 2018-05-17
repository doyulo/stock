package cn.stock.service.neuralnet;

import cn.stock.model.StockDay;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.dataset.api.DataSetPreProcessor;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.factory.Nd4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StockDayIterator implements DataSetIterator {

    private Random rng;

    private List<List<StockDay>> slist;

    private List<List<StockDay>> removedlist = new ArrayList<>();

    private int miniBatchSize=32;
    private int varsLength = 9;
    private int exampleLength = 60;//List<StockDay>实际长度应该为61
    private int outComes;//5

    private double priceDeal = 10000;
    private double marketCapDeal = 10000000000000.00;
    private double amtDeal = 100000000000.00;

    public StockDayIterator(Random rng, List<List<StockDay>> slist, int miniBatchSize, int lableLength, int exampleLength,int outComes) {
        this.rng = rng;
        this.slist = slist;
        this.miniBatchSize = miniBatchSize;
        this.varsLength = lableLength;
        this.exampleLength = exampleLength;
        this.outComes = outComes;
    }

    @Override
    public DataSet next(int m) {
        if(slist==null){

        }

        int currMinibatchSize = Math.min(m,slist.size());

        INDArray input = Nd4j.create(new int[]{currMinibatchSize, varsLength,exampleLength}, 'f');
        INDArray labels = Nd4j.create(new int[]{currMinibatchSize, varsLength,exampleLength}, 'f');

        Random random = new Random();

        for (int i = 0; i < currMinibatchSize; i++) {
            int x = random.nextInt(slist.size());
            List<StockDay> stockDays = slist.get(x);

            for (int j = 0; j < exampleLength-1; j++) {
                StockDay stockDay = stockDays.get(j);
                input.putScalar(new int[]{i,0,j},stockDay.getBeginPri().doubleValue()/priceDeal);
                input.putScalar(new int[]{i,1,j},stockDay.getMaxPri().doubleValue()/priceDeal);
                input.putScalar(new int[]{i,2,j},stockDay.getMinPri().doubleValue()/priceDeal);
                input.putScalar(new int[]{i,3,j},stockDay.getPrePri().doubleValue()/priceDeal);
                input.putScalar(new int[]{i,4,j},stockDay.getCurPri().doubleValue()/priceDeal);
                input.putScalar(new int[]{i,5,j},stockDay.getDealAmt().doubleValue()/amtDeal);
                input.putScalar(new int[]{i,6,j},stockDay.getRate().doubleValue());
                input.putScalar(new int[]{i,7,j},stockDay.getInOutRate().doubleValue());
                input.putScalar(new int[]{i,8,j},stockDay.getMarketCap().doubleValue()/marketCapDeal);
                StockDay stockDayNext = stockDays.get(j+1);
                labels.putScalar(new int[]{i,0,j},stockDayNext.getBeginPri().doubleValue()/priceDeal);
                labels.putScalar(new int[]{i,1,j},stockDayNext.getMaxPri().doubleValue()/priceDeal);
                labels.putScalar(new int[]{i,2,j},stockDayNext.getMinPri().doubleValue()/priceDeal);
                labels.putScalar(new int[]{i,3,j},stockDayNext.getPrePri().doubleValue()/priceDeal);
                labels.putScalar(new int[]{i,4,j},stockDayNext.getCurPri().doubleValue()/priceDeal);
                labels.putScalar(new int[]{i,5,j},stockDayNext.getDealAmt().doubleValue()/amtDeal);
                labels.putScalar(new int[]{i,6,j},stockDayNext.getRate().doubleValue());
                labels.putScalar(new int[]{i,7,j},stockDayNext.getInOutRate().doubleValue());
                labels.putScalar(new int[]{i,8,j},stockDayNext.getMarketCap().doubleValue()/marketCapDeal);
            }

            removedlist.add(slist.remove(x));
        }

        return new DataSet(input,labels);
    }

    @Override
    public int totalExamples() {
        return slist.size();
    }

    @Override
    public int inputColumns() {
        return varsLength;
    }

    @Override
    public int totalOutcomes() {
        return outComes;
    }

    @Override
    public boolean resetSupported() {
        return true;
    }

    @Override
    public boolean asyncSupported() {
        return true;
    }

    @Override
    public void reset() {
        slist.addAll(removedlist);
        removedlist.clear();
    }

    @Override
    public int batch() {
        return miniBatchSize;
    }

    @Override
    public int cursor() {
        return removedlist.size();
    }

    @Override
    public int numExamples() {
        return totalExamples();
    }

    @Override
    public void setPreProcessor(DataSetPreProcessor dataSetPreProcessor) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public DataSetPreProcessor getPreProcessor() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public List<String> getLabels() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public boolean hasNext() {
        return slist.size()>0;
    }

    @Override
    public DataSet next() {
        return next(miniBatchSize);
    }
}
