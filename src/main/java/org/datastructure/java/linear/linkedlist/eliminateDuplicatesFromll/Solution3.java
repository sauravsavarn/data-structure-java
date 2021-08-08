package org.datastructure.java.linear.linkedlist.eliminateDuplicatesFromll;

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

public class Solution3 {

    public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {
        if(head==null)
            return head;

        LinkedListNode<Integer> currNode = head;
        LinkedListNode<Integer> startNode = null;
        LinkedListNode<Integer> newNode = new LinkedListNode<>(currNode.data);
        startNode = newNode;
        head = startNode;
        currNode=currNode.next;

        while(currNode!=null) {
            if(startNode.data != currNode.data && currNode.data != null) {
                LinkedListNode<Integer> newNode1 = new LinkedListNode<>(currNode.data);
                startNode.next=newNode1;
                startNode=startNode.next;
            }

            currNode=currNode.next;
        }

        return head;
    }

}