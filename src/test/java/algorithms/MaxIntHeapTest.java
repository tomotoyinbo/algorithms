package algorithms;

import org.junit.Assert;
import org.junit.Test;

public class MaxIntHeapTest {

    private MaxIntHeap maxIntHeap;

    @Test
    public void extractMax(){

        maxIntHeap = new MaxIntHeap();
        maxIntHeap.insert(42);
        maxIntHeap.insert(29);
        maxIntHeap.insert(18);

        // Insert(35)
        maxIntHeap.insert(35);

        // Test insert
        Assert.assertEquals(42, maxIntHeap.items[0]);
        Assert.assertEquals(35, maxIntHeap.items[1]);
        Assert.assertEquals(18, maxIntHeap.items[2]);
        Assert.assertEquals(29, maxIntHeap.items[3]);

        // Text extract max
        Assert.assertEquals(42, maxIntHeap.extractMax());
        Assert.assertEquals(35, maxIntHeap.extractMax());
        Assert.assertEquals(29, maxIntHeap.extractMax());
        Assert.assertEquals(18, maxIntHeap.extractMax());

        maxIntHeap.print();
    }

    @Test
    public void ExtractMaxBigger() {
        maxIntHeap = new MaxIntHeap();
        maxIntHeap.insert(42);
        maxIntHeap.insert(29);
        maxIntHeap.insert(18);
        maxIntHeap.insert(14);
        maxIntHeap.insert(7);
        maxIntHeap.insert(18);
        maxIntHeap.insert(12);
        maxIntHeap.insert(11);
        maxIntHeap.insert(13);

        Assert.assertEquals(42, maxIntHeap.extractMax());
        Assert.assertEquals(29, maxIntHeap.extractMax());
        Assert.assertEquals(18, maxIntHeap.extractMax());
        Assert.assertEquals(18, maxIntHeap.extractMax());
        Assert.assertEquals(14, maxIntHeap.extractMax());
        Assert.assertEquals(13, maxIntHeap.extractMax());
        Assert.assertEquals(12, maxIntHeap.extractMax());
        Assert.assertEquals(11, maxIntHeap.extractMax());
        Assert.assertEquals(7, maxIntHeap.extractMax());
    }
}
