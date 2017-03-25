package dx.com.two;

/**
 * Created by dx on 2017/3/24.
 */
public class Exercise2111 {

    /**
     * 将希尔排序中实时计算递增序列改为预先计算并且保存在一个数组中
     */

    public static void ShellSort2111(int[] arrays) {
        //获取字符串的长度
        int length = arrays.length;
        //设置递增标志
        int temp = 1;
        //保存递增序列
        int i = 0;
        int[] flag = new int[length];
        while (temp < length / 3) {
            flag[i++] = temp;
            temp = temp * 3 + 1;
        }
        flag[i] = temp;

        System.out.println("递增序列为：");
        for(int s:flag){
            System.out.println(s);
        }
        System.out.println("============");
        while (i >= 0) {
            for (int j = flag[i]; j < length; j++) {
                for (int m = j; m >= flag[i]; m -= flag[i]) {
                    if (arrays[m] < arrays[m - flag[i]]) {
                        arrays[m] = arrays[m] + arrays[m - flag[i]];
                        arrays[m - flag[i]] = arrays[m] - arrays[m - flag[i]];
                        arrays[m] = arrays[m] - arrays[m - flag[i]];
                    }
                }
            }
            i--;
        }
    }


    public static void main(String[] args) {
        int []  arrays = {1,4,7,98,0,2,34};
        ShellSort2111(arrays);
        for(int i : arrays){
            System.out.println(i);
        }
    }
}
