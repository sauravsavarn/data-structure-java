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

public class Solution1 {

    public static void printReverse(LinkedListNode<Integer> root) {
        if(root==null)
            return;

        LinkedListNode<Integer> currNode=root;
        LinkedListNode<Integer> startNode=null;
        while(currNode!=null) {
            if(startNode==null) {
                LinkedListNode<Integer> newNode = new LinkedListNode<>(currNode.data);
                startNode = newNode;
            }
            else{
                LinkedListNode<Integer> interimNode = startNode;
                startNode = new LinkedListNode<>(currNode.data);
                startNode.next=interimNode;
            }

            currNode=currNode.next;
        }

        //finally printing
        while (startNode!=null) {
            System.out.print(startNode.data+ " ");
            startNode=startNode.next;
        }
    }

}