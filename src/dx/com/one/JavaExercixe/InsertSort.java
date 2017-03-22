package dx.com.one.JavaExercixe;

/**
 * Created by dx on 2017/3/21.
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arrays = {1, 3, 4, 5, 76, 2, 45};
        insertSortMethod(arrays);
        for (int i : arrays) {
            System.out.println(i);
        }
    }

    //将一个元素插入到有序的元素中
    public static void insertSortMethod(int[] arrays) {
        //外循环控制需要进行插入的元素
        for (int i = 1; i < arrays.length; i++) {
            //待插入元素
            int temp = arrays[i];
            //查找待插入元素的插入位置
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (temp <= arrays[j])
                    arrays[j + 1] = arrays[j];
                else
                    break;
            }
            arrays[j + 1] = temp;
        }
    }
}
