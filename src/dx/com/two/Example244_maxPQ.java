package dx.com.two;

/**
 * Created by dx on 2017/3/29.
 */
public class Example244_maxPQ {
    public static void main(String[] args) {
        MaxPQ<String> maxPQ = new MaxPQ<String>(5);
        maxPQ.insert("qeqe");
        maxPQ.insert("oeqe");
        maxPQ.insert("yeqe");
        maxPQ.insert("xeqe");
        maxPQ.insert("eeqe");
        while (!maxPQ.isEmpty())
            System.out.println(maxPQ.delMax());
    }
}

class MaxPQ<Key extends Comparable<Key>> {
    //用于保存数组的元素
    private Key[] pq;
    //保存元素的个数（存储于1-number中，pq[0]没有用）
    int number;

    public MaxPQ(int cap) {
        //java中不支持建立泛型数组
        pq = (Key[]) new Comparable[cap + 1];
    }

    //是否为空
    public boolean isEmpty() {
        return number == 0;
    }

    //返回大小
    public int size() {
        return number;
    }

    //比较两个元素的大小
    public boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    //插入元素
    public void insert(Key key) {
        pq[++number] = key;
        //调整结构至最佳位置
        swim(number);
    }

    //删除最大元素
    public Key delMax() {
        Key max = pq[1];
        pq[1] = pq[number--];
        //防止对象游离
        pq[number + 1] = null;
        //恢复堆的有序性
        sink(1);
        return max;
    }

    //交换两个元素的值
    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    //由下至上的堆有序化
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    //由上至下的堆有序化
    private void sink(int k) {
        while (2 * k <= number) {
            int j = 2 * k;
            if (j < number && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
}