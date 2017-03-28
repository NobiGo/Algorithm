package dx.com.two;

/**
 * Created by dx on 2017/3/25.
 */
public class Exercise2210 {

    private static int[] aux;

    public static void merge(int[] arrays, int lo, int mid, int hi) {
        int length = arrays.length;
        //辅助数组
        aux = new int[length];
        int i = lo;
        int j = mid + 1;
        //前半部分正序
        for (int k = i; k <= mid; k++) {
            aux[k] = arrays[k];
        }
        //后半部分倒序
        for (int k = j; k <= hi; k++) {
            aux[k] = arrays[hi - k +1+mid];
        }
//        printArrays(arrays);
//        printArrays(aux);
        i = lo;
        j = hi;
        for (int k = lo; k <= hi; k++) {
            if (aux[j] <= aux[i])
                arrays[k] = aux[j--];
            else
                arrays[k] = aux[i++];
        }
    }



    private static void printArrays(int [] arrays){
        for (int i : arrays) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {

        int[] arrays = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        merge(arrays, 0, arrays.length / 2, arrays.length - 1);
        printArrays(arrays);
    }
}
