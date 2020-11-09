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

        Node<String> node1 = new Node<>("a");
        Node<String> node2 = new Node<>("b");
        Node<String> node3 = new Node<>("c");

        queue.enqueue(node1);
        queue.enqueue(node2);
        queue.enqueue(node3);

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

        Node<String> node1 = new Node<>("a");
        Node<String> node2 = new Node<>("b");
        Node<String> node3 = new Node<>("c");

        queue.enqueue(node1);
        queue.enqueue(node2);
        queue.enqueue(node3);

        Assert.assertEquals(3, queue.size());

        queue.dequeue();
    }
}
