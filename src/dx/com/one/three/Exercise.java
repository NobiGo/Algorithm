package dx.com.one.three;

import com.algs4.stdlib.StdIn;
import org.junit.Test;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by dx on 2017/3/15.
 */
public class Exercise {

    public static void parentheses134() {
        Stack<String> stack = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();
            System.out.println(str);
            if ("(".equals(str))
                stack.push(str);
            else if ("[".equals(str))
                stack.push(str);
            else if ("{".equals(str))
                stack.push("{");
            else if (")".equals(str)) {
                String value = stack.pop();
                if (!value.equals("(")) {
                    stack.push(value);
                    break;
                }
            } else if ("]".equals(str)) {
                String value = stack.pop();
                if (!value.equals("[")) {
                    stack.push(value);
                    break;
                }
            } else if ("}".equals(str)) {
                String value = stack.pop();
                if (!value.equals("{")) {
                    stack.push(value);
                    return;
                }
            }
        }

        if (stack.size() == 0)
            System.out.println("true");
        else
            System.out.println("false");
    }
}

 class stack<Item> {
    //定义节点
    private class Node {
        Item item;
        Node Next;
    }

    //定义栈顶元素
    Node first;
    //定义栈的长度
    int length;

    public int size() {
        return length;
    }

    //将元素入栈
    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.Next = oldFirst;
        length++;
    }

    //元素出栈
    public Item pop() {
        Node node = first;
        Item item = node.item;
        first = first.Next;
        length--;
        return item;
    }




}