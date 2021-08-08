package org.datastructure.java.linear.linkedlist.printreversell.pb1;

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

    public static void printReverse(LinkedListNode<Integer> root) {
        if(root==null)
            return;
        printReverse(root.next);
        System.out.print(root.data+ " ");
    }

}