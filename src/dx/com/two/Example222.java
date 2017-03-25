package dx.com.two;

/**
 * Created by dx on 2017/3/25.
 */
public class Example222 {
    //归并所需的辅助数组
    private static int[] aux;

    public static void sort(int[] arrays) {
        int length = arrays.length;
        aux = new int[length];
        sort(arrays, 0, length - 1);
    }

    //归并排序
    public static void merge(int[] arrays, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        //对辅助数组进行赋值
        for (int k = lo; k <= hi; k++) {
            aux[k] = arrays[k];
        }
        for (int k = lo; k <= hi; k++) {
            //如果arrays[mid+1.....hi]完成
            if (j > hi)
                arrays[k] = aux[i++];
                //如果arrays[lo.....mid]遍历完成
            else if (i > mid)
                arrays[k] = aux[j++];
            else if (aux[i] < aux[j])
                arrays[k] = aux[i++];
            else
                arrays[k] = aux[j++];

        }


    }

    //自定向下归并排序
    public static void sort(int[] arrays, int lo, int hi) {
        if (lo >= hi)
            return;
        int mid = lo + (hi-lo) / 2;
        //左半边排序
        sort(arrays, lo, mid);
        //右半边排序
        sort(arrays, mid + 1, hi);
        //整体归并
        merge(arrays, lo, mid, hi);
    }


    public static void main(String[] args) {
        int[] arrays = {12, 2, 34, 56, 89, 3, 4, 5};
        sort(arrays);
        for (int i : arrays) {
            System.out.println(i);
        }
    }

}
