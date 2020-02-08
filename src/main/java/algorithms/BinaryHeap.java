package algorithms;

public class BinaryHeap {

    private int capacity = 10;
    private int size = 0;

    public int[] items = new int[capacity];

    public void insert(int item){

    }

    private int leftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int rightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int parentIndex(int childIndex ) {
        return (childIndex - 1) / 2;
    }
}
