package org.datastructure.java.linear.linkedlist.evenafteroddll;

public class Solution3 {

    static LinkedListNode<Integer> eHead, eTail, oHead, oTail = null;

    public static LinkedListNode<Integer> evenAfterOdd(LinkedListNode<Integer> head) {
        if (head == null)
            return head;

        LinkedListNode<Integer> finalLL = evenAfterOdd1(head);
        if(oTail!=null)
            oTail.next=eHead;
        if(eTail!=null)
            eTail.next=null;
        if(oHead==null && eHead!=null)
            return eHead;
        else
            return oHead;
    }

    public static LinkedListNode<Integer> evenAfterOdd1(LinkedListNode<Integer> head) {
        if (head == null)
            return head;

        if (head.data % 2 == 0) {
            if (eHead == null) {
                eHead = head;
                eTail = eHead;
            } else {
                //////check the node which eTail is connected to  if-not odd or otherwise.
                if (eTail.next == oTail) {
                    eTail.next = oTail.next;
                    eTail = eTail.next;
                    oTail.next = head.next;
                    //eTail = eTail.next;
                    eTail.next = oTail;
                    head=head.next;
                } else if (oTail!=null && oTail.next == head) {
                    eTail.next = head;
                    eTail = eTail.next;
                    oTail.next=null;
                } else {
                    eTail.next = head;
                    eTail = eTail.next;
                }
            }
        } else {
            if (oHead == null) {
                oHead = head;
                oTail = oHead;
            } else {
                if (oTail.next == eTail) {
                    oTail.next = eTail.next;
                    //eTail.next = head.next;
                    oTail = oTail.next;
                    eTail.next = oTail;
                } else {
                    oTail.next = head;
                    oTail = oTail.next;
                }
            }
        }

        LinkedListNode<Integer> interimLL = evenAfterOdd1(head.next);
        //head.next = interimLL;
        //return head;
        return interimLL;
    }
}
