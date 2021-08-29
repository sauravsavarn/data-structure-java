package org.datastructure.java.priorityQueue.kLargestElements;

import java.util.ArrayList;

public class Solution {

    static ArrayList<Integer> aList = new ArrayList<>();

    public static ArrayList<Integer> kLargest(int input[], int k) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        if (input.length == 0) return null;
        if (input.length == 1) {
            aList.add(input[0]);
            return aList;
        }

        ///////firstly call for downHeafify 1st k elements in arr.
//        for (int i = 1; i < k; i++) {
//            int parentIndex = i - 1;
//            int childIndex = -1;
//
//            downheapifyOperation(input, parentIndex, childIndex, k - 1);
//        }

        ///////firstly call for upHeafify 1st k elements in arr.
        for (int i = k-1; i >=0; i--) {
            int childIndex = i;
            //////get the Parent of the CHild.
            int parentIndex = (i-1)/2;

            /////proceed with the re-alignment (i.e. upheapify operation) of the data as per MIN ORDER HEAP rule for this iteration index 'i'.
            upheapifyOperation(input, parentIndex, i);
        }
        for (int i = 1; i < k; i++) {
            int parentIndex = i - 1;
            int childIndex = -1;

            downheapifyOperation(input, parentIndex, childIndex, k - 1);
        }
        System.out.println("testing");

        ////////now working on element by element iff any root-node value is less than the (k+i)th element then replace with the value from (k+i)th place
        for (int i = k; i < input.length; i++) {
            if (input[0] < input[i]) {
                ////replace the top-element
                input[0] = input[i];
                ////now proceed with the downHeapifyOperation
                int parentIndex=0;
                int childIndex=-1;
                downheapifyOperation(input, parentIndex, childIndex, k - 1);
            }
        }

        /////
        //////now perform down-heapify operation between 1st element & (n-1)th element, then 1st element & (n-2)th element and so on.
        for(int i=0, j=0; i< k-j; j++) {
            ////if arr.length - 1 == k then just swap the elements and skip
            if(k-j == 0) {
                ////just swap the elements and SKIP
                if(input[0] < input[k-j-1]) {
                    int temp = input[0];
                    input[0] = input[k-j-1];
                    input[k-j] = temp;
                }
                break;
            }
            ////first swap element i.e. 1st element and (last - ith) element.
            int tmp=input[k-j-1];
            input[k-j-1]=input[0];
            input[0]=tmp;

            /////proceed with the re-alignment (i.e. downheapify operation) of the data as per MIN ORDER HEAP rule for this iteration index 'i'.
            int parentIndex=0;
            downheapifyOperation(input, parentIndex, -1, k-j-2);
            //System.out.println("\n");
        }

        ////////finally add 1st k elements from this processed array 'input' into ArrayList 'aList'.
        for (int i = k-1; i >= 0; i--) {
            aList.add(input[i]);
        }
        return aList;
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

    static void downheapifyOperation(int[] arr, int parentIndex, int childIndex, int maxIndexToCare) {
        //////base case
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
            } else return;
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