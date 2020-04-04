package challenges.linkedlist;

public class SinglyLinkedNode {

    private int data;
    SinglyLinkedNode next;

    public SinglyLinkedNode(int data) {
        this.data = data;
    }

    public int getData() {

        return data;
    }

    public void setData(int data) {

        this.data = data;
    }

    public SinglyLinkedNode getNext() {

        return next;
    }

    public void setNext(SinglyLinkedNode next) {

        this.next = next;
    }
}
