package org.datastructure.java.testrounds.deleteAlternateNode;

/*

    Following is the class used to represent the Node of a Singly Linked List

    class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T data) {
            this.setData(data);
            this.next = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

    }
*/

public class Solution {

    public static void deleteAlternateNodes(Node<Integer> head) {
        //Your code goes here
        if (head == null)
            return;

        Node<Integer> prev = head;
        Node<Integer> now = head.next;

        while (prev != null && now != null) {
            /* Change next link of previous node */
            prev.next = now.next;
            /* Free node */
            now = null;
            /*Update prev and now */
            prev = prev.next;
            if (prev != null)
                now = prev.next;
        }
    }
}