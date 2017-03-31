package dx.com.two;

/**
 * Created by dx on 2017/3/31.
 */
public class Exercise243_Order {

    public static void main(String[] args) {
        MaxarrayOrder<String> maxArraysOrder = new MaxarrayOrder<String>(4);
        maxArraysOrder.insert("q");
        maxArraysOrder.insert("a");
        maxArraysOrder.insert("z");
        maxArraysOrder.insert("w");
        System.out.println(maxArraysOrder.delMax());
        System.out.println(maxArraysOrder.delMax());
        System.out.println(maxArraysOrder.delMax());
        System.out.println(maxArraysOrder.delMax());
    }
}

class MaxarrayOrder<Item extends Comparable<Item>> {
    //用于保存数据元素
    private Item[] values;
    //用于保存元素的个数
    private int number;

    MaxarrayOrder(int number) {
        //初试化容量
        values = (Item[]) new Comparable[number + 1];
    }

    private boolean less(int i, int j) {
        return values[i].compareTo(values[j]) < 0;
    }

    //交换两元素的值
    private void exch(int i, int j) {
        Item item = values[i];
        values[i] = values[j];
        values[j] = item;
    }

    //插入元素(保证元素按照从大到小排列)
    public void insert(Item item) {
        values[++number] = item;
        int k = number;
        while (k > 1 && less(k - 1, k)) {
            exch(k - 1, k);
            k--;
        }
    }

    //删除最大元素
    public Item delMax() {
        Item item = values[1];
        for (int i = 2; i <= number; i++) {
            values[i - 1] = values[i];
        }
        values[number--] = null;
        return item;
    }


}