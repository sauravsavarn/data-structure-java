package org.datastructure.java.linear.linkedlist.palindromell;

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

import java.util.HashMap;

public class Solution {

    static HashMap<Integer, Integer> hm = new HashMap();
    public static boolean isPalindrome(LinkedListNode<Integer> head) {
        if(head==null)
            return true;

        /////loop through the LinkedList and increment/decrement the value by 1 iff data not exists
        /////or exists respectively.
        int indexLL=0;
        while (head!=null) {
            hm.put(indexLL, head.data);
            head=head.next;
            indexLL++;
        }

        /////check if the Map has all key value final SUM==0
        int j=hm.size();
        boolean isPalindrome=true;
        for (int i = 0; i < j;) {

            if(hm.get(i)!=hm.get(j-1) && i!=j){
                isPalindrome=false;
                break;
            } else {
                i++;
                j--;
            }
        }

        return isPalindrome;
    }

}