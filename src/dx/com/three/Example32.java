package dx.com.three;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dx on 2017/4/2.
 */
public class Example32 {
    public static void main(String[] args) {
        BInarySearchST<String, String> st = new BInarySearchST<String, String>(10);
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

class BInarySearchST<Key extends Comparable<Key>, Value> {
    //定义符号表的存储位置
    private Key[] keys;
    private Value[] values;
    //定义符号表中元素的个数
    private int number;

    //获取符号表中元素的个数
    public int getLength() {
        return number;
    }

    //判断符号表是否为空
    public boolean isEmpty() {
        return number == 0;
    }

    //改变存储符号表的数组元素的大小
    public void size(int cap) {
        //Java中不能建立泛型数组
        Key[] tempKey = (Key[]) new Comparable[cap];
        Value[] tempValue = (Value[]) new Object[cap];
        //将元素赋值到新数组中
        for (int i = 0; i < number; i++) {
            tempKey[i] = keys[i];
            tempValue[i] = values[i];
        }
        //更新数组
        keys = tempKey;
        values = tempValue;
    }

    //构造方法指定数组的容器
    BInarySearchST(int cap) {
        keys = (Key[]) new Comparable[cap];
        values = (Value[]) new Object[cap];
    }

    //插入元素
    public void put(Key key, Value value) {
        int i = rank(key);
        if (i < number && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }
        for (int j = number - 1; j >= i; i--) {
            keys[j + 1] = keys[j];
            values[j + 1] = values[j];
        }
        keys[i] = key;
        values[i] = value;
        number++;
    }

    //查找元素
    public Value get(Key key) {
        if (isEmpty())
            return null;
        int i = rank(key);
        if (i < number && keys[i].compareTo(key) == 0)
            return values[i];
        else
            return null;
    }

    //rank方法返回的表中小于给定键的数量其实就是元素的存放位置或者是插入位置
    private int rank(Key key) {
        int lo = 0;
        int hi = number - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = keys[mid].compareTo(key);
            if (cmp < 0)
                hi = mid - 1;
            else if (cmp > 0)
                lo = mid + 1;
            else
                return mid;
        }
        return lo;
    }

    //删除元素
    public void delete(Key key) {
        int i = rank(key);
        if (i < number && keys[i].compareTo(key) == 0) {
            System.out.println("元素存在");
            for (int j = i + 1; j < number; j++) {
                keys[j - 1] = keys[j];
                values[j - 1] = values[j];
            }
            number--;
        } else {
            System.out.println("元素不存在");
        }
    }

    //打印符号表中的元素
    public void printST() {
        for (int i = 0; i < number; i++) {
            System.out.println(keys[i] + "================" + values[i]);
        }
    }

    //返回lo-hi中的所有键
    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new LinkedList<Key>();
        for (int i = rank(lo); i < rank(hi); i++) {
            queue.offer(keys[i]);
        }
        if (get(hi) != null)
            queue.offer(keys[rank(hi)]);
        return queue;
    }


}