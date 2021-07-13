package org.datastructure.java;

import org.datastructure.java.linear.linkedlist.single.NodeIfc;
import org.datastructure.java.linear.linkedlist.single.NodeImpl;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        System.out.println("<<<<<<<<<<<< CHECKING FOR SINGLE LINKED LIST DATA-STRUCTURE >>>>>>>>>>>>>>");
        NodeIfc singleLinkedList = new NodeImpl();
        singleLinkedList.addNode(10);
        singleLinkedList.addNode(20);
        singleLinkedList.addNode(30);
        singleLinkedList.addNode(40);
        singleLinkedList.addNode(50);

        /* ** display SingleLinkedList 'singleLinkedList' ** */
        singleLinkedList.display(singleLinkedList);

        /* ** now inserting an item at given Index in SingleLinkedList 'singleLinkedList' ** */
        singleLinkedList.set(singleLinkedList, 2, 100);

        /* ** display SingleLinkedList 'singleLinkedList' ** */
        singleLinkedList.display(singleLinkedList);

        /* ** now deleting specified value from SingleLinkedList 'singleLinkedList' ** */
        singleLinkedList.deleteByValue(singleLinkedList, 20);

        /* ** display SingleLinkedList 'singleLinkedList' ** */
        singleLinkedList.display(singleLinkedList);

        /* ** now deleting value at specified index from SingleLinkedList 'singleLinkedList' ** */
        singleLinkedList.deleteByIndex(singleLinkedList, 3);

        /* ** display SingleLinkedList 'singleLinkedList' ** */
        singleLinkedList.display(singleLinkedList);
    }
}
