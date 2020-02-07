package algorithms;

public class BinarySearchTree<T> {

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    @SuppressWarnings("unchecked")
    public T find(int key) {
        Node node = findNode(key);
        return (node == null) ? null : (T) node.value;
    }

    public Node findNode(int key){
        return findNode(root, key);
    }

    @SuppressWarnings("unchecked")
    private Node findNode(Node node, int key){

        if(node == null || node.key == key){
            return node;
        } else if(key < node.key){
            return findNode(node.left, key);
        } else {
            return findNode(node.right, key);
        }
    }

    public void insert(int key, T value) {
        root = insertItem(root, key, value);
    }

    @SuppressWarnings("unchecked")
    public Node insertItem(Node node, int key, T value){
        // If null - set it here. We are done.
        if(node == null){
            node = new Node(key, value);
            return node;
        }

        // Else
        // Walk until you find a node
        // that is null and set it there
        if (key < node.key) {
            node.left = insertItem(node.left, key, value);
        } else if (key > node.key) {
            node.right = insertItem(node.right, key, value);
        }

        // If we get here we have hit the bottom or tree with a duplicate.
        // Since duplicates are not allowed in BSTs, simply ignore the duplicate,
        // and return our fully constructed tree. We are done!
        return node;
    }

    // Delete: Three cases
    // 1. No child
    // 2. One child
    // 3. Two children

    // First two are simple. Third is more complex.

    // Case 1: No child - simply remove from tree by nulling it.
    //
    // Case 2: One child - copy the child to the node to be deleted and delete the child

    // Case 3: Two children - re-gig the tree to turn into a Case 1 or a Case 2

    // For third case we first need to
    // 1. Find the right side min
    // 2. Copy it to the node we want to delete (creating a duplicate)
    // 3. Then delete the min value way down on the branch we just copied
    //
    // This works because you can represent a binary tree in more than one way.
    // Here we are taking advantage of that fact to make our more complicated
    // 3rd case delete more simple by transforming it into case 1.

    // Step 1: Create a minvalue function
    public int findMinKey() {
        return findMin(root).key;
    }

    public Node findMin(Node node) {
        return node.min();
    }

    public void delete(int key) {
        root = delete(root, key);
    }

    public Node delete(Node node, int key){

        if (node == null) {
            return null;
        } else if (key < node.key) {
            node.left = delete(node.left, key);
        } else if (key > node.key) {
            node.right = delete(node.right, key);
        } else { // This is the node we want to delete.

            // Case 1: No child
            if (node.left == null && node.right == null) {
                node = null;
            }

            // Case 2: One child
            else if (node.left == null) {
                node = node.right;
            } else if (node.right == null) {
                node = node.left;
            }

            // Case 3: Two children
            else {
                // Find the minimum node on the right (could also max the left...)
                Node minRight = findMin(node.right);

                // Duplicate it by copying its values here
                node.key = minRight.key;
                node.value = minRight.value;

                // Now go ahead and delete the node we just duplicated (same key)
                node.right = delete(node.right, node.key);
            }
        }

        return node;
    }

    // Print
    public void printInOrderTraversal(){
        inOrderTraversal(root);
    }

    public Node getRoot() {
        return root;
    }

    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println(node.key);
            inOrderTraversal(node.right);
        }
    }

    public void printPreOrderTraversal() {
        preOrderTraversal(root);
    }

    private void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.println(node.key); // root
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public void printPostOrderTraversal() {
        postOrderTraversal(root);
    }

    private void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.println(node.key);
        }
    }

    class Node<S> {

        int key;
        S value;
        Node left;
        Node right;

        public Node(int key, S value) {
            this.key = key;
            this.value = value;
        }

        public Node min(){
            if(left == null){
                return this;
            }else {
                return left.min();
            }
        }
    }
}
