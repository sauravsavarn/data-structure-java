package org.datastructure.java.linear.linkedlist.bubblesortIterativell;

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

    public static LinkedListNode<Integer> bubbleSort(LinkedListNode<Integer> head) {
        //Write your code here
        if (head == null || head.next == null)
            return head;

        for (int i = 0; i < lengthLL(head) - 1; i++) {
            LinkedListNode<Integer> prev = null;
            LinkedListNode<Integer> curr = head;
            LinkedListNode<Integer> next = curr.next;

            while (curr.next != null) {
                if (curr.data > curr.next.data) {
                    if (prev == null) {
                        curr.next = next.next;
                        next.next = curr;
                        prev = next;
                        head = prev;
                    } else {
                        next = curr.next;
                        curr.next = next.next;
                        prev.next = next;
                        next.next = curr;
                        prev = next;
                    }
                } else {
                    prev = curr;
                    curr = curr.next;
                }
            }
        }
        return head;
    }

    private static int lengthLL(LinkedListNode<Integer> head) {
        int count = 1;
        while (head.next != null) {
            head = head.next;
            count++;
        }
        return count;
    }

}