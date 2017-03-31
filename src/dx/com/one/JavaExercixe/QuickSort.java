package dx.com.one.JavaExercixe;

/**
 * Created by dx on 2017/3/13.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arrays = {12, 45, 78, 32, 89, 54, 90};
        methodQuickSort(arrays, 0, arrays.length - 1);
        for (int i : arrays) {
            System.out.println(i);
        }
    }

    /**
     * 快速排序算法
     *
     * @param arrays
     * @param lo
     * @param hi
     */
    public static void methodQuickSort(int[] arrays, int lo, int hi) {
        if (lo > hi)
            return;
        int i, j;
        i = lo;
        j = hi;
        //用排序的首个元素作为哨兵
        int index = arrays[i];
        while (i < j) {
            //当i<j且j所指向的元素大于index时，一直递减知道找到这个大于的元素
            while (i < j && arrays[j] >= index) {
                j--;
            }
            if (i < j)
                arrays[i++] = arrays[j];
            while (j < j && arrays[i] < index) {
                i++;
            }
            if (i < j) {
                arrays[j--] = arrays[i];
            }

        }

        arrays[i] = index;
        methodQuickSort(arrays, lo, i - 1);
        methodQuickSort(arrays, i + 1, hi);
    }
}
