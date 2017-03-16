package dx.com.one.three;

import java.util.Iterator;

/**
 * Created by dx on 2017/3/15.
 */
public class LinkedQueue<Item> implements Iterable<Item> {
    //节点的结构
    private class Node {
        Item item;
        Node Next;
    }

    //定义节点的首节点和尾节点
    private Node first;
    private Node last;
    int length;

    @Override
    public Iterator iterator() {
        return new QueueIterator();
    }

    public class QueueIterator implements Iterator<Item> {

        Node node = first;

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public Item next() {
            Item item = node.item;
            node = node.Next;
            return item;
        }
    }


    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return length;
    }


    //进入队列
    public void enqueue(Item item) {
        Node oldLast = last;
        Node node = new Node();
        node.item = item;
        node.Next = null;
        if (isEmpty()) {
            first = node;
            last = first;
        } else {
            node.Next = last;
            last = node;
        }
        length++;
    }

    //出队列
    public Item dequeue() {
        Item item;
        if (length == 1) {
            Node node = first;
            item = node.item;
            first = null;
            last = null;
        } else {
            Node node = first;
            item = node.item;
            first = first.Next;
        }
        length--;
        return item;
    }
}
