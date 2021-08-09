package org.datastructure.java.linear.linkedlist.deleteeveryNnodes;

/*

    Following is the Node class already written for the Linked List

    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
        }
    }

*/


public class Solution {

    public static LinkedListNode<Integer> skipMdeleteN(LinkedListNode<Integer> head, int M, int N) {
        /////
        if(M==0)
            return null;

        if (head == null || head.next == null) {
            return head;
        }
        LinkedListNode<Integer> prev = null, nex;
        LinkedListNode<Integer> curr = head;
        // skip m nodes
        while (curr != null) {
            for (int i = 0; curr != null && i < M; i++) {
                prev = curr;
                curr = curr.next;
            }
            // delete next n nodes
            for (int i = 1; curr != null && i <= N; i++) {
                curr = curr.next;
            }
            // link remaining nodes with last node
            prev.next = curr;
        }
        return head;
        ////
    }
}