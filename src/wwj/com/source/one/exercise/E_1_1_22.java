package wwj.com.source.one.exercise;

import com.algs4.stdlib.StdIn;
import com.algs4.stdlib.StdOut;

import java.util.Arrays;

/**
 * Created by Jerry on 2017/3/23.
 */
public class E_1_1_22 {
    public E_1_1_22() {
    }

    /**
     * Returns the index of the specified key in the specified array.
     *
     * @param a   the arrray of integers, must be sorted in ascending order
     * @param key the search key
     * @return index of key in array{@code a} if present; {@code -1} otherwise
     */
    public static int indexOf(int[] a, int key) {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] > key) hi = mid - 1;
            else if (a[mid] < key) lo = mid + 1;
            else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * Returns the index of the specified key in the specified array.
     * This function is poorly named because it does not give the <em>rank</em>
     * if the array has duplicate keys or if the key is not in the array.
     *
     * @param key the search key
     * @param a   the array of integers, must be sorted in ascending order
     * @return index of key in array {@code a} if present; {@code -1} otherwise
     */
    @Deprecated
    public static int rank(int[] a, int key) {
        return indexOf(a, key);
    }


    public static int rank(int[] a, int key, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (a[mid] < key) return rank(a, key, mid + 1, hi);
        else if (a[mid] > key) return rank(a, key, lo, mid - 1);
        else {
            return mid;
        }
    }

    public static int rank(int[] a, int key, int lo, int hi, int depth) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (a[mid] < key){
            StdOut.printf("%s%d %d\n",repeat(4*depth,' '),lo,hi);
            return rank(a, key, mid + 1, hi,depth+1);
        }
        else if(a[mid] > key) {
            StdOut.printf("%s%d %d\n",repeat(4*depth,' '),lo,hi);
            return rank(a, key, lo, mid - 1,depth+1);
        }
        else{
            StdOut.printf("%s%d %d\n",repeat(4*depth,' '),lo,hi);
            return mid;
        }
    }
    private static String repeat(int n, char a){
        String res = "";
        for(int i = 0;i<n;i++){
            res += a;
        }
        return res;
    }

    public static void main(String[] args) {
        StdOut.print("The Array is: ");
        int[] a = new int[100];
        java.util.Random r = new java.util.Random(37);
        for(int i = 0;i<100;i++){
            a[i]=r.nextInt();
        }
        Arrays.sort(a);
//        StdOut.println(Arrays.asList(a));
        StdOut.println(rank(a,a[12],0,99,0));
        StdOut.println(rank(a,45,0,99,0));
    }
}
