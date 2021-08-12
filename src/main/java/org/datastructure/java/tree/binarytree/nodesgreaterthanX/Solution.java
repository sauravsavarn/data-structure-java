package org.datastructure.java.tree.binarytree.nodesgreaterthanX;

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

    static int totalNodesGtX=0;
    public static int countNodesGreaterThanX(BinaryTreeNode<Integer> root, int x) {
        //Your code goes here
        return checkCountRecursively(root, x);
    }

    private static int checkCountRecursively(BinaryTreeNode<Integer> currNode, int x) {
        if (currNode.left == null && currNode.right == null) {
            if(x<currNode.data)
                totalNodesGtX+=1;
            return totalNodesGtX;
        }

        if(currNode.left!=null)
            checkCountRecursively(currNode.left, x);
        if(currNode.right!=null)
            checkCountRecursively(currNode.right, x);

        if(x<currNode.data)
            totalNodesGtX+=1;
        return totalNodesGtX;
    }

}