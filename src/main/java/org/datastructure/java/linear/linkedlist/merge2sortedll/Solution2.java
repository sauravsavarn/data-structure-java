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

public class Solution2 {

    public static LinkedListNode<Integer> mergeTwoSortedLinkedLists(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {

        if(head1==null && head2==null)
            return head1;
        if(head1!=null && head2==null)
            return head1;
        if(head1==null && head2!=null)
            return head2;

        LinkedListNode<Integer> currNode=head1;
//        LinkedListNode<Integer> mergedNode=null;
        LinkedListNode<Integer> lHead=null; //currNode
        while(currNode!=null) {

            if(head2==null) {
                //mergedNode.next=currNode;
                break;
            }
            if(currNode.data < head2.data) {
                if(lHead==null)
                    lHead = currNode;
                currNode=currNode.next;
            } else if(currNode.data > head2.data) {
                if(lHead==null)
                    lHead = head2;

                LinkedListNode<Integer> tempNode = currNode;
                currNode=head2;
                head2=head2.next;
                currNode.next=tempNode;
//                currNode=currNode.next;
            } else {
                LinkedListNode<Integer> tempNode = head2;
                currNode.next=head2;
                currNode=currNode.next;
                head2=head2.next;
                currNode.next=null;
            }
        }

        if(head2!=null) {
            currNode.next=head2;
        }

        /* ** ** */
        return lHead;
    }

}