package datastructures;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

public class QueueTest {

    private Queue<String> queue;

    @Before
    public void before(){
        queue = new Queue<>();
    }

    @Test
    public void testEmptyQueue(){
        Assert.assertTrue(queue.isEmpty());
    }

    @Test(expected = EmptyStackException.class)
    public void testEmptyPeek(){
        queue.peek();
    }

    @Test
    public void testAdd(){
        Assert.assertTrue(queue.isEmpty());

        queue.add("a");
        queue.add("b");
        queue.add("c");

        Assert.assertFalse(queue.isEmpty());
        Assert.assertEquals(3, queue.size());
    }

    @Test
    public void testRemove(){
        queue.add("a");
        queue.add("b");
        queue.add("c");

        Assert.assertFalse(queue.isEmpty());
        Assert.assertEquals(3, queue.size());

        queue.remove();
        Assert.assertEquals(2,queue.size());
    }
}
