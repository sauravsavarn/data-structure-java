package org.datastructure.java.recurrsion.quicksort;

public class QuickSort {

    public static void quickSort(int[] input) {

        int[] sortedOutput = quickSortt(input, 0, input.length-1);
        int k = 0;
        for (int p : sortedOutput) {
            input[k++] = p;
        }
        System.out.println("testing is done");
    }

    public static int[] quickSortt(int[] input, int startIndex, int endIndex) {

        /////taking the base-case if startIndex < endIndex otherwise return, as if startIndex = endIndex signifies that there are only 1 element to be sorted which automatically is a sorted.
        if (startIndex < endIndex) {

            ///////// choosing the partition-key - by iterating to the array and check if any element is lower in value from the chosen random
            // pi is partitioning index, arr[p] is now at right place
            int pi = partition(input, startIndex, endIndex);

            // Separately sort elements before partition and after partition
            quickSortt(input, startIndex, pi - 1);
            quickSortt(input, pi + 1, endIndex);
        }

        return input;
    }

    // A utility function to swap two elements
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /* This function takes last element as pivot, places
   the pivot element at its correct position in sorted
   array, and places all smaller (smaller than pivot)
   to left of pivot and all greater elements to right
   of pivot */
    static int partition(int[] arr, int low, int high) {

        // pivot
        int pivot = arr[high];

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot) {

                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
}
