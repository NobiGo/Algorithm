package dx.com.two;

/**
 * Created by dx on 2017/3/25.
 */
public class Example223 {
    /**
     * 自顶向上
     */
    private static void sort(int[] arrays) {
        int length = arrays.length;
        int[] aux = new int[length];
        for (int sz = 1; sz < length; sz += sz) {
            for (int lo = 0; lo < length - sz; lo += sz + sz) {
                Example211.merge(arrays, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, length - 1));
            }
        }
    }

    public static void main(String[] args) {
        int[] arrays = {1, 2, 5, 6, 89, 34, 56};
        sort(arrays);
        for (int i : arrays) {
            System.out.println(i);
        }
    }
}
