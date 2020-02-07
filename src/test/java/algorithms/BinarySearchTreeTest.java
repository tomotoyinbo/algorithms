package algorithms;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {

    private BinarySearchTree<String> binarySearchTree;

    @Before
    public void before(){
        binarySearchTree = new BinarySearchTree<>();
    }

    @Test
    public void Insert() {
        binarySearchTree.insert(5, "e");
        binarySearchTree.insert(3, "c");
        binarySearchTree.insert(2, "b");
        binarySearchTree.insert(4, "d");
        binarySearchTree.insert(7, "g");
        binarySearchTree.insert(6, "f");
        binarySearchTree.insert(8, "h");

        Assert.assertEquals("e", binarySearchTree.find(5));
        Assert.assertEquals("c", binarySearchTree.find(3));
        Assert.assertEquals("b", binarySearchTree.find(2));
        Assert.assertEquals("d", binarySearchTree.find(4));
        Assert.assertEquals("g", binarySearchTree.find(7));
        Assert.assertEquals("f", binarySearchTree.find(6));
        Assert.assertEquals("h", binarySearchTree.find(8));
        Assert.assertNull(binarySearchTree.find(99));

        prettyPrint(binarySearchTree.getRoot());

        binarySearchTree.printInOrderTraversal();
//        binarySearchTree.printPreOrderTraversal();
//        binarySearchTree.printPostOrderTraversal();
    }

    @Test
    public void MinKey() {
        binarySearchTree.insert(5, "e");
        binarySearchTree.insert(3, "c");
        binarySearchTree.insert(2, "b");

        Assert.assertEquals(2, binarySearchTree.findMinKey());
    }

    @Test
    public void DeleteNoChild() {
        binarySearchTree.insert(5, "e");
        binarySearchTree.insert(3, "c");
        binarySearchTree.insert(2, "b");
        binarySearchTree.insert(4, "d");
        binarySearchTree.insert(7, "g");
        binarySearchTree.insert(6, "f");
        binarySearchTree.insert(8, "h");

        prettyPrint(binarySearchTree.getRoot());

        binarySearchTree.delete(2);

        Assert.assertNull(binarySearchTree.find(2));

        prettyPrint(binarySearchTree.getRoot());
    }

    @Test
    public void DeleteOneChild() {
        binarySearchTree.insert(5, "e");
        binarySearchTree.insert(3, "c");
        binarySearchTree.insert(2, "b");
        binarySearchTree.insert(4, "d");
        binarySearchTree.insert(7, "g");
        binarySearchTree.insert(6, "f");

        prettyPrint(binarySearchTree.getRoot());

        binarySearchTree.delete(7);

        Assert.assertNull(binarySearchTree.find(7));
        Assert.assertNull(binarySearchTree.findNode(6).right);
        Assert.assertNull(binarySearchTree.findNode(6).left);

        prettyPrint(binarySearchTree.getRoot());
    }

    @Test
    public void DeleteTwoChildren() {
        binarySearchTree.insert(5, "e");
        binarySearchTree.insert(3, "c");
        binarySearchTree.insert(2, "b");
        binarySearchTree.insert(4, "d");
        binarySearchTree.insert(7, "g");
        binarySearchTree.insert(6, "f");
        binarySearchTree.insert(8, "h");

        prettyPrint(binarySearchTree.getRoot());

        binarySearchTree.delete(7);

        Assert.assertNull(binarySearchTree.find(7));
        Assert.assertNull(binarySearchTree.findNode(8).right);
        Assert.assertEquals(binarySearchTree.find(6), binarySearchTree.findNode(8).left.value);

        prettyPrint(binarySearchTree.getRoot());
    }

    private void prettyPrint(BinarySearchTree.Node root) {
        // Hard coded print out of binary tree depth = 3

        int rootLeftKey = root.left == null ? 0 : root.left.key;
        int rootRightKey = root.right == null ? 0 : root.right.key;

        int rootLeftLeftKey = 0;
        int rootLeftRightKey = 0;

        if (root.left != null) {
            rootLeftLeftKey = root.left.left == null ? 0 : root.left.left.key;
            rootLeftRightKey = root.left.right == null ? 0 : root.left.right.key;
        }

        int rootRightLeftKey = 0;
        int rootRightRightKey = 0;

        if (root.right != null) {
            rootRightLeftKey = root.right.left == null ? 0 : root.right.left.key;
            rootRightRightKey = root.right.right == null ? 0 : root.right.right.key;
        }

        System.out.println("     " + root.key);
        System.out.println("   /  \\");
        System.out.println("  " + rootLeftKey + "    " + rootRightKey);
        System.out.println(" / \\  / \\");
        System.out.println(rootLeftLeftKey + "  " + rootLeftRightKey + " " + rootRightLeftKey + "   " + rootRightRightKey);
    }
}
