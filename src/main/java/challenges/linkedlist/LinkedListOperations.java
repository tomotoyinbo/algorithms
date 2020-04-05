package challenges.linkedlist;

import datastructures.Stack;

public class LinkedListOperations {

    // Challenge: You’re given the pointer to the head node of a linked list,
    // an integer to add to the list and the position at which the integer
    // must be inserted. Create a new node with the given integer, insert
    // this node at the desired position and return the head node.
    //
    // A position of 0 indicates head, a position of 1 indicates one node
    // away from the head and so on. The head pointer given may be null
    // meaning that the initial list is empty.

    // Example
    // Input:  Node = (1 -> 2 -> 3), Position = 2 and data = 4.
    // Output: (1 -> 2 -> 4 -> 3).
    public SinglyLinkedNode insertNodeAtPosition(SinglyLinkedNode head, int data, int position){

        if(head == null){
            return null;
        }

        SinglyLinkedNode currentNode = head;
        SinglyLinkedNode previousNode = head;

        int currentPosition = 0;

        while(currentNode != null){

            if(currentPosition == position){

                SinglyLinkedNode newNode = new SinglyLinkedNode(data);
                previousNode.next = newNode;
                newNode.next = currentNode;
            }

            previousNode = currentNode;
            currentNode = currentNode.next;
            currentPosition++;
        }

        return head;
    }

    // Challenge: You’re given the pointer to the head node of a linked list and the position of a node to delete.
    //            Delete the node at the given position and return the head node. A position of 0 indicates head,
    //            a position of 1 indicates one node away from the head and so on. The list may become empty after
    //            you delete the node.
    //
    // Example
    // Input:  Node = (20->6->2->19->7->4->15->9), Position = 3
    // Output: (20->6->2->7->4->15->9)
    public SinglyLinkedNode deleteNode(SinglyLinkedNode head, int position) {

        if(head == null){
            return null;
        } else {
            if(position == 0){
                head = head.next;
                return head;
            }
        }

        SinglyLinkedNode currentNode = head;

        while(position > 1 && currentNode.next != null){
            currentNode = currentNode.next;
            position--;
        }

        if(currentNode.next != null){
            currentNode.next = currentNode.next.next;
        }

        return head;
    }

    // Challenge: Given a reference to the head of a doubly-linked list and an integer, data,
    // create a new DoublyLinkedNode object having data value data and insert it into a sorted
    // linked list while maintaining the sort.
    //
    // Example
    // Input:  (1 <-> 3 <-> 4 <-> 10 -> null), data = 5.
    // Output: (1 <-> 3 <-> 4 <-> 5 <-> 10 -> null).
    public DoublyLinkedNode sortedInsert(DoublyLinkedNode head, int data) {

        if(head == null){

            head = new DoublyLinkedNode(data);

        } else if(head.getData() >= data){

            DoublyLinkedNode newNode = new DoublyLinkedNode(data);
            newNode.next = head;
            newNode.next.prev = newNode;
            head = newNode;

        } else {

            DoublyLinkedNode currentNode = head;

            while(currentNode.next != null && currentNode.next.getData() < data){
                currentNode = currentNode.next;
            }

            DoublyLinkedNode newNode = new DoublyLinkedNode(data);
            newNode.next = currentNode.next;

            // if the new node is not inserted
            // at the end of the list
            if(currentNode.next != null){
                newNode.next.prev = newNode;
            }

            currentNode.next = newNode;
            newNode.prev = currentNode;
        }

        return head;
    }

    // Challenge: You’re given the pointer to the head node of a doubly linked list.
    // Reverse the order of the nodes in the list. The head node might be NULL to
    // indicate that the list is empty. Change the next and prev pointers of all the
    // nodes so that the direction of the list is reversed. Return a reference to
    // the head node of the reversed list.
    //
    // Example
    // Input:  (head -> 1 <-> 2 <-> 3 <-> 4 -> null)
    // Output: (head -> 4 <-> 3 <-> 2 <-> 1 -> null).
    public DoublyLinkedNode reverse(DoublyLinkedNode head) {

        if(head == null){
            return null;
        }

        DoublyLinkedNode currentNode = head;

        while(currentNode.next != null){
            currentNode = currentNode.next;
        }

        head = currentNode;
        DoublyLinkedNode nextNode = currentNode.prev;
        DoublyLinkedNode prevNode = null;

        while(nextNode != null){
            currentNode.next = nextNode;
            currentNode.prev = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
            nextNode = nextNode.prev;
        }

        currentNode.next = null;
        currentNode.prev = prevNode;

        return head;
    }

    public Stack<Integer> sum(Stack<Integer> first, Stack<Integer> second) {

        int firstIntNumber = convertFromStackToInt(first);

        int secondIntNumber = convertFromStackToInt(second);

        int sumInt = firstIntNumber + secondIntNumber;

        return convertFromIntToStack(sumInt);
    }

    private int convertFromStackToInt(Stack<Integer> stack) {

        StringBuilder numberString = new StringBuilder();

        while (!stack.isEmpty()) {
            numberString.append(stack.pop().toString());
        }

        return Integer.parseInt(numberString.toString());
    }

    private Stack<Integer> convertFromIntToStack(int number){

        Stack<Integer>  forwardStack = new Stack<>();
        Stack<Integer>  backwardStack = new Stack<>();

        while(number > 0){

            int unit = number % 10;

            forwardStack.push(new Integer(String.valueOf(unit)));

            number = number / 10;
        }

        while (!forwardStack.isEmpty()){
            backwardStack.push(forwardStack.pop());
        }

        return backwardStack;
    }
}
