package org.datastructure.java.priorityQueue.buyTheTicket;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {

    public static int buyTicket(int input[], int k) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        Queue<Ticket> queue = new LinkedList<>();
        for (int i = 0; i < input.length; i++) {
            boolean destinedElement = false;
            if (k == i) {
                destinedElement = true;
            }
            int index = i;
            int priority = input[i];

            //////////adding these information into the Queue
            queue.add(new Ticket(priority, index, destinedElement));
        }

        int counter = 0;
        int largestElementToGet = 1;
        while (true) {
            Ticket ticket = queue.poll();
            ///////get the 1s Largest Element
            int firstLargestElement = kthLargest(input, largestElementToGet);

            if (ticket.priority == firstLargestElement) {
                counter++;
                largestElementToGet += 1;
            } else {
                queue.add(ticket);
            }

            if (ticket.destinedElement && ticket.priority == firstLargestElement) {
                break;
            }
        }

        return counter;
    }

    private static int kthLargest(int[] input, int k) {
        // Write your code here
        int numOfLeafNodes = input.length / 2;
        for (int i = numOfLeafNodes - 1; i >= 0; i--) {
            /////now perform downHeapify and check at Every STEP(s) if it is a MAX HEAP.
            int parentIndex = i;
            int childIndex = -1;
            downHeapifyOperation(input, parentIndex, childIndex);
        }

        ////////now working on element by element iff any root-node value is less than the (k+i)th element then replace with the value from (k+i)th place
        for (int j = 0, i = input.length - 1 - j; i >= 0; i--, j++) {
            ////SWAP the top-element
            int element = input[0];
            input[0] = input[i];
            input[i] = element;

            ////now proceed with the downHeapifyOperation
            int parentIndex = 0;
            int childIndex = -1;
            downheapifyOperation(input, parentIndex, childIndex, i - 1);
        }

        ///////////now get the kth element
        return input[k - 1];
    }

    private static boolean downHeapifyOperation(int arr[], int parentIndex, int childIndex) {
        if (childIndex != -1 && parentIndex >= childIndex) return true;

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
            return downHeapifyOperation(arr, parentIndex, childIndex);
        } else return true;
    }

    private static void downheapifyOperation(int arr[], int parentIndex, int childIndex, int maxIndexToCare) {
        //////base case
        if (maxIndexToCare <= 0) return;
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
        else if (indexRightChild > maxIndexToCare)
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

//class Ticket {
//    int priority;
//    int index;
//    boolean destinedElement = false;
//
//    public Ticket(int priority, int index, boolean destinedElement) {
//        this.priority = priority;
//        this.index = index;
//        this.destinedElement = destinedElement;
//    }
//}