package dx.com.one.JavaExercixe;

/**
 * Created by dx on 2017/3/21.
 */
public class SelectionSort {

    public static void main(String[] args) {

        int [] arrays = {1,2,5,7,8,3,4};
        selectSortMethod(arrays);
        for(int i:arrays){
            System.out.println(i);
        }
    }

    public static void selectSortMethod(int[] arrays) {
        int length = arrays.length;
        for (int i = 0; i < length; i++) {
            int min = i;
            int temp = arrays[i];
            for (int j = i + 1; j < length; j++) {
                if (arrays[min] > arrays[j])
                    min = j;
            }
            //交换最小值与首位的值
            arrays[i] = arrays[min];
            arrays[min] = temp;
        }
    }
}
