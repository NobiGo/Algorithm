package dx.com.three;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dx on 2017/4/3.
 */
public class Example33 {
    String str;
    Object object;
}

class BST<Key extends Comparable<Key>, Value> {
    //定义树的节点结构
    private class Node {
        Key key;//键
        Value value;//值
        Node left, right;//左右指针
        int number;//以该节点为根的子树中包含的多加点总数

        //初始化节点
        public Node(Key key, Value value, int number) {
            this.key = key;
            this.value = value;
            this.number = number;
        }
    }

    //定义二插查找树的根节点
    private Node root;

    public Key min() {
        return min(root).key;
    }

    //返回树中的最小结点
    private Node min(Node node) {
        if (node.left == null)
            return node;
        return min(node.left);
    }

    //返回树中的最大结点
    public Key max() {
        return max(root).key;
    }


    //返回树中的最大结点
    private Node max(Node node) {
        if (node.right == null)
            return node;
        return max(node.right);
    }

    //返回总的结点个数
    public int size() {
        return size(root);
    }

    //返回以Node结点为根节点的结点个数
    private int size(Node node) {
        if (node == null)
            return 0;
        else
            return node.number;
    }

    //获取键对应的相应的值
    public Value get(Key key) {
        return get(root, key);
    }


    //获得小于等于Key的最大值
    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null)
            return null;
        return x.key;
    }

    //获得小于等于Key的最大值
    private Node floor(Node node, Key key) {
        //判断节点是否为空，空返回null
        if (node == null)
            return null;
        //将根节点与节点的key值进行比表
        int cmp = key.compareTo(node.key);
        //找到等于该节点的节点
        if (cmp == 0)
            return node;
        if (cmp < 0)
            return floor(node.left, key);
        Node temp = floor(node.right, key);
        if (temp != null)
            return temp;
        else
            return node;
    }

    //在以node为根节点的树下，获得key对应的value值
    private Value get(Node node, Key key) {
        //如果node为空，则返回null
        if (node == null)
            return null;
        //观察节点与key的比较值，如果结点的值大，则在左子树中进行查找，否则在右子树中进行查找
        int cmp = node.key.compareTo(key);
        if (cmp < 0)
            return get(node.left, key);
        else if (cmp > 0)
            return get(node.right, key);
        else
            //当cmp==0时，说明查找到相应的值
            return node.value;
    }

    //向二叉树中插入值
    public void put(Key key, Value value) {
        put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null)
            return new Node(key, value, 1);
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            put(node.left, key, value);
        else if (cmp > 0)
            put(node.right, key, value);
        else
            node.value = value;
        node.number = size(node.left) + size(node.right) + 1;
        return node;
    }

    public Key select(int k) {
        return select(root, k).key;
    }

    private Node select(Node node, int k) {
        if (node == null)
            return null;
        int number = node.left.number;
        if (number > k)
            return select(node.left, k);
        else if (k > number)
            return select(node.right, k - number - 1);//其中1为根节点
        return node;
    }

    //删除数结点中的最小值
    public void deleteMin() {
        root = deleteMin(root);
    }

    //删除最小值
    private Node deleteMin(Node node) {
        if (node.left == null)
            return node.right;
        node.left = deleteMin(node.left);
        node.number = 1 + size(node.left) + size(node.right);
        return null;
    }

    //删除特定键
    public void delete(Key key) {
        root = delete(key, root);
    }

    private Node delete(Key key, Node node) {
        if (node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = delete(key, node.left);
        else if (cmp > 0)
            node.right = delete(key, node.right);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            Node temp = node;
            node = min(temp.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }
        node.number = size(node.left) + size(node.right) + 1;
        return node;
    }

    //返回指定键在键中的排名
    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node node) {
        if (node == null)
            return 0;
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            return rank(key, node.left);
        else if (cmp > 0)
            return 1 + size(node.left) + rank(key, node.right);
        else
            return size(node.left);//size返回每个节点以下包含的节点总数
    }


    //中序遍历
    public void print(Node node) {
        if (node == null)
            return;
        print(node.left);
        System.out.println(node.key);
        print(node.right);
    }

    //二插查找树的范围查找操作
    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    private Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new LinkedList<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node node, Queue queue, Key lo, Key hi) {
        if (node == null)
            return;
        int cmplo = lo.compareTo(node.key);
        int cmphi = hi.compareTo(node.key);
        if (cmplo < 0)
            keys(node.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0)
            queue.offer(node.key);
        else if (cmplo > 0)
            keys(node.right, queue, lo, hi);
    }
}
