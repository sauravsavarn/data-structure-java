package org.datastructure.java.priorityQueue.checkMaxHeap;

public class Solution {

    public static boolean checkMaxHeap(int arr[]) {
        /*
         * Your class should be named Solution Don't write main(). Don't read input, it
         * is passed as function argument. Return output and don't print it. Taking
         * input and printing output is handled automatically.
         */
        if (arr.length == 0 || arr.length == 1) return true;

        int numOfLeafNodes = arr.length / 2;
        for (int i = numOfLeafNodes - 1; i > 0; i--) {
            /////now perform downHeapify and check at Every STEP(s) if it is a MAX HEAP.
            int parentIndex = i;
            int childIndex = -1;
            if (!downHeapifyOperation(arr, parentIndex, childIndex))
                return false;
        }

        return true;
    }

    private static boolean downHeapifyOperation(int arr[], int parentIndex, int childIndex) {
        if (childIndex != -1 && parentIndex >= childIndex) return true;

        ////////get Index of Left & Right child
        int indexLeftChild = -1;
        int indexRightChild = -1;

        if (childIndex != -1) {
            if (arr[parentIndex] < arr[childIndex])
                return false;
            else {
                parentIndex = childIndex;
            }
        }

        /////////first check whether to proceed with the LEFT or the RIGHT Child.
        indexLeftChild = (2 * parentIndex + 1);
        indexRightChild = (2 * parentIndex + 2);

        if (indexRightChild >= arr.length)
            childIndex = indexLeftChild;
        else if (arr[indexLeftChild] < arr[indexRightChild])
            childIndex = indexLeftChild;
        else
            childIndex = indexRightChild;

        if (arr.length - 1 >= childIndex) {
            return downHeapifyOperation(arr, parentIndex, childIndex);
        } else return true;
    }
}