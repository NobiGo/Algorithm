package dx.com.one.three;

import java.util.Iterator;

/**
 * Created by dx on 2017/3/15.
 */
public class LinkStats<Item> implements Iterable {

    //定义节点结构
    private class Node {
        Item item;
        Node Next;
    }

    //定义首节点内容
    private Node first;
    private int length;

    @Override
    public Iterator iterator() {
        return new StatsIterator();
    }

    private class StatsIterator implements Iterator<Item> {

        Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.Next;
            return item;
        }
    }

    //判断是否为空
    public boolean isEmpty() {
        return first.Next == null;
    }

    //判断节点的长度
    public int getLength() {
        return length;
    }

    //将元素压入栈
    public void push(Item item) {

            Node oldFirst = first;
            first = new Node();
            first.item = item;
            first.Next = oldFirst;
        length++;
    }

    //将栈顶元素出栈
    public Item pop() {
        Item value = first.item;
        first = first.Next;
        length--;
        return value;
    }
}
