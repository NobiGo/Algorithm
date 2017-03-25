package dx.com.two;

/**
 * Created by dx on 2017/3/24.
 */
public class Example211 {
    /**
     * 2.2.1    原地归并的抽象方法
     */
    public static void merge(int[] arrays, int lo, int mid, int hi) {
        //将两个有序的数组合并为一个有序的数组
        int i = lo;
        int j = mid + 1;
        int[] temp = new int[hi + 1];
        //将需要进行合并的数组保存到临时数组中
        for (int k = lo; k <= hi; k++)
            temp[k] = arrays[k];
        //将临时数组归并到源数组中
        for (int k = lo; k <= hi; k++) {
            //当arrays[mid+1....hi]没有元素时
            if (j > hi)
                arrays[k] = temp[i++];
            else if (i > mid)
                arrays[k] = temp[j++];
            else if (temp[i] < temp[j])
                arrays[k] = temp[i++];
            else
                arrays[k] = temp[j++];
        }
    }

//    public static void main(String[] args) {
//        int[] arrays = {3, 8, 23, 7, 10, 34};
//        merge(arrays, 0, (arrays.length - 1) / 2, arrays.length - 1);
//        for (int i : arrays) {
//            System.out.println(i);
//        }
//    }
}
