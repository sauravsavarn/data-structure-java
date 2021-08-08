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

public class Solution4 {

    public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {
        if(head==null)
            return head;

        LinkedListNode<Integer> currNode = head;
        LinkedListNode<Integer> head1 = currNode;
        LinkedListNode<Integer> prevNode = head1;
        currNode=currNode.next;
        prevNode.next=null;

        while (currNode!=null) {
            //if(prevNode.data!=currNode.data) {
            if(!prevNode.data.equals(currNode.data)) {
                prevNode.next=currNode;
                prevNode=prevNode.next;
            }

            currNode=currNode.next;
            prevNode.next=null;
        }

        return head1;
    }

}