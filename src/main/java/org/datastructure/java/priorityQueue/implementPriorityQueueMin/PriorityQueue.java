package org.datastructure.java.priorityQueue.implementPriorityQueueMin;

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
 *
 * @param <T>
 */
public class PriorityQueue<T> {
    private ArrayList<Element<T>> heap;

    public PriorityQueue() {
        ////INITIALISE THE ARRAYLIST
        heap = new ArrayList<>();
    }

    //////now declaring common function(s) of PriorityQueue

    public void insert(T value, int priority) {
        if (heap.isEmpty()) heap.add(new Element<>(value, priority));
        else {
            Element<T> element = new Element<>(value, priority);
            /////first add element to the last of HEAP
            heap.add(element);

            ////Now proceed for the re-align of the newly added element into HEAP,
            // which is added as last element of HEAP.
            reAlignmentIns(element, -1, element, heap.indexOf(element));
        }
    }

    public T getMinimum() throws PriorityQueueException {
        if (!heap.isEmpty()) return (T) heap.get(0).value;
        else
            throw new PriorityQueueException();
    }

    /**
     * @return
     */
    public T removeMinimum() throws PriorityQueueException {
        T minValue;
        if (!heap.isEmpty()) {
            minValue=heap.get(0).value;
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
     * @return
     */
    public int size() {
        return heap.size(); ////whatever the size of arrylist is the size of the PriorityQueue.
    }

    /**
     * @return
     */
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    /**
     * Calling re-alignment of Nodes inside HEAP using Recursion for Insertion Operation.
     *
     * @param parent
     * @param indexOfParent
     * @param element
     * @param indexOfElement
     */
    private void reAlignmentIns(Element<T> parent, int indexOfParent, Element<T> element, int indexOfElement) {
        //////base case
        if (parent.priority < element.priority) return;

        if (indexOfParent != -1) {
            if (parent.priority > element.priority) {
                ////////thus setting this into ArrayList
                Element<T> interimElement = heap.get(indexOfElement);
                heap.set(indexOfElement, heap.get(indexOfParent));
                heap.set(indexOfParent, interimElement);

                ///////also swapping index of both new-Child & new-Parent.
                indexOfElement = indexOfParent;
            }
        }

        /////first check for the parent of this newly added element and check whether
        /////this is >greater or <less than.
        //int indexParent = (indexOfElement - 1) / 2;
        indexOfParent = (indexOfElement - 1) / 2;
        parent = heap.get(indexOfParent);
        element = heap.get(indexOfElement);

        reAlignmentIns(parent, indexOfParent, element, indexOfElement);
    }

    /**
     * Calling re-alignment of Nodes inside HEAP using Recursion for Insertion Operation.
     *
     * @param parent
     * @param indexOfParent
     * @param child
     * @param indexOfChild
     */
    private void reAlignmentRemove(Element<T> parent, int indexOfParent, Element<T> child, int indexOfChild) {
        //////base case
        if (indexOfChild!= -1 && parent.priority <= child.priority) return;

        ////////get Index of Left & Right child
        int indexLeftChild = -1;
        int indexRightChild = -1;

        if (indexOfChild != -1) {
            if (parent.priority > child.priority) {
                Element<T> element = parent;
                heap.set(indexOfParent, child);
                heap.set(indexOfChild, element);

                ///////also swapping index of both new-Child & new-Parent.
                indexOfParent = indexOfChild;

            }
        }

        /////////first check whether to proceed with the LEFT or the RIGHT Child.
        indexLeftChild = (2 * indexOfParent + 1);
        indexRightChild = (2 * indexOfParent + 2);

        if (heap.get(indexLeftChild).priority < heap.get(indexRightChild).priority)
            indexOfChild = indexLeftChild;
        else
            indexOfChild = indexRightChild;

        if (heap.size() - 1 >= indexOfChild) {
            child = heap.get(indexOfChild);
            reAlignmentRemove(parent, indexOfParent, child, indexOfChild);
        }
    }

    /**
     * Print all the elements of the PriorityQueue.
     */
    public void printAll() {
        this.heap.forEach(element -> System.out.print("[  " + element.priority + " , " + element.value + " ] " + " "));
    }
}

class PriorityQueueException extends Exception {
}
