package org.datastructure.java.tree.binarytree.replacenodewithdepth;

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

    public static void changeToDepthTree(BinaryTreeNode<Integer> root) {
        //Your code goes here
        if(root==null)
            return;

        replaceWithDepth(root, 0);
    }

    private static void replaceWithDepth(BinaryTreeNode<Integer> root, int depth) {
        if(root==null)
            return;

        replaceWithDepth(root.left, depth+1);
        root.data=depth;
        //System.out.print(depth + " " );
        replaceWithDepth(root.right, depth+1);
    }

}