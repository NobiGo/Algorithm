package dx.com.one.JavaExercixe;

/**
 * Created by dx on 2017/3/13.
 * 找出数组中出现一次的数
 */
public class FindNotDouble {
    public static void main(String[] args) {
        int [] arrays =  {1,1,2,2,3};
        int result   = 0;
        for(int  i = 0 ;i<arrays.length;i++){
            result ^= arrays[i];
        }
        System.out.println(result);
    }
}
