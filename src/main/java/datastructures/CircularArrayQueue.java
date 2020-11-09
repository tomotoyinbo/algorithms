package datastructures;

import java.util.NoSuchElementException;

public class CircularArrayQueue<T> {

    private int front;

    private int rear;

    private T[] data;

    public CircularArrayQueue(int initialSize) {
        this.front = this.rear = -1;
        this.data = (T[]) new Object[initialSize];
    }

    public T peek() {

        if(isEmpty()){
            throw new NoSuchElementException();
        }

        return data[front];
    }

    public void enqueue(T newData) {

        if(isFull()) {
            resize();
        } else if(isEmpty()) {
            front++;
        }

        rear = (rear + 1) % this.data.length;
        data[rear] = newData;
    }

    public T dequeue() {

        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        T tempData = data[front];

        if(front == rear){
            front = rear = -1;
        }

        front = (front + 1) % data.length;

        return tempData;
    }

    public int size() {
        return Math.max(0,(rear - front) + 1);
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return ((rear + 1) % data.length) == front;
    }

    public void resize() {

        T[] newArr = (T[]) new Object[2 * data.length];
        int i = 0;
        int j = front;

        do {
            newArr[i++] = data[j];
            j = (j + 1) % data.length;
        } while (j != front);

        front = 0;
        rear = data.length - 1;
        data = newArr;
    }
}
