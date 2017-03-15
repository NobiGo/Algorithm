package dx.com.one.JavaExercixe;

/**
 * 判断一个数是否为2的n次方
 * Created by dx on 2017/3/13.
 */
public class Power {
    public static void main(String[] args) {
        System.out.println(isPower2(4));
        System.out.println(isPower2(6));
    }

    public static boolean isPower2(int  n){
        if(n<1) return false;
        if((n&(n-1))==0)
            return true;
        return false;
    }

    public static boolean isPower1(int n){
        if(n<1)
            return false;
        int i = 1;
    while(i<=n){
        if(i==n)
            return true;
        i<<=1;
    }
    return false;
    }
}
