package org.datastructure.java.linear.linkedlist.mergesortll;

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
//////Solution1 has errors and needs to re-work
public class Solution1 {

    public static LinkedListNode<Integer> mergeSort(LinkedListNode<Integer> head) {
        if(head==null || head.next == null)
            return head;

        //////find the mid-point of the LinkedList
        LinkedListNode<Integer> lHalf = mergeSort(midPoint(head, 0));
        LinkedListNode<Integer> rHalf = mergeSort(midPoint(head, 1));
        return mergeTwoSortedLinkedLists(lHalf, rHalf);
    }

    private static LinkedListNode<Integer> midPoint(LinkedListNode<Integer> head, int pos) {
        if (head == null || head.next == null) {
            return head;
        }

        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> sHead = slow;
        LinkedListNode<Integer> fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if(pos==0) {
            LinkedListNode<Integer> temp = slow;
            slow=slow.next;
            //temp.next=null;
            temp=null;
            return  sHead;
        } else
            return slow=slow.next;
    }

    public static LinkedListNode<Integer> mergeTwoSortedLinkedLists(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {

        if(head1==null && head2==null)
            return head1;
        if(head1!=null && head2==null)
            return head1;
        if(head1==null && head2!=null)
            return head2;

        LinkedListNode<Integer> currNode=head1;
        LinkedListNode<Integer> mergedNode=null;
        LinkedListNode<Integer> lHead=null;
        while(currNode!=null) {

            if(head2==null) {
                mergedNode.next=currNode;
                break;
            }
            if(currNode.data < head2.data) {
                if(mergedNode==null) {
                    mergedNode = new LinkedListNode<>(currNode.data);
                    lHead=mergedNode;
                } else {
                    mergedNode.next = new LinkedListNode<>(currNode.data);
                    mergedNode=mergedNode.next;
                }
                currNode=currNode.next;
            } else if(currNode.data > head2.data) {
                if(mergedNode==null) {
                    mergedNode = new LinkedListNode<>(head2.data);
                    lHead=mergedNode;
                } else {
                    mergedNode.next = new LinkedListNode<>(head2.data);
                    mergedNode=mergedNode.next;
                }
                head2=head2.next;
            } else {
                if(mergedNode==null) {
                    mergedNode = new LinkedListNode<>(currNode.data);
                    lHead=mergedNode;
                    mergedNode.next = new LinkedListNode<>(head2.data);
                    mergedNode=mergedNode.next;
                } else {
                    mergedNode.next = new LinkedListNode<>(currNode.data);
                    mergedNode=mergedNode.next;
                    mergedNode.next = new LinkedListNode<>(head2.data);
                    mergedNode=mergedNode.next;
                }
                currNode=currNode.next;
                head2=head2.next;
            }
        }

        if(head2!=null) {
            mergedNode.next=head2;
        }

        /* ** ** */
        return lHead;
    }
}