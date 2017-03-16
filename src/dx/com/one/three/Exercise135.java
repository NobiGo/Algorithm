package dx.com.one.three;

import com.algs4.stdlib.StdIn;

import java.util.Iterator;

/**
 * Created by dx on 2017/3/16.
 */
public class Exercise135 {
    /**
     * 利用栈打印整数的二进制
     */
    public static void main(String[] args) {
        System.out.println("开始运行");
        int value = 0;
        while (!StdIn.isEmpty())
            value = StdIn.readInt();
        System.out.println("value的值为" + value);
        BStack bStack = new BStack();
        while (value > 0) {
            bStack.push(value % 2);
            value = value / 2;
        }
        Iterator<Integer> interator = bStack.iterator();
        while (interator.hasNext())
            System.out.println(interator.next());
    }
}

class BStack implements Iterable {

    //定义栈顶元素
    Node first;
    //定义栈的长度
    int length;

    //定义节点的结构
    private class Node {
        Integer item;
        Node next;
    }

    @Override
    public Iterator iterator() {
        return new BStackIterator();
    }

    private class BStackIterator implements Iterator<Integer> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Integer next() {
            Integer integer = current.item;
            current = current.next;
            return integer;
        }
    }

    //将元素压入栈
    void push(Integer value) {
        Node oldFirst = first;
        first = new Node();
        first.item = value;
        first.next = null;
        first.next = oldFirst;
        length++;
    }

    //将元素出栈
    Integer pop() {
        Node node = first;
        Integer item = node.item;
        first = first.next;
        length--;
        return item;
    }

    //得到栈的大小
    public int size() {
        return this.length;
    }

}
