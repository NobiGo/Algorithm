package dx.com.two;


/**
 * Created by dx on 2017/3/31.
 */
public class Exercise243_noOrder {
    public static void main(String[] args) {
        MaxArraysNoOrder<String> maxArraysNoOrder = new MaxArraysNoOrder<String>(3);
        maxArraysNoOrder.insert("q");
        maxArraysNoOrder.insert("a");
        maxArraysNoOrder.insert("z");
        maxArraysNoOrder.insert("w");
        System.out.println(maxArraysNoOrder.delMax());
        System.out.println(maxArraysNoOrder.delMax());
        System.out.println(maxArraysNoOrder.delMax());
        System.out.println(maxArraysNoOrder.delMax());
    }
}


class MaxArraysNoOrder<Item extends Comparable<Item>> {
    //保存二叉堆中的元素
    private Item[] values;
    //b保存二插堆中元素的个数(元素保存在【1-----number中】)
    public int number;

    public MaxArraysNoOrder(int cap) {
        values = (Item[]) new Comparable[cap + 1];
    }

    //交换两元素的位置
    private void swap(int i, int j) {
        Item item = values[i];
        values[i] = values[j];
        values[j] = item;
    }

    //判断量元素的大小
    private boolean less(int i, int j) {
        return values[i].compareTo(values[j]) < 0;
    }

    //将元素上浮到正确位置
    public void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            swap(k / 2, k);
            k = k / 2;
        }
    }

    //将元素下沉到正确位置
    public void sink(int k) {
        while (2 * k <= number) {
            int j = 2 * k;
            if (j < number && less(j, j + 1)) j++;
            if (less(j, k))
                break;
            swap(j, k);
            k = j;
        }
    }

    //改变数组元素的大小
    public void size(int cap) {
        Item[] arrays = (Item[]) new Comparable[cap + 1];
        for (int i = 1; i <= number; i++) {
            arrays[i] = values[i];
        }
        values = arrays;

    }

    //向二插堆中插入元素
    public void insert(Item item) {
        if (number == values.length - 1)
            size(values.length * 2);
        values[++number] = item;
        swim(number);
    }

    //删除二插堆中的最大元素
    public Item delMax() {
        if (number == 0)
            return null;
        swap(1, number);
        Item item = values[number--];
        sink(1);
        values[number + 1] = null;
        if (number == values.length / 4)
            size(values.length / 2);
        return item;

    }
}