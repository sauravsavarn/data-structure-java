package org.datastructure.java.linear.linkedlist.printiTHnode;
/*

 	Following is the Node class already written for the Linked List

	class LinkedListNode<T> {
		T data;
		LinkedListNode<T> next;

		public Node(T data) {
			this.data = data;
		}
	}

*/

public class Solution {

    public static void printIthNode(LinkedListNode<Integer> head, int i) {
        //Your code goes here
        if (head == null)
            return;
        if (i == -1)
            return;

        int counter = 0;
        while (head != null) {

            if (counter == i) {
                System.out.println(head.data);
                break;
            }

            head = head.next;
            counter++;

        }


    }
}