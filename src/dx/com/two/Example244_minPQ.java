package dx.com.two;

/**
 * Created by dx on 2017/3/29.
 */
public class Example244_minPQ {

    public static void main(String[] args) {
        minPQ<String> minPQ = new minPQ<>(3);
        minPQ.insert("a");
        minPQ.insert("q");
        minPQ.insert("e");
        minPQ.insert("r");
        minPQ.insert("y");
        minPQ.insert("e");
        while (!minPQ.isEmpty()) {
            System.out.println(minPQ.delMin());
        }

    }
}

//最小优先队列
class minPQ<Item extends Comparable<Item>> {
    //保存堆二叉树元素
    private Item[] pq;
    //元素数量(堆二叉树中的元素保存在pq[1]----pq[number]中)
    private int number = 0;

    //构造函数，指定默认二叉树大小
    public minPQ(int number) {
        pq = (Item[]) new Comparable[number + 1];
    }

    //判断二插堆是否为空
    public boolean isEmpty() {
        return number == 0;
    }

    //比较两元素的大小
    public boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    //交换两元素
    public void exch(int i, int j) {
        Item value = pq[i];
        pq[i] = pq[j];
        pq[j] = value;
    }

    //改变数组的大小
    public void size(int size) {
        if (size < number)
            return;
        Item[] values = (Item[]) new Comparable[size];
        for (int i = 1; i <= number; i++) {
            values[i] = pq[i];
        }
        pq = values;
    }

    //将元素上浮到正确位置，调整堆结构
    public void swim(int k) {
        while (k > 1 && less(k, k / 2)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    //将元素下沉到正确位置，调整堆结构
    public void sink(int k) {
        while (2 * k <= number) {
            //找出子节点中最小的元素
            int j = 2 * k;
            if (j < number && less(j + 1, j))
                j++;
            if (less(k, j))
                break;
            exch(k, j);
            k = j;
        }
    }

    //向二插堆中插入元素
    public void insert(Item item) {
        if (number == pq.length - 1)
            size(2 * pq.length);
        pq[++number] = item;
        swim(number);
    }

    //删除二插堆中的最小的元素
    public Item delMin() {
        Item value = pq[1];
        exch(1, number--);
        //维持堆结构稳定
        sink(1);
        //防止对象游离
        pq[number + 1] = null;
        if (number == pq.length / 4)
            size(pq.length / 2);
        return value;
    }
}