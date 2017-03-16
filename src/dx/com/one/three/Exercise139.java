package dx.com.one.three;

import java.util.Stack;


/**
 * Created by dx on 2017/3/16.
 */

public class Exercise139 {
    private String completeParentese(String str) {
        //操作符栈
        Stack<String> optrStack = new Stack<>();
        //操作数栈
        Stack<String> dataStack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (isDigit(str.charAt(i))) {
                // 处理数字的情况
                dataStack.push(String.valueOf(str.charAt(i)));
            } else if (isOpeartor(str.charAt(i))) {
                // 处理操作符的情况
                optrStack.push(String.valueOf(str.charAt(i)));
            } else {
                // 处理右括号的情况
                String d2 = dataStack.pop();
                String d1 = dataStack.pop();
                String opt = optrStack.pop();
                //将整个算式压入操作数栈
                String exstr = "(" + d1 + opt + d2 + ")";
                dataStack.push(exstr);
            }
        }
        return dataStack.pop();
    }

    private boolean isOpeartor(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public static void main(String[] args) {
        String str = "1+2*3）-4*5-6)))";
        Exercise139 cp = new Exercise139();
        String res = cp.completeParentese(str);
        System.out.println(res);
    }
}