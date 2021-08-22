package org.datastructure.java.tree.binarysearchtree.largestBST;

public class Solution {
    /*
     * BinaryTreeNode class
     *
     * class BinaryTreeNode<T>
     * {
     * 		T data;
     * 		BinaryTreeNode<T> left;
     * 		BinaryTreeNode<T> right;
     *		public BinaryTreeNode(T data)
     *		{
     *  		this.data = data;
     *  	}
     *  }
     */

    // Recursive function to find the size of the largest BST in a given binary tree
    public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
        if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            int siz = size(root);
            return siz;
        }

        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }

    // Recursive function to calculate the size of a given binary tree
    public static int size(BinaryTreeNode<Integer> root)
    {
        // base case: empty tree has size 0
        if (root == null) {
            return 0;
        }

        // recursively calculate the size of the left and right subtrees and
        // return the sum of their sizes + 1 (for root node)
        //return size(root.left) + 1 + size(root.right);
        int leftSize = 1+size(root.left);
        int rightSize= 1+size(root.right);
        int maxSize = Math.max(leftSize, rightSize);
        return maxSize;
    }

    // Recursive function to determine if a given binary tree is a BST or not
    // by keeping a valid range (starting from [-INFINITY, INFINITY]) and
    // keep shrinking it down for each node as we go down recursively
    public static boolean isBST(BinaryTreeNode<Integer> node, int min, int max)
    {
        // base case
        if (node == null) {
            return true;
        }

        // if the node's value falls outside the valid range
        if (node.data < min || node.data > max) {
            return false;
        }

        // recursively check left and right subtrees with updated range
        return isBST(node.left, min, node.data) &&
                isBST(node.right, node.data, max);
    }

}