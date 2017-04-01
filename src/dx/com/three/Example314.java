package dx.com.three;

/**
 * Created by dx on 2017/3/31.
 */
public class Example314 {
    public static void main(String[] args) {
    }
}

class SequentialSearchST<Key extends Comparable<Key>, Value> {
    //头结点
    private Node head;
    //节点的长度
    int length;

    //定义节点的类型
    private class Node {
        Key key;
        Value value;
        Node Next;

        public Node(Key key, Value value, Node Next) {
            this.key = key;
            this.value = value;
            this.Next = Next;
        }
    }

    //获取元素的个数
    public int getSize() {
        return length;
    }

    //判断符号表是否为口空
    public boolean isEmpty() {
        return length == 0;
    }

    //获取相应键对应的值
    public Value get(Key key) {
        Node node = head;
        for (; node != null; node = node.Next) {
            if (node.key.compareTo(key) == 0)
                return node.value;
        }
        return null;
    }

    //键中添加元素
    public void put(Key key, Value value) {
        if (get(key) == null) {
            Node oldHead = head;
            Node node = new Node(key, value, oldHead);
        }else
        {
            
        }
    }

}