package dx.com.one.one;

import com.algs4.stdlib.In;
import com.algs4.stdlib.Out;

/**
 * Created by dx on 2017/3/13.
 */
public class Example {
    public static void main(String[] args) {
        //将所有输入文件复制到输出流
        Out out = new Out(args[args.length-1]);
        for(int i = 0;i<args.length-1;i++){
            In in  = new In(args[i]);
            String value  = in.readAll();
            out.println(value);
            in.close();
        }
        out.close();
    }
}
