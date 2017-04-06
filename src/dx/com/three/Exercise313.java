package dx.com.three;

/**
 * Created by dx on 2017/4/3.
 */
public class Exercise313 {
    public static void main(String[] args) {
        OrderedSequentialSearchST<String, String> st = new OrderedSequentialSearchST<String, String>();
        st.put("wwj", "12");
        st.put("wwj", "13");
        st.put("wwj", "15");
        System.out.println(st.get("wwj"));
        st.put("dx", "12");
        System.out.println(st.get("dx"));
    }
}

//使用有序链表来实现符号表
class OrderedSequentialSearchST<Key extends Comparable<Key>, Value> {
    //定义符号链表中节点的结构
    private class Node {
        Key key;
        Value value;
        Node Next;


        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    //定义头结点
    private Node head;
    //定义节点的数量
    public int number;

    //判断表是否为空
    public boolean isEmpty() {
        return number == 0;
    }

    //获取表中的键值对的数量
    public int size() {
        return number;
    }

    //构造函数
    public OrderedSequentialSearchST() {

    }


    public Node contain(Key key) {
        Node node = head;
        while (node != null) {
            if (key.compareTo(node.key) == 0)
                return node;
        }
        return null;
    }


    public void delete(Key key) {
        Node node = contain(key);
        if (node == null) {
            System.out.println("符号表中不包含此元素");
            return;
        }
        Node pre = null;
        Node temp = head;
        if (key.compareTo(temp.key) == 0) {
            head = head.Next;
            number--;
            return;
        }
        while (temp.key.compareTo(key) >= 0) {
            if (temp.key.compareTo(key) == 0) {
                break;
            } else {
                pre = temp;
                temp = temp.Next;
            }
        }
        number--;
        pre.Next = temp.Next;
    }

    //获取键key对应的值
    public Value get(Key key) {
        if (contain(key) == null)
            return null;
        else
            return contain(key).value;
    }

    //将键值存入表中
    public void put(Key key, Value value) {
        Node node = contain(key);
        if (node != null)
            node.value = value;
        else {
            Node pre = null;
            Node nodeCurrent = head;
            while (key.compareTo(nodeCurrent.key) < 0) {
                pre = nodeCurrent;
                nodeCurrent = nodeCurrent.Next;
            }
            Node temp = new Node(key, value);
            temp.Next = nodeCurrent;
            if (pre == null)
                head = temp;
            number++;
        }

    }
}