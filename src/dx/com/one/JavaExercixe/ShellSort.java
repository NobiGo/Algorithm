package dx.com.one.JavaExercixe;

/**
 * Created by dx on 2017/3/22.
 */
public class ShellSort {
    public static void main(String[] args) {

    }

    public void ShellSortMethod(int[] arrays) {
        int n = arrays.length;
        int h = 1;
        while (h < n / 3)
            h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h; j -= h) {

                }
            }
            h = h / 3;
        }
    }
}
