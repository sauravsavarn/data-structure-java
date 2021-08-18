package org.datastructure.java.tree.binarytree.heightoftree;

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

public class Solution2 {
    static int maxHeightOfTree=0;
    public static int height(BinaryTreeNode<Integer> root) {
        //Your code goes here
        int maxHeightOfTree=calculateHeight(root);
        return maxHeightOfTree;
    }

    private static int calculateHeight(BinaryTreeNode<Integer> root) {
        if(root==null)
            return 0;

        int leftHeight=calculateHeight(root.left);
        int rightHeight=calculateHeight(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}