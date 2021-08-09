package org.datastructure.java.linear.linkedlist.swap2nodesofll;

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
/////////////NOTE: THIS SWAPPING CODE IS RECURSIVE
public class Solution1 {

    static int markDataFirstNode=-1;
    static int markDataSecondNode=-1;
    public static LinkedListNode<Integer> swapNodes(LinkedListNode<Integer> head, int i, int j) {
        //Your code goes here
        if(head==null)
            return head;

        if(i>j) {
            int tmp = i;
            i=j;
            j=tmp;
        } else if(i-j==0) {
            ///do nothing just return
            return head;
        }


        return swapNodes(head, i, j , 0);

    }

    public static LinkedListNode<Integer> swapNodes(LinkedListNode<Integer> head, int i, int j, int indexLL) {
        //Your code goes here
        if(head==null)
            return head;

        if(i==indexLL) {
            markDataFirstNode=head.data;
        } else if(indexLL==j) {
            //////initiate swapping of nodes.
            markDataSecondNode = head.data;
            head.data= markDataFirstNode;
            return head;
        }

        LinkedListNode<Integer> interim = swapNodes(head.next, i, j, ++indexLL);
        if(i==indexLL)
            head.next.data=markDataSecondNode;
        head.next=interim;
        return head;

    }
}