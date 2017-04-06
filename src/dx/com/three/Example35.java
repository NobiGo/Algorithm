package dx.com.three;

/**
 * Created by dx on 2017/4/6.
 */
public class Example35 {

}

class SeparateChainingHashST<Key extends Comparable<Key>, Value> {
    private int N;//键值对总数
    private int M;//散列表的大小
    private SequentialSearchST<Key, Value>[] st;//存放链表对象的数组

    public SeparateChainingHashST() {
        this(997);
    }

    public SeparateChainingHashST(int M) {
        this.M = M;
        //Java中不能声明泛型数组
        st = (SequentialSearchST<Key, Value>[]) new Object[M];
        for (int i = 0; i < st.length; i++) {
            st[i] = new SequentialSearchST<Key, Value>();
        }
    }

    private int hash(Key key) {
        //去除符号位
        return ((key.hashCode() & 0x7fffffff) % M);
    }

    public Value get(Key key) {
        return st[hash(key)].get(key);
    }

    public void put(Key key, Value value) {
        st[hash(key)].put(key, value);
    }


}
