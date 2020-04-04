package algorithms;

public class MergeSort {

    public void sort(int[] arr, int l, int r) {

        System.out.println("splitting l r: " + l + " " + r);

        if(l < r){

            //find mid point
            int m = (l+r)/2;

            //sort first and second halves
            sort(arr, l, m);

            sort(arr, m+1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    // Merges two sub-arrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    public void merge(int [] arr, int l, int m, int r){

        System.out.println("merge l m r: " + l + " " + m + " " + r);

        // Find sizes of two sub-arrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int [] leftArray = new int[n1];
        int [] rightArray = new int[n2];

        /* Copy data to temp arrays */
        for (int i = 0; i < n1; ++i) {
            leftArray[i] = arr[l + i];
        }

        for (int j = 0; j < n2; ++j) {
            rightArray[j] = arr[m + 1 + j];
        }

        /* Merge the temp arrays */

        // Initial indexes of first and second sub-arrays
        int i = 0;
        int j = 0;

        // Initial index of merged sub-array array
        int k = l;

        while (i < n1 && j < n2) {

            if (leftArray[i] <= rightArray[j]) {

                arr[k] = leftArray[i];

                i++;

            } else {

                arr[k] = rightArray[j];

                j++;
            }

            k++;
        }

        /* Copy remaining elements of leftArray[] if any */
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        /* Copy remaining elements of rightArray[] if any */
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }

        System.out.println("After merge");
        printArray(arr);
    }

    public void printArray(int[] arr) {

        for (int value : arr) {
            System.out.print(value + " ");
        }

        System.out.println();
    }
}
