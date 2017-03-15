package dx.com.one.JavaExercixe;

/**
 * Created by dx on 2017/3/14.
 */
public class MaxNum {
    public static void main(String[] args) {
    /**
     * Math.max()用来比较两个数的大小
     **/
    int [] arrays = {0,16,2,3,4,5,10,7,8,9};
     int value =    maxnum(arrays,0);
        System.out.println(value);
    }

    public static int maxnum(int [] arrays,int begin){
        if(arrays.length - begin == 1)
            return arrays[begin];
        else
            return Math.max(arrays[begin],maxnum(arrays,begin+1));
    }

}
