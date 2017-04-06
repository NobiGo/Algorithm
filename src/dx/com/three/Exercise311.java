package dx.com.three;

import com.algs4.stdlib.StdIn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dx on 2017/4/2.
 */
public class Exercise311 {
    public static void main(String[] args) {
        ST<String, String> st = new ST<String, String>(16);
        while (StdIn.hasNextLine()) {
            String string = StdIn.readLine();
            if (!string.equals("-")) {
                String[] values = string.split(",");
                st.put(values[0], values[1]);
            } else
                break;
        }
        double d = 0.0;
        int i = 0;
        Iterable<String> iterable = st.Keys();
        for (String str : iterable) {
            System.out.println(str);
            d += Double.valueOf(st.get(str));
            i++;
        }
        System.out.println(d / i);
    }
}

class ST<Key extends Comparable<Key>, Value> {

    //利用数组保存符号表中的值
    private Key[] keys;//保存键
    private Value[] values;//保存值
    //符号表中元素的个数
    private int number;

    //构造方法
    public ST(int cap) {
        keys = (Key[]) new Comparable[cap];
        values = (Value[]) new Object[cap];
    }

    //判断符号表是否为空
    public boolean isEmpty() {
        return number == 0;
    }

    //根据键获得相应的值
    public Value get(Key key) {
        int i = rank(key);
        if (i < number && key.compareTo(keys[i]) == 0)
            return values[i];
        else
            return null;
    }

    //返回Key值在符号表中的位置（不管存在不存在）
    public int rank(Key key) {
        int lo = 0;
        int hi = number - 1;
        while (lo <= hi) {
            //获得中间值
            int mid = lo + (hi - lo) / 2;
            //将中间值与key进行比较
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0)
                hi = mid - 1;
            else if (cmp > 0)
                lo = mid + 1;
            else
                return mid;
        }
        return lo;
    }

    //符号表中插入元素
    public void put(Key key, Value value) {
        int i = rank(key);
        if (i < number && key.compareTo(keys[i]) == 0) {
            //同一个元素改变值
            values[i] = value;
            return;
        }
        for (int j = number - 1; j >= i; j--) {
            keys[j + 1] = keys[j];
            values[j + 1] = values[j];
        }
        keys[i] = key;
        values[i] = value;
        number++;
    }

    public Iterable<Key> Keys() {
        Queue<Key> queue = new LinkedList<Key>();
        for (int i = 0; i < number; i++) {
            queue.offer(keys[i]);
        }
        return queue;
    }
}