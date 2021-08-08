package org.datastructure.java.linear.linkedlist.midpointll;

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

public class Solution2 {

    public static LinkedListNode<Integer> midPoint(LinkedListNode<Integer> head) {

        if (head == null) {
            return head;
        }
        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head.next;
        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}