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

public class Solution {
    static int maxHeightOfTree=0;
    public static int height(BinaryTreeNode<Integer> root) {
        //Your code goes here
        int maxHeightOfTree=calculateHeight(root, 1);
        return maxHeightOfTree;
    }

    private static int calculateHeight(BinaryTreeNode<Integer> root, int height) {
        if(root==null)
            return 0;

        calculateHeight(root.left, height+1);
        calculateHeight(root.right, height+1);

        if(maxHeightOfTree<height+1){
            maxHeightOfTree=height;
        }
        return maxHeightOfTree;
    }
}