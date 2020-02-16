package algorithms;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MinIntHeapTest {

    private MinIntHeap minIntHeap;

    @Before
    public void before(){
        minIntHeap = new MinIntHeap();
    }

    @Test
    public void extractMin(){

        minIntHeap.insert(42);
        minIntHeap.insert(32);
        minIntHeap.insert(12);

        minIntHeap.insert(35);

        // Test insert
        Assert.assertEquals(12, minIntHeap.items[0]);
        Assert.assertEquals(35, minIntHeap.items[1]);
        Assert.assertEquals(32, minIntHeap.items[2]);
        Assert.assertEquals(42, minIntHeap.items[3]);

        // Text extract min
        Assert.assertEquals(12, minIntHeap.extractMin());
        Assert.assertEquals(32, minIntHeap.extractMin());
        Assert.assertEquals(35, minIntHeap.extractMin());
        Assert.assertEquals(42, minIntHeap.extractMin());

        minIntHeap.print();
    }

}
