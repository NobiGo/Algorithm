package dx.com.one.three;

import com.algs4.stdlib.StdIn;

import java.util.Iterator;

/**
 * Created by dx on 2017/3/16.
 */
public class Exercise1315 {
    public static void main(String[] args) {
        MyQueue<String> myQueue = new MyQueue<String>();
        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();
            if("-".equals(str))
                break;
            myQueue.push(str);
        }
        System.out.println("=======================");
        System.out.println("队列的长度为："+myQueue.size());
        int value = StdIn.readInt();
        int size = myQueue.size()-value+1;
        for (int i = 1; i <= size; i++) {
            if (i == size)
                System.out.println(myQueue.pop());
            else
                myQueue.pop();
        }
    }
}

class MyQueue<Item> implements Iterable<Item> {

    //定义结构
    private class Node {
        Item item;
        Node next;
    }

    //定义队列的首与尾
    private Node head;
    private Node tail;
    //队列长度
    private int length;

    //获得长度
    public int size() {
        return length;
    }

    //队列是否为空
    public boolean isEmpty() {
        return head == null;
    }

    //队尾加入队列
    public void push(Item item) {
        Node oldTail = tail;
        tail = new Node();
        tail.next = null;
        tail.item = item;
        if (isEmpty()) {
            head = tail;
        } else {
            oldTail.next = tail;
        }
        length++;
    }

    //出队列
    public Item pop() {
        Item item;
        item = head.item;
        head = head.next;
        if (isEmpty())
            tail = null;
        length--;
        return item;
    }


    @Override
    public Iterator<Item> iterator() {
        return new MyQueueIterator();
    }

    public class MyQueueIterator implements Iterator<Item> {
        Node current = head;

        @Override
        public boolean hasNext() {
            return current == null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}
