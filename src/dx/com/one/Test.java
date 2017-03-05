package dx.com.one;

import dx.com.standard.StdIn;
import dx.com.standard.StdOut;

/**
 * Created by dx on 2017/3/5.
 */
public class Test {
    public static void main(String[] args) {
        for(String str:args){
            System.out.println(str);
        }
        double value  = StdIn.readDouble();
        StdOut.printf("%.2f\n",value);
    }
}
