package dx.com.one.three;

/**
 * Created by dx on 2017/3/16.
 */

import com.algs4.stdlib.StdIn;

/**
 * 思路：
 * 用两个指针来实现
 * 一个指针用来循环到最后一个元素
 * 一个指针用来循环到要删除元素的上一个元素
 */
public class Exercise1319 {
    public static void main(String[] args) {
        Link<String> link = new Link<String>();
        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();
            if (!"-".equals(str))
                      link.add(str);
            else
                break;
        }
        link.printLinked();
        link.delete(2);
        link.printLinked();
    }
}

class Link<Item> {
    //设置节点的结构
    private class Node {
        Item item;
        Node Next;
    }

    //链表的头结点
    Node first;
    //长度
    int length;

    //获取链表的长度
    int getLength() {
        return length;
    }

    //在链头加入元素
    public void add(Item item) {
        Node oldHead = first;
        first = new Node();
        first.item = item;
        first.Next = oldHead;
        length++;
    }

    /**
     * 1.3.20
     * @param k
     */
    //删除链表的第k个元素
    public void delete(int k){
        if(k>length) {
            System.out.println("K超出范围");
            return;
        }
        if(k==1)
        {
            first = first.Next;
            return ;
        }
        Node node = first;
        int i = 2;
        while(i<=k-1){
                node = node.Next;
                i++;
        }
        node.Next = node.Next.Next;
    }

    //删除链表的尾节点
    public Item delete(){
        //特殊情况：只有一个节点
        if(first.Next==null)
        {
            Item item = first.item;
            first = null;
            return  item;
        }
        //保存尾节点的前一个节点
        Node  qTail = first;
        //保存尾节点
        Node  tail = qTail.Next;
        while(tail.Next != null){
            qTail = qTail.Next;
            tail = qTail.Next;
        }
        qTail.Next = null;
        Item item = tail.item;
        length--;
        return item;
    }

    public void printLinked(){
        Node  node  = first;
        StringBuilder sb = new StringBuilder();
        while(node!=null){
            sb.append(node.item+"===");
            node = node.Next;
        }
        System.out.println(sb.toString());
    }
}

