package org.datastructure.java.linear.linkedlist.appendLastNToFirst;

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

    public static LinkedListNode<Integer> appendLastNToFirst(LinkedListNode<Integer> head, int n) {
        if (head == null)
            return head;

        LinkedListNode<Integer> currNode = head;
        LinkedListNode<Integer> prevNode = null;
        LinkedListNode<Integer> lastNode = head;

        int indexLL=-1;
        int indexLLLast=0;
        ////find the last node first
        while(currNode!=null) {
            indexLL++;
            if(currNode.next==null) {
                lastNode = currNode;
                indexLLLast=indexLL;
                break;
            }
            currNode=currNode.next;
        }

        ////now finding total index to travel from 1st node
        int indexToTraverse=(indexLLLast-n+1);

        ////
        indexLL = -1;
        currNode=head;
        while (currNode != null) {
            indexLL++;
            if (indexToTraverse == indexLL) {
                lastNode.next=head;
                head=currNode;
                prevNode.next=null;
                break;
            }

            prevNode = currNode;
            currNode = currNode.next;
        }

        return head;
    }

}