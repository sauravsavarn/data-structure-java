package org.datastructure.java.linear.linkedlist.midpointll;

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

    static int slowIndex=-1;
    static int fastIndex=-1;

    public static LinkedListNode<Integer> midPoint(LinkedListNode<Integer> head) {

        if(head==null || head.next==null) {
            return head;
        }

        calculateMidpoint(head);

        int indexLL=0;
        LinkedListNode<Integer> midLL=null;
        while (head!=null) {
            if(indexLL==slowIndex) {
                midLL=head;
                break;
            }
            head=head.next;
            indexLL++;
        }

        return midLL;
    }

    private static void calculateMidpoint(LinkedListNode<Integer> head) {
        if(head==null || head.next==null) {
            return;
        }

        if(slowIndex==-1) {
            slowIndex++;
            fastIndex++;
            calculateMidpoint(head.next);
        } else {
            slowIndex++;
            fastIndex += 2;
            calculateMidpoint(head.next.next);
        }


    }

}