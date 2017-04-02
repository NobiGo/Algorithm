package dx.com.three;

/**
 * Created by dx on 2017/3/31.
 */
public class Example314 {
    public static void main(String[] args) {
        SequentialSearchST<String, String> st = new SequentialSearchST<String, String>();
        st.put("wwj", "12");
        st.put("wwj", "13");
        st.put("wwj", "15");
        System.out.println(st.get("wwj"));
        st.put("dx", "12");
        System.out.println(st.get("dx"));

        st.printST();
        st.delete("dx");
        st.printST();

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

    //打印符号表中的元素
    public void printST() {
        System.out.println("符号表中的元素为：");
        Node node = head;
        while (node != null) {
            System.out.println(node.key + "===========" + node.value);
            node = node.Next;
        }
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


    //获取符号表的长度
    public int length() {
        return length;
    }

    //删除符号表中的元素
    public void delete(Key key) {
        //元素存在于符号表中
        if (get(key) != null) {
            if (head.key.compareTo(key) == 0) {
                head = head.Next;
                return;
            } else {
                Node preNode = head;
                Node node = head.Next;
                for (; node != null; node = node.Next) {
                    if (node.key.compareTo(key) == 0) {
                        preNode.Next = node.Next;
                    } else {
                        preNode = node;
                        node = node.Next;
                    }
                }
                length--;
            }
        } else {
            System.out.println("表中元素不存在");
        }
    }


    //键中添加元素
    public void put(Key key, Value value) {
        if (get(key) == null) {
            length++;
            head = new Node(key, value, head);
        } else {
            Node node = head;
            for (; node != null; node = node.Next) {
                if (node.key.compareTo(key) == 0) {
                    node.value = value;
                    break;
                }
            }
        }
    }

}