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
////////////Solution2 is the Optimal Solution. Solution1 has errors and needs to re-work
public class Solution2 {

    public static LinkedListNode<Integer> mergeSort(LinkedListNode<Integer> head) {
        if (head==null || head.next == null)
            return head;

        LinkedListNode<Integer> mid = findMid(head);
        LinkedListNode<Integer> head2 = mid.next;
        mid.next = null;
        LinkedListNode<Integer> newHead1 = mergeSort(head);
        LinkedListNode<Integer> newHead2 = mergeSort(head2);
        LinkedListNode<Integer> finalHead = merge(newHead1, newHead2);

        return finalHead;
    }

    static LinkedListNode<Integer> merge(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
        LinkedListNode<Integer> merged = new LinkedListNode<Integer>(-1);
        LinkedListNode<Integer> temp = merged;

        // While head1 is not null and head2
        // is not null
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        // While head1 is not null
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        // While head2 is not null
        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return merged.next;
    }

    // Find mid using The Tortoise and The Hare approach
    static LinkedListNode<Integer> findMid(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}