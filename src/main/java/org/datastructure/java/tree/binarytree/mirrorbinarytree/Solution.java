package org.datastructure.java.tree.binarytree.mirrorbinarytree;

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

    public static void mirrorBinaryTree(BinaryTreeNode<Integer> root){
        //Your code goes here
        if(root==null)
            return;
        BinaryTreeNode<Integer> tmp = root.left;
        root.left=root.right;
        root.right=tmp;

        mirrorBinaryTree(root.left);
        mirrorBinaryTree(root.right);
    }

}