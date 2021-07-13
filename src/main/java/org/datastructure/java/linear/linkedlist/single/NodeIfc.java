package org.datastructure.java.linear.linkedlist.single;

import org.datastructure.java.linear.linkedlist.Node;

/**
 *
 */
public interface NodeIfc<T> {

    /**
     * add new node with data of type 'T'
     *
     * @param data
     */
    Node<T> addNode(T data);

    /**
     * delete a node by index, where index can be the first or last or may be any intermediary value.
     *
     * @param linkedList
     * @param index
     * @param <L>
     */
    <L> void deleteByIndex(L linkedList, int index);

    /**
     * delete a node by the data value contained in the LinkedList passed as parameter.
     *
     * @param linkedList
     * @param data
     * @param <L>
     */
    <L> void deleteByValue(L linkedList, Object data);

    /**
     * set the element 'T' at specified index 'index' within the LinkedList passed as parameter.
     *
     * @param linkedList
     * @param index
     * @param data
     * @param <L>
     */
    <L> void set(L linkedList, int index, T data);

    /**
     * display all the elements into the LinkedList.
     *
     * @param linkedList
     * @param <L>
     */
    <L> void display(L linkedList);
}