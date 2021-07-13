package org.datastructure.java.linear.linkedlist.single;

import org.datastructure.java.linear.linkedlist.Node;

/**
 *
 */
public class NodeImpl<T> implements NodeIfc {
    Node head = null;
    Node tail = null;

//    static class Node<T> {
//        T data;
//        Node next;
//
//        Node(T data) {
//            this.data = data;
//            next = null;
//        }
//    }

    @Override
    public Node addNode(Object data) {
        /* ** ** */
        Node node = new Node(data);

        /* ** ** */
        if(head == null && tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }

        /* ** ** */
        return node;
    }

    @Override
    public void set(Object linkedList, int index, Object data) {
        /* ** ** */
        Node node = new Node(data);

        /* ** ** */
        Node current = head;
        Node prev = null;

        int k=1;
        while (current != null) {
            if(index == 0) {
                node.next = head;
                head = node;
            } else {
                if(index == k) {
                    prev.next = node;
                    node.next = current;

                    /* ** ** */
                    break;
                }
            }
            prev = current;
            current = current.next;
            k +=1;
        }

    }

    @Override
    public void deleteByValue(Object linkedList, Object data) {
        Node current = head;
        Node prev = head;

        /* ** ** */
        int k = 1;
        while (current != null) {
            if(current.data == data) {
                if(k==1) {
                    current = current.next;
                    head = current;
                    prev = current;
                } else {
                    prev.next = current.next;

                }
            }

            prev = current;
            current = current.next;
            k +=1;
        }

    }

    @Override
    public void deleteByIndex(Object linkedList, int index) {
        Node current = head;
        Node prev = null;

        int k = 0;
        while(current != null) {
            if(index == 0) {
                current = current.next;
                head = current;
                prev = current;

                /* ** ** */
                break;
            } else if( k == index) {

                if(current.next != null)
                    prev.next = current.next;
                else {
                    prev = current;
                    current = null;
                }

                /* ** ** */
                break;
            }

            prev = current;
            current = current.next;
            k +=1;
        }

    }

    @Override
    public void display(Object linkedList) {
        /* ** ** */
        Node current = head;
        System.out.println("");

        if(linkedList instanceof NodeImpl) {
            System.out.println("Nodes in LinkedList are : ");
            while (current != null) {
                System.out.print("\t" + current.data );

                /* ** ** */
                current = current.next;
            }
        }

    }

}
