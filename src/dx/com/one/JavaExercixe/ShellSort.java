package dx.com.one.JavaExercixe;

/**
 * Created by dx on 2017/3/22.
 */
public class ShellSort {
    public static void main(String[] args) {

        int[] arrays = {1, 3, 4, 6, 8, 2};
        ShellSortMethod(arrays);
        for (int i : arrays) {
            System.out.println(i);
        }
    }

    public static void ShellSortMethod(int[] arrays) {
        int n = arrays.length;
        int h = 1;
        while (h < n / 3)
            h = 3 * h + 1;
        System.out.println(h);
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                System.out.println(h + "===========" + i);
                for (int j = i; j >= h; j -= h) {
                    if (arrays[j] > arrays[j - h]) {
                        int temp = arrays[j];
                        arrays[j] = arrays[j - h];
                        arrays[j - h] = temp;
                    }
                }
                h = h / 3;
            }
        }
    }
}