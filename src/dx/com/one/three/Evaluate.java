package dx.com.one.three;

import com.algs4.stdlib.StdIn;
import com.algs4.stdlib.StdOut;

import java.util.Stack;

/**
 * Created by dx on 2017/3/14.
 */
public class Evaluate {
    public static void main(String[] args) {
        //用来保存操作符
        Stack<String> ops = new Stack<String>();
        //用来保存操作数
        Stack<Double> vals = new Stack<Double>();
        while (!StdIn.isEmpty()){
            String value = StdIn.readString();
            if(value.equals("("));
                else if (value.equals("+"))  ops.push("+");
                else if (value.equals("-"))  ops.push("-");
                else if (value.equals("*"))  ops.push("*");
                else if (value.equals("/"))  ops.push("/");
                else if (value.equals("sqrt")) ops.push("sqrt");
            else if(value.equals(")")){
                String op = ops.pop();
                Double value1 = vals.pop();
                if (op.equals("+"))  value1 = value1 + vals.pop();
                else if (op.equals("-")) value1 = value1 - vals.pop();
                else if (op.equals("*")) value1 = value1 * vals.pop();
                else if (op.equals("/")) value1 = value1 / vals.pop();
                else if (op.equals("sqrt")) value1 = Math.sqrt(value1);
                vals.push(value1);
            }
            else vals.push(Double.parseDouble(value));
        }
        StdOut.println(vals.pop());
    }
}
