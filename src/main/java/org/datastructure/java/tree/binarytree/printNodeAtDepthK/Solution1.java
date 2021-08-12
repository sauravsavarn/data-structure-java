package org.datastructure.java.tree.binarytree.printNodeAtDepthK;

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

public class Solution1 {

    public static void printNodeAtDepthK(BinaryTreeNode<Integer> root, int depth) {
        //Your code goes here
        if(root==null)
            return;

        replaceWithDepth(root, 0, depth);
    }

    private static void replaceWithDepth(BinaryTreeNode<Integer> root, int currentDepth, int depth) {
        if(root==null)
            return;

        replaceWithDepth(root.left, currentDepth+1, depth);
        if(currentDepth==depth)
            System.out.print(root.data + " " );
        replaceWithDepth(root.right, currentDepth+1, depth);
    }

}