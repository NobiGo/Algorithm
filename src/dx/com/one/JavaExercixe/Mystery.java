package dx.com.one.JavaExercixe;

/**
 * Created by dx on 2017/3/14.
 */
public class Mystery {
    public static void main(String[] args) {
        String string = "0123456789";
        System.out.println(mystery(string));

    }

    public static String mystery(String string){
        int N  = string.length();
        if(N<=1)
            return string;
        String a  = string.substring(0,N/2);
        String b  = string.substring(N/2,N);
        return mystery(b)+mystery(a);
    }

}
