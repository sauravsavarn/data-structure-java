package org.datastructure.java.linear.linkedlist.deletenodeINll;

/****************************************************************

 Following is the Node class already written for the Linked List

 class LinkedListNode<T> {
 T data;
 LinkedListNode<T> next;

 public LinkedListNode(T data) {
 this.data = data;
 }
 }
 *****************************************************************/


public class Solution1 {
    public static LinkedListNode<Integer> deleteNode(LinkedListNode<Integer> head, int pos) {

        if(head==null)
            return head;

        int currPos=-1;
        LinkedListNode<Integer> prevNode=null;
        LinkedListNode<Integer> currNode=head;

        if(pos==0) {
            head=head.next;
            return head;
        } else {

            while(currPos<pos && currNode!=null) {
                currPos++;
                if(currPos==pos) {
                    prevNode.next = currNode.next;
                    break;
                }
                prevNode=currNode;
                currNode=currNode.next;
            }
            currPos++;
            if(currPos==pos && currNode==null) {
                //do nothing
            } else {
                if(currPos==pos && currNode.next==null) {
                    prevNode.next=null;
                } else if(currPos==pos && currNode.next!=null) {
                    prevNode.next = currNode.next;
                }
            }
        }

        /* ** ** */
        return head;
    }
}
