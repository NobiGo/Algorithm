package dx.com.one.one;

import com.algs4.stdlib.StdIn;
import com.algs4.stdlib.StdOut;

import java.util.Random;

/**
 * Created by dx on 2017/3/12.
 */
public class Exercise {

    public static void main(String[] args) {
//        method113();
//        method115();
//        method117c();
//        method119();
//        method1111();
//        method1114();
        method1115();
    }


    /**
     * 1.1.3
     */
    public static void method113() {
        int[] value = new int[3];
        int i = 0;
        StdOut.println(value.length);
        while (i < value.length) {
            value[i] = StdIn.readInt();
            i++;
        }
        if ((value[0] == value[1]) && (value[1] == value[2])) {
            StdOut.println("equal");
        } else
            StdOut.println("not equal");
    }

    /**
     * 1.1.5
     */
    public static void method115() {
        double x, y;
        x = StdIn.readDouble();
        y = StdIn.readDouble();
        StdOut.print((x <= 1 && x >= 0) && (y >= 0 && y <= 1));
    }

    /**
     * 1.1.7C
     */

    public static void method117c() {
        int sum = 0;
        for (int i = 1; i < 1000; i *= 2) {
            for (int j = 0; j < 1000; j++) {
                sum++;
            }
        }
        StdOut.print(sum);
    }

    /**
     * 1.1.9
     * 将一个正整数N用二进制数表示并转换为一个String类型的值S
     */

    public static void method119() {
        int n = 10;
        String value = "";
        StdOut.println(Integer.toBinaryString(n));

        for (int i = n; i > 0; i /= 2) {
            value = i % 2 + value;
        }
        /**
         //单线程使用Stringbuilder
         StringBuilder stringBuilder = new StringBuilder(value);
         StdOut.print(stringBuilder.reverse());
         **/
        StdOut.print(value);
    }

    /**
     * 1.1.11
     * 打印出二维布尔数组的内容
     */
    public static void method1111() {
        boolean[][] booleans = new boolean[3][4];
        Random random = new Random();
        for (int i = 0; i < booleans.length; i++) {
            for (int j = 0; j < booleans[i].length; j++) {
                //Math.random方法生成【0,1）之间的随机小数
                if (Math.random() > 0.5) {
                    booleans[i][j] = true;
                    StdOut.print("  *");
                } else {
                    booleans[i][j] = false;
                    StdOut.print("  -");
                }
            }
            StdOut.println();
        }

    }

    /**
     * 1.1.14
     * 返回不大于log2N的最大整数
     */

    public static void method1114() {
        int n = 100;
        int value = 0;
        int temp = 2;
        while (temp < n) {
            temp = temp * 2;
            value++;
        }
        StdOut.print(value);
    }

    /***
     * 1.1.15
     * 随机获取0，M-1之间的整数
     */

    public static void method1115() {
        //方案1 获取随机数
        for (int i = 0; i <= 100; i++) {
            int value = (int)(Math.random()*4);
            StdOut.println(value);
        }

        System.out.println("======================================");
        //方案二 获取随机数
        Random random = new Random();
        for(int i = 0;i<=100;i++)
            System.out.println(random.nextInt(5));

    }

}
