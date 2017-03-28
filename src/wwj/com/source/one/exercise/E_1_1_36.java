package wwj.com.source.one.exercise;

import com.algs4.stdlib.StdOut;
import com.algs4.stdlib.StdRandom;

/**
 * Created by Jerry on 2017/3/23.
 */
public class E_1_1_36 {
//    static int MAX_NUM = 100;
    public static int[] shuttleTest(int M, int N){
        double[][] res = new double[N][];
        for(int j = 0;j<N;j++){
            double[] a = new double[M];
            for(int i = 0;i<M;i++)
                a[i] = i;
            StdRandom.shuffle(a);
            res[j] = a;
        }
        for(int i=0;i<N;i++){
            for(int j = 0;j<M;j++){
                StdOut.print(res[i][j]+" ");
            }
            StdOut.println();
        }
        int[] ans = new int[M];
        for(int i=0;i<M;i++){
            int count = 0;
            for(int j = 0;j<N;j++){
                if(res[j][i]==i)count++;
            }
            ans[i] = count;
            StdOut.print(count + " ");
        }
        StdOut.println();
        return ans;
    }

    public static void main(String[] args) {
        shuttleTest(12,12


        );
    }
}
