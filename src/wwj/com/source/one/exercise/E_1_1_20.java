package wwj.com.source.one.exercise;

import com.algs4.stdlib.StdIn;
import com.algs4.stdlib.StdOut;

import java.util.NoSuchElementException;

/**
 * Created by Jerry on 2017/3/23.
 */
public class E_1_1_20 {
    /**
     * calculate ln(n!), using Recursive
     * @param n
     * @return
     */
    public static double lnFac(int n){
        if(n==1)return 0.0;
        //negative number return Exception
        if(n<0) {
            throw new NoSuchElementException();
        }
        return Math.log(n)+ lnFac(n-1);
    }

    public static void main(String[] args) {
        StdOut.println("Type an int:");
        int s = StdIn.readInt();
        StdOut.printf("ln(%d!):",s);
        StdOut.println(lnFac(s));
        StdOut.println("the real: " + Math.log(6));
    }
}
