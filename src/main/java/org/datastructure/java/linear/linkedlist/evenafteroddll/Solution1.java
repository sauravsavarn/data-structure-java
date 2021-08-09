package org.datastructure.java.linear.linkedlist.evenafteroddll;

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

    public static LinkedListNode<Integer> evenAfterOdd(LinkedListNode<Integer> head) {
        if (head == null)
            return head;

        LinkedListNode<Integer> currNode = head;
        LinkedListNode<Integer> oddPointer = null;
        LinkedListNode<Integer> evenPointer = null;
        //////////
        while (currNode != null) {

            if (currNode.data % 2 != 0) {
                if (oddPointer == null) {
                    oddPointer = currNode;
                    currNode=currNode.next;
                }
                else {
                    if (evenPointer == null) {
                        oddPointer.next = currNode;
                        oddPointer = oddPointer.next;
                        currNode = currNode.next;
                    } else {
                        LinkedListNode<Integer> temp = oddPointer.next;
                        oddPointer.next = currNode;
                        oddPointer = oddPointer.next;
                        oddPointer.next=temp;

                        currNode=currNode.next;

                        if(oddPointer.next != null && oddPointer.next!=evenPointer)
                            oddPointer.next = evenPointer;
                    }
                    //currNode=currNode.next;
                }
            } else {
                if (evenPointer == null) {
                    evenPointer = currNode;
                    currNode=currNode.next;
                }
                else {
                    if (oddPointer == null) {
                        evenPointer.next = currNode;
                        evenPointer = evenPointer.next;
                        currNode=currNode.next;
                    } else {
//                        currNode=currNode.next;

                        if(oddPointer.next.data%2!=0)
                            oddPointer.next = evenPointer;

                        evenPointer.next = currNode;
                        evenPointer = evenPointer.next;
                        currNode=currNode.next;
                    }
                }
//                currNode=evenPointer;
//                currNode = currNode.next;
            }

            //currNode = currNode.next;
        }

        /////finally summing up the odd & even nodes
        return head;
    }

}