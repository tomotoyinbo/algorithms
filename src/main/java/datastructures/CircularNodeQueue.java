package datastructures;

import java.util.NoSuchElementException;

public class CircularNodeQueue <T> {

    private int size;

    private Node<T> rear;

    CircularNodeQueue(Node<T> node){
        this.rear = node;
        if(this.rear != null){
            this.rear.next = this.rear;
        }
    }

    public void enqueue(Node<T> node) {

    }

    public boolean isEmpty() {
        return rear == null;
    }

    public T peek() {

        if(isEmpty()){
            throw new NoSuchElementException();
        }

        return rear.next.data;
    }

    public int size(){
        return size;
    }

    public void dequeue() {

        if(rear == null){
            throw new NoSuchElementException();
        }

    }
}
