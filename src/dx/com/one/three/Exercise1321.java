package dx.com.one.three;

import com.algs4.stdlib.StdIn;

import java.util.Iterator;

/**
 * Created by dx on 2017/3/17.
 */
public class Exercise1321 {

    public static void main(String[] args) {
        MyLink<String> link = new MyLink<String>();
        while (!StdIn.isEmpty()) {
            String val = StdIn.readString();
            if ("-".equals(val))
                break;
            else
                link.add(val);
        }
        link.printLink();
        System.out.println(find(link,"as"));
    }

    public static  boolean find(MyLink link, String key) {
       Iterator<String>  iterator = link.iterator();
        while(iterator.hasNext()){
            if(iterator.next().equals(key))
                return true;
        }
        return false;
    }
}

class MyLink<Item> implements  Iterable<Item>{
    //节点结构
    private class Node {
        Item item;
        Node Next;
    }

    //链表的头节点
    Node head;

    @Override
    public Iterator<Item> iterator() {
        return new MyLinkIterator();
    }

    private class MyLinkIterator implements  Iterator<Item>{
        Node temp = head;
        @Override
        public boolean hasNext() {
            return temp!=null;
        }

        @Override
        public Item next() {
            Item item = temp.item;
            temp = temp.Next;
            return item;
        }
    }


    //链首添加节点
    public void add(Item item) {
        Node oldHead = head;
        head = new Node();
        head.item = item;
        head.Next = oldHead;
    }

    //遍历整个链表并打印
    public void printLink() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.item);
            temp = temp.Next;
        }
    }
    //删除特定节点的后序节点
    public void removeAfter(Node node){
        if(node==null)
            return ;
        if (node.Next!=null)
        node.Next = node.Next.Next;
    }
    //将特定节点插在给定节点的后面
    public void insertAfter(Node node,Node lateNode){
        if(node==null&&lateNode==null)
            return ;
        else {
            Node temp = node.Next;
            node.Next = lateNode;
            lateNode.Next = temp;
        }
    }
}
