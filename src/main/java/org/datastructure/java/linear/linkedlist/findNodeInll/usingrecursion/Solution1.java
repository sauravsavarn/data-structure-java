package org.datastructure.java.linear.linkedlist.findNodeInll.usingrecursion;

public class Solution1 {
    static int indexInLL=0;
    public static int findNodeRec(LinkedListNode<Integer> head, int n) {
        if(head==null)
            return -1;

        return findNodeRec(head, n, indexInLL);

    }

    public static int findNodeRec(LinkedListNode<Integer> head, int n, int pos) {
        if(head==null)
            return -1;

        if(head.data == n)
            return pos;

        return findNodeRec(head.next, n, ++pos);
    }

}
