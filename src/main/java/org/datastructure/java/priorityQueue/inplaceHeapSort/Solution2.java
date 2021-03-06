package org.datastructure.java.priorityQueue.inplaceHeapSort;

public class Solution2 {


    public static void inplaceHeapSort(int arr[]) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Change in the given input itself.
         * Taking input and printing output is handled automatically.
         */
        if (arr.length == 0 || arr.length == 1) return;
        ////////find the total number of non-leaf nodes
        int numNonLeafNodes = arr.length/2;

        ////////now for this number of Nodes perform downHeapifyOperation
        for (int i = numNonLeafNodes-1; i >=0 ; i--) {
            ////now proceed with the downHeapifyOperation
            int parentIndex = i;
            int childIndex = -1;
            downheapifyOperation(arr, parentIndex, childIndex);
        }

        ////////now working on element by element iff any root-node value is less than the (k+i)th element then replace with the value from (k+i)th place
        for (int k = 0, i = arr.length-1-k ; i >= 0; i--, k++) {
            ////SWAP the top-element
            int element = arr[0];
            arr[0] = arr[i];
            arr[i] = element;

            ////now proceed with the downHeapifyOperation
            int parentIndex = 0;
            int childIndex = -1;
            downheapifyOperation(arr, parentIndex, childIndex, i - 1);
        }

    }

    private static void downheapifyOperation(int arr[], int parentIndex, int childIndex) {
        if (childIndex != -1 && parentIndex >= childIndex) return;

        ////////get Index of Left & Right child
        int indexLeftChild = -1;
        int indexRightChild = -1;

        if (childIndex != -1) {
            if (arr[parentIndex] > arr[childIndex]) {
                int element = arr[parentIndex];
                arr[parentIndex] = arr[childIndex];
                arr[childIndex] = element;

                ///////also swapping index of both new-Child & new-Parent.
                parentIndex = childIndex;
            } else {
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
            downheapifyOperation(arr, parentIndex, childIndex);
        }

    }

    private static void downheapifyOperation(int arr[], int parentIndex, int childIndex, int maxIndexToCare) {
        //////base case
        if(maxIndexToCare<=0)return;
        if (childIndex != -1 && parentIndex >= childIndex) return;
        if (childIndex > maxIndexToCare || parentIndex > maxIndexToCare) return;

        ////////get Index of Left & Right child
        int indexLeftChild = -1;
        int indexRightChild = -1;

        if (childIndex != -1) {
            if (arr[parentIndex] > arr[childIndex]) {
                int element = arr[parentIndex];
                arr[parentIndex] = arr[childIndex];
                arr[childIndex] = element;

                ///////also swapping index of both new-Child & new-Parent.
                parentIndex = childIndex;
            }else return;
        }

        /////////first check whether to proceed with the LEFT or the RIGHT Child.
        indexLeftChild = (2 * parentIndex + 1);
        indexRightChild = (2 * parentIndex + 2);

        if (indexRightChild >= arr.length)
            childIndex = indexLeftChild;
        else if(indexRightChild > maxIndexToCare)
            childIndex = indexLeftChild;
        else if (arr[indexLeftChild] < arr[indexRightChild])
            childIndex = indexLeftChild;
        else
            childIndex = indexRightChild;

        if (arr.length - 1 >= childIndex) {
            downheapifyOperation(arr, parentIndex, childIndex, maxIndexToCare);
        }
    }
}