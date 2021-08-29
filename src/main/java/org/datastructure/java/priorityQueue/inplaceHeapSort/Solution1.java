package org.datastructure.java.priorityQueue.inplaceHeapSort;

public class Solution1 {

    public static void inplaceHeapSort(int arr[]) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Change in the given input itself.
         * Taking input and printing output is handled automatically.
         */
        if(arr.length==0 || arr.length==1)return;
        ////////at first run assume that 1st element that come is the first element of arr
        for (int i = 1; i < arr.length; i++) {
            /////get the child
            int element = arr[i];
            //////get the Parent of the CHild.
            int parentIndex = (i-1)/2;

            /////proceed with the re-alignment (i.e. upheapify operation) of the data as per MIN ORDER HEAP rule for this iteration index 'i'.
            upheapifyOperation(arr, parentIndex, i);
        }

        if(arr.length==1)return;
        //////now perform down-heapify operation between 1st element & (n-1)th element, then 1st element & (n-2)th element and so on.
        for(int i=0, k=0; i< arr.length-k; k++) {
            ////if arr.length - 1 == k then just swap the elements and skip
            if(arr.length-1-k == 0) {
                ////just swap the elements and SKIP
                if(arr[0] < arr[arr.length-k]) {
                    int temp = arr[0];
                    arr[0] = arr[arr.length-k];
                    arr[arr.length - k] = temp;
                }
                return;
            }
            ////first swap element i.e. 1st element and (last - ith) element.
            int tmp=arr[arr.length-1-k];
            arr[arr.length-1-k]=arr[0];
            arr[0]=tmp;

            /////proceed with the re-alignment (i.e. downheapify operation) of the data as per MIN ORDER HEAP rule for this iteration index 'i'.
            int parentIndex=0;
            downheapifyOperation(arr, parentIndex, -1, (arr.length-1)-k);
            //System.out.println("\n");
        }

        ///////proceed for simulation of deletion of elements from arr.
        System.out.println("testing");
    }

    private static void upheapifyOperation(int arr[], int parentIndex, int childIndex) {
        if(parentIndex<0)return;

        if(arr[parentIndex]>arr[childIndex]) {
            int tmp=arr[parentIndex];
            arr[parentIndex]=arr[childIndex];
            arr[childIndex]=tmp;

            childIndex=parentIndex;
        } else return;

        if(childIndex==0)return;
        /////////calculating newParentIndex and childIndex till this is MAXIMUM ORDER HEAP for the specified Iteration.
        parentIndex = (childIndex-1)/2;

        upheapifyOperation(arr, parentIndex, childIndex);
    }

    private static void downheapifyOperation(int arr[], int parentIndex, int childIndex, int maxIndex) {
        //////base case
        if (childIndex!= -1 && parentIndex >= childIndex) return;

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
            }
        }

        /////////first check whether to proceed with the LEFT or the RIGHT Child.
        indexLeftChild = (2 * parentIndex + 1);
        indexRightChild = (2 * parentIndex + 2);

        if(indexRightChild>= arr.length)
            childIndex=indexLeftChild;
        else if(indexRightChild>maxIndex && indexLeftChild<maxIndex)
            childIndex=indexLeftChild;
        else if (arr[indexLeftChild] < arr[indexRightChild] )
            childIndex = indexLeftChild;
        else
            childIndex = indexRightChild;

        if(childIndex>=maxIndex)return;
        if (arr.length - 1 >= childIndex) {
            downheapifyOperation(arr, parentIndex, childIndex, maxIndex);
        }
    }

}