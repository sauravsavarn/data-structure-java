package org.datastructure.java.linear.linkedlist.findNodeInll.usingiterativeway;

/****************************************************************

 Following is the class structure of the Node class:

 class LinkedListNode<T> {
 T data;
 LinkedListNode<T> next;

 public LinkedListNode(T data) {
 this.data = data;
 }
 }

 *****************************************************************/

public class Solution1 {
    public static int findNode(LinkedListNode<Integer> head, int n) {
        if(head==null)
            return -1;

        LinkedListNode<Integer> currNode = head;
        int indexLL = -1;
        boolean found = false;
        while(currNode!= null) {
            indexLL++;
            if(currNode.data==n) {
                found =true;
                break;
            }

            currNode = currNode.next;
        }

        if(!found)
            indexLL=-1;

        return indexLL;
    }
}
