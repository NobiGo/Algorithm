package dx.com.two;

/**
 * Created by dx on 2017/3/28.
 */
public class Example231 {

    //交换数组元素的位置
    public static void exch(int[] arrays, int i, int j) {
        int temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;
    }

    //切分数组算法
    public static int partition(int[] arrays, int lo, int hi) {
        //左右扫描指针
        int i = lo;
        int j = hi + 1;
        //切分元素
        int temp = arrays[i];
        while (true) {
            while (arrays[++i] < temp) {
                if (i == hi)
                    break;
            }
            while (arrays[--j] > temp) {
                if (j == lo)
                    break;
            }
            if (i >= j)
                break;
            exch(arrays, i, j);
        }
        exch(arrays, lo, j);
        return j;
    }

    public static void sort(int[] arrays, int lo, int hi) {
        if (hi <= lo)
            return;
        int i = partition(arrays, lo, hi);
        sort(arrays, lo, i - 1);
        sort(arrays, i + 1, hi);
    }


    public static void main(String[] args) {
        int[] arrays = {45, 34, 56, 89, 23, 78, 25, 46,45};
        sort(arrays,0,arrays.length-1);
        for(int i:arrays){
            System.out.println(i);
        }
    }
}
