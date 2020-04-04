package challenges.linkedlist;

public class DoublyLinkedNode {

    private int data;
    DoublyLinkedNode prev;
    DoublyLinkedNode next;

    public DoublyLinkedNode(int data) {

        this.data = data;
    }

    public int getData() {

        return data;
    }

    public void setData(int data) {

        this.data = data;
    }

    public DoublyLinkedNode getPrev() {

        return prev;
    }

    public void setPrev(DoublyLinkedNode prev) {

        this.prev = prev;
    }

    public DoublyLinkedNode getNext() {

        return next;
    }

    public void setNext(DoublyLinkedNode next) {

        this.next = next;
    }
}
