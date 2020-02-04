package datastructures;

public class LinkedList {

    private Node head;

    private int size;

    public int getFirst(){
        return head.data;
    }

    public int getLast(){

        if(head == null){
            throw new IllegalStateException("List is empty");
        }

        Node currentNode = head;

        while(currentNode.next != null){
            currentNode = currentNode.next;
        }

        return currentNode.data;
    }

    public void addFront(int data){

        Node newNode = new Node(data);
        //check if empty.ie., head is null
        if(head == null){
            head = newNode;
            size++;
            return;
        }

        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addBack(int data){

        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            size++;
            return;
        }

        Node currentNode = head;

        while (currentNode.next != null){
            currentNode = currentNode.next;
        }

        currentNode.next = newNode;
        size++;
    }

    public int size(){
        return size;
    }

    public void clear(){
        head = null;
        size = 0;
    }

    public void deleteValue(int data) {

        if(head == null){
            return;
        }

        if(head.data == data){
            head = head.next;
            size--;
            return;
        }

        Node previousNode = head;
        Node currentNode = head.next;

        while (currentNode != null){
            if(currentNode.data == data){
                previousNode.next = currentNode.next;
                size--;
                return;
            }

            previousNode = currentNode;
            currentNode = currentNode.next;
        }
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println("");
    }

    public class Node{

        int data;

        Node next;

        Node(int data) {

            this.data = data;
        }
    }
}
