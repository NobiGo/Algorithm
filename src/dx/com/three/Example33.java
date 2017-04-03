package dx.com.three;

/**
 * Created by dx on 2017/4/3.
 */
public class Example33 {
}

class BST<Key extends Comparable<Key>, Value> {
    //定义树的节点结构
    private class Node {
        Key key;//键
        Value value;//值
        Node left, right;//左右指针
        int number;//以该节点为根的子树中包含的节点个数

        public Node(Key key, Value value, int number) {
            this.key = key;
            this.value = value;
            this.number = number;
        }
    }


    public Key min() {
        return min(root).key;
    }

    private Node min(Node node) {
        if (node.left == null)
            return node;
        return min(node.left);

    }

    public Key max() {
        return max(root).key;
    }

    private Node max(Node node) {
        if (node.right == null)
            return node;
        return max(node.right);
    }


    //定义二插查找树的根节点
    private Node root;

    public int size() {
        return size(root);
    }

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


    private Node floor(Node node, Key key) {
        //判断节点是否为空，空返回null
        if (node == null)
            return null;
        //将根节点与节点的key值进行比表
        int cmp = node.key.compareTo(key);
        //找到等于该节点的节点
        if (cmp == 0)
            return node;
        //
        if (cmp < 0)
            return floor(node.left, key);
        Node temp = floor(node.right, key);
        if (temp != null)
            return temp;
        else
            return node;
    }

    private Value get(Node node, Key key) {
        if (node == null)
            return null;
        int cmp = node.key.compareTo(key);
        if (cmp < 0)
            return get(node.left, key);
        else if (cmp > 0)
            return get(node.right, key);
        else
            return node.value;
    }

    //向二叉树中叉入值
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
            return size(node.left);//size返回每个节点以下包含的节点总是
    }
}
