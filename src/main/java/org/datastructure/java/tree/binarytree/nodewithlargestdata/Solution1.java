package org.datastructure.java.tree.binarytree.nodewithlargestdata;

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
///////In Solution1 there is nothing returning to the caller.
public class Solution1 {

    static int largetNodeData = 0;

    public static void printNodeWithLargestData(BinaryTreeNode<Integer> root) {
        //Your code goes here
        System.out.print(returnNodeWithLargestData(root) + " ");
    }

    private static int returnNodeWithLargestData(BinaryTreeNode<Integer> root) {
        if (root == null)
            return -1; ///as if root==null, then the largest should be -1, with assumption that nothing is smaller than -1 everything is more than -1 i.e 0 or more.

        if (root.data > largetNodeData) //as largest can be on Left Side or the Right Side or the subsequent root.
            largetNodeData = root.data;

        returnNodeWithLargestData(root.left);
        returnNodeWithLargestData(root.right);
        return largetNodeData;
    }
}