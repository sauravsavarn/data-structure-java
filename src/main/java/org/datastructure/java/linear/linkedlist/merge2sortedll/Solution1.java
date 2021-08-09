package org.datastructure.java.linear.linkedlist.merge2sortedll;

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