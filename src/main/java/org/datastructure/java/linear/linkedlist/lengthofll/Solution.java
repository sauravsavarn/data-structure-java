package org.datastructure.java.linear.linkedlist.lengthofll;

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

    public static int length(LinkedListNode<Integer> head){
        //Your code goes here
        if(head ==null)
            return 0;

        int lengthh =0;
        while(head != null) {
            if(head.data !=-1)
                lengthh = lengthh+1;
            head = head.next;
        }

        return lengthh;
    }
}
