package org.datastructure.java.tree.binarysearchtree.pairSumInABST;

import java.util.HashSet;

/////This is hashing based solution. We traverse binary search tree by
//               inorder way and insert node’s value into a set. Also, check for any node,
//               difference between given sum and node’s value in set, if it is found
//               then pair exists otherwise it doesn’t exist.
public class Solution2 {
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

    static HashSet<Integer> set = new HashSet<Integer>();

    public static void printNodesSumToS(BinaryTreeNode<Integer> root, int s) {
        if (root == null)
            return;

        printNodesSumToS(root.left, s);

        if (set.contains(s - root.data)) {
            System.out.println((s - root.data) + " " + root.data);
        } else
            set.add(root.data);

        printNodesSumToS(root.right, s);
    }

}