package datastructures;

import java.util.EmptyStackException;

public class Queue<T> {

    private int size;

    private Node head;// remove things here

    private Node tail;// add things here

    public boolean isEmpty() {
        return head == null;
    }

    public int size(){
        return size;
    }

    public T peek() {

        if(isEmpty()){
            throw new EmptyStackException();
        }

        return (T) head.data;
    }

    public void add(T  data){
        //Create new node
        //Set current tail.next to new node
        //Set new node to tail
        Node<T> newNode = new Node<>(data);

        if(tail != null){
            tail.next = newNode;
        }

        tail = newNode;

        if(head == null){// handle case of first element where head is null
            head = tail;
        }

        size++;
    }

    public T remove(){
        //set head.data to value
        //set head to head.next
        //decrement size
        if(head == null){//degenerate case
            throw new EmptyStackException();
        }

        T data = (T) head.data;
        head = head.next;
        size--;

        return data;
    }

    private class Node<S>{

        private S data;
        private Node next;

        private Node(S data){
            this.data = data;
        }
    }
}
