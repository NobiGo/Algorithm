package dx.com.two;

/**
 * Created by dx on 2017/3/24.
 */
public class Exercise2112 {

    public static void shellSort2112(int[] arrays) {
        //获取字符串的长度
        int length = arrays.length;
        //比较次数
        int number = 0;
        //设置递增的序列
        int flag = 1;
        while (flag < length / 3)
            flag = flag * 3 + 1;
        System.out.println("flag的值为" + flag);
        while (flag > 0) {
            for (int i = flag; i < length; i++) {
                for (int j = i; j >= flag; j -= flag) {
                    if (arrays[j] < arrays[j - flag]) {
                        arrays[j] = arrays[j] + arrays[j - flag];
                        arrays[j - flag] = arrays[j] - arrays[j - flag];
                        arrays[j] = arrays[j] - arrays[j - flag];
                    }
                    number = number + 1;
                }
            }
            System.out.println("递增元素："+flag+"======比较次数为："+number+"=====与数组大小的比为："+(double)number/length);
            flag = flag / 3;
            number = 0;
        }
    }


    public static void main(String[] args) {
        int[] arrays = {1, 4, 5, 7, 89, 76, 20};
        shellSort2112(arrays);
        for (int i : arrays) {
            System.out.println(i);
        }
    }
}
