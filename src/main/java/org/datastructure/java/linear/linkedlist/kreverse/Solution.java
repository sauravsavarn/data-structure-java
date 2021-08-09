package org.datastructure.java.linear.linkedlist.kreverse;

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

    public static LinkedListNode<Integer> kReverse(LinkedListNode<Integer> head, int k) {
        //Your code goes here
        if(head == null)
            return null;
        if(k==0)
            return head;
        LinkedListNode<Integer> current = head;
        LinkedListNode<Integer> next = null;
        LinkedListNode<Integer> prev = null;

        int count = 0;

        /* Reverse first k nodes of linked list */
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        /* next is now a pointer to (k+1)th node
           Recursively call for the list starting from
           current. And make rest of the list as next of
           first node */
        if (next != null)
            head.next = kReverse(next, k);

        // prev is now head of input list
        return prev;
    }

}