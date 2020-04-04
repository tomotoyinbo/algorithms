package algorithms;

public class QuickSort {

    public int[] sort(int[] array) {

        quickSort(array, 0, array.length - 1);

        return array;
    }

    private void quickSort(int[] array, int left, int right) {

        if (right > left) {
            // Step 1: Pick a pivot element - we will choose the center
            // Better would be to choose left + (right-left)/2
            // (as this would avoid overflow error for large arrays i.e. 2GB))
            int pivot = array[(left + right)/2];

            // Step 2: Partition the array around this pivot - return the index of the partition
            int index = partition(array, left, right, pivot);

            // Step 3: Sort on the left and the right side
            quickSort(array, left, index - 1);
            quickSort(array, index, right);
        }
    }

    private int partition(int[] array, int left, int right, int pivot) {

        // Move the left and right pointers in towards each other
        while (left <= right) {

            // Move left until you find an element bigger than the pivot
            while(array[left] < pivot) {
                left++;
            }

            // Move right until you find an element smaller than the pivot
            while (array[right] > pivot) {
                right--;
            }

            // Then swap
            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }

        return left;
    }

    private void swap(int[] array, int left, int right) {

        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public void prettyPrint(int[] sorted) {

        for (int value : sorted) {
            System.out.println(value);
        }
    }
}
