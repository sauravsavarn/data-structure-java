package org.datastructure.java.tree.binarysearchtree.bstToLL;

public class Solution {

    /*
     * Binary Tree Node class
     *
     * class BinaryTreeNode<T> { T data; BinaryTreeNode<T> left; BinaryTreeNode<T>
     * right;
     *
     * public BinaryTreeNode(T data) { this.data = data; } }
     */

    /*
     * LinkedList Node Class
     *
     *
     * class LinkedListNode<T> { T data; LinkedListNode<T> next;
     *
     * public LinkedListNode(T data) { this.data = data; } }
     */

    static LinkedListNode<Integer> ll=null;
    static LinkedListNode<Integer> llTail=null;
    public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
        if(root==null)
            return null;

        constructLinkedList(root.left);
        if(ll==null) {
            ll = new LinkedListNode<>(root.data);
            llTail = ll;
        }
        else {
            llTail.next = new LinkedListNode<>(root.data);
            llTail=llTail.next;
        }
        constructLinkedList(root.right);

        return ll;
    }
}
