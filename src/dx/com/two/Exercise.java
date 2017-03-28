package dx.com.two;

/**
 * Created by dx on 2017/3/28.
 */
public class Exercise {
    //交换数组中元素的值
    public static void exch(int[] arrays, int i, int j) {
        int temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;
    }

    //插入排序
    public static void insertSort(int[] arrays) {
        //获取数组的长度
        int length = arrays.length;
        //从数组的第二个位置开始进行插入操作
        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0; j--) {
                if (arrays[j] < arrays[j - 1]) {
                    exch(arrays, j, j - 1);
                } else
                    break;
            }

        }
    }

    public static void main(String[] args) {
        int[] arrays = {12, 34, 56, 678, 89, 5, 3, 9};
        insertSort(arrays);
        for (int i : arrays) {
            System.out.println(i);
        }
    }
}
