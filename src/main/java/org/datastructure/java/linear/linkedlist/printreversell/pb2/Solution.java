package org.datastructure.java.linear.linkedlist.printreversell.pb2;

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

    public static LinkedListNode<Integer> reverseLinkedListRec(LinkedListNode<Integer> head) {
        //Your code goes here
        if(head==null || head.next==null)
            return head;
        LinkedListNode<Integer> sHead = reverseLinkedListRec(head.next);
        LinkedListNode<Integer> newNode = new LinkedListNode<>(head.data);
        head=sHead;
        while(sHead!=null) {
            if(sHead.next == null) {
                sHead.next = newNode;
                break;
            }
            sHead=sHead.next;
        }
        return head;
    }

}