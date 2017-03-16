package dx.com.one.three;

import com.algs4.stdlib.StdIn;

/**
 * Created by dx on 2017/3/16.
 */
public class Exercixe137 {

    public static void main(String[] args) {

        String value;
        Stack<String> stack = new Stack<String>();
        while (!StdIn.isEmpty()) {
            value = StdIn.readString();
           if("-".equals(value))
               System.out.println(stack.peek());
            else
               stack.push(value);
        }

        System.out.println(stack.pop());
    }
}

class Stack<Item> {
    //定义栈顶元素
    private Node first;
    //定义栈的长度
    private  int  length;

    private class Node{
        Item  item;
        Node  Next;
    }
    //压入元素
    public void push(Item  item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.Next = oldFirst;
        length++;
    }
    //弹出元素
    public Item pop(){
        Node  node = first;
        Item item  = first.item;
        first = first.Next;
        length--;
        return  item;
    }
    //得到栈的长度
    public int getSize(){
        return length;
    }

    //返回栈中最新添加的元素
    public  Item  peek(){
        Item value = pop();
        push(value);
        return value;
    }
 }