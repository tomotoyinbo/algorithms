package challenges;

import challenges.linkedlist.DoublyLinkedNode;
import challenges.linkedlist.LinkedListOperations;
import challenges.linkedlist.LinkedListLoopDetector;
import challenges.linkedlist.SinglyLinkedNode;
import datastructures.Stack;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedListsTest {

    private LinkedListOperations adder;

    @Before
    public void before(){
        adder = new LinkedListOperations();
    }

    @Test
    public void SumLists() {
        // Challenge: You have two numbers represented by a linked list.
        // Each node represents a single digit, in reverse order, such that the
        // 1's digit is at the head. Write a function that adds the two numbers
        // and returns the sum as a linked list.

        // Example
        // Input:  (8 -> 2 -> 5) + (4 -> 9 -> 2). That is 528 + 294.
        // Output: (2 -> 2 -> 8). That is 822.

        // Create our two numbers
        Stack<Integer> first = new Stack<>();
        first.push(new Integer("8"));
        first.push(new Integer("2"));
        first.push(new Integer("5"));

        Stack<Integer> second = new Stack<>();
        second.push(new Integer("4"));
        second.push(new Integer("9"));
        second.push(new Integer("2"));

        // Add them together
        Stack<Integer> sum = adder.sum(first, second);

        // Check the result
        Assert.assertEquals(3, sum.size());

        while(!sum.isEmpty()) {
            System.out.println(sum.pop());
        }
    }


    @Test
    public void LoopDetection() {
        // Challenge: Given a circular linked list, implement an algorithm determines
        // whether the linked list has a circular loop
        //
        // Definition: A circular linked list (corrupt) is one where a node's next pointer
        // points to an earlier node.

        // Example
        // Input: 1 -> 2 -> 3 -> 4 -> 5 -> 3 (same as earlier)

        SinglyLinkedNode node1 = new SinglyLinkedNode(1);
        SinglyLinkedNode node2 = new SinglyLinkedNode(2);
        SinglyLinkedNode node3 = new SinglyLinkedNode(3);
        SinglyLinkedNode node4 = new SinglyLinkedNode(4);
        SinglyLinkedNode node5 = new SinglyLinkedNode(5);
        SinglyLinkedNode node6 = new SinglyLinkedNode(6);
        SinglyLinkedNode node7 = new SinglyLinkedNode(7);

        LinkedListLoopDetector loopDetector = new LinkedListLoopDetector();

        loopDetector.addBack(node1);
        loopDetector.addBack(node2);
        loopDetector.addBack(node3);
        loopDetector.addBack(node4);
        loopDetector.addBack(node5);
        loopDetector.addBack(node6);
        loopDetector.addBack(node7);
        loopDetector.addBack(node3); // loop!


        Assert.assertTrue(loopDetector.hasLoop());
    }

    @Test
    public void testAddNodeAtPosition(){

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

        SinglyLinkedNode node1 = new SinglyLinkedNode(1); //Head
        SinglyLinkedNode node2 = new SinglyLinkedNode(2);
        SinglyLinkedNode node3 = new SinglyLinkedNode(3);

        node1.setNext(node2);
        node2.setNext(node3);

        SinglyLinkedNode newHeadNode = adder.insertNodeAtPosition(node1, 4, 2);
        //TODO: under construction...
    }

    @Test
    public void testAddNodeToSortedDoublyLinkedList(){
        // Challenge: Given a reference to the head of a doubly-linked list and an integer, data,
        // create a new DoublyLinkedNode object having data value data and insert it into a sorted
        // linked list while maintaining the sort.
        //
        // Example
        // Input:  (1 <-> 3 <-> 4 <-> 10 -> null), data = 5.
        // Output: (1 <-> 3 <-> 4 <-> 5 <-> 10 -> null).

        DoublyLinkedNode node1 = new DoublyLinkedNode(1);
        DoublyLinkedNode node2 = new DoublyLinkedNode(3);
        DoublyLinkedNode node3 = new DoublyLinkedNode(4);
        DoublyLinkedNode node4 = new DoublyLinkedNode(10);

        node1.setNext(node2);

        node2.setNext(node3);
        node2.setPrev(node1);

        node3.setNext(node4);
        node3.setPrev(node3);

        node4.setPrev(node3);

        DoublyLinkedNode newHeadNode = adder.sortedInsert(node1, 5);
        //TODO: under construction...
    }

    @Test
    public void testReverseDoublyLinkedList(){
        // Challenge: You’re given the pointer to the head node of a doubly linked list.
        // Reverse the order of the nodes in the list. The head node might be NULL to
        // indicate that the list is empty. Change the next and prev pointers of all the
        // nodes so that the direction of the list is reversed. Return a reference to
        // the head node of the reversed list.
        //
        // Example
        // Input:  (head -> 1 <-> 2 <-> 3 <-> 4 -> null)
        // Output: (head -> 4 <-> 3 <-> 2 <-> 1 -> null).
        DoublyLinkedNode node1 = new DoublyLinkedNode(1);
        DoublyLinkedNode node2 = new DoublyLinkedNode(2);
        DoublyLinkedNode node3 = new DoublyLinkedNode(3);
        DoublyLinkedNode node4 = new DoublyLinkedNode(4);

        node1.setNext(node2);

        node2.setNext(node3);
        node2.setPrev(node1);

        node3.setNext(node4);
        node3.setPrev(node3);

        node4.setPrev(node3);

        DoublyLinkedNode reverseLinkedHeadNode = adder.reverse(node1);
        //TODO: under construction...
    }
}
