package org.datastructure.java.tree.binarytree.diameterofBinaryTree;

/*

	Following is the structure used to represent the Binary Tree Node

	class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

*/

public class Solution {

    static int diam = Integer.MIN_VALUE;

    public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root) {
        //Your code goes here
        int height_of_tree = height(root);
        return diam;
    }

    /* Function to find height of a tree */
    static int height(BinaryTreeNode<Integer> root)
    {
        if (root == null)
            return 0;

        int left_height = height(root.left);

        int right_height = height(root.right);

        // update the answer, because diameter of a
        // tree is nothing but maximum value of
        // (left_height + right_height + 1) for each node
        diam = Math.max(diam, 1 + left_height + right_height);

        return 1 + Math.max(left_height, right_height);
    }
}