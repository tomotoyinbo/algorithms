package algorithms;

import java.util.Arrays;

public class MinIntHeap {

    private int capacity = 10;

    private int size = 0;

    public int[] items = new int[capacity];

    public void insert(int item) {

        ensureCapacity();

        items[size] = item;

        size++;

        heapifyUp();
    }

    public int extractMin() {

        if(size == 0){
            throw new IllegalStateException();
        }

        int min = items[0]; //extract from the top

        items[0] = items[size - 1]; // swap top and bottom
        size--;                     // effectively deletes last entry (min)

        heapifyDown();              // reorder

        return min;
    }

    public void print() {
        for(int i = 0; i < size; i++){
            System.out.println(i + "["+ items[i] + "]");
        }

    }

    private void heapifyDown() {

        int index = 0;//start at the top

        // as long as I have children
        // note: Only need to check left because if no left, there is no right
        while(hasLeftChild(index)){
            // take the smaller of the two indexes
            int smallerChildIndex = leftChildIndex(index);

            if(hasRightChild(index) && rightChild(index) < leftChild(index)){
                smallerChildIndex = rightChildIndex(index);
            }

            // now compare

            // if I am smaller than the items of my two children...
            // then everything is good. I am sorted.
            if(items[smallerChildIndex] > items[index]){
                break;
            } else {
                //  we are still not in order - swap
                swap(smallerChildIndex, index);
            }

            // then move down to larger child
            index = smallerChildIndex;
        }
    }

    private void heapifyUp() {

        int index = size - 1;

        while(hasParent(index) && parent(index) > items[index]){
            swap(parentIndex(index), index);
            index = parentIndex(index);
        }
    }

    private int leftChild(int parentIndex) {
        return items[leftChildIndex(parentIndex)];
    }

    private int rightChild(int parentIndex) {
        return items[rightChildIndex(parentIndex)];
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) < size;
    }

    private int rightChildIndex(int parentIndex) {
        return (2 * parentIndex) + 2;
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) < size;
    }

    private int leftChildIndex(int ParentIndex) {
        return (2 * ParentIndex) + 1;
    }

    private boolean hasParent(int childIndex) {
        return parent(childIndex) >= 0;
    }

    private int parent(int index) {
        return items[parentIndex(index)];
    }

    private int parentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private void swap(int indexOne, int indexTwo){
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    private void ensureCapacity() {

        if(size == capacity){
            items = Arrays.copyOf(items, capacity*2);
            capacity = capacity*2;
        }
    }
}
