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

public class Solution1 {

    public static LinkedListNode<Integer> insert(LinkedListNode<Integer> head, int pos, int data){
        //Your code goes here
        LinkedListNode<Integer> currentNode = head;
        LinkedListNode<Integer> prevNode = null;
        if(currentNode==null)
            return head;

        int currPos=-1;
        while (currentNode!=null) {
            currPos++;
            if(currPos==pos && pos==0) {
                LinkedListNode<Integer> currNode = new LinkedListNode<>(data);
                currNode.next=currentNode;
                head=currNode;
                break;
            } else {
                if(currPos==pos) {
                    LinkedListNode<Integer> newNode = new LinkedListNode<>(data);
                    newNode.next = currentNode;
                    prevNode.next=newNode;
                    break;
                }
                if(pos == currPos+1 && currentNode.next==null) {
                    LinkedListNode<Integer> newNode = new LinkedListNode<>(data);
                    currentNode.next = newNode;
                    break;
                }
            }
            prevNode=currentNode;
            currentNode = currentNode.next;
        }

        return head;
    }
}
