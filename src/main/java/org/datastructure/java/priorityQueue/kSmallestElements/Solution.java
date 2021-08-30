package org.datastructure.java.priorityQueue.kSmallestElements;

import java.util.ArrayList;

public class Solution {

    public static ArrayList<Integer> kSmallest(int n, int[] input, int k) {
        // Write your code here
        ArrayList<Integer> aListResult = new ArrayList<>();

        ///////
        if(input.length==0) return null;

        ///////now check for the upHeapify Operation
        for (int i = k-1; i >0 ; i--) {
            //////
            int parentIndex = (i-1)/2;
            upHeapifyOperation(input, parentIndex, i);
        }

        ///////firstly call for downHeafify 1st k elements in arr.
        for (int i = 1; i < k; i++) {
            int parentIndex = i - 1;
            int childIndex = -1;

            downheapifyOperation(input, parentIndex, childIndex, k - 1);
        }

        System.out.println("testing");
        ////////now working on element by element iff any root-node value is less than the (k+i)th element then replace with the value from (k+i)th place
        for (int i = k; i < input.length; i++) {
            if (input[0] > input[i]) {
                ////replace the top-element
                input[0] = input[i];
                ////now proceed with the downHeapifyOperation
                int parentIndex=0;
                int childIndex=-1;
                downheapifyOperation(input, parentIndex, childIndex, k - 1);
            }
        }

        ////////finally add 1st k elements from this processed array 'input' into ArrayList 'aList'.
        for (int i = k-1; i >= 0; i--) {
            aListResult.add(input[i]);
        }
        return aListResult;
    }

    static void upHeapifyOperation(int[] input, int parentIndex, int childIndex) {

        if(parentIndex < 0) return;

        if(input[parentIndex] < input[childIndex]) {
            /////SWAP elements
            int tmp = input[childIndex];
            input[childIndex] = input[parentIndex];
            input[parentIndex] = tmp;

            childIndex=parentIndex;
        } else return;

        if(childIndex==0)return;
        /////////calculating newParentIndex and childIndex till this is MAXIMUM ORDER HEAP for the specified Iteration.
        parentIndex = (childIndex-1)/2;

        upHeapifyOperation(input, parentIndex, childIndex);
    }

    static void downheapifyOperation(int[] input, int parentIndex, int childIndex, int maxIndexToCare) {
        //////base case
        if (childIndex != -1 && parentIndex >= childIndex) return;
        if (childIndex > maxIndexToCare || parentIndex > maxIndexToCare) return;

        ////////get Index of Left & Right child
        int indexLeftChild = -1;
        int indexRightChild = -1;

        if(childIndex!=-1) {
            if(input[parentIndex] < input[childIndex]) {
                int element=input[parentIndex];
                input[parentIndex] = input[childIndex];
                input[childIndex] = element;

                ///////also swapping index of both new-Child & new-Parent.
                parentIndex=childIndex;
            } else return;
        }

        /////////first check whether to proceed with the LEFT or the RIGHT Child.
        indexLeftChild = (2 * parentIndex + 1);
        indexRightChild = (2 * parentIndex + 2);


        if (indexRightChild >= input.length)
            childIndex = indexLeftChild;
        else if(indexRightChild > maxIndexToCare)
            childIndex = indexLeftChild;
        else if (input[indexLeftChild] > input[indexRightChild])
            childIndex = indexLeftChild;
        else
            childIndex = indexRightChild;

        if (input.length - 1 >= childIndex) {
            downheapifyOperation(input, parentIndex, childIndex, maxIndexToCare);
        }
    }
}