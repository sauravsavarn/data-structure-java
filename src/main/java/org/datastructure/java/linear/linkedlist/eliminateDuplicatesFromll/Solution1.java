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

public class Solution1 {

    public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {
        if(head==null)
            return head;

        LinkedListNode<Integer> currNode = head;
        LinkedListNode<Integer> prevNode = null;
        LinkedListNode<Integer> startNode = null;
        while(currNode!=null) {
            if(prevNode==null) {
                prevNode=currNode;
                startNode=prevNode;
            } else {
                if(prevNode.data != currNode.data) {
                    prevNode.next=currNode;
                    prevNode=prevNode.next;
//                    prevNode.next=null;
                }
                if(prevNode.data == currNode.data && currNode.next==null) {
                    prevNode.next=null;
                }
            }

            currNode=currNode.next;
        }

        head=startNode;
        return head;
    }

}