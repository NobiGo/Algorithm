package dx.com.three;

/**
 * Created by dx on 2017/4/7.
 */
public class Exercise3214 {
}

class NoRecursionBST<Key extends Comparable<Key>, Value> {
    //定义节点的结构
    private class Node {
        Key key;
        Value value;
        Node left, right;
        int number;//以节点为根节点的结点个数

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.number = 1;
        }
    }

    //定义根节点
    private Node root;

    //向二叉树中插入结点
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null)
            return new Node(key, value);
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = put(node.left, key, value);
        else if (cmp > 0)
            node.right = put(node.right, key, value);
        else
            node.value = value;
        node.number = 1 + size(node.right) + size(node.left);
        return node;
    }

    private int size(Node node) {
        if (node != null)
            return node.number;
        return 0;
    }

    //非递归实现最小值
    public Key min() {
        Node node = root;
        if (node == null)
            return null;
        while (node.left != null) {
            node = node.left;
        }
        return node.key;
    }

    //非递归实现最大值
    public Key max() {
        Node node = root;
        if (node == null)
            return null;
        while (node.right != null) {
            node = node.right;
        }
        return node.key;
    }


    //非递归实现求小于等于key的最大值
    public Key floor(Key key) {
        Node node = root;
        if (node == null)
            return null;

        while(key.compareTo(node.key)<=0)
        {
            if(key.compareTo(node.key)==0)
                return key;
            node = node.left;
        }

        while(key.compareTo(node.key)>=0){
            if(key.compareTo(node.key)==0)
                return key;
            node = node.right;
        }
        return null;
    }
}