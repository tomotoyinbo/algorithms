package datastructures;

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
    public void testInsert() {
        binarySearchTree.insert(80, "a");
        binarySearchTree.insert(40, "b");
        binarySearchTree.insert(20, "c");
        binarySearchTree.insert(60, "d");
        binarySearchTree.insert(10, "e");
        binarySearchTree.insert(30, "f");
        binarySearchTree.insert(60, "g");
        binarySearchTree.insert(50, "h");
        binarySearchTree.insert(70, "i");
        binarySearchTree.insert(120, "j");
        binarySearchTree.insert(100, "k");
        binarySearchTree.insert(140, "l");
        binarySearchTree.insert(90, "m");
        binarySearchTree.insert(110, "n");
        binarySearchTree.insert(130, "o");
        binarySearchTree.insert(150, "p");

        Assert.assertEquals("i", binarySearchTree.findByKey(70));
        Assert.assertNull(binarySearchTree.findByKey(99));
    }
}
