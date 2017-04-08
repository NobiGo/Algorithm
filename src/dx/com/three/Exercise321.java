package dx.com.three;

/**
 * Created by dx on 2017/4/7.
 */
public class Exercise321 {
    public static void main(String[] args) {
        MyBST<String, Integer> bst = new MyBST<String, Integer>();
        bst.put("E", 0);
        bst.put("A", 1);
        bst.put("S", 2);
        bst.put("Y", 3);
        bst.put("Q", 4);
        bst.put("U", 5);
        bst.put("E", 6);
        bst.put("S", 7);
        bst.put("T", 8);
        bst.put("I", 9);
        bst.put("O", 10);
        bst.put("N", 11);

        bst.print();
        System.out.println(bst.height());

    }
}

class MyBST<Key extends Comparable<Key>, Value> {
    //定义结点的结构
    private class Node {
        Key key;
        Value value;
        Node left, right;
        int number;//以这个节点为根节点的子树中结点的总数

        //节点的构造方法
        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.number = 1;
        }
    }

    //定义节点的根节点
    private Node root;
    //定义树的高度
    private int height;


    public void put(Key key, Value value) {
        root = put(root, key, value);
    }


    //向二叉树中插入节点
    private Node put(Node node, Key key, Value value) {
        if (node == null)
            return new Node(key, value);
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = put(node.left, key, value);
        else if (cmp > 0)
            node.right = put(node.right, key, value);
        else node.value = value;
        node.number = 1 + size(node.left) + size(node.right);
        return node;
    }


    public int height() {
        return height(root);
    }

    private int height(Node node) {
        int h1, h2;
        if (node == null)
            return 0;
        else {
            h1 = height(node.left);
            h2 = height(node.right);
            return (h1 < h2) ? h2 + 1 : h1 + 1;
        }
    }

    private int size(Node node) {
        if (node == null)
            return 0;
        else
            return node.number;
    }

    public void print() {
        print(root);
    }

    //打印查找二叉树中的结构
    private void print(Node node) {
        if (node == null)
            return;
        print(node.left);
        System.out.println(node.key);
        print(node.right);
    }
}