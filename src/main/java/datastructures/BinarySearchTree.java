package datastructures;

public class BinarySearchTree<T> {

    private TreeNode<T> rootNode;

    BinarySearchTree() {
        this.rootNode = null;
    }

    public void insert(int key, T data) {
        this.rootNode = insertItem(this.rootNode, key, data);
    }

    public T findByKey(int key) {
        TreeNode<T> node = findNode(rootNode, key);
        return (node != null) ? node.getData() : null;
    }

    public void delete(int key){
        //TODO: under construction...
    }

    public int findMinKey() {
        //TODO: under construction...
        return 0;
    }

    private TreeNode<T> insertItem(TreeNode<T> node, int key, T data) {

        if (node == null) {
            return new TreeNode<>(key, data);
        } else {
            if (key < node.getKey()) {
                node.setLeft(insertItem(node.getLeft(), key, data));
            } else if (key > node.getKey()) {
                node.setRight(insertItem(node.getRight(), key, data));
            }
        }

        return node;
    }

    private TreeNode<T> findNode(TreeNode<T> node, int key) {

        if (node == null || key == node.getKey()) {
            return node;
        } else if (key < node.getKey()) {
            return findNode(node.getLeft(), key);
        } else {
            return findNode(node.getRight(), key);
        }
    }
}
