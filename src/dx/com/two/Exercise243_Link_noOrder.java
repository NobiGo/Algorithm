package dx.com.two;

/**
 * Created by dx on 2017/3/31.
 */
public class Exercise243_Link_noOrder {

    public static void main(String[] args) {
        MaxLincOrder<String> maxLincOrder = new MaxLincOrder<String>();
        maxLincOrder.insert("q");
        maxLincOrder.insert("a");
        maxLincOrder.insert("z");
        maxLincOrder.insert("w");
        System.out.println("元素添加成功");
        maxLincOrder.printLinc();
        System.out.println(maxLincOrder.delMax());
        System.out.println(maxLincOrder.delMax());
        System.out.println(maxLincOrder.delMax());
        System.out.println(maxLincOrder.delMax());
        System.out.println("运行完成");
    }
}

class MaxLincOrder<Item extends Comparable<Item>> {
    //链表的结构
    private class Node {
        Item item;
        Node Next;
    }

    //定义链表的头结点
    public Node head;
    //链表的长度
    public int length;

    //链表是否为空
    public boolean isEmpty() {
        return length == 0;
    }

    //插入元素
    public void insert(Item item) {
        Node oldNode = head;
        head = new Node();
        head.item = item;
        head.Next = null;
        head.Next = oldNode;
        length++;
    }

    public void printLinc() {
        Node node = this.head;
        while (node != null) {
            System.out.println(node.item.toString());
            node = node.Next;
        }
    }

    private boolean less(Item item1, Item item2) {
        return item1.compareTo(item2) < 0;
    }

    //删除链表中的最大的元素
    public Item delMax() {

        Node node = head;
        Node prenode = head;
        Node max = head;

        while (node.Next != null) {
            if (less(max.item, node.Next.item)) {
                max = node.Next;
                prenode = node;
            }
            node = node.Next;
        }

        if (max == head) {
            head = head.Next;
        } else {
            prenode.Next = max.Next;
        }
        length--;
        return max.item;
    }
}