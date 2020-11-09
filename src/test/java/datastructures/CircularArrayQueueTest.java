package datastructures;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

public class CircularArrayQueueTest {

    private CircularArrayQueue<String> circularArrayQueue;

    @Before
    public void before(){
        circularArrayQueue = new CircularArrayQueue<>(5);
    }

    @Test
    public void testEmptyQueue(){
        Assert.assertTrue(circularArrayQueue.isEmpty());
    }

    @Test(expected = NoSuchElementException.class)
    public void testEmptyPeek() {
        circularArrayQueue.peek();
    }

    @Test
    public void testEnqueue(){

        circularArrayQueue.enqueue("a");
        circularArrayQueue.enqueue("b");
        circularArrayQueue.enqueue("c");

        Assert.assertFalse(circularArrayQueue.isEmpty());
        Assert.assertEquals(3, circularArrayQueue.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void testEmptyDequeue(){
        circularArrayQueue.dequeue();
    }

    @Test
    public void testDequeue() {
        circularArrayQueue.enqueue("a");
        circularArrayQueue.enqueue("b");
        circularArrayQueue.enqueue("c");

        circularArrayQueue.dequeue();

        Assert.assertFalse(circularArrayQueue.isEmpty());
        Assert.assertEquals(2, circularArrayQueue.size());
    }

    @Test
    public void testResize() {
        circularArrayQueue.enqueue("a");
        circularArrayQueue.enqueue("b");
        circularArrayQueue.enqueue("c");
        circularArrayQueue.enqueue("d");
        circularArrayQueue.enqueue("e");
        circularArrayQueue.enqueue("f");

        Assert.assertEquals(6, circularArrayQueue.size());
    }
}
