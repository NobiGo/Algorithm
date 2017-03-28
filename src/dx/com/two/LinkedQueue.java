package dx.com.two;

import java.util.Iterator;

/**
 * Created by dx on 2017/3/27.
 */
public class LinkedQueue<Item> implements Iterable {
    @Override
    public Iterator iterator() {
        return new LinkedQueueIterator();
    }

    private class LinkedQueueIterator implements Iterator<Item> {
        Node temp = head;

        @Override
        public boolean hasNext() {
            return temp != null;
        }

        @Override
        public Item next() {
            Item item = temp.item;
            temp = temp.Next;
            return item;
        }
    }


    //定义节点结构
    private class Node {
        Item item;
        Node Next;
    }

    //定义队列的首节点
    private Node head;
    private Node tail;
    //定义链表的长度
    private int length = 0;

    //判断是否为空
    public boolean isEmpty() {
        return head == null;
    }

    //获取链表的长度
    public int size() {
        return length;
    }

    //添加队列的元素
    public void enqueue(Item item) {
        Node oldTail = tail;
        //对结点进行初始化
        tail = new Node();
        tail.item = item;
        tail.Next = null;
        //判断是否为空节点
        if (isEmpty())
            head = tail;
        else
            oldTail.Next = tail;
        length++;
    }

    //删除队列元素
    public Item dequeue() {
        Item item = head.item;
        head = head.Next;
        if (isEmpty()) tail = null;
        length--;
        return item;
    }

    //打印队列
    public void printQueue() {
        Iterator<Item> itemIterator = this.iterator();
        while (itemIterator.hasNext()) {
            Item node = (Item) itemIterator.next();
            System.out.println(node.toString());
        }

    }
}
