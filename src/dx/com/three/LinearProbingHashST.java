package dx.com.three;

/**
 * Created by dx on 2017/4/6.
 */
public class LinearProbingHashST<Key extends Comparable<Key>, Value> {
    private int N;//符号表中键值对的总数
    private int M;//线性探测表的大小

    public Key[] keys;//保存键
    public Value[] values;//保存值

    public LinearProbingHashST() {
        this(16);
    }

    public LinearProbingHashST(int cap) {
        keys = (Key[]) new Comparable[cap];
        //Java中不能建立泛型数组
        values = (Value[]) new Object[cap];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key) {
        int temp = hash(key);
        while (keys[temp] != null && key.compareTo(keys[temp]) != 0) {
            temp = (temp + 1) % M;
        }
        return values[temp];
    }

    public void push(Key key, Value value) {
        if (N >= M / 2)
            resize(2 * M);
        int i = 0;

        for (i = hash(key); keys[i] != null; i = (i + 1) % M)
            if (keys[i].compareTo(key) == 0) {
                values[i] = value;
                return;
            }

        keys[i] = key;
        values[i] = value;
        N++;
    }


    public boolean contains(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].compareTo(key) == 0)
                return true;
        }
        return false;
    }

    public void delete(Key key) {
        if (!contains(key))
            return;
        int i = hash(key);
        //hash值已经相同，只需要判断是否是同一对象
        while (!key.equals(keys[i]))
            i = (i + 1) % M;
        keys[i] = null;
        values[i] = null;
        i = (i + 1) % M;
        while (keys[i] != null) {
            Key tempKey = keys[i];
            Value tempValue = values[i];
            keys[i] = null;
            values[i] = null;
            N--;
            push(tempKey, tempValue);
            i = (i + 1) % M;
        }
        N--;
        if (N > 0 && N == M / 8)
            resize(M / 2);
    }

    private void resize(int M) {
        LinearProbingHashST<Key, Value> tempST;
        tempST = new LinearProbingHashST<Key, Value>(M);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null)
                tempST.push(keys[i], values[i]);
        }
        keys = tempST.keys;
        values = tempST.values;
        this.M = M;

//        Key[] tempKey = (Key[]) new Comparable[M];
//        Value[] tempValue = (Value[]) new Object[M];
//        //循环复制
//        for (int i = 0; i < N; i++) {
//            keys[i] = tempKey[i];
//            values[i] = tempValue[i];
//        }
//        keys = tempKey;
//        values = tempValue;
//        this.M = M;
    }


}
