package datastructures;

import java.util.EmptyStackException;

public class Stack<T> {

    private Node head;//add and remove things here
    private int size;

    public boolean isEmpty() {
        return head == null;
    }

    public T peek() {

        if(isEmpty()){
            throw new EmptyStackException();
        }

        return (T) head.data;
    }

    public void push(T data){

        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public T pop(){

        if(head == null){
            throw new EmptyStackException();
        }

        T data = (T) head.data;
        head = head.next;
        size--;

        return data;
    }

    public int size(){
        return size;
    }

    private class Node<S>{

        private S data;
        private Node next;

        private Node(S data){
            this.data = data;
        }
    }
}
