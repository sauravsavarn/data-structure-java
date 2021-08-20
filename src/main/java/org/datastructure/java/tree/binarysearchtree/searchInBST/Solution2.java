package org.datastructure.java.tree.binarysearchtree.searchInBST;

/////Solution2 is very similar to Solution1 excpet the last else if statement which seems not required.
public class Solution2 {

    /*
     * Binary Tree Node class
     *
     * class BinaryTreeNode<T> { T data; BinaryTreeNode<T> left; BinaryTreeNode<T> right;
     *
     * public BinaryTreeNode(T data) { this.data = data; } }
     */


    public static boolean searchInBST(BinaryTreeNode<Integer> root, int k) {
        if (root == null)
            return false;
        if (root.data == k)
            return true;

        if (root.data > k)
            return searchInBST(root.left, k);
        return searchInBST(root.right, k);
    }
}
