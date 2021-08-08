package org.datastructure.java.linear.linkedlist.insertnodeINll;

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

    public static LinkedListNode<Integer> insert(LinkedListNode<Integer> head, int pos, int data){

        if(head==null)
            return head;

        if(pos==0) {
            /////signifies that data to be added here

            /* ** ** */
            LinkedListNode<Integer> newNode = new LinkedListNode<>(data);
            newNode.next=head;
            return newNode;
        }

        LinkedListNode<Integer> sHead =  insert(head.next, pos-1, data);
        head.next=sHead;
        return head;
    }
}
