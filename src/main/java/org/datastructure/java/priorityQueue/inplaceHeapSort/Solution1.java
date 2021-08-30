package org.datastructure.java.priorityQueue.inplaceHeapSort;

public class Solution1 {


    public static void inplaceHeapSort(int arr[]) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Change in the given input itself.
         * Taking input and printing output is handled automatically.
         */
        if (arr.length == 0 || arr.length == 1) return;
        ////////at first run assume that 1st element that come is the first element of arr
        for (int i = arr.length - 1; i >= 0; i--) {
            /////get the child
            int element = arr[i];
            //////get the Parent of the CHild.
            int parentIndex = (i - 1) / 2;

            /////proceed with the re-alignment (i.e. upheapify operation) of the data as per MIN ORDER HEAP rule for this iteration index 'i'.
            upheapifyOperation(arr, parentIndex, i);
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

    private static void upheapifyOperation(int arr[], int parentIndex, int childIndex) {
        if (parentIndex < 0) return;

        if (arr[parentIndex] > arr[childIndex]) {
            int tmp = arr[parentIndex];
            arr[parentIndex] = arr[childIndex];
            arr[childIndex] = tmp;

            childIndex = parentIndex;
        } else return;

        if (childIndex == 0) return;
        /////////calculating newParentIndex and childIndex till this is MAXIMUM ORDER HEAP for the specified Iteration.
        parentIndex = (childIndex - 1) / 2;

        upheapifyOperation(arr, parentIndex, childIndex);
    }
}