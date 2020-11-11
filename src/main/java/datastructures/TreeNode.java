package datastructures;

public class TreeNode<T> {

    private final T data;

    private final int key;

    private TreeNode<T> left;

    private TreeNode<T> right;

    public TreeNode(int key, T data) {
        this.key = key;
        this.data = data;
    }

    public TreeNode<T> findMin() {
        if (left == null) {
            return this;
        } else {
            return left.findMin();
        }
    }

    public TreeNode<T> findMax() {
        if (right == null) {
            return this;
        } else {
            return right.findMax();
        }
    }

    public T getData() {
        return data;
    }

    public int getKey() {
        return key;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }
}
