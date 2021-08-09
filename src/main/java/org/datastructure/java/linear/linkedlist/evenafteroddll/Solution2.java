package org.datastructure.java.linear.linkedlist.evenafteroddll;

public class Solution2 {

    public static LinkedListNode<Integer> evenAfterOdd(LinkedListNode<Integer> head) {

        if (head == null) return null;

        LinkedListNode<Integer> evenHead=null;
        LinkedListNode<Integer> evenTail=null;
        LinkedListNode<Integer> oddHead=null;
        LinkedListNode<Integer> oddTail=null;

        LinkedListNode<Integer> currNode=head;
        while(currNode!=null) {

            if(currNode.data%2==0) {
                if(evenHead==null) {
                    evenHead=currNode;
                    evenTail=currNode;
                } else {
                    evenTail.next=currNode;
                    evenTail=evenTail.next;
                }
            } else {
                if(oddHead==null) {
                    oddHead=currNode;
                    oddTail=currNode;
                } else {
                    oddTail.next=currNode;
                    oddTail=oddTail.next;
                }
            }

            currNode=currNode.next;
        }

        if(oddTail==null && oddHead==null) {
            oddHead=evenHead;
        } else {
            oddTail.next = evenHead;
        }
        return oddHead;
    }


}
