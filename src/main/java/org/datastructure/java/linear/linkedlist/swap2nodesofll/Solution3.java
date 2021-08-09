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
/////////////NOTE: THIS SWAPPING CODE IS ITERATIVE. THIS IS OPTIMAL SOLUTION
public class Solution3 {

    static LinkedListNode<Integer> markFirstNode = null;
    static int markIndexFirstNode = -1;

    public static LinkedListNode<Integer> swapNodes(LinkedListNode<Integer> head, int i, int j) {
        //Your code goes here
        if (head == null)
            return head;

        if (i > j) {
            int tmp = i;
            i = j;
            j = tmp;
        } else if (i - j == 0) {
            ///do nothing just return
            return head;
        }

        int indexLL = 0;
        LinkedListNode<Integer> sHead=head;
        LinkedListNode<Integer> currNode=head;
        while (head != null) {
            if (head == null)
                break;

            if (i == indexLL) {
                markFirstNode = head;
                markIndexFirstNode = i;
            }
            else if (indexLL == j) {
                //////initiate swapping of nodes.
                int tmp = markFirstNode.data;
                markFirstNode.data = head.data;
                head.data = tmp;
                break;
            }

            head=head.next;
            indexLL++;
        }

        return sHead;
    }
}