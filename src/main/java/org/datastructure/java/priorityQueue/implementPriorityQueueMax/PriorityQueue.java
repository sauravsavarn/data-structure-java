package org.datastructure.java.priorityQueue.implementPriorityQueueMax;

import java.util.ArrayList;

/**
 * Create PriorityQueue using Heap and this Heap is created using ArrayList.
 * <p>
 * NOTE: Remember the 2 property of HEAP Data-Structure which is about 2 things :-
 * <p>
 * 1. CBT - it should be having Complete Binary Tree property
 * <p>
 * 2. HEAP Order Property - which is Minimum or Maximum Heap Property
 * <p>
 * <p>
 * NOTE:
 * 1. Insert Minimum to HEAP is Order of Height 'h' which is O(h) i.e. Time Complexity is O(logn)
 * 2. Remove Minimum from HEAP of Height 'h' which is O(h) i.e. Time Complexity is O(logn)
 */
public class PriorityQueue {
    private ArrayList<Integer> heap = new ArrayList<>();

    // Complete this class
    boolean isEmpty() {
        // Implement the isEmpty() function here
        return heap.isEmpty();
    }

    int getSize() {
        // Implement the getSize() function here
        return heap.size();
    }

    int getMax() {
        // Implement the getMax() function here
        if (!heap.isEmpty()) return heap.get(0);
        else
            return Integer.MIN_VALUE;
    }

    void insert(int element) {
        // Implement the insert() function here
        if (heap.isEmpty()) heap.add(element);
        else {
            /////first add element to the last of HEAP
            heap.add(element);

            ////Now proceed for the re-align of the newly added element into HEAP,
            // which is added as last element of HEAP.
            reAlignmentIns(element, -1, element, heap.indexOf(element));
        }
    }

    int removeMax() {
        // Implement the removeMax() function here
        int maxValue;
        if (!heap.isEmpty()) {
            maxValue=heap.get(0);
            //////copy last Element to 1st node which is MINIMUM of all nodes inside HEAP.
            heap.set(0, heap.remove(heap.size() - 1));

            //////Finally calling for the re-alignment of NODES such that MINIMUM-HEAP-ORDER property
            //////should be maintained.
            reAlignmentRemove(heap.get(0), 0, heap.get(0), -1);
        } else
            return Integer.MIN_VALUE;

        return maxValue;
    }

    /**
     * Calling re-alignment of Nodes inside HEAP using Recursion for Insertion Operation.
     *
     * @param parent
     * @param indexOfParent
     * @param child
     * @param indexOfChild
     */
    private void reAlignmentIns(int parent, int indexOfParent, int child, int indexOfChild) {
        //////base case
        if (parent > child) return;

        if (indexOfParent != -1) {
            if (parent < child) {
                ////////thus setting this into ArrayList
                int interimElement = heap.get(indexOfChild);
                heap.set(indexOfChild, heap.get(indexOfParent));
                heap.set(indexOfParent, interimElement);

                ///////also swapping index of both new-Child & new-Parent.
                indexOfChild = indexOfParent;
            }
        }

        if(indexOfChild-1 < 0)return;
        /////first check for the parent of this newly added element and check whether
        /////this is >greater or <less than.
        //int indexParent = (indexOfElement - 1) / 2;
        indexOfParent = (indexOfChild - 1) / 2;
        parent = heap.get(indexOfParent);
        child = heap.get(indexOfChild);

        reAlignmentIns(parent, indexOfParent, child, indexOfChild);
    }

    /**
     * Calling re-alignment of Nodes inside HEAP using Recursion for Insertion Operation.
     *
     * @param parent
     * @param indexOfParent
     * @param child
     * @param indexOfChild
     */
    private void reAlignmentRemove(int parent, int indexOfParent, int child, int indexOfChild) {
        //////base case
        if (indexOfChild!= -1 && parent >= child) return;

        ////////get Index of Left & Right child
        int indexLeftChild = -1;
        int indexRightChild = -1;

        if (indexOfChild != -1) {
            if (parent < child) {
                int element = parent;
                heap.set(indexOfParent, child);
                heap.set(indexOfChild, element);

                ///////also swapping index of both new-Child & new-Parent.
                indexOfParent = indexOfChild;

            }
        }

        /////////first check whether to proceed with the LEFT or the RIGHT Child.
        indexLeftChild = (2 * indexOfParent + 1);
        indexRightChild = (2 * indexOfParent + 2);

        if(indexRightChild>= heap.size())
            indexOfChild=indexLeftChild;
        else if (heap.get(indexLeftChild) > heap.get(indexRightChild) )
            indexOfChild = indexLeftChild;
        else
            indexOfChild = indexRightChild;

        if (heap.size() - 1 >= indexOfChild) {
            child = heap.get(indexOfChild);
            reAlignmentRemove(parent, indexOfParent, child, indexOfChild);
        }
    }
}


