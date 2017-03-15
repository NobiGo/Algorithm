package dx.com.one.three;

import com.algs4.stdlib.StdIn;
import dx.com.tools.Bag;

/**
 * Created by dx on 2017/3/14.
 */

public class Stats {
    public static void main(String[] args) {
        Bag<Double> numbles = new Bag<Double>();
        while(!StdIn.isEmpty()) {
            Double value = StdIn.readDouble();
            if(value == 0.0)
                break;
            numbles.add(value);
        }
        for(Double value:numbles){
            System.out.println(value);
        }
    }
}
