package datastructures;

import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;

public class CircularNodeQueueTest {

    private CircularNodeQueue<String> queue;

    @Test
    public void testEmpty() {

        queue = new CircularNodeQueue<>(null);

        queue.isEmpty();
    }

    @Test(expected = NoSuchElementException.class)
    public void testEmptyPeek() {
        queue = new CircularNodeQueue<>(null);
        queue.peek();
    }

    @Test
    public void testEnqueue(){

        queue = new CircularNodeQueue<>(null);

        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");

        Assert.assertEquals(3, queue.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void testEmptyDequeue(){

        queue = new CircularNodeQueue<>(null);

        queue.dequeue();
    }

    @Test
    public void testDequeue(){

        queue = new CircularNodeQueue<>(null);

        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");

        Assert.assertEquals(3, queue.size());

        queue.dequeue();

        Assert.assertEquals(2, queue.size());
        Assert.assertEquals("b", queue.peek());
    }
}
