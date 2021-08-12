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
///////In Solution2 this is returning int to the caller.
public class Solution2 {

    public static int printNodeWithLargestData(BinaryTreeNode<Integer> root) {
        //Your code goes here
        if (root == null)
            return -1; ///as if root==null, then the largest should be -1, with assumption that nothing is smaller than -1 everything is more than -1 i.e 0 or more.

        int largestLeft=printNodeWithLargestData(root.left);
        int largestRight=printNodeWithLargestData(root.right);

        /////////now finally largest will be eithe of the 3 nodes i.e. largestLeft or largestRight or the root itself.
        int largestOfAllNodes=Math.max(root.data, Math.max(largestLeft, largestRight));
        return largestOfAllNodes;
    }
}