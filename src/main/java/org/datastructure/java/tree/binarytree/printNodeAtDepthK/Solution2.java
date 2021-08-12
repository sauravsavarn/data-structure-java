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
//////Solution2 is just the smallest and another version of Solution1
public class Solution2 {

    public static void printNodeAtDepthK(BinaryTreeNode<Integer> root, int depth) {
        //Your code goes here
        if(root==null)
            return;

        if(depth==0) {
            System.out.print(root.data + " " );
            return;
        }

        printNodeAtDepthK(root.left, depth-1);
        printNodeAtDepthK(root.right, depth-1);
    }
}