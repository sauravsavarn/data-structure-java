package org.datastructure.java.tree.binarytree.removeleafnodes;

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
public class Solution1 {

    public static BinaryTreeNode<Integer> removeLeafNodes(BinaryTreeNode<Integer> root) {
        //Your code goes here
        if(root==null)
            return null;
        if(root.left==null && root.right==null)
            return null;

        root.left =removeLeafNodes(root.left);
        root.right =removeLeafNodes(root.right);

        return root;
    }
}