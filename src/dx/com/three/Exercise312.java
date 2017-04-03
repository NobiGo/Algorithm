package dx.com.three;

import java.util.LinkedList;

/**
 * Created by dx on 2017/4/3.
 */
public class Exercise312 {
    public static void main(String[] args) {

        ArrayST<String, String> st = new ArrayST<String, String>(10);
        st.put("wwj", "12");
        st.put("wwj", "13");
        st.put("wwj", "15");
        System.out.println(st.size());
        System.out.println(st.get("wwj"));
        st.put("dx", "12");
        System.out.println(st.get("dx"));

        Iterable<String> iterable = st.keys();
        for (String value : iterable) {
            System.out.println(value);
        }


    }
}

class ArrayST<Key extends Comparable<Key>, Value> {
    //将数据保存在数组
    private Key[] keys;//保存键
    private Value[] values;//保存值
    //符号表中元素的个数
    private int length;

    //判断符号表是否为空
    public boolean isEmpty() {
        return length == 0;
    }

    //返回表中的键值对数量
    public int size() {
        return length;
    }

    //返回表中所有键的集合
    public Iterable<Key> keys() {
        java.util.Queue<Key> queue = new LinkedList<Key>();
        for (int i = 0; i < length; i++) {
            queue.offer(keys[i]);
        }
        return queue;
    }

    //构造函数初始化队列
    public ArrayST(int cap) {
        //Java中不能建立泛型数组
        keys = (Key[]) new Comparable[cap];
        values = (Value[]) new Object[cap];
    }

    //返回key值在keys中的位置（如果包含），如果不包含的话，返回该插入的索引
    private int contains(Key key) {
        for (int i = 0; i < length; i++) {
            if (key.compareTo(keys[i]) == 0)
                return i;
        }
        return length;
    }

    //将键值保存在符号表中
    public void put(Key key, Value value) {
        int index = contains(key);
        if (index == length) {
            keys[length] = key;
            values[length] = value;
            length++;
        } else {
            values[index] = value;
        }
    }

    //获取键key对应的值
    public Value get(Key key) {
        int i = contains(key);
        if (i == length)
            return null;
        else
            return values[i];
    }

    //从表中删除键key
    public void delete(Key key) {
        int index = contains(key);
        if (index == length)
            System.out.println("符号表中不存在相应的键值");
        else {
            for (int j = length - 1; j >= index + 1; j++) {
                keys[j - 1] = keys[j];
                values[j - 1] = values[j];
            }
            length--;
        }
    }
}