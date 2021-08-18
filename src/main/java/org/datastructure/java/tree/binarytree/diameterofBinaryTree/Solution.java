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

    static int diam = 0;

    public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root) {
        //Your code goes here
        int temp = calculateDiameter(root);
        return temp;
    }

    static int calculateDiameter(BinaryTreeNode<Integer> root) {
        if (root == null)
            return 0;

        int leftNodeDiam = calculateDiameter(root.left);
        if (diam != 0)
            diam -= 1;
        int rightNodeDiam = calculateDiameter(root.right);
        diam += 1;
        return diam;

    }

}