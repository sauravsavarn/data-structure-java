package org.datastructure.java.priorityQueue.removeMinimum;

import java.util.ArrayList;

public class PQ {

    private ArrayList<Integer> heap;

    public PQ() {
        heap = new ArrayList<Integer>();
    }

    boolean isEmpty() {
        return heap.size() == 0;
    }

    int size() {
        return heap.size();
    }

    int getMin() throws PriorityQueueException {
        if (isEmpty()) {
            // Throw an exception
            throw new PriorityQueueException();
        }
        return heap.get(0);
    }

    void insert(int element) {
        heap.add(element);
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;

        while (childIndex > 0) {
            if (heap.get(childIndex) < heap.get(parentIndex)) {
                int temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            } else {
                return;
            }
        }
    }

    int removeMin() throws PriorityQueueException {
        // Complete this function
        // Throw the exception PriorityQueueException if queue is empty
        int minValue;
        if (!heap.isEmpty()) {
            minValue=heap.get(0);
            //////copy last Element to 1st node which is MINIMUM of all nodes inside HEAP.
            heap.set(0, heap.remove(heap.size() - 1));

            //////Finally calling for the re-alignment of NODES such that MINIMUM-HEAP-ORDER property
            //////should be maintained.
            reAlignmentRemove(heap.get(0), 0, heap.get(0), -1);
        } else
            throw new PriorityQueueException();

        return minValue;

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
        if (indexOfChild!= -1 && parent <= child) return;

        ////////get Index of Left & Right child
        int indexLeftChild = -1;
        int indexRightChild = -1;

        if (indexOfChild != -1) {
            if (parent > child) {
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

        if(heap.size()-1< indexLeftChild && heap.size()-1 < indexRightChild)return;
        else if (heap.size()-1< indexRightChild) {
            indexOfChild = indexLeftChild;
        }
        else if (heap.get(indexLeftChild) < heap.get(indexRightChild))
            indexOfChild = indexLeftChild;
        else
            indexOfChild = indexRightChild;

        if (heap.size() - 1 >= indexOfChild) {
            child = heap.get(indexOfChild);
            reAlignmentRemove(parent, indexOfParent, child, indexOfChild);
        }
    }

}

class PriorityQueueException extends Exception {

}