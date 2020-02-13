package algorithms;

import org.junit.Assert;
import org.junit.Test;

public class BinaryHeapTest {

    private BinaryHeap binaryHeap;

    @Test
    public void extractMax(){

        binaryHeap = new BinaryHeap();
        binaryHeap.insert(42);
        binaryHeap.insert(29);
        binaryHeap.insert(18);

        // Insert(35)
        binaryHeap.insert(35);

        // Test insert
        Assert.assertEquals(42, binaryHeap.items[0]);
        Assert.assertEquals(35, binaryHeap.items[1]);
        Assert.assertEquals(18, binaryHeap.items[2]);
        Assert.assertEquals(29, binaryHeap.items[3]);

        // Text extract max
        Assert.assertEquals(42, binaryHeap.extractMax());
        Assert.assertEquals(35, binaryHeap.extractMax());
        Assert.assertEquals(29, binaryHeap.extractMax());
        Assert.assertEquals(18, binaryHeap.extractMax());

        binaryHeap.print();
    }
}
