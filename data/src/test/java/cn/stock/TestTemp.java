package cn.stock;

import org.junit.Test;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

public class TestTemp {

    @Test
    public void name() {
        int[] A = {1,0,0,0,1,1,1,1,1};
        int[] B = {1,0,1,0,1,0,1,0,1};

        INDArray arr = Nd4j.create(A,new int[]{3,3},'c');
        INDArray arr2 = Nd4j.create(B,new int[]{3,3},'c');

        System.out.println(arr);
        System.out.println(arr2);
    }

    @Test
    public void time(){
        System.out.println(System.currentTimeMillis());
    }
}
