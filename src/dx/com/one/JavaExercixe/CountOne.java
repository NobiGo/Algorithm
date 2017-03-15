package dx.com.one.JavaExercixe;

/**
 * Created by dx on 2017/3/13.
 */
public class CountOne {
    public static void main(String[] args) {
    methodCountOne(7);
    }

    public static void methodCountOne(int n){
        int count  = 0;
        while(n>0){
            //判断最后一位是否为1
            if((n&1)==1)
                count ++;
            n>>=1;
        }
        System.out.println(count);
    }

}
