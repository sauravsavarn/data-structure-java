package org.datastructure.java.linear.linkedlist.deletenodeINll;

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
/////////THIS IS THE RECURSIVE WAY FOR NODE INSERTION INTO LINKED-LIST
public class Solution2 {

    public static LinkedListNode<Integer> deleteNode(LinkedListNode<Integer> head, int pos) {

        if(head==null)
            return head;

        if(pos==0) { //////signifies that item has been identified to delete
            head=head.next;
            return head;
//            LinkedListNode<Integer> newNode = head.next;
//            return newNode;
        }

        LinkedListNode<Integer> sHead = deleteNode(head.next, pos-1);
        head.next=sHead;
        return head;
    }
}
